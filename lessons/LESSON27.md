# 🖥️ Lesson 27 – Objects & Classes in Java (Intro to OOP)

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🐝

---

## 🎯 Overview
**Keywords:** Java, Object-Oriented Programming, Objects, Classes, Attributes, Methods, Dot Operator  
Learn to:
- Understand what an **object** is (real-world entity in code)  
- Recognize **attributes** (things an object has) and **methods** (things an object can do)  
- Create a **class** as a blueprint for objects  
- Instantiate objects using the `new` keyword  
- Access and modify attributes with the **dot operator**  
- Call methods to perform actions  

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
- Create a `Car` class with attributes:  
  - `String make`  
  - `String model`  
  - `int year`  
  - `double price`  
  - `boolean isRunning`  

[CODE BLOCK]java
public class Car {
    String make = "Ford";
    String model = "Mustang";
    int year = 2025;
    double price = 58000.99;
    boolean isRunning = false;
}
[CODE BLOCK]

- In `main()`, create a `Car` object and print its attributes using the dot operator.  

**Extra (1 pt)**  
- Add methods to the `Car` class:  

[CODE BLOCK]java
void start() {
    isRunning = true;
    System.out.println("You start the engine");
}

void stop() {
    isRunning = false;
    System.out.println("You stop the engine");
}

void drive() {
    System.out.println("You drive the " + model);
}

void brake() {
    System.out.println("You brake the " + model);
}
[CODE BLOCK]

- Call these methods from `main()` and print `isRunning` before and after.  

---

## 🤖 Part 2 – Robot Code (2 pts)

**Basic (1 pt)**  
- Create a `Robot` class with attributes:  
  - `String name`  
  - `boolean isActive`  

- Add methods: `activate()`, `deactivate()`, and `move()`.  

**Extra (1 pt)**  
- Instantiate two robots and demonstrate that each has its own attributes.  
- Show how calling `activate()` changes only that robot’s state.  
- Print results to **SmartDashboard**.  

---

## 📜 Part 3 – Code Archaeology (2 pts)

**Basic (1 pt)**  
- Find a section of last year’s robot code where repeated variables represented the same concept (e.g., multiple motor controllers).  
- Suggest replacing them with a **class** to encapsulate attributes and methods.  

**Extra (1 pt)**  
- Suggest improvements:  
  - Replace procedural code with object-oriented design.  
  - Example: instead of separate functions for each motor, create a `Motor` class with `start()`, `stop()`, and `setSpeed()`.  

[CODE BLOCK]java
public class Motor {
    double speed;
    boolean isRunning;

    void start() { isRunning = true; }
    void stop() { isRunning = false; }
    void setSpeed(double s) { speed = s; }
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
- Objects = entities with attributes + methods.  
- Robot code: encapsulate robot parts as objects.  
- Archaeology: replace repeated code with classes.  
- Segue: Next lesson → **Constructors** (to create unique objects with custom attributes).  
[CODE BLOCK]
