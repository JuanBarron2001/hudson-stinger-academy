# Mentor & Author Guide — Hudson Stinger Academy

For mentors and the Head Programmer Student: how the curriculum is built, how to take a lesson from rough draft to finished, and where the sharp edges are.

If you're looking for how to *do* a lesson rather than how to *write* one, read [STUDENT-GUIDE.md](STUDENT-GUIDE.md) instead.

---

## 1. How a lesson is put together

One lesson is **three files in three places**, plus a fourth part that lives only in prose:

```
lessons/LESSON07.md                                    ← the written guide
java-lessons/src/lesson07/{basic,extra}/Main.java      ← the Java-only exercise
robot-code/command-based-bot-2025/src/main/java/
        frc/lesson/lesson07/{basic,extra}/Lesson07.java ← the robot exercise
```

Six points total: 2 for Java-only, 2 for robot code, 2 for "Code Archaeology" (reading last season's robot code), each split into a required **basic** half and a stretch **extra** half.

The naming is load-bearing. `LessonRunner` and `RobotContainer` both find lessons by **reflection on the package name**, so `lesson07.basic.Main` and `frc.lesson.lesson07.basic.Lesson07` must be spelled exactly that way or the lesson silently fails to load. Two digits, always — `lesson7` will not be found.

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

Where things actually stand today: lessons **01–11** have real content, **12–55** are `[AI_SLOB]` over empty stubs, and **56–70** have stubs with no guide at all. Lesson 04 is the only `[COMPLETE]` one, so **treat `LESSON04.md` as the reference implementation** — when you're unsure what "finished" looks like, open that file.

---

## 3. Taking a lesson from AI_SLOB to COMPLETE

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

See section 5 below. Lessons that read input **will hang forever** without this, and the failure looks like a frozen terminal rather than an error.

### Step 5 — Run it yourself, end to end

Both halves, both tracks. Then check the generated log actually contains what you expected. If you didn't run it, it isn't `[READY FOR REVIEW]`.

### Step 6 — Update the index

Edit the row in `lessons/LESSONS.md`. While you're in there, note that **rows 27 and 47 have a column shift** — `[AI_SLOB]` ended up in the summary cell as well as the status cell — and the status key spells it `[AI SLOB]` with a space while every row uses `[AI_SLOB]` with an underscore. Fix those when you pass by.

---

## 4. How the grading harness works

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

`LessonBase` does the same job against SmartDashboard instead of stdout. Rather than capturing prints, it walks `SmartDashboard.getKeys()` on a timer, diffs each value against what it saw last, and logs only what changed.

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

## 5. Adding scripted input to a `Scanner` lesson

Right now this is hardcoded in `LessonRunner.main`, as a chain of checks against the lesson number:

```java
if (lessonNum.equals("03")) {
    LessonInput lessonInput = new LessonInput();
    lessonInput.addScriptedLine("6.7");
    lessonInput.addScriptedLine("2.1");
    System.setIn(lessonInput);
}
```

To add a lesson, copy that block and change the number and the answers. One `addScriptedLine` per `Scanner` read, **in order**.

⚠️ **Two traps, both currently live in the code:**

1. **Don't forget `System.setIn(...)`.** The existing lesson 04 block builds a `LessonInput`, adds two lines, and never installs it — so lesson 04's extra exercise hangs. Use the lesson 03 block as your template, not lesson 04.
2. **This doesn't scale,** and it's already showing. Seventy lessons of `if` blocks in `main` is not a plan. Moving the scripted answers into per-lesson files under `java-lessons/resources/` (which exists and is empty, clearly meant for this) is on the task list.

---

## 6. Known sharp edges

Things that will waste your time if you don't know them. All verified in the code on 2026-09-15.

| Where | What |
|---|---|
| `LessonInput.timeDelay(int ms)` | Ignores its parameter and always sleeps 30ms, so `SIMULATED_READING_SPEED_MS` is dead code |
| `LessonRunner`, lesson 04 branch | Builds a `LessonInput` but never calls `System.setIn` — lesson 04 extra hangs |
| `RobotContainer.teleopPeriodic()` | Throws `NullPointerException` when no lesson loaded, right after printing a friendly "skipping" message |
| `LessonBase.logSmartDashboardChanges()` | Stops logging permanently after 137 cycles — `modResetCount` never resets |
| `LessonRunner` | Never calls `closeLogger()` |
| `LessonRunner` catch-all | Swallows the stack trace, leaving you nothing to debug |
| `Robot.java` | Lesson selection is hardcoded; students edit source to switch lessons |
| `lessons/LESSON49.md` | Zero bytes, and the index skips 48 → 50 |
| Lesson 24 | Duplicates lesson 23 — the index says so itself |
| `robot-code/educational-bot-2025/` | Untracked, empty but for a stale `build/` tree |
| `java-lessons/` | No build file at all |

---

## 7. Build and run commands

The system JDK on the development machine is a **JRE only** — no compiler. Use the JDK bundled with WPILib.

```bash
export JDK=$HOME/wpilib/2025/jdk/bin
```

**Java lessons** (run from `java-lessons/`, because logs land in the working directory):

```bash
cd java-lessons
$JDK/javac -d out $(find src -name "*.java")
$JDK/java -cp out lessonRunner.LessonRunner
```

**Robot project** (from `robot-code/command-based-bot-2025/`):

```bash
./gradlew compileJava  -Dorg.gradle.java.home=$HOME/wpilib/2025/jdk
./gradlew simulateJava -Dorg.gradle.java.home=$HOME/wpilib/2025/jdk
```

Add `--offline` when you have no network; the dependencies are already cached locally.

Without `-Dorg.gradle.java.home`, Gradle finds the JRE and fails with:

```
Toolchain installation '/usr/lib/jvm/java-21-openjdk-amd64'
does not provide the required capabilities: [JAVA_COMPILER]
```

which is a confusing way of saying "that's not a JDK."

---

## 8. Lesson numbering

- **01–89** — the Java course, following the source video series. 01–55 have guides; 56–70 have stubs awaiting guides.
- **90–99** — reserved for robot systems, taught in terms of a subsystem rather than a language feature. **Nothing in this block is written yet.** Lessons 90–95 are reserved for a planned drivetrain arc — tank, then mecanum, then swerve.

The 90-block exists because drivetrain lessons don't depend on the Java course past roughly lesson 30, and numbering them 71+ would imply a prerequisite chain that isn't real — parking the most motivating material in the curriculum behind seventy lessons nobody finishes first.

`LessonRunner` requires exactly two digits, so any new track has to live inside 00–99 unless the runner changes.

---

## 9. Writing style

The guides have a voice. Keep it.

- Emoji section headers, the 🐝 sign-off, "Learn it. Test it. Break it. Fix it. Own it."
- Second person, direct, short sentences.
- Every lesson opens with a **Keywords** line and a "Learn to:" list.
- Say what to build, not how to build it. The student writes the code.
- Never write personal details about students into this repo — it's public.
