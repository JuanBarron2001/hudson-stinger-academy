package frc.lesson.lesson02.extra;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.lesson.LessonBase;

// LESSON 02 EXTRA - All four drive motors
// CAN IDs are in robot-code/command-based-bot-2026/ROBOT.md
//
// TASK:
// 1. Store the team number AND team name in variables, and put both on SmartDashboard
// 2. Store all four drivetrain CAN IDs in variables with clear names
//    (leftLeaderId, not id1), and create all four motors from them
// 3. Store one speed under 0.5 in a variable, and set all four motors to it
// 4. Put the speed on SmartDashboard
// 5. Run it and watch Sim Field. The robot does NOT drive forward.
//    What does it do, and why do you think that happens? (Lesson 03 has the answer.)
//
// ANSWER (write it here as a comment):
public class Lesson02 extends LessonBase {
    // Variables declared up here keep their values between loops (lesson 21 explains why).
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
