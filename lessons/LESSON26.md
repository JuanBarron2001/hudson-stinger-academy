# 🖥️ Lesson 26 – 2D Arrays in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🐝

---

## 🎯 Overview
**Keywords:** Java, 2D Arrays, Multi‑Dimensional Arrays, Nested Loops, Matrix, Rows, Columns  
Learn to:
- Understand that a **2D array is an array of arrays**  
- Initialize and display 2D arrays  
- Access and modify elements using two indices (row, column)  
- Use nested loops to traverse a 2D array  
- Build a mini‑project: a telephone keypad grid  
- Build the 2026 robot's distance-to-speed shot table  

---

## ⏱️ Progress Tracking

### 📊 For the Marathon Watchers  
If you’re following the **full 12‑hour compilation** and want to see how far you’ve made it through the *entire* course:  
- **Start Time in 12‑Hour Video:** [05:34:36](https://www.youtube.com/watch?v=xTtL8E4LzTQ&t=20076s)  
- **Full Course (12h video):** [Watch Compilation](https://www.youtube.com/watch?v=xTtL8E4LzTQ)

---

### 🎯 For the Quick‑Hit Learners  
If you just want **this lesson only** and to be done with it — no scrubbing through hours of footage:  
- **Lesson Playlist:** [Java tutorial for beginners (2025) ☕](https://www.youtube.com/playlist?list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc)  
- **This Lesson Only:** [Watch Lesson 26](https://www.youtube.com/watch?v=Qf3Nczxm2AY&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=35) (Learn Java 2D arrays in 9 minutes! ⬜, 9:38)

---

## 💻 Part 1 – Java‑Only (2 pts)

**Basic (1 pt)**  
- A 2D array is an array of arrays, and each row is its own array. Create `String[][] groceries` with three rows: `Apple`, `Orange`, `Banana`; then `Potato`, `Onion`, `Carrot`; then `Chicken`, `Pork`, `Beef`, `Fish`. The rows don't have to be the same length.  
- Print it as a grid with nested enhanced `for` loops. The outer loop takes one row at a time (`String[] foods : groceries`). The inner loop prints each food in that row followed by a space, and then you print a new line.  

Expected output:  

```
Apple Orange Banana 
Potato Onion Carrot 
Chicken Pork Beef Fish 
```

**Extra (1 pt)**  
- Change three elements with two indices, `[row][column]`: `Apple` to `Pineapple`, `Potato` to `Celery`, and `Pork` to `Eggs`. Work out each pair of indices yourself, then print the grid again to check.  
- **Telephone keypad**, the video's mini‑project. Build a `char[][] telephone` with four rows: `'1' '2' '3'`, `'4' '5' '6'`, `'7' '8' '9'` and `'*' '0' '#'` (single quotes, because they're `char`s). Print it as a grid with nested enhanced `for` loops: the outer loop's type is `char[]` (one row), the inner loop's is `char`.  

Expected output:  

```
Pineapple Orange Banana 
Celery Onion Carrot 
Chicken Eggs Beef Fish 
1 2 3 
4 5 6 
7 8 9 
* 0 # 
```

---

## 🤖 Part 2 – Robot Code: the 2026 Robot (2 pts)

Your code goes in `robot-code/command-based-bot-2026/src/main/java/frc/lesson/lesson26/basic/Lesson26.java` (and `extra/Lesson26.java`). The task list is at the top of each file.  
Run it in the simulator the way you did in [Lesson 00](./LESSON00.md). CAN IDs, inversions and buttons are in [ROBOT.md](../robot-code/command-based-bot-2026/ROBOT.md).

**Basic (1 pt)**: a shot table  
- A `double[][]` field where each row is `{distance in inches, roller speed in RPS}`: `{30, -60}`, `{75, -75}`, `{120, -90}`.
- Read the distance from SmartDashboard: `putNumber("Distance (in)", 60)` in `setup()`, and `getNumber` in `execute()`. You can change it in the simulator's NetworkTables window.
- Loop over the rows, find the one whose distance is **closest** to yours, and put its speed and its row number on SmartDashboard.
- Try 0, 50, 53, 100 and 500 inches. Which answers look wrong for a real shot?

**Extra (1 pt)**: blend between rows  
- Find the two rows your distance falls **between**. Compute `fraction = (distance - low) / (high - low)`, then `speed = lowSpeed + fraction * (highSpeed - lowSpeed)`.
- Below the first row, use the first row's speed; above the last row, use the last row's speed.
- Try 30, 52.5, 75, 100 and 500.
- *Bonus:* while **A** is held, spin the rollers toward that speed (in the simulator, roughly `power = speed / 97`) and show whether they're at speed.

---

## 📜 Part 3 – Code Archaeology (2 pts, optional)

> *Optional: skip this part if you're short on time.* Last season's code is [`Hudson-Robotics/OG-Code-2026`](https://github.com/Hudson-Robotics/OG-Code-2026), branch **`Pre-DCMP-Flywheel`**.

**Basic (1 pt)**  
- `Constants.java` builds `DISTANCE_TO_RPS_MAP` from just two points: 30 in → -60 and 120 in → -90. Using your extra code, what speed would the robot pick at 75 inches? At 200?

**Extra (1 pt)**  
- `InterpolatingDoubleTreeMap` does what you wrote by hand. With only two calibration points, what is the team assuming about how shot speed changes with distance? How would you collect better points? *(Hint: lesson 09's tuning idea and a tape measure.)*

---

## 🏆 Total Points
- **Max:** 6 pts  
  - Java‑Only: 2 pts  
  - Robot Code: 2 pts  
  - Code Archaeology: 2 pts *(optional)*

---

<!-- Drafting notes from the transcript draft. Hidden from students.
Ideas:
- Show difference between 1D arrays and 2D arrays.  
- Robot code: 2D arrays for grid maps or path planning.  
- Archaeology: replace multiple arrays with one 2D structure.  
- Segue: Next lesson could cover **ArrayLists** or **multi‑dimensional data structures**.  
-->
