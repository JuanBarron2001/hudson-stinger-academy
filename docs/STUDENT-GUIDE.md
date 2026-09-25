# 🐝 Student Guide — Hudson Stinger Academy

**Start here if you've never run a lesson before.**
_Learn it. Test it. Break it. Fix it. Own it._

This guide gets you from a fresh laptop to a finished, submitted lesson. It should take about twenty minutes the first time and about thirty seconds every time after that.

---

## 1. What you're signing up for

Every lesson teaches one Java idea twice: once in plain Java, and once in code that runs on a robot. That's on purpose. Learning `if` statements is forgettable. Learning `if` statements because the robot needs to decide whether it's aimed at the target is not.

### This offseason: rebuild the 2026 robot

The robot half of every lesson programs a piece of **last season's robot**: its drivetrain, its intake and flywheel, its climber, its Limelight. Lesson by lesson, you rewrite the code the team competed with, and by the end you've put the whole robot together yourself.

- **Start with [Lesson 00](../lessons/LESSON00.md).** It sets up your fork and the simulator. Nothing else works until it does.
- **Aim for two lessons a week.** Do the Java half first, then the robot half.
- **Core lessons first.** Lessons marked *optional* in the [lesson index](../lessons/LESSONS.md) don't build a piece of the robot, so skip them unless you're ahead.
- **Points count toward the prize at kickoff.** Ask a mentor for the details.
- Everything about the robot (CAN IDs, inversions, buttons, speeds) is on one page: [ROBOT.md](../robot-code/command-based-bot-2026/ROBOT.md).

Each lesson is worth **6 points**:

| Part | What you do | Points |
|---|---|---|
| 💻 Java-only | Write a small program in `java-lessons/` | 2 |
| 🤖 Robot code | Write the same idea in real robot code | 2 |
| 📜 Code Archaeology *(optional)* | Read last season's robot code and explain a piece of it | 2 |

Each part splits in half:

- **Basic (1 pt)** — everyone does this. If you're new, doing every basic and no extra is a completely respectable way through the course.
- **Extra (1 pt)** — the stretch half. If the basic felt easy, this is where the actual learning is.

Nobody is expected to max every lesson. Do the basics, pick the extras that look interesting, and keep moving. Code Archaeology is optional: skip it when you're short on time.

---

## 2. One-time setup

### You need a JDK, not just Java

A JDK can *compile* Java. A JRE can only *run* it. If you type `javac -version` and the computer says "command not found," you have a JRE.

The good news: **if you installed WPILib 2026, you already have a JDK.** It's bundled. On Linux and macOS it lives at:

```
~/wpilib/2026/jdk
```

On Windows it's `C:\Users\Public\wpilib\2026\jdk`.

To save typing, point a shell variable at it:

```bash
export JDK=$HOME/wpilib/2026/jdk/bin
```

Check that it worked:

```bash
$JDK/javac -version
```

You should see `javac 17.0.16` or similar. If you see an error, stop here and ask a mentor — everything below depends on this working.

### Get the repo

Don't clone the academy directly. **Fork it and clone your fork**, so your work has somewhere to live. [Lesson 00](../lessons/LESSON00.md) walks through it step by step, including how to pull in new lessons later.

---

## 3. Running a Java-only lesson

All of this happens from the `java-lessons/` folder. **Be in that folder when you run things** — the lesson writes your output log into whatever folder you're standing in, and if you run from somewhere else you'll go looking for a file that isn't there.

```bash
cd java-lessons
```

### Compile everything

```bash
$JDK/javac -d out $(find src -name "*.java")
```

That compiles every lesson at once. It's fast, and it means you never have to think about which files changed.

If you get errors, read the **first** one and ignore the rest. Java errors cascade — one missing semicolon can produce fifteen complaints. Fix the first, recompile, repeat.

### Run it

```bash
$JDK/java -cp out lessonRunner.LessonRunner
```

You'll get the banner, then a prompt:

```
Enter lesson number (two digits, e.g. 01):
```

Type a **two-digit** number. `01`, not `1`. The runner is picky about this and will reject `1` outright.

It then runs your **basic** program, then your **extra** program, one after the other.

### Where your code goes

For lesson 07, you'd edit these two files:

```
java-lessons/src/lesson07/basic/Main.java
java-lessons/src/lesson07/extra/Main.java
```

Open one up and you'll find a numbered list of comments telling you what to build. That list is the assignment. Delete the comments as you complete them, or leave them — your call.

---

## 4. Running a robot lesson

You do **not** need a robot. Everything below runs in the simulator on your laptop, and the simulator makes the 2026 robot's motors and gyro behave like the real ones. [Lesson 00](../lessons/LESSON00.md) walks through this the first time.

Open this folder in **WPILib VS Code 2026**:

```
robot-code/command-based-bot-2026
```

### Pick your lesson

Open `src/main/java/frc/robot/PickYourLesson.java` and change the two lines:

```java
public static final int LESSON = 7;
public static final boolean EXTRA = false;
```

`EXTRA = false` runs the basic half; `true` runs the extra half. That's the only file you ever edit to choose a lesson.

There's a third line, `MY_ROBOT`. Leave it `false` until [Lesson 57](../lessons/LESSON57.md), the capstone: then it runs **your** robot, `frc/robot/RobotContainer.java`, instead of a lesson.

### Launch the simulator

In VS Code: **Ctrl+Shift+P → WPILib: Simulate Robot Code → Sim GUI → OK**.

Or from a terminal in the project folder:

```bash
./gradlew simulateJava
```

If that fails with a confusing message about **"does not provide the required capabilities: [JAVA_COMPILER]"**, it found the JRE instead of the JDK. Tell it where to look:

```bash
./gradlew simulateJava -Dorg.gradle.java.home=$HOME/wpilib/2026/jdk
```

A simulator window opens. To make your lesson code actually run:

1. In **Robot State**, click **Teleoperated**. Your lesson's `execute()` runs about fifty times a second, and only in Teleoperated.
2. Your keyboard is two controllers: **WASD / IJKL** sticks for the driver, **5 6 7 8** for the operator's A B X Y. The full key map is in [Lesson 00](../lessons/LESSON00.md).
3. Anything you put on SmartDashboard shows up under **NetworkTables → SmartDashboard**.
4. **Sim Field** (in the same place) shows where the robot actually is, which is how you see it drive.

### Where your code goes

For lesson 07:

```
src/main/java/frc/lesson/lesson07/basic/Lesson07.java
src/main/java/frc/lesson/lesson07/extra/Lesson07.java
```

Same deal: the comments at the top are the assignment.

### At the weekly meeting

You deploy the same code to the real robot (**WPILib: Deploy Robot Code**) and watch it for real. A mentor holds the enable/disable, especially for anything that touches the flywheel or the climber.

---

## 5. Turning in your work

**You turn in a log file, not a screenshot.**

When a lesson runs, it writes a log file named after the lesson:

| Lesson half | Log file | Where it lands |
|---|---|---|
| Java, lesson 07 basic | `lesson07.basic-output.log` | `java-lessons/` |
| Robot, lesson 07 basic | `frc.lesson.lesson07.basic-output.log` | `robot-code/command-based-bot-2026/` |

Commit the log along with your code, and push it to **your fork**:

```bash
git add .
git commit -m "lesson 07 basic"
git push
```

That's the whole submission.

### About the log file

Open one and you'll see lines like this:

```
20251110235655813|print|char|6|cbb80f823553d07cfedd97f06d7caa9b
```

That's a timestamp, what kind of print you called, the type, the value, and a **hash of the previous line**.

Each line is chained to the one before it. Change one character anywhere in the middle and every hash after it stops matching — which is instantly visible to whoever reads it.

This isn't there because anyone thinks you're a cheater. It's there so that *your* log is trustworthy evidence that your code really ran and really produced that output. A screenshot proves nothing. This proves you did the work.

The practical takeaway is simple: **don't hand-edit the log.** If the output is wrong, fix your code and run it again. That's faster than faking it anyway.

---

## 6. When something goes wrong

### "Something happened — it might be this program or your program."

That's the runner's catch-all. It means your code threw an exception. Most common causes:

- You used a variable before giving it a value
- You went past the end of an array
- You called a method on something that was `null`

Read your code from the top of `main` and trace what actually happens, line by line. If you're stuck for more than fifteen minutes, ask — that's not failure, that's efficiency.

### The program just sits there doing nothing

It's probably waiting for input you're not giving it. Lessons that use `Scanner` get their answers fed in automatically by the runner, but that scripting is set up per-lesson and a few lessons don't have it yet. Tell a mentor which lesson number and they'll add it.

### My log file is empty

Two usual causes: your code doesn't actually print anything yet, or you ran the command from the wrong folder. Check that you're in `java-lessons/`.

### Robot lesson: "No lesson found named ..."

The numbers in `PickYourLesson.java` point at a lesson that doesn't exist. Check the lesson number, and that `EXTRA` is `true` only when you mean the extra half.

### Robot lesson: "Your lesson threw an error, so it has been stopped"

Your `execute()` crashed. Scroll up to the error. The first line that mentions `frc.lesson` is usually the line with the problem. A very common one is using a motor or controller you never created in `setup()` (it's still `null`).

### Robot lesson: nothing happens at all

A lesson file starts **empty**, so a fresh lesson publishes nothing and moves nothing. That's normal, not a broken simulator. After five seconds the console says so.

To prove your setup works, set `LESSON = 98` and run the **simulator check**: it drives with W/S and J/L, spins the rollers on the operator's 5 key, and shows every key it hears under **Demo/**.

### Robot lesson: nothing moves when I press keys

- Is **Robot State** set to **Teleoperated**?
- Is the simulator window selected? Keys only count when it is.
- In the **Joysticks** window, are Keyboard 0 and Keyboard 1 in slots 0 and 1? If not, drag them there.

### Something else

Ask your Programming Mentor or the Head Programmer Student. Genuinely — asking early is the single biggest difference between students who finish this course and students who don't.

---

## 7. How to actually learn this

- **Type the code. Don't paste it.** Your hands remember what your eyes skim past.
- **Break it deliberately.** Change a `<` to a `>`. Delete an inversion. Watch what happens, then put it back. You learn more from a robot that drives wrong than one that drives right the first time.
- **Read the error message.** All of it. The answer is in there more often than you'd think.
- **Finish something small** rather than half-finishing something ambitious. A completed basic beats an abandoned extra.

> 🐝 _"The sting is in the details — master them, and you master the bot."_
