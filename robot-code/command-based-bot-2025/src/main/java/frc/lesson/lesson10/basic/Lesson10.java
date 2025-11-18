package frc.lesson.lesson10.basic;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.lesson.LessonBase;

// TASK: Build a Shuffleboard command parser for drive control
// 1. Create a SendableChooser or read a String from Shuffleboard (text field)
//    Note: You may need to set up a SendableChooser in your robot initialization
// 2. Read operator command string: "forward", "backward", "spin", "stop", etc.
// 3. Parse using string methods:
//    - .trim() to remove whitespace: "  forward  " -> "forward"
//    - .toLowerCase() to normalize case: "FORWARD" -> "forward"
//    - .contains() to check for keywords
// 4. Based on the command, execute robot actions:
//    - if contains "forward" -> drive forward (set motors positive)
//    - if contains "backward" -> drive backward (set motors negative)
//    - if contains "spin" -> rotate in place
//    - else -> stop all motors
// 5. Print to SmartDashboard:
//    "Operator Command: 'forward' -> DRIVING FORWARD"
// 6. Test with messy inputs to show trim() and toLowerCase() working
public class Lesson10 extends LessonBase {
    @Override
    public void execute() {
        // YOUR CODE HERE
    }
}
