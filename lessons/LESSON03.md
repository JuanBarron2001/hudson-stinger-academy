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
- Read the driver's controller and drive the 2026 robot with it

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

## 🤖 Part 2 – Robot Code: the 2026 Robot (2 pts)

Your code goes in `robot-code/command-based-bot-2026/src/main/java/frc/lesson/lesson03/basic/Lesson03.java` (and `extra/Lesson03.java`). The task list is at the top of each file.  
Run it in the simulator the way you did in [Lesson 00](./LESSON00.md). CAN IDs, inversions and buttons are in [ROBOT.md](../robot-code/command-based-bot-2026/ROBOT.md).

**Basic (1 pt)**  
- Create the **driver controller** (`new XboxController(0)`) and both **left side** drive motors.
- Read the left stick's up/down with `driver.getLeftY()`, put it on SmartDashboard, and set both left motors to it.
- Run it and hold **W**, which pushes the stick forward. Answer in comments:
  - Is the number **positive or negative**?
  - Which way does the robot move on **Sim Field**, and why does it turn instead of driving?

**Extra (1 pt)**: tank drive  
- Create the driver controller and **all four** drive motors.
- Left stick drives the left side, right stick drives the right side. Flip each stick's sign with a minus so pushing forward gives a positive number: `double left = -driver.getLeftY();`
- Hold **W** and **I** together (both sticks forward) and write down what the robot does.
- **Fix it:** the right side motors are mounted facing the other way, so send them the *opposite* sign. Lesson 28 shows how the competition code does this with a motor setting instead.
- Put both stick values and both side speeds on SmartDashboard, then **drive a square** on Sim Field.

---

## 📜 Part 3 – Code Archaeology (2 pts, optional)

> *Optional: skip this part if you're short on time.* Last season's code is [`Hudson-Robotics/OG-Code-2026`](https://github.com/Hudson-Robotics/OG-Code-2026), branch **`Pre-DCMP-Flywheel`**.

**Basic (1 pt)**  
- Open `RobotContainer.java` and find the **three controllers**. For each one: which **port** is it on, who holds it, and what does it control?

**Extra (1 pt)**  
- `Drive.java` flips the sign of **both** `getLeftY()` and `getRightX()`. You already worked out why Y is flipped. Why is **X** flipped too? *Hint: in WPILib, a positive turn is counterclockwise.*

---

## 🏆 Total Points
- **Max:** 6 pts  
  - Java‑Only: 2 pts  
  - Robot Code: 2 pts  
  - Code Archaeology: 2 pts *(optional)*

---

> 🐝 *"The sting is in the details — master them, and you master the bot."*