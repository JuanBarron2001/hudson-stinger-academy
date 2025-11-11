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
- **Start Time in 12‑Hour Video:** [00:31:30](https://www.youtube.com/watch?v=xTtL8E4LzTQ&t=1890s)  
- **Full Course (12h video):** [Watch Compilation](https://www.youtube.com/watch?v=xTtL8E4LzTQ)

---

### 🎯 For the Quick‑Hit Learners  
If you just want **this lesson only** and to be done with it — no scrubbing through hours of footage:  
- **Lesson Playlist:** [Java tutorial for beginners (2025) ☕](https://www.youtube.com/playlist?list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc) 
- **This Lesson Only:** [Watch Lesson 03](https://www.youtube.com/watch?v=RAthlOQUMkc&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=3)

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
- Program your **drivetrain motors** (from Lesson 02).  
- Add **controller input** so you can drive in different styles:  
  - Use **buttons** for simple forward, backward, steer left, and steer right.  
  - Use **axes** to experiment with driving modes:  
    - **Tank drive** (each stick controls one side).  
    - **Arcade drive** (one stick for forward/back, one stick for turning).  
    - **Cheesy drive** (mix of throttle + quick‑turn).  
- Output the chosen **axis/button values** and **motor speeds** to the **SmartDashboard** so you can see what’s happening.


---

## 📜 Part 3 – Code Archaeology (2 pts)

**Basic (1 pt)**  
- Search last year’s robot code for **controller definitions** (joysticks/gamepads)
- Identify:
  - Which controllers were used
  - What each controller controlled

**Extra (1 pt)**  
- Map out **all button bindings** from last year’s code and describe their purpose.  
- Identify any **hard‑coded axis/button numbers** and suggest replacing them with named constants.  
- Bonus: Trace one controller input through the code to show how it affects a subsystem.


---

## 🏆 Total Points
- **Max:** 6 pts  
  - Java‑Only: 2 pts  
  - Robot Code: 2 pts  
  - Code Archaeology: 2 pts

---

> 🐝 *"The sting is in the details — master them, and you master the bot."*