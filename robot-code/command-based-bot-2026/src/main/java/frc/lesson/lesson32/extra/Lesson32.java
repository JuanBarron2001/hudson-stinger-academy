package frc.lesson.lesson32.extra;

import edu.wpi.first.wpilibj.XboxController;
import frc.lesson.LessonBase;
// Uncomment once both classes extend SubsystemBase.
// import frc.robot.subsystems.Drivetrain;
// import frc.robot.subsystems.Fuel;

// LESSON 32 EXTRA - Do it again, then count what one word bought you
// This is the end of the drivetrain-and-fuel unit. After this lesson your robot has two
// real subsystems, and lesson 34 can finally write a command.
//
// TASK:
// 1. Make Fuel extend SubsystemBase too.
// 2. Move ALL of Fuel's telemetry into its own periodic(): the name, the last action, the
//    roller speed. Group the keys with a prefix, "Fuel/..." and "Drive/...", the way last
//    season's code does.
// 3. Here: drive AND intake at the same time - sticks for the drivetrain, the operator's B
//    for the intake. Your execute() should be about four lines and mention no motors.
// 4. Run it. Hold W and B together: you drive while intaking, both periodic()s keep
//    publishing, and "Fuel/Name" says Fuel while "Drive/Name" says Drivetrain. Neither
//    name is a String you typed.
// 5. THE EXPERIMENT: delete  extends SubsystemBase  from Fuel and try to run it.
//    PREDICT both things that go wrong before you do it.
//
// NOW COUNT. For the one word  extends SubsystemBase,  every subsystem got:
//   - periodic(), called for you every loop, in teleop AND when disabled
//   - getName(), already correct
//   - registration with the CommandScheduler, which is how periodic() gets called
//   - setDefaultCommand(), which does nothing yet and is the whole point of lesson 34
// You wrote none of it. That is what inheritance is: a parent that already did the boring
// part, and a child that only says what's different.
//
// WHERE YOUR TELEMETRY LIVES NOW: in the subsystem, not the lesson. A subsystem that reports
// on itself keeps reporting no matter who is driving it - your lesson today, a command
// tomorrow. That's why the move matters more than it looks.
public class Lesson32 extends LessonBase {
    // Declare your two controllers, your Drivetrain and your Fuel here.

    @Override
    public void setup() {
        // Runs ONCE, when the robot program starts.
    }

    @Override
    public void execute() {
        // Runs about 50 times a second while the robot is in Teleoperated.
    }
}
