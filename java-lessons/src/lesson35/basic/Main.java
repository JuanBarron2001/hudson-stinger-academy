package lesson35.basic;
import lessonRunner.BaseLesson;

// LESSON 35 BASIC - What an object prints by default
//
// TASK:
// 1. Car.java (package lesson35.basic;): String make, String model, int year, String color,
//    and a constructor that sets all four
// 2. In main, create  new Car("Ford", "Mustang", 2025, "Red")
// 3. Print it directly:  System.out.println(car);
//    You get something like lesson35.basic.Car@6d06d69c: the class name and a hash code.
//    That's Object's default toString(), which every class inherits.
// 4. Print the details the long way:
//      car.color + " " + car.year + " " + car.make + " " + car.model
public class Main extends BaseLesson {
    public static void main(String[] args) {
    }
}
