# 🖥️ Lesson 41 – Aggregation in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🐝  

---

## 🎯 Overview
**Keywords:** Java, Aggregation, Has‑A Relationship, Objects, Encapsulation  
Learn to:
- Understand **aggregation**: a “has‑a” relationship where one object contains another  
- Recognize that aggregated objects can **exist independently** of their container  
- Create classes that demonstrate aggregation (e.g., `Library` has `Book` objects)  
- Use arrays of objects to represent collections inside another class  
- Differentiate **aggregation** from **composition** (composition = stronger relationship, objects cannot exist independently)  

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
- Create a `Book` class with attributes and a method to display info:  

[CODE BLOCK]java
public class Book {
    String title;
    int pages;

    Book(String title, int pages) {
        this.title = title;
        this.pages = pages;
    }

    String displayInfo() {
        return this.title + " (" + this.pages + " pages)";
    }
}
[CODE BLOCK]

- Create a few `Book` objects and store them in an array.  

**Extra (1 pt)**  
- Create a `Library` class that **aggregates** `Book` objects:  

[CODE BLOCK]java
public class Library {
    String name;
    int year;
    Book[] books;

    Library(String name, int year, Book[] books) {
        this.name = name;
        this.year = year;
        this.books = books;
    }

    void displayInfo() {
        System.out.println(this.year + " " + this.name);
        System.out.println("Books available:");
        for (Book b : books) {
            System.out.println(b.displayInfo());
        }
    }
}
[CODE BLOCK]

- Demonstrate usage:  

[CODE BLOCK]java
Book b1 = new Book("The Fellowship of the Ring", 423);
Book b2 = new Book("The Two Towers", 352);
Book b3 = new Book("The Return of the King", 416);

Book[] books = { b1, b2, b3 };

Library library = new Library("New York City Public Library", 1897, books);
library.displayInfo();
[CODE BLOCK]

---

## 🤖 Part 2 – Robot Code (2 pts)

**Basic (1 pt)**  
- Create a `Motor` class with attributes: `id`, `speed`.  
- Create a `Robot` class that **aggregates** multiple `Motor` objects.  

**Extra (1 pt)**  
- Add a `displayInfo()` method in `Robot` to print all motors’ info to **SmartDashboard**.  

[CODE BLOCK]java
public class Motor {
    String id;
    double speed;

    Motor(String id, double speed) {
        this.id = id;
        this.speed = speed;
    }

    String displayInfo() {
        return id + " running at " + speed;
    }
}

public class Robot {
    String name;
    Motor[] motors;

    Robot(String name, Motor[] motors) {
        this.name = name;
        this.motors = motors;
    }

    void displayInfo() {
        SmartDashboard.putString("Robot", name);
        for (Motor m : motors) {
            SmartDashboard.putString(m.id, m.displayInfo());
        }
    }
}
[CODE BLOCK]

---

## 📜 Part 3 – Code Archaeology (2 pts)

**Basic (1 pt)**  
- Find a section of last year’s robot code where subsystems contained collections of parts (e.g., drivetrain with multiple motors).  
- Suggest replacing them with **aggregation**: a `DriveTrain` class that has `Motor[]`.  

**Extra (1 pt)**  
- Suggest improvements:  
  - Replace repeated variables with arrays of objects.  
  - Use aggregation to group related objects logically.  

[CODE BLOCK]java
public class DriveTrain {
    Motor[] motors;

    DriveTrain(Motor[] motors) {
        this.motors = motors;
    }

    void displayInfo() {
        for (Motor m : motors) {
            System.out.println(m.displayInfo());
        }
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
- Emphasize that aggregation = “has‑a” relationship, but objects can live independently.  
- Robot code: robot has motors, but motors can exist outside robot.  
- Archaeology: replace scattered variables with aggregated collections.  
- Segue: Next lesson → **Composition** (stronger relationship, objects cannot exist independently).  
[CODE BLOCK]
