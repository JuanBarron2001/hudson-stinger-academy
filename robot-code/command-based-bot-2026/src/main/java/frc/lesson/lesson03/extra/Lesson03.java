package frc.lesson.lesson03.extra;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.lesson.LessonBase;

// LESSON 03 EXTRA - Tank drive
// Left stick drives the left side, right stick drives the right side.
// At home: W/S is the left stick, I/K is the right stick.
//
// TASK:
// 1. Create the driver controller and all four drive motors
// 2. Read both sticks' up/down (getLeftY and getRightY). Flip each sign with a minus,
//    so pushing forward gives a positive number:  double left = -driver.getLeftY();
// 3. Set the left motors to the left stick and the right motors to the right stick
// 4. Hold W and I together. Write down what the robot does.
// 5. Fix it: the right side motors are mounted facing the other way (remember lesson 02?),
//    so send the right motors the OPPOSITE sign of the right stick.
//    (Lesson 28 shows how the competition code fixes this with a motor setting instead.)
// 6. Put both stick values and both side speeds on SmartDashboard
// 7. Drive a square on Sim Field.
//
// WHAT HAPPENED IN STEP 4:
public class Lesson03 extends LessonBase {
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
