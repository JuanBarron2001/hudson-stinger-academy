package lesson10.extra;
import lessonRunner.BaseLesson;

// LESSON 10 EXTRA - A recipe ingredient parser
//
// TASK:
// 1. Store a recipe command in a String, like "Add 2 cups sugar and vanilla extract"
//    or "MIX butter and eggs and sugar"
// 2. If the RAW command .equalsIgnoreCase("done"), print "Recipe finished!"
//    (that catches DONE, done and Done)
// 3. Clean it with .trim() and .toLowerCase() (lowercase, same reason as the basic)
// 4. Print where the first "and" is with .indexOf("and"), and the last with .lastIndexOf("and")
// 5. Use .contains() to check for the ingredients "sugar", "butter", "eggs" and "vanilla"
// 6. Use .replace() to swap an alias: "butter" -> "unsalted butter"
// 7. List the ingredients you found
// 8. Print a clean recipe step, like:
//      Step 1: Mix butter, eggs, and sugar
public class Main extends BaseLesson {
    public static void main(String[] args) {
    }
}
