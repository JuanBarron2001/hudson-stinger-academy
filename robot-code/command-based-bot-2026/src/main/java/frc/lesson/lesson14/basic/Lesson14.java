package frc.lesson.lesson14.basic;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.lesson.LessonBase;

// LESSON 14 BASIC - Flatten the nested ifs with && and !
// Lesson 09 nested ifs inside ifs. Logical operators can say the same thing in one line.
// At home the operator's A is the 5 key.
//
// TASK:
// 1. Create the operator controller, both rollers and the conveyor
// 2. Store two booleans:
//      shooting = operator.getAButton()
//      atSpeed  = Math.abs(-70 - leftRoller velocity) < 3        (lesson 07)
// 3. Rollers run at your lesson 07 power whenever shooting, otherwise 0
// 4. Use ONE if / else if / else chain with NO nesting:
//      shooting && atSpeed    -> conveyor -0.7,  status "FEEDING"
//      shooting && !atSpeed   -> conveyor -0.05, status "SPINNING UP"
//      otherwise              -> conveyor 0,     status "STOPPED"
// 5. Put shooting, atSpeed and the status on SmartDashboard
// 6. Compare with your lesson 09 version. Which is easier to read?
//
// ANSWER:
public class Lesson14 extends LessonBase {
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
