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
- **Start Time in 12‑Hour Video:** [blank]  
- **Full Course (12h video):** [link here]  

---

### 🎯 For the Quick‑Hit Learners  
- **Lesson Playlist:** [link here]  
- **This Lesson Only:** [link here]  

---

## 💻 Part 1 – Java‑Only (2 pts)

**Basic (1 pt)**  
- Create an abstract parent class `Vehicle` with an abstract method `go()`.  

[CODE BLOCK]java
public abstract class Vehicle {
    abstract void go();
}
[CODE BLOCK]

- Create child classes `Car`, `Bike`, and `Boat` that extend `Vehicle` and override `go()`.  

[CODE BLOCK]java
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
[CODE BLOCK]

- Demonstrate polymorphism with an array of `Vehicle`:  

[CODE BLOCK]java
Vehicle[] vehicles = { new Car(), new Bike(), new Boat() };

for (Vehicle v : vehicles) {
    v.go(); // dynamic dispatch
}
[CODE BLOCK]

**Extra (1 pt)**  
- Achieve polymorphism with an **interface** instead of an abstract class:  

[CODE BLOCK]java
public interface Vehicle {
    public void go();
}

public class Car implements Vehicle {
    @Override
    public void go() {
        System.out.println("You drive the car");
    }
}
[CODE BLOCK]

---

## 🤖 Part 2 – Robot Code (2 pts)

**Basic (1 pt)**  
- Create an abstract class `Subsystem` with an abstract method `run()`.  
- Create child classes `DriveTrain`, `Arm`, and `Shooter` that override `run()`.  

**Extra (1 pt)**  
- Store them in an array of `Subsystem` and loop through to call `run()`.  
- Print results to **SmartDashboard**.  

[CODE BLOCK]java
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
[CODE BLOCK]

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

[CODE BLOCK]java
public interface Subsystem {
    void run();
}

public class Climber implements Subsystem {
    @Override
    public void run() {
        System.out.println("Climber ascending");
    }
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
- Emphasize polymorphism = treating different objects as one common type.  
- Robot code: subsystems polymorphically run in a loop.  
- Archaeology: replace repeated subsystem calls with polymorphic arrays.  
- Segue: Next lesson → **Dynamic Binding & Casting** (downcasting, `instanceof`, runtime type checks).  
[CODE BLOCK]
