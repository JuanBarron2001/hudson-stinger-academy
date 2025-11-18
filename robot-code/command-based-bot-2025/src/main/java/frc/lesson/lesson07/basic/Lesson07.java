package frc.lesson.lesson07.basic;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.lesson.LessonBase;

// TASK: Use Math.max() and Math.min() to clamp joystick input within safe limits
// 1. Create an XboxController variable
// 2. Create a motor variable for testing
// 3. Read the left Y-axis value from joystick (-1.0 to 1.0)
// 4. Use Math.max() and Math.min() to clamp the value:
//    clampedSpeed = Math.max(-1.0, Math.min(1.0, joystickValue))
// 5. Send clamped value to motor
// 6. Print BOTH raw joystick value AND clamped value to SmartDashboard
// 7. Real-world reason: Motor controllers can't handle values outside [-1.0, 1.0]
//    This also protects from accidental out-of-range math operations
public class Lesson07 extends LessonBase {
    @Override
    public void execute() {
        // YOUR CODE HERE
    }
}
