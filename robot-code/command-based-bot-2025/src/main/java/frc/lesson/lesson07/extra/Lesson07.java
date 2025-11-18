package frc.lesson.lesson07.extra;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.lesson.LessonBase;

// CHALLENGE: Calculate distance and angle to AprilTag using Limelight data
// 1. Get Limelight tx (horizontal offset in degrees) and ty (vertical offset in degrees)
// 2. Use Pythagorean theorem to calculate distance:
//    distance = Math.sqrt(tx^2 + ty^2)
//    Use Math.pow(tx, 2) and Math.pow(ty, 2) or just tx*tx, ty*ty
// 3. Calculate angle to the tag:
//    angle = Math.atan2(ty, tx)  [in radians]
// 4. Convert angle from radians to degrees:
//    degreesAngle = angle * 180 / Math.PI
// 5. Use distance to control drive speed (closer = slower, farther = faster)
// 6. Use angle to control rotation (positive = turn right, negative = turn left)
// 7. Print distance, angle (in degrees), and motor commands to SmartDashboard
// 8. Hint: SmartDashboard.putNumber("key", value) for displaying numbers
public class Lesson07 extends LessonBase {
    @Override
    public void execute() {
        // YOUR CODE HERE
    }
}
