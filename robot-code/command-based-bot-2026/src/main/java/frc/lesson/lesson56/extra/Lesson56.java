package frc.lesson.lesson56.extra;

import frc.lesson.LessonBase;
// Uncomment once your RobotContainer (lesson 42) has its Trigger bindings.
// import frc.robot.RobotContainer;

// LESSON 56 EXTRA - ::, and buttons that bind themselves
//
// TASK:
// 1. Lesson 32's  new DifferentialDrive(leftLeader::set, rightLeader::set)  finally
//    explained: leftLeader::set means "the set method of leftLeader". In your Drivetrain,
//    write the same thing the long way as a comment:
//      // new DifferentialDrive(speed -> leftLeader.set(speed), speed -> rightLeader.set(speed));
// 2. Where :: stops working. Try  Runnable stopFuel = fuel::stop;  - it builds.
//    Now try  Runnable intakeNow = fuel::follow;  and PREDICT the error first.
//    follow needs a BallPath and a Runnable has nothing to give it. Use a lambda instead:
//      () -> fuel.follow(BallPath.INTAKE)
// 3. The reason all of this exists. In RobotContainer's CONSTRUCTOR (not update()):
//      new Trigger(operator::getBButton).whileTrue(new Intake(fuel));
//    Trigger takes a BooleanSupplier - "something that can give me a boolean". Then DELETE
//    lesson 34's two  if (...isScheduled()...)  lines from update().
// 4. Same for the climber:  new Trigger(() -> driver.getRightTriggerAxis() > 0.1)
//    .whileTrue(...) your DynamicClimb. Why does that one need a lambda and not :: ?
// 5. Here: make one RobotContainer in setup(). execute() calls container.update(), which
//    may be empty now - that's the point.
// 6. Run it. Hold B (the 6 key), then let go. Measured: Intake/State says "started", the
//    rollers reach -67.9 RPS; let go and it says "interrupted" and they drop to 0.0.
//    Lesson 34's log, and no isScheduled() anywhere.
//
// WHAT MUST whileTrue BE DOING INSIDE? It keeps your BooleanSupplier, asks it every loop,
// and does what your two if lines did. Write down your guess, then find the loop that
// asks: CommandScheduler.getInstance().run(), called every loop since lesson 32.
//
// WHY THE CONSTRUCTOR: a Trigger is built once and watches forever. Built in update(),
// you'd get a new one 50 times a second, each starting its own Intake.
//
// THE SHORTCUT: CommandXboxController builds these Triggers for you, so
// new Trigger(operator::getBButton) becomes operator.b(). The competition code uses it.
public class Lesson56 extends LessonBase {
    // Declare your RobotContainer here.

    @Override
    public void setup() {
        // Runs ONCE, when the robot program starts.
    }

    @Override
    public void execute() {
        // Runs about 50 times a second while the robot is in Teleoperated.
    }
}
