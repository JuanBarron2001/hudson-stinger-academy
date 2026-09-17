# 🖥️ Lesson 16 – For Loops in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🐝

---

## 🎯 Overview
**Keywords:** Java, For Loop, Iteration, Counter, Index, Scanner, Countdown, Thread.sleep  
Learn to:
- Understand the structure of a `for` loop (initialization, condition, update)  
- Use a counter variable (`i`) to control loop iterations  
- Increment, decrement, or step by custom values  
- Accept user input to control loop length  
- Build a countdown mini‑project with `Thread.sleep()` for timing  
- Use `for` loops for a CAN pit check and a dashboard speed bar (and learn why `Thread.sleep()` has no place in robot code)  

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
- Write a `for` loop that prints `"Pizza"` 10 times.  
- Print the loop index `i` to show iteration counts.  

**Extra (1 pt)**  
- Experiment with:  
  - Starting at 1 and looping to 10 (`i = 1; i <= 10; i++`)  
  - Decrementing from 10 down to 1 (`i = 10; i > 0; i--`)  
  - Incrementing by 2 or 3 (`i += 2`, `i += 3`)  
- Accept user input with `Scanner` for how many times to loop.  

---

## 🤖 Part 2 – Robot Code: the 2026 Robot (2 pts)

Your code goes in `robot-code/command-based-bot-2026/src/main/java/frc/lesson/lesson16/basic/Lesson16.java` (and `extra/Lesson16.java`). The task list is at the top of each file.  
Run it in the simulator the way you did in [Lesson 00](./LESSON00.md). CAN IDs, inversions and buttons are in [ROBOT.md](../robot-code/command-based-bot-2026/ROBOT.md).

**Basic (1 pt)**: pit check  
- On the **first** loop only (use the `checked` field), a `for` loop goes through CAN IDs **1 to 8**, creates `new TalonFX(id)`, and puts `"CAN " + id + " Connected"` = `motor.isConnected()` on SmartDashboard.
- Look up every ID in ROBOT.md. Which one comes back `false`, and why?
- The conveyor is CAN **29**. How would you check it without looping all the way to 29? Lesson 22's arrays make this clean.

**Extra (1 pt)**: a speed bar  
- Create the **operator controller** and both **rollers**, and run them while **A** is held.
- `blocks = (int) (Math.abs(velocity) / 10)`. Start with `bar = ""`, and use a `for` loop to add `"#"` to it `blocks` times.
- Put the bar on SmartDashboard, then press and release **A** and watch it grow and shrink.
- This `for` loop runs inside `execute()` and doesn't freeze the robot like lesson 15's `while`. What's the difference? Answer in a comment.

---

## 📜 Part 3 – Code Archaeology (2 pts, optional)

> *Optional: skip this part if you're short on time.* Last season's code is [`Hudson-Robotics/OG-Code-2026`](https://github.com/Hudson-Robotics/OG-Code-2026), branch **`Pre-DCMP-Flywheel`**.

**Basic (1 pt)**  
- `VisionSubsystem.getVisibleTags()` and `getAvgTagDistance()` both loop over `RawFiducial`s. Explain what one of those loops goes through and what it builds.

**Extra (1 pt)**  
- `VisionSubsystem.periodic()` publishes `Vision/Tag 0`, `Vision/Tag 1`, … with a `for` loop, but never removes old keys. If the camera sees three tags and then only one, what does the dashboard show? Why is that misleading, and how would you fix it?

---

## 🏆 Total Points
- **Max:** 6 pts  
  - Java‑Only: 2 pts  
  - Robot Code: 2 pts  
  - Code Archaeology: 2 pts *(optional)*

---

[CODE BLOCK]LOG
Ideas:
- Show difference between `for` and `while` loops.  
- Robot code: loop through motors or LEDs for testing.  
- Archaeology: replace repeated code blocks with a loop.  
- Segue: Next lesson could cover **nested loops** for grids or patterns.  
[CODE BLOCK]
