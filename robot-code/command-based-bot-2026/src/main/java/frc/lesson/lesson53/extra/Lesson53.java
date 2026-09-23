package frc.lesson.lesson53.extra;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.lesson.LessonBase;
// Uncomment once BallPath exists.
// import frc.robot.BallPath;
// import frc.robot.subsystems.Fuel;

// LESSON 53 EXTRA - switch on it, then type pizza at it
// The Java half switched on a Day and then let the user type one in. Same two moves here,
// on the robot.
//
// TASK:
// 1. Switch on the path to say where the ball actually GOES. The numbers are in the enum;
//    the meaning isn't:
//      String destination = switch (path) {
//          case INTAKE -> "into the hopper";
//          case EJECT -> "back out the front";
//          case SHOOT, SHUTTLE -> "up and out of the launcher";
//      };
//    Publish it. Notice you wrote no default case - try deleting one of the three lines
//    and see what the compiler says. PREDICT it first.
// 2. Now let a human pick, the way the Java half used a Scanner. Read a "Paths/Wanted"
//    string off the dashboard and turn it into a path:
//      BallPath path = BallPath.valueOf(typed.toUpperCase());
//    The constants are all caps, so "shuttle" has to become "SHUTTLE" - same rule as
//    monday/MONDAY.
// 3. Type PIZZA_PATH into it. PREDICT what happens.
//    It throws IllegalArgumentException, exactly like "Pizza day" did. Catch it (lesson 45)
//    and publish a message a person can read, instead of letting the lesson die.
// 4. Run all three: SHOOT, shuttle, PIZZA_PATH. The first two work, the third says
//    "no such ball path: PIZZA_PATH" and the fuel mechanism stays still.
//
// NOW COMPARE IT WITH LESSON 52. Both let a human name a behaviour. The map's get() handed
// back null and the robot did nothing at all. The enum's valueOf() THREW, loudly, with the
// bad name in the message. Which failure would you rather debug at a competition? Write
// down when a Map is still the right answer anyway (hint: PathPlanner's step names are not
// known when you compile).
//
// ONE MORE ENUM: DriverStation.getAlliance() gives an alliance colour, and Alliance.Red
// and Alliance.Blue are enum constants too. Lesson 12 had you copy that line without
// explaining it - this is the lesson it was waiting for. The .orElse(...) part stays
// copied as-is, because the Java course doesn't teach Optional anywhere, and that is
// worth knowing rather than pretending otherwise.
public class Lesson53 extends LessonBase {
    // Declare your operator controller and your Fuel here.

    @Override
    public void setup() {
        // Runs ONCE, when the robot program starts.
    }

    @Override
    public void execute() {
        // Runs about 50 times a second while the robot is in Teleoperated.
    }
}
