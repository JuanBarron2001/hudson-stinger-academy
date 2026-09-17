# 🖥️ Lesson 13 – Enhanced Switches in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🐝

---

## 🎯 Overview
**Keywords:** Java, Enhanced Switch, Switch Expression, Case Labels, Default, Java 14, If‑Else Alternative  
Learn to:
- Replace long chains of `if/else if` with cleaner `switch` logic  
- Use the **enhanced switch** syntax with `->` (arrow operator)  
- Group multiple cases together with commas  
- Add a `default` case for unmatched values  
- Accept user input and evaluate it with a switch  
- Understand why enhanced switches are preferred over traditional switches  
- Use a switch to pick the 2026 robot's ball path  

---

## ⏱️ Progress Tracking

### 📊 For the Marathon Watchers  
- **Start Time in 12‑Hour Video:** [blank]  
- **Full Course (12h video):** [link here]

---

### 🎯 For the Quick‑Hit Learners  
- **Lesson Playlist:** [link here]  
- **This Lesson Only:** [link here]

---

## 💻 Part 1 – Java‑Only (2 pts)

**Basic (1 pt)**  
- Create a `String day = "Friday";`  
- Write an enhanced `switch` that prints:  
  - `"It is a weekday"` for Monday–Friday  
  - `"It is the weekend"` for Saturday–Sunday  
  - `"<day> is not a day"` for anything else  

**Extra (1 pt)**  
- Accept user input with `Scanner` for the day of the week.  
- Use the enhanced switch to evaluate the input.  
- Consolidate multiple cases with commas (e.g., `case "Monday", "Tuesday", ... ->`).  

---

## 🤖 Part 2 – Robot Code: the 2026 Robot (2 pts)

Your code goes in `robot-code/command-based-bot-2026/src/main/java/frc/lesson/lesson13/basic/Lesson13.java` (and `extra/Lesson13.java`). The task list is at the top of each file.  
Run it in the simulator the way you did in [Lesson 00](./LESSON00.md). CAN IDs, inversions and buttons are in [ROBOT.md](../robot-code/command-based-bot-2026/ROBOT.md).

**Basic (1 pt)**: a switch picks the ball path  
- Create the **operator controller**, both **rollers** and the **conveyor**.
- Turn buttons into a mode word with `if` / `else if`: **B** → `"INTAKE"`, **left bumper** → `"EJECT"`, **A** → `"SHOOT"`, otherwise `"STOP"`. At home those are the **6**, **3** and **5** keys.
- An enhanced `switch` on the mode sets `rollerPower` and `conveyorPower`, using the ball paths in ROBOT.md. `"SHOOT"` uses your lesson 07 power with the conveyor at `-0.7`, and `default` stops both.
- Set the motors and put the mode and both powers on SmartDashboard.

**Extra (1 pt)**: shuttle, and switches that hand back a value  
- Add `"SHUTTLE"` on the **right bumper** (the **4** key): rollers `-0.93`, conveyor `-0.7`.
- Replace the one switch with **two switch expressions**, `double conveyorPower = switch (mode) { ... };`, and combine cases with commas (`case "INTAKE", "EJECT" -> 0.8;`).
- Delete the `default` case, read the error, and put it back. Explain in a comment why Java insists.

---

## 📜 Part 3 – Code Archaeology (2 pts, optional)

> *Optional: skip this part if you're short on time.* Last season's code is [`Hudson-Robotics/OG-Code-2026`](https://github.com/Hudson-Robotics/OG-Code-2026), branch **`Pre-DCMP-Flywheel`**.

**Basic (1 pt)**  
- `Constants.java` has a comment block listing four ball paths. For each path, find the command that uses it (`Intake`, `Eject`, `FlywheelLaunchSequence`, `Shuttle`).

**Extra (1 pt)**  
- That comment says shuttle is **positive** intake plus negative feeder, and `SHUTTLE_ROLLER_PERCENT` is `+0.7`. But `Shuttle.java` actually spins the rollers at `SHUTTLE_RPS = -90`. Which one is true, the comment or the code? What happened to `SHUTTLE_ROLLER_PERCENT`?

---

## 🏆 Total Points
- **Max:** 6 pts  
  - Java‑Only: 2 pts  
  - Robot Code: 2 pts  
  - Code Archaeology: 2 pts *(optional)*

---

[CODE BLOCK]LOG
Ideas:
- Day‑of‑week example → relatable intro.  
- Robot code: enhanced switch for modes and commands.  
- Archaeology: replace long `if/else` chains with grouped cases.  
- Segue: Next lesson could cover **switch with yield** (returning values).  
[CODE BLOCK]
