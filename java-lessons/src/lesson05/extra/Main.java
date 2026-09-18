package lesson05.extra;
import lessonRunner.BaseLesson;

// LESSON 05 EXTRA - Three groups of if statements
//
// TASK:
// 1. Import the Scanner and create one
// 2. Ask for the user's name (nextLine). Ask it FIRST: after a nextInt, lesson 03's
//    leftover-newline problem would swallow it.
// 3. Ask for the user's age (nextInt)
// 4. Ask "Are you a student? (true/false)" and read it with nextBoolean()
// 5. Group 1, the name:
//      if name.isEmpty() -> "You didn't enter your name"
//      else              -> "Hello " + name + "!"
// 6. Group 2, the age. ONE if / else if / else chain with these messages:
//      age < 0       -> "You haven't been born yet"
//      age == 0      -> "You are a baby"      (== compares, a single = assigns)
//      age >= 65     -> "You are a senior"
//      age >= 18     -> "You are an adult"
//      anything else -> "You are a child"
//    ORDER MATTERS: Java stops at the first true condition. Put your checks in an
//    order where a 70-year-old is called a senior, not an adult.
// 7. Group 3, the student: write if (isStudent), not if (isStudent == true)
public class Main extends BaseLesson {
    public static void main(String[] args) {
    }
}
