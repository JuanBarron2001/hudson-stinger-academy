package frc.lesson.lesson56.basic;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.lesson.LessonBase;
// Uncomment once you've done lesson 37: these are your classes from then.
// import frc.robot.commands.DynamicClimb;
// import frc.robot.subsystems.Climber;

// LESSON 56 BASIC - TriggerAxis, in one line
// In lesson 37, TriggerAxis was a whole file - a field, a constructor, an @Override - to
// hand DynamicClimb ONE expression: controller.getRightTriggerAxis(). DoubleSupplier has
// exactly one method, so it's a functional interface, so a lambda can stand in for it.
//
// TASK:
// 1. Build your Climber and a DynamicClimb the way lesson 37 did, but with a lambda where
//    new TriggerAxis(driver) used to be:
//      new DynamicClimb(climber, () -> driver.getRightTriggerAxis())
//    Change NOTHING else - not DynamicClimb, not Climber.
// 2. Schedule it while the right trigger is past 0.1, the way lesson 37 did (the E key).
// 3. Run it: a quarter trigger, then half, then full, like lesson 37. PREDICT first -
//    should the numbers be different? Measured, 1.2 s each from zero:
//      lambda:       29.6, 58.2, 116.6 rotations
//      TriggerAxis:  29.6, 58.2, 116.5 rotations
//    DynamicClimb can't tell which one it got.
// 4. Publish your lambda's getClass().getName(). Java made up a class for you, something
//    like Lesson56$$Lambda... - just like lesson 49's Lesson49$1.
//
// DON'T DELETE TriggerAxis.java. Your Lesson37.java still uses it, and deleting a class
// another file uses breaks the whole build, not just one lesson. Just don't write new ones.
public class Lesson56 extends LessonBase {
    // Declare your driver controller, your Climber and your DynamicClimb here.

    @Override
    public void setup() {
        // Runs ONCE, when the robot program starts.
    }

    @Override
    public void execute() {
        // Runs about 50 times a second while the robot is in Teleoperated.
    }
}
