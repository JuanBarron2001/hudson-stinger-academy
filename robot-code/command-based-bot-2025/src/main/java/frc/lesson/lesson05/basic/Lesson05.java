package frc.lesson.lesson05.basic;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.lesson.LessonBase;

// TASK: Implement joystick deadband logic using if statements
// 1. Create an XboxController variable
// 2. Create a motor variable for testing
// 3. Read the left Y-axis value from the joystick
// 4. Use if/else to implement deadband:
//    - If joystick value is very small (< 0.1), set motor speed to 0
//    - Else, set motor speed to the joystick value
// 5. Print both joystick value and motor command to SmartDashboard
// 6. Explain: Why do we use deadband? (Hint: joystick drift and noise)
public class Lesson05 extends LessonBase {
    @Override
    public void execute() {
        // YOUR CODE HERE
    }
}
