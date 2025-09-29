# 🖥️ Lesson 18 – Nested Loops in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🐝

---

## 🎯 Overview
**Keywords:** Java, Nested Loops, For Loop, While Loop, Matrix, Rows, Columns, Scanner  
Learn to:
- Understand what a nested loop is (a loop inside another loop)  
- Use nested loops to print repeated patterns or matrices  
- Differentiate between outer and inner loop responsibilities  
- Accept user input for rows, columns, and symbols  
- Build a mini‑project: a matrix generator  

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
- Write a `for` loop that prints numbers `1–9` on the same line.  
- Add a space between each number.  

**Extra (1 pt)**  
- Use a nested loop to print the numbers `1–9` three times, each on a new line.  
- Follow naming conventions: outer loop uses `i`, inner loop uses `j`.  

---

## 🤖 Part 2 – Robot Code (2 pts)

**Basic (1 pt)**  
- Use a nested loop to simulate scanning a grid of sensors (rows × columns).  
- Print each sensor’s index as you iterate.  

**Extra (1 pt)**  
- Accept user input for rows and columns.  
- Use nested loops to display a matrix of sensor states (e.g., `"OK"` or `"FAIL"`).  
- Print results to **SmartDashboard**.  

---

## 📜 Part 3 – Code Archaeology (2 pts)

**Basic (1 pt)**  
- Find a nested loop in last year’s robot code (e.g., iterating through motor controllers or joystick mappings).  
- Explain what the outer loop and inner loop each controlled.  

**Extra (1 pt)**  
- Suggest improvements:  
  - Replace repeated code with a nested loop.  
  - Use better variable names (`i`, `j`) for clarity.  
- Or write pseudo‑code for a matrix generator:  
  [CODE BLOCK]java
  for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
          System.out.print(symbol);
      }
      System.out.println();
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
- Show difference between outer loop (rows) and inner loop (columns).  
- Robot code: nested loops for grid scanning or multiple motor tests.  
- Archaeology: replace copy‑pasted code with nested loops.  
- Segue: Next lesson could cover **arrays** (1D and 2D) since nested loops pair well with them.  
[CODE BLOCK]
