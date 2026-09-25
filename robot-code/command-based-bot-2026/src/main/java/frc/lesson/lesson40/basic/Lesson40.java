package frc.lesson.lesson40.basic;

import edu.wpi.first.wpilibj.XboxController;
import frc.lesson.LessonBase;
// Uncomment once Drivetrain has its getters.
// import frc.robot.subsystems.Drivetrain;

// LESSON 40 BASIC - Close the doors, then open windows
// Since lesson 27 every field on your subsystems has been public, and lessons have reached
// straight through them:  drivetrain.leftLeader.getPosition().getValueAsDouble().  That is
// a lesson file knowing the robot has a motor called leftLeader, that it's a TalonFX, and
// that positions come in motor rotations. Change any one of those and every lesson breaks.
//
// TASK:
// 1. In Drivetrain, change every field from public to private. BUILD IT. Count the errors -
//    that list is every place something outside the class was reaching in.
// 2. Now add the getters, and notice they don't just hand the field back. They answer a
//    question in units the caller actually wants:
//      public double getLeftDistanceMeters()   leftLeader position x METERS_PER_MOTOR_ROTATION
//      public double getRightDistanceMeters()
//      public Rotation2d getHeading()          from the Pigeon on CAN 11
// 3. Add the odometry - the thing that turns "how far did each wheel go" into "where am I":
//      private final DifferentialDriveOdometry odometry;   built in the constructor from
//          getHeading(), getLeftDistanceMeters(), getRightDistanceMeters()
//      public Pose2d getPose()                 odometry.getPoseMeters()
//      public void resetPose(Pose2d pose)      odometry.resetPosition(...)
// 4. Update it once per loop in periodic(), then publish Pose X, Pose Y and Heading.
// 5. Put METERS_PER_MOTOR_ROTATION in Constants: (PI x 0.1524) / 10.71. Both numbers are
//    marked "not measured" in ROBOT.md, which matters in step 7.
// 6. Here: drive as usual. Hold W for two seconds.
// 7. Open the simulator's field view ("Sim Field") and compare. Your Pose X says about
//    5.56 m; the field says about 5.68 m. PREDICT which one a real robot would believe,
//    and why they differ at all.
//
// WHY THEY DIFFER: odometry is a guess built from wheel rotations. If the wheels slip even
// slightly, or the wheel diameter in Constants isn't the real one, the guess drifts. About
// 2% here - and 2% of a 15-second auto is the difference between scoring and missing.
//
// WHAT GETTERS BOUGHT YOU: your lesson now asks "where am I?" instead of "what does motor 1
// say?". You could swap every TalonFX for a different motor tomorrow and nothing outside
// Drivetrain would notice.
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
