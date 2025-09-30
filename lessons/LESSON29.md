# 🖥️ Lesson 29 – Overloaded Constructors in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🐝  

---

## 🎯 Overview
**Keywords:** Java, Constructors, Overloading, Initialization, Default Values, Optional Fields  
Learn to:
- Understand what **overloaded constructors** are  
- Create multiple constructors with different parameter lists  
- Provide **default values** when arguments are missing  
- Initialize objects in flexible ways depending on available data  
- Apply this technique when some fields are optional  

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
- Create a `User` class with attributes:  
  - `String username`  
  - `String email`  
  - `int age`  

- Add a constructor that accepts only a username and sets default values for the other fields.  

[CODE BLOCK]java
public class User {
    String username;
    String email;
    int age;

    // Constructor with username only
    User(String username) {
        this.username = username;
        this.email = "Not Provided";
        this.age = 0;
    }
}
[CODE BLOCK]

**Extra (1 pt)**  
- Add more constructors:  
  - One with `username` and `email`  
  - One with `username`, `email`, and `age`  
  - One with **no arguments** (default/guest profile)  

[CODE BLOCK]java
// Constructor with username + email
User(String username, String email) {
    this.username = username;
    this.email = email;
    this.age = 0;
}

// Constructor with username + email + age
User(String username, String email, int age) {
    this.username = username;
    this.email = email;
    this.age = age;
}

// Constructor with no arguments
User() {
    this.username = "Guest";
    this.email = "Not Provided";
    this.age = 0;
}
[CODE BLOCK]

---

## 🤖 Part 2 – Robot Code (2 pts)

**Basic (1 pt)**  
- Create a `Sensor` class with attributes:  
  - `String type`  
  - `String port`  
  - `boolean isActive`  

- Add a constructor that accepts only `type` and sets defaults for the rest.  

**Extra (1 pt)**  
- Add overloaded constructors:  
  - One with `type` and `port`  
  - One with `type`, `port`, and `isActive`  
  - One with no arguments (default sensor)  
- Print results to **SmartDashboard**.  

[CODE BLOCK]java
public class Sensor {
    String type;
    String port;
    boolean isActive;

    Sensor(String type) {
        this.type = type;
        this.port = "Unknown";
        this.isActive = false;
    }

    Sensor(String type, String port) {
        this.type = type;
        this.port = port;
        this.isActive = false;
    }

    Sensor(String type, String port, boolean isActive) {
        this.type = type;
        this.port = port;
        this.isActive = isActive;
    }

    Sensor() {
        this.type = "Generic";
        this.port = "None";
        this.isActive = false;
    }
}
[CODE BLOCK]

---

## 📜 Part 3 – Code Archaeology (2 pts)

**Basic (1 pt)**  
- Find a section of last year’s robot code where multiple initialization methods were used for the same object type.  
- Suggest replacing them with **overloaded constructors**.  

**Extra (1 pt)**  
- Suggest improvements:  
  - Replace repeated setup code with constructor overloading.  
  - Example: Instead of writing separate initialization functions for motors with/without encoders, use overloaded constructors.  

[CODE BLOCK]java
Motor m1 = new Motor("LeftMotor");                  // default port
Motor m2 = new Motor("RightMotor", "CAN1");         // custom port
Motor m3 = new Motor("ArmMotor", "PWM2", true);     // with encoder
Motor m4 = new Motor();                             // default motor
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
- Show similarity between overloaded methods and overloaded constructors.  
- Robot code: sensors or motors initialized in multiple ways.  
- Archaeology: replace repetitive initialization with constructor overloading.  
- Segue: Next lesson → **toString() method** for printing object details.  
[CODE BLOCK]
