package frc.lesson.lesson53.basic;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.lesson.LessonBase;
// Uncomment once you've made frc/robot/BallPath.java.
// import frc.robot.BallPath;
// import frc.robot.subsystems.Fuel;

// LESSON 53 BASIC - The four ball paths, named at last
// Back in lesson 13 you learned the 2026 robot has exactly four things it can do with a
// ball, and each one is a pair of numbers. Since then those numbers have been scattered
// across if-chains, Constants and command classes.
//
// Four. Fixed. Known at compile time. Each carrying data. That is an enum.
//
// TASK:
// 1. Make frc/robot/BallPath.java - an enum with a constructor and fields, exactly like
//    Day in Part 1, except the data is two doubles instead of a day number:
//      public enum BallPath {
//          INTAKE(-0.7, 0.8),
//          EJECT(0.9, 0.8),
//          SHOOT(-0.72, -0.7),
//          SHUTTLE(-0.93, -0.7);
//          ... private final fields, a constructor, getRollerPower(), getConveyorPower()
//      }
//    Every number comes from ROBOT.md's ball paths table.
// 2. Replace Fuel's separate intake()/eject()/shoot() methods with ONE:
//      public void follow(BallPath path) {
//          leftRoller.set(path.getRollerPower());
//          rightRoller.set(path.getRollerPower());
//          conveyor.set(path.getConveyorPower());
//      }
//    Four behaviours, one method, because the enum carries the difference.
// 3. Here: pick a path from the operator's buttons - B intake, left bumper eject,
//    A shoot, right bumper shuttle (the 6, 3, 5 and 4 keys). Publish path.toString().
// 4. Also publish BallPath.values(), which is every constant in order, for free:
//      [INTAKE, EJECT, SHOOT, SHUTTLE]
//    and path.ordinal(), its position. You wrote neither method.
// 5. Run all four. Measured roller / conveyor speeds:
//      INTAKE   -67.9 /  77.6
//      EJECT     87.3 /  77.6
//      SHOOT    -69.9 / -67.9
//      SHUTTLE  -90.2 / -67.9
//
// WHAT AN ENUM GIVES YOU THAT A String COULDN'T: BallPath.SHOOT is checked by the compiler.
// Misspell it and the build fails on your laptop. In lesson 52 you typed "Intkae" into a
// map and the robot silently did nothing - same mistake, found months apart.
//
// YOU HAVE BEEN USING ENUMS SINCE LESSON 28: NeutralModeValue.Brake and
// InvertedValue.Clockwise_Positive are both enum constants. Go look at one now that you
// know what you're looking at.
public class Lesson53 extends LessonBase {
    // Declare your operator controller and your Fuel here.

    @Override
    public void setup() {
        // Runs ONCE, when the robot program starts.
    }

    @Override
    public void execute() {
        // Runs about 50 times a second while the robot is in Teleoperated.
    }
}
