package lesson53.extra;
import lessonRunner.BaseLesson;

// LESSON 53 EXTRA - Enums in a switch, from user input
//
// TASK:
// 1. Copy Day.java into this folder, with  package lesson53.extra;
// 2. Day today = Day.WEDNESDAY;  and an enhanced switch on it:
//      case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> "It is a weekday"
//      case SATURDAY, SUNDAY -> "It is the weekend"
//    (no quotes around the cases: they're enum constants, not Strings)
// 3. Now read the day from a Scanner instead:
//      Day today = Day.valueOf(response.toUpperCase());
// 4. Type "Pizza day" and read the exception. Wrap the valueOf and the switch in a try,
//    and catch (IllegalArgumentException e) to print "Please enter a valid day"
// 5. Add PIZZA_DAY(8) to the enum and put it in the weekend case. "pizza_day" works now.
public class Main extends BaseLesson {
    public static void main(String[] args) {
    }
}
