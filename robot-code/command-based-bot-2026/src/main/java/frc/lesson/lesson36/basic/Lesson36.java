package frc.lesson.lesson36.basic;

import edu.wpi.first.wpilibj.XboxController;
import frc.lesson.LessonBase;
// Uncomment once FuelAction exists and Intake extends it.
// import frc.robot.commands.Eject;
// import frc.robot.commands.Intake;
// import frc.robot.subsystems.Fuel;

// LESSON 36 BASIC - The thing you've been doing since lesson 01
// Open frc/lesson/LessonBase.java. Find this line:
//
//     public abstract void execute();
//
// No body. No code. Just a promise that every lesson HAS one. That is why the very first
// thing you ever wrote on this robot was an @Override execute() - LessonBase couldn't run
// without it, and it refused to be a lesson on its own.
//
// Command works the same way. So does SubsystemBase. You've been standing on abstract
// classes for 35 lessons. Now build one.
//
// THE PROBLEM IT SOLVES: your Intake command is about 25 lines. An Eject command would be
// the same 25 lines with two numbers changed. Write both and you have two copies of a
// lifecycle to keep in step forever.
//
// TASK:
// 1. Make frc/robot/commands/FuelAction.java:
//      public abstract class FuelAction extends Command
//    It holds EVERYTHING that intake and eject agree on:
//      - a constructor taking Fuel, storing it, calling addRequirements(fuel)
//      - initialize()  publishes "Action/Running" = getName()
//      - execute()     fuel.setRollers(rollerPower());  fuel.setConveyor(conveyorPower());
//      - end(...)      fuel.stop(), publish "none"
//      - isFinished()  return false
// 2. And it holds two methods with NO BODY - the part each action has to answer itself:
//      protected abstract double rollerPower();
//      protected abstract double conveyorPower();
// 3. Add setRollers(double) and setConveyor(double) to Fuel if they aren't there yet.
// 4. Rewrite Intake as  public class Intake extends FuelAction.  Constructor calls
//    super(fuel). Then just answer the two questions: -0.7 and 0.8. That's the whole file.
// 5. Write Eject the same way: 0.9 and 0.8 (ROBOT.md).
// 6. Here: B runs Intake, left bumper runs Eject (the 6 and 3 keys).
// 7. Run both and check the rollers. Intake should read about -68, eject about +87.
//
// WHAT TO NOTICE: "Action/Running" says Intake or Eject, and you never typed either word
// as a String. getName() came from Command, and it knows which subclass it's inside.
//
// WHY ABSTRACT AND NOT JUST A NORMAL PARENT: because  new FuelAction(fuel)  is meaningless.
// There's no such thing as a generic fuel action - it would have no numbers. Marking the
// class abstract makes the compiler agree with you. Try it in the extra half.
public class Lesson36 extends LessonBase {
    // Declare your operator controller, your Fuel, and your two commands here.

    @Override
    public void setup() {
        // Runs ONCE, when the robot program starts.
    }

    @Override
    public void execute() {
        // Runs about 50 times a second while the robot is in Teleoperated.
    }
}
