package frc.lesson.lesson27.extra;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.lesson.LessonBase;
// Uncomment once frc/robot/subsystems/Fuel.java exists. It is the same file as the basic half.
// import frc.robot.subsystems.Fuel;

// LESSON 27 EXTRA - Two objects, one set of rollers
// The Java half made a second Car and asked why it was identical to the first. Here the
// answer is worse than identical, and it is worth seeing once.
//
// TASK:
// 1. Add a field to Fuel:  public String lastAction = "none";
//    Set it at the end of each method: "intake", "eject", "stopped".
// 2. In setup(), make TWO of them:  fuelA = new Fuel();  and  fuelB = new Fuel();
// 3. Use the dot operator to change only the second one, the way the Java half did:
//      fuelB.lastAction = "I am the second one";
//    Put both on SmartDashboard. Two objects, two answers, from one class.
// 4. Now the interesting part. In execute(), while the operator holds B:
//      fuelA.intake();
//      fuelB.stop();
//    Publish the real roller speed too, straight off the motor.
// 5. Run it and hold B (the 6 key). PREDICT the roller speed before you look.
//
// WHAT TO NOTICE: the two objects really do have their own state - they say different things.
// But there is only ONE pair of rollers on the robot, and both objects are holding it. The
// last set() of each loop wins, so the rollers sit at 0 and nothing intakes.
//
// This is a real bug teams ship: two pieces of code owning the same motor and fighting over it.
// Lesson 42 is where exactly ONE Fuel gets made and everything else shares it.
public class Lesson27 extends LessonBase {
    // Declare your operator controller and your two Fuel objects here.

    @Override
    public void setup() {
        // Runs ONCE, when the robot program starts.
    }

    @Override
    public void execute() {
        // Runs about 50 times a second while the robot is in Teleoperated.
    }
}
