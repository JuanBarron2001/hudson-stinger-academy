package frc.lesson.lesson16.basic;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.lesson.LessonBase;

// LESSON 16 BASIC - Pit check: is every motor there?
// Before a match, the pit crew checks every motor is talking on the CAN bus.
//
// TASK:
// 1. In execute(), use a boolean field so the check runs only on the FIRST loop:
//      if (!checked) { ...your for loop...  checked = true; }
// 2. Write a for loop that goes through CAN IDs 1 to 8. For each id:
//      TalonFX motor = new TalonFX(id);
//      put  "CAN " + id + " Connected"  =  motor.isConnected()  on SmartDashboard
// 3. Look up every ID in ROBOT.md. Which one comes back false, and why?
// 4. The conveyor is CAN 29. How would you check it without looping all the way to 29?
//    (Lesson 22's arrays make this clean.)
//
// ANSWERS:
public class Lesson16 extends LessonBase {
    // Variables declared up here keep their values between loops (lesson 21 explains why).
    private boolean checked = false;

    @Override
    public void setup() {
        // Runs ONCE, when the robot program starts.
    }

    @Override
    public void execute() {
        // Runs about 50 times a second while the robot is in Teleoperated.
    }
}
