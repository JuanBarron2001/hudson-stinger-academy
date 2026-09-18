package lesson10.basic;
import lessonRunner.BaseLesson;

// LESSON 10 BASIC - A magic spell parser
//
// TASK:
// 1. Store a messy spell in a String, like "   Cast FIREBALL now   "
// 2. .trim() the extra spaces, then .toLowerCase() it.
//    Your keywords are lowercase, so the spell has to be too:
//    an uppercased spell never .contains("fireball").
// 3. if the spell .isEmpty()               -> print "❌ No spell!"
//    else if it .equals("abracadabra")      -> print "🐇 A rabbit appears!"
//    else if it .contains("fireball")       -> print "🔥 Casting Fireball!"
//    else if it .contains("heal")           -> print "✨ Healing!"
//    add "teleport" and "shield" yourself
//    else                                   -> print "❌ Unknown spell!"
// 4. Print the cleaned spell's .length() and its first letter, .charAt(0)
// 5. Change the spell to "   FIREBALL   ", then "banana", then "" and run it each time
//    to see every branch work
public class Main extends BaseLesson {
    public static void main(String[] args) {
    }
}
