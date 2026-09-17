package frc.lesson.lesson13.extra;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.lesson.LessonBase;

// LESSON 13 EXTRA - Add the shuttle, and let the switch hand back a value
// Shuttle passes a ball across the field: rollers fast, straight to the launcher.
// At home: operator right bumper = the 4 key.
//
// TASK:
// 1. Start from your basic half and add a "SHUTTLE" mode on the right bumper
// 2. Instead of one switch setting two variables, write TWO switch EXPRESSIONS that each
//    hand back one value, and combine cases with commas:
//      double conveyorPower = switch (mode) {
//          case "INTAKE", "EJECT" -> 0.8;
//          ...
//      };
//    Shuttle: rollers -0.93, conveyor -0.7
// 3. What happens if you forget the default case in a switch expression? Try it, read the
//    error, then put it back. Answer in a comment.
//
// ANSWER:
public class Lesson13 extends LessonBase {
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
