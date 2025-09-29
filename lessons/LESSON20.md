# 🖥️ Lesson 20 – Overloaded Methods in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🐝

---

## 🎯 Overview
**Keywords:** Java, Overloaded Methods, Method Signature, Parameters, Arguments, Reusability  
Learn to:
- Understand what overloaded methods are  
- Recognize that a **method signature** = method name + parameter list  
- Write multiple methods with the same name but different parameters  
- Use overloaded methods for flexibility (e.g., math operations, pizza builder)  
- Avoid duplicate signatures (which cause compile errors)  

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
- Create an `add` method that takes two `double` parameters and returns their sum.  
- Call it with `1` and `2` → output should be `3`.  

**Extra (1 pt)**  
- Overload the `add` method to accept three and four parameters.  
- Call each version and print results.  
- Demonstrate that methods with the same name but different parameter lists are valid.  

---

## 🤖 Part 2 – Robot Code (2 pts)

**Basic (1 pt)**  
- Create an overloaded method `setMotorSpeed`:  
  - One version accepts a single speed value.  
  - Another version accepts left and right speeds separately.  

**Extra (1 pt)**  
- Add a third overload that accepts an array of motor speeds and sets each motor accordingly.  
- Print results to **SmartDashboard**.  

---

## 📜 Part 3 – Code Archaeology (2 pts)

**Basic (1 pt)**  
- Find a place in last year’s robot code where multiple methods with similar names existed (e.g., `driveForwardOneMotor`, `driveForwardTwoMotors`).  
- Suggest how overloading could simplify them into one method name with different parameters.  

**Extra (1 pt)**  
- Write pseudo‑code for an overloaded `bakePizza` method:  
  [CODE BLOCK]java
  static String bakePizza(String bread) {
      return bread + " pizza";
  }

  static String bakePizza(String bread, String cheese) {
      return cheese + " " + bread + " pizza";
  }

  static String bakePizza(String bread, String cheese, String topping) {
      return topping + " " + cheese + " " + bread + " pizza";
  }
  [CODE BLOCK]  
- Show how calling each version produces different results.  

---

## 🏆 Total Points
- **Max:** 6 pts  
  - Java‑Only: 2 pts  
  - Robot Code: 2 pts  
  - Code Archaeology: 2 pts

---

[CODE BLOCK]LOG
Ideas:
- Math example (`add`) → simple intro to overloading.  
- Pizza example → fun, real‑world analogy.  
- Robot code: overloaded methods for motor control.  
- Archaeology: replace multiple similar methods with one overloaded method.  
- Segue: Next lesson could cover **variable scope** or **access modifiers**.  
[CODE BLOCK]
