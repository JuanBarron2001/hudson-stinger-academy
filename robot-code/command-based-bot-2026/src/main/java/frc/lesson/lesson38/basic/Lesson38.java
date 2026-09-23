package frc.lesson.lesson38.basic;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.lesson.LessonBase;
// Uncomment once your three autos exist.
// import frc.robot.commands.DoNothing;
// import frc.robot.commands.DriveForward;
// import frc.robot.commands.SpinUpAuto;
// import frc.robot.subsystems.Drivetrain;
// import frc.robot.subsystems.Fuel;

// LESSON 38 BASIC - One box, three different autos
// At a competition nobody edits code between matches. The drive team picks the autonomous
// routine off a dropdown. That dropdown is a SendableChooser<Command>, and the only reason
// it can hold three different classes at once is polymorphism.
//
// TASK:
// 1. Write three autos. Each is a Command, and NONE of them needs a timer - each one knows
//    it is done by looking at the robot:
//      DriveForward(drivetrain, rotations)  execute() drives at 0.5;
//                                           isFinished() -> drivetrain.rotations() > target
//      SpinUpAuto(fuel)                     execute() runs the rollers at -0.72;
//                                           isFinished() -> fuel.atSpeed()
//      DoNothing()                          isFinished() -> true, immediately.
//                                           A real option that real teams really ship.
// 2. Build the chooser in setup():
//      chooser = new SendableChooser<>();
//      chooser.setDefaultOption("Drive Forward", new DriveForward(drivetrain, 40));
//      chooser.addOption("Spin Up", new SpinUpAuto(fuel));
//      chooser.addOption("Do Nothing", new DoNothing());
//      SmartDashboard.putData("Auto Chooser", chooser);     <- NAME IT. Part 3 explains.
// 3. In execute(): read  chooser.getSelected()  into a  Command  variable, publish its
//    getName(), and schedule it when the driver presses A (the Z key).
// 4. Run it WITHOUT touching the dashboard. It drives forward about 1.9 m and stops itself
//    at 40 rotations, because setDefaultOption means "this is what you get if nobody picks".
// 5. Open the simulator's NetworkTables window, switch the chooser to "Spin Up", and press
//    A again. Different auto, and you changed no code.
//
// WHAT TO NOTICE: your variable is declared  Command selected.  Not DriveForward, not
// SpinUpAuto. You call selected.schedule() without knowing or caring which one it is, and
// the right execute() runs. That is polymorphism, and this is the exact place every FRC
// robot uses it.
//
// ONE ODDITY WORTH SPOTTING: the dropdown says "Drive Forward" but getName() says
// "DriveForward". The label is yours; the name came from the class. They don't have to match,
// and on a real robot they often don't.
public class Lesson38 extends LessonBase {
    // Declare your driver controller and your SendableChooser<Command> here.

    @Override
    public void setup() {
        // Runs ONCE, when the robot program starts.
    }

    @Override
    public void execute() {
        // Runs about 50 times a second while the robot is in Teleoperated.
    }
}
