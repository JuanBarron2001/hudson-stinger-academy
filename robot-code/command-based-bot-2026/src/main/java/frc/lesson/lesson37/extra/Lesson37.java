package frc.lesson.lesson37.extra;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.lesson.LessonBase;
// Uncomment once FixedSpeed exists.
// import frc.robot.FixedSpeed;
// import frc.robot.TriggerAxis;
// import frc.robot.commands.DynamicClimb;
// import frc.robot.subsystems.Climber;

// LESSON 37 EXTRA - Prove the command doesn't care, then give it a limit
//
// TASK - part one, a second implementation:
// 1. Make frc/robot/FixedSpeed.java, also  implements DoubleSupplier.  It holds one number
//    and returns it from getAsDouble(). That's the entire class.
// 2. Build a SECOND DynamicClimb with it:
//      byTrigger = new DynamicClimb(climber, new TriggerAxis(driver));
//      byFixed   = new DynamicClimb(climber, new FixedSpeed(0.3));
//    Same command class, twice. One reads a trigger, one reads nothing at all.
// 3. Right trigger runs the first, A (the Z key) runs the second. Hold A and DON'T TOUCH
//    the trigger - the climber still moves, at a steady 0.3.
// 4. You changed DynamicClimb exactly zero times to make that work.
//
// TASK - part two, the limit:
// 5. Add UP_LIMIT_ROTATIONS = 365 to your climber constants (ROBOT.md), and make
//    DynamicClimb.isFinished() return  climber.getPosition() > UP_LIMIT_ROTATIONS.
// 6. Hold the trigger flat out for about eight seconds. PREDICT where it stops.
// 7. It does not stop at 365. It stops at about 411. isFinished() cuts the POWER at 365,
//    and a spinning climber keeps going for a while after that. A limit in software is a
//    request, not a wall - so the number you pick has to leave room for the coast.
//
// THE POINT OF THE WHOLE LESSON: an interface is a promise about ONE behaviour. DynamicClimb
// asked for "something that can give me a double" and got a trigger, a constant, and could
// just as easily get a dashboard value, a sensor, or an autonomous routine. It never has to
// know, and it never has to change.
//
// THE LAMBDA PREVIEW: TriggerAxis is eight lines to wrap one expression. Java has a shorter
// way to say the same thing:
//      new DynamicClimb(climber, () -> driver.getRightTriggerAxis())
// That is the exact line last season's code uses. It is a DoubleSupplier too - Java writes
// the class for you. Lesson 49 showed you the long way round; lesson 56 finishes it.
public class Lesson37 extends LessonBase {
    // Declare your driver controller, your Climber, and BOTH DynamicClimb commands here.

    @Override
    public void setup() {
        // Runs ONCE, when the robot program starts.
    }

    @Override
    public void execute() {
        // Runs about 50 times a second while the robot is in Teleoperated.
    }
}
