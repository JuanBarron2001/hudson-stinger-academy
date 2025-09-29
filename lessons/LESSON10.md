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
- **Start Time in 12‑Hour Video:** [blank]  
- **Full Course (12h video):** [link here]

---

### 🎯 For the Quick‑Hit Learners  
- **Lesson Playlist:** [link here]  
- **This Lesson Only:** [link here]

---

## 💻 Part 1 – Java‑Only (2 pts)

**Basic (1 pt)**  
- Create a `String name` with your full name (including a space).  
- Demonstrate:  
  - `.length()` → number of characters  
  - `.charAt(index)` → character at a given index  
  - `.indexOf(char)` and `.lastIndexOf(char)` → first/last occurrence  

**Extra (1 pt)**  
- Show:  
  - `.toUpperCase()` and `.toLowerCase()`  
  - `.trim()` to remove whitespace  
  - `.replace(oldChar, newChar)`  
  - `.isEmpty()` inside an `if` statement  
  - `.contains(" ")` to check for spaces  
  - `.equals()` and `.equalsIgnoreCase()` for string comparison  

---

## 🤖 Part 2 – Robot Code (2 pts)

**Basic (1 pt)**  
- Use `.equals()` to check robot mode strings (e.g., `"AUTO"`, `"TELEOP"`).  
- Print which mode the robot is in.  

**Extra (1 pt)**  
- Use `.contains()` to check if a command string includes `"drive"` or `"shoot"`.  
- Use `.trim()` to clean up operator input before processing.  
- Display results on **SmartDashboard**.  

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
  [CODE BLOCK]java
  if (command.trim().equalsIgnoreCase("shoot")) {
      fireShooter();
  } else if (command.contains("drive")) {
      driveForward();
  } else {
      stop();
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
- Show `.length()` for password validation.  
- Robot code: `.equals("AUTO")` to check autonomous mode.  
- Archaeology: replace messy string parsing with `.contains()` or `.trim()`.  
- Segue: Next lesson could cover **StringBuilder** for efficiency.  
[CODE BLOCK]
