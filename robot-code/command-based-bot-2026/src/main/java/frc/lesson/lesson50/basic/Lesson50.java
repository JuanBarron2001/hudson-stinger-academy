package frc.lesson.lesson50.basic;

// Careful: this is WPILib's Timer, a stopwatch you read. Part 1's java.util.Timer brings
// its own thread with it, and that does NOT belong in robot code.
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.lesson.LessonBase;

// LESSON 50 BASIC - A stopwatch on the robot's own loop
// execute() already runs about 50 times a second, so nothing needs to call you.
// At home the operator is Keyboard 1: A = 5 key.
//
// TASK:
// 1. Fields: a Timer, and the operator controller
// 2. In setup(): timer.restart()
// 3. In execute(): put timer.get() on SmartDashboard as the seconds since start
// 4. Put a status next to it (lesson 05's if):
//      under 2 seconds -> "WAITING",  2 seconds or more -> "READY"
// 5. A held -> timer.restart(), and watch the seconds go back to zero
//
// WHY NOT java.util.Timer HERE: a TimerTask runs on a SECOND thread, so it can touch a motor
// at the same moment the robot loop does, and it keeps running after your lesson stops.
public class Lesson50 extends LessonBase {
    // Declare your timer and controller here.

    @Override
    public void setup() {
        // Runs ONCE, when the robot program starts.
    }

    @Override
    public void execute() {
        // Runs about 50 times a second while the robot is in Teleoperated.
    }
}
