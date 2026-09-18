package lesson55.basic;
import lessonRunner.BaseLesson;

// LESSON 55 BASIC - Two threads at once
//
// TASK:
// 1. MyRunnable.java (package lesson55.basic;):  public class MyRunnable implements Runnable
//    Its run() counts 1 to 5, sleeping 1000 ms before each number, and prints
//      Thread.currentThread().getName() + " " + i
// 2. Add  throws InterruptedException  to main's first line
// 3. In main, create two threads from two MyRunnables, and start() both
// 4. End main with  Thread.sleep(6000);  so it stays alive until both finish.
//    Without it, the threads' counting happens after the lesson runner stops logging.
// 5. Run it a few times. Does the order of the lines change?
public class Main extends BaseLesson {
    public static void main(String[] args) {
    }
}
