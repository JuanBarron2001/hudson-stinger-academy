package lesson40.extra;
import lessonRunner.BaseLesson;

// LESSON 40 EXTRA - Rules inside getters and setters
//
// TASK:
// 1. Copy Car.java into this folder, with  package lesson40.extra;
// 2. Make the model  private final String model;
//    final means it's set once, in the constructor, and never again
// 3. Getter logic: make getPrice() return "$" + price  (a String now)
// 4. Setter rule: in setPrice, if the new price is less than 0, print
//    "Price can't be less than zero" and keep the old price
// 5. In main, try car.setPrice(-100), then print the price. It didn't change.
public class Main extends BaseLesson {
    public static void main(String[] args) {
    }
}
