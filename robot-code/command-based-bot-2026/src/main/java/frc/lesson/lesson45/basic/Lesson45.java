package frc.lesson.lesson45.basic;

import com.pathplanner.lib.config.RobotConfig;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.lesson.LessonBase;

// LESSON 45 BASIC - The file that might not be there
// Every exception you've written so far was about bad input - somebody typed "pizza" where
// a number belonged. On a robot the classic one is different: a FILE that was supposed to
// be deployed, and wasn't.
//
// PathPlanner keeps its robot settings in a file, src/main/deploy/pathplanner/settings.json,
// which gets copied onto the roboRIO when you deploy. RobotConfig.fromGUISettings() reads it.
// If it isn't there, that call throws, and it throws at STARTUP - before a match, not during.
//
// TASK:
// 1. In setup(), load the config inside a try:
//      RobotConfig config = RobotConfig.fromGUISettings();
//    and remember config.massKG. Without a try/catch this will not even compile if you
//    call it plainly - try it first and read what javac says.
// 2. Add the catch. In it, do NOT just print. Record three things a human can see:
//      autoReady = false;
//      status = "AUTO WILL NOT RUN: " + e.getClass().getSimpleName() + " - " + e.getMessage();
//      e.printStackTrace();       // for the mentor, in the console
// 3. In execute(), publish Auto/Ready (boolean), Auto/Status (string) and the mass.
// 4. Run it. It works: Ready is true, Status says "loaded", mass is 36.287 kg.
// 5. THE EXPERIMENT: rename src/main/deploy/pathplanner/settings.json to settings.json.bak
//    and run again. PREDICT what the dashboard says before you look.
// 6. You get:
//      Auto/Ready  false
//      Auto/Status AUTO WILL NOT RUN: FileNotFoundException - .../settings.json
//                  (No such file or directory)
//    Rename it back.
//
// WHY THE MESSAGE MATTERS: e.getMessage() here is the full path of the file it wanted. That
// is a stranger at 7am being told exactly which file to go find. Compare it to what a bare
// "something went wrong" would have given them.
//
// THE RULE THIS LESSON IS FOR: a catch block is not for making an error go away. It is for
// deciding WHO FINDS OUT and WHEN. Here the robot still drives - so let it drive, and make
// sure the one person who can fix it knows before the match instead of during it.
public class Lesson45 extends LessonBase {
    // Declare your autoReady flag, your status string and the mass here.

    @Override
    public void setup() {
        // Runs ONCE, when the robot program starts.
    }

    @Override
    public void execute() {
        // Runs about 50 times a second while the robot is in Teleoperated.
    }
}
