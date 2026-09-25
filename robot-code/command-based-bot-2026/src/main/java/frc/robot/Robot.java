// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.lesson.LessonBase;
import frc.lesson.LessonLoader;
import frc.lesson.myrobot.MyRobot;
import frc.sim.RobotSim;

/**
 * The lesson host. It loads the lesson picked in {@link PickYourLesson} and runs it, or, with
 * {@code MY_ROBOT} on, the student's own {@code RobotContainer}.
 *
 * <p>Students don't edit this file. Your code goes in {@code frc/lesson/lessonNN/basic} or
 * {@code frc/lesson/lessonNN/extra}.
 */
public class Robot extends TimedRobot {
  private final LessonBase lesson;
  private final MyRobot myRobot;
  private Command autonomousCommand;
  private RobotSim sim;

  public Robot() {
    if (PickYourLesson.MY_ROBOT) {
      lesson = null;
      myRobot = MyRobot.load(MyRobot.CONTAINER_CLASS);
    } else {
      lesson = LessonLoader.load(PickYourLesson.LESSON, PickYourLesson.EXTRA);
      myRobot = null;
    }
  }

  /** Loads a specific lesson. Tests use this; students use {@link PickYourLesson}. */
  Robot(int lessonNumber, boolean isExtra) {
    lesson = LessonLoader.load(lessonNumber, isExtra);
    myRobot = null;
  }

  /** Runs a robot container instead of a lesson. Tests use this to name a stand-in container. */
  Robot(String containerClass) {
    lesson = null;
    myRobot = MyRobot.load(containerClass);
  }

  @Override
  public void robotPeriodic() {
    // Runs commands and subsystem periodic() methods, once lessons start using them.
    CommandScheduler.getInstance().run();
    // A whole robot is logged in every mode, so the log shows Autonomous too.
    if (myRobot != null) {
      myRobot.runOneLoop();
    }
  }

  /** Only with MY_ROBOT on: runs your RobotContainer's getAutonomousCommand(). */
  @Override
  public void autonomousInit() {
    if (myRobot != null) {
      autonomousCommand = myRobot.autonomousCommand();
      if (autonomousCommand != null) {
        CommandScheduler.getInstance().schedule(autonomousCommand);
      }
    }
  }

  /** Stops the autonomous command when Teleoperated starts, the way the competition code does. */
  @Override
  public void teleopInit() {
    if (autonomousCommand != null) {
      autonomousCommand.cancel();
      autonomousCommand = null;
    }
  }

  /** Your lesson's execute() runs about fifty times a second while the robot is in Teleoperated. */
  @Override
  public void teleopPeriodic() {
    if (lesson != null) {
      lesson.runOneLoop();
    }
  }

  // Empty on purpose. Without these, WPILib prints "Override me!" every few seconds, which looks
  // like something a student did wrong.
  @Override
  public void disabledPeriodic() {}

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void testPeriodic() {}

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  /** Only runs in simulation: starts the physics that make the motors move at home. */
  @Override
  public void simulationInit() {
    sim = RobotSim.start();
  }

  @Override
  public void simulationPeriodic() {
    sim.update();
  }
}
