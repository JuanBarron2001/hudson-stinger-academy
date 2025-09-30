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
- **Start Time in 12‑Hour Video:** [blank]  
- **Full Course (12h video):** [link here]  

---

### 🎯 For the Quick‑Hit Learners  
- **Lesson Playlist:** [link here]  
- **This Lesson Only:** [link here]  

---

## 💻 Part 1 – Java‑Only (2 pts)

**Basic (1 pt)**  
- Create an `Engine` class with a `type` attribute and a `start()` method:  

[CODE BLOCK]java
public class Engine {
    String type;

    Engine(String type) {
        this.type = type;
    }

    void start() {
        System.out.println("You start the " + this.type + " engine");
    }
}
[CODE BLOCK]

- Create a `Car` class that **contains** an `Engine` object:  

[CODE BLOCK]java
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
[CODE BLOCK]

- Demonstrate usage:  

[CODE BLOCK]java
Car car = new Car("Corvette", 2025, "V8");
System.out.println(car.model + " " + car.year);
System.out.println("Engine type: " + car.engine.type);

car.start();
// Output:
// You start the V8 engine
// Corvette is running
[CODE BLOCK]

**Extra (1 pt)**  
- Show that if the `Car` object is deleted, the `Engine` object is also gone (because it’s part of the car).  

---

## 🤖 Part 2 – Robot Code (2 pts)

**Basic (1 pt)**  
- Create a `Motor` class with attributes: `id`, `power`.  
- Create a `DriveTrain` class that **composes** multiple `Motor` objects.  

**Extra (1 pt)**  
- Add a `start()` method in `DriveTrain` that starts all motors.  
- Print results to **SmartDashboard**.  

[CODE BLOCK]java
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
[CODE BLOCK]

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

[CODE BLOCK]java
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
- Emphasize composition = “part‑of” relationship (engine is part of car).  
- Robot code: subsystems composed of motors or joints.  
- Archaeology: replace scattered part management with composition.  
- Segue: Next lesson → **Packages & Imports** (organizing classes into packages).  
[CODE BLOCK]
