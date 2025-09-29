# 🖥️ Lesson 21 – Variable Scope in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🐝

---

## 🎯 Overview
**Keywords:** Java, Variable Scope, Local Variables, Class Variables, Static, Methods  
Learn to:
- Understand **local scope** (variables declared inside methods or blocks)  
- Understand **class scope** (variables declared inside a class but outside methods)  
- Recognize variable shadowing when local and class variables share the same name  
- Know when to use local vs. class variables  
- Apply scope rules to avoid conflicts and bugs  

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
- Create a local variable `x = 1` inside `main()`.  
- Print it.  
- Create another method `doSomething()` with its own local variable `x = 2`.  
- Print it.  
- Call both methods and observe that each method uses its own version of `x`.  

**Extra (1 pt)**  
- Add a class variable `static int x = 3;`.  
- Delete the local variables and print `x` from both methods → result is `3`.  
- Reintroduce local variables with the same name and observe **shadowing**:  
  - Local variable takes priority over class variable.  

---

## 🤖 Part 2 – Robot Code (2 pts)

**Basic (1 pt)**  
- Create a class variable `static double motorSpeed = 0.5;`.  
- Print it from multiple methods to show class scope.  

**Extra (1 pt)**  
- Add a local variable `motorSpeed = 1.0;` inside a method.  
- Print both values to demonstrate shadowing.  
- Show how local variables can override class variables temporarily.  
- Output results to **SmartDashboard**.  

---

## 📜 Part 3 – Code Archaeology (2 pts)

**Basic (1 pt)**  
- Find a variable in last year’s robot code that was declared at the class level.  
- Explain why it needed to be accessible across multiple methods.  

**Extra (1 pt)**  
- Suggest improvements:  
  - Replace unnecessary class variables with local variables to reduce complexity.  
  - Keep constants (e.g., wheel diameter, max speed) as class variables.  
- Or write pseudo‑code for scope demonstration:  
  [CODE BLOCK]java
  static int x = 3; // class variable

  public static void main(String[] args) {
      int x = 1; // local variable
      System.out.println(x); // prints 1
      doSomething();
  }

  static void doSomething() {
      int x = 2; // local variable
      System.out.println(x); // prints 2
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
- Use analogy of houses (local variables inside, class variable outside on the street).  
- Robot code: class variable for constants like wheel diameter.  
- Archaeology: reduce overuse of class variables, prefer local scope.  
- Segue: Next lesson could cover **final variables and constants** or **object scope** in OOP.  
[CODE BLOCK]
