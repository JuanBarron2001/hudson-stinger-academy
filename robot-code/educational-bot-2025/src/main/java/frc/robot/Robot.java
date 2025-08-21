package frc.robot;

import frc.lesson.LessonBase;

public class Robot extends EducationalRobot {

    private LessonBase currentLesson;

    public Robot() {
        // Change this ONE value when switching lessons
        int lessonNumber = 1;
        String lessonNumberFormatted = String.format("%02d", lessonNumber);
        String lessonClassName = "frc.lesson.lesson" + lessonNumberFormatted + ".Lesson" + lessonNumberFormatted;

        try {
            Class<?> clazz = Class.forName(lessonClassName);
            currentLesson = (LessonBase) clazz.getDeclaredConstructor().newInstance();
            currentLesson.setup();
            System.out.println("Loaded lesson: " + lessonClassName);
        } catch (ClassNotFoundException e) {
            System.out.println("No lesson found for: " + lessonClassName + " — doing nothing.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error while loading lesson — doing nothing.");
        }
    }

    @Override
    public void run() {
        if (currentLesson != null) {
            try {
                currentLesson.execute();
                currentLesson.logSmartDashboardChanges();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Lesson threw an error — stopping execution.");
                currentLesson.cleanup();
                currentLesson = null;
            }
        }
    }
}
