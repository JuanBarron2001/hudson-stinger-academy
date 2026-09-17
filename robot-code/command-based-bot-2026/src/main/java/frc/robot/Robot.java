// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.lesson.LessonBase;
import frc.lesson.LessonLoader;
import frc.sim.RobotSim;

/**
 * The lesson host. It loads the lesson picked in {@link PickYourLesson} and runs it.
 *
 * <p>Students don't edit this file. Your code goes in {@code frc/lesson/lessonNN/basic} or
 * {@code frc/lesson/lessonNN/extra}.
 */
public class Robot extends TimedRobot {
  private final LessonBase lesson;
  private RobotSim sim;

  public Robot() {
    this(PickYourLesson.LESSON, PickYourLesson.EXTRA);
  }

  /** Loads a specific lesson. Tests use this; students use {@link PickYourLesson}. */
  Robot(int lessonNumber, boolean isExtra) {
    lesson = LessonLoader.load(lessonNumber, isExtra);
  }

  @Override
  public void robotPeriodic() {
    // Runs commands and subsystem periodic() methods, once lessons start using them.
    CommandScheduler.getInstance().run();
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
