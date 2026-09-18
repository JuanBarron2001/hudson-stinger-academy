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
If you’re following the **full 12‑hour compilation** and want to see how far you’ve made it through the *entire* course:  
- **Start Time in 12‑Hour Video:** [07:22:04](https://www.youtube.com/watch?v=xTtL8E4LzTQ&t=26524s)  
- **Full Course (12h video):** [Watch Compilation](https://www.youtube.com/watch?v=xTtL8E4LzTQ)

---

### 🎯 For the Quick‑Hit Learners  
If you just want **this lesson only** and to be done with it — no scrubbing through hours of footage:  
- **Lesson Playlist:** [Java tutorial for beginners (2025) ☕](https://www.youtube.com/playlist?list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc)  
- **This Lesson Only:** [Watch Lesson 32](https://www.youtube.com/watch?v=GTP5lVEKXaU&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=44) (Learn Java inheritance in 9 minutes! 👨‍👧‍👦, 9:07)

---

## 💻 Part 1 – Java‑Only (2 pts)

> Each class gets its own file next to `Main.java`, starting with the same `package` line, like lesson 27: `Animal.java`, `Dog.java` and `Cat.java` all start with `package lesson32.basic;`. The extra folder gets its own copies with `package lesson32.extra;`.

**Basic (1 pt)**  
- Create a parent class `Animal` with:  
  - Attribute: `boolean isAlive`  
  - Constructor: sets `isAlive = true`  
  - Method: `void eat()`  

```java
public class Animal {
    boolean isAlive;

    Animal() {
        isAlive = true;
    }

    void eat() {
        System.out.println("The animal is eating");
    }
}
```

- Create child classes `Dog` and `Cat` that **extend** `Animal`.  
- Instantiate them and show they inherit `isAlive` and `eat()`.  

**Extra (1 pt)**  
- Add unique attributes and methods:  
  - `Dog`: `int lives = 1; void speak() { System.out.println("The dog goes woof"); }`  
  - `Cat`: `int lives = 9; void speak() { System.out.println("The cat goes meow"); }`  

```java
Dog dog = new Dog();
Cat cat = new Cat();

System.out.println(dog.isAlive); // true
dog.eat();                       // inherited
dog.speak();                     // unique

System.out.println(cat.lives);   // 9
cat.speak();                     // unique
```

- **Multi‑level inheritance**, the end of the video. Add a grandparent class `Organism` and move `isAlive` and its constructor into it, so `Animal extends Organism`. `Dog` and `Cat` still have `isAlive`: they get it through `Animal`.  
- Add `Plant extends Organism` with `void photosynthesize()` that prints `"The plant absorbs sunlight"`. A plant is alive, but it can't `eat()`, and a dog can't `photosynthesize()`. Try calling `dog.photosynthesize()` and read the error. They're siblings under `Organism`, not parent and child.  

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

```java
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
```

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

```java
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
- Show how inheritance reduces duplication (DRY principle).  
- Robot code: subsystems inherit from a common parent.  
- Archaeology: replace repeated attributes with a parent class.  
- Segue: Next lesson → **Method Overriding** (child classes redefine parent methods).  
-->
