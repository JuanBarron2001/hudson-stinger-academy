# 🖥️ Lesson 11 – The `substring` Method in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🐝

---

## 🎯 Overview
**Keywords:** Java, String, substring, indexOf, Email Slicer, User Input, Validation  
Learn to:
- Extract parts of a string using `.substring(start, end)`  
- Use `.substring(start)` to get everything from an index to the end  
- Combine `.substring()` with `.indexOf()` for flexible slicing  
- Build an **email slicer** program (username + domain)  
- Validate input with `.contains()` before slicing  

---

## ⏱️ Progress Tracking

### 📊 For the Marathon Watchers  
If you’re following the **full 12‑hour compilation** and want to see how far you’ve made it through the *entire* course:  
- **Start Time in 12‑Hour Video:** [02:18:55](https://www.youtube.com/watch?v=xTtL8E4LzTQ&t=8335s)  
- **Full Course (12h video):** [Watch Compilation](https://www.youtube.com/watch?v=xTtL8E4LzTQ)

---

### 🎯 For the Quick‑Hit Learners  
If you just want **this lesson only** and to be done with it — no scrubbing through hours of footage:  
- **Lesson Playlist:** [Java tutorial for beginners (2025) ☕](https://www.youtube.com/playlist?list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc)  
- **This Lesson Only:** [Watch Lesson 11](https://www.youtube.com/watch?v=44iQGNUcik0&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=14) (Java substrings are easy! 📧, 8:05)

---

## 💻 Part 1 – Java‑Only (2 pts)

**Basic (1 pt)**  
- Build an **interactive email slicer**:
  - Use `Scanner` to prompt user for an email address
  - Validate that it `.contains("@")`
  - Use `.indexOf("@")` to find the `@` position
  - Extract username: `.substring(0, indexOf("@"))`
  - Extract domain: `.substring(indexOf("@") + 1)`
  - Print both parts clearly
  - Example: `"bro123@gmail.com"` → username: `"bro123"`, domain: `"gmail.com"`

**Extra (1 pt)**  
- Build a **filename/path parser** (more complex):
  - Store a file path in a `String`, like `"/home/user/robot/config.json"`. For a Windows path, write every backslash twice inside the quotes: `"C:\\Users\\robot\\config.json"`. A single `\` starts an escape, like the `\n` from lesson 01, and `\U` isn't one, so it won't compile.
  - Extract:
    - Filename: everything after the last `/` or `\` → `config.json`
    - Extension: everything after the last `.` → `json`
    - Directory: everything before the last `/` or `\` → `/home/user/robot`
  - Use `.lastIndexOf()` to find the last occurrence
  - Use `.substring()` to extract each part
  - Handle edge cases: `.lastIndexOf()` gives `-1` when it finds nothing. What should print for `"notes"` (no extension) or `"config.json"` (no directory)?
  - Print all three parts clearly  

---

## 🤖 Part 2 – Robot Code (2 pts)

> **Not written yet.** Lesson 11 is **optional** this offseason, so its robot half was never rewritten for the 2026 robot. What used to be here was a 2025 draft describing hardware this robot doesn't have, so it has been taken out rather than left to send you down a dead end. **Skip Parts 2 and 3 for now.**
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
- Email slicer program → relatable beginner project.  
- Robot code: parse operator commands like `"drive:fast"`.  
- Archaeology: replace manual string splitting with `.substring()`.  
- Segue: Next lesson could cover **StringBuilder** or **String.split()** for advanced parsing.  
-->
