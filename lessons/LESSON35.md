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
If you’re following the **full 12‑hour compilation** and want to see how far you’ve made it through the *entire* course:  
- **Start Time in 12‑Hour Video:** [07:46:08](https://www.youtube.com/watch?v=xTtL8E4LzTQ&t=27968s)  
- **Full Course (12h video):** [Watch Compilation](https://www.youtube.com/watch?v=xTtL8E4LzTQ)

---

### 🎯 For the Quick‑Hit Learners  
If you just want **this lesson only** and to be done with it — no scrubbing through hours of footage:  
- **Lesson Playlist:** [Java tutorial for beginners (2025) ☕](https://www.youtube.com/playlist?list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc)  
- **This Lesson Only:** [Watch Lesson 35](https://www.youtube.com/watch?v=u3BGdOunOTI&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=47) (Learn the toString() method in 5 minutes! 🎉, 5:53)

---

## 💻 Part 1 – Java‑Only (2 pts)

> New classes go in their own file next to `Main.java`, starting with the same `package` line, like lesson 27 (`package lesson35.basic;`, and `package lesson35.extra;` for the extra's copy).

**Basic (1 pt)**  
- Create a `Car` class with attributes and constructor:  

```java
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
```

- In `main()`, create `new Car("Ford", "Mustang", 2025, "Red")` and print it directly with `System.out.println(car);`. You’ll see something like  
  `lesson35.basic.Car@6d06d69c`: the class's full name and a hash code. That's `Object`'s default `toString()`, which every class inherits.  
- Now print the details the long way: `car.color + " " + car.year + " " + car.make + " " + car.model`.  

**Extra (1 pt)**  
- Override the `toString()` method to return meaningful details:  

```java
@Override
public String toString() {
    return this.color + " " + this.year + " " + this.make + " " + this.model;
}
```

- Now printing the object directly gives:  
  `Red 2025 Ford Mustang`  

- Example usage:  

```java
Car car1 = new Car("Ford", "Mustang", 2025, "Red");
Car car2 = new Car("Chevrolet", "Corvette", 2026, "Blue");

System.out.println(car1); // Red 2025 Ford Mustang
System.out.println(car2); // Blue 2026 Chevrolet Corvette
```

---

## 🤖 Part 2 – Robot Code (2 pts)

**Basic (1 pt)**  
- Create a `Motor` class with attributes: `id`, `speed`.  
- Override `toString()` to return `"Motor <id> running at <speed>"`.  

**Extra (1 pt)**  
- Store multiple `Motor` objects in an array.  
- Print them directly to **SmartDashboard** using their overridden `toString()`.  

```java
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
```

---

## 📜 Part 3 – Code Archaeology (2 pts)

**Basic (1 pt)**  
- Find a section of last year’s robot code where objects were printed manually with multiple `println` statements.  
- Suggest replacing them with a **custom `toString()`** method.  

**Extra (1 pt)**  
- Suggest improvements:  
  - Override `toString()` in classes like `Sensor`, `Motor`, or `Subsystem`.  
  - This way, printing the object directly shows useful details without extra formatting code.  

```java
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
- Show how `toString()` makes debugging and logging easier.  
- Robot code: override `toString()` for motors/sensors to simplify SmartDashboard output.  
- Archaeology: replace verbose print statements with `toString()`.  
- Segue: Next lesson → **Polymorphism** (using parent references to call overridden methods).  
-->
