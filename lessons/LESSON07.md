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
- Print `Math.PI` and `Math.E`.  
- Demonstrate `Math.pow`, `Math.abs`, and `Math.sqrt`.  
- Show rounding with `Math.round`, `Math.ceil`, and `Math.floor`.  
- Compare two numbers with `Math.max` and `Math.min`.  

**Extra (1 pt)**  
- Build a shape area & perimeter calculator:
  - Prompt the user to pick a shape: **triangle**, **circle**, or **square**.
  - Ask for the necessary inputs (side length, radius, etc.).
  - Calculate and print the **area** and **perimeter** (or circumference for circle):
    - **Triangle:** area = `(base × height) / 2`, perimeter = `side1 + side2 + side3`
    - **Circle:** area = `Math.PI × radius²`, circumference = `2 × Math.PI × radius`
    - **Square:** area = `side²`, perimeter = `4 × side`
  - Use `Math.pow()` and `Math.PI` appropriately.
  - Format output nicely (e.g., round to 2 decimal places).  

---

## 🤖 Part 2 – Robot Code (2 pts)

**Basic (1 pt)**  
- Read joystick input from an XboxController.  
- Use `Math.max()` and `Math.min()` to **clamp** the joystick value between safe limits (e.g., -1.0 to 1.0).  
  - Example: `clampedSpeed = Math.max(-1.0, Math.min(1.0, joystickValue))`  
- Send the clamped value to a motor.  
- Print both raw and clamped values to **SmartDashboard** to see the difference.  
- **Real-world reason:** Protects motor controllers from out-of-range values.  

**Extra (1 pt)**  
- Calculate **distance to AprilTag** using Limelight data and Pythagorean theorem:
  - Get Limelight `tx` (horizontal offset) and `ty` (vertical offset).
  - Use the formula: `distance = sqrt(tx² + ty²)` with `Math.sqrt()` and `Math.pow()`.
  - Calculate the **angle** to the tag using `Math.atan2(ty, tx)` (in radians).
  - Convert angle to degrees if desired: `degrees = radians × 180 / Math.PI`.
  - Use distance to drive toward the tag (closer = faster, far = slower).
  - Use angle to steer the robot to face the tag.
  - Print distance, angle (degrees), and motor commands to **SmartDashboard** for debugging.  

---

## 📜 Part 3 – Code Archaeology (2 pts)

**Basic (1 pt)**  
- Find a math method used in last year’s robot code (e.g., `Math.max` to cap motor output).  
- Explain what it does and why it’s needed.  

**Extra (1 pt)**  
- Suggest improvements:  
  - Replace manual formulas with built‑in math methods for clarity.  
  - Use `Math.min`/`Math.max` to enforce safe ranges.  
- Or write pseudo‑code for a geometry‑based feature:  
  [CODE BLOCK]java
  double dx = targetX - robotX;
  double dy = targetY - robotY;
  double angle = Math.atan2(dy, dx);
  [CODE BLOCK]  

---

## 🏆 Total Points
- **Max:** 6 pts  
  - Java‑Only: 2 pts  
  - Robot Code: 2 pts  
  - Code Archaeology: 2 pts

---

[CODE BLOCK]LOG
Ideas:
- Hypotenuse exercise: practice with `Math.sqrt` and `Math.pow`.  
- Circle/sphere exercise: circumference, area, volume using `Math.PI`.  
- Robot code: joystick magnitude with Pythagorean theorem.  
- Archaeology: replace hard‑coded constants with `Math.PI` or `Math.E`.  
- Segue: Next lesson could cover loops to repeat calculations.  
[CODE BLOCK]
