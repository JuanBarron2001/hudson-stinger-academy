package lesson48.extra;
import lessonRunner.BaseLesson;

// LESSON 48 EXTRA - Formatting, custom dates, and comparing them
//
// TASK:
// 1. Import java.time.format.DateTimeFormatter (and LocalDateTime)
// 2. Format now with  DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss")  and
//    now.format(formatter), and print it
// 3. Build two date-times with of():
//      date1 = LocalDateTime.of(2024, 12, 25, 12, 0, 0)   (Christmas, noon)
//      date2 = LocalDateTime.of(2025, 1, 1, 0, 0, 0)      (New Year's, midnight)
// 4. if date1.isBefore(date2)       -> date1 + " is earlier than " + date2
//    else if date1.isAfter(date2)   -> date1 + " is later than " + date2
//    else if date1.isEqual(date2)   -> date1 + " is equal to " + date2
// 5. Change date1 so each branch prints once: January 2nd 2025, then New Year's midnight
public class Main extends BaseLesson {
    public static void main(String[] args) {
    }
}
