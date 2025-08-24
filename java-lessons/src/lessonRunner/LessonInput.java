package lessonRunner;

import java.io.InputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.Queue;

public class LessonInput extends InputStream {

    private final Queue<String> allAnswers = new LinkedList<>();
    private final Queue<Byte> currentBytes = new LinkedList<>();
    private boolean hasLoadedData = false;

    private final int SIMULATED_TYPING_SPEED_MS = 30;
    private final int SIMULATED_READING_SPEED_MS = 350;

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

    private void timeDelay(int ms)
    {
        try
        {
            Thread.sleep(30);
        }
        catch (InterruptedException ignored)
        {
            Thread.currentThread().interrupt();
        }
    }
}
