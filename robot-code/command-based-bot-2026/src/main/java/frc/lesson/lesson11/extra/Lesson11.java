package frc.lesson.lesson11.extra;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.lesson.LessonBase;

// LESSON 11 EXTRA - Build an advanced multi-parameter Shuffleboard command parser
// Optional this offseason. This robot half hasn't been rebuilt for the 2026 robot yet,
// so LESSONS.md says "skip for now". The task below is the guide's current Part 2.
//
// TASK:
// 1. Get complex command strings with MULTIPLE colons (3+ parts)
//    Examples: "drivetrain:forward:0.5" or "apriltag:5:follow"
// 2. Parse in steps:
//    a) Find first ":" with indexOf(":") → extract subsystem
//    b) Use substring() from after first ":" and find next ":" → extract first param
//    c) Use substring() from after second ":" → extract second param
// 3. Handle "drivetrain" commands:
//    - drivetrain:forward:0.5 → drive forward at 50% speed
//    - drivetrain:backward:0.75 → drive backward at 75% speed
//    - drivetrain:stop:0 → stop all motors
// 4. Handle "apriltag" commands:
//    - apriltag:5:follow → find and follow AprilTag ID 5
//    - apriltag:12:ignore → see tag 12 but ignore it (don't track)
// 5. Log detailed parsing to SmartDashboard:
//    "Parsed: subsystem=drivetrain, direction=forward, speed=0.5 → EXECUTING"
// Challenge: What if a parameter itself contains a colon? How would you handle that?
public class Lesson11 extends LessonBase {
    @Override
    public void execute() {
    }
}
