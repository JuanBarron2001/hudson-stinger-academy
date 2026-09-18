package frc.lesson.lesson45.extra;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.lesson.LessonBase;

// LESSON 45 EXTRA - finally runs either way
// This robot half hasn't been rebuilt for the 2026 robot yet ("Not yet" in LESSONS.md).
// The task below is the guide's current Part 2, and it will change.
//
// TASK:
// 1. Parse a speed from a String (Double.parseDouble), inside a try. Don't use a Scanner:
//    robot code has no keyboard, and waiting for one freezes the robot loop.
// 2. Catch NumberFormatException and put an error on SmartDashboard
// 3. In finally, put a status message on SmartDashboard. Try "0.75", then "fast":
//    finally runs both times.
public class Lesson45 extends LessonBase {
    @Override
    public void execute() {
        //SmartDashboard.putString("Testing SmartDashboard", "Hello From SmartDashboard: ");
    }
}
