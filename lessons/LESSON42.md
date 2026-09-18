# 🖥️ Lesson 42 – Composition in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🐝  

---

## 🎯 Overview
**Keywords:** Java, Composition, Part‑Of Relationship, Encapsulation, Object-Oriented Design  
Learn to:
- Understand **composition**: a “part‑of” relationship between objects  
- Recognize that in composition, the **lifetime of the part depends on the whole** (if the car is deleted, its engine is deleted too)  
- Build complex objects from smaller, reusable components  
- Differentiate **composition** from **aggregation** (aggregation = has‑a, but parts can exist independently)  

---

## ⏱️ Progress Tracking

### 📊 For the Marathon Watchers  
If you’re following the **full 12‑hour compilation** and want to see how far you’ve made it through the *entire* course:  
- **Start Time in 12‑Hour Video:** [08:39:02](https://www.youtube.com/watch?v=xTtL8E4LzTQ&t=31142s)  
- **Full Course (12h video):** [Watch Compilation](https://www.youtube.com/watch?v=xTtL8E4LzTQ)

---

### 🎯 For the Quick‑Hit Learners  
If you just want **this lesson only** and to be done with it — no scrubbing through hours of footage:  
- **Lesson Playlist:** [Java tutorial for beginners (2025) ☕](https://www.youtube.com/playlist?list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc)  
- **This Lesson Only:** [Watch Lesson 42](https://www.youtube.com/watch?v=6MYaUdSuW24&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=54) (Learn composition in 6 minutes! ⚙️, 6:17)

---

## 💻 Part 1 – Java‑Only (2 pts)

> Each class gets its own file next to `Main.java`, starting with the same `package` line, like lesson 27 (`package lesson42.basic;`, and `package lesson42.extra;` for the extra's copies).

**Basic (1 pt)**  
- Create an `Engine` class with a `type` attribute and a `start()` method:  

```java
public class Engine {
    String type;

    Engine(String type) {
        this.type = type;
    }

    void start() {
        System.out.println("You start the " + this.type + " engine");
    }
}
```

- Create a `Car` class that **contains** an `Engine` object:  

```java
public class Car {
    String model;
    int year;
    Engine engine; // composition: Car has an Engine

    Car(String model, int year, String engineType) {
        this.model = model;
        this.year = year;
        this.engine = new Engine(engineType); // engine created as part of car
    }

    void start() {
        engine.start();
        System.out.println(this.model + " is running");
    }
}
```

- Demonstrate usage:  

```java
Car car = new Car("Corvette", 2025, "V8");
System.out.println(car.model + " " + car.year);
System.out.println("Engine type: " + car.engine.type);

car.start();
// Output:
// You start the V8 engine
// Corvette is running
```

**Extra (1 pt)**  
- Print `car.engine` directly. You get a hash code, because it's an object (lesson 35). Give `Engine` a `toString()` that returns `type + " engine"`, and print it again.  
- Build a second car with a different engine, like `new Car("Mustang", 2025, "V6")`, and start both.  
- Notice that `main` never created an `Engine`: each car built its own inside its constructor, and the only way to reach one is through its car (`car.engine`). When a car goes away, its engine goes with it. In a comment, compare that with lesson 41, where the books were built first and handed to the library, so they outlived it.  

---

## 🤖 Part 2 – Robot Code (2 pts)

**Basic (1 pt)**  
- Create a `Motor` class with attributes: `id`, `power`.  
- Create a `DriveTrain` class that **composes** multiple `Motor` objects.  

**Extra (1 pt)**  
- Add a `start()` method in `DriveTrain` that starts all motors.  
- Print results to **SmartDashboard**.  

```java
public class Motor {
    String id;
    double power;

    Motor(String id, double power) {
        this.id = id;
        this.power = power;
    }

    void start() {
        SmartDashboard.putString(id, "Motor " + id + " running at " + power);
    }
}

public class DriveTrain {
    Motor leftMotor;
    Motor rightMotor;

    DriveTrain(String leftId, String rightId) {
        this.leftMotor = new Motor(leftId, 0.5);
        this.rightMotor = new Motor(rightId, 0.5);
    }

    void start() {
        leftMotor.start();
        rightMotor.start();
        SmartDashboard.putString("DriveTrain", "DriveTrain is active");
    }
}
```

---

## 📜 Part 3 – Code Archaeology (2 pts)

**Basic (1 pt)**  
- Find a section of last year’s robot code where a subsystem was manually managing multiple parts (e.g., drivetrain controlling motors separately).  
- Suggest replacing it with **composition**: the subsystem contains the parts as objects.  

**Extra (1 pt)**  
- Suggest improvements:  
  - Encapsulate related parts inside a parent class.  
  - Example: `DriveTrain` composes `Motor` objects, `Arm` composes `Joint` objects.  
  - This makes the code modular and easier to maintain.  

```java
public class Arm {
    Joint shoulder;
    Joint elbow;

    Arm() {
        this.shoulder = new Joint("Shoulder");
        this.elbow = new Joint("Elbow");
    }

    void move() {
        shoulder.activate();
        elbow.activate();
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
- Emphasize composition = “part‑of” relationship (engine is part of car).  
- Robot code: subsystems composed of motors or joints.  
- Archaeology: replace scattered part management with composition.  
- Segue: Next lesson → **Packages & Imports** (organizing classes into packages).  
-->
