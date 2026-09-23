package frc.lesson.lesson37.basic;

import edu.wpi.first.wpilibj.XboxController;
import frc.lesson.LessonBase;
// Uncomment once Climber, DynamicClimb and TriggerAxis exist.
// import frc.robot.TriggerAxis;
// import frc.robot.commands.DynamicClimb;
// import frc.robot.subsystems.Climber;

// LESSON 37 BASIC - The climber, at whatever speed the driver wants
// An abstract class says "you ARE a kind of me". An interface says something smaller and
// more useful: "you can DO this one thing." It doesn't care what you are.
//
// Java already ships the one you need. DoubleSupplier is an interface with a single
// method - double getAsDouble() - and it means "ask me for a number, any time you like."
//
// TASK:
// 1. Make frc/robot/subsystems/Climber.java, a SubsystemBase on CAN 7 (ROBOT.md):
//      constructor - brake mode, 80 A stator limit, and motor.setPosition(0) so you start
//                    from a known place
//      setSpeed(double), getPosition(), stop(), and a periodic() publishing the position
// 2. Make frc/robot/commands/DynamicClimb.java. Its constructor takes a Climber AND a
//    DoubleSupplier:
//      public DynamicClimb(Climber climber, DoubleSupplier speed)
//    In execute():  climber.setSpeed(speed.getAsDouble());  and publish what you commanded.
//    Notice the command has NO IDEA where that number comes from. That is the point.
// 3. Make frc/robot/TriggerAxis.java - a small class that implements the interface:
//      public class TriggerAxis implements DoubleSupplier {
//          ... hold an XboxController ...
//          @Override public double getAsDouble() { return controller.getRightTriggerAxis(); }
//      }
// 4. Here: build  new DynamicClimb(climber, new TriggerAxis(driver))  and schedule it while
//    the right trigger is past 0.1. At home the driver's triggers are Q and E.
// 5. Run it. Squeeze the trigger a little, then a lot. PREDICT the climber's position after
//    a couple of seconds at each. Measured in the simulator: a quarter trigger for ~1.2 s
//    gets you about 25 rotations, half gets about 78, full gets about 180.
//
// WHAT TO NOTICE: DynamicClimb never mentions XboxController, triggers, or the driver.
// It asks an interface for a number. Anything that can produce a double can drive your
// climber - which is the whole idea, and the extra half proves it.
//
// (You have written this shape before without knowing it: lesson 32's
//  DifferentialDrive(leftLeader::set, rightLeader::set) hands over two "things that accept
//  a double" the same way. The lambdas lesson ties it together.)
public class Lesson37 extends LessonBase {
    // Declare your driver controller, your Climber and your DynamicClimb here.

    @Override
    public void setup() {
        // Runs ONCE, when the robot program starts.
    }

    @Override
    public void execute() {
        // Runs about 50 times a second while the robot is in Teleoperated.
    }
}
