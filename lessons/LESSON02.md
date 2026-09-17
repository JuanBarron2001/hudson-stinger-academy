# 🖥️ Lesson 02 – Variables in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🐝

---

## 🎯 Overview
**Keywords:** Java, Variables, Primitive Types, Reference Types, Strings, SmartDashboard, Code Archaeology  
Learn to:
- Understand variables as reusable containers for values
- Differentiate between **primitive** and **reference** data types
- Declare, assign, and use variables in Java
- Output variables to the console and to **SmartDashboard**
- Recognize good vs. bad variable naming and avoid “magic numbers”

---

## ⏱️ Progress Tracking

### 📊 For the Marathon Watchers  
If you’re following the **full 12‑hour compilation** and want to see how far you’ve made it through the *entire* course:  
- **Start Time in 12‑Hour Video:** [00:10:58](https://www.youtube.com/watch?v=xTtL8E4LzTQ&t=658s)  
- **Full Course (12h video):** [Watch Compilation](https://www.youtube.com/watch?v=xTtL8E4LzTQ)

---

### 🎯 For the Quick‑Hit Learners  
If you just want **this lesson only** and to be done with it — no scrubbing through hours of footage:  
- **Lesson Playlist:** [Java tutorial for beginners (2025) ☕](https://www.youtube.com/playlist?list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc)  
- **This Lesson Only:** [Watch Lesson 02](https://www.youtube.com/watch?v=TGVLmr194DI&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=4)

---

## 💻 Part 1 – Java‑Only (2 pts)

**Basic (1 pt)**  
- Complete the **homework from the video**:  
  - Create **five variables** — one each for: a string, an integer, a double, a char, and a boolean.  
  - Print them all to the console.

**Extra (1 pt)**  
- Write a **simple introduction program** that:  
  - Stores your **name**, **grade**, and **age** as variables (no types given — you choose the correct ones).  
  - Stores whether you are a **senior** as a boolean.  
  - Uses an `if / else` statement:  
    - If senior → print `"Almost there!"`  
    - Else → print `"School is fun!"`  
  - Bonus creativity points: include **at least two more variables** of your choice (e.g., favorite subject, GPA, club name) and weave them into your introduction.

---

## 🤖 Part 2 – Robot Code: the 2026 Robot (2 pts)

Your code goes in `robot-code/command-based-bot-2026/src/main/java/frc/lesson/lesson02/basic/Lesson02.java` (and `extra/Lesson02.java`). The task list is at the top of each file.  
Run it in the simulator the way you did in [Lesson 00](./LESSON00.md). CAN IDs, inversions and buttons are in [ROBOT.md](../robot-code/command-based-bot-2026/ROBOT.md).

**Basic (1 pt)**  
- Store the **team number** (4295) in a variable and put it on SmartDashboard.
- Store the **left leader** drive motor's CAN ID in a variable, and use it to create the motor: `new TalonFX(leftLeaderId)`.
- Store a speed of **0.25** in a variable, set the motor to it, and put the speed on SmartDashboard.
- Run it and open **Sim Field**. Only one of the robot's four drive motors is pushing. **What does the robot do?** Write your answer as a comment in your code.

**Extra (1 pt)**  
- Store the **team number** and **team name** in variables and put both on SmartDashboard.
- Store **all four** drivetrain CAN IDs in variables with clear names (`leftLeaderId`, not `id1`), and create all four motors from them.
- Pick **one speed under 0.5**, store it in a variable, and set all four motors to it. Put the speed on SmartDashboard.
- Run it and watch **Sim Field**. The robot does *not* drive forward. **What does it do, and why do you think that happens?** Write your guess as a comment. Lesson 03 has the answer.

---

## 📜 Part 3 – Code Archaeology (2 pts, optional)

> *Optional: skip this part if you're short on time.* Last season's code is [`Hudson-Robotics/OG-Code-2026`](https://github.com/Hudson-Robotics/OG-Code-2026), branch **`Pre-DCMP-Flywheel`**.

**Basic (1 pt)**  
- Open `Constants.java`. Pick **one CAN ID variable**, find where it's used, and explain what its name tells you.

**Extra (1 pt)**, pick one:  
- **Magic number:** find a bare number with no name, like `365` in `ClimbUp.java` or `6380.0` in `CANDriveSubsystem.java` (see [Magic number – Wikipedia](https://en.wikipedia.org/wiki/Magic_number_%28programming%29)). Explain what it means and what a named constant would fix.
- **Bad name:** find the class named `ClimbConstatns`. What's wrong with the name, why didn't Java care, and why should *we*?

---

## 🏆 Total Points
- **Max:** 6 pts  
  - Java‑Only: 2 pts  
  - Robot Code: 2 pts  
  - Code Archaeology: 2 pts *(optional)*

---

> 🐝 *"The sting is in the details — master them, and you master the bot."*