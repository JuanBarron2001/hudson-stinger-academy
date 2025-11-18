package frc.lesson.lesson11.basic;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.lesson.LessonBase;

public class Lesson11 extends LessonBase {
    @Override
    public void execute() {
        // TASK: Build a simple Shuffleboard command parser for drivetrain
        // 1. Get command string from Shuffleboard input (e.g., "drivetrain:forward")
        // 2. Validate it contains ":" using .contains(":")
        // 3. Use .indexOf(":") to find the delimiter position
        // 4. Extract subsystem: command.substring(0, indexOf(":"))
        // 5. Extract action: command.substring(indexOf(":")+1)
        // 6. Check subsystem:
        //    - If "drivetrain" and action="forward" → drive forward at full speed
        //    - If action="backward" → drive backward
        //    - If action="stop" → stop all motors
        // 7. Log to SmartDashboard: "Command: drivetrain:forward → DRIVING FORWARD"
        // Example commands: "drivetrain:forward", "drivetrain:backward", "drivetrain:stop"
    }
}
