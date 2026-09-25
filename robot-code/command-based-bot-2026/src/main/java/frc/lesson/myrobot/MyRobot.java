package frc.lesson.myrobot;

import edu.wpi.first.wpilibj2.command.Command;
import frc.lesson.LessonBase;
import java.lang.reflect.Method;

/**
 * Runs the student's own robot, {@code frc.robot.RobotContainer}, instead of a lesson. Turned on by
 * {@code PickYourLesson.MY_ROBOT}, from lesson 57.
 *
 * <p>The container is found by name, like {@link frc.lesson.LessonLoader} finds lessons, because
 * the academy repo doesn't ship a {@code RobotContainer}: each student writes their own, starting in
 * lesson 42. It extends {@link LessonBase} only for the log, so a whole robot run gets turned in the
 * same way a lesson does.
 */
public class MyRobot extends LessonBase {
  /** The class every student's robot lives in, from lesson 42 on. */
  public static final String CONTAINER_CLASS = "frc.robot.RobotContainer";

  private final Object container;

  private MyRobot(Object container) {
    this.container = container;
  }

  /**
   * Builds the student's RobotContainer, or returns null if it can't. Either way it prints what
   * happened, so a missing or crashing RobotContainer is explained instead of silently doing nothing.
   */
  public static MyRobot load(String className) {
    try {
      Object container = Class.forName(className).getDeclaredConstructor().newInstance();
      System.out.println(
          "Loaded your robot: "
              + className
              + ". Teleoperated drives it, and Autonomous runs getAutonomousCommand().");
      MyRobot myRobot = new MyRobot(container);
      Runtime.getRuntime().addShutdownHook(new Thread(myRobot::cleanup));
      return myRobot;
    } catch (ClassNotFoundException e) {
      System.out.println(
          "PickYourLesson.MY_ROBOT is true, but there's no "
              + className
              + " yet. Lesson 42 is where you make it. Nothing will run.");
    } catch (Exception e) {
      System.out.println(
          "Your "
              + className
              + " was found but crashed while it was being built. The error is below; the first"
              + " line that mentions frc.robot is usually where the problem is.");
      (e.getCause() != null ? e.getCause() : e).printStackTrace();
    }
    return null;
  }

  /**
   * Asks the container for its autonomous command, the way last season's Robot.java did. Returns
   * null, and says why, if there isn't one.
   */
  public Command autonomousCommand() {
    try {
      Method method = container.getClass().getMethod("getAutonomousCommand");
      Object command = method.invoke(container);
      if (command == null) {
        System.out.println("getAutonomousCommand() returned null, so Autonomous does nothing.");
      }
      return (Command) command;
    } catch (NoSuchMethodException e) {
      System.out.println(
          "Your RobotContainer has no public getAutonomousCommand(), so Autonomous does nothing.");
    } catch (Exception e) {
      System.out.println("getAutonomousCommand() crashed, so Autonomous does nothing:");
      (e.getCause() != null ? e.getCause() : e).printStackTrace();
    }
    return null;
  }

  /** Nothing to do here: the scheduler runs your robot. This class is only here for the log. */
  @Override
  public void execute() {}
}
