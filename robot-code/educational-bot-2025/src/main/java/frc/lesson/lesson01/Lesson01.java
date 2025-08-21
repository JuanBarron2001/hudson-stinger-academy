package frc.lesson.lesson01;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.lesson.LessonBase;

public class Lesson01 extends LessonBase{
    @Override
    public void execute()
    {
        double rand = Math.random();
        SmartDashboard.putString("Testing SmartDashboard", "Hello From SmartDashboard" + rand);
    }
}
