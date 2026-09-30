package lessonRunner;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LessonRunner {

    /**
     * The real keyboard, except that closing it does nothing. Lessons are taught to close their
     * Scanner, and closing a Scanner closes System.in with it, which would leave the extra half
     * with no keyboard at all.
     */
    private static final InputStream KEYBOARD = new FilterInputStream(System.in) {
        @Override
        public void close() {}
    };

    public static void main(String[] args) {
        printOutBanner();

        try {
            System.out.print("Enter lesson number (two digits, e.g. 01): ");
            String lessonNum = readLine(KEYBOARD).trim();

            if (!lessonNum.matches("\\d{2}")) {
                System.err.println("❌ Invalid lesson number format. Use exactly two digits like '01'.");
                return;
            }

            // System.out.print("Enter program/class to run (e.g. Main): ");
            // String className = scanner.nextLine().trim();
            // if (className.isBlank()) {
            //     System.err.println("❌ No class name entered.");
            //     scanner.close();
            //     return;
            // }
            String className = "Main"; // assuming Main for now for everything

            useAnswersFor(lessonNum + ".basic");
            runProgram(lessonNum+".basic", className);
            System.out.println("-----------------------------------------------");
            useAnswersFor(lessonNum + ".extra");
            runProgram(lessonNum+".extra", className);

        } catch (ClassNotFoundException e) {
            System.err.println("❌ No such class found. Check the lesson number or program name.");
        } catch (NoSuchMethodException e) {
            System.err.println("❌ Missing required method: public static void main(String[] args).");
        } catch (ClassCastException e) {
            System.err.println("❌ Your Main class has to say \"extends BaseLesson\", or nothing gets logged.");
        } catch (LessonCrashed e) {
            System.out.println("❌ Something happened — it might be this program or your program.\n"
                             + "   Reach out to your Programming Mentor or Head Programmer Student,\n"
                             + "   and send them " + e.getMessage() + ". The details are at the bottom.");
        } catch (Exception e) {
            System.out.println("❌ Something happened — it might be this program or your program.\n"
                             + "   Reach out to your Programming Mentor or Head Programmer Student.");
            // Not the lesson's fault, so there's no lesson log to put this in. The mentor needs it.
            e.printStackTrace();
        }
    }

    /** The lesson's own code threw. Its stack trace is already in the log file this names. */
    private static class LessonCrashed extends Exception {
        LessonCrashed(String logFileName) {
            super(logFileName);
        }
    }

    /**
     * If resources/lessonNN.half.txt exists, the lesson's questions are answered from it, one line
     * per answer. Otherwise the lesson reads the real keyboard.
     */
    private static void useAnswersFor(String lessonHalf) throws IOException
    {
        Path answers = Paths.get("resources", "lesson" + lessonHalf + ".txt");
        if (Files.exists(answers)) {
            System.out.println("\n⌨️  Answering this lesson's questions from " + answers);
            System.setIn(LessonInput.fromFile(answers));
        } else {
            System.setIn(KEYBOARD);
        }
    }

    /**
     * Reads one line, one byte at a time. A Scanner would read ahead and keep typed-ahead input
     * for itself, where the lesson's own Scanner could never get it.
     */
    private static String readLine(InputStream in) throws IOException
    {
        StringBuilder line = new StringBuilder();
        int b;
        while ((b = in.read()) != -1 && b != '\n') {
            if (b != '\r') line.append((char) b);
        }
        return line.toString();
    }

    private static void printOutBanner()
    {

        System.out.println("**************************************************");
        System.out.println("*               HUDSON STINGER ACADEMY           *");
        System.out.println("*         Made by Hudson Stingers FRC 4295       *");
        System.out.println("**************************************************\n");
    }

    private static void runProgram(String lessonNum, String className) throws ReflectiveOperationException, LessonCrashed
    {
        String lessonClassName = "lesson" + lessonNum + "." + className;
        System.out.println("\n🚀 Launching lesson: " + lessonClassName);

        Class<?> lessonClass = Class.forName(lessonClassName);
        BaseLesson lesson = (BaseLesson) lessonClass.getDeclaredConstructor().newInstance();
        Method mainMethod = lessonClass.getMethod("main", String[].class);

        lesson.turnOnLogging();
        try {
            mainMethod.invoke(null, (Object) new String[0]);
        } catch (InvocationTargetException e) {
            lesson.logCrash(e.getCause());
            throw new LessonCrashed(lesson.getLogFileName());
        } finally {
            lesson.turnOffLogging();
            lesson.closeLogger();
        }

        System.out.println("\n✅ Lesson finished running.");
        System.out.println("📄 A file has been generated — commit it for review!");
    }
}
