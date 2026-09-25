package frc.lesson;

/**
 * Finds a lesson class by its package name and creates it.
 *
 * <p>The naming is load-bearing: lesson 7's basic half must be the class {@code
 * frc.lesson.lesson07.basic.Lesson07}. Two digits, always.
 */
public final class LessonLoader {
  private LessonLoader() {}

  /**
   * Loads a lesson, or returns null if it can't. Either way it prints what happened, so a student
   * who picked a lesson that doesn't exist sees why nothing runs instead of a crash.
   */
  public static LessonBase load(int lessonNumber, boolean isExtra) {
    String number = String.format("%02d", lessonNumber);
    String className =
        "frc.lesson.lesson" + number + (isExtra ? ".extra" : ".basic") + ".Lesson" + number;

    try {
      Class<?> lessonClass = Class.forName(className);
      LessonBase lesson = (LessonBase) lessonClass.getDeclaredConstructor().newInstance();
      lesson.setup();
      Runtime.getRuntime().addShutdownHook(new Thread(lesson::cleanup));
      System.out.println(
          "Loaded lesson: " + className + " - set the robot to Teleoperated to run it.");
      return lesson;
    } catch (ClassNotFoundException e) {
      System.out.println(
          "No lesson found named "
              + className
              + ". Check the numbers in PickYourLesson.java. Nothing will run.");
    } catch (Exception e) {
      System.out.println(
          "Lesson "
              + className
              + " was found but crashed while starting up. The error is below; show it to a mentor"
              + " if it doesn't make sense.");
      e.printStackTrace();
    }
    return null;
  }
}
