package frc.lesson.lesson14.extra;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.lesson.LessonBase;

// LESSON 14 EXTRA - Climber soft limits with ||
// The climber can tear itself apart if it keeps driving past the end of its travel.
// The competition code stops it past 365 rotations going up and below -70 going down.
// At home: up arrow = D-pad up, down arrow = D-pad down.
//
// TASK:
// 1. Create the driver controller and the climber (CAN 7)
// 2. power = 0.95 if the D-pad is up (getPOV() == 0), -0.4 if it's down (getPOV() == 180),
//    otherwise 0
// 3. position = the climber's rotations
// 4. In ONE if, using && and ||:
//      if (going up AND past 365) OR (going down AND below -70) -> power = 0
// 5. Set the climber, and put position, power and "At Limit" on SmartDashboard
// 6. Hold the up arrow until it stops. Can you still drive it back down? Why should you be able to?
//
// ANSWER:
public class Lesson14 extends LessonBase {
    // Variables declared up here keep their values between loops (lesson 21 explains why).
    private XboxController driver;
    private TalonFX climber;

    @Override
    public void setup() {
        // Runs ONCE, when the robot program starts.
    }

    @Override
    public void execute() {
        // Runs about 50 times a second while the robot is in Teleoperated.
    }
}
