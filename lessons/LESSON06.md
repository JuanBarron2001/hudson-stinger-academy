# 🖥️ Lesson 06 – Random Numbers in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🐝

---

## 🎯 Overview
**Keywords:** Java, Random Class, nextInt, nextDouble, nextBoolean, Dice Roll, Coin Flip  
Learn to:
- Import and create a `Random` object  
- Generate random integers within a range  
- Generate multiple random values (simulate dice rolls)  
- Generate random doubles between 0.0 and 1.0  
- Generate random booleans (simulate coin flips)  
- Apply randomness to robot code for testing or simulation  

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
- Import `java.util.Random`.  
- Create a `Random` object.  
- Roll a single 6-sided die using `nextInt(6) + 1`.  
- Print the result.  
- Bonus: Roll the die 5 times and print each result (call the roll 5 times or use a loop).

**Extra (1 pt)**  
- Build a simple dice game:
  - Prompt the user to pick a **target number between 3 and 18** using `Scanner`.
  - Use `nextBoolean()` to flip a coin (randomly determine win condition).
    - If heads → user wins if the **3-die sum is ABOVE their target**.
    - If tails → user wins if the **3-die sum is BELOW their target**.
  - Roll **3 six-sided dice** and calculate the sum.
  - Compare the sum to the target and print whether the user won or lost.
  - Example: User picks 10, coin flip is "heads" (need above 10), roll 3 dice → sum is 13 → **WIN!**  

---

## 🤖 Part 2 – Robot Code (2 pts)

**Basic (1 pt)**  
- Use `Random` to generate a **target AprilTag ID** (1–16) **once at robot startup**.  
- Store this ID in a variable.  
- Use Limelight to continuously search for that specific tag during operation.  
- Print the target tag ID and current Limelight detection status to **SmartDashboard**.  
- **Key insight:** Randomness is used only at initialization; runtime behavior is deterministic and predictable.

**Extra (1 pt)**  
- Expand the scenario with robot personality:
  - Use `nextBoolean()` to randomly determine robot **behavior** at startup:
    - If true → **Attracted mode** — robot is drawn to the target tag (follow it).
    - If false → **Scared mode** — robot runs away from the target tag (move opposite direction).
  - Use Limelight `tx` (horizontal offset) to implement the selected behavior:
    - Attracted: Turn toward the tag (positive motor speed when tx > 0)
    - Scared: Turn away from the tag (negative motor speed when tx > 0)
  - Print behavior mode, target tag ID, offset, and detection status to **SmartDashboard** for debugging.
  - Test by running the robot multiple times and observing it either chase or flee based on random startup selection.  

---

## 📜 Part 3 – Code Archaeology (2 pts)

**Basic (1 pt)**  
- Find a place in last year’s robot code where randomness could have been useful (e.g., testing robustness by simulating noisy sensor input).  
- Explain why adding randomness might help.  

**Extra (1 pt)**  
- Suggest improvements:  
  - Use randomness to stress‑test algorithms.  
  - Simulate coin‑flip logic for decision‑making in autonomous mode.  
- Or write pseudo‑code for a random decision:  
  [CODE BLOCK]java
  if (random.nextBoolean()) {
      driveLeft();
  } else {
      driveRight();
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
- Show dice roll simulation as a fun intro.  
- Robot code: add random delay before shooting to simulate real‑world timing.  
- Archaeology: propose using randomness to test PID tuning under noisy conditions.  
- Segue: Next lesson could cover loops → repeat random trials automatically.  
[CODE BLOCK]
