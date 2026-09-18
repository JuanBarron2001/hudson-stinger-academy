package lesson32.extra;
import lessonRunner.BaseLesson;

// LESSON 32 EXTRA - Unique children, and a grandparent
//
// TASK:
// 1. Copy Animal, Dog and Cat into this folder, with  package lesson32.extra;
// 2. Give each child something of its own:
//      Dog:  int lives = 1;  void speak() prints "The dog goes woof"
//      Cat:  int lives = 9;  void speak() prints "The cat goes meow"
// 3. In main, print each one's isAlive and lives, and call eat() and speak()
// 4. Multi-level: make a grandparent Organism.java. Move isAlive and its constructor into
//    Organism, and make  Animal extends Organism.  Dog and Cat still have isAlive.
// 5. Make  Plant extends Organism  with  void photosynthesize()  that prints
//    "The plant absorbs sunlight". Create a Plant, print its isAlive, and photosynthesize.
// 6. Try dog.photosynthesize(). Read the error, answer why in a comment, then remove it.
//
// WHY A DOG CAN'T PHOTOSYNTHESIZE:
public class Main extends BaseLesson {
    public static void main(String[] args) {
    }
}
