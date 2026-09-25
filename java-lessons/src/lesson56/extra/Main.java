package lesson56.extra;
import lessonRunner.BaseLesson;

// LESSON 56 EXTRA - Method references, and a number that's fresh every time
// A lambda that only calls one method can name the method instead, with ::
//   name -> System.out.println(name)   is the same as   System.out::println
//
// TASK:
// 1. An ArrayList<String> of Scooby, Fred, Daphne, Velma, Shaggy, in that order.
// 2. Print every name with forEach and a lambda. Then again with forEach and
//    System.out::println.
// 3. Sort shortest name first:  Comparator.comparingInt(...)  with a lambda that gives a
//    name's length. Print the list. Then longest first with String::length and
//    .reversed(). Print it again. Names with the same length keep their order - PREDICT
//    both lists first.
// 4. double once = Math.random();   DoubleSupplier everyTime = Math::random;
//    Loop three times, printing  once + "  vs  " + everyTime.getAsDouble()
//
// Expected (your random numbers will differ, but the LEFT column is the same all 3 times):
//   Scooby / Fred / Daphne / Velma / Shaggy      (each on its own line, printed twice)
//   [Fred, Velma, Scooby, Daphne, Shaggy]
//   [Scooby, Daphne, Shaggy, Velma, Fred]
//   0.5737847816249689  vs  0.9886306258355839
//   0.5737847816249689  vs  0.5241595950688832
//   0.5737847816249689  vs  0.8131731171463132
//
// WHY IT MATTERS: once was worked out one time. everyTime is a WAY to work it out, and it
// runs again whenever you ask. That's why lesson 37's climb command took a DoubleSupplier:
// a plain double would have frozen the trigger at the moment the command was built.
public class Main extends BaseLesson {
    public static void main(String[] args) {
    }
}
