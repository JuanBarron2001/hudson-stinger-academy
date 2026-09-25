package frc.lesson.lesson16.extra;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.lesson.LessonBase;

// LESSON 16 EXTRA - A speed bar made with a for loop
// Numbers are hard to read at a glance. A bar is easy.
// At home the operator's A is the 5 key.
//
// TASK:
// 1. Create the operator controller and both rollers. While A is held, run them at your
//    lesson 07 power; otherwise stop them.
// 2. blocks = (int) (Math.abs(leftRoller's velocity) / 10)
// 3. Start with bar = "" and use a for loop to add "#" to it, blocks times
// 4. Put the bar on SmartDashboard, then press and release A and watch it grow and shrink
// 5. This for loop runs inside execute() and does NOT freeze the robot like lesson 15's while.
//    What's the difference? Answer in a comment.
//
// ANSWER:
public class Lesson16 extends LessonBase {
    // Variables declared up here keep their values between loops (lesson 21 explains why).
    private XboxController operator;
    private TalonFX leftRoller;
    private TalonFX rightRoller;

    @Override
    public void setup() {
        // Runs ONCE, when the robot program starts.
    }

    @Override
    public void execute() {
        // Runs about 50 times a second while the robot is in Teleoperated.
    }
}
