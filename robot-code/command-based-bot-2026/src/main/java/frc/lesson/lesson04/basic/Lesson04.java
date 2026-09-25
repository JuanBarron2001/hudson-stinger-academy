package frc.lesson.lesson04.basic;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.lesson.LessonBase;

// LESSON 04 BASIC - Arcade drive, by hand
// Left stick up/down drives forward and back. Right stick left/right turns.
// At home: W/S is forward and back, J/L is turn.
//
// TASK:
// 1. Create the driver controller and all four drive motors
// 2. forward = the left stick's up/down, sign flipped (like lesson 03), times 0.7
// 3. turn = the right stick's left/right (driver.getRightX()), times 0.8
//    (0.7 and 0.8 are the competition robot's stick scaling; full stick is too twitchy)
// 4. left side speed  = forward + turn
//    right side speed = forward - turn
// 5. Set the motors (the right side still needs the opposite sign)
// 6. Put forward, turn, left and right on SmartDashboard
// 7. Hold W and L together. What number does "left" show, and what can a motor
//    actually do with a number like that? Answer in a comment.
//
// ANSWER:
public class Lesson04 extends LessonBase {
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
