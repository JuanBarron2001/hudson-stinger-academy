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
- Generate a random integer using `nextInt()`.  
- Print the result.  

**Extra (1 pt)**  
- Generate random integers within a range (e.g., 1–6 for dice).  
- Generate multiple random integers (simulate rolling 3 dice).  
- Generate a random double with `nextDouble()` (0.0–1.0).  
- Generate a random boolean with `nextBoolean()` (simulate coin flip).  
- Use an `if` statement to print `"Heads"` or `"Tails"` based on the boolean.  

---

## 🤖 Part 2 – Robot Code (2 pts)

**Basic (1 pt)**  
- Use `Random` to simulate sensor noise or unpredictable input.  
- Example: Add a small random offset to joystick input before sending to motors.  

**Extra (1 pt)**  
- Simulate randomized autonomous behavior:  
  - Randomly choose between two paths.  
  - Randomly vary delay before starting a routine.  
- Print results to **SmartDashboard** for debugging.  

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
