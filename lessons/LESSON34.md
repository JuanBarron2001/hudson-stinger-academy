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
- **Start Time in 12‑Hour Video:** [blank]  
- **Full Course (12h video):** [link here]  

---

### 🎯 For the Quick‑Hit Learners  
- **Lesson Playlist:** [link here]  
- **This Lesson Only:** [link here]  

---

## 💻 Part 1 – Java‑Only (2 pts)

**Basic (1 pt)**  
- Create a parent class `Animal` with a `move()` method.  

[CODE BLOCK]java
public class Animal {
    void move() {
        System.out.println("This animal is running");
    }
}
[CODE BLOCK]

- Create child classes `Dog`, `Cat`, and `Fish` that extend `Animal`.  
- By default, they inherit the `move()` method.  

**Extra (1 pt)**  
- Override the `move()` method in the `Fish` class to provide a unique implementation.  

[CODE BLOCK]java
public class Fish extends Animal {
    @Override
    void move() {
        System.out.println("This animal is swimming");
    }
}
[CODE BLOCK]

- Demonstrate:  

[CODE BLOCK]java
Dog dog = new Dog();
Cat cat = new Cat();
Fish fish = new Fish();

dog.move();  // "This animal is running"
cat.move();  // "This animal is running"
fish.move(); // "This animal is swimming"
[CODE BLOCK]

---

## 🤖 Part 2 – Robot Code (2 pts)

**Basic (1 pt)**  
- Create a parent class `Subsystem` with a method `activate()`.  

[CODE BLOCK]java
public class Subsystem {
    void activate() {
        System.out.println("Subsystem activated");
    }
}
[CODE BLOCK]

- Create child classes `DriveTrain`, `Arm`, and `Shooter` that extend `Subsystem`.  

**Extra (1 pt)**  
- Override `activate()` in each child to provide unique behavior.  
- Print results to **SmartDashboard**.  

[CODE BLOCK]java
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
[CODE BLOCK]

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

[CODE BLOCK]java
Subsystem[] subsystems = { new DriveTrain(), new Arm(), new Shooter() };

for (Subsystem s : subsystems) {
    s.activate(); // polymorphic behavior
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
- Emphasize that overriding = same method name, different behavior.  
- Robot code: subsystems override `activate()` for unique actions.  
- Archaeology: replace duplicated method names with overridden versions.  
- Segue: Next lesson → **toString() method overriding** (custom string representation of objects).  
[CODE BLOCK]
