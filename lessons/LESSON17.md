# 🖥️ Lesson 17 – Break & Continue in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🐝

---

## 🎯 Overview
**Keywords:** Java, Loops, Break, Continue, For Loop, Iteration Control  
Learn to:
- Use `break` to exit a loop early  
- Use `continue` to skip the current iteration but keep looping  
- Understand the difference between stopping vs. skipping  
- Apply these keywords in practical loop scenarios  

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
- Write a `for` loop that prints numbers `0–9`.  
- Add an `if` statement:  
  - If `i == 5`, use `break` to stop the loop.  
- Observe that the loop ends at 4.  

**Extra (1 pt)**  
- Replace `break` with `continue`.  
- Observe that the loop skips printing `5` but continues with `6–9`.  
- Print results to show the difference between the two.  

---

## 🤖 Part 2 – Robot Code (2 pts)

**Basic (1 pt)**  
- Use `break` in a loop that checks sensors:  
  - Example: stop looping once a limit switch is pressed.  

**Extra (1 pt)**  
- Use `continue` to skip invalid sensor readings:  
  - Example: if a sensor returns `-1`, skip that iteration and move on.  
- Print results to **SmartDashboard** for debugging.  

---

## 📜 Part 3 – Code Archaeology (2 pts)

**Basic (1 pt)**  
- Find a loop in last year’s robot code where `break` was used to stop early.  
- Explain why it was necessary (e.g., safety, efficiency).  

**Extra (1 pt)**  
- Suggest improvements:  
  - Replace nested `if` checks with `continue` for cleaner code.  
  - Use `break` to exit once a condition is satisfied instead of checking repeatedly.  
- Or write pseudo‑code for motor testing:  
  [CODE BLOCK]java
  for (Motor m : motors) {
      if (!m.isConnected()) {
          continue; // skip disconnected motors
      }
      testMotor(m);
      if (m.hasError()) {
          break; // stop testing if a failure occurs
      }
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
- Show difference between `break` (stop) and `continue` (skip).  
- Robot code: skip bad sensor values with `continue`.  
- Archaeology: simplify loops by replacing nested checks with `continue`.  
- Segue: Next lesson could cover **nested loops** for patterns and grids.  
[CODE BLOCK]
