# 🖥️ Lesson 31 – The `static` Keyword in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🐝  

---

## 🎯 Overview
**Keywords:** Java, static, Class Members, Shared Variables, Utility Methods  
Learn to:
- Understand that `static` makes a variable or method belong to the **class**, not the object  
- Use `static` variables to share data across all objects  
- Use `static` methods as **utility methods** (e.g., `Math.round()`)  
- Access static members via the **class name** instead of an object reference  

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
- Create a `Friend` class with a `name` attribute and a **static** variable to track total friends.  

[CODE BLOCK]java
public class Friend {
    String name;
    static int numberOfFriends = 0;

    Friend(String name) {
        this.name = name;
        numberOfFriends++;
    }

    static void showFriends() {
        System.out.println("You have " + numberOfFriends + " total friends");
    }
}
[CODE BLOCK]

- In `main()`, create several `Friend` objects and print the total count.  

**Extra (1 pt)**  
- Demonstrate accessing the static variable and method via the **class name**:  

[CODE BLOCK]java
public static void main(String[] args) {
    Friend f1 = new Friend("SpongeBob");
    Friend f2 = new Friend("Patrick");
    Friend f3 = new Friend("Squidward");

    // Access static variable and method via class name
    System.out.println(Friend.numberOfFriends); // 3
    Friend.showFriends(); // "You have 3 total friends"
}
[CODE BLOCK]

---

## 🤖 Part 2 – Robot Code (2 pts)

**Basic (1 pt)**  
- Create a `Motor` class with a static variable `motorCount` to track how many motors are created.  

**Extra (1 pt)**  
- Add a static method `showMotors()` to print the total number of motors.  
- Demonstrate creating multiple motors and printing the shared count to **SmartDashboard**.  

[CODE BLOCK]java
public class Motor {
    String id;
    static int motorCount = 0;

    Motor(String id) {
        this.id = id;
        motorCount++;
    }

    static void showMotors() {
        SmartDashboard.putNumber("Total Motors", motorCount);
    }
}
[CODE BLOCK]

---

## 📜 Part 3 – Code Archaeology (2 pts)

**Basic (1 pt)**  
- Find a section of last year’s robot code where a counter was duplicated across multiple objects.  
- Suggest replacing it with a **static variable** to track the total count.  

**Extra (1 pt)**  
- Suggest improvements:  
  - Replace repeated counters with a single static counter.  
  - Use static utility methods for calculations (e.g., `Math.round()`, `Math.sqrt()`).  

[CODE BLOCK]java
// Instead of each motor tracking its own count:
Motor m1 = new Motor("Left");
Motor m2 = new Motor("Right");
Motor.showMotors(); // prints total motors created
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
- Show difference between instance vs. static variables.  
- Robot code: static counters for motors, sensors, or subsystems.  
- Archaeology: replace redundant counters with static variables.  
- Segue: Next lesson → **Inheritance** (how classes can share attributes and methods).  
[CODE BLOCK]
