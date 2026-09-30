package frc.lesson;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Deliberately a separate copy of java-lessons' lessonRunner.LessonLogger, not a shared class.
 * java-lessons has no build file, so this Gradle project can't depend on it, and the two do
 * different jobs: this one records SmartDashboard changes and prints nothing, that one captures a
 * student's prints and echoes them to the console. What they must share is the line format and
 * the seed, so one checker (MENTOR-GUIDE section 5) verifies both logs. Change either of those
 * here and change them there too.
 */
public class LessonLogger extends PrintStream {

    private String lastLogLine = "4X#f9qdkEkzHEGGK";
    private static final DateTimeFormatter TS_FORMAT =
            DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");

    public LessonLogger(FileOutputStream fileOut) throws UnsupportedEncodingException {
        super(fileOut, true, StandardCharsets.UTF_8.name());
    }

    public void log(String key, String type, String value) {
        if (value == null) value = "null";

        String prevHash = hash(lastLogLine);
        String logLine = String.join("|",
                LocalDateTime.now().format(TS_FORMAT),
                key,
                type,
                value,
                prevHash
        );

        lastLogLine = logLine;
        super.print(logLine + System.lineSeparator());
    }

    private String hash(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(input.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder(digest.length * 2);
            for (byte b : digest) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            return "COULD_NOT_HASH(" + e.getMessage() + ")";
        }
    }
}
