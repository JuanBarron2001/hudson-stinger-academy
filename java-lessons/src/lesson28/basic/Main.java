package lesson28.basic;
import lessonRunner.BaseLesson;

// LESSON 28 BASIC - A constructor gives every object its own values
//
// TASK:
// 1. Make a new file next to this one: Student.java, starting with  package lesson28.basic;
// 2. Give Student the attributes  String name, int age, double gpa, boolean isEnrolled
// 3. Add a constructor that takes name, age and gpa:
//      Student(String name, int age, double gpa) { ... }
//    Inside, use this to tell the attribute from the parameter:  this.name = name;
// 4. In the constructor, also set  this.isEnrolled = true;  (every new student is enrolled)
// 5. Add a method  void study()  that prints  this.name + " is studying"
// 6. Back here in main: create  new Student("SpongeBob", 30, 3.2)  and print its four attributes
public class Main extends BaseLesson {
    public static void main(String[] args) {
    }
}
