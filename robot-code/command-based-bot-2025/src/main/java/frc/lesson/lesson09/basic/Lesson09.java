package frc.lesson.lesson09.basic;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.lesson.LessonBase;

// TASK: Implement nested if logic for button-triggered targeting by alliance
// 1. Create an XboxController variable
// 2. Create a motor variable for testing
// 3. Get alliance color from DriverStation (RED or BLUE)
// 4. Get button press state from XboxController (e.g., getAButton())
// 5. Write nested if logic:
//    if (alliance == RED) {
//        if (buttonPressed) {
//            // Drive toward AprilTag
//        } else {
//            // Stop driving
//        }
//    } else {
//        if (buttonPressed) {
//            // Drive away from AprilTag
//        } else {
//            // Stop driving
//        }
//    }
// 6. Print to SmartDashboard: alliance color, button state, and action taken
// 7. Example: "RED | Button Pressed | TRACKING TAG"
public class Lesson09 extends LessonBase {
    @Override
    public void execute() {
        // YOUR CODE HERE
    }
}
