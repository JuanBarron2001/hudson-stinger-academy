# 🖥️ Lesson 22 – Arrays in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🐝

---

## 🎯 Overview
**Keywords:** Java, Arrays, Elements, Index, For Loop, Enhanced For Loop, Sorting, Filling  
Learn to:
- Declare and initialize arrays  
- Access elements by index  
- Modify elements within an array  
- Use `.length` to determine array size  
- Iterate through arrays with `for` and enhanced `for-each` loops  
- Sort and fill arrays using `java.util.Arrays`  
- Hold every motor on the 2026 robot in one array  

---

## ⏱️ Progress Tracking

### 📊 For the Marathon Watchers  
If you’re following the **full 12‑hour compilation** and want to see how far you’ve made it through the *entire* course:  
- **Start Time in 12‑Hour Video:** [05:03:26](https://www.youtube.com/watch?v=xTtL8E4LzTQ&t=18206s)  
- **Full Course (12h video):** [Watch Compilation](https://www.youtube.com/watch?v=xTtL8E4LzTQ)

---

### 🎯 For the Quick‑Hit Learners  
If you just want **this lesson only** and to be done with it — no scrubbing through hours of footage:  
- **Lesson Playlist:** [Java tutorial for beginners (2025) ☕](https://www.youtube.com/playlist?list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc)  
- **This Lesson Only:** [Watch Lesson 22](https://www.youtube.com/watch?v=9dr2mHYYoug&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=31) (Learn Java arrays in 9 minutes! 🍎, 9:09)

---

## 💻 Part 1 – Java‑Only (2 pts)

**Basic (1 pt)**  
- Create a `String[] fruits = {"Apple", "Orange", "Banana", "Coconut"};`  
- Print each element by accessing its index (`fruits[0]`, `fruits[1]`, etc.).  
- Print `fruits` itself, with no index. Why do you get a strange code instead of fruit names? *(Hint: lesson 02's reference types.)*  
- Demonstrate what happens if you try to access an invalid index, like `fruits[4]`. Read the exception's name.  

**Extra (1 pt)**  
- Use a `for` loop with `fruits.length` to print all elements.  
- Use an **enhanced for loop** (`for (String fruit : fruits)`) to simplify iteration.  
- Modify an element (e.g., change `"Apple"` to `"Pineapple"`) and print the updated array.  
- Add `import java.util.Arrays;` at the top, then:  
  - `Arrays.sort(fruits);` and print the array again. What order is it in now?  
  - `Arrays.fill(fruits, "Pineapple");` and print it once more.  

---

## 🤖 Part 2 – Robot Code: the 2026 Robot (2 pts)

Your code goes in `robot-code/command-based-bot-2026/src/main/java/frc/lesson/lesson22/basic/Lesson22.java` (and `extra/Lesson22.java`). The task list is at the top of each file.  
Run it in the simulator the way you did in [Lesson 00](./LESSON00.md). CAN IDs, inversions and buttons are in [ROBOT.md](../robot-code/command-based-bot-2026/ROBOT.md).

**Basic (1 pt)**: every motor in one array  
- An `int[]` field holding every TalonFX CAN ID on the robot: `{1, 2, 3, 4, 5, 6, 7, 29}`.
- A `TalonFX[]` field of the same length, filled in `setup()` with a `for` loop.
- On the first loop, put `"CAN <id> Connected"` for every motor. This is lesson 16's pit check, and now CAN 29 is easy.
- Every loop, put each motor's rotations on SmartDashboard.
- Read `motors[8]`, see what error you get, and then remove it.

**Extra (1 pt)**: drive with arrays  
- Make `leftMotors` (CAN 1, 3) and `rightMotors` (CAN 2, 4) arrays, and set each side with an **enhanced for loop** in your lesson 04 arcade drive.
- Average the left side's rotations with a loop and `leftMotors.length`, turn the result into meters (lesson 04), and put it on SmartDashboard.
- Why divide by `.length` instead of writing `2`? Answer in a comment.

---

## 📜 Part 3 – Code Archaeology (2 pts, optional)

> *Optional: skip this part if you're short on time.* Last season's code is [`Hudson-Robotics/OG-Code-2026`](https://github.com/Hudson-Robotics/OG-Code-2026), branch **`Pre-DCMP-Flywheel`**.

**Basic (1 pt)**  
- `VisionSubsystem.getAvgTagDistance()` loops over a `RawFiducial[]` array. Explain the loop line by line. What does it return when the array is empty?

**Extra (1 pt)**: units detective  
- `getAvgTagDistance()`'s comment says it returns **inches**, and `MAX_SINGLE_TAG_DISTANCE = 60.0` is labelled inches too. Look up what units Limelight reports tag distances in. If it's meters, what does the 60 actually filter, and which caller gets the wrong answer? *(Confirm on the real robot before calling it a bug.)*

---

## 🏆 Total Points
- **Max:** 6 pts  
  - Java‑Only: 2 pts  
  - Robot Code: 2 pts  
  - Code Archaeology: 2 pts *(optional)*

---

<!-- Drafting notes from the transcript draft. Hidden from students.
Ideas:
- Show `.length` property for dynamic iteration.  
- Robot code: arrays for motor speeds or sensor values.  
- Archaeology: replace multiple joystick variables with an array.  
- Segue: Next lesson could cover **2D arrays** (matrices) since nested loops pair well with them.  
-->
