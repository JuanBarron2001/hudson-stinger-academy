# 🖥️ Lesson 15 – While Loops in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🐝

---

## 🎯 Overview
**Keywords:** Java, While Loop, Do‑While Loop, Infinite Loop, User Input, Validation, Scanner  
Learn to:
- Use `while` loops to repeat code while a condition remains true  
- Prevent invalid input by re‑prompting users  
- Understand infinite loops and how to avoid them  
- Use `do‑while` loops to guarantee code runs at least once  
- Apply loops to real‑world scenarios like games and input validation  
- Understand why robot code never waits in a `while` loop, and when a `while` loop is fine  

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
- Create a `Scanner`.  
- Prompt the user to enter their name.  
- Use a `while` loop with `.isEmpty()` to keep asking until they type something.  
- Print `"Hello, <name>"` once valid input is given.  

**Extra (1 pt)**  
- Demonstrate an infinite loop example (`while (1 == 1)`) and explain why it never ends.  
- Create a simple game loop:  
  - Keep printing `"You are playing a game. Press Q to quit."`  
  - Exit only when the user types `"Q"`.  
- Show input validation with age:  
  - Keep asking until the user enters a non‑negative number.  

---

## 🤖 Part 2 – Robot Code: the 2026 Robot (2 pts)

Your code goes in `robot-code/command-based-bot-2026/src/main/java/frc/lesson/lesson15/basic/Lesson15.java` (and `extra/Lesson15.java`). The task list is at the top of each file.  
Run it in the simulator the way you did in [Lesson 00](./LESSON00.md). CAN IDs, inversions and buttons are in [ROBOT.md](../robot-code/command-based-bot-2026/ROBOT.md).

**Basic (1 pt)**: why robot code never waits  
> ⚠️ **Simulator only.** Never deploy the `while` version to the real robot.

- Create the **operator controller** and both **rollers**.
- **The wrong way:** while **A** is held, loop `while (Math.abs(-70 - velocity) >= 3)`, setting the rollers inside the loop.
- Run it and press **A**. Watch the dashboard and Sim Field, then stop the simulator.
- **Why did everything freeze?** Answer in a comment. *Hint: `execute()` has to finish before the robot does anything else, including updating how fast the rollers are spinning.*
- **The right way:** replace the `while` with an `if` that checks once per loop. The robot stays alive, because `execute()` runs again fifty times a second anyway.

**Extra (1 pt)**: a while loop that's fine  
- Create the driver controller, all four drive motors and the **Pigeon** gyro (`new Pigeon2(11)`), and drive with your lesson 04 arcade drive.
- The gyro's yaw keeps counting past 360, so two spins read 720. Wrap it into -180…180 with two `while` loops: subtract 360 while it's above 180, and add 360 while it's below -180.
- Put the raw yaw and the wrapped heading on SmartDashboard, then spin in circles (**J** / **L**).
- Why doesn't **this** `while` freeze the robot? Answer in a comment.

---

## 📜 Part 3 – Code Archaeology (2 pts, optional)

> *Optional: skip this part if you're short on time.* Last season's code is [`Hudson-Robotics/OG-Code-2026`](https://github.com/Hudson-Robotics/OG-Code-2026), branch **`Pre-DCMP-Flywheel`**.

**Basic (1 pt)**  
- Outside of `LimelightHelpers`, the team's code has **no `while` loops at all**. Explain why that's right for code that runs fifty times a second.

**Extra (1 pt)**  
- `VisionSubsystem.getAngleToHubDegrees()` wraps its angle with `MathUtil.inputModulus(desiredAngle - currentAngle, -180, 180)` and a comment saying "no loops needed". Compare it with your `while` loops. When would you pick each?

---

## 🏆 Total Points
- **Max:** 6 pts  
  - Java‑Only: 2 pts  
  - Robot Code: 2 pts  
  - Code Archaeology: 2 pts *(optional)*

---

[CODE BLOCK]LOG
Ideas:
- Show difference between `while` and `do‑while` with input validation.  
- Robot code: loop until a sensor condition is satisfied.  
- Archaeology: check for infinite loops or polling loops in old code.  
- Segue: Next lesson could cover **for loops** for counting iterations.  
[CODE BLOCK]
