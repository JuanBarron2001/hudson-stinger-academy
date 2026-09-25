package frc.lesson.lesson44.extra;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.lesson.LessonBase;
// Uncomment once the basic half works.
// import frc.robot.subsystems.Drivetrain;

// LESSON 44 EXTRA - The rest of the list, and one question about nothing
//
// TASK:
// 1. Use the methods an array doesn't have. On your inRange list each loop, publish:
//      inRange.isEmpty()           - are there NO tags near me?
//      inRange.size()              - how many
//      inRange.contains(...)       - careful, see step 2
//      inRange.get(0).ID           - the first one... if there is one
// 2. contains() compares with equals(). AprilTag HAS an equals(), so
//    inRange.contains(new AprilTag(18, field.getTagPose(18).get())) works - but that's
//    a mouthful. Write a small helper that loops and checks tag.ID instead, and say in a
//    comment which one you'd rather read at 1am.
// 3. Sort nearest-first, so get(0) means "the closest tag":
//      inRange.sort(Comparator.comparingDouble(t -> distanceTo(t)));
//    That's a lambda. You've seen them promised since lesson 32 - copy it for now. Lesson 56 explains it.
//    Publish the closest tag's ID and its distance.
// 4. THE CRASH. Publish  inRange.get(0).ID  WITHOUT checking isEmpty() first, then drive
//    to a corner of the field until nothing is in range. PREDICT what happens.
//    You get an IndexOutOfBoundsException and the lesson dies. Fix it with isEmpty().
// 5. Now the design question this lesson is really about. When nothing is in range, what
//    should your code hand back to a caller?
//      (a) an empty list        (b) null        (c) a made-up value like -1
//    Write your answer down before Part 3, because last season's code picked (a) in one
//    method and (c) in another, ten lines apart.
//
// WHY AN EMPTY LIST IS USUALLY THE ANSWER: a caller can loop over an empty list and get
// zero iterations, which is exactly right and needs no special case. Loop over null and
// you crash. Loop over -1 and you can't, because -1 isn't a list at all - the caller has to
// remember to check for a magic number that means "nothing", and one day somebody won't.
public class Lesson44 extends LessonBase {
    // Declare your driver controller, your Drivetrain and your AprilTagFieldLayout here.

    @Override
    public void setup() {
        // Runs ONCE, when the robot program starts.
    }

    @Override
    public void execute() {
        // Runs about 50 times a second while the robot is in Teleoperated.
    }
}
