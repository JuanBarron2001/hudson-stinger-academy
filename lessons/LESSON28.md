# 🖥️ Lesson 28 – Constructors in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🐝

---

## 🎯 Overview
**Keywords:** Java, Constructors, Initialization, this Keyword, Parameters, Objects  
Learn to:
- Understand what a **Constructor** is and how it differs from regular methods  
- Use Constructors to initialize objects with **unique values**  
- Pass arguments to a Constructor and match them with parameters  
- Apply the `this` keyword to distinguish between attributes and parameters  
- Automatically set default values for certain attributes  
- Use attributes inside methods after initialization  

---

## ⏱️ Progress Tracking

### 📊 For the Marathon Watchers  
If you’re following the **full 12‑hour compilation** and want to see how far you’ve made it through the *entire* course:  
- **Start Time in 12‑Hour Video:** [06:51:38](https://www.youtube.com/watch?v=xTtL8E4LzTQ&t=24698s)  
- **Full Course (12h video):** [Watch Compilation](https://www.youtube.com/watch?v=xTtL8E4LzTQ)

---

### 🎯 For the Quick‑Hit Learners  
If you just want **this lesson only** and to be done with it — no scrubbing through hours of footage:  
- **Lesson Playlist:** [Java tutorial for beginners (2025) ☕](https://www.youtube.com/playlist?list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc)  
- **This Lesson Only:** [Watch Lesson 28](https://www.youtube.com/watch?v=ZD7CB6wKg8A&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=40) (Learn CONSTRUCTORS in 10 minutes! 🔨, 10:08)

---

## 💻 Part 1 – Java‑Only (2 pts)

> New classes go in their own file next to `Main.java`, starting with the same `package` line, like lesson 27: `java-lessons/src/lesson28/basic/Student.java` starts with `package lesson28.basic;`, and the extra folder gets its own copy with `package lesson28.extra;`.

**Basic (1 pt)**  
- Create a `Student` class with attributes:  
  - `String name`  
  - `int age`  
  - `double gpa`  
  - `boolean isEnrolled`  

- Add a **Constructor** that accepts `name`, `age`, and `gpa`.  
- Use the `this` keyword to assign parameters to attributes.  
- Automatically set `isEnrolled = true`.  
- In `main()`, create one student with `new Student("SpongeBob", 30, 3.2)` and print its four attributes.  

```java
public class Student {
    String name;
    int age;
    double gpa;
    boolean isEnrolled;

    // Constructor
    Student(String name, int age, double gpa) {
        this.name = name;
        this.age = age;
        this.gpa = gpa;
        this.isEnrolled = true; // default
    }

    void study() {
        System.out.println(this.name + " is studying");
    }
}
```

**Extra (1 pt)**  
- In `main()`, create three students with unique values.  
- Print their attributes and call the `study()` method.  
- Try `new Student()` with no arguments. Read the error: once a class has a constructor with parameters, every new object has to pass them.  

```java
public static void main(String[] args) {
    Student s1 = new Student("SpongeBob", 30, 3.2);
    Student s2 = new Student("Patrick", 34, 1.5);
    Student s3 = new Student("Sandy", 27, 4.0);

    System.out.println(s1.name + " " + s1.age + " " + s1.gpa + " " + s1.isEnrolled);
    System.out.println(s2.name + " " + s2.age + " " + s2.gpa + " " + s2.isEnrolled);
    System.out.println(s3.name + " " + s3.age + " " + s3.gpa + " " + s3.isEnrolled);

    s1.study();
    s2.study();
    s3.study();
}
```

---

## 🤖 Part 2 – Robot Code (2 pts)

**Basic (1 pt)**  
- Create a `Motor` class with attributes:  
  - `String id`  
  - `double speed`  
  - `boolean isRunning`  

- Add a Constructor to initialize `id` and `speed`.  
- Default `isRunning = false`.  

**Extra (1 pt)**  
- Add methods `start()`, `stop()`, and `setSpeed(double s)`.  
- Instantiate multiple motors with different IDs and speeds.  
- Print their states to **SmartDashboard**.  

```java
public class Motor {
    String id;
    double speed;
    boolean isRunning;

    Motor(String id, double speed) {
        this.id = id;
        this.speed = speed;
        this.isRunning = false;
    }

    void start() { isRunning = true; }
    void stop() { isRunning = false; }
    void setSpeed(double s) { speed = s; }
}
```

---

## 📜 Part 3 – Code Archaeology (2 pts)

**Basic (1 pt)**  
- Find a section of last year’s robot code where objects were created but initialized manually (e.g., assigning attributes after creation).  
- Suggest replacing that with a **Constructor** to simplify initialization.  

**Extra (1 pt)**  
- Suggest improvements:  
  - Replace repeated setup code with a Constructor.  
  - Example: instead of setting motor IDs and speeds line by line, pass them into a Constructor.  

```java
Motor leftMotor = new Motor("Left", 0.5);
Motor rightMotor = new Motor("Right", 0.5);
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
- Show how Constructors solve the problem of duplicate default values.  
- Robot code: use Constructors for motors, sensors, or subsystems.  
- Archaeology: replace manual initialization with Constructor calls.  
- Segue: Next lesson → **Overloading Constructors** (multiple ways to initialize objects).  
-->
