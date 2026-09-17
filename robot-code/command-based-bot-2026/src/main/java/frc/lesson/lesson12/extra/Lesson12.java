package frc.lesson.lesson12.extra;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import frc.lesson.LessonBase;

// LESSON 12 EXTRA - Which hub is ours?
// The robot shoots at its OWN alliance's hub. Hub centers are in ROBOT.md -> Vision.
//
// TASK:
// 1. Copy this line into execute() exactly (lesson 43 explains how it works):
//      boolean isRed = DriverStation.getAlliance().orElse(Alliance.Blue) == Alliance.Red;
// 2. Use ternaries to pick the hub center:
//      hubX = 11.9903 if isRed, otherwise 4.5227
//      hubY = 4.0214 either way (so no ternary needed; notice that)
//    Put isRed, hubX and hubY on SmartDashboard.
// 3. In the simulator's FMS window, switch the alliance station between Red and Blue.
//    Does hubX change?
// 4. Precision mode: create the driver controller and all four drive motors.
//    scale = 0.35 while the right bumper is held (the 2 key), otherwise 0.7, using a ternary.
//    Drive forward and back with the left stick times scale (right side opposite sign).
public class Lesson12 extends LessonBase {
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
