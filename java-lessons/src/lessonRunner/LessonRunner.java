package lessonRunner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class LessonRunner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        printOutBanner();

        try {
            System.out.print("Enter lesson number (two digits, e.g. 01): ");
            String lessonNum = scanner.nextLine().trim();

            if (!lessonNum.matches("\\d{2}")) {
                System.err.println("❌ Invalid lesson number format. Use exactly two digits like '01'.");
                scanner.close();
                return;
            }

            // System.out.print("Enter program/class to run (e.g. Main): ");
            // String className = scanner.nextLine().trim();
            // if (className.isBlank()) {
            //     System.err.println("❌ No class name entered.");
            //     scanner.close();
            //     return;
            // }
            scanner.close();
            String className = "Main"; // assuming Main for now for everything

            if(lessonNum.equals("03"))
            {
                LessonInput lessonInput = new LessonInput();
                lessonInput.addScriptedLine("6.7");
                lessonInput.addScriptedLine("2.1");
                System.setIn(lessonInput);
            }
            runProgram(lessonNum+".basic", className);
            System.out.println("-----------------------------------------------");
            if(lessonNum.equals("03"))
            {
                LessonInput lessonInput = new LessonInput();
                lessonInput.addScriptedLine("First Last");
                lessonInput.addScriptedLine("Math");
                lessonInput.addScriptedLine("92.3");
                lessonInput.addScriptedLine("95.7");
                lessonInput.addScriptedLine("90.1");
                lessonInput.addScriptedLine("91.2");
                System.setIn(lessonInput);
            }
            runProgram(lessonNum+".extra", className);

        } catch (ClassNotFoundException e) {
            System.err.println("❌ No such class found. Check the lesson number or program name.");
        } catch (NoSuchMethodException e) {
            System.err.println("❌ Missing required method (main/turnOnLogging/turnOffLogging).");
        } catch (Exception e) {
            System.out.println("❌ Something happened — it might be this program or your program.\n"
                             + "   Reach out to your Programming Mentor or Head Programmer Student.");
        }
    }

    private static void printOutBanner()
    {

        System.out.println("**************************************************");
        System.out.println("*               HUDSON STINGER ACADEMY           *");
        System.out.println("*         Made by Hudson Stingers FRC 4295       *");
        System.out.println("**************************************************\n");
    }

    private static void runProgram(String lessonNum, String className) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, SecurityException
    {
        String lessonClassName = "lesson" + lessonNum + "." + className;
        System.out.println("\n🚀 Launching lesson: " + lessonClassName);

        Class<?> lessonClass = Class.forName(lessonClassName);
        Object lessonInstance = lessonClass.getDeclaredConstructor().newInstance();

        Method turnOnLoggingMethod = lessonClass.getMethod("turnOnLogging");
        turnOnLoggingMethod.invoke(lessonInstance);

        Method mainMethod = lessonClass.getMethod("main", String[].class);
        mainMethod.invoke(null, (Object) new String[0]);

        Method turnOffLoggingMethod = lessonClass.getMethod("turnOffLogging");
        turnOffLoggingMethod.invoke(lessonInstance);

        System.out.println("\n✅ Lesson finished running.");
        System.out.println("📄 A file has been generated — commit it for review!");
    }
}
