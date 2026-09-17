# 🖥️ Lesson 05 – If Statements in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🐝

---

## 🎯 Overview
**Keywords:** Java, If Statements, Boolean, Else, Else If, Comparison Operators, Scanner, Strings, Conditions  
Learn to:
- Write and structure `if`, `else if`, and `else` statements  
- Use Boolean variables directly in conditions  
- Compare values with relational and equality operators (`>=`, `==`, etc.)  
- Prompt the user for input with `Scanner` and branch logic accordingly  
- Handle strings with `.isEmpty()` and Boolean input with `nextBoolean()`  
- Understand order of conditions and why placement matters  
- Use `if` statements for a joystick deadband and for the 2026 robot's intake buttons  

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
- Create an integer variable `age`.  
- Write an `if` statement that checks if `age >= 18`.  
- Print `"You are an adult"` if true.  
- Add an `else` clause to print `"You are a child"`.  

**Extra (1 pt)**  
- Expand with multiple conditions:  
  - `age < 0` → `"You haven’t been born yet"`  
  - `age == 0` → `"You are a baby"`  
  - `age >= 65` → `"You are a senior"`  
- Prompt the user for their age using `Scanner` and test the branching logic.  

---

## 🤖 Part 2 – Robot Code: the 2026 Robot (2 pts)

Your code goes in `robot-code/command-based-bot-2026/src/main/java/frc/lesson/lesson05/basic/Lesson05.java` (and `extra/Lesson05.java`). The task list is at the top of each file.  
Run it in the simulator the way you did in [Lesson 00](./LESSON00.md). CAN IDs, inversions and buttons are in [ROBOT.md](../robot-code/command-based-bot-2026/ROBOT.md).

**Basic (1 pt)**: deadband  
- Create the driver controller and all four drive motors.
- `stick` = the left stick's up/down, sign flipped, **plus 0.06**. The `+ 0.06` fakes a drifting stick, because real sticks never rest at exactly 0 and your keyboard never drifts.
- Drive all four motors with `stick`, run it **without touching anything**, and watch Sim Field. Write down what happens.
- Add a **deadband** with `if` / `else if` / `else`: above `0.1` or below `-0.1`, `speed = stick`; otherwise `speed = 0`. Drive with `speed` instead. Does the creeping stop?
- Put `stick` and `speed` on SmartDashboard.
- **Real-world reason:** a drifting stick makes a real robot creep across the field when nobody's touching it.

**Extra (1 pt)**: intake and eject  
- Create the **operator controller** (`new XboxController(1)`), the two **rollers** (CAN 5 and 6), and the **conveyor** (CAN 29). At home, the operator is Keyboard 1: **B is the 6 key**, and **the left bumper is the 3 key**.
- Using the ball paths in ROBOT.md:
  - `if` B is held → **INTAKE**: rollers `-0.7`, conveyor `+0.8`
  - `else if` the left bumper is held → **EJECT**: rollers `+0.9`, conveyor `+0.8`
  - `else` → **STOPPED**: everything `0`
- Put the mode and the left roller's speed (`leftRoller.getVelocity().getValueAsDouble()`) on SmartDashboard.
- Hold B. **Does the roller actually spin?** If it reads 0, the right roller is mounted like the right side of the drivetrain.
- Hold **B and the left bumper at the same time**. Which one wins, and why? Answer in a comment.

---

## 📜 Part 3 – Code Archaeology (2 pts, optional)

> *Optional: skip this part if you're short on time.* Last season's code is [`Hudson-Robotics/OG-Code-2026`](https://github.com/Hudson-Robotics/OG-Code-2026), branch **`Pre-DCMP-Flywheel`**.

**Basic (1 pt)**  
- The team never wrote a deadband in `Drive.java` or `CANDriveSubsystem.java`. Is there one anyway? Find out where it's hiding and how big it is. *Hint: look up WPILib's `DifferentialDrive`.*

**Extra (1 pt)**  
- In `FlywheelLaunchSequence.java`, find the `if` / `else` in `execute()` that decides when to feed the ball. Explain both branches, and why the robot holds the ball back while the flywheel spins up.

---

## 🏆 Total Points
- **Max:** 6 pts  
  - Java‑Only: 2 pts  
  - Robot Code: 2 pts  
  - Code Archaeology: 2 pts *(optional)*

---

[CODE BLOCK]LOG
Ideas:
- Use joystick deadband logic as a real-world “if statement” example.
- Archaeology: check for safety interlocks (e.g., “if limit switch is pressed, stop motor”).
- Segue: This lesson builds naturally from arithmetic (Lesson 04) → now we make decisions with those values.
- Future: Combine if statements with loops for Lesson 06.
[CODE BLOCK]
