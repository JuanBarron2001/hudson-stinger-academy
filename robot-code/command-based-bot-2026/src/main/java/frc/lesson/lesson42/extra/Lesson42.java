package frc.lesson.lesson42.extra;

import frc.lesson.LessonBase;
// Uncomment once ShootAndClimb exists.
// import frc.robot.RobotContainer;

// LESSON 42 EXTRA - A command made out of commands, and the drivetrain changing hands
// Composition again, one level up. ShootAndClimb is not a new behaviour - it is three
// behaviours you already wrote, in order.
//
// TASK:
// 1. Make frc/robot/commands/ShootAndClimb.java:
//      public class ShootAndClimb extends SequentialCommandGroup
//    Its constructor takes all three subsystems and says only this:
//      addCommands(
//          new SpinUp(fuel),
//          new DriveForward(drivetrain, 40),
//          new ClimbUp(climber));
//    No execute(). No isFinished(). The group runs each one until it finishes, then starts
//    the next, and is finished when the last one is. Every piece already knew when it was
//    done - that is why lessons 34 and 38 made isFinished() do real work.
// 2. Bind it to the driver's A (the Z key) in RobotContainer.update().
// 3. Publish who currently owns the drivetrain: set a string in TeleopDrive's execute()
//    and a different one in its end().
// 4. Run it, then TAP A and stop touching the controls. Watch for about eight seconds.
// 5. PREDICT the order, and predict what happens to your teleop driving while it runs.
//
// WHAT YOU SHOULD SEE:
//    rollers spin up and stop  ->  drivetrain rolls to ~41 rotations  ->  climber rises
//    to ~380 and stops
// and, on the dashboard, "Drive/Owner" saying "handed over" for the whole sequence, then
// flipping back to "TeleopDrive" the moment it ends.
//
// NOBODY WROTE THAT HANDOVER. DriveForward requires the drivetrain, so scheduling the group
// interrupted TeleopDrive. When the group finished, the scheduler noticed the drivetrain was
// free and restarted its default command by itself. Try driving with the sticks in the middle
// of the sequence - you can't, and that is correct: an auto routine should not be fightable.
//
// THE SHAPE TO NOTICE: SpinUp, DriveForward and ClimbUp know nothing about each other, and
// ShootAndClimb adds no robot code at all - it only says the order. That is what makes a
// fourth auto cost three lines instead of a new file full of motor calls.
public class Lesson42 extends LessonBase {
    // Declare your RobotContainer here. Still the only field.

    @Override
    public void setup() {
        // Runs ONCE, when the robot program starts.
    }

    @Override
    public void execute() {
        // Runs about 50 times a second while the robot is in Teleoperated.
    }
}
