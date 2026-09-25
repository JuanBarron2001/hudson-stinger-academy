package frc.lesson.lesson57.basic;

import frc.lesson.LessonBase;

// LESSON 57 BASIC - The whole robot, in one container
// This file stays empty. Your robot is the exercise: frc/robot/RobotContainer.java and
// everything it owns. The host runs it once PickYourLesson.MY_ROBOT is true.
//
// TASK:
// 1. PickYourLesson.java: set MY_ROBOT = true. The simulator now builds YOUR
//    frc/robot/RobotContainer.java instead of a lesson, runs getAutonomousCommand() in
//    Autonomous, stops it in Teleoperated, and logs to frc.lesson.myrobot-output.log.
// 2. Finish RobotContainer (from lesson 42):
//    - TeleopDrive as the drivetrain's default command
//    - Triggers built in the constructor (lesson 56), each running fuel.follow(BallPath...)
//      while held: operator B intake, left bumper eject, A shoot, right bumper shuttle
//    - the driver's right trigger climbs, with DynamicClimb and a lambda
//    - an auto chooser (lesson 38) with your autos, ShootAndClimb included, on the dashboard
//    - public Command getAutonomousCommand() returning the chooser's pick. EXACTLY that
//      name - the host looks it up by name.
//    - update() is empty now, and nothing outside RobotContainer mentions a motor.
// 3. Teleoperated: drive and try every button (intake: rollers -67.9 RPS).
//    Autonomous: pick an auto, run it, switch to Teleoperated partway - the auto stops.
// 4. Read your log. It should tell the story of what you did.
// 5. AT A MEETING, WITH A MENTOR: deploy it to the real robot. Robot on blocks or with room,
//    a hand on disable. Write down anything that behaves differently from the simulator.
public class Lesson57 extends LessonBase {
    @Override
    public void execute() {
        // Stays empty. With MY_ROBOT on, this lesson isn't loaded at all.
    }
}
