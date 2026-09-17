package frc.lesson.lesson07.extra;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.lesson.LessonBase;

// LESSON 07 EXTRA - Drive math that behaves
// Start from your lesson 04 arcade drive (copy it over).
//
// TASK:
// 1. Squared sticks, for gentler control at low speed:
//      forward = Math.signum(stick) * Math.pow(stick, 2), then * 0.7
//    Math.pow(stick, 2) squares it (half stick -> quarter speed); Math.signum puts
//    the + or - back, because squaring a negative makes it positive. Do the same for turn.
// 2. Mix left = forward + turn, right = forward - turn (like lesson 04)
// 3. Fix numbers bigger than 1 WITHOUT changing the turn:
//      biggest = Math.max(Math.abs(left), Math.abs(right))
//      if biggest > 1, divide BOTH left and right by biggest
// 4. Put left and right on SmartDashboard before AND after step 3
// 5. Hold W and L together. Why is dividing both sides better than chopping each one
//    down to 1 with Math.min? Answer in a comment.
//
// ANSWER:
public class Lesson07 extends LessonBase {
    // Variables declared up here keep their values between loops (lesson 21 explains why).
    private XboxController driver;
    private TalonFX leftLeader;
    private TalonFX leftFollower;
    private TalonFX rightLeader;
    private TalonFX rightFollower;

    @Override
    public void setup() {
        // Runs ONCE, when the robot program starts.
    }

    @Override
    public void execute() {
        // Runs about 50 times a second while the robot is in Teleoperated.
    }
}
