package frc.robot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import edu.wpi.first.hal.HAL;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.simulation.DriverStationSim;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.sim.RobotSim;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.util.HexFormat;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * The whole at-home loop, with no simulator window: the robot program loads a lesson, the lesson
 * drives the simulated robot in Teleoperated, and the log a student would turn in gets written with
 * an unbroken hash chain.
 */
class RobotHarnessTest {
  private static final String LOG_NAME = "frc.lesson.lesson99.basic-output.log";

  /** The seed LessonLogger hashes before the first line. */
  private static final String FIRST_LINE_SEED = "4X#f9qdkEkzHEGGK";

  @Test
  void lessonDrivesTheSimulatedRobotAndGetsLogged() throws Exception {
    Path log = Paths.get(LOG_NAME);
    Files.deleteIfExists(log);

    HAL.initialize(500, 0);
    DriverStationSim.setDsAttached(true);
    DriverStationSim.setAutonomous(false);
    DriverStationSim.setTest(false);
    DriverStationSim.setEnabled(true);
    DriverStationSim.notifyNewData();
    DriverStation.refreshData();

    Robot robot = new Robot(99, false);
    robot.simulationInit();
    RobotSim.start().reset();

    // What TimedRobot does every 20 ms in Teleoperated.
    for (int i = 0; i < 75; i++) {
      DriverStationSim.notifyNewData();
      DriverStation.refreshData();
      robot.teleopPeriodic();
      robot.robotPeriodic();
      robot.simulationPeriodic();
      Thread.sleep(20);
    }

    double x = RobotSim.start().getTruePose().getX();
    System.out.printf("lesson 99 drove the simulated robot %.2f m%n", x);
    assertTrue(x > 1.0, "the lesson should have driven the robot forward");

    List<String> lines = Files.readAllLines(log, StandardCharsets.UTF_8);
    System.out.printf("log has %d lines, last: %s%n", lines.size(), lines.get(lines.size() - 1));
    assertTrue(lines.stream().anyMatch(l -> l.contains("|Drive Speed|Double|0.4|")));
    assertTrue(lines.stream().filter(l -> l.contains("|Left Rotations|")).count() > 3,
        "encoder readings should be logged as they change");
    assertTrue(lines.stream().noneMatch(l -> l.contains("|Sim Field")),
        "the simulator's own values stay out of a student's log");

    String previous = FIRST_LINE_SEED;
    for (String line : lines) {
      String[] fields = line.split("\\|");
      assertEquals(md5(previous), fields[fields.length - 1], "hash chain broken at: " + line);
      previous = line;
    }

    Files.deleteIfExists(log);
  }

  @Test
  void lessonZeroPassesOnceTheStickMovesAndAIsPressed() throws Exception {
    Path log = Paths.get("frc.lesson.lesson00.basic-output.log");
    Files.deleteIfExists(log);

    HAL.initialize(500, 0);
    DriverStationSim.setDsAttached(true);
    DriverStationSim.setAutonomous(false);
    DriverStationSim.setEnabled(true);
    // What a keyboard mapped as controller 0 sends: left stick Y is axis 1, A is button 1.
    DriverStationSim.setJoystickAxisCount(0, 6);
    DriverStationSim.setJoystickButtonCount(0, 10);

    Robot robot = new Robot(0, false);
    for (int i = 0; i < 20; i++) {
      DriverStationSim.setJoystickAxis(0, 1, i < 10 ? -1.0 : 0.0);
      DriverStationSim.setJoystickButton(0, 1, i >= 10);
      DriverStationSim.notifyNewData();
      DriverStation.refreshData();
      robot.teleopPeriodic();
    }

    List<String> lines = Files.readAllLines(log, StandardCharsets.UTF_8);
    assertTrue(lines.stream().anyMatch(l -> l.contains("|Setup Check|String|PASSED")),
        "lesson 00 should report PASSED in the log");
    Files.deleteIfExists(log);
  }

  @Test
  void theSimulatorCheckDrivesWithTheSticks() throws Exception {
    Path log = Paths.get("frc.lesson.lesson98.basic-output.log");
    Files.deleteIfExists(log);

    HAL.initialize(500, 0);
    DriverStationSim.setDsAttached(true);
    DriverStationSim.setAutonomous(false);
    DriverStationSim.setEnabled(true);
    for (int port = 0; port < 2; port++) {
      DriverStationSim.setJoystickAxisCount(port, 6);
      DriverStationSim.setJoystickButtonCount(port, 10);
    }

    // Simulated motors keep their last command, so stop anything an earlier test left running.
    // Otherwise this test would "pass" on leftover motion.
    com.ctre.phoenix6.hardware.TalonFX[] driveMotors = {
      new com.ctre.phoenix6.hardware.TalonFX(1), new com.ctre.phoenix6.hardware.TalonFX(2),
      new com.ctre.phoenix6.hardware.TalonFX(3), new com.ctre.phoenix6.hardware.TalonFX(4)
    };
    RobotSim.start();
    for (int i = 0; i < 15; i++) {
      for (com.ctre.phoenix6.hardware.TalonFX m : driveMotors) m.set(0);
      RobotSim.start().update();
      Thread.sleep(20);
    }
    RobotSim.start().reset();
    assertEquals(0, RobotSim.start().getTruePose().getX(), 0.05, "robot should start still");

    Robot robot = new Robot(98, false);
    robot.simulationInit();

    // Hold W (left stick forward) and the operator's A.
    for (int i = 0; i < 75; i++) {
      DriverStationSim.setJoystickAxis(0, 1, -1.0);
      DriverStationSim.setJoystickButton(1, 1, true);
      DriverStationSim.notifyNewData();
      DriverStation.refreshData();
      robot.teleopPeriodic();
      robot.robotPeriodic();
      robot.simulationPeriodic();
      Thread.sleep(20);
    }

    double x = RobotSim.start().getTruePose().getX();
    System.out.printf("simulator check: drove %.2f m with W held%n", x);
    assertTrue(x > 1.0, "holding W should drive the robot forward");

    List<String> lines = Files.readAllLines(log, StandardCharsets.UTF_8);
    assertTrue(lines.stream().anyMatch(l -> l.contains("|Demo/Driver Left Y (W and S)|")),
        "grouped keys like Demo/... have to be logged, not just top-level ones");
    assertTrue(lines.stream().anyMatch(l -> l.contains("|Demo/Roller Speed (RPS)|Double|-")),
        "the operator's A should spin the rollers");
    Files.deleteIfExists(log);
  }

  @Test
  void anEmptyLessonSaysSoInsteadOfLookingBroken() throws Exception {
    HAL.initialize(500, 0);
    DriverStationSim.setDsAttached(true);
    DriverStationSim.setAutonomous(false);
    DriverStationSim.setEnabled(true);
    DriverStationSim.notifyNewData();
    DriverStation.refreshData();

    java.io.ByteArrayOutputStream console = new java.io.ByteArrayOutputStream();
    java.io.PrintStream realOut = System.out;
    Robot robot;
    try {
      System.setOut(new java.io.PrintStream(console, true));
      robot = new Robot(1, false); // lesson 01 basic: an empty stub, like a student's first run
      for (int i = 0; i < 260; i++) {
        robot.teleopPeriodic();
      }
    } finally {
      System.setOut(realOut);
    }

    String printed = console.toString();
    System.out.println("console said: " + printed.trim());
    assertTrue(printed.contains("set the robot to Teleoperated"), "loading should say how to start it");
    assertTrue(printed.contains("hasn't put anything on SmartDashboard yet"),
        "an empty lesson should explain itself");
    java.nio.file.Files.deleteIfExists(Paths.get("frc.lesson.lesson01.basic-output.log"));
  }

  @Test
  void myRobotRunsTheContainersAutoThenStopsItForTeleop() throws Exception {
    Path log = Paths.get("frc.lesson.myrobot-output.log");
    Files.deleteIfExists(log);

    HAL.initialize(500, 0);
    DriverStationSim.setDsAttached(true);
    DriverStationSim.setAutonomous(true);
    DriverStationSim.setEnabled(true);
    DriverStationSim.notifyNewData();
    DriverStation.refreshData();

    Robot robot = new Robot("frc.robot.StandInRobotContainer");
    robot.autonomousInit();
    for (int i = 0; i < 30; i++) {
      robot.robotPeriodic();
    }
    double autoLoops = SmartDashboard.getNumber("StandIn/Auto Loops", 0);
    assertTrue(autoLoops >= 25, "Autonomous should run the container's command, ran " + autoLoops);

    DriverStationSim.setAutonomous(false);
    DriverStationSim.notifyNewData();
    DriverStation.refreshData();
    robot.teleopInit();
    for (int i = 0; i < 10; i++) {
      robot.robotPeriodic();
      robot.teleopPeriodic();
    }
    assertEquals("auto stopped", SmartDashboard.getString("StandIn/State", ""));
    assertEquals(autoLoops, SmartDashboard.getNumber("StandIn/Auto Loops", 0), 1,
        "the autonomous command should stop when Teleoperated starts");

    List<String> lines = Files.readAllLines(log, StandardCharsets.UTF_8);
    assertTrue(lines.stream().anyMatch(l -> l.contains("|StandIn/Auto Loops|")),
        "a whole robot run is logged, Autonomous included");
    String previous = FIRST_LINE_SEED;
    for (String line : lines) {
      String[] fields = line.split("\\|");
      assertEquals(md5(previous), fields[fields.length - 1], "hash chain broken at: " + line);
      previous = line;
    }
    Files.deleteIfExists(log);
  }

  @Test
  void myRobotWithNoRobotContainerSaysSo() {
    HAL.initialize(500, 0);
    java.io.ByteArrayOutputStream console = new java.io.ByteArrayOutputStream();
    java.io.PrintStream realOut = System.out;
    try {
      System.setOut(new java.io.PrintStream(console, true));
      Robot robot = new Robot("frc.robot.NoSuchRobotContainer");
      robot.autonomousInit();
      robot.robotPeriodic();
      robot.teleopInit();
      robot.teleopPeriodic();
    } finally {
      System.setOut(realOut);
    }
    assertTrue(console.toString().contains("Lesson 42 is where you make it"),
        "a missing RobotContainer should be explained, not crash");
  }

  private static String md5(String text) throws Exception {
    byte[] digest = MessageDigest.getInstance("MD5").digest(text.getBytes(StandardCharsets.UTF_8));
    return HexFormat.of().formatHex(digest);
  }
}
