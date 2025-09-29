# 🖥️ Lesson 09 – Nested If Statements in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🐝

---

## 🎯 Overview
**Keywords:** Java, Nested If, Boolean, Discounts, Conditions, Augmented Assignment, printf  
Learn to:
- Write `if` statements inside other `if` statements  
- Use Boolean variables to control program flow  
- Apply multiple conditions to calculate different outcomes  
- Format output with `printf` for cleaner results  
- Understand when nested logic is more effective than flat `if/else` chains  

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
- Create two Boolean variables:  
  - `isStudent`  
  - `isSenior`  
- Create a `double price = 9.99;`  
- Write an `if` statement:  
  - If student → apply 10% discount (`price *= 0.9`)  
  - Else → full price  
- Print result with `printf` to two decimal places.  

**Extra (1 pt)**  
- Add nested conditions:  
  - If student **and** senior → 30% discount (`price *= 0.7`)  
  - If only senior → 20% discount (`price *= 0.8`)  
  - If neither → full price  
- Print messages for each case (student discount, senior discount, both, or none).  

---

## 🤖 Part 2 – Robot Code (2 pts)

**Basic (1 pt)**  
- Use nested `if` statements to check robot conditions.  
- Example:  
  - If `batteryLow` → reduce motor speed.  
  - Inside that, if also `isClimbing` → reduce even further.  

**Extra (1 pt)**  
- Combine multiple conditions for safety:  
  - If `isArmExtended` and `isMovingFast` → trigger a warning.  
  - Else if `isArmExtended` but not moving fast → allow normal operation.  
- Print results to **SmartDashboard**.  

---

## 📜 Part 3 – Code Archaeology (2 pts)

**Basic (1 pt)**  
- Find a nested `if` in last year’s robot code.  
- Explain what it checks and why nesting was necessary.  

**Extra (1 pt)**  
- Suggest improvements:  
  - Could the nested logic be simplified with `&&` or `||` operators?  
  - Could readability improve by restructuring?  
- Or write pseudo‑code for a nested safety check:  
  [CODE BLOCK]java
  if (isShooterActive) {
      if (ballDetected) {
          fire();
      } else {
          stopShooter();
      }
  } else {
      idle();
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
- Movie ticket discount example → relatable intro.  
- Robot code: nested safety checks (battery, arm, shooter).  
- Archaeology: simplify nested ifs with logical operators.  
- Segue: Next lesson could cover logical operators (`&&`, `||`, `!`) as an alternative to nesting.  
[CODE BLOCK]
