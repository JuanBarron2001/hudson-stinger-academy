package frc.lesson;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public abstract class LessonBase {

    private final Map<String, Object> previousValues = new HashMap<>();
    private LessonLogger lessonLogger;
    private FileOutputStream fileOutStream;

    // Logging rate control
    private static final int MOD = 47;
    private static final int RESET_MOD_COUNT_MAX = 137;
    private int modCounter = 0;
    private int modResetCount = 0;

    private static final int HYPHEN_SEPARATOR_LENGTH = 80;

    protected LessonBase() {
        initLogger();
    }

    private void initLogger() {
        try {
            String pkgName = getClass().getPackageName();
            String logFileName = String.format("%s-output.log", pkgName);

            Path logFile = Paths.get(logFileName);
            boolean fileExists = Files.exists(logFile);

            fileOutStream = new FileOutputStream(logFile.toFile(), true);

            if (fileExists) {
                String separator = "-".repeat(HYPHEN_SEPARATOR_LENGTH) + System.lineSeparator();
                fileOutStream.write(separator.getBytes(StandardCharsets.UTF_8));
                fileOutStream.flush();
            }

            lessonLogger = new LessonLogger(fileOutStream);

        } catch (IOException e) {
            e.printStackTrace();
            lessonLogger = null;
        }
    }

    public void logSmartDashboardChanges() {
        if (lessonLogger == null) return;

        // Rate limiting
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
                    lessonLogger.log(key, current.getClass().getSimpleName(), current.toString());
                    previousValues.put(key, current);
                }
            } catch (IllegalArgumentException e) {
                
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

    public void setup() {}

    public abstract void execute();

    public void cleanup() {
        if (fileOutStream != null) {
            try {
                fileOutStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
