package frc.lesson.lesson34.basic;

import edu.wpi.first.wpilibj.XboxController;
import frc.lesson.LessonBase;
// Uncomment once you've made frc/robot/commands/Intake.java.
// import frc.robot.commands.Intake;
// import frc.robot.subsystems.Fuel;

// LESSON 34 BASIC - Your first real command
// A subsystem is a THING the robot has. A command is something the robot DOES. WPILib's
// Command class is four empty methods and a promise about when each one runs, and you
// fill them in by overriding them - which is this lesson's Java idea, on a robot.
//
// THE FOUR, and when the scheduler calls them:
//   initialize()          once, the moment the command is scheduled
//   execute()             every loop after that, ~50 times a second
//   isFinished()          every loop, right after execute(). true means stop.
//   end(boolean)          once, when it stops. The boolean is TRUE if something
//                         cancelled it, FALSE if isFinished() said so.
//
// TASK:
// 1. Make frc/robot/commands/Intake.java:  public class Intake extends Command
//    (edu.wpi.first.wpilibj2.command.Command)
// 2. Its constructor takes your Fuel and keeps it, then says:
//      addRequirements(fuel);
//    That line is a claim: "while I run, I own the fuel mechanism." The scheduler enforces it.
// 3. Override all four:
//      initialize()  - reset a loop counter, publish "Intake/State" = "started"
//      execute()     - count the loop, call fuel.intake(), publish "Intake/Loops"
//      end(...)      - fuel.stop(), publish "Intake/State" = interrupted ? "interrupted"
//                      : "finished"
//      isFinished()  - return false. This one runs until somebody stops it.
// 4. Here: schedule it while the operator holds B (the 6 key), and cancel it when they
//    let go. No lambdas yet, so ask plainly:
//      if (operator.getBButton() && !intake.isScheduled()) { intake.schedule(); }
//      if (!operator.getBButton() && intake.isScheduled()) { intake.cancel(); }
// 5. Run it. Hold B for a second, let go, and read your log top to bottom.
//
// WHAT TO NOTICE: your log tells a story now. "started", then Loops climbing one per
// cycle, then "interrupted" - because you cancelled it, and isFinished() never said yes.
// PREDICT: how many loops for one second of holding B? Check.
//
// AND NOTICE WHAT ISN'T HERE: execute() is empty in the lesson. The robot is doing a thing
// you described somewhere else, and the lesson just says when.
public class Lesson34 extends LessonBase {
    // Declare your operator controller, your Fuel and your Intake command here.

    @Override
    public void setup() {
        // Runs ONCE, when the robot program starts.
    }

    @Override
    public void execute() {
        // Runs about 50 times a second while the robot is in Teleoperated.
    }
}
