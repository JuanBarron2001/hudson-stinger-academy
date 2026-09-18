# 🖥️ Lesson 12 – The Ternary Operator in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🐝

---

## 🎯 Overview
**Keywords:** Java, Ternary Operator, Conditional Operator, If‑Else Alternative, Modulus, Time of Day, Tax Rate  
Learn to:
- Use the ternary operator (`? :`) as a shorthand for `if/else`  
- Assign values based on conditions in a single line  
- Check pass/fail conditions with scores  
- Determine even/odd numbers using modulus  
- Convert military time to AM/PM  
- Apply conditional logic to calculate tax rates  
- Use ternaries on the 2026 robot's climber and to pick your alliance's hub  

---

## ⏱️ Progress Tracking

### 📊 For the Marathon Watchers  
If you’re following the **full 12‑hour compilation** and want to see how far you’ve made it through the *entire* course:  
- **Start Time in 12‑Hour Video:** [02:35:19](https://www.youtube.com/watch?v=xTtL8E4LzTQ&t=9319s)  
- **Full Course (12h video):** [Watch Compilation](https://www.youtube.com/watch?v=xTtL8E4LzTQ)

---

### 🎯 For the Quick‑Hit Learners  
If you just want **this lesson only** and to be done with it — no scrubbing through hours of footage:  
- **Lesson Playlist:** [Java tutorial for beginners (2025) ☕](https://www.youtube.com/playlist?list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc)  
- **This Lesson Only:** [Watch Lesson 12](https://www.youtube.com/watch?v=t2PcC-FYFmI&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=16) (Learn the Java ternary operator in 5 minutes! ❔, 5:51)

---

## 💻 Part 1 – Java‑Only (2 pts)

**Basic (1 pt)**  
- Create an integer `score = 70;`  
- Use the ternary operator to assign `"Pass"` (a score of 60 or more) or `"Fail"` to a string variable.  
- Print the result, then change the score to 55 and run it again.  

**Extra (1 pt)**  
- Write a program that:  
  - Checks if a number is even or odd using `% 2 == 0 ? "Even" : "Odd"`.  
  - Converts military time (e.g., `13`) into `"AM"` or `"PM"`.  
  - Calculates tax rate:  
    - If income ≥ 40,000 → `0.25`  
    - Else → `0.15`  

---

## 🤖 Part 2 – Robot Code: the 2026 Robot (2 pts)

Your code goes in `robot-code/command-based-bot-2026/src/main/java/frc/lesson/lesson12/basic/Lesson12.java` (and `extra/Lesson12.java`). The task list is at the top of each file.  
Run it in the simulator the way you did in [Lesson 00](./LESSON00.md). CAN IDs, inversions and buttons are in [ROBOT.md](../robot-code/command-based-bot-2026/ROBOT.md).

**Basic (1 pt)**: the climber  
- Create the **driver controller** and the **climber** (CAN 7).
- One ternary picks the climber power: `0.5` if the D-pad is pushed up (`driver.getPOV() == 0`, the **up arrow** at home), otherwise `0.0`.
- A second ternary picks a word from the climber's position: `"UP"` past 100 rotations, otherwise `"DOWN"`.
- Put the power, the position and the word on SmartDashboard.
- Rewrite the power ternary as an `if` / `else` in a comment. Which version is easier to read *here*?

**Extra (1 pt)**: which hub is ours?  
- Copy this line exactly. Lesson 43 explains how it works: `boolean isRed = DriverStation.getAlliance().orElse(Alliance.Blue) == Alliance.Red;`
- Use a ternary to pick the hub's x: `11.9903` if red, otherwise `4.5227`. The hub's y is `4.0214` either way, so notice when a ternary *isn't* needed.
- Switch the alliance in the simulator's **FMS** window and watch the hub's x change.
- **Precision mode:** while the driver's **right bumper** is held (the **2** key), scale driving by `0.35` instead of `0.7`, picked with a ternary.

---

## 📜 Part 3 – Code Archaeology (2 pts, optional)

> *Optional: skip this part if you're short on time.* Last season's code is [`Hudson-Robotics/OG-Code-2026`](https://github.com/Hudson-Robotics/OG-Code-2026), branch **`Pre-DCMP-Flywheel`**.

**Basic (1 pt)**  
- `VisionSubsystem.getHubCenter()` picks red or blue with a ternary. Rewrite it as an `if` / `else`. Which do you prefer, and why?

**Extra (1 pt)**  
- `getRobotPose()` is `return estimate != null ? estimate.pose : null;`. What does it hand back when the camera can't see anything? Find one caller, and explain what that caller does with the answer. (Lesson 14 comes back to this.)

---

## 🏆 Total Points
- **Max:** 6 pts  
  - Java‑Only: 2 pts  
  - Robot Code: 2 pts  
  - Code Archaeology: 2 pts *(optional)*

---

<!-- Drafting notes from the transcript draft. Hidden from students.
Ideas:
- Use ternary operator for quick pass/fail checks.  
- Robot code: joystick deadband logic in one line.  
- Archaeology: simplify nested `if/else` into ternary for cleaner code.  
- Segue: Next lesson could cover **switch statements** as another branching tool.  
-->
