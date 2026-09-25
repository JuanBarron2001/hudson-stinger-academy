package frc.lesson.lesson15.basic;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.lesson.LessonBase;

// LESSON 15 BASIC - Why robot code never waits in a while loop
//
// !!! SIMULATOR ONLY. NEVER deploy the step 2 version to the real robot. !!!
//
// TASK:
// 1. Create the operator controller and both rollers
// 2. THE WRONG WAY. Inside execute(), while A (the 5 key) is held:
//      while (Math.abs(-70 - leftRoller's velocity) >= 3) {
//          set both rollers to your lesson 07 power
//      }
//      then put "Status" = "AT SPEED" on SmartDashboard
// 3. Run the simulator and press A. Watch the dashboard and Sim Field. Then stop the
//    simulator (close its window, or press stop in VS Code).
// 4. Answer in a comment: why did everything freeze?
//    Hint: execute() has to FINISH before the robot does anything else, including
//    updating how fast the rollers are spinning.
// 5. THE RIGHT WAY. Replace the while with an if that checks ONCE per loop (like lesson 07).
//    The robot stays alive, because execute() runs again 50 times a second anyway.
//
// WHY IT FROZE:
public class Lesson15 extends LessonBase {
    // Variables declared up here keep their values between loops (lesson 21 explains why).
    private XboxController operator;
    private TalonFX leftRoller;
    private TalonFX rightRoller;

    @Override
    public void setup() {
        // Runs ONCE, when the robot program starts.
    }

    @Override
    public void execute() {
        // Runs about 50 times a second while the robot is in Teleoperated.
    }
}
