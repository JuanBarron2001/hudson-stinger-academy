# 🖥️ Lesson 04 – Arithmetic Operators in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🐝

---

## 🎯 Overview
**Keywords:** Java, Arithmetic Operators, Addition, Subtraction, Multiplication, Division, Modulus, Augmented Assignment, SmartDashboard, Code Archaeology  
Learn to:
- Use two variables to perform core math operations
- Read user input and compute results
- Apply scaling math to robot code (motor speed)
- Estimate theoretical RPM and linear speed from joystick input
- Analyze old code where math is used and propose improvements

---

## ⏱️ Progress Tracking

### 📊 For the Marathon Watchers  
If you’re following the **full 12‑hour compilation** and want to see how far you’ve made it through the *entire* course:  
- **Start Time in 12‑Hour Video:** [00:54:08](https://www.youtube.com/watch?v=xTtL8E4LzTQ&t=3248s)  
- **Full Course (12h video):** [Watch Compilation](https://www.youtube.com/watch?v=xTtL8E4LzTQ)

---

### 🎯 For the Quick‑Hit Learners  
If you just want **this lesson only** and to be done with it — no scrubbing through hours of footage:  
- **Lesson Playlist:** [Java tutorial for beginners (2025) ☕](https://www.youtube.com/playlist?list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc)  
- **This Lesson Only:** [Watch Lesson 03](https://www.youtube.com/watch?v=QAD5unRlCyo&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=5)

---

## 💻 Part 1 – Java‑Only (2 pts)

**Basic (1 pt)**  
- Create two variables (choose the types and values, e.g., integers).  
- Perform and print:
  - Addition (+)
  - Subtraction (−)
  - Multiplication (×)
  - Division (÷)
  - Modulus (%)  
- Print each operation with both the expression and the result (e.g., `10 + 3 = 13`).

**Extra (1 pt)**  
- Ask the user for two numbers using `Scanner`.  
- Perform at least three operations with those inputs and print the results.  
- Optional: also show floating‑point division by casting to `double`.

---

## 🤖 Part 2 – Robot Code: the 2026 Robot (2 pts)

Your code goes in `robot-code/command-based-bot-2026/src/main/java/frc/lesson/lesson04/basic/Lesson04.java` (and `extra/Lesson04.java`). The task list is at the top of each file.  
Run it in the simulator the way you did in [Lesson 00](./LESSON00.md). CAN IDs, inversions and buttons are in [ROBOT.md](../robot-code/command-based-bot-2026/ROBOT.md).

**Basic (1 pt)**: arcade drive, by hand  
- Create the driver controller and all four drive motors.
- `forward` = the left stick's up/down, sign flipped, **× 0.7**. `turn` = `driver.getRightX()` **× 0.8**. Those are the competition robot's stick scaling numbers, because a full-strength stick is too twitchy to drive.
- `left = forward + turn` and `right = forward - turn`. Set the motors, with the right side still getting the opposite sign.
- Put `forward`, `turn`, `left` and `right` on SmartDashboard.
- Hold **W** and **L** together. What number does `left` show, and what can a motor actually do with a number like that? Answer in a comment.

**Extra (1 pt)**: distance and top speed  
- Drive with your arcade code from the basic half.
- Read the left leader's encoder: `leftLeader.getPosition().getValueAsDouble()` is **motor rotations**.
- Convert to meters: **÷ 10.71** (gear ratio) gives wheel rotations, then **× `Math.PI` × 0.1524** (wheel diameter in meters) gives meters. Put both on SmartDashboard.
- Drive straight forward, then compare your meters with the true distance, the first number in **Sim Field → Robot**. How close are they?
- A Kraken X60 spins about **6000 RPM** with nothing attached. Work out the robot's **top speed** in m/s and mph (÷ 60, ÷ 10.71, × π × 0.1524, then × 2.237 for mph) and put both on SmartDashboard.

---

## 📜 Part 3 – Code Archaeology (2 pts, optional)

> *Optional: skip this part if you're short on time.* Last season's code is [`Hudson-Robotics/OG-Code-2026`](https://github.com/Hudson-Robotics/OG-Code-2026), branch **`Pre-DCMP-Flywheel`**.

**Basic (1 pt)**  
- `CANDriveSubsystem.java` has `METERS_PER_MOTOR_ROTATION`. Walk through its math step by step and compare it with yours. Same answer?

**Extra (1 pt)**  
- `driveRobotRelative` assumes a free speed of **6380 RPM**, which is a *Falcon 500*. Look at the real robot, or ask a mentor: are its drive motors Falcons or Krakens? How far off is the competition code's top speed if they're Krakens?

---

## 🏆 Total Points
- **Max:** 6 pts  
  - Java‑Only: 2 pts  
  - Robot Code: 2 pts  
  - Code Archaeology: 2 pts *(optional)*

---

> 🐝 *"Math isn’t just numbers — it’s the language your robot speaks."*