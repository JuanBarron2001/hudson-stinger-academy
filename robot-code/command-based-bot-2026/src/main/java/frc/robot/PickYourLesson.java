package frc.robot;

/**
 * Pick which lesson runs. These three lines are the only thing in this file you should ever change.
 *
 * <p>Examples:
 *
 * <ul>
 *   <li>Lesson 05 basic: {@code LESSON = 5} and {@code EXTRA = false}
 *   <li>Lesson 05 extra: {@code LESSON = 5} and {@code EXTRA = true}
 *   <li>Your own robot, from lesson 57: {@code MY_ROBOT = true}
 * </ul>
 */
public final class PickYourLesson {
  /** The lesson number. Lesson 05 is just 5. Starts on lesson 00, the setup check. */
  public static final int LESSON = 0;

  /** false runs the basic half, true runs the extra half. */
  public static final boolean EXTRA = false;

  /**
   * true runs YOUR robot, {@code frc/robot/RobotContainer.java}, instead of a lesson, and then
   * LESSON and EXTRA are ignored. Leave it false until lesson 57.
   */
  public static final boolean MY_ROBOT = false;

  private PickYourLesson() {}
}
