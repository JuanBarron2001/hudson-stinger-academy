# 🖥️ Lesson 38 – Polymorphism in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🐝  

---

## 🎯 Overview
**Keywords:** Java, Polymorphism, Inheritance, Interfaces, Abstract Classes, Method Overriding  
Learn to:
- Understand **polymorphism**: “many shapes” → objects can be treated as their own type or as a parent type  
- Use **abstract classes** and **interfaces** to achieve polymorphism  
- Store different child objects in a single array of their **common parent type**  
- Call overridden methods dynamically at runtime (dynamic dispatch)  
- Recognize that polymorphism supports **flexibility and code reusability**  

---

## ⏱️ Progress Tracking

### 📊 For the Marathon Watchers  
If you’re following the **full 12‑hour compilation** and want to see how far you’ve made it through the *entire* course:  
- **Start Time in 12‑Hour Video:** [08:07:44](https://www.youtube.com/watch?v=xTtL8E4LzTQ&t=29264s)  
- **Full Course (12h video):** [Watch Compilation](https://www.youtube.com/watch?v=xTtL8E4LzTQ)

---

### 🎯 For the Quick‑Hit Learners  
If you just want **this lesson only** and to be done with it — no scrubbing through hours of footage:  
- **Lesson Playlist:** [Java tutorial for beginners (2025) ☕](https://www.youtube.com/playlist?list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc)  
- **This Lesson Only:** [Watch Lesson 38](https://www.youtube.com/watch?v=6xRd0j1anzc&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=50) (Learn POLYMORPHISM in 6 minutes! 🎭, 6:46)

---

## 💻 Part 1 – Java‑Only (2 pts)

> Each class gets its own file next to `Main.java`, starting with the same `package` line, like lesson 27 (`package lesson38.basic;`, and `package lesson38.extra;` for the extra's copies).

**Basic (1 pt)**  
- Create an abstract parent class `Vehicle` with an abstract method `go()`.  

```java
public abstract class Vehicle {
    abstract void go();
}
```

- Create child classes `Car`, `Bike`, and `Boat` that extend `Vehicle` and override `go()`.  

```java
public class Car extends Vehicle {
    @Override
    void go() {
        System.out.println("You drive the car");
    }
}

public class Bike extends Vehicle {
    @Override
    void go() {
        System.out.println("You ride the bike");
    }
}

public class Boat extends Vehicle {
    @Override
    void go() {
        System.out.println("You sail the boat");
    }
}
```

- First try the video's mistake: `Car[] cars = { new Car(), new Bike(), new Boat() };`. Read the error: a bike isn't a car. Then find the one type they all share.  
- Demonstrate polymorphism with an array of `Vehicle`:  

```java
Vehicle[] vehicles = { new Car(), new Bike(), new Boat() };

for (Vehicle v : vehicles) {
    v.go(); // dynamic dispatch
}
```

**Extra (1 pt)**  
- Achieve polymorphism with an **interface** instead of an abstract class:  

```java
public interface Vehicle {
    public void go();
}

public class Car implements Vehicle {
    @Override
    public void go() {
        System.out.println("You drive the car");
    }
}
```

- Change `Bike` and `Boat` the same way (`implements Vehicle`, and `public void go()`).  
- Run the same `Vehicle[]` loop in `main`. It shouldn't need a single change: code written against `Vehicle` works whether `Vehicle` is an abstract class or an interface.  

---

## 🤖 Part 2 – Robot Code (2 pts)

**Basic (1 pt)**  
- Create an abstract class `Subsystem` with an abstract method `run()`.  
- Create child classes `DriveTrain`, `Arm`, and `Shooter` that override `run()`.  

**Extra (1 pt)**  
- Store them in an array of `Subsystem` and loop through to call `run()`.  
- Print results to **SmartDashboard**.  

```java
public abstract class Subsystem {
    abstract void run();
}

public class DriveTrain extends Subsystem {
    @Override
    void run() {
        SmartDashboard.putString("DriveTrain", "Driving forward");
    }
}

public class Arm extends Subsystem {
    @Override
    void run() {
        SmartDashboard.putString("Arm", "Lifting object");
    }
}

public class Shooter extends Subsystem {
    @Override
    void run() {
        SmartDashboard.putString("Shooter", "Shooting ball");
    }
}

// Demo
Subsystem[] subsystems = { new DriveTrain(), new Arm(), new Shooter() };
for (Subsystem s : subsystems) {
    s.run();
}
```

---

## 📜 Part 3 – Code Archaeology (2 pts)

**Basic (1 pt)**  
- Find a section of last year’s robot code where different subsystems had unique methods but no shared parent.  
- Suggest replacing them with a **common abstract class or interface**.  

**Extra (1 pt)**  
- Suggest improvements:  
  - Define a `Subsystem` interface with `run()`.  
  - Each subsystem implements it with its own behavior.  
  - Store all subsystems in a single array and loop through them polymorphically.  

```java
public interface Subsystem {
    void run();
}

public class Climber implements Subsystem {
    @Override
    public void run() {
        System.out.println("Climber ascending");
    }
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
- Emphasize polymorphism = treating different objects as one common type.  
- Robot code: subsystems polymorphically run in a loop.  
- Archaeology: replace repeated subsystem calls with polymorphic arrays.  
- Segue: Next lesson → **Dynamic Binding & Casting** (downcasting, `instanceof`, runtime type checks).  
-->
