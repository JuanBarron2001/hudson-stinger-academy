package frc.lesson.lesson31.extra;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.lesson.LessonBase;
// Uncomment once RobotMath exists and Drivetrain has its counter.
// import static frc.robot.Constants.DriveConstants.DEADBAND;
// import frc.robot.RobotMath;
// import frc.robot.subsystems.Drivetrain;

// LESSON 31 EXTRA - A static method, a static import, and a counter that catches a bug
// Constants are static VALUES. Methods can be static too, and it means the same thing:
// this belongs to the class, because it doesn't need an object to do its job.
//
// TASK:
// 1. Make frc/robot/RobotMath.java with ONE static method - lesson 19's deadband:
//      public static double deadband(double value, double band)
//    Return 0 when Math.abs(value) < band, otherwise return value. Nothing about this
//    needs a drivetrain, or a robot, or any object at all. So it's static.
// 2. Use it here on BOTH sticks, and publish the forward value after the deadband.
//    Call it as  RobotMath.deadband(...)  - no  new RobotMath()  anywhere.
// 3. Add a static counter to Drivetrain:
//      public static int built = 0;
//    and  built++;  inside the constructor that does the real work (the two-argument one).
//    Publish it here, straight off the class:  SmartDashboard.putNumber("Drivetrains Built",
//    Drivetrain.built);
// 4. The static import. At the top:  import static frc.robot.Constants.DriveConstants.DEADBAND;
//    Now you write DEADBAND instead of Constants.DriveConstants.DEADBAND.
// 5. Run it and nudge the stick very slightly (tap W). "Forward After Deadband" should sit at
//    0.0 until you push past 0.1, then jump. "Drivetrains Built" should read exactly 1.
// 6. THE EXPERIMENT: add a second  new Drivetrain();  in setup() and run it again.
//    PREDICT what the counter says. Then take it out.
//
// WHAT THE COUNTER IS FOR: it is a real check. One robot has one drivetrain, so that number
// should be 1 forever. If it ever reads 2, something built a second one behind your back -
// which is lesson 27's two-objects-one-motor bug, except now you can SEE it.
//
// ON THE STATIC IMPORT: it makes short code and it hides where a name came from. Last season's
// code static-imports a whole class it never uses a single value from. Part 3 has the details.
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
