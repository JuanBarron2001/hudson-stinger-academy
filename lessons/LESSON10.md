# 🖥️ Lesson 10 – Useful String Methods in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🐝

---

## 🎯 Overview
**Keywords:** Java, String Methods, length, charAt, indexOf, lastIndexOf, toUpperCase, toLowerCase, trim, replace, isEmpty, contains, equals, equalsIgnoreCase  
Learn to:
- Measure string length with `.length()`  
- Access characters with `.charAt()`  
- Find positions with `.indexOf()` and `.lastIndexOf()`  
- Convert strings to uppercase/lowercase  
- Trim whitespace with `.trim()`  
- Replace characters with `.replace()`  
- Check if a string is empty with `.isEmpty()`  
- Test for substrings with `.contains()`  
- Compare strings with `.equals()` and `.equalsIgnoreCase()`  

---

## ⏱️ Progress Tracking

### 📊 For the Marathon Watchers  
If you’re following the **full 12‑hour compilation** and want to see how far you’ve made it through the *entire* course:  
- **Start Time in 12‑Hour Video:** [02:10:20](https://www.youtube.com/watch?v=xTtL8E4LzTQ&t=7820s)  
- **Full Course (12h video):** [Watch Compilation](https://www.youtube.com/watch?v=xTtL8E4LzTQ)

---

### 🎯 For the Quick‑Hit Learners  
If you just want **this lesson only** and to be done with it — no scrubbing through hours of footage:  
- **Lesson Playlist:** [Java tutorial for beginners (2025) ☕](https://www.youtube.com/playlist?list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc)  
- **This Lesson Only:** [Watch Lesson 10](https://www.youtube.com/watch?v=Ntl3DxhyrQQ&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=13) (Useful string methods in Java! 🧵, 8:36)

---

## 💻 Part 1 – Java‑Only (2 pts)

**Basic (1 pt)**  
- Build a **magic spell parser** (fun and quirky!):
  - Start from a messy spell string, like `"   Cast FIREBALL now   "`
  - `.trim()` the extra spaces, then `.toLowerCase()` it. Your keywords below are lowercase, so the spell has to be too: an uppercased spell never `.contains("fireball")`.
  - If the spell `.isEmpty()` → print `"❌ No spell!"`
  - Else if it `.equals("abracadabra")` exactly → print `"🐇 A rabbit appears!"`
  - Else if it `.contains()` a keyword: `"fireball"` → `"🔥 Casting Fireball!"`, `"heal"` → `"✨ Healing!"`, and add `"teleport"` and `"shield"` yourself
  - Else → print `"❌ Unknown spell!"`
  - Also print the cleaned spell's `.length()` and its first letter, `.charAt(0)`
  - Test with `"   FIREBALL   "`, `"banana"` and `""` to show each branch working

**Extra (1 pt)**  
- Build an advanced **recipe ingredient parser**:
  - Take a recipe command like `"Add 2 cups sugar and vanilla extract"` or `"MIX butter and eggs and sugar"`
  - Parse using string methods:
    - `.trim()` and `.toLowerCase()` to clean it (lowercase, for the same reason as the basic)
    - `.indexOf("and")` and `.lastIndexOf("and")` to find the first and last "and"
    - `.contains()` to check for ingredients: "sugar", "butter", "eggs", "vanilla"
    - `.replace()` to swap ingredient aliases (e.g., "butter" → "unsalted butter")
    - `.equalsIgnoreCase("done")` on the **raw** command, before cleaning, to print `"Recipe finished!"` whether they typed `DONE` or `done`
  - Extract and list what ingredients were found
  - Print a clean recipe step: `"Step 1: Mix butter, eggs, and sugar"`
  - Show how multiple string methods work together to parse complex input  

---

## 🤖 Part 2 – Robot Code (2 pts)

> **Not written yet.** Lesson 10 is **optional** this offseason, so its robot half was never rewritten for the 2026 robot. What used to be here was a 2025 draft describing hardware this robot doesn't have, so it has been taken out rather than left to send you down a dead end. **Skip Parts 2 and 3 for now.**
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
- Show `.length()` for password validation.  
- Robot code: `.equals("AUTO")` to check autonomous mode.  
- Archaeology: replace messy string parsing with `.contains()` or `.trim()`.  
- Segue: Next lesson could cover **StringBuilder** for efficiency.  
-->
