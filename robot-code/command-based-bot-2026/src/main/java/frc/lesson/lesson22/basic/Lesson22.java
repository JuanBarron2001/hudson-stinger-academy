package frc.lesson.lesson22.basic;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.lesson.LessonBase;

// LESSON 22 BASIC - Every motor in one array
// Lesson 16 couldn't reach CAN 29 cleanly. Arrays fix that.
//
// TASK:
// 1. A field with every TalonFX CAN ID on the robot (ROBOT.md):
//      private int[] canIds = {1, 2, 3, 4, 5, 6, 7, 29};
// 2. A field for the motors, the same length:
//      private TalonFX[] motors = new TalonFX[canIds.length];
// 3. In setup(): a for loop over the indexes creates each motor from its ID
// 4. On the first loop only (like lesson 16): put "CAN <id> Connected" for every motor
// 5. Every loop: put each motor's rotations on SmartDashboard as "CAN <id> Rotations"
// 6. What happens if you read motors[8]? Try it, read the error, then remove it.
//
// WHAT HAPPENED IN STEP 6:
public class Lesson22 extends LessonBase {
    // Declare your arrays here.

    @Override
    public void setup() {
        // Runs ONCE, when the robot program starts.
    }

    @Override
    public void execute() {
        // Runs about 50 times a second while the robot is in Teleoperated.
    }
}
