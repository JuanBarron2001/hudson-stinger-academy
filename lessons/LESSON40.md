# 🖥️ Lesson 40 – Getters and Setters in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🐝  

---

## 🎯 Overview
**Keywords:** Java, Encapsulation, Getters, Setters, Access Modifiers, Private Fields  
Learn to:
- Understand **encapsulation**: restricting direct access to fields  
- Use **private attributes** to protect data  
- Provide **getter methods** to read values safely  
- Provide **setter methods** to update values with control  
- Recognize how getters and setters improve **security, flexibility, and maintainability**  

---

## ⏱️ Progress Tracking

### 📊 For the Marathon Watchers  
If you’re following the **full 12‑hour compilation** and want to see how far you’ve made it through the *entire* course:  
- **Start Time in 12‑Hour Video:** [08:19:35](https://www.youtube.com/watch?v=xTtL8E4LzTQ&t=29975s)  
- **Full Course (12h video):** [Watch Compilation](https://www.youtube.com/watch?v=xTtL8E4LzTQ)

---

### 🎯 For the Quick‑Hit Learners  
If you just want **this lesson only** and to be done with it — no scrubbing through hours of footage:  
- **Lesson Playlist:** [Java tutorial for beginners (2025) ☕](https://www.youtube.com/playlist?list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc)  
- **This Lesson Only:** [Watch Lesson 40](https://www.youtube.com/watch?v=OjrR_C_UPjc&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=52) (Learn Java getters and setters in 10 minutes! 🔐, 10:06)

---

## 💻 Part 1 – Java‑Only (2 pts)

> New classes go in their own file next to `Main.java`, starting with the same `package` line, like lesson 27 (`package lesson40.basic;`, and `package lesson40.extra;` for the extra's copy).

**Basic (1 pt)**: lock the data, then open it on purpose  
- Create a `Car` class whose attributes are **private**:  

```java
public class Car {
    private String model;
    private String color;
    private int price;

    Car(String model, String color, int price) {
        this.model = model;
        this.color = color;
        this.price = price;
    }
}
```

- In `main()`, create `new Car("Charger", "Yellow", 10000)` and try to print `car.color`. Read the error: `private` means only code inside `Car` can touch it.  
- Add a **getter** for each attribute, so they can be read: `public String getModel()`, `public String getColor()` and `public int getPrice()`, each returning its attribute. Print all three with the getters.  
- Add **setters** for `color` and `price` only: `public void setColor(String color)` and `public void setPrice(int price)`. You can repaint a car or sell it for a new price, but a Charger can't turn into a Corvette, so there is **no** `setModel`.  
- Repaint the car blue, change its price, and print it again with the getters. Then try `car.setModel("Corvette")` and read the error.  

**Extra (1 pt)**: rules inside getters and setters  
- Make the model `private final String model;`. `final` means it can be set once, in the constructor, and never again, even from inside `Car`.  
- Add logic to the getter: have `getPrice()` return `"$" + price` (a `String` now).  
- Add a rule to the setter: if the new price is less than 0, print `"Price can't be less than zero"` and leave the old price alone.  
- Try `car.setPrice(-100)`. The message prints, and the price stays what it was.  

---

## 🤖 Part 2 – Robot Code (2 pts)

**Basic (1 pt)**  
- Create a `Motor` class with private attributes: `id`, `speed`.  
- Add getters and setters for both.  

**Extra (1 pt)**  
- Add validation in the setter for `speed` (e.g., must be between `0.0` and `1.0`).  
- Print results to **SmartDashboard**.  

```java
public class Motor {
    private String id;
    private double speed;

    Motor(String id) {
        this.id = id;
        this.speed = 0.0;
    }

    public String getId() {
        return id;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        if (speed >= 0.0 && speed <= 1.0) {
            this.speed = speed;
        } else {
            System.out.println("Invalid speed value");
        }
    }
}

// Example usage
Motor motor = new Motor("LeftMotor");
motor.setSpeed(0.75);
SmartDashboard.putNumber(motor.getId(), motor.getSpeed());
```

---

## 📜 Part 3 – Code Archaeology (2 pts)

**Basic (1 pt)**  
- Find a section of last year’s robot code where attributes were declared `public`.  
- Suggest replacing them with **private fields** and adding getters/setters.  

**Extra (1 pt)**  
- Suggest improvements:  
  - Add validation logic in setters (e.g., prevent invalid sensor values).  
  - Use getters to standardize how data is accessed across subsystems.  

```java
// Before
public double motorSpeed;

// After
private double motorSpeed;

public double getMotorSpeed() {
    return motorSpeed;
}

public void setMotorSpeed(double motorSpeed) {
    if (motorSpeed >= 0 && motorSpeed <= 1) {
        this.motorSpeed = motorSpeed;
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
- Emphasize encapsulation: hide fields, expose controlled access.  
- Robot code: validate motor speeds or sensor values with setters.  
- Archaeology: replace `public` fields with private + getters/setters.  
- Segue: Next lesson → **Access Modifiers (public, private, protected)** for deeper encapsulation.  
-->
