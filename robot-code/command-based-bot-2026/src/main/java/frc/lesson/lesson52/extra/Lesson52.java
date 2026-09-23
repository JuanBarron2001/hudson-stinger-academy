package frc.lesson.lesson52.extra;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.lesson.LessonBase;
// Uncomment once the basic half works.
// import com.pathplanner.lib.auto.NamedCommands;
// import frc.robot.subsystems.Fuel;

// LESSON 52 EXTRA - Hand your map to PathPlanner, then check it before the match
// Your map and PathPlanner's are the same idea, and PathPlanner will take yours whole:
//
//      NamedCommands.registerCommands(actions);     // takes a Map<String, Command>
//
// That one line is why you built a map instead of an if-chain. The library's API IS a map,
// because the problem IS a map.
//
// TASK:
// 1. Call NamedCommands.registerCommands(actions) in setup(), passing the map from the
//    basic half. No loop, no copying.
// 2. Now write the check that the basic half's typo needed. PathPlanner can tell you
//    whether a name is registered:
//      NamedCommands.hasCommand("Intake")
//    Make a String[] of every name your autos actually use - "Intake", "Eject", "Shoot",
//    "ClimbUp" - and publish hasCommand() for each one at startup.
// 3. Run it. PREDICT the four answers before you look.
//      Intake  true
//      Eject   true
//      Shoot   true
//      ClimbUp FALSE   <- the auto needs it, and nobody ever registered it
// 4. Publish one summary boolean too - "Autos/All Names Registered" - that is true only if
//    every name passed. That single value is the thing a mentor can check in two seconds
//    before a match.
// 5. Add a climb command to the map and watch it go true.
//
// WHY THIS IS THE MOST USEFUL CODE IN THE UNIT: a missing named command does not crash
// anything. PathPlanner just skips that step, the robot drives its path, does nothing where
// the intake should have been, and everybody argues about the intake hardware afterwards.
// Six lines at startup turns that into a red boolean on the dashboard.
//
// LOOK AT WHAT YOU'VE NOW DONE THREE TIMES: lesson 34's tuning slider that was never
// published, lesson 38's dropdown with no name, and now a named command with nothing behind
// it. Same failure every time - the code is fine, and a person finds out too late. This
// time you wrote the thing that tells them.
//
// ONE MORE MAP, IF YOU WANT IT: keys don't have to be Strings. A Map<Double, Double> of
// distance -> roller speed is lesson 26's shot table again. Ask yourself why that one is
// AWKWARD as a map (what happens at a distance that isn't a key?) and what lesson 26's
// closest-row loop was really doing.
public class Lesson52 extends LessonBase {
    // Declare your map and the names your autos use here.

    @Override
    public void setup() {
        // Runs ONCE, when the robot program starts.
    }

    @Override
    public void execute() {
        // Runs about 50 times a second while the robot is in Teleoperated.
    }
}
