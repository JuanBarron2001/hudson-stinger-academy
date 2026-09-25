package lesson56.basic;
import lessonRunner.BaseLesson;

// LESSON 56 BASIC - The anonymous class, shortened
// There's no video for this lesson. LESSON56.md explains how to read a lambda.
//
// TASK:
// 1. Write lesson 49's anonymous Runnable that prints "Running a one-time task".
//    Then write a second Runnable that prints the same thing, as a lambda:  () -> ...
//    Run both.
// 2. Greeting.java (package lesson56.basic;): a functional interface with one method:
//      String greet(String name);
// 3. Two Greeting lambdas: polite puts "Hello, " in front of the name; scooby puts
//    "Ruh-roh, " in front and "!" after. Call both with "Shaggy".
// 4. A third, loud, with a two-statement body in { }: upper-case the name into a variable,
//    then return "HEY " + that + a local variable punctuation = "!!!" set just above it.
//    Call it with "Velma".
// 5. Print your lambda Runnable's getClass().getName(), like lesson 49's Main$1.
//
// Expected (the last line's number will differ):
//   Running a one-time task
//   Running a one-time task
//   Hello, Shaggy
//   Ruh-roh, Shaggy!
//   HEY VELMA!!!
//   lesson56.basic.Main$$Lambda$1/0x000074f188000c30
//
// EXPERIMENTS - predict each one before you build:
// a. Put @FunctionalInterface above the interface, then add a second method, String wave();
//    Read the error. Delete wave(), keep the annotation.
// b. Right after the lambda that uses punctuation, add  punctuation = "?";  Read the error:
//    a lambda can read a local variable only if it never changes. Undo it.
public class Main extends BaseLesson {
    public static void main(String[] args) {
    }
}
