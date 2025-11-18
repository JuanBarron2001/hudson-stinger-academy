# 🖥️ Lesson 05 – If Statements in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🐝

---

## 🎯 Overview
**Keywords:** Java, If Statements, Boolean, Else, Else If, Comparison Operators, Scanner, Strings, Conditions  
Learn to:
- Write and structure `if`, `else if`, and `else` statements  
- Use Boolean variables directly in conditions  
- Compare values with relational and equality operators (`>=`, `==`, etc.)  
- Prompt the user for input with `Scanner` and branch logic accordingly  
- Handle strings with `.isEmpty()` and Boolean input with `nextBoolean()`  
- Understand order of conditions and why placement matters  

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
- Create an integer variable `age`.  
- Write an `if` statement that checks if `age >= 18`.  
- Print `"You are an adult"` if true.  
- Add an `else` clause to print `"You are a child"`.  

**Extra (1 pt)**  
- Expand with multiple conditions:  
  - `age < 0` → `"You haven’t been born yet"`  
  - `age == 0` → `"You are a baby"`  
  - `age >= 65` → `"You are a senior"`  
- Prompt the user for their age using `Scanner` and test the branching logic.  

---

## 🤖 Part 2 – Robot Code (2 pts)

**Basic (1 pt)**  
- Read joystick input from an XboxController.  
- Use `if` statements to implement **deadband logic** (ignore small stick movements).  
  - If joystick input is very small (e.g., `< 0.1`), set motor speed to `0`.  
  - Else, set motor speed to the joystick value.  
- Print joystick value and motor command to **SmartDashboard** for debugging.  
- **Real-world reason:** Joysticks have drift and noise; deadband keeps the robot from creeping unintentionally.

**Extra (1 pt)**  
- Expand deadband logic with multiple thresholds:  
  - If input is very small (e.g., `< 0.1`) → motor speed = `0` (deadband).  
  - Else if input is high (e.g., `> 0.8`) → cap motor speed at safe maximum (e.g., `0.8`).  
  - Else → set motor speed to joystick value.  
- **Challenge:** Use Limelight data (`tx` offset) instead of joystick to demonstrate `if` logic in auto-targeting:  
  - If `tx < -5` → turn left (negative motor speed).  
  - Else if `tx > 5` → turn right (positive motor speed).  
  - Else → stop turning (motor speed = `0`).  
- Print target offset and motor command to **SmartDashboard**.

---

## 📜 Part 3 – Code Archaeology (2 pts)

**Basic (1 pt)**  
- Find an `if` statement in last year’s robot code.  
- Explain what condition it checks and why it’s important (e.g., safety, limits, mode switching).  

**Extra (1 pt)**  
- Suggest improvements:  
  - Could the conditions be reordered for clarity?  
  - Could repeated checks be simplified with Boolean variables?  
- Or write pseudo‑code for a new feature, e.g.:  
  [CODE BLOCK]java
  if (distanceToGoal < 2) {
      shootBall();
  } else if (distanceToGoal < 5) {
      adjustShooterAngle();
  } else {
      driveCloser();
  }
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
- Use joystick deadband logic as a real-world “if statement” example.
- Archaeology: check for safety interlocks (e.g., “if limit switch is pressed, stop motor”).
- Segue: This lesson builds naturally from arithmetic (Lesson 04) → now we make decisions with those values.
- Future: Combine if statements with loops for Lesson 06.
[CODE BLOCK]
