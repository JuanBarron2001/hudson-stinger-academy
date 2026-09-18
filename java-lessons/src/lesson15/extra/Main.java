package lesson15.extra;
import lessonRunner.BaseLesson;

// LESSON 15 EXTRA - Infinite loops, game loops, and do-while
//
// TASK:
// 1. Write this infinite loop but leave it COMMENTED OUT. Don't run it: it prints forever,
//    and every line lands in your log file.
//      while (1 == 1) { System.out.println("Help, I'm stuck in a loop"); }
//    In a comment, explain why it never ends.
// 2. Game loop:
//      String response = "";
//      while (!response.equals("Q")):
//          print "You are playing a game. Press Q to quit."
//          response = scanner.next().toUpperCase();   (so a lowercase q quits too)
//      after the loop, print "You have quit the game"
// 3. Age validation: ask for an age, then while (age < 0):
//      print "Your age can't be negative" and ask again
// 4. do-while: ask for a number between 1 and 10 with
//      do { ... } while (number < 1 || number > 10);
//    In a comment: a do-while always runs its body at least once. A while may never run it.
//
// WHY THE INFINITE LOOP NEVER ENDS:
public class Main extends BaseLesson {
    public static void main(String[] args) {
    }
}
