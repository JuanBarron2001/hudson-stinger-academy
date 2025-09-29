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
- **Start Time in 12‑Hour Video:** [blank]  
- **Full Course (12h video):** [link here]

---

### 🎯 For the Quick‑Hit Learners  
- **Lesson Playlist:** [link here]  
- **This Lesson Only:** [link here]

---

## 💻 Part 1 – Java‑Only (2 pts)

**Basic (1 pt)**  
- Create a `String email = "bro123@gmail.com";`  
- Use `.substring(0, 6)` to extract the username.  
- Use `.substring(7)` to extract the domain.  
- Print both results.  

**Extra (1 pt)**  
- Make the program flexible:  
  - Use `.indexOf("@")` to find the position of the `@`.  
  - Extract username with `.substring(0, email.indexOf("@"))`.  
  - Extract domain with `.substring(email.indexOf("@") + 1)`.  
- Print both values.  

---

## 🤖 Part 2 – Robot Code (2 pts)

**Basic (1 pt)**  
- Use `.substring()` to parse robot command strings.  
- Example: `"drive:forward"` → extract `"drive"` as the command.  

**Extra (1 pt)**  
- Combine `.indexOf()` and `.substring()` to split operator input:  
  - `"shoot:high"` → command = `"shoot"`, mode = `"high"`.  
- Display results on **SmartDashboard**.  

---

## 📜 Part 3 – Code Archaeology (2 pts)

**Basic (1 pt)**  
- Find a place in last year’s robot code where strings were manually split.  
- Suggest replacing it with `.substring()` for clarity.  

**Extra (1 pt)**  
- Propose improvements:  
  - Use `.indexOf()` + `.substring()` instead of hard‑coded indices.  
  - Add validation with `.contains(":")` before slicing.  
- Or write pseudo‑code for parsing:  
  [CODE BLOCK]java
  if (command.contains(":")) {
      String action = command.substring(0, command.indexOf(":"));
      String value  = command.substring(command.indexOf(":") + 1);
      execute(action, value);
  } else {
      System.out.println("Invalid command");
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
- Email slicer program → relatable beginner project.  
- Robot code: parse operator commands like `"drive:fast"`.  
- Archaeology: replace manual string splitting with `.substring()`.  
- Segue: Next lesson could cover **StringBuilder** or **String.split()** for advanced parsing.  
[CODE BLOCK]
