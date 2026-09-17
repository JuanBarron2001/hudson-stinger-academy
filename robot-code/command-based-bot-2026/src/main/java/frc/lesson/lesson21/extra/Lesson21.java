package frc.lesson.lesson21.extra;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.lesson.LessonBase;

// LESSON 21 EXTRA - Toggle the intake, and remember the fastest speed
// Holding a button all match is tiring. A toggle turns intake on with one press and off
// with the next. To know a press just HAPPENED, you have to remember last loop's button.
// At home the operator's B is the 6 key.
//
// TASK:
// 1. Declare your own fields: operator controller, both rollers, the conveyor, and:
//      boolean intakeOn = false;
//      boolean bWasPressed = false;
//      double fastestSpeed = 0;
// 2. Each loop: bPressed = operator.getBButton()
//    if (bPressed && !bWasPressed) -> flip intakeOn
//    then bWasPressed = bPressed
// 3. When intakeOn: rollers -0.7, conveyor 0.8 (ROBOT.md). Otherwise stop them.
// 4. Keep fastestSpeed as the biggest roller speed ever seen (Math.max and Math.abs)
// 5. Shadowing: add a field  double rollerPower = 0.7;  and inside execute() a LOCAL
//      double rollerPower = 0.2;
//    Which one does your code use? How do you reach the field? (Hint: this.)
// 6. Put intakeOn and fastestSpeed on SmartDashboard
//
// ANSWER TO STEP 5:
public class Lesson21 extends LessonBase {
    // Declare your fields here.

    @Override
    public void setup() {
        // Runs ONCE, when the robot program starts.
    }

    @Override
    public void execute() {
        // Runs about 50 times a second while the robot is in Teleoperated.
    }
}
