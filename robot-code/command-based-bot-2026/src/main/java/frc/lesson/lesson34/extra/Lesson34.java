package frc.lesson.lesson34.extra;

import edu.wpi.first.wpilibj.XboxController;
import frc.lesson.LessonBase;
// Uncomment once SpinUp exists and Fuel has spinUp().
// import frc.robot.Shot;
// import frc.robot.commands.Intake;
// import frc.robot.commands.SpinUp;
// import frc.robot.subsystems.Fuel;

// LESSON 34 EXTRA - A command that knows when it's done, and one that gets shoved aside
// Intake returns false from isFinished() forever. Most commands aren't like that. A
// command that spins the flywheel up is finished the moment the flywheel is at speed,
// and it's the only thing that can know that.
//
// TASK:
// 1. Add to Fuel:  public void spinUp(Shot shot)  - both rollers to shot.rollerPower and
//    the conveyor to 0. Rollers only. Nothing gets fed yet.
// 2. Make frc/robot/commands/SpinUp.java, taking a Fuel AND a Shot, with addRequirements(fuel).
//      initialize()  - reset the counter, publish "SpinUp/State" = "spinning up"
//      execute()     - fuel.spinUp(shot), count loops
//      isFinished()  - return fuel.atSpeed(shot);       <-- lesson 29's check, doing real work
//      end(...)      - fuel.stop(), publish "cancelled" or "reached speed"
// 3. Here: B still runs Intake. Add A (the 5 key) to schedule SpinUp - schedule only, no
//    cancel, because this one ends itself.
// 4. Run it and tap A. PREDICT what "SpinUp/State" ends up saying, and roughly how many
//    loops it takes. (In the simulator the rollers get there in well under half a second,
//    which is much faster than a real flywheel.)
// 5. THE EXPERIMENT: hold B to intake, and WHILE HOLDING IT, press A. Predict what your
//    log says before you look.
//
// WHAT YOU JUST SAW: Intake says "interrupted". You never cancelled it. The scheduler did,
// because both commands called addRequirements(fuel) and there is only one fuel mechanism.
// Instead of two commands fighting over the rollers - which is exactly lesson 27's bug -
// the newer one wins and the older one is told, properly, through end(true).
//
// THAT is what commands are for. Not the four methods: the fact that something is keeping
// track of who owns what, so two pieces of code can't quietly ruin each other.
//
// ONE MORE QUESTION: your SpinUp calls fuel.stop() in end(), so reaching speed immediately
// stops the rollers. Is that what you want right before a shot? Hold that thought - lesson
// 42 is where commands get joined together into a sequence.
public class Lesson34 extends LessonBase {
    // Declare your operator controller, your Fuel, and both commands here.

    @Override
    public void setup() {
        // Runs ONCE, when the robot program starts.
    }

    @Override
    public void execute() {
        // Runs about 50 times a second while the robot is in Teleoperated.
    }
}
