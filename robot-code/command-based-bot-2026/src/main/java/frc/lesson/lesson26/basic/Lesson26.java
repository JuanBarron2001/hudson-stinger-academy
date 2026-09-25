package frc.lesson.lesson26.basic;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.lesson.LessonBase;

// LESSON 26 BASIC - A shot table
// Farther shots need faster rollers. The robot keeps a table: distance -> roller speed.
// Each row is {distance in inches, roller speed in rotations per second}.
//
// TASK:
// 1. A 2D array field:
//      private double[][] shotTable = {
//          {30, -60},
//          {75, -75},
//          {120, -90}
//      };
// 2. In setup(): SmartDashboard.putNumber("Distance (in)", 60);
//    In execute(): distance = SmartDashboard.getNumber("Distance (in)", 60);
//    (You can change the number in the simulator's NetworkTables window.)
// 3. Loop over the rows and find the row whose distance is CLOSEST to yours
//    (Math.abs of the difference). Its speed is the target.
// 4. Put the target speed and the chosen row number on SmartDashboard
// 5. Try distances 0, 50, 53, 100 and 500. Which answers look wrong for a real shot?
//
// ANSWER:
public class Lesson26 extends LessonBase {
    // Declare your fields here.

    @Override
    public void setup() {
        // Runs ONCE, when the robot program starts.
    }

    @Override
    public void execute() {
        // Runs about 50 times a second while the robot is in Teleoperated.
    }
}
