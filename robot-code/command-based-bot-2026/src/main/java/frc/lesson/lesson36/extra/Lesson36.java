package frc.lesson.lesson36.extra;

import edu.wpi.first.wpilibj.XboxController;
import frc.lesson.LessonBase;
// Uncomment once Shuttle exists.
// import frc.robot.commands.Eject;
// import frc.robot.commands.Intake;
// import frc.robot.commands.Shuttle;
// import frc.robot.subsystems.Fuel;

// LESSON 36 EXTRA - Collect on it
// An abstraction is only worth anything if the NEXT one is cheap. So add a third action
// and count the lines.
//
// TASK:
// 1. Make frc/robot/commands/Shuttle.java. Shuttle is the long pass across the field:
//    rollers -0.93, conveyor -0.7 (ROBOT.md). Write it before you read the next line.
// 2. It should be a constructor calling super(fuel) and two one-line methods. About five
//    lines of actual code. Last season's equivalent file is 57 lines - see Part 3.
// 3. Here: B intakes, left bumper ejects, right bumper shuttles (the 6, 3 and 4 keys).
// 4. Run all three and write down the roller and conveyor speeds for each. They should be
//    clearly different: about -68/+78, then +87/+78, then -90/-68.
// 5. THE EXPERIMENT: add this line to setup() and try to build:
//      FuelAction whatever = new FuelAction(fuel);
//    PREDICT what happens. Read the error - it is one of the clearest in Java.
// 6. Now the other half of the same idea. In FuelAction, delete the word abstract from
//    rollerPower() so it looks like  protected double rollerPower();  and build again.
//    Then give it a body instead:  { return 0; }  and build again. Three different errors
//    or non-errors, and each one tells you something about what abstract actually means.
//
// WHAT ABSTRACT MEANS, in one sentence: this class is half a class, and the compiler will
// not let anyone pretend otherwise.
//
// THE BIGGER PICTURE: you are now on BOTH sides of abstraction in the same file. Your
// lesson extends LessonBase and fills in execute(). Your commands extend FuelAction and
// fill in rollerPower(). Same deal, and somebody wrote LessonBase for you before you knew
// what it was.
public class Lesson36 extends LessonBase {
    // Declare your operator controller, your Fuel, and your three commands here.

    @Override
    public void setup() {
        // Runs ONCE, when the robot program starts.
    }

    @Override
    public void execute() {
        // Runs about 50 times a second while the robot is in Teleoperated.
    }
}
