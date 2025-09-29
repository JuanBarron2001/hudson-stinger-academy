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
- Create a `String[] fruits = {"Apple", "Orange", "Banana", "Coconut"};`  
- Print each element by accessing its index (`fruits[0]`, `fruits[1]`, etc.).  
- Demonstrate what happens if you try to access an invalid index.  

**Extra (1 pt)**  
- Use a `for` loop with `fruits.length` to print all elements.  
- Use an **enhanced for loop** (`for (String fruit : fruits)`) to simplify iteration.  
- Modify an element (e.g., change `"Apple"` to `"Pineapple"`) and print the updated array.  

---

## 🤖 Part 2 – Robot Code (2 pts)

**Basic (1 pt)**  
- Create an array of motor speeds: `double[] speeds = {0.5, 0.7, 1.0};`  
- Print each motor speed using a loop.  

**Extra (1 pt)**  
- Use `Arrays.sort()` to sort sensor readings in ascending order.  
- Use `Arrays.fill()` to reset all motor speeds to `0.0`.  
- Print results to **SmartDashboard**.  

---

## 📜 Part 3 – Code Archaeology (2 pts)

**Basic (1 pt)**  
- Find an array in last year’s robot code (e.g., storing joystick button states).  
- Explain how it was used and why an array was chosen.  

**Extra (1 pt)**  
- Suggest improvements:  
  - Replace repeated variables with an array for cleaner code.  
  - Use enhanced for loops for readability.  
- Or write pseudo‑code for iterating through motor controllers:  
  [CODE BLOCK]java
  for (int i = 0; i < motors.length; i++) {
      System.out.println("Motor " + i + " speed: " + motors[i]);
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
- Show `.length` property for dynamic iteration.  
- Robot code: arrays for motor speeds or sensor values.  
- Archaeology: replace multiple joystick variables with an array.  
- Segue: Next lesson could cover **2D arrays** (matrices) since nested loops pair well with them.  
[CODE BLOCK]
