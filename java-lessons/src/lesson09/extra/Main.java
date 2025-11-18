package lesson09.extra;
import lessonRunner.BaseLesson;
import java.util.Scanner;

// CHALLENGE: Build a complex nested discount system with user input
// 1. Use Scanner to prompt user for: student status (yes/no), senior status (yes/no), membership tier (BRONZE/SILVER/GOLD/NONE)
// 2. Base price: $15.00
// 3. Build deeply nested if logic:
//    if (isStudent) {
//        if (isSenior) {
//            if (GOLD) discount = 40%
//            else if (SILVER) discount = 35%
//            else discount = 30%
//        } else {
//            if (GOLD) discount = 25%
//            else if (SILVER) discount = 20%
//            else discount = 15%
//        }
//    } else {
//        if (isSenior) {
//            if (member) discount = 25%
//            else discount = 20%
//        } else {
//            discount = 0% (full price)
//        }
//    }
// 4. Calculate final price after discount
// 5. Print a detailed receipt:
//    - Base price
//    - Discount reason (e.g., "Student + Senior + Gold Member")
//    - Discount amount
//    - Final price
// 6. Format nicely with printf
public class Main extends BaseLesson {
    public static void main(String[] args) {
        // YOUR CODE HERE
    }
}
