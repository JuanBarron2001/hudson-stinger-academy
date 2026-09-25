package frc.lesson.lesson57.extra;

import frc.lesson.LessonBase;

// LESSON 57 EXTRA - Last season's autonomous, on your code
// This file stays empty. Your robot is the exercise: frc/robot/RobotContainer.java and
// everything it owns. The host runs it once PickYourLesson.MY_ROBOT is true.
//
// TASK:
// 1. Copy src/main/deploy/pathplanner/paths/, autos/ and navgrid.json from OG-Code-2026
//    (branch Pre-DCMP-Flywheel) into the same place here. settings.json is already here.
// 2. Drivetrain: you have getPose() and resetPose(Pose2d) from lesson 40. Add
//      public ChassisSpeeds getRobotRelativeSpeeds()
//      public void driveRobotRelative(ChassisSpeeds speeds)
//    using a DifferentialDriveKinematics(0.56) - toChassisSpeeds / toWheelSpeeds. Wheel m/s
//    = motor RPS x your metres-per-rotation. Power = m/s / top speed, where top speed is
//    (6380 / 60) x metres-per-rotation.
// 3. In the constructor, inside lesson 45's try/catch:
//      AutoBuilder.configure(this::getPose, this::resetPose, this::getRobotRelativeSpeeds,
//          this::driveRobotRelative, new PPLTVController(0.02), config,
//          <a lambda: are we red? (lesson 53)>, this);
// 4. RobotContainer: lesson 52's map with Intake, Shoot, ClimbUp, ClimbDown, handed over
//    with NamedCommands.registerCommands(map). Check each with NamedCommands.hasCommand
//    and publish any that are missing.
// 5. AFTER registering: AutoBuilder.buildAuto("PP Depot And Climb") as the chooser default.
// 6. Run Autonomous. Measured:
//      0-3 s    ToDepot (3.59, 5.98) -> (0.48, 5.98), Intake running
//      3-5 s    DepotToHub back to (3.55, 4.19), ClimbUp alongside
//      ~7.4 s   ClimbUp stops at 365, coasts to ~406 (lesson 37)
//      8-9 s    HubToTower, ending at (1.52, 4.19)
//      9-14.5 s Shoot for six seconds, then ClimbDown
//    The sim's field view starts you in the corner, but PathPlanner resets your odometry
//    to the path start - compare the SHAPE, not the spot.
// 7. EXPERIMENT: move registerCommands to AFTER buildAuto. PREDICT, then run.
//    Every path drives perfectly and nothing else happens: no intake, climb or shot. Only
//    four console warnings at startup. Lesson 38's failure: runs perfectly, fails a human.
//    Put it back.
public class Lesson57 extends LessonBase {
    @Override
    public void execute() {
        // Stays empty. With MY_ROBOT on, this lesson isn't loaded at all.
    }
}
