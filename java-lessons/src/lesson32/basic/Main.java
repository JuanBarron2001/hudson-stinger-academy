package lesson32.basic;
import lessonRunner.BaseLesson;

// LESSON 32 BASIC - A child class inherits from its parent
//
// TASK:
// 1. Make three new files next to this one, each starting with  package lesson32.basic;
//      Animal.java:  boolean isAlive;  a constructor that sets isAlive = true;
//                    and void eat() that prints "The animal is eating"
//      Dog.java:     public class Dog extends Animal { }      (empty for now)
//      Cat.java:     public class Cat extends Animal { }      (empty for now)
// 2. In main, create a Dog and a Cat
// 3. Print dog.isAlive and cat.isAlive, and call dog.eat() and cat.eat().
//    Dog and Cat are empty, yet they have both: they inherited them from Animal.
public class Main extends BaseLesson {
    public static void main(String[] args) {
    }
}
