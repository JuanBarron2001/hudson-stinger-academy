package frc.lesson.lesson45.extra;

import com.pathplanner.lib.config.RobotConfig;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.lesson.LessonBase;

// LESSON 45 EXTRA - Three ways to "handle" it, and only one of them is honest
// Catching an exception is easy. Deciding what happens next is the actual job. Write all
// three, run each with settings.json renamed away, and write down what a drive team would
// experience in each case.
//
// TASK:
// 1. VERSION A - don't catch it at all. Delete the try/catch and let setup() throw.
//    Run it. The lesson never starts: LessonLoader prints "was found but crashed while
//    starting up" and a stack trace, and nothing you wrote runs.
//    Drive team experience: the robot is dead. Obvious, immediate, unmissable, useless.
// 2. VERSION B - catch it and move on quietly:
//      catch (Exception e) { e.printStackTrace(); return; }
//    Run it. The robot boots. The dashboard looks completely normal. Your teleop code works.
//    Drive team experience: everything is fine, right up until autonomous does nothing and
//    you have 15 seconds to work out why. This is the version most teams ship.
// 3. VERSION C - the one from the basic half. Catch it, keep the robot usable, and SAY SO
//    loudly on the dashboard where someone will see it before the match.
// 4. Now try to catch the RIGHT exception. Change  catch (Exception e)  to
//      catch (IOException e)
//    PREDICT whether it compiles. It does NOT, and the error is the whole point:
//      unreported exception org.json.simple.parser.ParseException; must be caught or
//      declared to be thrown
//    fromGUISettings() can fail TWO ways, and catching Exception was quietly covering both
//    without you ever learning the second one existed.
// 5. So find out what the second one is for. IOException means the file ISN'T THERE.
//    ParseException means it IS there and isn't valid JSON. Open settings.json, delete one
//    closing brace, and run it. Different exception, completely different fix - and a
//    message that says so.
//    Catch them properly, either as two catch blocks or as  catch (IOException |
//    ParseException e).  Put the brace back.
// 6. Add a finally block that publishes "Auto/Check Finished" = true. Run it BOTH ways -
//    file present and file missing. PREDICT whether finally runs when the catch runs.
//
// TASK - part two, the numbers that disagree:
// 7. Publish config.massKG next to the robot mass the simulator uses. settings.json says
//    36.287 kg. frc/sim/RobotSim.java says 55 kg, marked "estimate". ROBOT.md says the
//    gear ratio and track width were never measured either.
// 8. settings.json also has driveCurrentLimit 33.0, while your Constants and last season's
//    code both use 60 A. Same robot. Three files. Different numbers.
// 9. Write down which number you would trust, and how you would settle it with a scale, a
//    tape measure and twenty minutes at a meeting. That answer is worth more than this
//    lesson.
//
// THE BIG IDEA: an exception is the program telling you it cannot keep its promise. Your
// only real choice is whether that message reaches a human in time to matter.
public class Lesson45 extends LessonBase {
    // Declare your fields here.

    @Override
    public void setup() {
        // Runs ONCE, when the robot program starts.
    }

    @Override
    public void execute() {
        // Runs about 50 times a second while the robot is in Teleoperated.
    }
}
