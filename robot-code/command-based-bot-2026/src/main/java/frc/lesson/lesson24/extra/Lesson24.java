package frc.lesson.lesson24.extra;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.lesson.LessonBase;

// LESSON 24 EXTRA - Search by mechanism name
// At home the operator is Keyboard 1: A = 5 key, B = 6 key, X = 7 key.
// Two arrays in the SAME ORDER: the index that matches the name is the index of its CAN ID.
//
// TASK:
// 1. Fields: canIds from the basic, plus the names in the same order:
//      private String[] mechanisms = {"left drive", "right drive", "left drive follower",
//                                     "right drive follower", "left roller", "right roller",
//                                     "climber", "conveyor"};
// 2. Also the operator controller, and a TalonFX[] built from canIds in setup() (lesson 22)
// 3. In execute(): the operator picks the target name.
//      B held -> "conveyor",  A held -> "climber",  X held -> "left drive",  otherwise ""
//    The target changes while the robot runs, so the search lives here, not in setup().
// 4. Search mechanisms with  mechanisms[i].equals(target)  -- NOT == -- and break when found
// 5. When found, put the name, the index, and canIds[i] on SmartDashboard.
//    When not found, put "<target> is not on this robot".
// 6. Use the index to reach the motor too: put motors[i]'s rotations on SmartDashboard.
//    Search for "left drive", hold W to drive, and watch that number move.
// 7. Try a name that isn't there, like "shooter". You should still get the message.
//
// WHY .equals() AND NOT == : (lesson 02's reference types)
public class Lesson24 extends LessonBase {
    // Declare your arrays, the controller, and the motors here.

    @Override
    public void setup() {
        // Runs ONCE, when the robot program starts.
    }

    @Override
    public void execute() {
        // Runs about 50 times a second while the robot is in Teleoperated.
    }
}
