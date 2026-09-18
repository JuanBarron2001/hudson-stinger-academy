package lesson21.extra;
import lessonRunner.BaseLesson;

// LESSON 21 EXTRA - Class scope and shadowing
//
// TASK:
// 1. Inside the class but outside every method, add a class variable:  static int x = 3;
// 2. Delete both local x variables and print x from main and from doSomething.
//    Both print 3: the class variable is "out in the street" where every method can see it.
// 3. Put the local variables back (x = 1 in main, x = 2 in doSomething) and run it again.
//    Now they print 1 and 2: a local variable wins over a class variable with the same name.
//    That's called shadowing.
public class Main extends BaseLesson {
    public static void main(String[] args) {
    }
}
