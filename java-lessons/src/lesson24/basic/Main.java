package lesson24.basic;
import lessonRunner.BaseLesson;

// LESSON 24 BASIC - Search an array of numbers (a linear search)
//
// TASK:
// 1. Create  int[] numbers = {1, 9, 2, 8, 3, 7, 4};  and  int target = 2;
// 2. Loop through the array with a for loop that stops at numbers.length
// 3. if (numbers[i] == target): print "Element found at index " + i, then break
//    (once you've found it, there's no reason to keep looking)
// 4. Change target to 5, which isn't in the array. Nothing prints at all. Fix that:
//      before the loop:  boolean isFound = false;
//      when you find it: isFound = true;
//      after the loop:   if (!isFound) print "Element not found in the array"
public class Main extends BaseLesson {
    public static void main(String[] args) {
    }
}
