# Mentor & Author Guide — Hudson Stinger Academy

For mentors and the Head Programmer Student: how the curriculum is built, how to take a lesson from rough draft to finished, and where the sharp edges are.

If you're looking for how to *do* a lesson rather than how to *write* one, read [STUDENT-GUIDE.md](STUDENT-GUIDE.md) instead.

---

## 1. How a lesson is put together

One lesson is **three files in three places**, plus a fourth part that lives only in prose:

```
lessons/LESSON07.md                                    ← the written guide
java-lessons/src/lesson07/{basic,extra}/Main.java      ← the Java-only exercise
robot-code/command-based-bot-2026/src/main/java/
        frc/lesson/lesson07/{basic,extra}/Lesson07.java ← the robot exercise
```

Six points total: 2 for Java-only, 2 for robot code, 2 for "Code Archaeology" (reading last season's robot code), each split into a required **basic** half and a stretch **extra** half. **Archaeology is optional** as of the 2026 offseason: students aim for two lessons a week, Java first, then robot, and skip archaeology when short on time.

The naming is load-bearing. `LessonRunner` and `LessonLoader` both find lessons by **reflection on the package name**, so `lesson07.basic.Main` and `frc.lesson.lesson07.basic.Lesson07` must be spelled exactly that way or the lesson silently fails to load. Two digits, always — `lesson7` will not be found.

---

## 2. The status ladder

Every lesson carries a status in `lessons/LESSONS.md`. The ladder is the actual workflow:

| Status | Means |
|---|---|
| `[IDEA]` | A number and a title, nothing else |
| `[AI_SLOB]` | Auto-drafted from a transcript of a YouTube Java course. Rough, no robot connection, no test data |
| `[DRAFT]` | A human has passed over it, but it isn't tied to robot examples yet |
| `[WORK IN PROGRESS]` | Being connected to robot code and real exercises |
| `[READY FOR REVIEW]` | Looks done, needs a second pair of eyes |
| `[COMPLETE]` | Reviewed, connected to robot code, has test data |
| `[NEEDS UPDATE]` | Was complete, has since gone stale |

Where things actually stand today (2026-09-25): every lesson from **00 to 57** has a guide and stubs, and the course ends at 57. Lessons 12–57 are `[READY FOR REVIEW]`: each was checked against its video, or written from scratch for 56 and 57, but hasn't had a final read yet. Lesson 04 is the only `[COMPLETE]` one, so **treat `LESSON04.md` as the reference implementation** — when you're unsure what "finished" looks like, open that file.

For the 2026 offseason, **every Core lesson** has a robot half written for the 2026 robot. The Optional lessons have none this season: their robot halves say "not written yet, skip for now". The **2026 Path** and **2026 Robot** columns in `lessons/LESSONS.md` show which is which.

---

## 3. The seasonal rebuild: how `robot-code/` changes every year

`java-lessons/` teaches Java principles and doesn't change. `robot-code/` teaches WPILib, and each offseason it's re-authored against **last season's robot**, so students rebuild that robot's code one lesson at a time. Lesson NN teaches the same Java idea in all three parts. The plan for 2026 lives in the mentor's notes; the robot facts students need are in `robot-code/command-based-bot-2026/ROBOT.md`.

### What's in the 2026 project

| Path | What it is | Students edit it? |
|---|---|---|
| `frc/robot/PickYourLesson.java` | The lines that choose a lesson, and `MY_ROBOT`, which runs the student's own `RobotContainer` instead (lesson 57) | Yes, only this |
| `frc/robot/Robot.java` | The lesson host: loads the lesson, runs it in Teleoperated, runs the simulator. With `MY_ROBOT` on, it builds the student's `RobotContainer` and runs its `getAutonomousCommand()` in Autonomous | No |
| `frc/lesson/LessonBase.java`, `LessonLoader.java`, `LessonLogger.java` | The harness and the hash-chained log | No |
| `frc/lesson/myrobot/MyRobot.java` | Finds the student's `RobotContainer` by name, so a fresh clone builds without one, and logs the whole run to `frc.lesson.myrobot-output.log` | No |
| `frc/lesson/lessonNN/{basic,extra}/` | The exercises | Yes |
| `frc/lesson/lesson98/basic/` | The simulator check: a working demo that drives, shoots and climbs | No |
| `frc/sim/RobotSim.java` | Physics that make the 2026 robot move at home | No |
| `frc/robot/LimelightHelpers.java` | Limelight's helper file, copied from the competition code | No |
| `simgui-ds.json` | Maps the keyboard to a driver (port 0) and an operator (port 1) Xbox controller | No |
| `ROBOT.md` | CAN IDs, inversions, ball paths, buttons, speeds | Read it |

### The simulator

A Phoenix 6 motor in simulation doesn't move unless code feeds it a rotor position and velocity. Without that, it behaves like a **stalled** Kraken: the default 120 A stator limit caps its output at about 3 V, which looks exactly like a broken license or a bad `set()` call and is neither.

`RobotSim` fixes this for the drivetrain, the launcher rollers, the conveyor, the climber and the Pigeon. It opens its own `TalonFX` handles by CAN ID, which point at the same simulated devices a lesson creates, so it works however a student writes their code. It sets each motor's mounting (`Orientation`) to match the real robot, so a forgotten inversion behaves like it would on carpet: the drivetrain spins in place, and un-flipped launcher rollers fight each other at 0 RPS.

Its limits:
- It models every motor as a **Kraken X60**, the only motor CTRE's simulator supports.
- Robot mass, robot inertia and roller inertia are **estimates**. The drivetrain gear ratio, wheel size and track width are the competition code's values, which match the kitbot template and may never have been measured.
- There is **no Limelight**. Vision exercises use pretend buttons at home and the real camera at meetings.

### The simulator check (lesson 98)

Every real lesson starts as an empty stub, so a student's first run publishes nothing and moves nothing, which is indistinguishable from a broken setup. `LESSON = 98` runs a working demo instead: arcade drive on the sticks, rollers on the operator's A, climber on the D-pad, and every input echoed under `Demo/`. Point anyone stuck at it before debugging anything else.

It drives with WPILib's `DifferentialDrive`, which is lesson 32's material, so copying it doesn't complete lessons 03–05, which ask for the mixing and the sign flipping by hand.

### Tests

```bash
./gradlew test -Dorg.gradle.java.home=$HOME/wpilib/2026/jdk
```

runs `RobotSimTest` (straight driving, forgotten inversion, gyro, flywheel holding -80 RPS with the competition gains, conveyor and climber) and `RobotHarnessTest` (a test-only lesson drives the simulated robot through the real `Robot` class, and the log's hash chain checks out; lesson 00 passes with simulated controller input). They run in real time, so **`build` and `deploy` skip them on purpose**: a slow student laptop should never block a deploy at a meeting. Run them after touching the harness or the simulator.

### Re-authoring a lesson's robot half

1. Start from the Java topic of that lesson number and ask which piece of this season's robot uses it. If nothing honest fits, mark the lesson optional instead of forcing it.
2. Write the stub as a numbered task list at the top of `LessonNN.java`, with the motor and controller fields pre-declared. Students can't declare fields until lesson 21, but they can fill them in.
3. **Check it in the simulator before a student does.** Write a throwaway solution, run it against `RobotSim`, and confirm the guide's promises actually happen, like "the robot creeps" or "the rollers read 0 RPS". **Don't commit solutions.** This repo is public, and so are forks of it.
4. Rewrite Part 2 of the guide to match, and aim Part 3 at a specific spot in last season's code.
5. Update the **2026 Robot** column in `lessons/LESSONS.md`.

### Forks, rebasing and privacy

Students fork the academy and pull new lessons with `git fetch upstream` and `git rebase upstream/main` (lesson 00). Two things to know:

- **A fork of a public repo is public.** Anyone, including other students, can read anyone's fork. If that matters, the options are GitHub Classroom (a private repo per student, created from the academy), or each student making a private repo and pushing a copy of the academy into it, which keeps the history so `upstream` rebasing still works. A plain fork can't be made private.
- **Don't change files students have already edited.** Rebases stay conflict-free as long as upstream only adds new lessons and never rewrites a released stub, `PickYourLesson.java` or `simgui-ds.json`.

### Meetings

Students deploy their own copy to the real robot. With one robot and two hours, plan a rotation. Put the drivetrain on blocks for drive lessons, and have a mentor hold enable and disable for anything that spins the flywheel or moves the climber.

Lesson 57, the capstone, is the one lesson that can't be homework: its deliverable is each student's whole robot running on the real one, with `MY_ROBOT = true`. Its PathPlanner extra drives last season's `PP Depot And Climb` auto, which needs about 3.5 m by 2 m of floor, so run it on the field or with the robot on blocks, never in a crowded room.

---

## 4. Taking a lesson from AI_SLOB to COMPLETE

This is the core loop. Budget about an hour per lesson.

### Step 1 — Fix the transcript damage

Every `[AI_SLOB]` guide has two mechanical defects, and 50 of the 55 guides have both:

- **`[CODE BLOCK]java`** appears where a fenced code block should be. The placeholder **ate the code** — it didn't just replace the fence. So you're usually writing the snippet fresh, not re-fencing something that's still there. Check before you assume.
- **`[link here]` and `[blank]`** placeholders sit where the video timestamps go.

Don't bulk-fix these across all 50 files with a script. The missing code has to be written per lesson anyway, so fix them as you work the lesson.

### Step 2 — Make the robot half actually about the robot

This is the step that matters and the step that's easiest to skip. An AI draft will give you a generic Java exercise. Your job is to find the version of that idea that a Team 4295 robot genuinely needs.

Good translations from lessons that are already done:

- **Arithmetic** → scale a joystick value to a motor speed, then compute theoretical RPM and linear speed from wheel diameter and gearing (lesson 04)
- **If statements** → decide whether the Limelight's `tx` offset means "aimed" or "keep turning" (lesson 05)
- **Math methods** → distance to an AprilTag from Limelight `tx` and `ty` (lesson 07)
- **printf** → a formatted telemetry line, fixed decimal places, aligned columns (lesson 08)
- **substring** → parse a log filename or a path into its parts (lesson 11)

The test: if the robot half would make just as much sense in a class that had never seen a robot, it isn't done yet.

### Step 3 — Write the exercise stubs as a numbered task list

Don't write the solution. Write the steps. Copy the shape from `java-lessons/src/lesson11/basic/Main.java`:

```java
public class Main extends BaseLesson {
    public static void main(String[] args) {
        // TASK: Build an interactive email slicer
        // 1. Create a Scanner to read user input
        // 2. Prompt user: "Enter an email address: "
        // 3. Validate that email contains "@" using .contains("@")
        // ...
    }
}
```

Numbered, imperative, one action per line. A student who follows the list exactly should end up with working code, and a student who ignores it should still know what "done" means.

### Step 4 — Add scripted input if the lesson uses `Scanner`

Add `java-lessons/resources/lessonNN.basic.txt` (and `.extra.txt`) with one answer per line. Section 6 below has the details.

### Step 5 — Run it yourself, end to end

Both halves, both tracks. Then check the generated log actually contains what you expected. If you didn't run it, it isn't `[READY FOR REVIEW]`.

### Step 6 — Update the index

Edit the row in `lessons/LESSONS.md`. While you're in there, note that **rows 27 and 47 have a column shift** — `[AI_SLOB]` ended up in the summary cell as well as the status cell — and the status key spells it `[AI SLOB]` with a space while every row uses `[AI_SLOB]` with an underscore. Fix those when you pass by.

---

## 5. How the grading harness works

Worth understanding before you change any of it, because the design is deliberate.

### The Java side

- **`BaseLesson`** — every lesson extends it. Its constructor opens a log file named from the package (`lesson07.basic` → `lesson07.basic-output.log`) and can swap `System.out` for a logging stream. Appends rather than overwrites, separating runs with a line of hyphens, so a student's history survives.
- **`LessonLogger`** — a `PrintStream` that overrides every `print`/`println` overload. Each call writes:

  ```
  timestamp|function|type|value|hashOfPreviousLine
  ```

- **`LessonInput`** — an `InputStream` that feeds scripted answers to `Scanner`, echoing each character with a delay so the transcript looks typed.
- **`LessonRunner`** — prompts for a two-digit lesson, reflectively runs `basic` then `extra`.

### The robot side

`LessonBase` does the same job against SmartDashboard instead of stdout. Rather than capturing prints, it walks `SmartDashboard.getKeys()` on a timer, diffs each value against what it saw last, and logs only what changed. In the 2026 project it samples every 5 loops (10 times a second), skips the simulator's own `Sim ` keys, stops at 10,000 lines with a note in the log, and logs a lesson's crash once instead of fifty times a second.

### What the hash chain does and doesn't do

Each line embeds an MD5 of the entire previous line, seeded from a constant in the source. Edit one line in the middle and every hash after it stops matching.

**To verify a student's log:**

```python
import hashlib, sys

SEED = "4X#f9qdkEkzHEGGK"
lines = open(sys.argv[1], encoding="utf-8").read().split("\n")

prev = SEED
for i, line in enumerate(lines):
    if not line or line.startswith("---"):
        continue
    expected = hashlib.md5(prev.encode()).hexdigest()
    actual = line.rsplit("|", 1)[-1]
    if actual != expected:
        print(f"chain breaks at line {i + 1}")
        break
    prev = line
else:
    print("chain intact")
```

Verified against a real committed log — `lesson03.basic-output.log` checks out clean.

**Be honest with yourself about what this proves.** The seed is a plain constant in `LessonLogger.java`, which every student can read. A student who understood the mechanism could regenerate a whole consistent chain from fabricated output. This is **tamper-evident, not tamper-proof** — it defeats casual editing of a log, which is the realistic threat, and it is not a cryptographic guarantee. Honestly, a student capable of forging the chain has already learned more than the lesson was teaching.

One real limitation: values containing `|` or a newline break the line format. Scripted input echoes character by character, so a newline keystroke produces a log line with a literal newline inside it. The verifier above skips past that, but any stricter parser will trip on it.

---

## 6. Adding scripted input to a `Scanner` lesson

Lessons that read input get their answers from a plain text file in `java-lessons/resources/`, one file per half, named after the lesson's package:

```
java-lessons/resources/lesson03.basic.txt
java-lessons/resources/lesson03.extra.txt
```

**One answer per line, in the order the lesson asks.** A blank line is an answer too: the user pressing Enter without typing. `lesson15.basic.txt` starts with two blank lines to prove the "don't skip the prompt" loop works. Before running each half, `LessonRunner` checks for its file. If the file exists, it "types" each answer into the lesson and echoes it, so the answers appear in the console and in the log, right after their questions. If there's no file, the lesson reads the real keyboard.

To add input for a lesson, you only need to add a file. There's no Java to touch.

- **Pick answers that go down the interesting branch.** Lesson 05 answers age `70`, which catches a senior who's been checked as an adult first. Lesson 45 answers `pizza`, which reaches the `catch`. Lesson 24 searches for `coconut`, which isn't there.
- **Cover every question, and end loops on a valid answer.** If a lesson asks for more answers than its file has, the runner stops it with a message naming the file. Lesson 15's game loop needs its `q`, and its range check needs a number from 1 to 10 at the end.
- **Students can edit their copy** to try other answers. The files are shipped from upstream, so tell them to put a file back before they rebase, or they'll get a conflict.

All 24 halves that read input have a file, and each one was checked by running a solution through the runner (2026-09-25).

---

## 7. Known sharp edges

Things that will waste your time if you don't know them. Verified in the code on 2026-09-15; the robot-side ones marked *fixed* were fixed in `command-based-bot-2026` on 2026-09-17 and still exist in the 2025 project.

| Where | What |
|---|---|
| `LessonInput.timeDelay(int ms)` | Ignored its parameter and always slept 30ms. *Fixed 2026-09-25* |
| `LessonRunner`, lesson 04 branch | Built a `LessonInput` but never called `System.setIn`, so lesson 04 extra hung. *Fixed 2026-09-25: every half goes through the answer files (section 6)* |
| `LessonRunner` | Closed `System.in` after reading the lesson number, so a lesson with no scripted answers couldn't read the keyboard at all. *Fixed 2026-09-25* |
| `RobotContainer.teleopPeriodic()` | Throws `NullPointerException` when no lesson loaded, right after printing a friendly "skipping" message. *Fixed in 2026: `LessonLoader` explains and nothing runs* |
| `LessonBase.logSmartDashboardChanges()` | Stops logging permanently after 137 cycles — `modResetCount` never resets. *Fixed in 2026: samples 10×/s, caps at 10,000 lines and says so in the log* |
| `LessonRunner` | Never calls `closeLogger()` |
| `LessonRunner` catch-all | Swallows the stack trace, leaving you nothing to debug |
| `Robot.java` | Lesson selection is hardcoded; students edit source to switch lessons. *In 2026 it's `PickYourLesson.java`, still source, but isolated* |
| `.gitignore` | Ignored `*.log` since the first commit, so `git add .` silently skipped every submission log. *Fixed: `!*-output.log`* |
| Phoenix 6 in simulation | A motor with no physics feeding it looks stalled at ~3 V. Use `RobotSim`; see section 3 |
| `ctre_sim/` | Phoenix creates it wherever the sim runs. Ignored in the 2026 project |
| `lessons/LESSON49.md` | Zero bytes, and the index skips 48 → 50 |
| Lesson 24 | Duplicates lesson 23 — the index says so itself |
| `robot-code/educational-bot-2025/` | Untracked, empty but for a stale `build/` tree |
| `java-lessons/` | No build file at all |

---

## 8. Build and run commands

The system JDK on the development machine is a **JRE only** — no compiler. Use the JDK bundled with WPILib.

```bash
export JDK=$HOME/wpilib/2026/jdk/bin
```

**Java lessons** (run from `java-lessons/`, because logs land in the working directory):

```bash
cd java-lessons
$JDK/javac -d out $(find src -name "*.java")
$JDK/java -cp out lessonRunner.LessonRunner
```

**Robot project** (from `robot-code/command-based-bot-2026/`):

```bash
./gradlew compileJava  -Dorg.gradle.java.home=$HOME/wpilib/2026/jdk
./gradlew simulateJava -Dorg.gradle.java.home=$HOME/wpilib/2026/jdk
./gradlew test         -Dorg.gradle.java.home=$HOME/wpilib/2026/jdk   # real-time simulator tests
```

Add `--offline` when you have no network; the dependencies are already cached locally.

Without `-Dorg.gradle.java.home`, Gradle finds the JRE and fails with:

```
Toolchain installation '/usr/lib/jvm/java-21-openjdk-amd64'
does not provide the required capabilities: [JAVA_COMPILER]
```

which is a confusing way of saying "that's not a JDK."

---

## 9. Lesson numbering

- **00**: setup (git, fork, simulator). No Java half and no points.
- **01–89**: the Java course, following the source video series. Only 00–57 exist: 56 is lambdas, 57 is the capstone, and 58–89 are unused. **Each lesson's robot half programs a piece of last season's robot**, so there's no separate robot track.
- **90–99**: reserved. The drivetrain arc once planned here (tank, then mecanum, then swerve) is on hold. Tank drive now lives in lessons 03–05, and mecanum and swerve wait for the swerve robot.

`LessonRunner` requires exactly two digits, so any new track has to live inside 00–99 unless the runner changes.

---

## 10. Writing style

The guides have a voice. Keep it.

- Emoji section headers, the 🐝 sign-off, "Learn it. Test it. Break it. Fix it. Own it."
- Second person, direct, short sentences.
- Every lesson opens with a **Keywords** line and a "Learn to:" list.
- Say what to build, not how to build it. The student writes the code.
- Never write personal details about students into this repo — it's public.
