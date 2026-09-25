package frc.sim;

import com.ctre.phoenix6.hardware.Pigeon2;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.sim.ChassisReference;
import com.ctre.phoenix6.sim.TalonFXSimState;
import edu.wpi.first.math.VecBuilder;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.math.system.plant.LinearSystemId;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.simulation.DCMotorSim;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim;
import edu.wpi.first.wpilibj.simulation.FlywheelSim;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Makes the 2026 robot move in simulation, so robot lessons can be done at home.
 *
 * <p><b>Students don't edit this, and don't need to read it.</b> It's mentor-maintained.
 *
 * <p>How it works: a Phoenix 6 motor in simulation only moves if something tells it how fast its
 * rotor is spinning. Every loop, this class reads the voltage each simulated motor is putting out,
 * runs it through a physics model, and writes the resulting rotor position and speed back. It opens
 * its own handles to the motors by CAN ID, which point at the same simulated devices a lesson
 * creates, so it works no matter how a student writes their code.
 *
 * <p>Motors are mounted the way they are on the real robot, so a student's inversions matter here
 * too. Forget to invert the right side of the drivetrain and the robot spins in place, exactly like
 * it would on carpet. The motor model is the Kraken X60, because that is the only motor CTRE's
 * simulator models, and {@code set()} uses FOC by default.
 *
 * <p>Numbers marked "estimate" were not measured on the robot.
 */
public final class RobotSim {
  // CAN IDs from the 2026 competition code. See ROBOT.md.
  private static final int LEFT_LEADER_ID = 1;
  private static final int RIGHT_LEADER_ID = 2;
  private static final int LEFT_FOLLOWER_ID = 3;
  private static final int RIGHT_FOLLOWER_ID = 4;
  private static final int LEFT_LAUNCHER_ID = 5;
  private static final int RIGHT_LAUNCHER_ID = 6;
  private static final int CLIMBER_ID = 7;
  private static final int PIGEON_ID = 11;
  private static final int CONVEYOR_ID = 29;

  // Drivetrain numbers from the 2026 competition code. They match the kitbot template's defaults,
  // and nobody has confirmed they were measured on the real robot.
  private static final double DRIVE_GEAR_RATIO = 10.71;
  private static final double WHEEL_DIAMETER_METERS = Units.inchesToMeters(6);
  private static final double TRACK_WIDTH_METERS = 0.56;
  private static final double ROBOT_MASS_KG = 55; // estimate
  private static final double ROBOT_MOI_KG_M2 = 4.5; // estimate

  private static final double LAUNCHER_MOI_KG_M2 = 0.002; // estimate
  private static final double CONVEYOR_MOI_KG_M2 = 0.001; // estimate
  private static final double CLIMBER_MOI_KG_M2 = 0.002; // estimate, low enough that it stops near a soft limit

  private static final double DT_SECONDS = 0.02;

  private static RobotSim instance;

  private final TalonFX leftLeader = new TalonFX(LEFT_LEADER_ID);
  private final TalonFX leftFollower = new TalonFX(LEFT_FOLLOWER_ID);
  private final TalonFX rightLeader = new TalonFX(RIGHT_LEADER_ID);
  private final TalonFX rightFollower = new TalonFX(RIGHT_FOLLOWER_ID);
  private final TalonFX leftLauncher = new TalonFX(LEFT_LAUNCHER_ID);
  private final TalonFX rightLauncher = new TalonFX(RIGHT_LAUNCHER_ID);
  private final TalonFX conveyor = new TalonFX(CONVEYOR_ID);
  private final TalonFX climber = new TalonFX(CLIMBER_ID);
  private final Pigeon2 pigeon = new Pigeon2(PIGEON_ID);

  private final DifferentialDrivetrainSim drivetrain =
      new DifferentialDrivetrainSim(
          DCMotor.getKrakenX60Foc(2),
          DRIVE_GEAR_RATIO,
          ROBOT_MOI_KG_M2,
          ROBOT_MASS_KG,
          WHEEL_DIAMETER_METERS / 2,
          TRACK_WIDTH_METERS,
          null);

  private final FlywheelSim launcherRollers =
      new FlywheelSim(
          LinearSystemId.createFlywheelSystem(DCMotor.getKrakenX60Foc(2), LAUNCHER_MOI_KG_M2, 1.0),
          DCMotor.getKrakenX60Foc(2));

  private final DCMotorSim conveyorRoller = motorSim(CONVEYOR_MOI_KG_M2);
  private final DCMotorSim climberWinch = motorSim(CLIMBER_MOI_KG_M2);

  private double launcherRotations = 0;

  /** Shows where the simulated robot really is. Look for "Sim Field" in the simulator. */
  private final Field2d field = new Field2d();

  /** Call once from Robot.simulationInit(). */
  public static RobotSim start() {
    if (instance == null) {
      instance = new RobotSim();
    }
    return instance;
  }

  private RobotSim() {
    // How each motor is mounted: which way the rotor turns when the mechanism moves "forward".
    // These come from the inversions the 2026 competition code needed.
    mount(leftLeader, ChassisReference.CounterClockwise_Positive);
    mount(leftFollower, ChassisReference.CounterClockwise_Positive);
    mount(rightLeader, ChassisReference.Clockwise_Positive);
    mount(rightFollower, ChassisReference.Clockwise_Positive);
    mount(leftLauncher, ChassisReference.CounterClockwise_Positive);
    mount(rightLauncher, ChassisReference.Clockwise_Positive);
    mount(conveyor, ChassisReference.CounterClockwise_Positive);
    mount(climber, ChassisReference.CounterClockwise_Positive);

    SmartDashboard.putData("Sim Field", field);
  }

  /** Call every loop from Robot.simulationPeriodic(). */
  public void update() {
    double battery = RobotController.getBatteryVoltage();
    for (TalonFX motor :
        new TalonFX[] {
          leftLeader, leftFollower, rightLeader, rightFollower,
          leftLauncher, rightLauncher, conveyor, climber
        }) {
      motor.getSimState().setSupplyVoltage(battery);
    }
    pigeon.getSimState().setSupplyVoltage(battery);

    updateDrivetrain();
    updateLauncher();
    updateMotor(conveyor, conveyorRoller);
    updateMotor(climber, climberWinch);
  }

  private void updateDrivetrain() {
    // Two motors share each gearbox. If they disagree, they fight, and the side barely moves.
    double leftVolts = average(leftLeader, leftFollower);
    double rightVolts = average(rightLeader, rightFollower);
    drivetrain.setInputs(leftVolts, rightVolts);
    drivetrain.update(DT_SECONDS);

    double rotorRotationsPerMeter = DRIVE_GEAR_RATIO / (Math.PI * WHEEL_DIAMETER_METERS);
    double leftRotations = drivetrain.getLeftPositionMeters() * rotorRotationsPerMeter;
    double leftRps = drivetrain.getLeftVelocityMetersPerSecond() * rotorRotationsPerMeter;
    double rightRotations = drivetrain.getRightPositionMeters() * rotorRotationsPerMeter;
    double rightRps = drivetrain.getRightVelocityMetersPerSecond() * rotorRotationsPerMeter;

    setRotor(leftLeader, leftRotations, leftRps);
    setRotor(leftFollower, leftRotations, leftRps);
    setRotor(rightLeader, rightRotations, rightRps);
    setRotor(rightFollower, rightRotations, rightRps);

    pigeon.getSimState().setRawYaw(drivetrain.getHeading().getDegrees());
    field.setRobotPose(drivetrain.getPose());
  }

  private void updateLauncher() {
    // The two launcher motors turn the same rollers, so they share one physics model.
    launcherRollers.setInputVoltage(average(leftLauncher, rightLauncher));
    launcherRollers.update(DT_SECONDS);

    double rps = Units.radiansToRotations(launcherRollers.getAngularVelocityRadPerSec());
    launcherRotations += rps * DT_SECONDS;
    setRotor(leftLauncher, launcherRotations, rps);
    setRotor(rightLauncher, launcherRotations, rps);
  }

  /** Where the simulated robot really is, for tests and mentors. Lessons use their own sensors. */
  public Pose2d getTruePose() {
    return drivetrain.getPose();
  }

  /** Puts the robot back at the origin and stops every mechanism. For tests. */
  public void reset() {
    drivetrain.setPose(new Pose2d());
    drivetrain.setInputs(0, 0);
    drivetrain.setState(VecBuilder.fill(0, 0, 0, 0, 0, 0, 0));
    launcherRollers.setAngularVelocity(0);
    launcherRotations = 0;
    conveyorRoller.setState(0, 0);
    climberWinch.setState(0, 0);
    update();
  }

  private static void updateMotor(TalonFX motor, DCMotorSim physics) {
    physics.setInputVoltage(motor.getSimState().getMotorVoltage());
    physics.update(DT_SECONDS);
    setRotor(
        motor,
        physics.getAngularPositionRotations(),
        Units.radiansToRotations(physics.getAngularVelocityRadPerSec()));
  }

  private static DCMotorSim motorSim(double moi) {
    return new DCMotorSim(
        LinearSystemId.createDCMotorSystem(DCMotor.getKrakenX60Foc(1), moi, 1.0),
        DCMotor.getKrakenX60Foc(1));
  }

  private static void mount(TalonFX motor, ChassisReference orientation) {
    TalonFXSimState sim = motor.getSimState();
    sim.Orientation = orientation;
    sim.setMotorType(TalonFXSimState.MotorType.KrakenX60);
  }

  private static double average(TalonFX a, TalonFX b) {
    return (a.getSimState().getMotorVoltage() + b.getSimState().getMotorVoltage()) / 2;
  }

  private static void setRotor(TalonFX motor, double rotations, double rotationsPerSecond) {
    motor.getSimState().setRawRotorPosition(rotations);
    motor.getSimState().setRotorVelocity(rotationsPerSecond);
  }
}
