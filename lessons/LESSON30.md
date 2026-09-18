# 🖥️ Lesson 30 – Arrays of Objects in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🐝  

---

## 🎯 Overview
**Keywords:** Java, Arrays, Objects, Anonymous Objects, Enhanced For Loop, Constructors  
Learn to:
- Create a class with attributes and methods  
- Instantiate multiple objects from that class  
- Store objects inside an array  
- Iterate through arrays of objects with standard and enhanced for loops  
- Use **anonymous objects** inside arrays  
- Modify attributes of objects stored in arrays  

---

## ⏱️ Progress Tracking

### 📊 For the Marathon Watchers  
If you’re following the **full 12‑hour compilation** and want to see how far you’ve made it through the *entire* course:  
- **Start Time in 12‑Hour Video:** [07:08:22](https://www.youtube.com/watch?v=xTtL8E4LzTQ&t=25702s)  
- **Full Course (12h video):** [Watch Compilation](https://www.youtube.com/watch?v=xTtL8E4LzTQ)

---

### 🎯 For the Quick‑Hit Learners  
If you just want **this lesson only** and to be done with it — no scrubbing through hours of footage:  
- **Lesson Playlist:** [Java tutorial for beginners (2025) ☕](https://www.youtube.com/playlist?list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc)  
- **This Lesson Only:** [Watch Lesson 30](https://www.youtube.com/watch?v=cMJeCs0n6BY&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=42) (Learn Java ARRAY OF OBJECTS in 5 minutes! 🗃️, 5:46)

---

## 💻 Part 1 – Java‑Only (2 pts)

> New classes go in their own file next to `Main.java`, starting with the same `package` line, like lesson 27: `Car.java` starts with `package lesson30.basic;` in the basic folder, and the extra folder gets its own copy with `package lesson30.extra;`.

**Basic (1 pt)**  
- Create a `Car` class with attributes and a constructor:  

```java
public class Car {
    String model;
    String color;

    Car(String model, String color) {
        this.model = model;
        this.color = color;
    }

    void drive() {
        System.out.println("You drive the " + this.color + " " + this.model);
    }
}
```

- Instantiate three cars and store them in an array.  
- Use a **for loop** to call `drive()` on each.  

**Extra (1 pt)**  
- Use an **enhanced for loop** to simplify iteration.  
- Create an array with **anonymous objects** directly:  

```java
Car[] cars = {
    new Car("Mustang", "Red"),
    new Car("Corvette", "Blue"),
    new Car("Charger", "Yellow")
};

for (Car car : cars) {
    car.drive();
}
```

- Paint every car: in another enhanced `for` loop, set `car.color = "Black";`, then drive them all again. Changing an object you got from the array changes the object itself.

---

## 🤖 Part 2 – Robot Code (2 pts)

**Basic (1 pt)**  
- Create a `Motor` class with attributes:  
  - `String id`  
  - `double speed`  
- Add a method `run()` that prints `"Motor <id> running at <speed>"`.  
- Store multiple `Motor` objects in an array and loop through them.  

**Extra (1 pt)**  
- Use an enhanced for loop to update all motor speeds (e.g., set all to `0.5`).  
- Print results to **SmartDashboard**.  

```java
Motor[] motors = {
    new Motor("Left", 0.3),
    new Motor("Right", 0.3),
    new Motor("Arm", 0.2)
};

for (Motor m : motors) {
    m.setSpeed(0.5);
    SmartDashboard.putNumber("Motor " + m.id, m.speed);
}
```

---

## 📜 Part 3 – Code Archaeology (2 pts)

**Basic (1 pt)**  
- Find a section of last year’s robot code where multiple objects were declared individually (e.g., `motor1`, `motor2`, `motor3`).  
- Suggest replacing them with an **array of objects**.  

**Extra (1 pt)**  
- Suggest improvements:  
  - Replace repeated method calls with a loop over an array.  
  - Use anonymous objects in arrays for quick initialization.  

```java
Motor[] motors = {
    new Motor("Left", 0.5),
    new Motor("Right", 0.5),
    new Motor("Claw", 0.2)
};

for (Motor m : motors) {
    m.run();
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
- Show difference between arrays of primitives vs. arrays of objects.  
- Robot code: arrays of motors or sensors.  
- Archaeology: replace multiple object variables with arrays.  
- Segue: Next lesson → **Object Arrays + Loops with User Input** (dynamic object creation).  
-->
