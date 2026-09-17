package frc.lesson.lesson09.extra;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.LimelightHelpers;
import frc.lesson.LessonBase;

// LESSON 09 EXTRA - Don't shoot blind
// Add two more checks before feeding: does the camera see the hub, and are we aimed at it?
//
// At home there is no camera, so pretend with operator buttons:
//   X held (the 7 key) = "the Limelight sees the hub"
//   Y held (the 8 key) = "we are aimed at it"
// At a meeting, on the real robot, swap them for the real camera:
//   LimelightHelpers.getTV("limelight")                    -> true if it sees a target
//   Math.abs(LimelightHelpers.getTX("limelight")) < 1.5    -> true if we're aimed
//
// TASK:
// 1. Start from your basic half
// 2. Inside "A is held", nest the checks in this order:
//      target seen?  no -> status "NO TARGET"
//        aimed?      no -> status "AIMING"
//          at speed? no -> status "SPINNING UP"
//                    yes -> status "FEEDING"
//    Only "FEEDING" runs the conveyor at -0.7. Every other status holds it at -0.05.
// 3. Put the status on SmartDashboard
// 4. Should the rollers already spin up while the status is "NO TARGET"? Decide, and explain.
//
// ANSWER TO STEP 4:
public class Lesson09 extends LessonBase {
    // Variables declared up here keep their values between loops (lesson 21 explains why).
    private XboxController operator;
    private TalonFX leftRoller;
    private TalonFX rightRoller;
    private TalonFX conveyor;

    @Override
    public void setup() {
        // Runs ONCE, when the robot program starts.
    }

    @Override
    public void execute() {
        // Runs about 50 times a second while the robot is in Teleoperated.
    }
}
