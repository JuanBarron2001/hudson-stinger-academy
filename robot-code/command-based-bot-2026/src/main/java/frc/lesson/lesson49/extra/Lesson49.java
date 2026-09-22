package frc.lesson.lesson49.extra;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.lesson.LessonBase;

// LESSON 49 EXTRA - No name, no reuse, and then the short way
// Start from your basic, then:
//
// TASK:
// 1. Put intakeAction.getClass().getName() on SmartDashboard. Java made up a name like
//    frc.lesson.lesson49.extra.Lesson49$1, because you never gave the class one.
// 2. Hold both actions in an array:  private Runnable[] actions = new Runnable[2];
//    Fill it in setup() (0 = intake, 1 = eject) and pick a slot with the operator's buttons:
//      B held -> actions[0].run(),  left bumper held -> actions[1].run(),  otherwise stop
// 3. Put the index you ran on SmartDashboard, so the log shows which slot did what.
// 4. Write the intake action a SECOND way, as a lambda, and leave it in a comment:
//      // Runnable intakeAction = () -> { leftRoller.set(-0.7); rightRoller.set(0.7);
//      //                                 conveyor.set(0.8); };
//    Same object, four lines shorter. This is the shape every button binding uses.
//
// WHY CAN'T YOU REUSE AN ANONYMOUS CLASS? (there is no name to write new in front of)
public class Lesson49 extends LessonBase {
    // Declare your controller, your motors, and your Runnable[] here.

    @Override
    public void setup() {
        // Runs ONCE, when the robot program starts.
    }

    @Override
    public void execute() {
        // Runs about 50 times a second while the robot is in Teleoperated.
    }
}
