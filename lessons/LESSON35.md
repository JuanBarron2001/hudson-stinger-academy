# 🖥️ Lesson 35 – The `toString()` Method in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🐝  

---

## 🎯 Overview
**Keywords:** Java, `toString()`, Object Class, Method Overriding, String Representation  
Learn to:
- Understand that every class in Java **implicitly extends `Object`**  
- Recognize that `Object` provides a default `toString()` method  
- See that the default `toString()` returns a **hash code** (not very useful)  
- Override `toString()` to return **meaningful details** about an object  
- Use `@Override` to ensure correctness when redefining the method  

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
- Create a `Car` class with attributes and constructor:  

[CODE BLOCK]java
public class Car {
    String make;
    String model;
    int year;
    String color;

    Car(String make, String model, int year, String color) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
    }
}
[CODE BLOCK]

- If you print a `Car` object directly, you’ll see something like:  
  `Car@6d06d69c` (the default hash code).  

**Extra (1 pt)**  
- Override the `toString()` method to return meaningful details:  

[CODE BLOCK]java
@Override
public String toString() {
    return this.color + " " + this.year + " " + this.make + " " + this.model;
}
[CODE BLOCK]

- Now printing the object directly gives:  
  `Red 2025 Ford Mustang`  

- Example usage:  

[CODE BLOCK]java
Car car1 = new Car("Ford", "Mustang", 2025, "Red");
Car car2 = new Car("Chevrolet", "Corvette", 2026, "Blue");

System.out.println(car1); // Red 2025 Ford Mustang
System.out.println(car2); // Blue 2026 Chevrolet Corvette
[CODE BLOCK]

---

## 🤖 Part 2 – Robot Code (2 pts)

**Basic (1 pt)**  
- Create a `Motor` class with attributes: `id`, `speed`.  
- Override `toString()` to return `"Motor <id> running at <speed>"`.  

**Extra (1 pt)**  
- Store multiple `Motor` objects in an array.  
- Print them directly to **SmartDashboard** using their overridden `toString()`.  

[CODE BLOCK]java
public class Motor {
    String id;
    double speed;

    Motor(String id, double speed) {
        this.id = id;
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Motor " + id + " running at " + speed;
    }
}

// Example usage
Motor[] motors = {
    new Motor("Left", 0.5),
    new Motor("Right", 0.5),
    new Motor("Arm", 0.3)
};

for (Motor m : motors) {
    SmartDashboard.putString(m.id, m.toString());
}
[CODE BLOCK]

---

## 📜 Part 3 – Code Archaeology (2 pts)

**Basic (1 pt)**  
- Find a section of last year’s robot code where objects were printed manually with multiple `println` statements.  
- Suggest replacing them with a **custom `toString()`** method.  

**Extra (1 pt)**  
- Suggest improvements:  
  - Override `toString()` in classes like `Sensor`, `Motor`, or `Subsystem`.  
  - This way, printing the object directly shows useful details without extra formatting code.  

[CODE BLOCK]java
public class Sensor {
    String type;
    String port;

    Sensor(String type, String port) {
        this.type = type;
        this.port = port;
    }

    @Override
    public String toString() {
        return "Sensor type: " + type + " on port " + port;
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
- Show how `toString()` makes debugging and logging easier.  
- Robot code: override `toString()` for motors/sensors to simplify SmartDashboard output.  
- Archaeology: replace verbose print statements with `toString()`.  
- Segue: Next lesson → **Polymorphism** (using parent references to call overridden methods).  
[CODE BLOCK]
