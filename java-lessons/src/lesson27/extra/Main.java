package lesson27.extra;
import lessonRunner.BaseLesson;

// LESSON 27 EXTRA - Objects can do things
//
// TASK:
// 1. This folder is a different package, so it needs its own Car.java next to this file.
//    Copy your basic Car over and change its first line to  package lesson27.extra;
// 2. Add methods to Car (no "static" this time):
//      void start()  sets isRunning = true  and prints "You start the engine"
//      void stop()   sets isRunning = false and prints "You stop the engine"
//      void drive()  prints "You drive the " + model
//      void brake()  prints "You brake the " + model
// 3. In main, print car.isRunning, call start(), print it again, call stop(), print it again
// 4. Call drive() and brake()
// 5. Change an attribute straight from main:  car.isRunning = true;
// 6. Create a SECOND Car and print its make and model. Why is it exactly the same as the
//    first one? (Lesson 28's constructors fix that.) Answer in a comment.
//
// ANSWER:
public class Main extends BaseLesson {
    public static void main(String[] args) {
    }
}
