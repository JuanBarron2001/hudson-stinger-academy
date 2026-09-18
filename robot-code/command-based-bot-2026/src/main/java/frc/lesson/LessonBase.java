package frc.lesson;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * Every robot lesson extends this class. Put your one-time code in {@link #setup()} and your
 * every-loop code in {@link #execute()}.
 *
 * <p>While the lesson runs, this class watches SmartDashboard and writes every value that changes
 * into a hash-chained log file, which is what you turn in.
 */
public abstract class LessonBase {

  /** Check SmartDashboard every 5 loops, which is 10 times a second. */
  private static final int LOOPS_PER_SAMPLE = 5;

  /**
   * Stop logging after this many lines, and say so in the log. This keeps a lesson log small enough
   * to read, without silently giving up two minutes in.
   */
  private static final int MAX_LOG_LINES = 10_000;

  private static final int HYPHEN_SEPARATOR_LENGTH = 80;

  /** SmartDashboard keys published by the simulator itself start with this. */
  private static final String SIM_KEY_PREFIX = "Sim ";

  private final Map<String, Object> previousValues = new HashMap<>();
  private LessonLogger lessonLogger;
  private FileOutputStream fileOutStream;
  private int loopCounter = 0;
  private int linesLogged = 0;
  private boolean halted = false;
  private int quietLoops = 0;
  private boolean saidItIsQuiet = false;

  protected LessonBase() {
    initLogger();
  }

  /** Runs once, when the robot program starts. Create motors and controllers here. */
  public void setup() {}

  /** Runs about fifty times a second while the robot is in Teleoperated. */
  public abstract void execute();

  /**
   * Runs one loop of the lesson: {@link #execute()}, then logging.
   *
   * <p>If {@code execute()} throws, the error is printed and logged once and the lesson stops
   * running, instead of printing the same error fifty times a second.
   */
  public final void runOneLoop() {
    if (halted) return;
    try {
      execute();
    } catch (RuntimeException e) {
      halted = true;
      System.out.println(
          "Your lesson threw an error, so it has been stopped. Read the error below: the first"
              + " line that mentions frc.lesson is usually where the problem is.");
      e.printStackTrace();
      logStackTrace(e);
      return;
    }
    logSmartDashboardChanges();
    nagIfNothingIsHappening();
  }

  /**
   * A stub with no code in it publishes nothing, which looks exactly like a broken simulator. After
   * about five seconds of silence, say so once.
   */
  private void nagIfNothingIsHappening() {
    if (saidItIsQuiet || linesLogged > 0) return;
    if (++quietLoops < 250) return;
    saidItIsQuiet = true;
    System.out.println(
        "Lesson "
            + getClass().getPackageName()
            + " is running, but it hasn't put anything on SmartDashboard yet. If its file is still"
            + " empty, that's expected: open it and work through the TASK list at the top.");
  }

  private void initLogger() {
    try {
      String pkgName = getClass().getPackageName();
      Path logFile = Paths.get(String.format("%s-output.log", pkgName));
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

    loopCounter = (loopCounter + 1) % LOOPS_PER_SAMPLE;
    if (loopCounter != 0) return;

    for (String key : SmartDashboard.getKeys()) {
      // The simulator's own values aren't your work, so they stay out of your log.
      if (key.startsWith(SIM_KEY_PREFIX)) continue;

      Object current = getSmartDashboardValue(key);
      if (current == null) continue;

      Object previous = previousValues.get(key);
      if (previous == null || !previous.equals(current)) {
        if (!logLine(key, current.getClass().getSimpleName(), current.toString())) return;
        previousValues.put(key, current);
      }
    }
  }

  /** Writes one line, unless the log is full. Returns false once the log is full. */
  private boolean logLine(String key, String type, String value) {
    if (linesLogged >= MAX_LOG_LINES) return false;
    linesLogged++;
    if (linesLogged == MAX_LOG_LINES) {
      lessonLogger.log("lesson", "String", "Log is full at " + MAX_LOG_LINES + " lines; stopping.");
      return false;
    }
    lessonLogger.log(key, type, value);
    return true;
  }

  private void logStackTrace(Exception e) {
    if (lessonLogger == null) return;
    StringWriter trace = new StringWriter();
    e.printStackTrace(new PrintWriter(trace));
    lessonLogger.log("lesson", "Exception", trace.toString().replace(System.lineSeparator(), " / "));
  }

  private Object getSmartDashboardValue(String key) {
    try {
      String strVal = SmartDashboard.getString(key, null);
      if (strVal != null) return strVal;

      double numVal = SmartDashboard.getNumber(key, Double.NaN);
      if (!Double.isNaN(numVal)) return numVal;

      if (SmartDashboard.containsKey(key)) {
        return SmartDashboard.getBoolean(key, false);
      }
    } catch (IllegalArgumentException e) {
      // Values of other types (arrays, raw data) aren't logged.
    }
    return null;
  }

  /** Closes the log file. Called automatically when the robot program exits. */
  public void cleanup() {
    if (fileOutStream != null) {
      try {
        fileOutStream.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
      fileOutStream = null;
    }
  }
}
