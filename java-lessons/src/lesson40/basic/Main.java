package lesson40.basic;
import lessonRunner.BaseLesson;

// LESSON 40 BASIC - Private data, getters and setters
//
// TASK:
// 1. Car.java (package lesson40.basic;):
//      private String model;  private String color;  private int price;
//      and a constructor that sets all three
// 2. In main, create  new Car("Charger", "Yellow", 10000)  and try to print car.color.
//    Read the error, then delete that line: private means only Car can touch it.
// 3. Add a getter for each one, so they can be READ:
//      public String getModel()   public String getColor()   public int getPrice()
//    Print all three with the getters.
// 4. Add setters for color and price ONLY, so just those can be WRITTEN:
//      public void setColor(String color)   public void setPrice(int price)
//    No setModel: a Charger can't turn into a Corvette.
// 5. Repaint the car "Blue", set its price to 5000, and print it again with the getters
// 6. Try car.setModel("Corvette") and read the error, then delete it
public class Main extends BaseLesson {
    public static void main(String[] args) {
    }
}
