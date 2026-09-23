package frc.lesson.lesson31.basic;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.lesson.LessonBase;
// Uncomment once you've made frc/robot/Constants.java.
// import frc.robot.Constants;
// import frc.robot.subsystems.Drivetrain;

// LESSON 31 BASIC - Constants, the file every robot has
// Count the loose numbers in your code right now: 1, 2, 3, 4, 5, 6, 29, 60, 100, 80,
// -0.7, 0.8, -0.72, -70, 0.7... Every one of them is typed somewhere specific, and if
// the conveyor ever moves to a different CAN ID you get to go find them all.
//
// A CAN ID isn't something a Fuel object HAS. There is one conveyor on the robot. That
// is what static is for: it belongs to the class, not to any one object.
//
// TASK:
// 1. Make frc/robot/Constants.java:  public final class Constants
//    with nested groups inside it:
//      public static final class DriveConstants { ... }
//      public static final class FuelConstants  { ... }
//    Every value inside is  public static final  - shared, and never changes.
// 2. Move the numbers in. Suggested homes:
//      DriveConstants - the four CAN IDs, CURRENT_LIMIT 60, FORWARD_SCALE 0.7,
//                       TURN_SCALE 0.8, DEADBAND 0.1
//      FuelConstants  - CAN IDs 5, 6, 29, the two current limits, the intake powers,
//                       SHORT_SHOT_POWER, SHORT_SHOT_RPS, SPEED_TOLERANCE_RPS
// 3. Change Drivetrain, Fuel and Shot to use them. Nothing else changes.
// 4. Here: publish three constants in setup() - and notice you never write  new Constants().
//      SmartDashboard.putNumber("Const/Short Shot RPS", Constants.FuelConstants.SHORT_SHOT_RPS);
//    Then drive as usual so you can see the robot still works.
// 5. Run it. It should behave EXACTLY like lesson 29. That is the whole point of this one.
//
// WHY THE NESTED CLASSES: one flat Constants file becomes 200 lines of numbers with names
// like LEFT_ID. Grouping them means the name can be short, because DriveConstants.LEFT_LEADER_ID
// already tells you which left it is.
public class Lesson31 extends LessonBase {
    // Declare your driver controller and your Drivetrain here.

    @Override
    public void setup() {
        // Runs ONCE, when the robot program starts.
    }

    @Override
    public void execute() {
        // Runs about 50 times a second while the robot is in Teleoperated.
    }
}
