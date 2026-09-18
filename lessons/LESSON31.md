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
If you’re following the **full 12‑hour compilation** and want to see how far you’ve made it through the *entire* course:  
- **Start Time in 12‑Hour Video:** [07:14:07](https://www.youtube.com/watch?v=xTtL8E4LzTQ&t=26047s)  
- **Full Course (12h video):** [Watch Compilation](https://www.youtube.com/watch?v=xTtL8E4LzTQ)

---

### 🎯 For the Quick‑Hit Learners  
If you just want **this lesson only** and to be done with it — no scrubbing through hours of footage:  
- **Lesson Playlist:** [Java tutorial for beginners (2025) ☕](https://www.youtube.com/playlist?list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc)  
- **This Lesson Only:** [Watch Lesson 31](https://www.youtube.com/watch?v=qULACa4D_vg&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=43) (Learn the STATIC keyword in 8 minutes! 🤝, 8:01)

---

## 💻 Part 1 – Java‑Only (2 pts)

> New classes go in their own file next to `Main.java`, starting with the same `package` line, like lesson 27: `Friend.java` starts with `package lesson31.basic;` in the basic folder, and the extra folder gets its own copy with `package lesson31.extra;`.

**Basic (1 pt)**  
- **First, without `static`**, the way the video starts: give `Friend` a `name` and a plain `int numberOfFriends = 0;`, add 1 to it in the constructor, create two friends, and print each one's `numberOfFriends`. Why do both say `1`? Answer in a comment.  
- Now add `static` to that variable, so every `Friend` shares **one** count instead of each keeping its own:  

```java
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
```

- In `main()`, create several `Friend` objects and print the total count. It goes up with every friend now.  

**Extra (1 pt)**  
- Demonstrate accessing the static variable and method via the **class name**:  

```java
public static void main(String[] args) {
    Friend f1 = new Friend("SpongeBob");
    Friend f2 = new Friend("Patrick");
    Friend f3 = new Friend("Squidward");

    // Access static variable and method via class name
    System.out.println(Friend.numberOfFriends); // 3
    Friend.showFriends(); // "You have 3 total friends"
}
```

- Use `Friend.numberOfFriends`, not `f1.numberOfFriends`. It works either way, but the class name tells the reader the value belongs to the class, not to one friend.  
- `Math.round(2.5)` is a static method too: you've been calling it on the class since lesson 07, without ever writing `new Math()`. Print one to prove it.  

---

## 🤖 Part 2 – Robot Code (2 pts)

**Basic (1 pt)**  
- Create a `Motor` class with a static variable `motorCount` to track how many motors are created.  

**Extra (1 pt)**  
- Add a static method `showMotors()` to print the total number of motors.  
- Demonstrate creating multiple motors and printing the shared count to **SmartDashboard**.  

```java
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
```

---

## 📜 Part 3 – Code Archaeology (2 pts)

**Basic (1 pt)**  
- Find a section of last year’s robot code where a counter was duplicated across multiple objects.  
- Suggest replacing it with a **static variable** to track the total count.  

**Extra (1 pt)**  
- Suggest improvements:  
  - Replace repeated counters with a single static counter.  
  - Use static utility methods for calculations (e.g., `Math.round()`, `Math.sqrt()`).  

```java
// Instead of each motor tracking its own count:
Motor m1 = new Motor("Left");
Motor m2 = new Motor("Right");
Motor.showMotors(); // prints total motors created
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
- Show difference between instance vs. static variables.  
- Robot code: static counters for motors, sensors, or subsystems.  
- Archaeology: replace redundant counters with static variables.  
- Segue: Next lesson → **Inheritance** (how classes can share attributes and methods).  
-->
