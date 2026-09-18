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
If you’re following the **full 12‑hour compilation** and want to see how far you’ve made it through the *entire* course:  
- **Start Time in 12‑Hour Video:** [07:51:58](https://www.youtube.com/watch?v=xTtL8E4LzTQ&t=28318s)  
- **Full Course (12h video):** [Watch Compilation](https://www.youtube.com/watch?v=xTtL8E4LzTQ)

---

### 🎯 For the Quick‑Hit Learners  
If you just want **this lesson only** and to be done with it — no scrubbing through hours of footage:  
- **Lesson Playlist:** [Java tutorial for beginners (2025) ☕](https://www.youtube.com/playlist?list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc)  
- **This Lesson Only:** [Watch Lesson 36](https://www.youtube.com/watch?v=4B8XKEORJss&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=48) (Learn Java abstraction in 9 minutes! 🌫️, 9:34)

---

## 💻 Part 1 – Java‑Only (2 pts)

> Each class gets its own file next to `Main.java`, starting with the same `package` line, like lesson 27 (`package lesson36.basic;`, and `package lesson36.extra;` for the extra's copies).

**Basic (1 pt)**  
- Create an abstract parent class `Shape` with:  
  - Abstract method: `double area()`  
  - Concrete method: `void display()`  

```java
public abstract class Shape {
    // Abstract method (must be implemented by children)
    abstract double area();

    // Concrete method (inherited by children)
    void display() {
        System.out.println("This is a shape");
    }
}
```

- Create child classes `Circle`, `Triangle`, and `Rectangle` that extend `Shape`.  
- Each child **must** have an `area()` method, or Java won't compile it: that's what `abstract` enforces. For now, give each one `@Override double area() { return 0; }`. The extra fills them in.  
- In `main()`, try `new Shape()` and read the error, then delete it. `Shape` is too general to build.  
- Create one `Circle`, one `Triangle` and one `Rectangle`, and call `display()` on each. They inherited it from `Shape` without writing it.  

**Extra (1 pt)**  
- Implement the `area()` method in each child:  

```java
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
```

- Demonstrate usage:  

```java
Shape circle = new Circle(3);
Shape triangle = new Triangle(4, 5);
Shape rectangle = new Rectangle(6, 7);

System.out.println(circle.area());    // 28.27...
System.out.println(triangle.area());  // 10.0
System.out.println(rectangle.area()); // 42.0
```

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

```java
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
```

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

```java
Subsystem[] subsystems = { new DriveTrain(), new Arm(), new Shooter() };

for (Subsystem s : subsystems) {
    s.activate();
    s.run();
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
- Emphasize that abstraction = hiding details, showing essentials.  
- Robot code: abstract parent class for subsystems.  
- Archaeology: replace repeated subsystem code with abstract parent.  
- Segue: Next lesson → **Interfaces** (pure abstraction, multiple inheritance of type).  
-->
