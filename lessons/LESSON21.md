# 🖥️ Lesson 21 – Variable Scope in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🐝

---

## 🎯 Overview
**Keywords:** Java, Variable Scope, Local Variables, Class Variables, Static, Methods  
Learn to:
- Understand **local scope** (variables declared inside methods or blocks)  
- Understand **class scope** (variables declared inside a class but outside methods)  
- Recognize variable shadowing when local and class variables share the same name  
- Know when to use local vs. class variables  
- Apply scope rules to avoid conflicts and bugs  
- Understand why motors and controllers live in fields, and build a button toggle  

---

## ⏱️ Progress Tracking

### 📊 For the Marathon Watchers  
If you’re following the **full 12‑hour compilation** and want to see how far you’ve made it through the *entire* course:  
- **Start Time in 12‑Hour Video:** [04:25:59](https://www.youtube.com/watch?v=xTtL8E4LzTQ&t=15959s)  
- **Full Course (12h video):** [Watch Compilation](https://www.youtube.com/watch?v=xTtL8E4LzTQ)

---

### 🎯 For the Quick‑Hit Learners  
If you just want **this lesson only** and to be done with it — no scrubbing through hours of footage:  
- **Lesson Playlist:** [Java tutorial for beginners (2025) ☕](https://www.youtube.com/playlist?list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc)  
- **This Lesson Only:** [Watch Lesson 21](https://www.youtube.com/watch?v=eVCK1jlopmY&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=28) (Learn VARIABLE SCOPE in 4 minutes! 🏠, 4:59)

---

## 💻 Part 1 – Java‑Only (2 pts)

**Basic (1 pt)**  
- Create a local variable `x = 1` inside `main()`.  
- Print it.  
- Create another method `doSomething()` with its own local variable `x = 2`.  
- Print it.  
- Call both methods and observe that each method uses its own version of `x`.  

**Extra (1 pt)**  
- Add a class variable `static int x = 3;`.  
- Delete the local variables and print `x` from both methods → result is `3`.  
- Reintroduce local variables with the same name and observe **shadowing**:  
  - Local variable takes priority over class variable.  

---

## 🤖 Part 2 – Robot Code: the 2026 Robot (2 pts)

Your code goes in `robot-code/command-based-bot-2026/src/main/java/frc/lesson/lesson21/basic/Lesson21.java` (and `extra/Lesson21.java`). The task list is at the top of each file.  
Run it in the simulator the way you did in [Lesson 00](./LESSON00.md). CAN IDs, inversions and buttons are in [ROBOT.md](../robot-code/command-based-bot-2026/ROBOT.md).

**Basic (1 pt)**: why variables have been living up top  
- In `execute()`, declare a **local** counter (`int localCount = 0; localCount++;`) and put it on SmartDashboard.
- Declare a **field** counter (`private int fieldCount = 0;`) outside any method, add 1 to it in `execute()`, and put it on SmartDashboard.
- Run for five seconds. What does each counter show? Explain **why** in a comment.
- This stub has no fields, so declare your **own** for the operator controller and both rollers. Create them in `setup()` and run the rollers at `0.3` while **A** is held.
- What would go wrong if you created the rollers inside `execute()`? Answer in a comment.

**Extra (1 pt)**: toggles and memory  
- Make **B** a toggle: one press turns intake on, the next turns it off. You'll need a field that remembers whether B was pressed **last loop**: `if (bPressed && !bWasPressed)`.
- When intake is on: rollers `-0.7`, conveyor `0.8` (ROBOT.md). Otherwise stop them.
- Keep a field with the **fastest roller speed ever seen** (`Math.max`). Put it and whether intake is on on SmartDashboard.
- **Shadowing:** add a field `double rollerPower = 0.7;` and a local `double rollerPower = 0.2;` inside `execute()`. Which one does your code use, and how do you reach the field? *(Hint: `this.`)*

---

## 📜 Part 3 – Code Archaeology (2 pts, optional)

> *Optional: skip this part if you're short on time.* Last season's code is [`Hudson-Robotics/OG-Code-2026`](https://github.com/Hudson-Robotics/OG-Code-2026), branch **`Pre-DCMP-Flywheel`**.

**Basic (1 pt)**  
- `FlywheelTuningCommand.java` reads a local `boolean feedNow` and then never uses it. Its documentation says setting "Feed Now", or pressing B, feeds a ball. Does it? Is B even bound on the tuner controller in `RobotContainer.java`?

**Extra (1 pt)**  
- The same command keeps `lastKS`, `lastKV` and `lastKP` as **fields**. Why can't those be local variables? What would happen to the flywheel if they were?

---

## 🏆 Total Points
- **Max:** 6 pts  
  - Java‑Only: 2 pts  
  - Robot Code: 2 pts  
  - Code Archaeology: 2 pts *(optional)*

---

<!-- Drafting notes from the transcript draft. Hidden from students.
Ideas:
- Use analogy of houses (local variables inside, class variable outside on the street).  
- Robot code: class variable for constants like wheel diameter.  
- Archaeology: reduce overuse of class variables, prefer local scope.  
- Segue: Next lesson could cover **final variables and constants** or **object scope** in OOP.  
-->
