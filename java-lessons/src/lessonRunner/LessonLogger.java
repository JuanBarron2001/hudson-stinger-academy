package lessonRunner;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LessonLogger extends PrintStream
{
    private final PrintStream consoleOut;
    private String lastLogLine = "4X#f9qdkEkzHEGGK";
    private final DateTimeFormatter TS_FORMAT = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");

    public LessonLogger(PrintStream consoleOut, FileOutputStream fileOut) throws UnsupportedEncodingException
    {
        super(fileOut, true, StandardCharsets.UTF_8.name());
        this.consoleOut = consoleOut;
    }

    private void log(String function, String type, String value)
    {
        if (value == null) value = "null";

        if ("println".equals(function))
        {
            this.consoleOut.println(value);
        }
        else
        {
            this.consoleOut.print(value);
        }

        String prevHash = this.hash(this.lastLogLine);
        String logLine = String.join("|",LocalDateTime.now().format(this.TS_FORMAT),function,type,value,prevHash);
        lastLogLine = logLine;

        super.print(logLine + System.lineSeparator());
    }

    private String hash(String input) {
        try
        {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(input.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder(digest.length * 2);
            for (byte b : digest)
            {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        }
        catch (NoSuchAlgorithmException NSAException)
        {
            return String.format("COULD_NOT_HASH(%s)" , NSAException.getMessage());
        }
    }

    // ===== String variants =====
    @Override public void print(String x)   { log("print",   "String", x); }
    @Override public void println(String x) { log("println", "String", x); }

    // ===== No-arg println =====
    @Override public void println() { log("println", "void", ""); }

    // ===== boolean =====
    @Override public void print(boolean b)   { log("print",   "boolean", String.valueOf(b)); }
    @Override public void println(boolean b) { log("println", "boolean", String.valueOf(b)); }

    // ===== char =====
    @Override public void print(char c)   { log("print",   "char", String.valueOf(c)); }
    @Override public void println(char c) { log("println", "char", String.valueOf(c)); }

    // ===== int =====
    @Override public void print(int i)   { log("print",   "int", String.valueOf(i)); }
    @Override public void println(int i) { log("println", "int", String.valueOf(i)); }

    // ===== long =====
    @Override public void print(long l)   { log("print",   "long", String.valueOf(l)); }
    @Override public void println(long l) { log("println", "long", String.valueOf(l)); }

    // ===== float =====
    @Override public void print(float f)   { log("print",   "float", String.valueOf(f)); }
    @Override public void println(float f) { log("println", "float", String.valueOf(f)); }

    // ===== double =====
    @Override public void print(double d)   { log("print",   "double", String.valueOf(d)); }
    @Override public void println(double d) { log("println", "double", String.valueOf(d)); }

    // ===== char[] =====
    @Override public void print(char[] s)   { log("print",   "char[]", new String(s)); }
    @Override public void println(char[] s) { log("println", "char[]", new String(s)); }

    // ===== Object =====
    @Override public void print(Object obj) {
        log("print", obj == null ? "null" : obj.getClass().getSimpleName(), String.valueOf(obj));
    }
    @Override public void println(Object obj) {
        log("println", obj == null ? "null" : obj.getClass().getSimpleName(), String.valueOf(obj));
    }
}
