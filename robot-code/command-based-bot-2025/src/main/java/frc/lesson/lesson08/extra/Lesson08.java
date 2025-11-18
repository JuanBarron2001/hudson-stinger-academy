package frc.lesson.lesson08.extra;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Timer;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.lesson.LessonBase;

// CHALLENGE: Build a match data logger with formatted telemetry output
// 1. Create an XboxController and motor controller variables
// 2. Create a Timer to track match time
// 3. Every 100ms (or on a periodic method), log the following data:
//    - Timestamp (milliseconds since enable): use Timer.getFPGATimestamp()
//    - Joystick inputs: left X/Y, right X/Y (each %+.2f)
//    - Motor speeds: left wheel, right wheel (each %+.2f)
//    - Distance to AprilTag: from Limelight (%.1f)
// 4. Use printf to format as an aligned table:
//    Time(ms) | LX     LY     RX     RY     | LeftW  RightW | TagDist
//    1250     | -0.25  +0.75  +0.50  -0.12  | +0.60  +0.65  | 24.5
// 5. Print to console (System.out.printf) or optionally to a file
// 6. Use consistent width and precision so the log is easy to read
// 7. This data is valuable for post-match analysis and debugging!
// Hint: You may need a counter to print every Nth call to avoid spamming console
public class Lesson08 extends LessonBase {
    @Override
    public void execute() {
        // YOUR CODE HERE
    }
}
