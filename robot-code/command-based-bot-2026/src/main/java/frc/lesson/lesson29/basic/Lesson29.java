package frc.lesson.lesson29.basic;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.lesson.LessonBase;
// Uncomment once you've made frc/robot/Shot.java and added shoot() to Fuel.
// import frc.robot.Shot;
// import frc.robot.subsystems.Fuel;

// LESSON 29 BASIC - Three shots, one class, three constructors
// The robot takes three shots: short, medium and far. They differ only in numbers.
// That is a class with overloaded constructors: one way to build the usual one, and
// other ways to build the ones you have to describe.
//
// TASK:
// 1. Make frc/robot/Shot.java with three fields:  rollerPower, targetRps, conveyorPower.
// 2. Give it THREE constructors, each one calling the next with this(...):
//      Shot()                                        -> this(-0.72, -70)      the short shot
//      Shot(double rollerPower, double targetRps)    -> this(rollerPower, targetRps, -0.7)
//      Shot(double rollerPower, double targetRps, double conveyorPower)   <- the real one
//    Only the LAST one assigns the fields. The other two hand work to it. Write it that
//    way on purpose: if the default conveyor power ever changes, it changes in ONE place.
// 3. In Fuel, add:
//      public double rollerRps()            - the left roller's velocity
//      public boolean atSpeed(Shot shot)    - lesson 07's check: Math.abs(target - actual) < 3
//      public void shoot(Shot shot)         - both rollers to shot.rollerPower, and the
//                                             conveyor to -0.05 UNTIL atSpeed, then
//                                             shot.conveyorPower. That's ROBOT.md's real
//                                             behaviour: don't feed a slow flywheel.
// 4. Here: build the three shots in setup() and fire them from the operator's A, X and Y
//    (the 5, 7 and 8 keys). Publish the target, the actual RPS and whether you're at speed.
// 5. -0.72 reaches -70 RPS - you found that in lesson 07. Find the powers for -80 and -90
//    the same way. In the simulator, roller RPS is roughly 97 x power, so start near -0.82
//    and -0.93.
//
// WHAT TO NOTICE: new Shot() reads like "the usual shot". new Shot(-0.93, -90, -0.9) reads
// like "this specific one". Same class, and you never wrote a shot with three loose doubles
// floating next to each other where two could get swapped.
public class Lesson29 extends LessonBase {
    // Declare your operator controller, your Fuel, and your three Shots here.

    @Override
    public void setup() {
        // Runs ONCE, when the robot program starts.
    }

    @Override
    public void execute() {
        // Runs about 50 times a second while the robot is in Teleoperated.
    }
}
