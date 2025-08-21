package frc.lesson;

import edu.wpi.first.util.sendable.Sendable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class LessonBase {

    private final Map<String, Object> previousValues = new HashMap<>();
    private final PrintStream logOut;

    protected LessonBase() {
        PrintStream tmp = null;
        try {
            // packageName_timestamp.log
            String pkg = getClass().getPackageName().replace('.', '_');
            String ts  = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            String logFileName = pkg + "_" + ts + ".log";

            Path logFile = Path.of(logFileName);
            if (!Files.exists(logFile)) {
                Files.createFile(logFile);
            }

            tmp = new PrintStream(new FileOutputStream(logFile.toFile(), true), true);
            tmp.println("=== Logging started for " + pkg + " at " + ts + " ===");
        } catch (IOException e) {
            // If logging fails, tmp will remain null and logging will be inert
        }
        logOut = tmp;
    }

    /**
     * Logs only SmartDashboard values that have changed
     * since the previous check.
     */
    public void logSmartDashboardChanges() {
        if (logOut == null) return; // no file open

        Set<String> keys = SmartDashboard.getKeys();
        for (String key : keys) {
            try
            {
                Sendable current = SmartDashboard.getData(key);
                Object previous = previousValues.get(key);
                if (previous == null || !previous.equals(current)) {
                    logOut.println("[" + LocalDateTime.now() + "] " + key + " changed to: " + current);
                    previousValues.put(key, current);
                }
            } catch(IllegalArgumentException IAE)
            {
                // Do nothing and wait i guess
            }
        }
    }

    public void setup() {
        // optional override by subclasses
    }

    public abstract void execute();

    public void cleanup() {
        if (logOut != null) {
            logOut.println("=== Lesson ended ===");
            logOut.flush();
            logOut.close();
        }
    }
}
