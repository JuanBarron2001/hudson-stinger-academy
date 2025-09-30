# 🖥️ Lesson 32 – Inheritance in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🐝  

---

## 🎯 Overview
**Keywords:** Java, Inheritance, Parent Class, Child Class, Multi‑Level Inheritance, Extends, DRY Principle  
Learn to:
- Understand **inheritance**: one class (child) inherits attributes and methods from another (parent)  
- Use the `extends` keyword to establish parent‑child relationships  
- Apply the **DRY principle** (Don’t Repeat Yourself) by reusing code in parent classes  
- Add **unique attributes and methods** to child classes  
- Recognize **multi‑level inheritance** (grandparent → parent → child)  
- Differentiate between **siblings** (classes that share the same parent but not each other’s methods)  

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
- Create a parent class `Animal` with:  
  - Attribute: `boolean isAlive`  
  - Constructor: sets `isAlive = true`  
  - Method: `void eat()`  

[CODE BLOCK]java
public class Animal {
    boolean isAlive;

    Animal() {
        isAlive = true;
    }

    void eat() {
        System.out.println("The animal is eating");
    }
}
[CODE BLOCK]

- Create child classes `Dog` and `Cat` that **extend** `Animal`.  
- Instantiate them and show they inherit `isAlive` and `eat()`.  

**Extra (1 pt)**  
- Add unique attributes and methods:  
  - `Dog`: `int lives = 1; void speak() { System.out.println("The dog goes woof"); }`  
  - `Cat`: `int lives = 9; void speak() { System.out.println("The cat goes meow"); }`  

[CODE BLOCK]java
Dog dog = new Dog();
Cat cat = new Cat();

System.out.println(dog.isAlive); // true
dog.eat();                       // inherited
dog.speak();                     // unique

System.out.println(cat.lives);   // 9
cat.speak();                     // unique
[CODE BLOCK]

---

## 🤖 Part 2 – Robot Code (2 pts)

**Basic (1 pt)**  
- Create a parent class `Subsystem` with:  
  - Attribute: `boolean isActive`  
  - Method: `activate()`  

- Create child classes `DriveTrain` and `Arm` that extend `Subsystem`.  

**Extra (1 pt)**  
- Add unique methods:  
  - `DriveTrain`: `moveForward()`  
  - `Arm`: `lift()`  
- Demonstrate that both inherit `activate()` but have their own unique actions.  
- Print results to **SmartDashboard**.  

[CODE BLOCK]java
public class Subsystem {
    boolean isActive = false;

    void activate() {
        isActive = true;
        System.out.println("Subsystem activated");
    }
}

public class DriveTrain extends Subsystem {
    void moveForward() {
        System.out.println("DriveTrain moving forward");
    }
}

public class Arm extends Subsystem {
    void lift() {
        System.out.println("Arm lifting");
    }
}
[CODE BLOCK]

---

## 📜 Part 3 – Code Archaeology (2 pts)

**Basic (1 pt)**  
- Find a section of last year’s robot code where multiple subsystems repeated the same attributes (e.g., `isActive`, `status`).  
- Suggest replacing them with a **parent class** to avoid duplication.  

**Extra (1 pt)**  
- Suggest improvements:  
  - Use inheritance to centralize shared logic.  
  - Example: `Subsystem` parent class with `activate()` and `deactivate()`.  
  - Children (`Shooter`, `Climber`, `DriveTrain`) inherit and add unique methods.  

[CODE BLOCK]java
public class Shooter extends Subsystem {
    void shoot() {
        System.out.println("Shooter firing");
    }
}

public class Climber extends Subsystem {
    void climb() {
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
- Show how inheritance reduces duplication (DRY principle).  
- Robot code: subsystems inherit from a common parent.  
- Archaeology: replace repeated attributes with a parent class.  
- Segue: Next lesson → **Method Overriding** (child classes redefine parent methods).  
[CODE BLOCK]
