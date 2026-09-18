package lesson37.basic;
import lessonRunner.BaseLesson;

// LESSON 37 BASIC - Interfaces are contracts
//
// TASK:
// 1. Two interfaces, each in its own file (package lesson37.basic;):
//      Prey.java:      public interface Prey { void flee(); }
//      Predator.java:  public interface Predator { void hunt(); }
// 2. Rabbit.java:  public class Rabbit implements Prey,  with
//      @Override public void flee()  printing "The rabbit is running away!"
// 3. Hawk.java:  public class Hawk implements Predator,  with
//      @Override public void hunt()  printing "The hawk is hunting!"
// 4. In main, create a Rabbit and a Hawk, and call rabbit.flee() and hawk.hunt()
// 5. Delete "public" from the rabbit's flee() and read the error, then put it back.
//    An interface's methods are always public, so the class has to keep them public.
public class Main extends BaseLesson {
    public static void main(String[] args) {
    }
}
