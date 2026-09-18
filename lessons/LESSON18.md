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
If you’re following the **full 12‑hour compilation** and want to see how far you’ve made it through the *entire* course:  
- **Start Time in 12‑Hour Video:** [03:55:45](https://www.youtube.com/watch?v=xTtL8E4LzTQ&t=14145s)  
- **Full Course (12h video):** [Watch Compilation](https://www.youtube.com/watch?v=xTtL8E4LzTQ)

---

### 🎯 For the Quick‑Hit Learners  
If you just want **this lesson only** and to be done with it — no scrubbing through hours of footage:  
- **Lesson Playlist:** [Java tutorial for beginners (2025) ☕](https://www.youtube.com/playlist?list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc)  
- **This Lesson Only:** [Watch Lesson 18](https://www.youtube.com/watch?v=sd4x2QG2K6U&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=25) (Learn Java nested loops in 8 minutes! ➿, 8:44)

---

## 💻 Part 1 – Java‑Only (2 pts)

**Basic (1 pt)**  
- Write a `for` loop that prints the numbers `1–9` on the same line, with a space after each (`print`, not `println`).  
- Now put that loop **inside** another `for` loop that runs 3 times, and print an empty `println()` after the inner loop, so you get 3 rows of `1–9`.  
- Follow the naming convention: the outer loop uses `i`, the inner loop uses `j`. Try naming both `i`. What does Java say?  

**Extra (1 pt)**  
- The video's mini‑project, a **symbol grid**:  
  - Use a `Scanner` to ask for the number of **rows**, the number of **columns**, and a **symbol**. Read the symbol as a `char` with `scanner.next().charAt(0)`.  
  - The **outer** loop runs once per row. The **inner** loop prints the symbol once per column.  
  - After each row, print a new line.  
  - Example: 3 rows, 6 columns and `@` print three lines of `@@@@@@`.  

---

## 🤖 Part 2 – Robot Code (2 pts)

**Basic (1 pt)**  
- Use a nested loop to simulate scanning a grid of sensors (rows × columns).  
- Print each sensor’s index as you iterate.  

**Extra (1 pt)**  
- Pick the number of rows and columns. (Robot code has no keyboard to type them into.)  
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
  ```java
  for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
          System.out.print(symbol);
      }
      System.out.println();
  }
  ```

---

## 🏆 Total Points
- **Max:** 6 pts  
  - Java‑Only: 2 pts  
  - Robot Code: 2 pts  
  - Code Archaeology: 2 pts

---

<!-- Drafting notes from the transcript draft. Hidden from students.
Ideas:
- Show difference between outer loop (rows) and inner loop (columns).  
- Robot code: nested loops for grid scanning or multiple motor tests.  
- Archaeology: replace copy‑pasted code with nested loops.  
- Segue: Next lesson could cover **arrays** (1D and 2D) since nested loops pair well with them.  
-->
