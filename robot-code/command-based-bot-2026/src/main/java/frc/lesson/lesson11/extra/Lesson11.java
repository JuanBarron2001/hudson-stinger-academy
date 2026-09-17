package frc.lesson.lesson11.extra;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.lesson.LessonBase;

public class Lesson11 extends LessonBase {
    @Override
    public void execute() {
        // TASK: Build an advanced multi-parameter Shuffleboard command parser
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
    }
}
