package frc.lesson.lesson09.extra;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.PowerDistribution;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.lesson.LessonBase;

// CHALLENGE: Implement multi-level nested logic for smarter alliance-based strategy
// 1. Create an XboxController variable
// 2. Create motor variables for testing
// 3. Get alliance color, button press, and battery voltage (PowerDistribution.getVoltage() or similar)
// 4. Build deeply nested logic:
//    if (alliance == RED) {
//        if (buttonPressed) {
//            if (batteryGood) {
//                // Drive toward tag at FULL speed
//            } else {
//                // Drive toward tag at HALF speed
//            }
//        } else {
//            // Stop
//        }
//    } else { // BLUE
//        if (buttonPressed) {
//            if (distanceToTag < 2.0) {
//                // Stop (already close to tag)
//            } else {
//                // Drive toward tag
//            }
//        } else {
//            // Stop
//        }
//    }
// 5. Print decision logic to SmartDashboard for debugging during match
// 6. Example: "BLUE | Button Pressed | CloseToTag | STOP" or "RED | Button | GoodBatt | FULL_TRACK"
// 7. This multi-level nesting shows why the logic matters in real match scenarios!
public class Lesson09 extends LessonBase {
    @Override
    public void execute() {
        // YOUR CODE HERE
    }
}
