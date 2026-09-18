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
If you’re following the **full 12‑hour compilation** and want to see how far you’ve made it through the *entire* course:  
- **Start Time in 12‑Hour Video:** [06:41:47](https://www.youtube.com/watch?v=xTtL8E4LzTQ&t=24107s)  
- **Full Course (12h video):** [Watch Compilation](https://www.youtube.com/watch?v=xTtL8E4LzTQ)

---

### 🎯 For the Quick‑Hit Learners  
If you just want **this lesson only** and to be done with it — no scrubbing through hours of footage:  
- **Lesson Playlist:** [Java tutorial for beginners (2025) ☕](https://www.youtube.com/playlist?list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc)  
- **This Lesson Only:** [Watch Lesson 27](https://www.youtube.com/watch?v=DYbi93vuSaU&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=39) (Learn Java Object Oriented Programming in 10 minutes! 🧱, 9:51)

---

## 💻 Part 1 – Java‑Only (2 pts)

> **Where a new class goes.** Make a new file next to your `Main.java`: `java-lessons/src/lesson27/basic/Car.java`. Its first line must be `package lesson27.basic;`, the same as `Main.java`, or `Main` can't find it. The extra half lives in a different folder, so it needs its own `Car.java` that starts with `package lesson27.extra;`. Copy your basic one over and change that line.

**Basic (1 pt)**  
- Create a `Car` class with attributes:  
  - `String make`  
  - `String model`  
  - `int year`  
  - `double price`  
  - `boolean isRunning`  

```java
public class Car {
    String make = "Ford";
    String model = "Mustang";
    int year = 2025;
    double price = 58000.99;
    boolean isRunning = false;
}
```

- In `main()`, create a `Car` object and print its attributes using the dot operator.  

**Extra (1 pt)**  
- Add methods to the `Car` class:  

```java
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
```

- Call these methods from `main()` and print `isRunning` before and after.  
- Change an attribute straight from `main` with the dot operator: `car.isRunning = true;`  
- Create a **second** `Car` and print its make and model. Why is it exactly the same as the first one? Lesson 28's constructors fix that.  

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

```java
public class Motor {
    double speed;
    boolean isRunning;

    void start() { isRunning = true; }
    void stop() { isRunning = false; }
    void setSpeed(double s) { speed = s; }
}
```

---

## 🏆 Total Points
- **Max:** 6 pts  
  - Java‑Only: 2 pts  
  - Robot Code: 2 pts  
  - Code Archaeology: 2 pts  

---

<!-- Drafting notes from the transcript draft. Hidden from students.
Ideas:
- Objects = entities with attributes + methods.  
- Robot code: encapsulate robot parts as objects.  
- Archaeology: replace repeated code with classes.  
- Segue: Next lesson → **Constructors** (to create unique objects with custom attributes).  
-->
