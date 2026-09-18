package frc.lesson.lesson98.basic;

import com.ctre.phoenix6.configs.MotorOutputConfigs;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.lesson.LessonBase;

/**
 * Lesson 98 is not a lesson. It's the simulator check: run it to prove your simulator, your
 * keyboard and the robot's motors all work, before you've written a single line yourself.
 *
 * <p>Set {@code LESSON = 98} in PickYourLesson, simulate, click Teleoperated, then:
 *
 * <ul>
 *   <li><b>W / S</b> drive forward and back, <b>J / L</b> turn
 *   <li><b>5</b> (the operator's A) spins the launcher rollers
 *   <li><b>Up / down arrows</b> run the climber
 *   <li>Watch the robot move under NetworkTables → SmartDashboard → <b>Sim Field</b>
 *   <li>Every key you press shows up under <b>Demo/</b>
 * </ul>
 *
 * <p>It drives using WPILib's {@code DifferentialDrive}, which is lesson 32's job. Lessons 03, 04
 * and 05 ask you to do this the hard way on purpose, so copying this file skips the lessons rather
 * than doing them.
 */
public class Lesson98 extends LessonBase {
  private XboxController driver;
  private XboxController operator;
  private TalonFX leftLeader;
  private TalonFX leftFollower;
  private TalonFX rightLeader;
  private TalonFX rightFollower;
  private TalonFX leftRoller;
  private TalonFX rightRoller;
  private TalonFX climber;
  private DifferentialDrive drive;

  @Override
  public void setup() {
    driver = new XboxController(0);
    operator = new XboxController(1);

    leftLeader = new TalonFX(1);
    leftFollower = new TalonFX(3);
    rightLeader = new TalonFX(2);
    rightFollower = new TalonFX(4);
    leftRoller = new TalonFX(5);
    rightRoller = new TalonFX(6);
    climber = new TalonFX(7);

    // The right side of this robot is mounted backwards, so it gets inverted. Lesson 28.
    invert(rightLeader, InvertedValue.Clockwise_Positive);
    invert(rightFollower, InvertedValue.Clockwise_Positive);
    invert(leftLeader, InvertedValue.CounterClockwise_Positive);
    invert(leftFollower, InvertedValue.CounterClockwise_Positive);
    invert(rightRoller, InvertedValue.Clockwise_Positive);
    invert(leftRoller, InvertedValue.CounterClockwise_Positive);

    drive = new DifferentialDrive(this::driveLeft, this::driveRight);
  }

  @Override
  public void execute() {
    drive.arcadeDrive(-driver.getLeftY(), -driver.getRightX());

    double rollerPower = operator.getAButton() ? -0.5 : 0;
    leftRoller.set(rollerPower);
    rightRoller.set(rollerPower);

    double climbPower = 0;
    if (driver.getPOV() == 0) {
      climbPower = 0.4;
    } else if (driver.getPOV() == 180) {
      climbPower = -0.4;
    }
    climber.set(climbPower);

    // Everything the robot is hearing and doing, so you can tell which half is broken.
    SmartDashboard.putNumber("Demo/Driver Left Y (W and S)", driver.getLeftY());
    SmartDashboard.putNumber("Demo/Driver Right X (J and L)", driver.getRightX());
    SmartDashboard.putNumber("Demo/Driver POV (arrows)", driver.getPOV());
    SmartDashboard.putBoolean("Demo/Operator A (the 5 key)", operator.getAButton());
    SmartDashboard.putNumber("Demo/Left Wheel Rotations", leftLeader.getPosition().getValueAsDouble());
    SmartDashboard.putNumber("Demo/Roller Speed (RPS)", leftRoller.getVelocity().getValueAsDouble());
    SmartDashboard.putNumber("Demo/Climber Rotations", climber.getPosition().getValueAsDouble());
  }

  private void driveLeft(double power) {
    leftLeader.set(power);
    leftFollower.set(power);
  }

  private void driveRight(double power) {
    rightLeader.set(power);
    rightFollower.set(power);
  }

  private static void invert(TalonFX motor, InvertedValue inverted) {
    motor.getConfigurator().apply(new MotorOutputConfigs().withInverted(inverted));
  }
}
