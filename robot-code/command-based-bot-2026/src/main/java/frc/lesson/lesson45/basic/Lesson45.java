package frc.lesson.lesson45.basic;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.lesson.LessonBase;

// LESSON 45 BASIC - Bad sensor values don't crash the robot
// This robot half hasn't been rebuilt for the 2026 robot yet ("Not yet" in LESSONS.md).
// The task below is the guide's current Part 2, and it will change.
//
// TASK:
// 1. Parse a sensor value from a String with Integer.parseInt, inside a try
// 2. Use an invalid value like "abc", catch the NumberFormatException, and put an error
//    message on SmartDashboard instead of crashing
public class Lesson45 extends LessonBase {
    @Override
    public void execute() {
        //SmartDashboard.putString("Testing SmartDashboard", "Hello From SmartDashboard: ");
    }
}
