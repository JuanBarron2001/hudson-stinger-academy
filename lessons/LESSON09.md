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
- Build a **movie ticket discount calculator** with nested logic:
  - Create a `double basePrice = 15.00;`
  - Create a Boolean variable `isStudent`
  - Write a nested `if` statement:
    - If `isStudent` → check nested condition:
      - If also `isSenior` → apply 30% discount (`price *= 0.7`)
      - Else → apply 15% discount (`price *= 0.85`)
    - Else → full price (no discount)
  - Print the ticket type and final price with `printf` to 2 decimal places
  - Example output: `"Student+Senior Ticket: $10.50"` or `"Student Ticket: $12.75"` or `"Regular Ticket: $15.00"`

**Extra (1 pt)**  
- Expand with user input and more complex nesting:
  - Use `Scanner` to prompt for: student status (yes/no), senior status (yes/no), membership tier (BRONZE/SILVER/GOLD/NONE)
  - Build nested logic:
    - If student:
      - If also senior:
        - If GOLD member → 40% discount
        - Else if SILVER member → 35% discount
        - Else → 30% discount
      - Else (student, not senior):
        - If GOLD member → 25% discount
        - Else if SILVER member → 20% discount
        - Else → 15% discount
    - Else (not student):
      - If senior:
        - If any member tier → 25% discount
        - Else → 20% discount
      - Else → full price
  - Print a clear receipt showing discount reason and final price  

---

## 🤖 Part 2 – Robot Code (2 pts)

**Basic (1 pt)**  
- Use nested `if` statements to implement a **button-triggered targeting system**:
  - Get alliance color from DriverStation (RED or BLUE)
  - Get button press state from XboxController (e.g., A button)
  - Nested logic:
    - If alliance is RED:
      - If button is pressed → drive toward AprilTag
      - Else → stop driving
    - Else (alliance is BLUE):
      - If button is pressed → drive away from AprilTag
      - Else → stop driving
  - Print the alliance color, button state, and action to **SmartDashboard**

**Extra (1 pt)**  
- Expand with **multi-level nesting** for smarter strategy:
  - Get alliance color, button press, and battery voltage (or distance to tag)
  - Nested logic:
    - If alliance is RED:
      - If button is pressed:
        - If battery is good (> 11.5V) → drive toward tag at full speed
        - Else → drive toward tag at reduced speed (50%)
      - Else → stop
    - Else (alliance is BLUE):
      - If button is pressed:
        - If distance to tag is close (< 2 meters) → stop (don't go closer)
        - Else → drive toward tag
      - Else → stop
  - Print decision logic to **SmartDashboard** so you can debug what the robot decided (useful during matches!)
  - Example: `"RED + Button + LowBattery → Slow Track"` or `"BLUE + Button + CloseToTag → Stop"`  

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
