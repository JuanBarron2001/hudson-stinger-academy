package frc.lesson.lesson21.basic;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.lesson.LessonBase;

// LESSON 21 BASIC - Why variables have been living up top
// Every lesson so far gave you fields up here. This time you declare them yourself.
//
// TASK:
// 1. In execute(): declare a LOCAL counter, add 1 to it, and put it on SmartDashboard:
//      int localCount = 0;
//      localCount++;
// 2. Up here (outside any method): declare a FIELD counter:  private int fieldCount = 0;
//    In execute(): add 1 to it and put it on SmartDashboard too.
// 3. Run for 5 seconds. What does each counter show? Explain why in a comment.
// 4. Now declare your OWN fields for the operator controller and both rollers,
//    create them in setup(), and run the rollers at 0.3 while A (the 5 key) is held.
// 5. Answer in a comment: what would go wrong if you created the rollers inside
//    execute() instead of setup()? (Hint: how many times does execute() run?)
//
// ANSWERS:
public class Lesson21 extends LessonBase {
    // Declare your fields here.

    @Override
    public void setup() {
        // Runs ONCE, when the robot program starts.
    }

    @Override
    public void execute() {
        // Runs about 50 times a second while the robot is in Teleoperated.
    }
}
