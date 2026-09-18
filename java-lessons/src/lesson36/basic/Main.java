package lesson36.basic;
import lessonRunner.BaseLesson;

// LESSON 36 BASIC - An abstract Shape
//
// TASK:
// 1. Shape.java (package lesson36.basic;):  public abstract class Shape  with
//      abstract double area();                        (no body: children must write it)
//      void display()  prints "This is a shape"      (a normal, concrete method)
// 2. Circle.java, Triangle.java and Rectangle.java: each one  extends Shape.
//    Java won't compile them until each has an area() method, so for now give each one:
//      @Override double area() { return 0; }
// 3. In main, try  new Shape()  and read the error, then delete it
// 4. Create a Circle, a Triangle and a Rectangle, and call display() on each
public class Main extends BaseLesson {
    public static void main(String[] args) {
    }
}
