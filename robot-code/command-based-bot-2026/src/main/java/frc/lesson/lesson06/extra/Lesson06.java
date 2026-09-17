package frc.lesson.lesson06.extra;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.lesson.LessonBase;
import java.util.Random;

// CHALLENGE: Randomly determine if robot is "attracted" or "scared" of AprilTag at startup
// 1. Create a Random object
// 2. At initialization, use nextBoolean() to randomly pick behavior:
//    - If true → ATTRACTED: robot chases/follows the target tag
//    - If false → SCARED: robot runs away from the target tag
// 3. Store the selected behavior in a variable (should NOT change during operation)
// 4. During execute(), implement the selected behavior using Limelight tx (horizontal offset):
//    ATTRACTED mode:
//      - If tx > 0 (target is to the right) → turn right (positive motor speed)
//      - If tx < 0 (target is to the left) → turn left (negative motor speed)
//      - If tx ≈ 0 (target is centered) → move forward toward it
//    SCARED mode:
//      - If tx > 0 (target is to the right) → turn LEFT away from it (negative motor speed)
//      - If tx < 0 (target is to the left) → turn RIGHT away from it (positive motor speed)
//      - If tx ≈ 0 (target is centered) → move backward away from it
// 5. Print behavior mode ("ATTRACTED" or "SCARED"), target tag ID, and tx offset to SmartDashboard
// 6. Run the robot multiple times to see it either chase or flee based on random startup
public class Lesson06 extends LessonBase {
    @Override
    public void execute() {
        // YOUR CODE HERE
    }
}
