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
If you’re following the **full 12‑hour compilation** and want to see how far you’ve made it through the *entire* course:  
- **Start Time in 12‑Hour Video:** [07:31:09](https://www.youtube.com/watch?v=xTtL8E4LzTQ&t=27069s)  
- **Full Course (12h video):** [Watch Compilation](https://www.youtube.com/watch?v=xTtL8E4LzTQ)

---

### 🎯 For the Quick‑Hit Learners  
If you just want **this lesson only** and to be done with it — no scrubbing through hours of footage:  
- **Lesson Playlist:** [Java tutorial for beginners (2025) ☕](https://www.youtube.com/playlist?list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc)  
- **This Lesson Only:** [Watch Lesson 33](https://www.youtube.com/watch?v=LN45TyPWAAg&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=45) (Learn the Java super keyword in 10 minutes! 🔝, 10:30)

---

## 💻 Part 1 – Java‑Only (2 pts)

> Each class gets its own file next to `Main.java`, starting with the same `package` line, like lesson 27 (`package lesson33.basic;`, and `package lesson33.extra;` for the extra's copies).

**Basic (1 pt)**  
- Create a `Person` class with attributes and constructor:  

```java
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
```

- Create a `Student` class that extends `Person`.  
- Add a `double gpa` attribute.  
- Use `super(first, last)` in the constructor.  

```java
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
```

- Before you add the `super(first, last);` line, try setting `this.first = first;` in `Student`'s constructor instead, and read the error. `Person`'s only constructor needs a first and last name, so a `Student` can't be built until it hands them up to the parent with `super`.  
- In `main()`, create `new Student("Harry", "Potter", 3.25)`, then call `showName()` and `showGpa()`. `showName()` came from `Person`.  

**Extra (1 pt)**  
- Create an `Employee` class that extends `Person`.  
- Add an `int salary` attribute.  
- Use `super(first, last)` in the constructor.  

```java
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
```

- In `main()`, create `new Employee("Rubeus", "Hagrid", 50000)` and call `showName()` and `showSalary()`.  

---

## 🤖 Part 2 – Robot Code (2 pts)

> **Not written yet.** Lesson 33 is **optional** this offseason, so its robot half was never rewritten for the 2026 robot. What used to be here was a 2025 draft describing hardware this robot doesn't have, so it has been taken out rather than left to send you down a dead end. **Skip Parts 2 and 3 for now.**
>
> Ahead of the pace and want the points anyway? Ask a mentor. Writing this half with you is a good use of a meeting.

---

## 📜 Part 3 – Code Archaeology (2 pts, optional)

> Not written yet. See Part 2.

---

## 🏆 Total Points
- **Max right now:** 2 pts  
  - Java‑Only: 2 pts  
  - Robot Code and Code Archaeology: they come back if this lesson gets a 2026 robot half

---

<!-- Drafting notes from the transcript draft. Hidden from students.
Ideas:  
- Emphasize that `super` = parent.  
- Robot code: subsystems inherit from a base class, use `super` for shared setup.  
- Archaeology: replace repeated initialization with `super(...)`.  
- Segue: Next lesson → **Method Overriding with super** (child redefines parent method but can still call parent’s version).  
-->
