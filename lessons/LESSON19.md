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

## 🤖 Part 2 – Robot Code (2 pts)

**Basic (1 pt)**  
- Create a method `printMotorStatus()` that prints `"Motor running"` or `"Motor stopped"`.  
- Call it multiple times to simulate robot actions.  

**Extra (1 pt)**  
- Create a method `isBatterySafe(double voltage)` that returns a `boolean`.  
  - If voltage ≥ 12.0 → return `true`.  
  - Else → return `false`.  
- Use this method in an `if` statement to decide whether to enable motors.  
- Print results to **SmartDashboard**.  

---

## 📜 Part 3 – Code Archaeology (2 pts)

**Basic (1 pt)**  
- Find a repeated block of code in last year’s robot project.  
- Suggest how it could have been turned into a method for reuse.  

**Extra (1 pt)**  
- Suggest improvements:  
  - Replace repeated safety checks with a method like `isSafeToRun()`.  
  - Replace repeated string concatenations with a method like `getFullName(first, last)`.  
- Or write pseudo‑code for an age check method:  
  [CODE BLOCK]java
  static boolean ageCheck(int age) {
      return age >= 18;
  }

  if (ageCheck(userAge)) {
      System.out.println("You may sign up");
  } else {
      System.out.println("You must be 18+ to sign up");
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
- Show Happy Birthday example → fun intro to methods.  
- Robot code: method for battery safety check.  
- Archaeology: replace repeated code with reusable methods.  
- Segue: Next lesson could cover **method overloading** (same method name, different parameters).  
[CODE BLOCK]
