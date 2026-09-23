package frc.lesson.lesson27.basic;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.lesson.LessonBase;
// The class you write in this lesson doesn't exist yet, so this line starts commented out.
// Uncomment it once you've created frc/robot/subsystems/Fuel.java.
// import frc.robot.subsystems.Fuel;

// LESSON 27 BASIC - The fuel mechanism becomes a class
// Lesson 13 drove the rollers and the conveyor from inside execute(). Those lines describe
// ONE THING - the fuel mechanism - so they belong in one class, in their own file.
//
// This is the first lesson where your code lives outside the lesson folder. From here on you
// are building a robot, and the lesson is just the switch that turns it on.
//
// TASK:
// 1. Make a new file: frc/robot/subsystems/Fuel.java, first line  package frc.robot.subsystems;
// 2. Give it three TalonFX fields, created right where you declare them (no constructor yet):
//      public TalonFX leftRoller = new TalonFX(5);     // and rightRoller 6, conveyor 29
// 3. Give it three methods - intake(), eject() and stop() - holding lesson 13's ball paths.
//    Intake: rollers -0.7, conveyor +0.8.  Eject: rollers +0.9, conveyor +0.8.  Stop: all 0.
//    BOTH rollers get the SAME number. They turn the same rollers (see ROBOT.md).
// 4. The class, its fields and its methods all need the word  public  in front, because this
//    lesson is in a different folder. Lesson 40 explains what public really means.
// 5. Back here: uncomment the import above, make ONE Fuel in setup(), and in execute() call
//    intake() while the operator holds B, eject() on left bumper, and stop() otherwise.
// 6. Put the action name and the roller and conveyor speeds on SmartDashboard.
// 7. Run it. At home the operator is Keyboard 1, so B is the 6 key and left bumper is 3.
//
// WHAT TO NOTICE: execute() no longer says anything about motors or power levels. It says
// what you want the robot to DO. That is the whole point of a class.
public class Lesson27 extends LessonBase {
    // Declare your operator controller and your one Fuel here.

    @Override
    public void setup() {
        // Runs ONCE, when the robot program starts.
    }

    @Override
    public void execute() {
        // Runs about 50 times a second while the robot is in Teleoperated.
    }
}
