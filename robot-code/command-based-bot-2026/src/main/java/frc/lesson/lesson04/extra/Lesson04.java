package frc.lesson.lesson04.extra;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.lesson.LessonBase;

// LESSON 04 EXTRA - How far did we drive, and how fast can we go?
// A motor's encoder counts rotations:  leftLeader.getPosition().getValueAsDouble()
//
// TASK:
// 1. Drive with your arcade drive from the basic half (copy it over)
// 2. Read the left leader's rotations into a variable
// 3. wheel rotations = motor rotations / 10.71        (the gear ratio, from ROBOT.md)
// 4. meters = wheel rotations * Math.PI * 0.1524      (wheel diameter in meters;
//                                                      Math.PI is pi, more in lesson 07)
// 5. Put rotations and meters on SmartDashboard
// 6. Drive straight forward, then compare your meters with the first number in
//    NetworkTables -> SmartDashboard -> Sim Field -> Robot (that's the true distance).
//    How close are they?
// 7. Top speed: a Kraken X60 motor spins about 6000 RPM with nothing attached.
//    RPM / 60 = rotations per second, / 10.71 = wheel rotations per second,
//    * Math.PI * 0.1524 = meters per second, * 2.237 = miles per hour.
//    Put the robot's top speed in m/s and mph on SmartDashboard
public class Lesson04 extends LessonBase {
    // Variables declared up here keep their values between loops (lesson 21 explains why).
    private XboxController driver;
    private TalonFX leftLeader;
    private TalonFX leftFollower;
    private TalonFX rightLeader;
    private TalonFX rightFollower;

    @Override
    public void setup() {
        // Runs ONCE, when the robot program starts.
    }

    @Override
    public void execute() {
        // Runs about 50 times a second while the robot is in Teleoperated.
    }
}
