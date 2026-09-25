package lesson50.basic;
import lessonRunner.BaseLesson;

// LESSON 50 BASIC - Run a task later
//
// TASK:
// 1. At the top:  import java.util.Timer;  and  import java.util.TimerTask;
// 2. Add  throws InterruptedException  to main's first line, after the parentheses
// 3. Timer timer = new Timer();
// 4. Make the task with an anonymous class (lesson 49),  new TimerTask() { ... };
//    whose  public void run()  prints "Hello"
// 5. timer.schedule(task, 3000);   runs it once, after 3 seconds
// 6. The timer runs in the background, so main has to wait for it, then stop it:
//      Thread.sleep(4000);
//      timer.cancel();
//    Without these two lines, "Hello" never reaches your log, and the program never
//    ends (stop it with Ctrl+C). Try it once to see.
public class Main extends BaseLesson {
    public static void main(String[] args) {
    }
}
