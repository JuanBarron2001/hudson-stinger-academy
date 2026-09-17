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
- **Start Time in 12‑Hour Video:** [blank]  
- **Full Course (12h video):** [link here]

---

### 🎯 For the Quick‑Hit Learners  
- **Lesson Playlist:** [link here]  
- **This Lesson Only:** [link here]

---

## 💻 Part 1 – Java‑Only (2 pts)

**Basic (1 pt)**  
- Create a 2D array of groceries:  

```java
String[][] groceries = {
    {"Apple", "Orange", "Banana"},
    {"Potato", "Onion", "Carrot"},
    {"Chicken", "Pork", "Beef", "Fish"}
};

// Nested loop to print
for (String[] foods : groceries) {
    for (String food : foods) {
        System.out.print(food + " ");
    }
    System.out.println();
}
```

**Extra (1 pt)**  
- Modify elements using two indices:  

```java
groceries[0][0] = "Pineapple"; // replaces Apple
groceries[1][0] = "Celery";    // replaces Potato
groceries[2][1] = "Eggs";      // replaces Pork
```

---

## 🤖 Part 2 – Robot Code: the 2026 Robot (2 pts)

Your code goes in `robot-code/command-based-bot-2026/src/main/java/frc/lesson/lesson26/basic/Lesson26.java` (and `extra/Lesson26.java`). The task list is at the top of each file.  
Run it in the simulator the way you did in [Lesson 00](./LESSON00.md). CAN IDs, inversions and buttons are in [ROBOT.md](../robot-code/command-based-bot-2026/ROBOT.md).

**Basic (1 pt)**: a shot table  
- A `double[][]` field where each row is `{distance in inches, roller speed in RPS}`: `{30, -60}`, `{75, -75}`, `{120, -90}`.
- Read the distance from SmartDashboard: `putNumber("Distance (in)", 60)` in `setup()`, and `getNumber` in `execute()`. You can change it in the simulator's NetworkTables window.
- Loop over the rows, find the one whose distance is **closest** to yours, and put its speed on SmartDashboard.
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

[CODE BLOCK]LOG
Ideas:
- Show difference between 1D arrays and 2D arrays.  
- Robot code: 2D arrays for grid maps or path planning.  
- Archaeology: replace multiple arrays with one 2D structure.  
- Segue: Next lesson could cover **ArrayLists** or **multi‑dimensional data structures**.  
[CODE BLOCK]
