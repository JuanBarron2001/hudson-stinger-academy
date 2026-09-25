package frc.lesson.lesson15.extra;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.ctre.phoenix6.hardware.Pigeon2;
import frc.lesson.LessonBase;

// LESSON 15 EXTRA - A while loop that IS fine: wrapping an angle
// The gyro's yaw keeps counting past 360: spin twice and it reads 720.
// For aiming you want the same heading between -180 and 180.
//
// TASK:
// 1. Create the driver controller, all four drive motors and the Pigeon gyro:
//      pigeon = new Pigeon2(11);
// 2. Drive with your arcade drive from lesson 04 (J and L spin the robot)
// 3. raw = pigeon.getYaw().getValueAsDouble()
// 4. heading = raw, then wrap it with two while loops:
//      while heading > 180, subtract 360
//      while heading < -180, add 360
// 5. Put raw and heading on SmartDashboard. Spin in circles and watch both.
// 6. Why doesn't THIS while loop freeze the robot like the basic half did? Answer in a comment.
//
// ANSWER:
public class Lesson15 extends LessonBase {
    // Variables declared up here keep their values between loops (lesson 21 explains why).
    private XboxController driver;
    private TalonFX leftLeader;
    private TalonFX leftFollower;
    private TalonFX rightLeader;
    private TalonFX rightFollower;
    private Pigeon2 pigeon;

    @Override
    public void setup() {
        // Runs ONCE, when the robot program starts.
    }

    @Override
    public void execute() {
        // Runs about 50 times a second while the robot is in Teleoperated.
    }
}
