package frc.sim;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.ctre.phoenix6.configs.MotorOutputConfigs;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.hardware.Pigeon2;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import edu.wpi.first.hal.HAL;
import edu.wpi.first.wpilibj.simulation.DriverStationSim;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Proves the simulator behaves like the real 2026 robot, using the kind of code a student writes.
 * If these pass, robot lessons can be done at home with no robot.
 *
 * <p>Each loop sleeps 20 ms, because the simulated Phoenix devices run in real time.
 */
class RobotSimTest {
  private static RobotSim sim;

  @BeforeAll
  static void startSimulator() {
    HAL.initialize(500, 0);
    DriverStationSim.setDsAttached(true);
    DriverStationSim.setEnabled(true);
    DriverStationSim.notifyNewData();
    sim = RobotSim.start();
  }

  @BeforeEach
  void putRobotBack() {
    sim.reset();
  }

  /** Runs student code and the simulator together for the given number of 20 ms loops. */
  private static void runLoops(int loops, Runnable studentCode) throws InterruptedException {
    for (int i = 0; i < loops; i++) {
      DriverStationSim.setEnabled(true);
      DriverStationSim.notifyNewData();
      studentCode.run();
      sim.update();
      Thread.sleep(20);
    }
  }

  /**
   * Stops every motor a previous test left running, then puts the robot back at the origin. Phoenix
   * devices keep their last command, so without this a test starts with the last test's motion.
   */
  private static void settle(TalonFX... motors) throws InterruptedException {
    runLoops(10, () -> { for (TalonFX m : motors) m.set(0); });
    sim.reset();
  }

  private static TalonFX motor(int id, InvertedValue invert) {
    TalonFX motor = new TalonFX(id);
    motor
        .getConfigurator()
        .apply(new TalonFXConfiguration().withMotorOutput(new MotorOutputConfigs().withInverted(invert)));
    return motor;
  }

  @Test
  void drivetrainDrivesStraightWhenTheRightSideIsInverted() throws InterruptedException {
    TalonFX[] left = {motor(1, InvertedValue.CounterClockwise_Positive), motor(3, InvertedValue.CounterClockwise_Positive)};
    TalonFX[] right = {motor(2, InvertedValue.Clockwise_Positive), motor(4, InvertedValue.Clockwise_Positive)};
    settle(left[0], left[1], right[0], right[1]);

    runLoops(
        100,
        () -> {
          for (TalonFX m : left) m.set(0.5);
          for (TalonFX m : right) m.set(0.5);
        });

    double x = sim.getTruePose().getX();
    double heading = sim.getTruePose().getRotation().getDegrees();
    System.out.printf("straight: x=%.2f m, heading=%.1f deg, left encoder=%.1f rot%n", x, heading, left[0].getPosition().getValueAsDouble());
    assertTrue(x > 2.0, "robot should drive forward a couple of meters in 2 s at half power");
    assertEquals(0, heading, 2.0, "robot should drive straight");
    assertTrue(left[0].getPosition().getValueAsDouble() > 10, "the student's encoder should count forward");
  }

  @Test
  void drivetrainSpinsInPlaceWhenTheRightSideIsNotInverted() throws InterruptedException {
    TalonFX[] all = {
      motor(1, InvertedValue.CounterClockwise_Positive), motor(3, InvertedValue.CounterClockwise_Positive),
      motor(2, InvertedValue.CounterClockwise_Positive), motor(4, InvertedValue.CounterClockwise_Positive)
    };
    settle(all);

    runLoops(50, () -> { for (TalonFX m : all) m.set(0.5); });

    double x = sim.getTruePose().getX();
    double heading = sim.getTruePose().getRotation().getDegrees();
    System.out.printf("forgot invert: x=%.2f m, heading=%.1f deg%n", x, heading);
    assertEquals(0, x, 0.2, "robot should barely move forward");
    assertTrue(Math.abs(heading) > 45, "robot should spin");
  }

  @Test
  void gyroFollowsTheRobot() throws InterruptedException {
    TalonFX[] left = {motor(1, InvertedValue.CounterClockwise_Positive), motor(3, InvertedValue.CounterClockwise_Positive)};
    TalonFX[] right = {motor(2, InvertedValue.Clockwise_Positive), motor(4, InvertedValue.Clockwise_Positive)};
    Pigeon2 pigeon = new Pigeon2(11);
    settle(left[0], left[1], right[0], right[1]);
    runLoops(5, () -> {});
    // Compare changes, not absolute angles: the Pigeon's yaw keeps counting past 360 degrees, so a
    // test that ran earlier and spun the robot can leave it at any starting value.
    double gyroBefore = pigeon.getYaw().getValueAsDouble();

    // Left side backward, right side forward: turns counterclockwise (left).
    runLoops(30, () -> {
      for (TalonFX m : left) m.set(-0.3);
      for (TalonFX m : right) m.set(0.3);
    });
    runLoops(5, () -> {});

    double trueTurn = sim.getTruePose().getRotation().getDegrees();
    double gyroTurn = pigeon.getYaw().getValueAsDouble() - gyroBefore;
    System.out.printf("turn left: true turn=%.1f deg, pigeon turn=%.1f deg%n", trueTurn, gyroTurn);
    assertTrue(trueTurn > 10, "turning left should be a positive heading");
    assertEquals(trueTurn, gyroTurn, 5.0, "the Pigeon should read how far the robot turned");
  }

  @Test
  void flywheelReachesTargetWithTheCompetitionGains() throws InterruptedException {
    TalonFX left = motor(5, InvertedValue.CounterClockwise_Positive);
    TalonFX right = motor(6, InvertedValue.Clockwise_Positive);
    Slot0Configs gains = new Slot0Configs().withKS(0.15).withKV(0.12).withKP(0.1);
    left.getConfigurator().apply(gains);
    right.getConfigurator().apply(gains);
    VelocityVoltage request = new VelocityVoltage(-80);
    settle(left, right);

    runLoops(100, () -> {
      left.setControl(request);
      right.setControl(request);
    });

    double rps = (left.getVelocity().getValueAsDouble() + right.getVelocity().getValueAsDouble()) / 2;
    System.out.printf("flywheel: target -80 rps, actual %.1f rps%n", rps);
    assertEquals(-80, rps, 3.0, "flywheel should hold -80 RPS within the competition code's tolerance");
  }

  @Test
  void rollersSpinTogetherOnTheSameNumberAndStallWhenTheyFight() throws InterruptedException {
    TalonFX left = motor(5, InvertedValue.CounterClockwise_Positive);
    TalonFX right = motor(6, InvertedValue.Clockwise_Positive);
    settle(left, right);

    // Both motors turn the same rollers, so a lesson gives them the same number.
    runLoops(60, () -> {
      left.set(-0.7);
      right.set(-0.7);
    });
    double together = left.getVelocity().getValueAsDouble();
    System.out.printf("rollers, same number: %.1f RPS%n", together);
    assertTrue(together < -20, "rollers should spin the launch way on the same number, got " + together);

    settle(left, right);

    // Opposite numbers are the classic mistake: the two motors fight and nothing turns.
    runLoops(60, () -> {
      left.set(-0.7);
      right.set(0.7);
    });
    double fighting = left.getVelocity().getValueAsDouble();
    System.out.printf("rollers, fighting:    %.1f RPS%n", fighting);
    assertEquals(0, fighting, 1.0, "rollers should stall when the two motors disagree");
  }

  @Test
  void conveyorAndClimberMove() throws InterruptedException {
    TalonFX conveyor = motor(29, InvertedValue.CounterClockwise_Positive);
    TalonFX climber = motor(7, InvertedValue.CounterClockwise_Positive);
    settle(conveyor, climber);

    runLoops(25, () -> {
      conveyor.set(0.3);
      climber.set(-0.3);
    });

    double conveyorRotations = conveyor.getPosition().getValueAsDouble();
    double climberRotations = climber.getPosition().getValueAsDouble();
    System.out.printf("conveyor=%.1f rot, climber=%.1f rot%n", conveyorRotations, climberRotations);
    assertTrue(conveyorRotations > 5, "conveyor should spin forward");
    assertTrue(climberRotations < -2, "climber should run backward (it has more inertia, so it is slower)");
  }
}
