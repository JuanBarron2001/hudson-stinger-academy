package frc.lesson.lesson05.extra;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.lesson.LessonBase;

// CHALLENGE: Implement advanced deadband with speed capping AND Limelight auto-targeting
// 1. Create an XboxController variable
// 2. Create a motor variable for testing (e.g., rotation motor)
// 3. OPTION A - Advanced Deadband with Speed Capping:
//    - Read left Y-axis from joystick
//    - Use if/else if/else to implement multi-threshold logic:
//      * If input < 0.1 → motor speed = 0 (deadband)
//      * Else if input > 0.8 → motor speed = 0.8 (speed cap for safety)
//      * Else → motor speed = input value
//    - Print joystick value and motor command to SmartDashboard
// 4. OPTION B - Limelight AprilTag Following (Real Match Strategy):
//    - Get horizontal offset (tx) from Limelight
//    - Use if/else if/else to turn toward target:
//      * If tx < -5 → turn left (motor speed = -0.5)
//      * Else if tx > 5 → turn right (motor speed = +0.5)
//      * Else → stop turning (motor speed = 0)
//    - Print tx offset and motor command to SmartDashboard
//    - Bonus: Use Math.abs() to handle deadband within this logic
public class Lesson05 extends LessonBase {
    @Override
    public void execute() {
        // YOUR CODE HERE
    }
}
