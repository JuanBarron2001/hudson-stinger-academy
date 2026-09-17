package frc.lesson.lesson26.extra;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.lesson.LessonBase;

// LESSON 26 EXTRA - Blend between rows (linear interpolation)
// "Closest row" jumps from -60 to -75 all at once. Real shots want something smooth.
//
// TASK:
// 1. Start from your basic half
// 2. Find the two rows the distance falls BETWEEN (row i and row i + 1)
// 3. fraction = (distance - lowDistance) / (highDistance - lowDistance)
//    speed    = lowSpeed + fraction * (highSpeed - lowSpeed)
// 4. Below the first row, use the first row's speed. Above the last row, use the last.
// 5. Put the blended speed on SmartDashboard, and try 30, 52.5, 75, 100 and 500
// 6. Bonus: while the operator's A (the 5 key) is held, spin the rollers toward that speed
//    and show whether they're at speed (lesson 07). Roughly, power = speed / 97 in the sim.
public class Lesson26 extends LessonBase {
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
