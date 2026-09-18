package lesson08.basic;
import lessonRunner.BaseLesson;

// LESSON 08 BASIC - A player profile card with printf
//
// TASK:
// 1. Create variables: name (String), initial (char), rank (int), wins (int),
//    score (double), level (int), isOnline (boolean)
// 2. Use printf to print a profile card with a header and a footer
// 3. Use every specifier at least once: %s, %c, %d, %f and %b
// 4. Precision: %.2f for the score
// 5. The , flag for thousands: %,.2f turns 12345.5 into 12,345.50
// 6. Zero padding for the rank: %03d turns 1 into 001
// 7. Width to line things up: a positive width right-justifies (%5d),
//    a negative one left-justifies (%-12s)
// 8. End every line with %n (or \n). printf never adds a new line for you.
// 9. Example output:
//    ================================
//     Player Profile
//    ================================
//     Name:        SpongeBob
//     Rank:        #001
//     Level:       45
//     Wins:        234
//     Score:       12,345.50
//     Online:      true
//    ================================
public class Main extends BaseLesson {
    public static void main(String[] args) {
    }
}
