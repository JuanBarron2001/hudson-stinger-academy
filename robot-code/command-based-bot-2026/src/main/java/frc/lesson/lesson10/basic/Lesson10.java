package frc.lesson.lesson10.basic;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import com.ctre.phoenix6.hardware.TalonFX;
import frc.lesson.LessonBase;

// LESSON 10 BASIC - Build a Shuffleboard command parser for drive control
// Optional this offseason. This robot half hasn't been rebuilt for the 2026 robot yet,
// so LESSONS.md says "skip for now". The task below is the guide's current Part 2.
//
// TASK:
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
