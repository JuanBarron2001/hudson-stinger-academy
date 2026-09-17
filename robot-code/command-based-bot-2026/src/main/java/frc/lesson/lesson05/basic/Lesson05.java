package frc.lesson.lesson05.basic;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.lesson.LessonBase;

// LESSON 05 BASIC - Deadband
// Real controller sticks never rest at exactly 0. They "drift", and a drifting stick
// makes the robot creep when nobody is touching it.
//
// TASK:
// 1. Create the driver controller and all four drive motors
// 2. stick = the left stick's up/down, sign flipped, PLUS 0.06
//    (the + 0.06 fakes a drifting stick, because your keyboard never drifts)
// 3. Drive all four motors with it (right side opposite sign, like before)
// 4. Run it WITHOUT touching anything and watch Sim Field. Write down what happens.
// 5. Add a deadband with if / else if / else:
//      if stick > 0.1         -> speed = stick
//      else if stick < -0.1   -> speed = stick
//      else                   -> speed = 0
// 6. Drive with speed instead of stick. Does the creeping stop?
// 7. Put stick and speed on SmartDashboard
//
// WHAT HAPPENED IN STEP 4:
public class Lesson05 extends LessonBase {
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
