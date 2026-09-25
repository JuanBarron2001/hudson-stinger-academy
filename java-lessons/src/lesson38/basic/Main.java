package lesson38.basic;
import lessonRunner.BaseLesson;

// LESSON 38 BASIC - One array, many shapes
//
// TASK:
// 1. Vehicle.java (package lesson38.basic;):  public abstract class Vehicle { abstract void go(); }
// 2. Car, Bike and Boat each extend Vehicle and override go():
//      "You drive the car"   "You ride the bike"   "You sail the boat"
// 3. In main, try  Car[] cars = { new Car(), new Bike(), new Boat() };  and read the error.
//    A bike isn't a car. Delete it.
// 4. Use the type they all share:  Vehicle[] vehicles = { new Car(), new Bike(), new Boat() };
// 5. Loop with  for (Vehicle vehicle : vehicles)  and call vehicle.go().
//    Each one runs its OWN go(), even though the loop only knows it's a Vehicle.
public class Main extends BaseLesson {
    public static void main(String[] args) {
    }
}
