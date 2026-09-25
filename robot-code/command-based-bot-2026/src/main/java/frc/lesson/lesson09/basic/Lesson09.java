package frc.lesson.lesson09.basic;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.lesson.LessonBase;

// LESSON 09 BASIC - A shot that waits until it's ready
// Feeding a ball into rollers that aren't at speed makes a weak, short shot.
// At home the operator is Keyboard 1: A is the 5 key.
//
// TASK:
// 1. Create the operator controller, both rollers (CAN 5, 6) and the conveyor (CAN 29)
// 2. Build this with an if INSIDE an if:
//      if A is held:
//          run the rollers at the power you found in lesson 07
//          if the rollers are at speed (lesson 07's Math.abs check against -70):
//              conveyor -0.7        -> status "FEEDING"
//          else:
//              conveyor -0.05       -> status "SPINNING UP"   (holds the ball back)
//      else:
//          stop everything          -> status "STOPPED"
// 3. Put the status and the roller speed on SmartDashboard
// 4. Tap A and let go quickly. Does the conveyor ever feed? Why or why not?
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
