# 🖥️ Lesson 15 – While Loops in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🐝

---

## 🎯 Overview
**Keywords:** Java, While Loop, Do‑While Loop, Infinite Loop, User Input, Validation, Scanner  
Learn to:
- Use `while` loops to repeat code while a condition remains true  
- Prevent invalid input by re‑prompting users  
- Understand infinite loops and how to avoid them  
- Use `do‑while` loops to guarantee code runs at least once  
- Apply loops to real‑world scenarios like games and input validation  

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
- Create a `Scanner`.  
- Prompt the user to enter their name.  
- Use a `while` loop with `.isEmpty()` to keep asking until they type something.  
- Print `"Hello, <name>"` once valid input is given.  

**Extra (1 pt)**  
- Demonstrate an infinite loop example (`while (1 == 1)`) and explain why it never ends.  
- Create a simple game loop:  
  - Keep printing `"You are playing a game. Press Q to quit."`  
  - Exit only when the user types `"Q"`.  
- Show input validation with age:  
  - Keep asking until the user enters a non‑negative number.  

---

## 🤖 Part 2 – Robot Code (2 pts)

**Basic (1 pt)**  
- Use a `while` loop to keep checking a sensor until a condition is met.  
- Example: while a limit switch is not pressed, keep moving the arm.  

**Extra (1 pt)**  
- Use a `do‑while` loop to ensure a motor runs at least once before checking a condition.  
- Example: run intake until a ball is detected, but guarantee one cycle of motor spin.  
- Print results to **SmartDashboard**.  

---

## 📜 Part 3 – Code Archaeology (2 pts)

**Basic (1 pt)**  
- Find a `while` loop in last year’s robot code.  
- Explain what condition it checks and why it repeats.  

**Extra (1 pt)**  
- Suggest improvements:  
  - Replace nested `if` checks with a `while` loop for repeated validation.  
  - Use `do‑while` when code must run at least once.  
- Or write pseudo‑code for sensor polling:  
  [CODE BLOCK]java
  do {
      readSensor();
      adjustMotor();
  } while (!targetReached);
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
- Show difference between `while` and `do‑while` with input validation.  
- Robot code: loop until a sensor condition is satisfied.  
- Archaeology: check for infinite loops or polling loops in old code.  
- Segue: Next lesson could cover **for loops** for counting iterations.  
[CODE BLOCK]
