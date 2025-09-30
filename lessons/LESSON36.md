# 🖥️ Lesson 36 – Abstraction in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🐝  

---

## 🎯 Overview
**Keywords:** Java, Abstraction, Abstract Class, Abstract Method, Concrete Method, Inheritance  
Learn to:
- Understand **abstraction**: hiding implementation details and exposing only essential features  
- Use the `abstract` keyword to create abstract classes and methods  
- Recognize that abstract classes **cannot be instantiated** directly  
- Force child classes to implement abstract methods for consistency  
- Inherit **concrete methods** from abstract classes without redefining them  

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
- Create an abstract parent class `Shape` with:  
  - Abstract method: `double area()`  
  - Concrete method: `void display()`  

[CODE BLOCK]java
public abstract class Shape {
    // Abstract method (must be implemented by children)
    abstract double area();

    // Concrete method (inherited by children)
    void display() {
        System.out.println("This is a shape");
    }
}
[CODE BLOCK]

- Create child classes `Circle`, `Triangle`, and `Rectangle` that extend `Shape`.  

**Extra (1 pt)**  
- Implement the `area()` method in each child:  

[CODE BLOCK]java
public class Circle extends Shape {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }
}

public class Triangle extends Shape {
    double base, height;

    Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    double area() {
        return 0.5 * base * height;
    }
}

public class Rectangle extends Shape {
    double length, width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double area() {
        return length * width;
    }
}
[CODE BLOCK]

- Demonstrate usage:  

[CODE BLOCK]java
Shape circle = new Circle(3);
Shape triangle = new Triangle(4, 5);
Shape rectangle = new Rectangle(6, 7);

System.out.println(circle.area());    // 28.27...
System.out.println(triangle.area());  // 10.0
System.out.println(rectangle.area()); // 42.0
[CODE BLOCK]

---

## 🤖 Part 2 – Robot Code (2 pts)

**Basic (1 pt)**  
- Create an abstract class `Subsystem` with:  
  - Abstract method: `void run()`  
  - Concrete method: `void activate()`  

**Extra (1 pt)**  
- Create child classes `DriveTrain`, `Arm`, and `Shooter` that extend `Subsystem`.  
- Implement `run()` differently in each.  
- Print results to **SmartDashboard**.  

[CODE BLOCK]java
public abstract class Subsystem {
    abstract void run();

    void activate() {
        System.out.println("Subsystem activated");
    }
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
[CODE BLOCK]

---

## 📜 Part 3 – Code Archaeology (2 pts)

**Basic (1 pt)**  
- Find a section of last year’s robot code where multiple subsystems had similar methods but no shared parent.  
- Suggest replacing them with an **abstract parent class** to enforce consistency.  

**Extra (1 pt)**  
- Suggest improvements:  
  - Define an abstract `run()` method in the parent.  
  - Each subsystem implements its own version.  
  - Shared setup logic (like `activate()`) lives in the parent.  

[CODE BLOCK]java
Subsystem[] subsystems = { new DriveTrain(), new Arm(), new Shooter() };

for (Subsystem s : subsystems) {
    s.activate();
    s.run();
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
- Emphasize that abstraction = hiding details, showing essentials.  
- Robot code: abstract parent class for subsystems.  
- Archaeology: replace repeated subsystem code with abstract parent.  
- Segue: Next lesson → **Interfaces** (pure abstraction, multiple inheritance of type).  
[CODE BLOCK]
