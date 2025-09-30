# 🖥️ Lesson 37 – Interfaces in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🐝  

---

## 🎯 Overview
**Keywords:** Java, Interfaces, Multiple Inheritance, Abstract Methods, Implements  
Learn to:
- Understand that an **interface** is a blueprint for a class  
- Recognize that interfaces contain **abstract methods** (no body, just signatures)  
- Implement interfaces in classes, which forces those classes to define the methods  
- Achieve **multiple inheritance–like behavior** by implementing more than one interface  
- Differentiate between **abstract classes** and **interfaces**  

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
- Create two interfaces:  

[CODE BLOCK]java
public interface Prey {
    void flee();
}

public interface Predator {
    void hunt();
}
[CODE BLOCK]

- Create a `Rabbit` class that implements `Prey`:  

[CODE BLOCK]java
public class Rabbit implements Prey {
    @Override
    public void flee() {
        System.out.println("The rabbit is running away!");
    }
}
[CODE BLOCK]

- Create a `Hawk` class that implements `Predator`:  

[CODE BLOCK]java
public class Hawk implements Predator {
    @Override
    public void hunt() {
        System.out.println("The hawk is hunting!");
    }
}
[CODE BLOCK]

**Extra (1 pt)**  
- Create a `Fish` class that implements **both** `Prey` and `Predator`:  

[CODE BLOCK]java
public class Fish implements Prey, Predator {
    @Override
    public void flee() {
        System.out.println("The fish is swimming away!");
    }

    @Override
    public void hunt() {
        System.out.println("The fish is hunting smaller fish!");
    }
}
[CODE BLOCK]

- Demonstrate usage:  

[CODE BLOCK]java
Rabbit rabbit = new Rabbit();
Hawk hawk = new Hawk();
Fish fish = new Fish();

rabbit.flee(); // The rabbit is running away!
hawk.hunt();   // The hawk is hunting!
fish.flee();   // The fish is swimming away!
fish.hunt();   // The fish is hunting smaller fish!
[CODE BLOCK]

---

## 🤖 Part 2 – Robot Code (2 pts)

**Basic (1 pt)**  
- Create two interfaces:  
  - `Controllable` with method `start()`  
  - `Monitorable` with method `status()`  

**Extra (1 pt)**  
- Create classes that implement these interfaces:  
  - `Motor` implements `Controllable`  
  - `Sensor` implements `Monitorable`  
  - `SmartSubsystem` implements **both** `Controllable` and `Monitorable`  

[CODE BLOCK]java
public interface Controllable {
    void start();
}

public interface Monitorable {
    void status();
}

public class Motor implements Controllable {
    @Override
    public void start() {
        System.out.println("Motor started");
    }
}

public class Sensor implements Monitorable {
    @Override
    public void status() {
        System.out.println("Sensor is active");
    }
}

public class SmartSubsystem implements Controllable, Monitorable {
    @Override
    public void start() {
        System.out.println("Subsystem started");
    }

    @Override
    public void status() {
        System.out.println("Subsystem status: OK");
    }
}
[CODE BLOCK]

---

## 📜 Part 3 – Code Archaeology (2 pts)

**Basic (1 pt)**  
- Find a section of last year’s robot code where multiple classes had similar methods but no shared parent.  
- Suggest replacing them with an **interface** to enforce consistency.  

**Extra (1 pt)**  
- Suggest improvements:  
  - Define a `Monitorable` interface for all subsystems that can report status.  
  - Define a `Controllable` interface for all subsystems that can be started/stopped.  
  - This ensures every subsystem implements the same method signatures.  

[CODE BLOCK]java
public interface Monitorable {
    void status();
}

public class DriveTrain implements Monitorable {
    @Override
    public void status() {
        System.out.println("DriveTrain status: OK");
    }
}

public class Arm implements Monitorable {
    @Override
    public void status() {
        System.out.println("Arm status: OK");
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
- Emphasize that interfaces = contracts (classes must implement methods).  
- Robot code: use interfaces for subsystems to enforce consistent behavior.  
- Archaeology: replace repeated method signatures with interfaces.  
- Segue: Next lesson → **Polymorphism with Interfaces** (treating different objects through a common interface type).  
[CODE BLOCK]
