package lesson45.extra;
import lessonRunner.BaseLesson;

// LESSON 45 EXTRA - More than one catch, finally, and try-with-resources
//
// TASK:
// 1. try the 1 / 0 again, with three blocks after it:
//      catch (ArithmeticException e)  prints "Math error: " + e.getMessage()
//      catch (Exception e)            prints "Something went wrong."   (the safety net, LAST)
//      finally                        prints "This always executes."
// 2. Try-with-resources: create the Scanner INSIDE the try's parentheses,
//      try (Scanner scanner = new Scanner(System.in)) { ... }
//    ask for a number, and catch InputMismatchException ("Invalid input!").
//    Java closes the Scanner for you when the try ends.
public class Main extends BaseLesson {
    public static void main(String[] args) {
    }
}
