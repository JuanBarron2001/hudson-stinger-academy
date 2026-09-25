# 🖥️ Lesson 45 – Exceptions in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ ⚡  

---

## 🎯 Overview
**Keywords:** Java, Exceptions, try-catch, finally, try-with-resources, Error Handling  
Learn to:
- Understand that **exceptions** are events that interrupt the normal flow of a program  
- Use **try-catch** blocks to handle dangerous code gracefully  
- Catch **specific exceptions** (e.g., `ArithmeticException`, `InputMismatchException`)  
- Use a **catch-all** as a last resort (`Exception e`)  
- Apply the **finally** block for cleanup tasks  
- Use **try-with-resources** for automatic resource management  

---

## ⏱️ Progress Tracking

### 📊 For the Marathon Watchers  
If you’re following the **full 12‑hour compilation** and want to see how far you’ve made it through the *entire* course:  
- **Start Time in 12‑Hour Video:** [09:05:29](https://www.youtube.com/watch?v=xTtL8E4LzTQ&t=32729s)  
- **Full Course (12h video):** [Watch Compilation](https://www.youtube.com/watch?v=xTtL8E4LzTQ)

---

### 🎯 For the Quick‑Hit Learners  
If you just want **this lesson only** and to be done with it — no scrubbing through hours of footage:  
- **Lesson Playlist:** [Java tutorial for beginners (2025) ☕](https://www.youtube.com/playlist?list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc)  
- **This Lesson Only:** [Watch Lesson 45](https://www.youtube.com/watch?v=u1PROb-aRUI&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=57) (Learn EXCEPTION HANDLING in 8 minutes! ⚠️, 8:02)

---

## 💻 Part 1 – Java‑Only (2 pts)

**Basic (1 pt)**  
- Put `int result = 1 / 0;` inside a `try` block. After it, `catch (ArithmeticException e)` and print `You can't divide by zero!`. Run it once **without** the `try` first, and read the exception it crashes with.  
- Add `import java.util.Scanner;` and `import java.util.InputMismatchException;` at the **top** of the file.  
- Create a `Scanner`. Inside a `try`: ask `Enter a number: `, read it with `nextInt()`, and print `You entered: ` and the number. Then `catch (InputMismatchException e)` and print `That wasn't a number!`.  
- Run it twice: once typing a number, once typing a word like `pizza`. Without the `try`, the word would crash the program with an `InputMismatchException`.  

Expected output, typing `42` and then (on the second run) `pizza`:  

```
You can't divide by zero!
Enter a number: 42
You entered: 42
```
```
You can't divide by zero!
Enter a number: pizza
That wasn't a number!
```

**Extra (1 pt)**  
- Try the `1 / 0` again, this time with **three** blocks after it:  
  - `catch (ArithmeticException e)`, which prints `Math error: ` followed by `e.getMessage()`  
  - `catch (Exception e)`, which prints `Something went wrong.`: the safety net, and it goes **last**  
  - `finally`, which prints `This always executes.`  
- **Predict** which of the three print before you run it.  
- **Try-with-resources:** create the `Scanner` **inside** the `try`'s parentheses, `try (Scanner scanner = new Scanner(System.in))`. Ask for a number again, and `catch (InputMismatchException e)` with `Invalid input!`.  
- With try‑with‑resources, Java closes the `Scanner` for you when the `try` ends, even if an exception was thrown. The video's advice: catch **specific** exceptions first, so the user learns what went wrong, and keep `Exception e` last, as a safety net.  

Expected output of the first part:  

```
Math error: / by zero
This always executes.
```

---

## 🤖 Part 2 – Robot Code: the 2026 Robot (2 pts)

Your code goes in `robot-code/command-based-bot-2026/src/main/java/frc/lesson/lesson45/basic/Lesson45.java` (and `extra/Lesson45.java`). The task list is at the top of each file.  
Run it in the simulator the way you did in [Lesson 00](./LESSON00.md).

**Basic (1 pt)**: the file that might not be there  

Every exception you've written so far was about bad input — somebody typed `pizza` where a number belonged. On a robot the classic one is different: **a file that was supposed to be deployed, and wasn't.**

PathPlanner keeps its robot settings in `src/main/deploy/pathplanner/settings.json`, which is copied onto the roboRIO when you deploy. `RobotConfig.fromGUISettings()` reads it. If it isn't there, that call throws — at **startup**, before a match rather than during one.

- Load the config inside a `try`, and keep `config.massKG`. Call it plainly first, with no `try` at all, and read what `javac` says — that error is the compiler telling you this call is known to fail.  
- Add the `catch`. **Do not just print.** Record three things a human can see:  

```java
catch (Exception e) {
    autoReady = false;
    status = "AUTO WILL NOT RUN: " + e.getClass().getSimpleName() + " - " + e.getMessage();
    e.printStackTrace();          // for the mentor, in the console
}
```

- Publish `Auto/Ready`, `Auto/Status` and the mass. Run it: **Ready `true`, Status `loaded`, mass 36.287 kg.**  
- 🧪 **The experiment:** rename `settings.json` to `settings.json.bak` and run again. **Predict the dashboard before you look.** You get:  

```
Auto/Ready   false
Auto/Status  AUTO WILL NOT RUN: FileNotFoundException - .../pathplanner/settings.json
             (No such file or directory)
```

Rename it back.

> 📬 **Why the message matters.** `e.getMessage()` here is the **full path of the file it wanted**. That's a stranger at 7am being told exactly which file to go find. Compare it with what a bare `"something went wrong"` would have given them.

> 🎯 **The rule this lesson exists for:** a `catch` block is not for making an error go away. It is for deciding **who finds out, and when**. Here the robot can still drive — so let it drive, and make sure the one person who can fix it knows *before* the match instead of during it.

**Extra (1 pt)**: three ways to "handle" it, and only one is honest  

Write all three, run each with `settings.json` renamed away, and write down what a drive team would actually experience.

| Version | Code | What the drive team gets |
|---|---|---|
| **A** | no `try` at all | The lesson never starts. `LessonLoader` prints *"crashed while starting up"*. The robot is dead — obvious, immediate, and useless |
| **B** | `catch (Exception e) { e.printStackTrace(); return; }` | The robot boots, the dashboard looks normal, teleop works — and autonomous does nothing, which you discover with 15 seconds to fix it. **This is the version most teams ship** |
| **C** | the basic half's | The robot drives, and the dashboard says in words that auto will not run |

- 🧪 **Now try to catch the *right* exception.** Change `catch (Exception e)` to `catch (IOException e)`. **Predict whether it compiles.**  
- **It does not**, and the error is the entire point:  

```
unreported exception org.json.simple.parser.ParseException;
must be caught or declared to be thrown
```

`fromGUISettings()` can fail **two** ways, and `catch (Exception e)` was quietly covering both without you ever learning the second one existed.

- So find out what the second one is for. `IOException` means the file **isn't there**. `ParseException` means it **is** there and isn't valid JSON. Open `settings.json`, delete one closing brace, and run it — different exception, completely different fix, and a message that says so. Then catch them properly (two blocks, or `catch (IOException | ParseException e)`) and put the brace back.  
- Add a `finally` that publishes `Auto/Check Finished`. Run it both ways. **Predict whether `finally` runs when the `catch` runs.**  

**Then the part that isn't about exceptions at all.** Publish `config.massKG` next to the mass the simulator uses:

| Where | Robot mass | Drive current limit |
|---|---|---|
| `settings.json` | **36.287 kg** | **33 A** |
| `frc/sim/RobotSim.java` | **55 kg** *(marked "estimate")* | — |
| Your `Constants` / last season's code | — | **60 A** |

Same robot. Three files. Different numbers, and nothing in the code will ever complain. Write down which you'd trust, and how you'd settle it with a scale, a tape measure and twenty minutes at a meeting. **That answer is worth more than this lesson is.**

> 💡 **The big idea:** an exception is the program telling you it cannot keep a promise. Your only real choice is whether that message reaches a human in time to matter.

---

## 📜 Part 3 – Code Archaeology (2 pts, optional)

**Basic (1 pt)**: version B, in the wild  
- Open `configureAutoBuilder()` in `CANDriveSubsystem.java` ([`OG-Code-2026`](https://github.com/Hudson-Robotics/OG-Code-2026), branch `Pre-DCMP-Flywheel`). Here is the whole handler:  

```java
try {
    robotConfig = RobotConfig.fromGUISettings();
} catch (Exception e) {
    e.printStackTrace();
    return;
}

AutoBuilder.configure( ... );
```

- That `return` is **version B**, in the code that went to competition. Trace what it means: if the settings file is missing, `AutoBuilder.configure(...)` is **never called**, and the robot carries on booting as though nothing happened.  
- Now follow the consequence. `RobotContainer` line 90 calls `AutoBuilder.buildAuto("PP Depot And Climb")` to fill the auto chooser. **What happens there if `AutoBuilder` was never configured?** Read PathPlanner's source or try it — and notice the failure has now moved to a completely different file from the thing that actually went wrong.  
- **Answer the question the heading asks:** what does the drive team see at a match? Be specific about *when* they find out.  

**Extra (1 pt)**: catch, log, and carry on  
- `e.printStackTrace()` writes to the console. On a robot, who is reading that console during a match? Where does it go after the match?  
- Find every `catch` in the project (`grep -rn "catch (" src/main/java/frc/robot`) and sort them into the three versions from the table above. How many are version B?  
- Pick the one you think is most dangerous and write the version C rewrite — three or four lines, publishing something a human would see. That's a real pull request someone could merge before next season.  

---

## 🏆 Total Points
- **Max:** 6 pts  
  - Java‑Only: 2 pts  
  - Robot Code: 2 pts  
  - Code Archaeology: 2 pts *(optional)*  

---

<!-- Drafting notes from the transcript draft. Hidden from students.
Ideas:  
- Emphasize exceptions = interruptions in program flow.  
- Robot code: handle invalid sensor data gracefully.  
- Archaeology: replace crash-prone parsing with try-catch.  
- Segue: Next lesson → **File Handling** (working with files, streams, and exceptions).  
-->
