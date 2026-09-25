package lesson54.basic;
import lessonRunner.BaseLesson;

// LESSON 54 BASIC - One thread can only do one thing at a time
//
// TASK:
// 1. Import the Scanner and create one
// 2. Print "You have 5 seconds to enter your name:"
// 3. A for loop from 1 to 5 that sleeps 1000 ms each time (Thread.sleep inside a try,
//    catching InterruptedException), and prints "Time's up!" when i == 5
// 4. THEN ask "Enter your name: ", read it, and print "Hello " + name
// 5. Run it: the prompt doesn't appear until the countdown is over. Everything runs on
//    one thread, the main thread, one line at a time.
public class Main extends BaseLesson {
    public static void main(String[] args) {
    }
}
