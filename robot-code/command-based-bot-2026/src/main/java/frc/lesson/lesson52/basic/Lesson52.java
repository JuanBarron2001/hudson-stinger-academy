package frc.lesson.lesson52.basic;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.lesson.LessonBase;
// Uncomment once your commands exist.
// import frc.robot.commands.FuelFor;
// import frc.robot.subsystems.Fuel;

// LESSON 52 BASIC - Calling a command by its name
// Lesson 38 put commands in a dropdown. This one puts them in a phone book.
//
// Here is the problem a HashMap solves on a robot. PathPlanner autos are drawn in an app,
// not written in Java, and in that app you place a step called "Intake". The app has never
// heard of your Intake class - it only knows the WORD. Something has to turn that word into
// the actual command. That something is a Map<String, Command>.
//
// TASK:
// 1. Write a small command you can make several of. FuelFor(fuel, label, rollers, belt)
//    runs the two motors at the numbers you hand it and publishes its label.
// 2. Build the map in setup():
//      Map<String, Command> actions = new HashMap<>();
//      actions.put("Intake", new FuelFor(fuel, "Intake", -0.7, 0.8));
//      actions.put("Eject",  new FuelFor(fuel, "Eject",   0.9, 0.8));
//      actions.put("Shoot",  new FuelFor(fuel, "Shoot",  -0.72, -0.7));
//    Publish actions.size() and actions.keySet().
// 3. Put a "Lookup" string on the dashboard, and each loop:
//      Command found = actions.get(wanted);
//    Publish whether it was found, and run it while the operator holds B.
// 4. Run it. In the NetworkTables window, change "Lookup" between Intake, Eject and Shoot
//    and hold B each time. Measured: -67.9, +87.3 and -69.9 RPS on the rollers.
//    You are choosing robot behaviour by TYPING A WORD.
// 5. THE EXPERIMENT: set Lookup to "Intkae" - a plain typo - and hold B. PREDICT it first.
//    get() returns null, found is false, and nothing at all happens. No error. No crash.
//
// WHY A MAP AND NOT AN IF-CHAIN: you could write if (wanted.equals("Intake")) three times.
// Then the fourth action means editing that chain, and the tenth means reading twenty lines
// to find out what exists. A map's keySet() IS the list of what exists, and adding one is
// one line.
//
// WHY get() RETURNING null IS THE WHOLE LESSON: a Map will happily tell you it has never
// heard of something. On a robot, "never heard of it" arrives 3 seconds into autonomous.
// The extra half is how you find out beforehand.
public class Lesson52 extends LessonBase {
    // Declare your operator controller and your Map<String, Command> here.

    @Override
    public void setup() {
        // Runs ONCE, when the robot program starts.
    }

    @Override
    public void execute() {
        // Runs about 50 times a second while the robot is in Teleoperated.
    }
}
