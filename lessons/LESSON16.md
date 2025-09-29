# 🖥️ Lesson 16 – For Loops in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🐝

---

## 🎯 Overview
**Keywords:** Java, For Loop, Iteration, Counter, Index, Scanner, Countdown, Thread.sleep  
Learn to:
- Understand the structure of a `for` loop (initialization, condition, update)  
- Use a counter variable (`i`) to control loop iterations  
- Increment, decrement, or step by custom values  
- Accept user input to control loop length  
- Build a countdown mini‑project with `Thread.sleep()` for timing  

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
- Write a `for` loop that prints `"Pizza"` 10 times.  
- Print the loop index `i` to show iteration counts.  

**Extra (1 pt)**  
- Experiment with:  
  - Starting at 1 and looping to 10 (`i = 1; i <= 10; i++`)  
  - Decrementing from 10 down to 1 (`i = 10; i > 0; i--`)  
  - Incrementing by 2 or 3 (`i += 2`, `i += 3`)  
- Accept user input with `Scanner` for how many times to loop.  

---

## 🤖 Part 2 – Robot Code (2 pts)

**Basic (1 pt)**  
- Use a `for` loop to repeat a robot action a fixed number of times.  
- Example: blink an LED 5 times.  

**Extra (1 pt)**  
- Create a countdown timer for robot startup:  
  - Start at a given number of seconds.  
  - Decrement each second using `Thread.sleep(1000)`.  
  - Print `"System Ready!"` at the end.  
- Display countdown progress on **SmartDashboard**.  

---

## 📜 Part 3 – Code Archaeology (2 pts)

**Basic (1 pt)**  
- Find a repeated action in last year’s robot code (e.g., running a motor test multiple times).  
- Explain how a `for` loop could simplify it.  

**Extra (1 pt)**  
- Suggest improvements:  
  - Replace copy‑pasted code with a `for` loop.  
  - Use a loop to iterate through an array of motors or sensors.  
- Or write pseudo‑code for a countdown:  
  [CODE BLOCK]java
  for (int i = start; i > 0; i--) {
      System.out.println(i);
      Thread.sleep(1000);
  }
  System.out.println("Happy New Year!");
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
- Show difference between `for` and `while` loops.  
- Robot code: loop through motors or LEDs for testing.  
- Archaeology: replace repeated code blocks with a loop.  
- Segue: Next lesson could cover **nested loops** for grids or patterns.  
[CODE BLOCK]
