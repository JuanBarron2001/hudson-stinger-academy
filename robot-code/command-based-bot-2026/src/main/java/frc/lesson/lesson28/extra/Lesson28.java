package frc.lesson.lesson28.extra;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.lesson.LessonBase;
// Uncomment once you've created frc/robot/subsystems/Drivetrain.java.
// import frc.robot.subsystems.Drivetrain;

// LESSON 28 EXTRA - The drivetrain gets a constructor, and you delete a minus sign
// Back in lesson 19 you wrote setDrive(left, right), and it had to flip the sign on the
// right side by hand, because the two sides face opposite directions. A constructor can
// tell the motors that ONCE, and then you never think about it again.
//
// TASK:
// 1. Make frc/robot/subsystems/Drivetrain.java with four TalonFX fields: 1 and 2 are the
//    leaders, 3 and 4 the followers (ROBOT.md).
// 2. Its constructor creates all four, then applies ONE config to each side:
//      both sides - Brake, 60 A stator limit
//      right side - InvertedValue.Clockwise_Positive
//      left side  - InvertedValue.CounterClockwise_Positive
// 3. Then make the followers actually follow, so you only ever talk to the leaders:
//      leftFollower.setControl(new Follower(1, MotorAlignmentValue.Aligned));
//      rightFollower.setControl(new Follower(2, MotorAlignmentValue.Aligned));
// 4. Add  public void arcade(double forward, double turn)  that sets the LEFT leader to
//    forward + turn and the RIGHT leader to forward - turn. NO MINUS SIGN on the right.
//    That's what the inversion in step 2 was for.
// 5. Here: drive it from the sticks, scaled the way the real robot is - forward x 0.7,
//    turn x 0.8 - and publish both sides' rotations.
// 6. Run it and hold W. Straight forward, about 5.4 m in two seconds, heading still 0.
// 7. THE EXPERIMENT: delete the .withInverted(...) line from the right side's config and
//    run it again. PREDICT it first.
//
// WHAT TO NOTICE: without that one line the robot spins in place - the same bug lesson 03
// warned you about, except now it lives in a constructor instead of in every drive call.
// Two motors per side is why the followers exist: talk to the leader, the follower copies.
public class Lesson28 extends LessonBase {
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
