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
If you’re following the **full 12‑hour compilation** and want to see how far you’ve made it through the *entire* course:  
- **Start Time in 12‑Hour Video:** [07:01:45](https://www.youtube.com/watch?v=xTtL8E4LzTQ&t=25305s)  
- **Full Course (12h video):** [Watch Compilation](https://www.youtube.com/watch?v=xTtL8E4LzTQ)

---

### 🎯 For the Quick‑Hit Learners  
If you just want **this lesson only** and to be done with it — no scrubbing through hours of footage:  
- **Lesson Playlist:** [Java tutorial for beginners (2025) ☕](https://www.youtube.com/playlist?list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc)  
- **This Lesson Only:** [Watch Lesson 29](https://www.youtube.com/watch?v=iLrY412dFwo&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=41) (Learn OVERLOADED CONSTRUCTORS in 6 minutes! 🛠️, 6:37)

---

## 💻 Part 1 – Java‑Only (2 pts)

> New classes go in their own file next to `Main.java`, starting with the same `package` line, like lesson 27: `User.java` starts with `package lesson29.basic;` in the basic folder, and the extra folder gets its own copy with `package lesson29.extra;`.

**Basic (1 pt)**  
- Create a `User` class with attributes:  
  - `String username`  
  - `String email`  
  - `int age`  

- Add a constructor that accepts only a username and sets default values for the other fields.  
- In `main()`, create `new User("SpongeBob")` and print its username, email and age.  

```java
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
```

**Extra (1 pt)**  
- Add more constructors:  
  - One with `username` and `email`  
  - One with `username`, `email`, and `age`  
  - One with **no arguments** (default/guest profile)  
- In `main()`, create one user with each constructor, like the video: `"SpongeBob"`; `"Patrick"` and `"pstar@aol.com"`; `"Sandy"`, `"scheeks@gmail.com"` and `27`; and one with nothing. Print all four. Java picks the constructor whose parameters match what you pass.  

```java
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
```

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

```java
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
```

---

## 📜 Part 3 – Code Archaeology (2 pts)

**Basic (1 pt)**  
- Find a section of last year’s robot code where multiple initialization methods were used for the same object type.  
- Suggest replacing them with **overloaded constructors**.  

**Extra (1 pt)**  
- Suggest improvements:  
  - Replace repeated setup code with constructor overloading.  
  - Example: Instead of writing separate initialization functions for motors with/without encoders, use overloaded constructors.  

```java
Motor m1 = new Motor("LeftMotor");                  // default port
Motor m2 = new Motor("RightMotor", "CAN1");         // custom port
Motor m3 = new Motor("ArmMotor", "PWM2", true);     // with encoder
Motor m4 = new Motor();                             // default motor
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
- Show similarity between overloaded methods and overloaded constructors.  
- Robot code: sensors or motors initialized in multiple ways.  
- Archaeology: replace repetitive initialization with constructor overloading.  
- Segue: Next lesson → **toString() method** for printing object details.  
-->
