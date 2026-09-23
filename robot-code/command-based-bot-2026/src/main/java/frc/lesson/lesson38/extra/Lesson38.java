package frc.lesson.lesson38.extra;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.lesson.LessonBase;
// Uncomment once your three autos exist.
// import frc.robot.commands.DoNothing;
// import frc.robot.commands.DriveForward;
// import frc.robot.commands.SpinUpAuto;

// LESSON 38 EXTRA - The same call, three different answers, and the bug that loses a match
//
// TASK - part one, an array of things that aren't the same:
// 1. Put your three autos in one array. Note the TYPE:
//      Command[] autos = { new DriveForward(drivetrain, 40), new SpinUpAuto(fuel),
//                          new DoNothing() };
//    Three different classes in one array, because all three ARE a Command.
// 2. Loop over it every cycle and publish, for each one:
//      SmartDashboard.putString("Autos/" + i + "/Name", autos[i].getName());
//      SmartDashboard.putBoolean("Autos/" + i + "/Finished", autos[i].isFinished());
// 3. Read your log. One line of code, written once, calling isFinished() - and you get
//    three different answers, because each class overrode it differently. DoNothing says
//    true forever. The other two say false until the robot has actually done something.
//
// TASK - part two, the bug:
// 4. Change  setDefaultOption  to  addOption,  so nothing is the default any more. Run it
//    again WITHOUT touching the dashboard, and press A.
// 5. PREDICT what happens first. Then look.
// 6. The robot sits there. 0.00 m. getSelected() returned null, your null check caught it,
//    and nothing ran. No crash, no error, no clue - which is exactly how this goes wrong
//    at a competition: the auto period just quietly doesn't happen.
// 7. Put setDefaultOption back and make sure your code still handles null anyway. Both
//    halves matter: a default so it works, and a null check so it never crashes.
//
// WHY THIS IS THE LESSON'S REAL POINT: polymorphism lets a dropdown hold four unrelated
// classes. That same flexibility means the box can also hold NOTHING, and the type system
// can't warn you, because null is a valid Command as far as the compiler is concerned.
//
// WORTH KNOWING: a chooser can hold autos you didn't write. Last season's holds three of
// the team's own command groups AND one built by PathPlanner from a drawn path - a class
// nobody on the team ever opened. It fits because it's a Command. That's lesson 45.
public class Lesson38 extends LessonBase {
    // Declare your driver controller, your chooser, and your Command[] here.

    @Override
    public void setup() {
        // Runs ONCE, when the robot program starts.
    }

    @Override
    public void execute() {
        // Runs about 50 times a second while the robot is in Teleoperated.
    }
}
