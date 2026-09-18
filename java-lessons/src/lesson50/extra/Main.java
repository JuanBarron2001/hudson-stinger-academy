package lesson50.extra;
import lessonRunner.BaseLesson;

// LESSON 50 EXTRA - Repeat, then stop
//
// TASK:
// 1. Same imports, and  throws InterruptedException  on main
// 2. A TimerTask with its own counter, as an anonymous class:
//      int count = 3;
//      run(): print "Hello", count--, and if count <= 0: print "Task complete"
//             and call timer.cancel()
// 3. timer.scheduleAtFixedRate(task, 0, 1000);   start now, repeat every second
// 4. The task stops the timer itself, but main still has to wait:  Thread.sleep(4000);
// 5. Change the delay (the 0) to 3000. How long does main have to sleep now?
public class Main extends BaseLesson {
    public static void main(String[] args) {
    }
}
