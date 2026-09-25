package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;

/**
 * A stand-in for a student's RobotContainer, so the MY_ROBOT switch can be tested without shipping
 * a real one in the academy repo. Its autonomous command counts loops until it's cancelled.
 */
public class StandInRobotContainer {
  private int autoLoops = 0;

  public StandInRobotContainer() {
    SmartDashboard.putString("StandIn/State", "built");
  }

  public Command getAutonomousCommand() {
    return Commands.run(() -> SmartDashboard.putNumber("StandIn/Auto Loops", ++autoLoops))
        .finallyDo(() -> SmartDashboard.putString("StandIn/State", "auto stopped"));
  }
}
