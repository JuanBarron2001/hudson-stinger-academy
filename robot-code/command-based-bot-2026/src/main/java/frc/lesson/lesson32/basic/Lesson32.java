package frc.lesson.lesson32.basic;

import edu.wpi.first.wpilibj.XboxController;
import frc.lesson.LessonBase;
// Uncomment once Drivetrain extends SubsystemBase.
// import frc.robot.subsystems.Drivetrain;

// LESSON 32 BASIC - Drivetrain extends SubsystemBase
// One word, and your class inherits a pile of machinery WPILib already wrote. You have
// actually been on the receiving end of this since lesson 01: every lesson you've written
// says  extends LessonBase,  which is where setup() and execute() come from.
//
// TASK:
// 1. In Drivetrain.java:  public class Drivetrain extends SubsystemBase
//    (edu.wpi.first.wpilibj2.command.SubsystemBase)
// 2. Add a periodic() method with @Override, and move your telemetry into it:
//      @Override
//      public void periodic() {
//          SmartDashboard.putNumber("Drive/Left Rotations", ...);
//          SmartDashboard.putString("Drive/Name", getName());
//      }
//    You never call periodic(). The CommandScheduler does, every single loop, because
//    SubsystemBase registered your drivetrain the moment you built it.
// 3. getName() is not a method you wrote. It came with the parent, and it returns
//    "Drivetrain" - the parent worked the name out from the class.
// 4. Now replace your arcade math with WPILib's:
//      drive = new DifferentialDrive(leftLeader::set, rightLeader::set);   // in the constructor
//      drive.arcadeDrive(forward * forwardScale, turn * turnScale);        // in arcade()
//    The  ::  is a method reference. Read it as "the set method of leftLeader". The lambdas
//    lesson explains it properly; for now copy the pattern.
// 5. Here: execute() is now TWO lines - read the sticks, call arcade(). That's all.
// 6. Run it and hold W for two seconds. You'll go about 3.9 m. Lesson 29 went 5.4 m with
//    the SAME numbers. PREDICT why before you read on.
// 7. THE ANSWER: arcadeDrive SQUARES your input by default, so 0.7 becomes 0.49. It's meant
//    to give finer control near the middle of the stick. Turn it off with a third argument:
//      drive.arcadeDrive(forward * forwardScale, turn * turnScale, false);
//    and you're back to 5.4 m. Decide which one you want on this robot, and write down why.
public class Lesson32 extends LessonBase {
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
