# 🖥️ Lesson 33 – The `super` Keyword in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🐝  

---

## 🎯 Overview
**Keywords:** Java, super, Inheritance, Parent Class, Child Class, Constructors  
Learn to:
- Understand that `super` refers to the **parent (superclass)** of a child (subclass)  
- Use `super` inside a **constructor** to call the parent’s constructor  
- Pass required arguments from the child constructor to the parent constructor  
- Recognize that if the parent requires arguments, the child must provide them  
- Differentiate between attributes inherited from the parent and new attributes in the child  

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
- Create a `Person` class with attributes and constructor:  

[CODE BLOCK]java
public class Person {
    String first;
    String last;

    Person(String first, String last) {
        this.first = first;
        this.last = last;
    }

    void showName() {
        System.out.println(this.first + " " + this.last);
    }
}
[CODE BLOCK]

- Create a `Student` class that extends `Person`.  
- Add a `double gpa` attribute.  
- Use `super(first, last)` in the constructor.  

[CODE BLOCK]java
public class Student extends Person {
    double gpa;

    Student(String first, String last, double gpa) {
        super(first, last); // call parent constructor
        this.gpa = gpa;
    }

    void showGpa() {
        System.out.println(this.first + "'s GPA is " + this.gpa);
    }
}
[CODE BLOCK]

**Extra (1 pt)**  
- Create an `Employee` class that extends `Person`.  
- Add an `int salary` attribute.  
- Use `super(first, last)` in the constructor.  

[CODE BLOCK]java
public class Employee extends Person {
    int salary;

    Employee(String first, String last, int salary) {
        super(first, last);
        this.salary = salary;
    }

    void showSalary() {
        System.out.println(this.first + "'s salary is $" + this.salary);
    }
}
[CODE BLOCK]

---

## 🤖 Part 2 – Robot Code (2 pts)

**Basic (1 pt)**  
- Create a parent class `Subsystem` with attribute `String name`.  
- Constructor requires `name`.  
- Add method `showName()`.  

**Extra (1 pt)**  
- Create child classes `DriveTrain` and `Arm` that extend `Subsystem`.  
- Use `super(name)` in their constructors.  
- Add unique attributes (`speed`, `strength`) and methods.  
- Print results to **SmartDashboard**.  

[CODE BLOCK]java
public class Subsystem {
    String name;

    Subsystem(String name) {
        this.name = name;
    }

    void showName() {
        System.out.println("Subsystem: " + this.name);
    }
}

public class DriveTrain extends Subsystem {
    double speed;

    DriveTrain(String name, double speed) {
        super(name);
        this.speed = speed;
    }
}

public class Arm extends Subsystem {
    int strength;

    Arm(String name, int strength) {
        super(name);
        this.strength = strength;
    }
}
[CODE BLOCK]

---

## 📜 Part 3 – Code Archaeology (2 pts)

**Basic (1 pt)**  
- Find a section of last year’s robot code where child classes duplicated parent initialization code.  
- Suggest replacing it with `super(...)` calls to the parent constructor.  

**Extra (1 pt)**  
- Suggest improvements:  
  - Use `super` to centralize initialization logic.  
  - Example: all subsystems require a `name` → handled in parent constructor.  
  - Children only add their unique attributes.  

[CODE BLOCK]java
public class Shooter extends Subsystem {
    int rpm;

    Shooter(String name, int rpm) {
        super(name); // parent handles name
        this.rpm = rpm;
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
- Emphasize that `super` = parent.  
- Robot code: subsystems inherit from a base class, use `super` for shared setup.  
- Archaeology: replace repeated initialization with `super(...)`.  
- Segue: Next lesson → **Method Overriding with super** (child redefines parent method but can still call parent’s version).  
[CODE BLOCK]
