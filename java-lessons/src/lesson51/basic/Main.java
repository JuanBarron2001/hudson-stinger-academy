package lesson51.basic;
import lessonRunner.BaseLesson;

// LESSON 51 BASIC - One Box for any type
//
// TASK:
// 1. You've used generics already: make an ArrayList<String> of fruits and print it,
//    then an ArrayList<Integer> of numbers (import java.util.ArrayList at the top)
// 2. Box.java (package lesson51.basic;):  public class Box<T>  with
//      private T item;   public void setItem(T item)   public T getItem()
//    T is the type parameter: a placeholder for whatever type the box will hold
// 3. In main:  Box<String> stringBox = new Box<>();  put "Banana" in it, and print getItem()
// 4. Box<Integer> intBox: put 3 in it and print it
// 5. Try  intBox.setItem("Banana");  and read the error, then delete it.
//    <Integer> filled in the T, and Java checks it before the program runs.
public class Main extends BaseLesson {
    public static void main(String[] args) {
    }
}
