# 🖥️ Lesson 04 – Arithmetic Operators in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🐝

---

## 🎯 Overview
**Keywords:** Java, Arithmetic Operators, Addition, Subtraction, Multiplication, Division, Modulus, Augmented Assignment, SmartDashboard, Code Archaeology  
Learn to:
- Use two variables to perform core math operations
- Read user input and compute results
- Apply scaling math to robot code (motor speed)
- Estimate theoretical RPM and linear speed from joystick input
- Analyze old code where math is used and propose improvements

---

## ⏱️ Progress Tracking

### 📊 For the Marathon Watchers  
If you’re following the **full 12‑hour compilation** and want to see how far you’ve made it through the *entire* course:  
- **Start Time in 12‑Hour Video:** TBD  
- **Full Course (12h video):** [Watch Compilation](https://www.youtube.com/watch?v=xTtL8E4LzTQ)

---

### 🎯 For the Quick‑Hit Learners  
If you just want **this lesson only** and to be done with it — no scrubbing through hours of footage:  
- **Lesson Playlist:** [Java tutorial for beginners (2025) ☕](https://www.youtube.com/playlist?list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc)  
- **This Lesson Only:** Watch Lesson 04 (TBD)

---

## 💻 Part 1 – Java‑Only (2 pts)

**Basic (1 pt)**  
- Create two variables (choose the types and values, e.g., integers).  
- Perform and print:
  - Addition (+)
  - Subtraction (−)
  - Multiplication (×)
  - Division (÷)
  - Modulus (%)  
- Print each operation with both the expression and the result (e.g., `10 + 3 = 13`).

**Extra (1 pt)**  
- Ask the user for two numbers using `Scanner`.  
- Perform at least three operations with those inputs and print the results.  
- Optional: also show floating‑point division by casting to `double`.

---

## 🤖 Part 2 – Robot Code (2 pts)

**Basic (1 pt)**  
- Given a `double motorSpeed`, divide it by 2.  
- Output the result to **SmartDashboard**.  
- Ignore floating‑point precision details for now.

**Extra (1 pt)**  
- With only the joystick speed (0.0 to 1.0), compute and print:
  - Theoretical motor RPM  
  - Theoretical robot linear speed  
- Research or ask teammates/mentors for:
  - Motor free speed (RPM) from the datasheet  
  - Wheel diameter  
  - How to convert RPM to linear speed (use wheel circumference and unit conversions)

---

## 📜 Part 3 – Code Archaeology (2 pts)

**Basic (1 pt)**  
- Find any math operation in last year’s robot code and explain:  
  - What it’s doing  
  - Why it’s needed  
  - Which variables are involved

**Extra (1 pt)**  
- If you find a place where math could improve behavior or clarity, describe it.  
- If not, write **pseudo‑code** for a math‑driven feature, such as:  
  - Calculating the angle between the robot and the goal using geometry  
  - Estimating travel time from distance and speed

---

## 🏆 Total Points
- **Max:** 6 pts  
  - Java‑Only: 2 pts  
  - Robot Code: 2 pts  
  - Code Archaeology: 2 pts

---

> 🐝 *"Math isn’t just numbers — it’s the language your robot speaks."*

```LOG
Note to self: Delete this before lessons are done
Lesson04 – two variables → do all math → print
Extra – ask for input → compute → print
FRC basic – motorSpeed / 2 → SmartDashboard
FRC extra – theoretical RPM & linear speed from joystick; research required
Archaeology – find math; explain; propose improvements or geometry pseudo-code
Segue – leads into Lesson03 (input) by reading joystick & console inputs
```