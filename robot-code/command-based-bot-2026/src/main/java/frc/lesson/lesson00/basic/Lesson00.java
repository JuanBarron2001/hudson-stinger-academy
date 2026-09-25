package frc.lesson.lesson00.basic;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.lesson.LessonBase;

/**
 * Lesson 00: setup check. You don't write anything here. This lesson proves your simulator, your
 * keyboard-as-a-controller, and your log file all work before lesson 01 depends on them.
 *
 * <p>What to do is in lessons/LESSON00.md.
 */
public class Lesson00 extends LessonBase {
  private XboxController controller;
  private boolean movedStick = false;
  private boolean pressedA = false;

  @Override
  public void setup() {
    controller = new XboxController(0);
    SmartDashboard.putString("Setup Check", "Waiting for Teleoperated...");
  }

  @Override
  public void execute() {
    double leftY = controller.getLeftY();
    SmartDashboard.putNumber("Left Stick Y", leftY);
    SmartDashboard.putBoolean("A Button", controller.getAButton());

    if (Math.abs(leftY) > 0.5) {
      movedStick = true;
    }
    if (controller.getAButton()) {
      pressedA = true;
    }
    SmartDashboard.putBoolean("Moved Stick", movedStick);
    SmartDashboard.putBoolean("Pressed A", pressedA);

    if (movedStick && pressedA) {
      SmartDashboard.putString("Setup Check", "PASSED - close the simulator and commit your log");
    } else {
      SmartDashboard.putString("Setup Check", "Move the left stick all the way, and press A");
    }
  }
}
