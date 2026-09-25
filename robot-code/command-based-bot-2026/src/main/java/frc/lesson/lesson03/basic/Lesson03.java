package frc.lesson.lesson03.basic;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.lesson.LessonBase;

// LESSON 03 BASIC - Reading the driver's controller
// The driver controller is port 0. At home, W and S are its left stick's up and down.
//
// TASK:
// 1. In setup(): create the driver controller:  driver = new XboxController(0);
//    and create both LEFT side drive motors (CAN IDs in ROBOT.md)
// 2. In execute(): read the left stick's up/down into a variable:  driver.getLeftY()
// 3. Put that value on SmartDashboard
// 4. Set both left motors to that value
// 5. Run it and hold W (the stick pushed forward). Answer in comments:
//    a) Is the number positive or negative?
//    b) Which way does the robot move on Sim Field, and why does it turn instead of driving?
//
// ANSWERS:
public class Lesson03 extends LessonBase {
    // Variables declared up here keep their values between loops (lesson 21 explains why).
    private XboxController driver;
    private TalonFX leftLeader;
    private TalonFX leftFollower;

    @Override
    public void setup() {
        // Runs ONCE, when the robot program starts.
    }

    @Override
    public void execute() {
        // Runs about 50 times a second while the robot is in Teleoperated.
    }
}
