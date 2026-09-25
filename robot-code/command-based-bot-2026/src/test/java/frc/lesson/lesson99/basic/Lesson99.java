package frc.lesson.lesson99.basic;

import com.ctre.phoenix6.configs.MotorOutputConfigs;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.lesson.LessonBase;

/**
 * Not a real lesson. {@code RobotHarnessTest} uses it to prove that a lesson written the way
 * students write them can drive the simulated robot and end up in the log.
 */
public class Lesson99 extends LessonBase {
  private TalonFX leftLeader;
  private TalonFX leftFollower;
  private TalonFX rightLeader;
  private TalonFX rightFollower;

  @Override
  public void setup() {
    leftLeader = new TalonFX(1);
    leftFollower = new TalonFX(3);
    rightLeader = new TalonFX(2);
    rightFollower = new TalonFX(4);

    MotorOutputConfigs rightSide = new MotorOutputConfigs().withInverted(InvertedValue.Clockwise_Positive);
    rightLeader.getConfigurator().apply(rightSide);
    rightFollower.getConfigurator().apply(rightSide);
    MotorOutputConfigs leftSide = new MotorOutputConfigs().withInverted(InvertedValue.CounterClockwise_Positive);
    leftLeader.getConfigurator().apply(leftSide);
    leftFollower.getConfigurator().apply(leftSide);
  }

  @Override
  public void execute() {
    double speed = 0.4;
    leftLeader.set(speed);
    leftFollower.set(speed);
    rightLeader.set(speed);
    rightFollower.set(speed);

    SmartDashboard.putNumber("Drive Speed", speed);
    SmartDashboard.putNumber("Left Rotations", leftLeader.getPosition().getValueAsDouble());
  }
}
