# 🖥️ Lesson 34 – Method Overriding in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🐝  

---

## 🎯 Overview
**Keywords:** Java, Method Overriding, Inheritance, @Override Annotation, Polymorphism  
Learn to:
- Understand **method overriding**: when a subclass provides its own implementation of a method inherited from a parent class  
- Recognize that the child’s version takes precedence over the parent’s version  
- Use the `@Override` annotation to ensure correctness and avoid mistakes  
- Apply overriding to give **specific behavior** to different subclasses  
- See how overriding supports **polymorphism** (same method name, different behavior depending on the object)  

---

## ⏱️ Progress Tracking

### 📊 For the Marathon Watchers  
If you’re following the **full 12‑hour compilation** and want to see how far you’ve made it through the *entire* course:  
- **Start Time in 12‑Hour Video:** [07:41:37](https://www.youtube.com/watch?v=xTtL8E4LzTQ&t=27697s)  
- **Full Course (12h video):** [Watch Compilation](https://www.youtube.com/watch?v=xTtL8E4LzTQ)

---

### 🎯 For the Quick‑Hit Learners  
If you just want **this lesson only** and to be done with it — no scrubbing through hours of footage:  
- **Lesson Playlist:** [Java tutorial for beginners (2025) ☕](https://www.youtube.com/playlist?list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc)  
- **This Lesson Only:** [Watch Lesson 34](https://www.youtube.com/watch?v=hx_DRanBRRM&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=46) (Learn Java METHOD OVERRIDING in 4 minutes! ♻️, 4:33)

---

## 💻 Part 1 – Java‑Only (2 pts)

> Each class gets its own file next to `Main.java`, starting with the same `package` line, like lesson 27 (`package lesson34.basic;`, and `package lesson34.extra;` for the extra's copies).

**Basic (1 pt)**  
- Create a parent class `Animal` with a `move()` method.  

```java
public class Animal {
    void move() {
        System.out.println("This animal is running");
    }
}
```

- Create child classes `Dog`, `Cat`, and `Fish` that extend `Animal`.  
- By default, they inherit the `move()` method.  
- In `main()`, create a `Dog`, a `Cat` and a `Fish`, and call `move()` on each. All three are "running", which is wrong for a fish.  

**Extra (1 pt)**  
- Override the `move()` method in the `Fish` class to provide a unique implementation.  

```java
public class Fish extends Animal {
    @Override
    void move() {
        System.out.println("This animal is swimming");
    }
}
```

- Demonstrate:  

```java
Dog dog = new Dog();
Cat cat = new Cat();
Fish fish = new Fish();

dog.move();  // "This animal is running"
cat.move();  // "This animal is running"
fish.move(); // "This animal is swimming"
```

- Now misspell the override as `void moves()`, keeping `@Override` above it, and read the error. Without `@Override`, Java would quietly add a new method, and the fish would go back to running with no warning. Fix the spelling.  

---

## 🤖 Part 2 – Robot Code (2 pts)

**Basic (1 pt)**  
- Create a parent class `Subsystem` with a method `activate()`.  

```java
public class Subsystem {
    void activate() {
        System.out.println("Subsystem activated");
    }
}
```

- Create child classes `DriveTrain`, `Arm`, and `Shooter` that extend `Subsystem`.  

**Extra (1 pt)**  
- Override `activate()` in each child to provide unique behavior.  
- Print results to **SmartDashboard**.  

```java
public class DriveTrain extends Subsystem {
    @Override
    void activate() {
        SmartDashboard.putString("DriveTrain", "DriveTrain moving forward");
    }
}

public class Arm extends Subsystem {
    @Override
    void activate() {
        SmartDashboard.putString("Arm", "Arm lifting");
    }
}

public class Shooter extends Subsystem {
    @Override
    void activate() {
        SmartDashboard.putString("Shooter", "Shooter firing");
    }
}
```

---

## 📜 Part 3 – Code Archaeology (2 pts)

**Basic (1 pt)**  
- Find a section of last year’s robot code where multiple subsystems had similar methods with different names (e.g., `driveForward()`, `armUp()`, `shootBall()`).  
- Suggest replacing them with a common parent method (`activate()`) and overriding it in each subsystem.  

**Extra (1 pt)**  
- Suggest improvements:  
  - Use `@Override` to ensure correct method signatures.  
  - Centralize shared logic in the parent class.  
  - Let each child provide its own unique implementation.  

```java
Subsystem[] subsystems = { new DriveTrain(), new Arm(), new Shooter() };

for (Subsystem s : subsystems) {
    s.activate(); // polymorphic behavior
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
- Emphasize that overriding = same method name, different behavior.  
- Robot code: subsystems override `activate()` for unique actions.  
- Archaeology: replace duplicated method names with overridden versions.  
- Segue: Next lesson → **toString() method overriding** (custom string representation of objects).  
-->
