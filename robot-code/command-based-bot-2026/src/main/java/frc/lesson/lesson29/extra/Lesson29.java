package frc.lesson.lesson29.extra;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.lesson.LessonBase;
// Uncomment once Drivetrain has its two constructors.
// import frc.robot.subsystems.Drivetrain;

// LESSON 29 EXTRA - A rookie driver's drivetrain
// The 2026 robot scales the sticks: forward x 0.7, turn x 0.8, so full stick isn't full
// power. Those numbers are in ROBOT.md and they're baked into the code. What if you wanted
// a gentler robot for someone driving for the first time?
//
// TASK:
// 1. Add two fields to Drivetrain:  public double forwardScale;  and  public double turnScale;
// 2. Give it TWO constructors:
//      Drivetrain()                                   -> this(0.7, 0.8)   the robot's own numbers
//      Drivetrain(double forwardScale, double turnScale)   <- the real one, does all the work
//    Everything you wrote in lesson 28 - the motors, the configs, the followers - moves into
//    the second one. The first one is now a single line.
// 3. Move the scaling INTO arcade(), so the lesson just hands it raw stick values:
//      leftLeader.set(forward * forwardScale + turn * turnScale);
// 4. Here: arcade(-driver.getLeftY(), driver.getRightX()), and publish both scales so your
//    log says which drivetrain you built.
// 5. Run it with  new Drivetrain()  and hold W for two seconds. About 5.4 m.
// 6. Change it to  new Drivetrain(0.4, 0.5)  and do it again. PREDICT the distance first.
//    You should get about 3.3 m, and the turning should feel much lazier.
//
// WHY NOT TWO DRIVETRAINS: you might want one of each and a button to switch. You already
// know why that doesn't work - lesson 27's two Fuel objects fought over the same rollers.
// One robot, one drivetrain. You choose how it's built when you build it, which is exactly
// what a constructor is.
public class Lesson29 extends LessonBase {
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
