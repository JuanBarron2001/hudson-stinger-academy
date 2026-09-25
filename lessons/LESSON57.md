# 🤖 Lesson 57 – Capstone: Your Whole Robot

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🏁  

---

## 🎯 Overview
**Keywords:** Capstone, `RobotContainer`, Button Bindings, Autonomous, PathPlanner, Deploying  
This lesson doesn't teach a new Java idea. It uses all of them at once:
- Read a real robot log with the Java you already know: `ArrayList`, `HashMap`, exceptions and lambdas  
- Put every class you've written since [Lesson 27](./LESSON27.md) into one robot program that you run instead of a lesson  
- Get last season's PathPlanner autonomous running on **your** code, which last season's team never managed  
- Write down what you'd change about last season's robot code before 2027, with evidence  

> 🧑‍🏫 **This lesson needs robot time.** The simulator half is homework like any other lesson. Deploying to the real robot happens at a meeting, with a mentor, and you'll probably need more than one meeting for it.

---

## ⏱️ Progress Tracking

**There is no video for this one.** It's a project, not a topic, so no video in the playlist matches it. Everything you need is on this page and in the lessons it links to.

---

## 💻 Part 1 – Java‑Only (2 pts)

Every lesson you've turned in was a **log file**: one line per value that changed, each line ending in a hash. In this part you write the program that reads one.

The file is `java-lessons/resources/lesson57-robot-log.txt`. It's a real log, from a robot built the way you're building yours, running last season's `PP Depot And Climb` autonomous in the simulator. Each line looks like this:

```
20260924233931877|Climber/Position|Double|0.0|f3dd36ae9d9d47b90b3608dcdadf7ed4
  when (to the ms) | key            | type | value | hash of the line BEFORE this one
```

**Reading a file** is [Lesson 47](./LESSON47.md), which is Optional, so here is the only line of it you need. It reads every line of a file into a `List<String>`:

```java
List<String> lines = Files.readAllLines(Path.of("resources/lesson57-robot-log.txt"));
```

It needs `import java.nio.file.Files;`, `java.nio.file.Path` and `java.util.List`. It **throws `IOException`** if the file isn't there, so the compiler makes you deal with that: [Lesson 45](./LESSON45.md).

**Basic (1 pt)**: what did the robot do?  

- Read the file inside a `try`. If it throws, print `Couldn't read the log: ` and the exception's message, and stop. Then print how many lines there are.  
- Split each line on `|`. Careful: `split` takes a pattern, where `|` means "or", so you have to write it `"\\|"`. The key is the second piece.  
- Count how many times each key changed, in a `HashMap<String, Integer>` ([Lesson 52](./LESSON52.md)). Print how many **different** keys there are.  
- Put the map's entries in an `ArrayList<Map.Entry<String, Integer>>` and sort it busiest first, with a lambda that compares two entries' values ([Lesson 56](./LESSON56.md)). Print the top three.  
- While you're looping, collect every value of `Fuel/Doing` into an `ArrayList<String>` and print it. That's the story of the whole autonomous.  

Expected output (`Drive/Pose Y` and `Drive/Pose X` tie, so they may come out in either order):  

```
Lines: 382
Different keys: 22
Climber/Position changed 118 times
Drive/Pose Y changed 73 times
Drive/Pose X changed 73 times
The fuel mechanism did: [INTAKE, stopped, SHOOT, stopped]
```

- 🧪 Change the file name to one that doesn't exist, and **predict the output first**. Then change it back.  

**Extra (1 pt)**: check the chain  

The last piece of every line is the **MD5 hash of the line before it**. The first line uses a fixed starting text instead, `4X#f9qdkEkzHEGGK`. Change one character anywhere, and the hash stored on the *next* line stops matching. That's how a mentor can tell a log came straight from the robot.

- MD5 is a library call, not the point of this lesson, so here's a helper to copy as it is (it needs `java.security.MessageDigest`, `java.security.NoSuchAlgorithmException`, `java.nio.charset.StandardCharsets` and `java.util.HexFormat`):  

```java
static String md5(String text) {
    try {
        byte[] digest = MessageDigest.getInstance("MD5").digest(text.getBytes(StandardCharsets.UTF_8));
        return HexFormat.of().formatHex(digest);
    } catch (NoSuchAlgorithmException e) {
        throw new RuntimeException(e);   // every Java has MD5, so this never happens
    }
}
```

- Write `static int firstBrokenLine(List<String> lines)`. It returns the line number (counting from 1) of the first line whose stored hash isn't `md5(` of the line before it, or `-1` if every line checks out. Start `previous` at the fixed starting text. The stored hash is everything after the **last** `|`, which `lastIndexOf` finds.  
- Run it on the sample log.  
- Now, **in memory only** (never edit the real file), change line 3's value from `0.0` to `400.0` with `lines.set(...)` and check again. **Predict which line it reports before you run.**  

Expected output:  

```
Chain OK: all 382 lines check out
After editing line 3: BROKEN at line 4
```

- **Line 4, not line 3.** Line 3's own hash describes line 2, which you didn't touch. It's line 4 that holds a fingerprint of line 3, and that fingerprint doesn't match any more.  
- Point it at your own logs too: `lesson56.basic-output.log` in `java-lessons/` uses the same format and the same starting text.  

> 🔐 **Be honest about what this proves.** Now that you've written the checker, you could also write a program that *makes* a valid-looking log. So could anyone who reads `LessonLogger.java`, which is public. The chain catches accidents and lazy edits. It can't stop someone who's determined to fake it. The real check has always been a mentor watching your code run.

---

## 🤖 Part 2 – Robot Code: the 2026 Robot (2 pts)

This time there's no lesson file to write. Your robot **is** the exercise.

> 🔀 **The switch.** Open `robot-code/command-based-bot-2026/src/main/java/frc/robot/PickYourLesson.java` and set `MY_ROBOT = true`. The simulator then ignores `LESSON` and `EXTRA` and builds **your** `frc/robot/RobotContainer.java` instead, the same way last season's `Robot.java` did. It runs your `getAutonomousCommand()` when you pick **Autonomous**, stops it when you switch to **Teleoperated**, and logs everything to `frc.lesson.myrobot-output.log`. That log is what you turn in.

The task list is also at the top of `frc/lesson/lesson57/basic/Lesson57.java` (and `extra/`). Those files stay empty.

**Basic (1 pt)**: the whole robot, in one container  

Your `RobotContainer` from [Lesson 42](./LESSON42.md) owns the drivetrain, the fuel mechanism and the climber. Finish it:

- **Driving.** `TeleopDrive` is the drivetrain's default command, as in lesson 42.  
- **Every ball path on a button,** with `Trigger`s built in the constructor ([Lesson 56](./LESSON56.md)): operator **B** intake, **left bumper** eject, **A** shoot, **right bumper** shuttle. Each one runs `fuel.follow(BallPath...)` from [Lesson 53](./LESSON53.md) while the button is held.  
- **Climbing,** on the driver's right trigger, with your `DynamicClimb` and a lambda.  
- **An auto chooser** ([Lesson 38](./LESSON38.md)) with the autos you've built, `ShootAndClimb` from lesson 42 included, published to the dashboard.  
- `public Command getAutonomousCommand()`, returning whatever the chooser has selected. **The name has to be exactly that.** The host looks for it by name, and says so in the console if it can't find it.  
- **`update()` should be empty now,** and nothing outside `RobotContainer` should mention a motor.  

Then, in the simulator:

- **Teleoperated:** drive, and try every button. The numbers are the ones you measured in lessons 13, 37 and 53: intake spins the rollers to **−67.9 RPS**, and so on. If a button does nothing, check the console before you touch the code.  
- **Autonomous:** pick an auto from the chooser, switch to Autonomous, and let it run. Switch to Teleoperated partway through and check that the auto stops and the sticks work again.  
- Read your log. It should tell the story of what you did, from start to finish.  

**At a meeting, with a mentor:** deploy it to the real robot (`MY_ROBOT = true` still). Before anything moves, check with the mentor that the robot is on blocks or has room, and that someone has a hand on the disable button. Then go through every button again. If anything behaves differently from the simulator, that's worth writing down, not just fixing: the simulator was built from guesses, and the difference tells you which guess was wrong.

**Extra (1 pt)**: last season's autonomous, on your code  

Last season's code has two autos drawn in the PathPlanner app, and **neither one ever worked on the real robot**. The team couldn't get PathPlanner to drive a tank drivetrain, so the only auto that worked all season was `Shoot And Climb`, which is timed and has no paths. You're going to run `PP Depot And Climb` on the robot you wrote.

> ⚠️ **Working in the simulator doesn't mean it'll work on the robot.** It drives in the simulator below, but the simulator uses guessed numbers for the wheels, the gearing and the robot's weight, and the real Pigeon is mounted on its side, which lesson 40 showed the simulator can't reproduce. Whatever goes wrong on the real robot is worth more than getting it right here, so write it all down.

- **Copy the drawings.** From [`OG-Code-2026`](https://github.com/Hudson-Robotics/OG-Code-2026) (branch `Pre-DCMP-Flywheel`), copy `src/main/deploy/pathplanner/paths/`, `autos/` and `navgrid.json` into the same place in your project. `settings.json` is already there from [Lesson 45](./LESSON45.md), and it's identical to last season's.  
- **Teach your `Drivetrain` to follow a path.** PathPlanner needs four methods from it, and you have two already from [Lesson 40](./LESSON40.md), `getPose()` and `resetPose(Pose2d)`. Add:  

```java
public ChassisSpeeds getRobotRelativeSpeeds()      // how fast am I going, right now
public void driveRobotRelative(ChassisSpeeds speeds)  // go this fast
```

  - A `DifferentialDriveKinematics` built with the track width (**0.56 m**, from ROBOT.md) converts between the two ways of describing speed. `toChassisSpeeds(...)` turns left and right wheel speeds (m/s) into one `ChassisSpeeds`, and `toWheelSpeeds(...)` does the reverse.  
  - Wheel speed in m/s is your motor velocity (rotations per second) times the metres-per-rotation you worked out for odometry in lesson 40.  
  - To turn m/s into motor power, divide by the robot's top speed: 6380 RPM ÷ 60 is the motor's free speed in rotations per second, and multiplying that by the same metres-per-rotation gives m/s. That's what last season's code does, too.  
- **Hand them to PathPlanner** with `AutoBuilder.configure(...)` in the constructor, inside lesson 45's `try`/`catch`. This is lesson 56's archaeology, in your own code: `this::getPose`, `this::resetPose`, `this::getRobotRelativeSpeeds`, `this::driveRobotRelative`, `new PPLTVController(0.02)`, the `RobotConfig`, a lambda that says whether you're on the red alliance ([Lesson 53](./LESSON53.md)), and `this`.  
- **Register the named commands.** The auto has steps called `Intake`, `Shoot`, `ClimbUp` and `ClimbDown`, which are names, not classes. That's exactly [Lesson 52](./LESSON52.md)'s map, so build it and hand the whole thing over with `NamedCommands.registerCommands(map)`. Then check each name with `NamedCommands.hasCommand(...)` and publish any that are missing, the way lesson 52 did.  
- Add `AutoBuilder.buildAuto("PP Depot And Climb")` to your chooser, **after** registering the names. Make it the default.  
- Run Autonomous. Measured in the simulator with a robot built this way:  

| Time | What happens |
|---|---|
| 0–3 s | Drives `ToDepot`, from (3.59, 5.98) to (0.48, 5.98), with **Intake** running |
| 3–5 s | Reverses along `DepotToHub` to (3.55, 4.19), with **ClimbUp** running alongside |
| ~7.4 s | ClimbUp stops at **365** rotations, and the climber coasts on to about **406**, as [Lesson 37](./LESSON37.md) warned |
| 8–9 s | Drives `HubToTower`, ending at **(1.52, 4.19)** |
| 9–14.5 s | **Shoot** for six seconds, then **ClimbDown** |

  - Your odometry should land within a couple of centimetres of each path's end point.  
  - 👀 **The simulator's field view won't agree about *where* you are.** PathPlanner resets your odometry to the path's starting point, but the simulator always starts the robot in the corner. Compare the *shape* of the drive, not the spot.  
- 🧪 **The experiment.** Move `registerCommands` to **after** `buildAuto` and run Autonomous again. **Predict what happens before you run.**  
- It drives **every path perfectly**, and nothing else happens at all. No intake, no climb, no shot. The only sign is four console warnings, `PathPlanner attempted to create a command 'Intake' that has not been registered`, printed at startup, long before the match. Your `hasCommand` check catches it, but only if it runs before the auto is built. It's the failure [Lesson 38](./LESSON38.md) asked you to name: **code that runs perfectly and fails a human.** Put the registration back.  

> 🏁 **What you just did:** a whole robot, every subsystem, every command, and a PathPlanner auto, all written by you, and running drawings the team never got to work. If it works on the real robot too, you've fixed something last season's programmers couldn't. That's the whole course.

---

## 📜 Part 3 – Code Archaeology (2 pts, optional)

Last season's code is [`OG-Code-2026`](https://github.com/Hudson-Robotics/OG-Code-2026), branch `Pre-DCMP-Flywheel`. This is the archaeology that ends the course, and **you should be able to do it from your own notes.**

**Basic (1 pt)**: five things to change before 2027  
- Write a list of **five changes** you'd make to last season's code before the 2027 season starts. Each one needs:  
  1. **Where it is:** the file, and what to search for.  
  2. **What's wrong with it,** in one sentence a new programmer would understand.  
  3. **The evidence:** which lesson you found it in, and what you saw or measured.  
  4. **The fix,** in a sentence or two, or as code.  
- If you're stuck, go back over the archaeology you did in lessons [28](./LESSON28.md), [31](./LESSON31.md), [34](./LESSON34.md), [37](./LESSON37.md), [38](./LESSON38.md), [44](./LESSON44.md) and [45](./LESSON45.md). Each one found at least one candidate.  
- Rank them by how much each would have cost at a competition, and say why the top one is on top.  

**Extra (1 pt)**: what they got right, and the note for next year  
- Find the comment above the `NamedCommands.registerCommand` lines in `RobotContainer.java`. It warns about the exact mistake you made on purpose in the extra half. Somebody on the team learned that the hard way. Now you know what "the hard way" looked like.  
- Open last season's `Robot.java` and find `autonomousInit()` and `teleopInit()`. `MY_ROBOT` does the same two things for your robot: it gets the autonomous command, schedules it, and cancels it when Teleoperated starts. Find one thing theirs does that the academy's doesn't, or the other way round.  
- **Write the note you'd hand to next year's programmers.** One page: what the robot does, where each piece lives, the three things that will bite them first, and which lesson to read for each. You've read more of this code, more carefully, than almost anyone who'll open it in 2027.  

---

## 🏆 Total Points
- **Max:** 6 pts  
  - Java‑Only: 2 pts  
  - Robot Code: 2 pts  
  - Code Archaeology: 2 pts *(optional)*  
