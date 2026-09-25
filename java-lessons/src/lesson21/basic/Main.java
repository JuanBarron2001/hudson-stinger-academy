package lesson21.basic;
import lessonRunner.BaseLesson;

// LESSON 21 BASIC - Local scope: every method is its own house
//
// TASK:
// 1. Inside main, create a local variable  int x = 1;  and print it
// 2. Below main, write  static void doSomething()  with its OWN local  int x = 2;
//    and print it there
// 3. Call doSomething() from main
// 4. Each method prints its own x. Neither can see inside the other's "house".
public class Main extends BaseLesson {
    public static void main(String[] args) {
    }
}
