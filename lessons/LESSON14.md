# 🖥️ Lesson 14 – Logical Operators in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🐝

---

## 🎯 Overview
**Keywords:** Java, Logical Operators, AND (`&&`), OR (`||`), NOT (`!`), Boolean, Validation, Conditions  
Learn to:
- Combine multiple conditions with `&&` (AND)  
- Use `||` (OR) to allow at least one condition to be true  
- Apply `!` (NOT) to invert Boolean values  
- Validate input with logical operators  
- Build practical examples like weather checks and username validation  

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
- Create an integer `temp = 20;`  
- Use `&&` to check if `temp` is between 0 and 30.  
- Print `"The weather is good 🙂"` if true.  

**Extra (1 pt)**  
- Add a Boolean `isSunny`.  
- Use `&&` to require both temperature range and sunny conditions.  
- Use `!isSunny` to print `"It is cloudy ☁️"`.  
- Use `||` to check if `temp` is too hot (>30) or too cold (<0). Print `"The weather is bad"`.  

---

## 🤖 Part 2 – Robot Code (2 pts)

**Basic (1 pt)**  
- Use `&&` to check multiple robot conditions:  
  - Example: if `batteryLevel > 20 && isEnabled`.  
  - Only then allow motors to run.  

**Extra (1 pt)**  
- Use `||` to trigger a warning:  
  - Example: if `temperature > 80 || current > 40`.  
- Use `!` to ensure a safety condition:  
  - Example: `if (!limitSwitchPressed)` → allow arm movement.  
- Print results to **SmartDashboard**.  

---

## 📜 Part 3 – Code Archaeology (2 pts)

**Basic (1 pt)**  
- Find a logical operator in last year’s robot code (e.g., `&&` for safety checks).  
- Explain what it does and why it’s important.  

**Extra (1 pt)**  
- Suggest improvements:  
  - Replace nested `if` statements with combined logical operators.  
  - Use `||` for multiple failure conditions.  
- Or write pseudo‑code for username validation:  
  [CODE BLOCK]java
  if (username.length() < 4 || username.length() > 12) {
      System.out.println("Username must be 4–12 characters");
  } else if (username.contains(" ") || username.contains("_")) {
      System.out.println("Username must not contain spaces or underscores");
  } else {
      System.out.println("Welcome, " + username);
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
- Weather example → fun intro to `&&`, `||`, `!`.  
- Robot code: combine multiple safety checks with logical operators.  
- Archaeology: simplify nested conditions with `&&` and `||`.  
- Segue: Next lesson could cover **while loops** (repeating conditions).  
[CODE BLOCK]
