package frc.lesson.lesson05.extra;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.lesson.LessonBase;

// LESSON 05 EXTRA - Intake and eject with the operator's buttons
// The same rollers pull fuel in AND shoot it out; the conveyor picks where the ball goes.
// The numbers are in ROBOT.md -> "Ball paths".
// At home the operator controller is Keyboard 1: B is the 6 key, left bumper is the 3 key.
//
// TASK:
// 1. Create the operator controller:  operator = new XboxController(1);
// 2. Create the left roller (CAN 5), right roller (CAN 6) and conveyor (CAN 29)
// 3. if B is held (operator.getBButton())                          -> INTAKE:  rollers -0.7, conveyor +0.8
//    else if left bumper is held (operator.getLeftBumperButton())  -> EJECT:   rollers +0.9, conveyor +0.8
//    else                                                          -> STOPPED: everything 0
// 4. Put the mode ("INTAKE", "EJECT" or "STOPPED") on SmartDashboard, plus the left
//    roller's speed:  leftRoller.getVelocity().getValueAsDouble()
// 5. Hold B. Does the left roller actually spin? If it reads 0, check that BOTH rollers got
//    the same number: the two motors turn the same rollers, so if they disagree they fight
//    and nothing moves. (The drivetrain was the opposite case: two sides, two gearboxes.)
// 6. Hold B and the left bumper at the same time. Which one wins, and why?
//
// ANSWER TO STEP 6:
public class Lesson05 extends LessonBase {
    // Variables declared up here keep their values between loops (lesson 21 explains why).
    private XboxController operator;
    private TalonFX leftRoller;
    private TalonFX rightRoller;
    private TalonFX conveyor;

    @Override
    public void setup() {
        // Runs ONCE, when the robot program starts.
    }

    @Override
    public void execute() {
        // Runs about 50 times a second while the robot is in Teleoperated.
    }
}
