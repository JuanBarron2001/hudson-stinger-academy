# 🖥️ Lesson 07 – Math Constants & Methods in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🐝

---

## 🎯 Overview
**Keywords:** Java, Math Class, Constants, Methods, Pi, E, Power, Square Root, Absolute Value, Rounding, Max, Min  
Learn to:
- Use built‑in math constants (`Math.PI`, `Math.E`)  
- Apply math methods (`pow`, `abs`, `sqrt`, `round`, `ceil`, `floor`, `max`, `min`)  
- Perform calculations with user input  
- Solve geometry problems (triangle hypotenuse, circle/sphere formulas)  
- Format numeric output with `printf`  
- Use `Math.abs`, `Math.max` and `Math.pow` to check the 2026 robot's flywheel speed and tame its drive math  

---

## ⏱️ Progress Tracking

### 📊 For the Marathon Watchers  
If you’re following the **full 12‑hour compilation** and want to see how far you’ve made it through the *entire* course:  
- **Start Time in 12‑Hour Video:** [01:27:28](https://www.youtube.com/watch?v=xTtL8E4LzTQ&t=5248s)  
- **Full Course (12h video):** [Watch Compilation](https://www.youtube.com/watch?v=xTtL8E4LzTQ)

---

### 🎯 For the Quick‑Hit Learners  
If you just want **this lesson only** and to be done with it — no scrubbing through hours of footage:  
- **Lesson Playlist:** [Java tutorial for beginners (2025) ☕](https://www.youtube.com/playlist?list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc)  
- **This Lesson Only:** [Watch Lesson 07](https://www.youtube.com/watch?v=nle8CQXYhl4&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=9) (The Java Math class + exercises! 📐, 15:10)

---

## 💻 Part 1 – Java‑Only (2 pts)

**Basic (1 pt)**  
- Print `Math.PI` and `Math.E`.  
- Demonstrate `Math.pow`, `Math.abs`, and `Math.sqrt`.  
- Show rounding with `Math.round`, `Math.ceil`, and `Math.floor`.  
- Compare two numbers with `Math.max` and `Math.min`.  

**Extra (1 pt)**  
The video's two exercises. Use a `Scanner` for the inputs.
- **Hypotenuse:** ask for sides `a` and `b` of a right triangle, then `c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2))`. Test it with 3 and 4: you should get 5.
- **Circle and sphere:** ask for a `radius`, then print:
  - circumference = `2 * Math.PI * radius`
  - area = `Math.PI * Math.pow(radius, 2)`
  - sphere volume = `(4.0 / 3) * Math.PI * Math.pow(radius, 3)`. Try it with `4 / 3` first. Why is the answer wrong? *(Hint: lesson 04's integer division.)*
- Put a unit on each answer (cm, cm², cm³). Optional: show one decimal place with `System.out.printf("%.1f cm%n", area);`, which lesson 08 explains.

---

## 🤖 Part 2 – Robot Code: the 2026 Robot (2 pts)

Your code goes in `robot-code/command-based-bot-2026/src/main/java/frc/lesson/lesson07/basic/Lesson07.java` (and `extra/Lesson07.java`). The task list is at the top of each file.  
Run it in the simulator the way you did in [Lesson 00](./LESSON00.md). CAN IDs, inversions and buttons are in [ROBOT.md](../robot-code/command-based-bot-2026/ROBOT.md).

**Basic (1 pt)**: is the flywheel at speed?  
- Create the **operator controller** and both **rollers**. While **A** is held (the **5** key at home), run the rollers at a power you pick. Negative launches, and **both rollers get the same number**: the two motors turn the same rollers, so they have to agree or they fight.
- `target = -70` (the short shot, in rotations per second), `actual = leftRoller.getVelocity().getValueAsDouble()`, and `error = target - actual`.
- `atSpeed = Math.abs(error) < 3`. `Math.abs` throws away the minus sign, because being 5 away is 5 away whether you're above or below.
- Put `target`, `actual`, `error` and `atSpeed` on SmartDashboard.
- **Find a power that makes `atSpeed` true**, and list every power you tried in a comment. On the real robot the right power is different, and it changes as the battery drains. Keep that in mind for Part 3.

**Extra (1 pt)**: drive math that behaves  
- Start from your lesson 04 arcade drive.
- **Square the sticks** for gentler low-speed control: `Math.signum(stick) * Math.pow(stick, 2)`, then scale. Squaring a negative makes it positive, so `Math.signum` puts the sign back.
- **Fix numbers bigger than 1 without changing the turn:** `biggest = Math.max(Math.abs(left), Math.abs(right))`, and if `biggest > 1`, divide **both** sides by it.
- Put `left` and `right` on SmartDashboard, before and after the fix.
- Hold **W** and **L** together. Why is dividing both sides better than chopping each one down to 1 with `Math.min`? Answer in a comment.

---

## 📜 Part 3 – Code Archaeology (2 pts, optional)

> *Optional: skip this part if you're short on time.* Last season's code is [`Hudson-Robotics/OG-Code-2026`](https://github.com/Hudson-Robotics/OG-Code-2026), branch **`Pre-DCMP-Flywheel`**.

**Basic (1 pt)**  
- Find `isAtTargetVelocity()` in `CANFuelSubsystem.java` and compare it with your `atSpeed`. What's the same, what's different, and where does its tolerance number come from?

**Extra (1 pt)**  
- Open commit [`9dbcb0e` "Treating Shooter as flywheel"](https://github.com/Hudson-Robotics/OG-Code-2026/commit/9dbcb0e). Before it, the robot shot at a fixed **power**. After it, the robot asked the motors for a **speed**. Using what you found while hunting for the right power in the basic half, explain why the team switched right before the district championship.

---

## 🏆 Total Points
- **Max:** 6 pts  
  - Java‑Only: 2 pts  
  - Robot Code: 2 pts  
  - Code Archaeology: 2 pts *(optional)*

---

<!-- Drafting notes from the transcript draft. Hidden from students.
Ideas:
- Hypotenuse exercise: practice with `Math.sqrt` and `Math.pow`.  
- Circle/sphere exercise: circumference, area, volume using `Math.PI`.  
- Robot code: joystick magnitude with Pythagorean theorem.  
- Archaeology: replace hard‑coded constants with `Math.PI` or `Math.E`.  
- Segue: Next lesson could cover loops to repeat calculations.  
-->
