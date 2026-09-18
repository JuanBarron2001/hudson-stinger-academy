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

**Basic (1 pt)**  
- Build a **Shuffleboard command parser** for driver input:
  - Read a string command from Shuffleboard (e.g., a text field where operator types)
  - Parse using string methods:
    - `.trim()` to clean whitespace
    - `.toLowerCase()` to normalize case
    - `.contains()` to check for keywords: `"forward"`, `"backward"`, `"spin"`
  - Based on the command, execute robot actions:
    - If contains `"forward"` → drive forward
    - If contains `"backward"` → drive backward
    - If contains `"spin"` → rotate in place
    - Else → stop
  - Print to SmartDashboard what command was understood: `"Operator: 'forward' → DRIVING FORWARD"`
  - Handle messy input like `"  FORWARD  "` or `"FoRwArD"` by using `.trim()` and `.toLowerCase()`

**Extra (1 pt)**  
- Build a **command logger with validation**:
  - Read operator input from Shuffleboard (text field)
  - Clean and validate:
    - `.trim()` whitespace
    - `.toLowerCase()` for case-insensitivity
    - `.isEmpty()` check for empty commands
  - Parse with `.contains()` and `.indexOf()` to extract keywords:
    - Valid commands: `"forward"`, `"backward"`, `"spin"`, `"stop"`
  - Log to SmartDashboard:
    - Raw input: `"  FORWARD please  "`
    - Cleaned input: `"forward please"`
    - Recognized keyword: `"forward"`
    - Action taken: `"DRIVING FORWARD"`
    - Unknown commands logged as: `"Invalid command: 'banana'"`
  - Use `.equals()` or `.equalsIgnoreCase()` for exact command matching if desired  

---

## 📜 Part 3 – Code Archaeology (2 pts)

**Basic (1 pt)**  
- Find a string method in last year’s robot code (e.g., `.equals()` for mode checking).  
- Explain what it does and why it was needed.  

**Extra (1 pt)**  
- Suggest improvements:  
  - Replace manual character checks with `.contains()` or `.indexOf()`.  
  - Use `.equalsIgnoreCase()` for more robust comparisons.  
- Or write pseudo‑code for command parsing:  
  ```java
  if (command.trim().equalsIgnoreCase("shoot")) {
      fireShooter();
  } else if (command.contains("drive")) {
      driveForward();
  } else {
      stop();
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
- Show `.length()` for password validation.  
- Robot code: `.equals("AUTO")` to check autonomous mode.  
- Archaeology: replace messy string parsing with `.contains()` or `.trim()`.  
- Segue: Next lesson could cover **StringBuilder** for efficiency.  
-->
