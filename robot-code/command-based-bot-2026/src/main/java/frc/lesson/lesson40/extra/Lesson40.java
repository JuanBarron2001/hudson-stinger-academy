package frc.lesson.lesson40.extra;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.lesson.LessonBase;
// Uncomment once Drivetrain has setPower() and resetPose().
// import frc.robot.subsystems.Drivetrain;

// LESSON 40 EXTRA - A setter that checks, and a minus sign worth arguing about
// A getter answers a question. A setter is the one place a value has to get past you
// before it reaches a motor, so it is the natural place to check it.
//
// TASK - part one, the setter:
// 1. Replace the raw motor calls in Drivetrain with:
//      public void setPower(double left, double right)
//    and have it CLAMP both values to the range -1.0 to 1.0 before passing them on.
// 2. Publish whether you clamped anything, so you can see it happen.
// 3. Here: on A (the Z key), call setPower(3.0, 3.0). On B (X key), setPower(-3.0, -3.0).
//    Both get clamped. The robot drives full forward, then full backward.
// 4. NOW THE MISTAKE TO AVOID. Change the clamp to 0.0 to 1.0 instead and press B again.
//    PREDICT it first. The robot cannot reverse. At all. Ever.
//    A clamp of 0..1 looks like "power is a percentage, percentages aren't negative", and
//    it quietly deletes half of what a drivetrain can do. Put -1.0 back.
//
// TASK - part two, the heading:
// 5. Last season's getHeading() is:
//      return Rotation2d.fromDegrees(-pigeon2.getYaw().getValueAsDouble());
//    Note the minus sign. Write yours WITHOUT it first.
// 6. Drive forward for two seconds, then turn right for about one second. Watch your
//    "Drive/Heading Deg" AND the "Sim Field" view at the same time.
// 7. Now add the minus sign and do exactly the same thing. PREDICT what changes.
// 8. What happens: without the minus, heading goes NEGATIVE turning right and the field
//    agrees. With it, heading goes POSITIVE while the robot still turns right - your
//    odometry now thinks the robot is somewhere it isn't, mirrored across the field.
//
// SO IS THE MINUS SIGN WRONG? In the simulator, yes, clearly. On the real robot, maybe not:
// the Pigeon is mounted on its side (ROBOT.md), and the competition code sets a mount pose
// to deal with that. The simulator doesn't reproduce the sideways mount, so it cannot settle
// this. What you HAVE proved is how to test it in ten seconds on the real robot: turn right,
// and see whether the heading agrees.
//
// ONE MORE THING WORTH NOTICING: after a hard turn your odometry says about 400 degrees and
// the field says about 429. Position matched almost exactly, but the turn lost 7%. Skidding
// sideways is invisible to a wheel encoder - it can only report rolling. That is why robots
// that care about where they are use a gyro for heading instead of the wheels.
public class Lesson40 extends LessonBase {
    // Declare your driver controller and your Drivetrain here.

    @Override
    public void setup() {
        // Runs ONCE, when the robot program starts.
    }

    @Override
    public void execute() {
        // Runs about 50 times a second while the robot is in Teleoperated.
    }
}
