package lesson09.extra;
import lessonRunner.BaseLesson;

// LESSON 09 EXTRA - A deeper discount system with user input
//
// TASK:
// 1. Create a Scanner. Ask "Student? (true/false)" and "Senior? (true/false)",
//    and read both with nextBoolean() like lesson 05
// 2. Ask for the membership tier as a word: BRONZE, SILVER, GOLD or NONE (read it with next())
// 3. Compare words with .equals, never == :  tier.equals("GOLD")
//    A String is a reference type (lesson 02's IOU), so == asks "is this the same IOU?",
//    not "are these the same letters?", and a word you read in never is.
// 4. Base price: $15.00
// 5. Build the nested logic:
//      if student:
//          if also senior:   GOLD 40%,  else SILVER 35%,  else 30%
//          else:             GOLD 25%,  else SILVER 20%,  else 15%
//      else:
//          if senior:        any tier (not NONE) 25%,  else 20%
//          else:             full price
// 6. Calculate the final price
// 7. Print a receipt with printf:
//      the base price, the discount reason (like "Student + Senior + Gold Member"),
//      the discount amount and the final price
public class Main extends BaseLesson {
    public static void main(String[] args) {
    }
}
