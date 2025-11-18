package frc.lesson.lesson10.extra;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.lesson.LessonBase;

// CHALLENGE: Build a command logger with validation and parsing
// 1. Read operator input from Shuffleboard (text field for commands)
// 2. Clean and validate the input:
//    - .trim() to remove whitespace
//    - .toLowerCase() for case-insensitive matching
//    - .isEmpty() to check if command is empty
// 3. Parse for valid keywords using .contains():
//    Valid commands: "forward", "backward", "spin", "stop"
// 4. Log each step to SmartDashboard for debugging:
//    "Raw Input: '  FORWARD please  '"
//    "Cleaned: 'forward please'"
//    "Keyword Found: 'forward'"
//    "Action: DRIVING FORWARD"
// 5. Handle invalid commands gracefully:
//    "Invalid command: 'banana' - recognized commands: forward, backward, spin, stop"
// 6. Use .equals() or .equalsIgnoreCase() for exact matching if desired
// 7. Execute the appropriate motor commands based on parsed keyword
// 8. This is a realistic logger for debugging operator input during matches!
public class Lesson10 extends LessonBase {
    @Override
    public void execute() {
        // YOUR CODE HERE
    }
}
