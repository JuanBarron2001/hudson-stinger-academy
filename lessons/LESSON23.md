# 🖥️ Lesson 23 – User Input into Arrays in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🐝

---

## 🎯 Overview
**Keywords:** Java, Arrays, User Input, Scanner, For Loop, Enhanced For Loop, Input Buffer  
Learn to:
- Declare and instantiate arrays with a fixed size  
- Understand why arrays need a size before storing values  
- Fill arrays with user input using `Scanner`  
- Iterate through arrays with loops to display elements  
- Dynamically set array size based on user input  

---

## ⏱️ Progress Tracking

### 📊 For the Marathon Watchers  
If you’re following the **full 12‑hour compilation** and want to see how far you’ve made it through the *entire* course:  
- **Start Time in 12‑Hour Video:** [05:12:35](https://www.youtube.com/watch?v=xTtL8E4LzTQ&t=18755s)  
- **Full Course (12h video):** [Watch Compilation](https://www.youtube.com/watch?v=xTtL8E4LzTQ)

---

### 🎯 For the Quick‑Hit Learners  
If you just want **this lesson only** and to be done with it — no scrubbing through hours of footage:  
- **Lesson Playlist:** [Java tutorial for beginners (2025) ☕](https://www.youtube.com/playlist?list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc)  
- **This Lesson Only:** [Watch Lesson 23](https://www.youtube.com/watch?v=ah5bAnGpmKY&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=32) (Enter USER INPUT into an ARRAY! ➡️, 8:04)

---

## 💻 Part 1 – Java‑Only (2 pts)

**Basic (1 pt)**  
- First, the video's warning: create `String[] foods = {};`, print `foods.length`, then try `foods[0] = "pizza";`. Why does it fail? An array needs its size **before** you store anything.  
- Now create it properly: `String[] foods = new String[3];`  
- Use a `for` loop to prompt the user three times:  
  - `"Enter a food:"`  
  - Store each input into the array.  
- Print all elements using an **enhanced for loop**.  

**Extra (1 pt)**  
- Ask the user how many foods they want to enter.  
- Use that number to set the array size dynamically.  
- Clear the input buffer after `nextInt()` with `scanner.nextLine()`.  
- Fill the array with user input and print all elements.  

---

## 🤖 Part 2 – Robot Code (2 pts)

> **Not written yet.** Lesson 23 is **optional** this offseason, so its robot half was never rewritten for the 2026 robot. What used to be here was a 2025 draft describing hardware this robot doesn't have, so it has been taken out rather than left to send you down a dead end. **Skip Parts 2 and 3 for now.**
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
- Show difference between fixed-size arrays and dynamic size from user input.  
- Robot code: arrays for motor speeds or sensor names.  
- Archaeology: replace multiple variables with arrays for cleaner code.  
- Segue: Next lesson could cover **2D arrays** (grids/matrices) since user input arrays lead naturally into them.  
-->
