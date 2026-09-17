package frc.lesson.lesson07.basic;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.lesson.LessonBase;

// LESSON 07 BASIC - Is the flywheel at speed?
// Before the robot shoots, the rollers have to be spinning at the right speed.
// At home the operator is Keyboard 1: A is the 5 key.
//
// TASK:
// 1. Create the operator controller (port 1) and both rollers (CAN 5 and 6)
// 2. While A is held, run the rollers at a power you pick (negative launches;
//    the right roller gets the opposite sign, like lesson 05). Otherwise stop them.
// 3. target = -70         (the short shot, in rotations per second, from ROBOT.md)
//    actual = leftRoller.getVelocity().getValueAsDouble()
//    error  = target - actual
// 4. atSpeed = Math.abs(error) < 3
//    (Math.abs throws away the minus sign: 5 away is 5 away, above OR below)
// 5. Put target, actual, error and atSpeed on SmartDashboard
// 6. Find a power that makes atSpeed true. List every power you tried and what happened.
//
// POWERS I TRIED:
public class Lesson07 extends LessonBase {
    // Variables declared up here keep their values between loops (lesson 21 explains why).
    private XboxController operator;
    private TalonFX leftRoller;
    private TalonFX rightRoller;

    @Override
    public void setup() {
        // Runs ONCE, when the robot program starts.
    }

    @Override
    public void execute() {
        // Runs about 50 times a second while the robot is in Teleoperated.
    }
}
