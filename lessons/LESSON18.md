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

> **Not written yet.** Lesson 18 is **optional** this offseason, so its robot half was never rewritten for the 2026 robot. What used to be here was a 2025 draft describing hardware this robot doesn't have, so it has been taken out rather than left to send you down a dead end. **Skip Parts 2 and 3 for now.**
>
> Ahead of the pace and want the points anyway? Ask a mentor. Writing this half with you is a good use of a meeting.

---

## 📜 Part 3 – Code Archaeology (2 pts, optional)

> Not written yet. See Part 2.

---

## 🏆 Total Points
- **Max right now:** 2 pts  
  - Java‑Only: 2 pts  
  - Robot Code and Code Archaeology: they come back if this lesson gets a 2026 robot half

---

<!-- Drafting notes from the transcript draft. Hidden from students.
Ideas:
- Show difference between outer loop (rows) and inner loop (columns).  
- Robot code: nested loops for grid scanning or multiple motor tests.  
- Archaeology: replace copy‑pasted code with nested loops.  
- Segue: Next lesson could cover **arrays** (1D and 2D) since nested loops pair well with them.  
-->
