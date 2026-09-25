# 🖥️ Lesson 31 – The `static` Keyword in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🐝  

---

## 🎯 Overview
**Keywords:** Java, static, Class Members, Shared Variables, Utility Methods  
Learn to:
- Understand that `static` makes a variable or method belong to the **class**, not the object  
- Use `static` variables to share data across all objects  
- Use `static` methods as **utility methods** (e.g., `Math.round()`)  
- Access static members via the **class name** instead of an object reference  

---

## ⏱️ Progress Tracking

### 📊 For the Marathon Watchers  
If you’re following the **full 12‑hour compilation** and want to see how far you’ve made it through the *entire* course:  
- **Start Time in 12‑Hour Video:** [07:14:07](https://www.youtube.com/watch?v=xTtL8E4LzTQ&t=26047s)  
- **Full Course (12h video):** [Watch Compilation](https://www.youtube.com/watch?v=xTtL8E4LzTQ)

---

### 🎯 For the Quick‑Hit Learners  
If you just want **this lesson only** and to be done with it — no scrubbing through hours of footage:  
- **Lesson Playlist:** [Java tutorial for beginners (2025) ☕](https://www.youtube.com/playlist?list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc)  
- **This Lesson Only:** [Watch Lesson 31](https://www.youtube.com/watch?v=qULACa4D_vg&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=43) (Learn the STATIC keyword in 8 minutes! 🤝, 8:01)

---

## 💻 Part 1 – Java‑Only (2 pts)

> New classes go in their own file next to `Main.java`, starting with the same `package` line, like lesson 27: `Friend.java` starts with `package lesson31.basic;` in the basic folder, and the extra folder gets its own copy with `package lesson31.extra;`.

**Basic (1 pt)**  
- **First, without `static`**, the way the video starts: give `Friend` a `String name` and a plain `int numberOfFriends = 0;`, and a constructor, `Friend(String name)`, that sets the name and adds 1 to `numberOfFriends`.  
- In `main()`, create two friends and print **each one's** `numberOfFriends`. **Predict it first.** Then explain in a comment why both say `1`.  
- Now make it `static int numberOfFriends = 0;`, so every `Friend` shares **one** count instead of each keeping its own. Create a few more friends and print the total: it goes up with every friend now.  

Expected output, before `static`:  

```
1
1
```

**Extra (1 pt)**  
- Add a static method to `Friend`, `static void showFriends()`, which prints `You have `, the count, and ` total friends`. There's no `this.` in a static method, because it doesn't belong to any one friend.  
- In `main()`, create three friends (SpongeBob, Patrick and Squidward), then print `Friend.numberOfFriends` and call `Friend.showFriends()`, both through the **class name**.  
- Use `Friend.numberOfFriends`, not `f1.numberOfFriends`. It works either way, but the class name tells the reader the value belongs to the class, not to one friend.  
- `Math.round(2.5)` is a static method too: you've been calling it on the class since lesson 07, without ever writing `new Math()`. Print one to prove it.  

Expected output:  

```
3
You have 3 total friends
3
```

---

## 🤖 Part 2 – Robot Code: the 2026 Robot (2 pts)

Your code goes in `robot-code/command-based-bot-2026/src/main/java/frc/lesson/lesson31/basic/Lesson31.java` (and `extra/Lesson31.java`). The task list is at the top of each file.  
Run it in the simulator the way you did in [Lesson 00](./LESSON00.md). Every number you are about to move lives in [ROBOT.md](../robot-code/command-based-bot-2026/ROBOT.md).

> 🧱 Same robot, fourth lesson on it. This one doesn't add a mechanism — it cleans up the three classes you already have.

**Basic (1 pt)**: `Constants`, the file every robot has  

Count the loose numbers in your code right now: `1`, `2`, `3`, `4`, `5`, `6`, `29`, `60`, `100`, `80`, `-0.7`, `0.8`, `-0.72`, `-70`, `0.7`. Each one is typed somewhere specific, and when the conveyor moves to a different CAN ID you get to go find them all.

A CAN ID is not something a `Fuel` **has**. There is one conveyor on the robot. That is what `static` is for: it belongs to the class, not to any one object.

- Make `frc/robot/Constants.java` — `public final class Constants` — with nested groups inside it:  

```java
public final class Constants {
    public static final class DriveConstants {
        public static final int LEFT_LEADER_ID = 1;
        public static final double FORWARD_SCALE = 0.7;
        // ...
    }

    public static final class FuelConstants {
        public static final int CONVEYOR_ID = 29;
        public static final double SHORT_SHOT_RPS = -70;
        // ...
    }
}
```

- Move the numbers in. `DriveConstants` takes the four CAN IDs, the 60 A limit, the two stick scales and a `DEADBAND` of `0.1`. `FuelConstants` takes CAN 5, 6 and 29, both current limits, the intake powers, and the short shot's power, RPS and ±3 tolerance.  
- Point `Drivetrain`, `Fuel` and `Shot` at them. Nothing else changes.  
- In the lesson, publish three constants in `setup()` — and notice what you never write:  

```java
SmartDashboard.putNumber("Const/Short Shot RPS", Constants.FuelConstants.SHORT_SHOT_RPS);
```

There is no `new Constants()` anywhere. There never will be.

- Run it. It should behave **exactly** like lesson 29 — same driving, same shots. A change that changes nothing is the entire point of this half.  

> 📦 **Why nested classes and not one flat list?** A flat `Constants` becomes 200 lines of numbers with names like `LEFT_ID`, and you start guessing. Grouped, the name can be short, because `DriveConstants.LEFT_LEADER_ID` already says which left it is.

**Extra (1 pt)**: a static method, a static import, and a counter that catches a real bug  

- Make `frc/robot/RobotMath.java` with one static method — [Lesson 19](./LESSON19.md)'s deadband: `public static double deadband(double value, double band)`, returning `0` when `Math.abs(value) < band`. Nothing about it needs a drivetrain, or a robot, or any object, so it's `static`. Call it as `RobotMath.deadband(...)`.  
- Add a counter to `Drivetrain`: `public static int built = 0;`, with `built++` in the constructor that does the real work (the two-argument one — the chained one must not double-count). Publish it straight off the class: `Drivetrain.built`.  
- Add the static import at the top of the lesson: `import static frc.robot.Constants.DriveConstants.DEADBAND;`, and write `DEADBAND` on its own from then on.  
- Run it and tap **W** gently. `Forward After Deadband` sits at exactly **0.0** until you push past `0.1`, then jumps. `Drivetrains Built` reads exactly **1**.  
- 🧪 **The experiment:** add a second `new Drivetrain();` in `setup()` and run it again. **Predict the counter first.** Then take it out.  

> 🔎 **That counter is a real check, not a toy.** One robot has one drivetrain, so the number should be `1` forever. If it ever reads `2`, something built a second one behind your back — which is [Lesson 27](./LESSON27.md)'s two-objects-one-motor bug, except now you can see it on the dashboard instead of wondering why the robot feels dead.

---

## 📜 Part 3 – Code Archaeology (2 pts, optional)

Open `src/main/java/frc/robot/Constants.java` in [`OG-Code-2026`](https://github.com/Hudson-Robotics/OG-Code-2026), branch `Pre-DCMP-Flywheel`. It's 218 lines and seven nested classes — the grown-up version of what you just wrote, including the same `public static final class` shape and the same static imports.

**Basic (1 pt)**: a label that lies, twice  
- Find the comment `// Legacy / unused` inside `FuelConstants`, around line 80. Six constants sit under it.  
- Now go check. Search the project for `INDEXER_INTAKING_PERCENT`, `INTAKE_INTAKING_PERCENT` and `LAUNCHING_LAUNCHER_PERCENT`. **Every one of them is still in use** — two to four times each, in `CANFuelSubsystem` and the launch commands. The label is wrong.  
- Then look at `LauncherConstants`, the last class in the file. `RobotContainer` static-imports it with `import static frc.robot.Constants.LauncherConstants.*;` — and uses **none of its six values**. That class really is dead, and nothing says so.  
- So the file labels live code as dead and leaves dead code unlabelled. Write down what you'd trust instead of the comment, and how long it took you to check.  

**Extra (1 pt)**: the typo you can't fix in five seconds  
- Line 113: `public static final class ClimbConstatns`. Read it again.  
- It shipped. It went to competition. Every file that uses a climber constant spells it that way, because it has to.  
- That's the real cost: a typo in a `private` variable is a five-second fix, but this one is **public**, so renaming it means touching every file that refers to it. Find them all (`grep -rn ClimbConstatns src/`), and count how many lines a correct spelling would touch.  
- While you're in there: `CLIMBER_MOTOR_DOWN_PERCENT = -0.3867`. Where does a number like that come from? Compare it with `CLIMBER_MOTOR_UP_PERCENT = 0.95` — which one was measured and which was guessed?  

---

## 🏆 Total Points
- **Max:** 6 pts  
  - Java‑Only: 2 pts  
  - Robot Code: 2 pts  
  - Code Archaeology: 2 pts *(optional)*  

---

<!-- Drafting notes from the transcript draft. Hidden from students.
Ideas:  
- Show difference between instance vs. static variables.  
- Robot code: static counters for motors, sensors, or subsystems.  
- Archaeology: replace redundant counters with static variables.  
- Segue: Next lesson → **Inheritance** (how classes can share attributes and methods).  
-->
