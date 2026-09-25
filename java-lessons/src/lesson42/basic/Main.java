package lesson42.basic;
import lessonRunner.BaseLesson;

// LESSON 42 BASIC - A Car is built with its Engine (composition)
//
// TASK:
// 1. Engine.java (package lesson42.basic;): String type, a constructor, and
//    void start()  that prints "You start the " + type + " engine"
// 2. Car.java: String model, int year, Engine engine.
//    Its constructor takes (String model, int year, String engineType) and builds the
//    engine itself:  this.engine = new Engine(engineType);
// 3. Give Car  void start()  that starts the engine, then prints model + " is running"
// 4. In main: create  new Car("Corvette", 2025, "V8"),  print its model, year and
//    car.engine.type, then call car.start()
public class Main extends BaseLesson {
    public static void main(String[] args) {
    }
}
