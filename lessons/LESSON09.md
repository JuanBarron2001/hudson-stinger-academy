# 🖥️ Lesson 09 – Nested If Statements in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🐝

---

## 🎯 Overview
**Keywords:** Java, Nested If, Boolean, Discounts, Conditions, Augmented Assignment, printf  
Learn to:
- Write `if` statements inside other `if` statements  
- Use Boolean variables to control program flow  
- Apply multiple conditions to calculate different outcomes  
- Format output with `printf` for cleaner results  
- Understand when nested logic is more effective than flat `if/else` chains  
- Build the 2026 robot's shoot-when-ready decision tree  

---

## ⏱️ Progress Tracking

### 📊 For the Marathon Watchers  
If you’re following the **full 12‑hour compilation** and want to see how far you’ve made it through the *entire* course:  
- **Start Time in 12‑Hour Video:** [02:03:47](https://www.youtube.com/watch?v=xTtL8E4LzTQ&t=7427s)  
- **Full Course (12h video):** [Watch Compilation](https://www.youtube.com/watch?v=xTtL8E4LzTQ)

---

### 🎯 For the Quick‑Hit Learners  
If you just want **this lesson only** and to be done with it — no scrubbing through hours of footage:  
- **Lesson Playlist:** [Java tutorial for beginners (2025) ☕](https://www.youtube.com/playlist?list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc)  
- **This Lesson Only:** [Watch Lesson 09](https://www.youtube.com/watch?v=23VT2wh3BG4&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=12) (Nested if statements are easy! 🎟️, 6:33)

---

## 💻 Part 1 – Java‑Only (2 pts)

**Basic (1 pt)**  
- Build the video's **movie ticket discount calculator**:
  - Create `double price = 15.00;` and two booleans, `isStudent` and `isSenior`
  - Write an `if` inside an `if`, **and** an `if` inside the `else`:
    - If `isStudent`:
      - if also `isSenior` → student + senior discount, 30% off (`price *= 0.7`)
      - else → student discount, 10% off (`price *= 0.9`)
    - Else:
      - if `isSenior` → senior discount, 20% off (`price *= 0.8`)
      - else → full price
  - Print the ticket type and final price with `printf` to 2 decimal places
  - Try all four combinations. You should see `"Student+Senior Ticket: $10.50"`, `"Student Ticket: $13.50"`, `"Senior Ticket: $12.00"` and `"Regular Ticket: $15.00"`

**Extra (1 pt)**  
- Expand with user input and more complex nesting:
  - Use `Scanner` to ask: student? and senior? (read both with `nextBoolean()`, like lesson 05), then the membership tier as a word: `BRONZE`, `SILVER`, `GOLD` or `NONE` (read it with `next()`)
  - Compare words with `.equals`, never `==`: `tier.equals("GOLD")`. A `String` is a reference type (lesson 02's IOU), so `==` asks "is this the same IOU?" instead of "are these the same letters?", and a word you read in never is. Lesson 10 covers `.equals`.
  - Build nested logic:
    - If student:
      - If also senior:
        - If GOLD member → 40% discount
        - Else if SILVER member → 35% discount
        - Else → 30% discount
      - Else (student, not senior):
        - If GOLD member → 25% discount
        - Else if SILVER member → 20% discount
        - Else → 15% discount
    - Else (not student):
      - If senior:
        - If any member tier (not `NONE`) → 25% discount
        - Else → 20% discount
      - Else → full price
  - Print a clear receipt showing discount reason and final price  

---

## 🤖 Part 2 – Robot Code: the 2026 Robot (2 pts)

Your code goes in `robot-code/command-based-bot-2026/src/main/java/frc/lesson/lesson09/basic/Lesson09.java` (and `extra/Lesson09.java`). The task list is at the top of each file.  
Run it in the simulator the way you did in [Lesson 00](./LESSON00.md). CAN IDs, inversions and buttons are in [ROBOT.md](../robot-code/command-based-bot-2026/ROBOT.md).

**Basic (1 pt)**: a shot that waits until it's ready  
- Create the **operator controller**, both **rollers** and the **conveyor**.
- Build this with an `if` **inside** an `if`:
  - If **A** is held: run the rollers at your lesson 07 power, then
    - if the rollers are at speed → conveyor `-0.7`, status `"FEEDING"`
    - else → conveyor `-0.05` to hold the ball back, status `"SPINNING UP"`
  - Else → stop everything, status `"STOPPED"`
- Put the status and the roller speed on SmartDashboard.
- Tap **A** and let go quickly. Does the conveyor ever feed? Why or why not?

**Extra (1 pt)**: don't shoot blind  
- Inside "A is held", nest two more checks, in this order: **target seen?** → **aimed?** → **at speed?** Only `"FEEDING"` runs the conveyor. The other statuses, `"NO TARGET"`, `"AIMING"` and `"SPINNING UP"`, hold it back.
- **At home** there's no camera, so pretend: operator **X** held (**7** key) means "the Limelight sees the hub", and **Y** held (**8** key) means "we're aimed".
- **At a meeting**, swap in the real camera: `LimelightHelpers.getTV("limelight")` for target seen, and `Math.abs(LimelightHelpers.getTX("limelight")) < 1.5` for aimed.
- Should the rollers already spin up while the status is `"NO TARGET"`? Decide, and explain in a comment.

---

## 📜 Part 3 – Code Archaeology (2 pts, optional)

> *Optional: skip this part if you're short on time.* Last season's code is [`Hudson-Robotics/OG-Code-2026`](https://github.com/Hudson-Robotics/OG-Code-2026), branch **`Pre-DCMP-Flywheel`**.

**Basic (1 pt)**  
- Draw the decision tree in `AlignAndShoot.java`'s `execute()`. Boxes and arrows on paper are fine, or indented text in a comment.

**Extra (1 pt)**  
- `AlignAndShoot` handles "no target" with an early `return` instead of nesting everything inside an `if`. Rewrite its logic as nested `if`s in pseudo-code. Which version is easier to read, and why?

---

## 🏆 Total Points
- **Max:** 6 pts  
  - Java‑Only: 2 pts  
  - Robot Code: 2 pts  
  - Code Archaeology: 2 pts *(optional)*

---

<!-- Drafting notes from the transcript draft. Hidden from students.
Ideas:
- Movie ticket discount example → relatable intro.  
- Robot code: nested safety checks (battery, arm, shooter).  
- Archaeology: simplify nested ifs with logical operators.  
- Segue: Next lesson could cover logical operators (`&&`, `||`, `!`) as an alternative to nesting.  
-->
