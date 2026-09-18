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
If you’re following the **full 12‑hour compilation** and want to see how far you’ve made it through the *entire* course:  
- **Start Time in 12‑Hour Video:** [08:01:30](https://www.youtube.com/watch?v=xTtL8E4LzTQ&t=28890s)  
- **Full Course (12h video):** [Watch Compilation](https://www.youtube.com/watch?v=xTtL8E4LzTQ)

---

### 🎯 For the Quick‑Hit Learners  
If you just want **this lesson only** and to be done with it — no scrubbing through hours of footage:  
- **Lesson Playlist:** [Java tutorial for beginners (2025) ☕](https://www.youtube.com/playlist?list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc)  
- **This Lesson Only:** [Watch Lesson 37](https://www.youtube.com/watch?v=c2sTQk9opO8&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=49) (Learn INTERFACES in 6 minutes! 📋, 6:16)

---

## 💻 Part 1 – Java‑Only (2 pts)

> Every interface and class gets its own file next to `Main.java`, starting with the same `package` line, like lesson 27: `Prey.java`, `Predator.java`, `Rabbit.java` and so on all start with `package lesson37.basic;` (and `package lesson37.extra;` for the extra's copies).

**Basic (1 pt)**  
- Create two interfaces:  

```java
public interface Prey {
    void flee();
}

public interface Predator {
    void hunt();
}
```

- Create a `Rabbit` class that implements `Prey`:  

```java
public class Rabbit implements Prey {
    @Override
    public void flee() {
        System.out.println("The rabbit is running away!");
    }
}
```

- Create a `Hawk` class that implements `Predator`:  

```java
public class Hawk implements Predator {
    @Override
    public void hunt() {
        System.out.println("The hawk is hunting!");
    }
}
```

- In `main()`, create a `Rabbit` and a `Hawk`, and call `rabbit.flee()` and `hawk.hunt()`. A rabbit has no `hunt()` and a hawk has no `flee()`.  
- Delete the word `public` from the rabbit's `flee()` and read the error. An interface's methods are always public, so the class that fills them in has to keep them public. Put it back.  

**Extra (1 pt)**  
- Create a `Fish` class that implements **both** `Prey` and `Predator`:  

```java
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
```

- Demonstrate usage:  

```java
Rabbit rabbit = new Rabbit();
Hawk hawk = new Hawk();
Fish fish = new Fish();

rabbit.flee(); // The rabbit is running away!
hawk.hunt();   // The hawk is hunting!
fish.flee();   // The fish is swimming away!
fish.hunt();   // The fish is hunting smaller fish!
```

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

```java
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
```

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

```java
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
- Emphasize that interfaces = contracts (classes must implement methods).  
- Robot code: use interfaces for subsystems to enforce consistent behavior.  
- Archaeology: replace repeated method signatures with interfaces.  
- Segue: Next lesson → **Polymorphism with Interfaces** (treating different objects through a common interface type).  
-->
