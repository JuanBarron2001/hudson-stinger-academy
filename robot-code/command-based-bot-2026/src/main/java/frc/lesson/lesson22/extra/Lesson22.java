package frc.lesson.lesson22.extra;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.lesson.LessonBase;

// LESSON 22 EXTRA - Drive with arrays, and average the encoders
//
// TASK:
// 1. Two arrays of two motors each: leftMotors (CAN 1, 3) and rightMotors (CAN 2, 4)
// 2. Drive with your lesson 04 arcade drive, setting each side with an enhanced for loop:
//      for (TalonFX motor : leftMotors) motor.set(left);
//    (the right side still gets the opposite sign)
// 3. Average distance: add up the rotations of the LEFT motors with a loop and divide by
//    leftMotors.length, then turn that into meters (lesson 04)
// 4. Put the average distance in meters on SmartDashboard
// 5. Why divide by leftMotors.length instead of just writing 2? Answer in a comment.
//
// ANSWER:
public class Lesson22 extends LessonBase {
    // Declare your fields and arrays here.

    @Override
    public void setup() {
        // Runs ONCE, when the robot program starts.
    }

    @Override
    public void execute() {
        // Runs about 50 times a second while the robot is in Teleoperated.
    }
}
