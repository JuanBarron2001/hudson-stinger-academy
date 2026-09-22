package frc.lesson.lesson49.basic;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.lesson.LessonBase;

// LESSON 49 BASIC - One robot action, in a class with no name
// At home the operator is Keyboard 1: B = 6 key, left bumper = 3 key.
// The powers are in ROBOT.md -> "Ball paths".
//
// TASK:
// 1. Fields: the operator controller, both rollers (CAN 5, 6), the conveyor (CAN 29),
//    and two Runnable fields: intakeAction and ejectAction
// 2. In setup(): create the motors FIRST, then the actions as anonymous classes:
//      intakeAction = new Runnable() {
//          @Override
//          public void run() {
//              leftRoller.set(-0.7);
//              rightRoller.set(0.7);   // the right roller gets the opposite sign
//              conveyor.set(0.8);
//          }
//      };
// 3. Do the same for ejectAction with the eject powers (rollers 0.9, conveyor 0.8)
// 4. In execute():
//      B held           -> intakeAction.run()
//      left bumper held -> ejectAction.run()
//      otherwise        -> set all three motors to 0
// 5. Put the name of the action you ran on SmartDashboard ("INTAKE", "EJECT", "STOP")
// 6. Also put leftRoller.getVelocity().getValueAsDouble() on SmartDashboard (lesson 07).
//    Intake and eject should turn the rollers opposite ways. Does the sign agree?
//
// NOTHING RUNS BY ITSELF: a Runnable is an object with a run() method, and you are the one
// calling it, from the robot's own loop. Lesson 50 shows what breaks when a thread calls it.
public class Lesson49 extends LessonBase {
    // Declare your controller, your motors, and your two Runnable fields here.

    @Override
    public void setup() {
        // Runs ONCE, when the robot program starts. Motors first, then the actions.
    }

    @Override
    public void execute() {
        // Runs about 50 times a second while the robot is in Teleoperated.
    }
}
