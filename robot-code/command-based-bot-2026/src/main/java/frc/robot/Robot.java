// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.lesson.LessonBase;
import frc.lesson.LessonLoader;

/**
 * The lesson host. It loads the lesson picked in {@link PickYourLesson} and runs it.
 *
 * <p>Students don't edit this file. Your code goes in {@code frc/lesson/lessonNN/basic} or
 * {@code frc/lesson/lessonNN/extra}.
 */
public class Robot extends TimedRobot {
  private final LessonBase lesson;

  public Robot() {
    lesson = LessonLoader.load(PickYourLesson.LESSON, PickYourLesson.EXTRA);
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

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }
}
