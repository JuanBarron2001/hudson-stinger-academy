package frc.lesson.lesson19.extra;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.lesson.LessonBase;

// LESSON 19 EXTRA - Methods for the shooter
// At home the operator's A is the 5 key.
//
// TASK:
// 1. Create the operator controller, both rollers and the conveyor
// 2. Write these methods:
//      double rollerSpeed()                          returns the left roller's velocity
//      boolean atSpeed(double target)                returns true within 3 of target (lesson 07)
//      void setFuel(double rollerPower, double conveyorPower)
//                                                    sets all three motors, right roller opposite sign
// 3. Rebuild lesson 14's shoot logic in execute() using only those methods.
//    It should read almost like English:  if (shooting && atSpeed(-70)) setFuel(...)
// 4. Put the roller speed and whether it's at speed on SmartDashboard
public class Lesson19 extends LessonBase {
    // Variables declared up here keep their values between loops (lesson 21 explains why).
    private XboxController operator;
    private TalonFX leftRoller;
    private TalonFX rightRoller;
    private TalonFX conveyor;

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
