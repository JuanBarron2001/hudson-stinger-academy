package frc.lesson.lesson02.basic;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.lesson.LessonBase;

// LESSON 02 BASIC - Variables on the 2026 robot
// CAN IDs are in robot-code/command-based-bot-2026/ROBOT.md
//
// TASK:
// 1. In setup(): store the team number (4295) in a variable and put it on SmartDashboard
// 2. In setup(): store the left leader motor's CAN ID in a variable,
//    then create the motor with it:  leftLeader = new TalonFX(yourIdVariable);
// 3. In execute(): store a speed of 0.25 in a variable, set the motor to it
//    (leftLeader.set(yourSpeedVariable);), and put the speed on SmartDashboard
// 4. Run it and open NetworkTables -> SmartDashboard -> Sim Field.
//    Only one of the robot's four motors is pushing. What does the robot do?
//
// ANSWER (write it here as a comment):
public class Lesson02 extends LessonBase {
    // Variables declared up here keep their values between loops (lesson 21 explains why).
    private TalonFX leftLeader;

    @Override
    public void setup() {
        // Runs ONCE, when the robot program starts.
    }

    @Override
    public void execute() {
        // Runs about 50 times a second while the robot is in Teleoperated.
    }
}
