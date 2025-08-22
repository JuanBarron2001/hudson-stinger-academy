package frc.lesson;

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

    // Logging rate control
    private static final int MOD = 47;
    private static final int RESET_MOD_COUNT_MAX = 137;
    private int modCounter = 0;
    private int modResetCount = 0;

    protected LessonBase() {
        logOut = createLogFile();
    }

    private PrintStream createLogFile() {
        try {
            String pkg = getClass().getPackageName().replace('.', '_');
            String ts = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            String logFileName = pkg + "_" + ts + ".log";

            Path logFile = Path.of(logFileName);
            if (!Files.exists(logFile)) {
                Files.createFile(logFile);
            }

            PrintStream ps = new PrintStream(new FileOutputStream(logFile.toFile(), true), true);
            ps.printf("=== Logging started for %s at %s ===%n", pkg, ts);
            return ps;
        } catch (IOException e) {
            return null;
        }
    }

    public void logSmartDashboardChanges() {
        if (logOut == null) return;

        modCounter = (modCounter + 1) % MOD;
        if (modCounter != 0) return;

        modResetCount++;
        if (modResetCount >= RESET_MOD_COUNT_MAX) return;

        for (String key : SmartDashboard.getKeys()) {
            try {
                Object current = getSmartDashboardValue(key);
                if (current == null) continue;

                Object previous = previousValues.get(key);
                if (previous == null || !previous.equals(current)) {
                    String ts = LocalDateTime.now()
                            .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
                    logOut.printf("[%s] %s: %s -> %s%n", ts, key, previous, current);
                    previousValues.put(key, current);
                }
            } catch (IllegalArgumentException ignored) {
                
            }
        }
    }

    private Object getSmartDashboardValue(String key) {
        String strVal = SmartDashboard.getString(key, null);
        if (strVal != null) return strVal;

        double numVal = SmartDashboard.getNumber(key, Double.NaN);
        if (!Double.isNaN(numVal)) return numVal;

        if (SmartDashboard.containsKey(key)) {
            return SmartDashboard.getBoolean(key, false);
        }

        return null;
    }

    public void setup() {
        
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
