package frc.lesson.lesson13.basic;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.lesson.LessonBase;

// LESSON 13 BASIC - A switch picks the ball path
// At home the operator is Keyboard 1: A = 5 key, B = 6 key, left bumper = 3 key.
// The powers are in ROBOT.md -> "Ball paths".
//
// TASK:
// 1. Create the operator controller, both rollers (CAN 5, 6) and the conveyor (CAN 29)
// 2. Turn the buttons into a mode word with if / else if (like lesson 05):
//      B held -> "INTAKE",  left bumper held -> "EJECT",  A held -> "SHOOT",  otherwise "STOP"
// 3. Use an enhanced switch on the mode to set two variables, rollerPower and conveyorPower:
//      case "INTAKE" -> rollers -0.7, conveyor  0.8
//      case "EJECT"  -> rollers  0.9, conveyor  0.8
//      case "SHOOT"  -> rollers at your lesson 07 power, conveyor -0.7
//      default       -> both 0
// 4. Set the motors. Both rollers get the same number: they turn the same rollers.
// 5. Put the mode, rollerPower and conveyorPower on SmartDashboard
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
