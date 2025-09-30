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
- **Start Time in 12‑Hour Video:** [blank]  
- **Full Course (12h video):** [link here]  

---

### 🎯 For the Quick‑Hit Learners  
- **Lesson Playlist:** [link here]  
- **This Lesson Only:** [link here]  

---

## 💻 Part 1 – Java‑Only (2 pts)

**Basic (1 pt)**  
- Create a `Car` class with private attributes:  

[CODE BLOCK]java
public class Car {
    private String model;
    private String color;

    // Constructor
    Car(String model, String color) {
        this.model = model;
        this.color = color;
    }

    // Getter for model
    public String getModel() {
        return model;
    }

    // Setter for model
    public void setModel(String model) {
        this.model = model;
    }

    // Getter for color
    public String getColor() {
        return color;
    }

    // Setter for color
    public void setColor(String color) {
        this.color = color;
    }
}
[CODE BLOCK]

- Demonstrate usage:  

[CODE BLOCK]java
Car car = new Car("Mustang", "Red");

// Access values through getters
System.out.println(car.getModel()); // Mustang
System.out.println(car.getColor()); // Red

// Update values through setters
car.setModel("Corvette");
car.setColor("Blue");

System.out.println(car.getModel()); // Corvette
System.out.println(car.getColor()); // Blue
[CODE BLOCK]

**Extra (1 pt)**  
- Add validation inside a setter (e.g., prevent negative values for `year`).  

[CODE BLOCK]java
private int year;

public void setYear(int year) {
    if (year > 1885) { // first car invented ~1886
        this.year = year;
    } else {
        System.out.println("Invalid year for a car!");
    }
}

public int getYear() {
    return year;
}
[CODE BLOCK]

---

## 🤖 Part 2 – Robot Code (2 pts)

**Basic (1 pt)**  
- Create a `Motor` class with private attributes: `id`, `speed`.  
- Add getters and setters for both.  

**Extra (1 pt)**  
- Add validation in the setter for `speed` (e.g., must be between `0.0` and `1.0`).  
- Print results to **SmartDashboard**.  

[CODE BLOCK]java
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
[CODE BLOCK]

---

## 📜 Part 3 – Code Archaeology (2 pts)

**Basic (1 pt)**  
- Find a section of last year’s robot code where attributes were declared `public`.  
- Suggest replacing them with **private fields** and adding getters/setters.  

**Extra (1 pt)**  
- Suggest improvements:  
  - Add validation logic in setters (e.g., prevent invalid sensor values).  
  - Use getters to standardize how data is accessed across subsystems.  

[CODE BLOCK]java
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
- Emphasize encapsulation: hide fields, expose controlled access.  
- Robot code: validate motor speeds or sensor values with setters.  
- Archaeology: replace `public` fields with private + getters/setters.  
- Segue: Next lesson → **Access Modifiers (public, private, protected)** for deeper encapsulation.  
[CODE BLOCK]
