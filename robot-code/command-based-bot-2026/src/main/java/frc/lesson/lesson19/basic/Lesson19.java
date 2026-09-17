package frc.lesson.lesson19.basic;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.lesson.LessonBase;

// LESSON 19 BASIC - Methods clean up the drive code
// Your execute() has been getting long. Methods give a chunk of code a name.
// Methods inside a lesson don't need the word "static".
//
// TASK:
// 1. Create the driver controller and all four drive motors
// 2. Write a method that takes a stick value and RETURNS it with a deadband applied:
//      double deadband(double value)       (lesson 05's if / else if / else, with return)
// 3. Write a method that sets all four motors, handling the right side's opposite sign:
//      void setDrive(double left, double right)
// 4. Rewrite your lesson 04 arcade drive in execute() using ONLY those two methods for
//    the deadband and the motors. Aim for five lines or fewer in execute().
// 5. Put left and right on SmartDashboard
public class Lesson19 extends LessonBase {
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

    // Write your own methods below this line.
}
