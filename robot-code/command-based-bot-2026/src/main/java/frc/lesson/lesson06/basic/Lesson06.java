package frc.lesson.lesson06.basic;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.lesson.LessonBase;
import java.util.Random;

// LESSON 06 BASIC - Use Random to select a target AprilTag at startup, then track it deterministically
// Optional this offseason. This robot half hasn't been rebuilt for the 2026 robot yet,
// so LESSONS.md says "skip for now". The task below is the guide's current Part 2.
//
// TASK:
// 1. Create a Random object
// 2. Generate a random AprilTag ID (1-16) once at robot initialization
// 3. Store this ID in a variable (should NOT change during operation)
// 4. During execute(), use Limelight to search for that specific tag
// 5. Print the target tag ID and detection status to SmartDashboard
// 6. Key insight: Randomness is ONLY used at startup; runtime behavior is deterministic
// Hint: You may need to use Limelight's pipeline or filtering to look for a specific tag
public class Lesson06 extends LessonBase {
    @Override
    public void execute() {
        // YOUR CODE HERE
    }
}
