# 🖥️ Lesson 01 – Java Setup & Printouts

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🐝

---

## 🎯 Overview
**Keywords:** Java, VS Code, WPILib, SmartDashboard, FRC, Print Statements  
Learn to:
- Set up Java in **VS Code** with WPILib
- Write your first Java program
- Output to **SmartDashboard** in robot code
- Read & understand SmartDashboard usage in past robot code

---

## ⏱️ Progress Tracking

### 📊 For the Marathon Watchers  
If you’re following the **full 12‑hour compilation** and want to see how far you’ve made it through the *entire* course:  
- **Start Time in 12‑Hour Video:** [00:00:00](https://www.youtube.com/watch?v=xTtL8E4LzTQ)
- **Full Course (12h video):** [Watch Compilation](https://www.youtube.com/watch?v=xTtL8E4LzTQ)

---

### 🎯 For the Quick‑Hit Learners  
If you just want **this lesson only** and to be done with it — no scrubbing through hours of footage:  
- **Lesson Playlist:** [Java tutorial for beginners (2025) ☕](https://www.youtube.com/playlist?list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc)  
- **This Lesson Only:** [Watch Lesson 01](https://www.youtube.com/watch?v=23HFxAPyJ9U&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=1)

---

## 💻 Part 1 – Java‑Only (2 pts)

**Basic (1 pt)**  
- Follow along with the YouTube video to set up Java in VS Code and run your first print statement.

**Extra (1 pt)**  
- Complete the homework: write a short poem, share fun facts, or introduce yourself using print statements.

---

## 🤖 Part 2 – Robot Code: the 2026 Robot (2 pts)

Your code goes in `robot-code/command-based-bot-2026/src/main/java/frc/lesson/lesson01/basic/Lesson01.java` (and `extra/Lesson01.java`). The task list is at the top of each file.  
Run it in the simulator the way you did in [Lesson 00](./LESSON00.md). CAN IDs, inversions and buttons are in [ROBOT.md](../robot-code/command-based-bot-2026/ROBOT.md).

**Basic (1 pt)**  
- Put one message on **SmartDashboard**, like `SmartDashboard.putString("Hello", "Hello from the 2026 robot!");`
- Run the simulator, click **Teleoperated**, and find your message under **NetworkTables → SmartDashboard**.

**Extra (1 pt)**  
- A driver of the 2026 robot is in the middle of a match. Put **three** values on SmartDashboard that they would want to see, **one of each kind**:
  - a **number** with `putNumber`, like the flywheel's speed
  - a **true/false** with `putBoolean`, like whether the Limelight sees the hub
  - a **word** with `putString`, like whether the climber is `"UP"` or `"DOWN"`
- The values are made up for now. Later lessons replace them with real sensor readings.

---

## 📜 Part 3 – Code Archaeology (2 pts, optional)

> *Optional: skip this part if you're short on time.* Last season's code is [`Hudson-Robotics/OG-Code-2026`](https://github.com/Hudson-Robotics/OG-Code-2026), branch **`Pre-DCMP-Flywheel`**.

**Basic (1 pt)**  
- Search the code for `SmartDashboard.put`. Pick **two** and explain who each one is for: a **driver** during a match, or a **programmer** fixing something.

**Extra (1 pt)**  
- `ClimbUp.java` publishes a value named just `Pos`. The position of *what*, and in what units? Suggest a better name, and explain why yours is better.

---

## 🏆 Total Points
- **Max:** 6 pts  
  - Java‑Only: 2 pts  
  - Robot Code: 2 pts  
  - Code Archaeology: 2 pts *(optional)*

---

> 🐝 *"The sting is in the details — master them, and you master the bot."*