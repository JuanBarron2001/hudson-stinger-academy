package lesson09.basic;
import lessonRunner.BaseLesson;

// LESSON 09 BASIC - Movie ticket discounts with nested if statements
//
// TASK:
// 1. Create double price = 15.00 and two booleans: isStudent and isSenior
// 2. Write an if inside an if, AND an if inside the else:
//      if (isStudent) {
//          if (isSenior)  -> student + senior discount, 30% off  (price *= 0.7)
//          else           -> student discount, 10% off           (price *= 0.9)
//      } else {
//          if (isSenior)  -> senior discount, 20% off            (price *= 0.8)
//          else           -> full price
//      }
// 3. Use printf to print the ticket type and the final price with 2 decimal places
// 4. Try all four combinations of true and false. You should see:
//      Student+Senior Ticket: $10.50
//      Student Ticket: $13.50
//      Senior Ticket: $12.00
//      Regular Ticket: $15.00
public class Main extends BaseLesson {
    public static void main(String[] args) {
    }
}
