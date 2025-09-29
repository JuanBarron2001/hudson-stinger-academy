# 🖥️ Lesson 12 – The Ternary Operator in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🐝

---

## 🎯 Overview
**Keywords:** Java, Ternary Operator, Conditional Operator, If‑Else Alternative, Modulus, Time of Day, Tax Rate  
Learn to:
- Use the ternary operator (`? :`) as a shorthand for `if/else`  
- Assign values based on conditions in a single line  
- Check pass/fail conditions with scores  
- Determine even/odd numbers using modulus  
- Convert military time to AM/PM  
- Apply conditional logic to calculate tax rates  

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
- Create an integer `score = 70;`  
- Use the ternary operator to assign `"Pass"` or `"Fail"` to a string variable.  
- Print the result.  

**Extra (1 pt)**  
- Write a program that:  
  - Checks if a number is even or odd using `% 2 == 0 ? "Even" : "Odd"`.  
  - Converts military time (e.g., `13`) into `"AM"` or `"PM"`.  
  - Calculates tax rate:  
    - If income ≥ 40,000 → `0.25`  
    - Else → `0.15`  

---

## 🤖 Part 2 – Robot Code (2 pts)

**Basic (1 pt)**  
- Use the ternary operator to set motor speed:  
  - If joystick input > 0.1 → use joystick value.  
  - Else → `0`.  

**Extra (1 pt)**  
- Apply ternary operator for robot mode:  
  - If `isAutonomous` → `"AUTO"`  
  - Else → `"TELEOP"`  
- Display results on **SmartDashboard**.  

---

## 📜 Part 3 – Code Archaeology (2 pts)

**Basic (1 pt)**  
- Find an `if/else` in last year’s robot code that could be simplified with a ternary operator.  
- Explain what it does.  

**Extra (1 pt)**  
- Suggest improvements:  
  - Replace verbose `if/else` with ternary for readability.  
  - Example pseudo‑code:  
    [CODE BLOCK]java
    String status = (batteryLevel < 20) ? "LOW" : "OK";
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
- Use ternary operator for quick pass/fail checks.  
- Robot code: joystick deadband logic in one line.  
- Archaeology: simplify nested `if/else` into ternary for cleaner code.  
- Segue: Next lesson could cover **switch statements** as another branching tool.  
[CODE BLOCK]
