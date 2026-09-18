package lesson55.extra;
import lessonRunner.BaseLesson;

// LESSON 55 EXTRA - Ping-pong, and join()
//
// TASK:
// 1. MyRunnable.java (package lesson55.extra;): give it  private final String text;
//    a constructor that sets it, and a run() that prints the text 5 times, one second apart
// 2. In main: print "Game start", start a "Ping" thread and a "Pong" thread, then print
//    "Game over". Run it: "Game over" prints before a single ping. main didn't wait.
// 3. Fix it with join(): after starting both threads, in a try,
//      thread1.join();  thread2.join();
//    catch InterruptedException ("Main thread was interrupted"), THEN print "Game over"
public class Main extends BaseLesson {
    public static void main(String[] args) {
    }
}
