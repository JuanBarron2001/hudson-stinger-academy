package lessonRunner;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

public abstract class BaseLesson {

    private final String logFileName;
    private final PrintStream originalOut;
    private FileOutputStream fileOutStream;
    private PrintStream loggerStream;
    private final int HYPHEN_SEPARATOR_LENGTH = 80;

    protected BaseLesson() {
        String className = getClass().getPackageName();
        logFileName = String.format("%s-output.log", className);
        originalOut = System.out;

        try
        {
            Path logFile = Paths.get(logFileName);
            boolean fileExists = Files.exists(logFile);

            fileOutStream = new FileOutputStream(logFile.toFile(), true);

            if (fileExists)
            {
                String separator = "-".repeat(HYPHEN_SEPARATOR_LENGTH) + System.lineSeparator();
                fileOutStream.write(separator.getBytes(StandardCharsets.UTF_8));
                fileOutStream.flush();
            }

        loggerStream = new LessonLogger(System.out, fileOutStream);
        }
        catch (Exception e)
        {
            e.printStackTrace(originalOut);
        }
    }

    public void turnOffLogging()
    {
        System.setOut(originalOut);
    }

    public void turnOnLogging()
    {
        if (loggerStream != null)
        {
            System.setOut(loggerStream);
        }
    }

    public void closeLogger()
    {
        if (fileOutStream != null)
        {
            try
            {
                fileOutStream.close();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
    }

}
