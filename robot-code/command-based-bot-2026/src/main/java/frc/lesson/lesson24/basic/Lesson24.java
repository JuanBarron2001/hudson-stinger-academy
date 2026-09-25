package frc.lesson.lesson24.basic;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.lesson.LessonBase;

// LESSON 24 BASIC - Is that CAN ID on the robot?
// Lesson 22 put every CAN ID in one array. Now search it.
//
// TASK:
// 1. Lesson 22's array as a field:  private int[] canIds = {1, 2, 3, 4, 5, 6, 7, 29};
// 2. A target to look for:          private int target = 29;
// 3. Two more fields to hold the answer: the index you found, and boolean isFound
// 4. In setup(): the search. The array never changes, so once is enough.
//    When canIds[i] == target, save the index, set isFound = true, and break.
// 5. In execute(): if isFound, put "CAN <target> found at index <i>" on SmartDashboard.
//    If NOT isFound, put "CAN <target> is not on this robot" instead.
// 6. Run it, then change target to 8 and run it again. There is no CAN 8 on this robot.
//
// WHAT THE FLAG IS FOR: without isFound, what does the dashboard show for CAN 8?
public class Lesson24 extends LessonBase {
    // Declare your array, your target, and the two answer fields here.

    @Override
    public void setup() {
        // Runs ONCE, when the robot program starts. Do the search here.
    }

    @Override
    public void execute() {
        // Runs about 50 times a second while the robot is in Teleoperated.
    }
}
