# 🖥️ Lesson 19 – Methods in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🐝

---

## 🎯 Overview
**Keywords:** Java, Methods, Parameters, Arguments, Return Values, Static, Reusable Code  
Learn to:
- Define and call methods in Java  
- Understand the difference between **arguments** (values you send) and **parameters** (placeholders that receive them)  
- Pass multiple arguments into methods  
- Return values from methods (`void` vs. typed returns)  
- Use methods for code reuse and cleaner design  
- Turn the 2026 robot's drive and shooter code into named methods  

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
- Write a simple method called `happyBirthday()` that prints the Happy Birthday song.  
- Call it three times from `main()` to demonstrate code reuse.  

**Extra (1 pt)**  
- Add parameters:  
  - `String name`  
  - `int age`  
- Update the method to print:  
  `"Happy Birthday dear <name>, you are <age> years old!"`  
- Call the method with different names and ages.  

---

## 🤖 Part 2 – Robot Code: the 2026 Robot (2 pts)

Your code goes in `robot-code/command-based-bot-2026/src/main/java/frc/lesson/lesson19/basic/Lesson19.java` (and `extra/Lesson19.java`). The task list is at the top of each file.  
Run it in the simulator the way you did in [Lesson 00](./LESSON00.md). CAN IDs, inversions and buttons are in [ROBOT.md](../robot-code/command-based-bot-2026/ROBOT.md).

**Basic (1 pt)**: methods clean up the drive code  
- Create the driver controller and all four drive motors.
- Write `double deadband(double value)`, which **returns** the value with lesson 05's deadband applied.
- Write `void setDrive(double left, double right)`, which sets all four motors and handles the right side's opposite sign.
- Rewrite your lesson 04 arcade drive using only those two methods. Aim for **five lines or fewer** in `execute()`.
- Methods inside a lesson don't need the word `static`.

**Extra (1 pt)**: methods for the shooter  
- Create the operator controller, both rollers and the conveyor.
- Write `double rollerSpeed()`, `boolean atSpeed(double target)` (within 3, like lesson 07) and `void setFuel(double rollerPower, double conveyorPower)`.
- Rebuild lesson 14's shoot logic using only those methods. It should read almost like English: `if (shooting && atSpeed(-70)) setFuel(...)`.

---

## 📜 Part 3 – Code Archaeology (2 pts, optional)

> *Optional: skip this part if you're short on time.* Last season's code is [`Hudson-Robotics/OG-Code-2026`](https://github.com/Hudson-Robotics/OG-Code-2026), branch **`Pre-DCMP-Flywheel`**.

**Basic (1 pt)**  
- `CANFuelSubsystem.java` has `setIntakeLauncherRoller`, `setFeederRoller` and `stop`. For each one: what parameters does it take, what does it return, and which commands call it?

**Extra (1 pt)**  
- Four commands are never created anywhere in the code (`AimAtTarget`, `IntakeUp`, `IntakeDown`, `LaunchAtSpeed`), and nothing reads `LauncherConstants`. Should unused code be deleted or kept? Argue one side, with a reason from *this* codebase.

---

## 🏆 Total Points
- **Max:** 6 pts  
  - Java‑Only: 2 pts  
  - Robot Code: 2 pts  
  - Code Archaeology: 2 pts *(optional)*

---

[CODE BLOCK]LOG
Ideas:
- Show Happy Birthday example → fun intro to methods.  
- Robot code: method for battery safety check.  
- Archaeology: replace repeated code with reusable methods.  
- Segue: Next lesson could cover **method overloading** (same method name, different parameters).  
[CODE BLOCK]
