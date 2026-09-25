package frc.lesson.lesson42.basic;

import frc.lesson.LessonBase;
// Uncomment once you've made frc/robot/RobotContainer.java.
// import frc.robot.RobotContainer;

// LESSON 42 BASIC - The robot becomes one object
// Inheritance is IS-A: a Drivetrain IS A SubsystemBase. Composition is HAS-A, and it is
// what actually holds a robot together: the robot HAS a drivetrain, HAS a fuel mechanism,
// HAS a climber. None of those is a kind of robot. The robot owns them.
//
// TASK:
// 1. Make frc/robot/RobotContainer.java. It extends NOTHING. It just owns things:
//      private final Drivetrain drivetrain = new Drivetrain();
//      private final Fuel fuel = new Fuel();
//      private final Climber climber = new Climber();
//      private final XboxController driver = new XboxController(0);
//      private final XboxController operator = new XboxController(1);
//    Exactly ONE of each, for the whole robot. That is lesson 31's counter, enforced by
//    there being one place that builds them.
// 2. Make frc/robot/commands/TeleopDrive.java - a Command taking the Drivetrain and the
//    driver's controller, with addRequirements(drivetrain). Its execute() does the arcade
//    driving you've done since lesson 04. isFinished() returns false: it never ends.
// 3. In RobotContainer's constructor, hand it over:
//      drivetrain.setDefaultCommand(new TeleopDrive(drivetrain, driver));
//    That is the method lesson 32 said you'd got for free and had no use for yet.
//    It means: run this whenever nothing else wants the drivetrain.
// 4. Add an update() method holding the button bindings - B runs Intake, the way you did
//    in lesson 34.
// 5. Here: setup() makes ONE RobotContainer. execute() is one line: container.update();
// 6. Run it and drive. Nothing in your lesson file mentions a motor, a subsystem, a CAN ID
//    or a stick. It says "update the robot".
//
// WHY THE DEFAULT COMMAND MATTERS: before this, your lesson called drivetrain.arcade()
// directly every loop. That worked, but it went around the scheduler - so addRequirements()
// could not protect the drivetrain from you. Now every single thing that moves the
// drivetrain is a command, and the scheduler can referee all of them.
//
// WHAT THIS FILE IS, BESIDES CODE: RobotContainer is the only place that knows the whole
// robot. It is also the only honest answer to "what does the X button do?" - which is why
// Part 3 asks you to draw last season's controller map out of theirs.
public class Lesson42 extends LessonBase {
    // Declare your RobotContainer here. It should be the only field.

    @Override
    public void setup() {
        // Runs ONCE, when the robot program starts.
    }

    @Override
    public void execute() {
        // Runs about 50 times a second while the robot is in Teleoperated.
    }
}
