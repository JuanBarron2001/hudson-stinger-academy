package lesson20.extra;
import lessonRunner.BaseLesson;

// LESSON 20 EXTRA - Overloads that Java picks between
//
// TASK:
// 1. Overload add to take three numbers, and again to take four
// 2. Call each version and print the results
// 3. Pizza. Write three overloads of static String bakePizza(...):
//      bakePizza(String bread)                                returns bread + " pizza"
//      bakePizza(String bread, String cheese)                 returns cheese + " " + bread + " pizza"
//      bakePizza(String bread, String cheese, String topping) returns topping + " " + cheese + " " + bread + " pizza"
// 4. Call all three and print them. Java picks the one whose parameters match:
//      bakePizza("flatbread", "mozzarella", "pepperoni") -> "pepperoni mozzarella flatbread pizza"
public class Main extends BaseLesson {
    public static void main(String[] args) {
    }
}
