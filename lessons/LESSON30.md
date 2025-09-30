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
- **Start Time in 12‑Hour Video:** [blank]  
- **Full Course (12h video):** [link here]  

---

### 🎯 For the Quick‑Hit Learners  
- **Lesson Playlist:** [link here]  
- **This Lesson Only:** [link here]  

---

## 💻 Part 1 – Java‑Only (2 pts)

**Basic (1 pt)**  
- Create a `Car` class with attributes and a constructor:  

[CODE BLOCK]java
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
[CODE BLOCK]

- Instantiate three cars and store them in an array.  
- Use a **for loop** to call `drive()` on each.  

**Extra (1 pt)**  
- Use an **enhanced for loop** to simplify iteration.  
- Create an array with **anonymous objects** directly:  

[CODE BLOCK]java
Car[] cars = {
    new Car("Mustang", "Red"),
    new Car("Corvette", "Blue"),
    new Car("Charger", "Yellow")
};

for (Car car : cars) {
    car.drive();
}
[CODE BLOCK]

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

[CODE BLOCK]java
Motor[] motors = {
    new Motor("Left", 0.3),
    new Motor("Right", 0.3),
    new Motor("Arm", 0.2)
};

for (Motor m : motors) {
    m.setSpeed(0.5);
    SmartDashboard.putNumber("Motor " + m.id, m.speed);
}
[CODE BLOCK]

---

## 📜 Part 3 – Code Archaeology (2 pts)

**Basic (1 pt)**  
- Find a section of last year’s robot code where multiple objects were declared individually (e.g., `motor1`, `motor2`, `motor3`).  
- Suggest replacing them with an **array of objects**.  

**Extra (1 pt)**  
- Suggest improvements:  
  - Replace repeated method calls with a loop over an array.  
  - Use anonymous objects in arrays for quick initialization.  

[CODE BLOCK]java
Motor[] motors = {
    new Motor("Left", 0.5),
    new Motor("Right", 0.5),
    new Motor("Claw", 0.2)
};

for (Motor m : motors) {
    m.run();
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
- Show difference between arrays of primitives vs. arrays of objects.  
- Robot code: arrays of motors or sensors.  
- Archaeology: replace multiple object variables with arrays.  
- Segue: Next lesson → **Object Arrays + Loops with User Input** (dynamic object creation).  
[CODE BLOCK]
