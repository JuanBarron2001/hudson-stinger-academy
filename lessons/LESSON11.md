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
  - Take a file path like `"/home/user/Documents/myfile.txt"` or `"C:\Users\robot\config.json"`
  - Extract:
    - Filename: everything after the last `/` or `\`
    - Extension: everything after the last `.`
    - Directory: everything before the filename
  - Use `.lastIndexOf()` to find the last occurrence
  - Use `.substring()` to extract each part
  - Handle edge cases (no extension, no directory, etc.)
  - Print all three parts clearly  

---

## 🤖 Part 2 – Robot Code (2 pts)

**Basic (1 pt)**  
- Build a **simple command parser** for Shuffleboard input:
  - Read command strings from Shuffleboard (text field): `"drivetrain:forward"`, `"drivetrain:backward"`, `"apriltag:5"`
  - Use `.indexOf(":")` to find the delimiter position
  - Extract the subsystem: `.substring(0, indexOf(":"))`
  - Extract the action: `.substring(indexOf(":") + 1)`
  - Validate with `.contains(":")`
  - Execute appropriate robot action:
    - If subsystem is `"drivetrain"` and action is `"forward"` → drive forward
    - If action is `"backward"` → drive backward
    - If action is `"stop"` → stop
  - Print to SmartDashboard: `"Command: drivetrain:forward → DRIVING FORWARD"`

**Extra (1 pt)**  
- Build an **advanced multi-parameter parser**:
  - Parse complex command strings with multiple colons: `"drivetrain:forward:0.5"`, `"apriltag:5:follow"`, `"apriltag:12:ignore"`
  - Use `.indexOf(":")` to find the first delimiter, then use `.substring()` + `.indexOf(":")` again to find the second
  - Extract all three parts:
    - Subsystem: `"drivetrain"` or `"apriltag"`
    - First param: direction/ID
    - Second param: speed/action
  - Example parsing:
    - `"drivetrain:forward:0.5"` → subsystem=`"drivetrain"`, direction=`"forward"`, speed=`0.5`
    - `"apriltag:5:follow"` → subsystem=`"apriltag"`, tagID=`5`, action=`"follow"`
  - Execute appropriate actions based on all parsed parameters
  - Print detailed log to SmartDashboard showing what was parsed and executed  

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
