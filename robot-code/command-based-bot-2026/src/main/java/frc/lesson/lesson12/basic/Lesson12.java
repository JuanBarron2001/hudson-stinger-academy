package frc.lesson.lesson12.basic;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.lesson.LessonBase;

// LESSON 12 BASIC - The ternary operator on the climber
// A ternary picks one of two values in one line:  condition ? valueIfTrue : valueIfFalse
// At home: the D-pad is the arrow keys. Up arrow = D-pad up.
//
// TASK:
// 1. Create the driver controller (port 0) and the climber motor (CAN 7)
// 2. D-pad up reads as 0 from driver.getPOV(). Use ONE ternary to pick the climber power:
//      0.5 if the D-pad is pushed up, otherwise 0.0
//    and set the climber to it.
// 3. position = climber.getPosition().getValueAsDouble()     (motor rotations)
// 4. Use a second ternary for a word:  "UP" if position > 100, otherwise "DOWN"
// 5. Put power, position and the word on SmartDashboard
// 6. Rewrite step 2 as an if / else in a comment. Which is easier to read here?
//
// IF / ELSE VERSION:
public class Lesson12 extends LessonBase {
    // Variables declared up here keep their values between loops (lesson 21 explains why).
    private XboxController driver;
    private TalonFX climber;

    @Override
    public void setup() {
        // Runs ONCE, when the robot program starts.
    }

    @Override
    public void execute() {
        // Runs about 50 times a second while the robot is in Teleoperated.
    }
}
