package lesson49.basic;
import lessonRunner.BaseLesson;

// LESSON 49 BASIC - One unusual dog
//
// TASK:
// 1. Dog.java (package lesson49.basic;):  void speak()  prints "The dog goes woof".
//    In main, create a dog and make it speak.
// 2. The long way: TalkingDog.java, where  TalkingDog extends Dog  and overrides speak()
//    to print "Scooby-Doo says ruh-roh". Create one and make it speak.
// 3. The short way: delete TalkingDog.java, and give a second, ordinary Dog its own
//    speak() right where you create it:
//      Dog dog2 = new Dog() {
//          @Override
//          void speak() { System.out.println("Scooby-Doo says ruh-roh"); }
//      };
//    The braces are a class with no name, an anonymous class. Note the ; at the end.
// 4. Make both dogs speak. The first one still goes woof.
public class Main extends BaseLesson {
    public static void main(String[] args) {
    }
}
