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
- Replace nested ifs with `&&`, `||` and `!`, and give the climber soft limits  

---

## ⏱️ Progress Tracking

### 📊 For the Marathon Watchers  
If you’re following the **full 12‑hour compilation** and want to see how far you’ve made it through the *entire* course:  
- **Start Time in 12‑Hour Video:** [03:09:58](https://www.youtube.com/watch?v=xTtL8E4LzTQ&t=11398s)  
- **Full Course (12h video):** [Watch Compilation](https://www.youtube.com/watch?v=xTtL8E4LzTQ)

---

### 🎯 For the Quick‑Hit Learners  
If you just want **this lesson only** and to be done with it — no scrubbing through hours of footage:  
- **Lesson Playlist:** [Java tutorial for beginners (2025) ☕](https://www.youtube.com/playlist?list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc)  
- **This Lesson Only:** [Watch Lesson 14](https://www.youtube.com/watch?v=4ezfRdg6Z7E&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=20) (Java LOGICAL OPERATORS are easy! ❕, 11:26)

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
- **Username rules**, the video's second example. Store a username in a `String` and check it with one `if` / `else if` / `else`:  
  - `username.length() < 4 || username.length() > 12` → `"Username must be between 4 and 12 characters"`  
  - `username.contains(" ") || username.contains("_")` → `"Username must not contain spaces or underscores"`  
  - otherwise → `"Welcome " + username`  
  - Try `"bob"`, `"bee_keeper"` and `"stinger4295"`.  

---

## 🤖 Part 2 – Robot Code: the 2026 Robot (2 pts)

Your code goes in `robot-code/command-based-bot-2026/src/main/java/frc/lesson/lesson14/basic/Lesson14.java` (and `extra/Lesson14.java`). The task list is at the top of each file.  
Run it in the simulator the way you did in [Lesson 00](./LESSON00.md). CAN IDs, inversions and buttons are in [ROBOT.md](../robot-code/command-based-bot-2026/ROBOT.md).

**Basic (1 pt)**: flatten the nested ifs  
- Create the **operator controller**, both **rollers** and the **conveyor**.
- Store two booleans: `shooting` (**A** held, the **5** key) and `atSpeed` (lesson 07's check against `-70`).
- The rollers run at your lesson 07 power whenever `shooting`.
- Use **one** `if` / `else if` / `else` chain with **no nesting**:
  - `shooting && atSpeed` → conveyor `-0.7`, status `"FEEDING"`
  - `shooting && !atSpeed` → conveyor `-0.05`, status `"SPINNING UP"`
  - otherwise → conveyor `0`, status `"STOPPED"`
- Put `shooting`, `atSpeed` and the status on SmartDashboard.
- Compare with your lesson 09 version. Which is easier to read? Answer in a comment.

**Extra (1 pt)**: climber soft limits  
- Create the **driver controller** and the **climber**.
- Power is `0.95` when the D-pad is up, `-0.4` when it's down (`getPOV() == 180`), otherwise `0`.
- **In one `if`**, using `&&` and `||`: if (going up **and** past `365`) **or** (going down **and** below `-70`), set power to `0`. Those are the competition code's limits.
- Put position, power and `"At Limit"` on SmartDashboard.
- Hold the up arrow until it stops. Can you still drive it back down? Why *should* you be able to?

---

## 📜 Part 3 – Code Archaeology (2 pts, optional)

> *Optional: skip this part if you're short on time.* Last season's code is [`Hudson-Robotics/OG-Code-2026`](https://github.com/Hudson-Robotics/OG-Code-2026), branch **`Pre-DCMP-Flywheel`**.

**Basic (1 pt)**  
- In `AlignAndShoot.java`, the feeder runs when `visionSubsystem.isAimedAtHub() && fuelSubsystem.isAtTargetVelocity() && targetRPS != 0`. Explain each of the three parts, and what goes wrong if you remove each one.

**Extra (1 pt)**: a real bug hunt  
- `isAimedAtHub()` is `hasTarget() && Math.abs(getAngleToHubDegrees()) < AIM_TOLERANCE_DEGREES`, and `getAngleToHubDegrees()` returns `0` whenever the pose estimate gets rejected. Suppose the robot already had a valid target speed, and then the camera sees a tag but its estimate is thrown out as too ambiguous. **What does the robot do?** Propose a fix. *(This comes from reading the code; confirm it on the robot before calling it a bug.)*

---

## 🏆 Total Points
- **Max:** 6 pts  
  - Java‑Only: 2 pts  
  - Robot Code: 2 pts  
  - Code Archaeology: 2 pts *(optional)*

---

<!-- Drafting notes from the transcript draft. Hidden from students.
Ideas:
- Weather example → fun intro to `&&`, `||`, `!`.  
- Robot code: combine multiple safety checks with logical operators.  
- Archaeology: simplify nested conditions with `&&` and `||`.  
- Segue: Next lesson could cover **while loops** (repeating conditions).  
-->
