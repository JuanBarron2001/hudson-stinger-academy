# 🖥️ Lesson 03 – Accepting User Input in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🐝

---

## 🎯 Overview
**Keywords:** Java, Scanner, User Input, Strings, Integers, Doubles, Booleans, SmartDashboard, Code Archaeology  
Learn to:
- Import and use the `Scanner` class from `java.util`
- Accept user input of different data types (`String`, `int`, `double`, `boolean`)
- Handle common input issues (like the newline buffer problem)
- Use input in calculations and conditional logic
- Close resources properly to avoid unexpected behavior

---

## ⏱️ Progress Tracking

### 📊 For the Marathon Watchers  
If you’re following the **full 12‑hour compilation** and want to see how far you’ve made it through the *entire* course:  
- **Start Time in 12‑Hour Video:** [HH:MM:SS](full‑course‑link)  
- **Full Course (12h video):** [Watch Compilation](full‑course‑link)

---

### 🎯 For the Quick‑Hit Learners  
If you just want **this lesson only** and to be done with it — no scrubbing through hours of footage:  
- **Lesson Playlist:** [Java tutorial for beginners (2025) ☕](playlist‑link)  
- **This Lesson Only:** [Watch Lesson 03](lesson‑link)

---

## 💻 Part 1 – Java‑Only (2 pts)

**Basic (1 pt)**  
- Write a program that:
  - Imports `java.util.Scanner`
  - Prompts the user for **two doubles**: `width` and `height`
  - Calculates the **area of a rectangle** (`width * height`)
  - Prints:  
    ```
    The area is: <area> cm²
    ```

**Extra (1 pt)**  
- Write a program that:
  - Asks for **Name**, **Class**, **four doubles**: the scores of the last 4 assignments
  - Calculates the **average score**
  - Prints a **“report card”** style output, for example:  
    ```
    Report Card for: <student name>
    Class: <class name>
    Assignment Scores: <score1>, <score2>, <score3>, <score4>
    Average Score: <average>
    ```

---

## 🤖 Part 2 – Robot Code (2 pts)

**Basic (1 pt)**  
- Use a controller (joystick/gamepad) input to:
  - Read the value of one axis
  - Print that value to **SmartDashboard**
  - Set a motor’s speed to match that axis value

**Extra (1 pt)**  
- Program an **intake system** with two motors that can:
  - **Intake** when a certain button is pressed
  - **Outtake** when another button is pressed
  - Optionally: scale the motor speed based on joystick axis math (e.g., half‑speed mode)

---

## 📜 Part 3 – Code Archaeology (2 pts)

**Basic (1 pt)**  
- Search last year’s robot code for **controller definitions** (joysticks/gamepads)
- Identify:
  - Which controllers were used
  - What each controller controlled

**Extra (1 pt)**  
- **[Leave Blank for Now]** – Possible ideas:
  - Map out **all button bindings** and describe their purpose
  - Find unused controller inputs and suggest how they could be repurposed
  - Identify any **hard‑coded axis/button numbers** and suggest replacing them with named constants
  - Trace one controller input through the code to see exactly how it affects a subsystem

---

## 🏆 Total Points
- **Max:** 6 pts  
  - Java‑Only: 2 pts  
  - Robot Code: 2 pts  
  - Code Archaeology: 2 pts

---

> 🐝 *"The sting is in the details — master them, and you master the bot."*

```LOG
Note to self: Delete this before lessons are done
Lesson03 - need to pick what to for extra part 3
need to add the links to the video
not md related but will just try catch to see if they do basic or extra and handle it accordingly
```