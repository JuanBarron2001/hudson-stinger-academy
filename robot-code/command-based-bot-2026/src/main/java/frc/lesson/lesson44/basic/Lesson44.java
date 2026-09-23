package frc.lesson.lesson44.basic;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.lesson.LessonBase;
// Uncomment once Drivetrain has getPose() from lesson 40.
// import frc.robot.subsystems.Drivetrain;

// LESSON 44 BASIC - Which tags are near me right now?
// Lesson 22 gave you an array of CAN IDs. An array is the right shape when you know the
// count and it never changes: this robot has 8 motors, forever.
//
// "Which AprilTags are within range of the robot" is not that. It's 4 tags, then 6, then
// 5, changing every single loop as you drive. You cannot size an array for that.
//
// GOOD NEWS: you need no camera for this one. The 2026 field layout ships inside WPILib -
// all 32 tags, with their real positions - and lesson 40 gave you a pose. Where you think
// you are, plus where the tags actually are, is enough.
//
// TASK:
// 1. Load the field in setup():
//      field = AprilTagFields.k2026RebuiltWelded.loadAprilTagLayoutField();
//    Publish field.getTags().size(). It's 32. That list never changes - it's the field.
// 2. Reset your pose so you start from a known place:  drivetrain.resetPose(new Pose2d());
// 3. In execute(), build a list of the tags close to you:
//      List<AprilTag> inRange = new ArrayList<>();
//      for (AprilTag tag : field.getTags()) {
//          ...compute the distance from your pose to tag.pose...
//          if (distance < 4.0) { inRange.add(tag); }
//      }
//    Math.hypot(dx, dy) gives you the straight-line distance.
// 4. Publish inRange.size() and a string of the IDs. Drive around.
// 5. PREDICT what happens to the count as you drive forward. Then hold W and watch.
//
// WHAT YOU SHOULD SEE: driving straight up the field, something like
//      x=0.67 m: 4 tags (28 29 30 31)
//      x=2.40 m: 5 tags (17 27 28 29 30)
//      x=3.26 m: 6 tags (17 18 27 28 29 30)
//      x=4.12 m: 5 tags (17 18 19 27 28)
// The list grows, shrinks, and swaps members, and you never once said how big it is.
//
// TWO SHAPES, AND WHY IT MATTERS:
//   field.getTags()  - 32 tags, fixed, known before the match. Array-shaped.
//   inRange          - changes every loop. List-shaped.
// Picking the wrong one isn't a style argument. An array here would mean guessing a maximum
// and tracking "how many are actually filled in", which is the bug you'd spend an evening on.
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
