package frc.robot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import edu.wpi.first.hal.HAL;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.simulation.DriverStationSim;
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

  private static String md5(String text) throws Exception {
    byte[] digest = MessageDigest.getInstance("MD5").digest(text.getBytes(StandardCharsets.UTF_8));
    return HexFormat.of().formatHex(digest);
  }
}
