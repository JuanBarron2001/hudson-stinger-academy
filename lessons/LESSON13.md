# 🖥️ Lesson 13 – Enhanced Switches in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🐝

---

## 🎯 Overview
**Keywords:** Java, Enhanced Switch, Switch Expression, Case Labels, Default, Java 14, If‑Else Alternative  
Learn to:
- Replace long chains of `if/else if` with cleaner `switch` logic  
- Use the **enhanced switch** syntax with `->` (arrow operator)  
- Group multiple cases together with commas  
- Add a `default` case for unmatched values  
- Accept user input and evaluate it with a switch  
- Understand why enhanced switches are preferred over traditional switches  

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
- Create a `String day = "Friday";`  
- Write an enhanced `switch` that prints:  
  - `"It is a weekday"` for Monday–Friday  
  - `"It is the weekend"` for Saturday–Sunday  
  - `"<day> is not a day"` for anything else  

**Extra (1 pt)**  
- Accept user input with `Scanner` for the day of the week.  
- Use the enhanced switch to evaluate the input.  
- Consolidate multiple cases with commas (e.g., `case "Monday", "Tuesday", ... ->`).  

---

## 🤖 Part 2 – Robot Code (2 pts)

**Basic (1 pt)**  
- Use an enhanced switch to handle robot modes:  
  - `"AUTO"` → print `"Autonomous mode"`  
  - `"TELEOP"` → print `"Teleoperated mode"`  
  - `"TEST"` → print `"Test mode"`  
  - Default → `"Unknown mode"`  

**Extra (1 pt)**  
- Accept a string command (e.g., `"drive"`, `"shoot"`, `"climb"`).  
- Use an enhanced switch to call the correct robot action.  
- Print results to **SmartDashboard**.  

---

## 📜 Part 3 – Code Archaeology (2 pts)

**Basic (1 pt)**  
- Find a section of last year’s robot code with many `if/else if` statements.  
- Explain how it could be simplified with an enhanced switch.  

**Extra (1 pt)**  
- Suggest improvements:  
  - Group repeated cases into one branch.  
  - Add a `default` case for unexpected inputs.  
- Or write pseudo‑code for robot state handling:  
  [CODE BLOCK]java
  switch (robotState) {
      case "IDLE"      -> stopMotors();
      case "DRIVING"   -> driveForward();
      case "SHOOTING"  -> fireShooter();
      default          -> System.out.println("Unknown state");
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
- Day‑of‑week example → relatable intro.  
- Robot code: enhanced switch for modes and commands.  
- Archaeology: replace long `if/else` chains with grouped cases.  
- Segue: Next lesson could cover **switch with yield** (returning values).  
[CODE BLOCK]
