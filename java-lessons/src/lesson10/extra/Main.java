package lesson10.extra;
import lessonRunner.BaseLesson;
import java.util.Scanner;

// CHALLENGE: Build a recipe ingredient parser with multiple string methods
// 1. Use Scanner to read recipe commands like:
//    - "Add 2 cups sugar and vanilla extract"
//    - "MIX butter and eggs"
//    - "Combine flour, salt, and baking powder"
// 2. Parse using string methods working together:
//    - .trim() to clean whitespace
//    - .toUpperCase() to normalize case for checking
//    - .toLowerCase() for later display if desired
//    - .contains() to find ingredient keywords: "sugar", "butter", "eggs", "vanilla", "flour", "salt", "baking powder"
//    - .indexOf() to find positions of keywords (optional, more advanced)
//    - .replace() to swap aliases: "butter" -> "unsalted butter", "eggs" -> "large eggs"
// 3. Extract all recognized ingredients found in the command
// 4. Print a clean recipe step:
//    "Recipe: Mix butter, eggs, and sugar together"
// 5. Show multiple string methods working together to parse complex input
// 6. Handle edge cases: empty input, all uppercase, extra spaces
public class Main extends BaseLesson {
    public static void main(String[] args) {
        // YOUR CODE HERE
    }
}
