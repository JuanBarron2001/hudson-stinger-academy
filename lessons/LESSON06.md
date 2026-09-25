# 🖥️ Lesson 06 – Random Numbers in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🐝

---

## 🎯 Overview
**Keywords:** Java, Random Class, nextInt, nextDouble, nextBoolean, Dice Roll, Coin Flip  
Learn to:
- Import and create a `Random` object  
- Generate random integers within a range  
- Generate multiple random values (simulate dice rolls)  
- Generate random doubles between 0.0 and 1.0  
- Generate random booleans (simulate coin flips)  
- Apply randomness to robot code for testing or simulation  

---

## ⏱️ Progress Tracking

### 📊 For the Marathon Watchers  
If you’re following the **full 12‑hour compilation** and want to see how far you’ve made it through the *entire* course:  
- **Start Time in 12‑Hour Video:** [01:22:28](https://www.youtube.com/watch?v=xTtL8E4LzTQ&t=4948s)  
- **Full Course (12h video):** [Watch Compilation](https://www.youtube.com/watch?v=xTtL8E4LzTQ)

---

### 🎯 For the Quick‑Hit Learners  
If you just want **this lesson only** and to be done with it — no scrubbing through hours of footage:  
- **Lesson Playlist:** [Java tutorial for beginners (2025) ☕](https://www.youtube.com/playlist?list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc)  
- **This Lesson Only:** [Watch Lesson 06](https://www.youtube.com/watch?v=-tt98ICTHtQ&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=8) (Generate random numbers using Java! 🔀, 5:01)

---

## 💻 Part 1 – Java‑Only (2 pts)

**Basic (1 pt)**  
- Import `java.util.Random`.  
- Create a `Random` object.  
- Roll a single 6-sided die with `random.nextInt(1, 7)` and print the result. The first number is included and the second is **not**, so `7` is what gets you 1 through 6. (`nextInt(6) + 1` does the same thing.)  
- Print one `random.nextDouble()`. What range of numbers does it give you?  
- Bonus: Roll the die 5 times and print each result.

**Extra (1 pt)**  
- Build a simple dice game:
  - Prompt the user to pick a **target number between 3 and 18** using `Scanner`.
  - Use `nextBoolean()` to flip a coin (randomly determine win condition).
    - If heads → user wins if the **3-die sum is ABOVE their target**.
    - If tails → user wins if the **3-die sum is BELOW their target**.
  - Roll **3 six-sided dice** and calculate the sum.
  - Compare the sum to the target and print whether the user won or lost.
  - Example: User picks 10, coin flip is "heads" (need above 10), roll 3 dice → sum is 13 → **WIN!**  

---

## 🤖 Part 2 – Robot Code (2 pts)

> **Not written yet.** Lesson 06 is **optional** this offseason, so its robot half was never rewritten for the 2026 robot. What used to be here was a 2025 draft describing hardware this robot doesn't have, so it has been taken out rather than left to send you down a dead end. **Skip Parts 2 and 3 for now.**
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
- Show dice roll simulation as a fun intro.  
- Robot code: add random delay before shooting to simulate real‑world timing.  
- Archaeology: propose using randomness to test PID tuning under noisy conditions.  
- Segue: Next lesson could cover loops → repeat random trials automatically.  
-->
