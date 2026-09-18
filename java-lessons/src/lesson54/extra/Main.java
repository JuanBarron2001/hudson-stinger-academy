package lesson54.extra;
import lessonRunner.BaseLesson;

// LESSON 54 EXTRA - Put the countdown on its own thread
//
// TASK:
// 1. MyRunnable.java (package lesson54.extra;):  public class MyRunnable implements Runnable
//    Its  public void run()  counts 1 to 10, sleeping 1000 ms each time, and prints
//    "Time's up!" at 10
// 2. In main, create a Scanner and print "You have 10 seconds to enter your name:"
// 3. Thread timerThread = new Thread(new MyRunnable());
//    timerThread.setDaemon(true);
//    timerThread.start();
// 4. Ask for the name and print "Hello " + name. The countdown runs in the background.
// 5. Take out setDaemon(true) and answer quickly: the program keeps running until the
//    countdown ends. Put it back.
// 6. Don't use System.exit(0) like the video does: it would shut down the lesson runner
//    before it finishes your log.
public class Main extends BaseLesson {
    public static void main(String[] args) {
    }
}
