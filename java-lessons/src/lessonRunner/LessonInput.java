package lessonRunner;

import java.io.InputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Types scripted answers into a lesson, as if a person were at the keyboard.
 *
 * <p>The answers come from a file, one answer per line: {@code resources/lesson03.basic.txt}
 * for lesson 03's basic half. Each answer is echoed as it's "typed", so it shows up in the
 * console and in the lesson's log, right after the question it answers.
 */
public class LessonInput extends InputStream {

    private final Queue<String> allAnswers = new LinkedList<>();
    private final Queue<Byte> currentBytes = new LinkedList<>();
    private final String sourceName;
    private boolean hasLoadedData = false;
    private boolean saidItRanOut = false;

    private final int SIMULATED_TYPING_SPEED_MS = 30;
    private final int SIMULATED_READING_SPEED_MS = 350;

    public LessonInput(String sourceName)
    {
        this.sourceName = sourceName;
    }

    /** Every line of the file becomes one answer. Blank lines are answers too: an empty Enter. */
    public static LessonInput fromFile(Path answersFile) throws IOException
    {
        LessonInput lessonInput = new LessonInput(answersFile.toString());
        for (String line : Files.readAllLines(answersFile, StandardCharsets.UTF_8))
        {
            lessonInput.addScriptedLine(line);
        }
        return lessonInput;
    }

    public void addScriptedLine(String line)
    {
        this.allAnswers.add(line + System.lineSeparator());
    }

    public void clearScriptedInputs()
    {
        this.allAnswers.clear();
        this.currentBytes.clear();
    }

    private void loadNextAnswer()
    {
        if (!allAnswers.isEmpty())
        {
            byte[] bytes = this.allAnswers.poll().getBytes(StandardCharsets.UTF_8);
            this.currentBytes.clear();
            for (byte b : bytes)
            {
                this.currentBytes.add(b);
            }
        }
    }

    @Override
    public int read() throws IOException
    {
        if (this.currentBytes.isEmpty())
        {
            if (!this.hasLoadedData)
            {
                this.loadNextAnswer();
                if (this.currentBytes.isEmpty())
                {
                    this.sayItRanOut();
                    return -1;
                }
                this.timeDelay(this.SIMULATED_READING_SPEED_MS);
            } else
            {
                this.hasLoadedData = false;
                return -1;
            }
        }
        this.hasLoadedData = true;

        this.timeDelay(this.SIMULATED_TYPING_SPEED_MS);

        int b = currentBytes.poll() & 0xFF;

        System.out.print((char) b);
        System.out.flush();

        return b;
    }

    /** The lesson asked for more answers than the file has. Say which file, once. */
    private void sayItRanOut()
    {
        if (this.saidItRanOut) return;
        this.saidItRanOut = true;
        System.out.println();
        System.out.println("⚠️  The lesson asked for another answer, but " + this.sourceName
                + " has no more lines. Either the lesson asks one question too many, or the"
                + " file needs another line.");
    }

    private void timeDelay(int ms)
    {
        try
        {
            Thread.sleep(ms);
        }
        catch (InterruptedException ignored)
        {
            Thread.currentThread().interrupt();
        }
    }
}
