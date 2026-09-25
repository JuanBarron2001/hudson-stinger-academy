# 🖥️ Lesson 34 – Method Overriding in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🐝  

---

## 🎯 Overview
**Keywords:** Java, Method Overriding, Inheritance, @Override Annotation, Polymorphism  
Learn to:
- Understand **method overriding**: when a subclass provides its own implementation of a method inherited from a parent class  
- Recognize that the child’s version takes precedence over the parent’s version  
- Use the `@Override` annotation to ensure correctness and avoid mistakes  
- Apply overriding to give **specific behavior** to different subclasses  
- See how overriding supports **polymorphism** (same method name, different behavior depending on the object)  

---

## ⏱️ Progress Tracking

### 📊 For the Marathon Watchers  
If you’re following the **full 12‑hour compilation** and want to see how far you’ve made it through the *entire* course:  
- **Start Time in 12‑Hour Video:** [07:41:37](https://www.youtube.com/watch?v=xTtL8E4LzTQ&t=27697s)  
- **Full Course (12h video):** [Watch Compilation](https://www.youtube.com/watch?v=xTtL8E4LzTQ)

---

### 🎯 For the Quick‑Hit Learners  
If you just want **this lesson only** and to be done with it — no scrubbing through hours of footage:  
- **Lesson Playlist:** [Java tutorial for beginners (2025) ☕](https://www.youtube.com/playlist?list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc)  
- **This Lesson Only:** [Watch Lesson 34](https://www.youtube.com/watch?v=hx_DRanBRRM&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=46) (Learn Java METHOD OVERRIDING in 4 minutes! ♻️, 4:33)

---

## 💻 Part 1 – Java‑Only (2 pts)

> Each class gets its own file next to `Main.java`, starting with the same `package` line, like lesson 27 (`package lesson34.basic;`, and `package lesson34.extra;` for the extra's copies).

**Basic (1 pt)**  
- Create a parent class, `Animal`, with `void move()`, which prints `This animal is running`.  
- Create `Dog`, `Cat` and `Fish`, which each extend `Animal` and are otherwise empty. They all inherit `move()`.  
- In `main()`, create a `Dog`, a `Cat` and a `Fish`, and call `move()` on each. All three are "running", which is wrong for a fish.  

Expected output:  

```
This animal is running
This animal is running
This animal is running
```

**Extra (1 pt)**  
- In `Fish`, write its own `void move()`, which prints `This animal is swimming`, with `@Override` on the line above it. This is **overriding**: same name, same parameters, and the child's version wins.  
- In `main()`, call `move()` on a `Dog`, a `Cat` and a `Fish` again. Only the fish swims now.  
- Now misspell the override as `void moves()`, keeping `@Override` above it, and read the error: `method does not override or implement a method from a supertype`. Without `@Override`, Java would quietly add a new method, and the fish would go back to running with no warning. Fix the spelling.  

Expected output:  

```
This animal is running
This animal is running
This animal is swimming
```

---

## 🤖 Part 2 – Robot Code: the 2026 Robot (2 pts)

Your code goes in `robot-code/command-based-bot-2026/src/main/java/frc/lesson/lesson34/basic/Lesson34.java` (and `extra/Lesson34.java`). The task list is at the top of each file.  
Run it in the simulator the way you did in [Lesson 00](./LESSON00.md).

> 🧱 This is the first lesson of the **commands** unit, and it needs the subsystems from [Lesson 32](./LESSON32.md). A subsystem is a **thing the robot has**. A command is **something the robot does**.

**Basic (1 pt)**: your first real command  

WPILib's `Command` is four empty methods and a promise about when each one runs. You fill them in by **overriding** them — this lesson's Java idea, pointed at a robot.

| Method | When the scheduler calls it |
|---|---|
| `initialize()` | Once, the moment the command is scheduled |
| `execute()` | Every loop after that, ~50 times a second |
| `isFinished()` | Every loop, right after `execute()`. `true` means stop |
| `end(boolean interrupted)` | Once, when it stops. The boolean is **`true`** if something cancelled it, **`false`** if `isFinished()` said so |

- Make `frc/robot/commands/Intake.java` — `public class Intake extends Command`.  
- Its constructor takes your `Fuel`, keeps it, and then says one important line:  

```java
addRequirements(fuel);
```

That is a claim: *while I run, I own the fuel mechanism.* The scheduler enforces it, and the extra half is where you watch it happen.

- Override all four. `initialize()` resets a loop counter and publishes `Intake/State` = `"started"`. `execute()` counts the loop and calls `fuel.intake()`. `end()` calls `fuel.stop()` and publishes `"interrupted"` or `"finished"`. `isFinished()` returns `false` — this one runs until somebody stops it.  
- Schedule it from the lesson while the operator holds **B**. No lambdas yet ([Lesson 56](./LESSON56.md) replaces these two lines with one), so ask plainly:  

```java
if (operator.getBButton() && !intake.isScheduled()) { intake.schedule(); }
if (!operator.getBButton() && intake.isScheduled()) { intake.cancel(); }
```

- Run it, hold **B** (the **6** key) for a second, let go, and read your log top to bottom. It tells a story now: `started`, then `Loops` climbing one per cycle, then `interrupted` — because **you** cancelled it and `isFinished()` never said yes.  
- 🧪 **Predict:** how many loops is one second of holding B? Then check.  

> 👀 **Notice what isn't there.** Your lesson's `execute()` doesn't touch a motor. The robot is doing a thing you described somewhere else, and the lesson only says *when*.

**Extra (1 pt)**: a command that knows when it's done, and one that gets shoved aside  

`Intake` returns `false` from `isFinished()` forever. Most commands aren't like that. A command that spins the flywheel up is finished the moment the flywheel is at speed — and it's the only thing that can know that.

- Add `public void spinUp(Shot shot)` to `Fuel`: both rollers to `shot.rollerPower`, conveyor to `0`. Rollers only; nothing gets fed yet.  
- Make `frc/robot/commands/SpinUp.java`, taking a `Fuel` **and** a `Shot`, with `addRequirements(fuel)`. The interesting method is one line:  

```java
@Override
public boolean isFinished() {
    return fuel.atSpeed(shot);      // lesson 29's check, finally doing real work
}
```

- **A** schedules it. Schedule only — no cancel, because this one ends itself.  
- Run it and tap **A** (the **5** key). **Predict what `SpinUp/State` ends up saying** and roughly how many loops it takes. In the simulator the rollers get there in well under half a second, much faster than a real flywheel.  
- 🧪 **The experiment:** hold **B** to intake, and *while still holding it*, press **A**. **Predict your log first.**  

Here is what actually comes out, in order:

```
SpinUp/State = spinning up  ->  reached speed  ->  Intake/State = started
  ->  SpinUp/State = spinning up  ->  Intake/State = interrupted
```

**`Intake` says `interrupted`, and you never cancelled it.** The scheduler did, because both commands called `addRequirements(fuel)` and there is only one fuel mechanism. Instead of two pieces of code fighting over the same rollers — which is exactly [Lesson 27](./LESSON27.md)'s bug, the one that left the rollers sitting at 0 — the newer command wins and the older one is told, properly, through `end(true)`.

> 🎯 **That is what commands are really for.** Not the four methods. The fact that something is keeping track of who owns what, so two pieces of code can't quietly ruin each other.

> 🤔 **One thing to sit with:** your `SpinUp` calls `fuel.stop()` in `end()`, so reaching speed immediately stops the rollers — right before you wanted to shoot. Hold that thought. Lesson 42 is where commands get joined into a sequence.

---

## 📜 Part 3 – Code Archaeology (2 pts, optional)

Open `src/main/java/frc/robot/commands/Intake.java` in [`OG-Code-2026`](https://github.com/Hudson-Robotics/OG-Code-2026), branch `Pre-DCMP-Flywheel`. You just wrote this file.

**Basic (1 pt)**: why is their `execute()` empty?  
- Theirs overrides the same four methods, calls `addRequirements`, and returns `false` from `isFinished()` — same as yours. But their `execute()` is `{ }`, and the rollers get set in **`initialize()`** instead.  
- It works, because a motor keeps its last command until something changes it. Setting it once is enough.  
- So which is better? Make the case for each, then answer this: **if something else set the rollers for one loop in the middle of the command, which version recovers?** Yours re-asserts 50 times a second. Theirs set it once, a while ago, and has no idea.  
- Both files still carry the auto-generated line *"You should consider using the more terse Command factories API"*. Nineteen commands, and nobody deleted it once. What does that tell you about how the file got made?  

**Extra (1 pt)**: the tuning slider that was never there  
- Open `SpinUp.java`. Its `initialize()` reads two numbers off the dashboard so they can be tuned at an event:  

```java
fuelSubsystem.setFeederRoller(
    SmartDashboard.getNumber("Launching spin-up feeder value", INDEXER_SPIN_UP_PRE_LAUNCH_PERCENT));
```

- Now search the whole project for who **publishes** `"Launching spin-up feeder value"`. Nobody does. The closest line is in `CANFuelSubsystem`, it is **commented out**, and it uses a *different* name (`"Spin-up feeder roller value"`).  
- So `getNumber` falls back to its default every single time. The slider never appeared on the dashboard, and nobody noticed, because the fallback is a perfectly reasonable number.  
- Trace that fallback — `INDEXER_SPIN_UP_PRE_LAUNCH_PERCENT` — back to `Constants.java`. It's under the `// Legacy / unused` label you investigated in [Lesson 31](./LESSON31.md).  
- Write down the failure: a value that *looks* tunable, isn't, and is labelled dead while being the only thing actually used. How would you have caught it? (Hint: what would `getNumber` have to do differently to be honest?)  

---

## 🏆 Total Points
- **Max:** 6 pts  
  - Java‑Only: 2 pts  
  - Robot Code: 2 pts  
  - Code Archaeology: 2 pts *(optional)*  

---

<!-- Drafting notes from the transcript draft. Hidden from students.
Ideas:  
- Emphasize that overriding = same method name, different behavior.  
- Robot code: subsystems override `activate()` for unique actions.  
- Archaeology: replace duplicated method names with overridden versions.  
- Segue: Next lesson → **toString() method overriding** (custom string representation of objects).  
-->
