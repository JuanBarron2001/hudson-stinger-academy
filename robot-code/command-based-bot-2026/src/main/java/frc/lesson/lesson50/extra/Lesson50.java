package frc.lesson.lesson50.extra;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.lesson.LessonBase;

// LESSON 50 EXTRA - Run last season's "Just Shoot" auto by hand
// One timer, three phases, no threads. The powers are in ROBOT.md -> "Ball paths".
//
// TASK:
// 1. Fields: a Timer, both rollers (CAN 5, 6) and the conveyor (CAN 29)
// 2. In setup(): create the motors and timer.restart()
// 3. In execute(), pick the phase from timer.get():
//      under 1.0s        -> rollers at your lesson 07 shooting power, conveyor 0   ("SPIN UP")
//      1.0s up to 5.0s   -> rollers still going, conveyor -0.7                     ("LAUNCH")
//      5.0s and after    -> all three motors 0                                     ("DONE")
//    (both rollers get the same number: they turn the same rollers)
// 4. Put the phase name and timer.get() on SmartDashboard every loop, so your log reads
//    like a timeline of the auto
// 5. Read commands/auto/JustShoot.java in Part 3. It does the same thing with one
//    .withTimeout() per step and no clock arithmetic at all.
//
// WHICH VERSION WOULD YOU RATHER EDIT THE DAY BEFORE A MATCH?
public class Lesson50 extends LessonBase {
    // Declare your timer and motors here.

    @Override
    public void setup() {
        // Runs ONCE, when the robot program starts.
    }

    @Override
    public void execute() {
        // Runs about 50 times a second while the robot is in Teleoperated.
    }
}
