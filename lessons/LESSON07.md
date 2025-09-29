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
- Write a program that asks the user for two numbers.  
- Compute and print:  
  - Power (first number raised to the second)  
  - Absolute difference  
  - Rounded results (nearest, up, down)  

---

## 🤖 Part 2 – Robot Code (2 pts)

**Basic (1 pt)**  
- Use `Math.abs()` to ensure motor speed is always positive before sending to the motor controller.  

**Extra (1 pt)**  
- Use `Math.sqrt()` and `Math.pow()` to calculate distance from joystick X/Y input (Pythagorean theorem).  
- Example: `distance = sqrt(x^2 + y^2)` to determine joystick magnitude.  
- Display results on **SmartDashboard**.  

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
