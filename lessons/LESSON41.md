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
If you’re following the **full 12‑hour compilation** and want to see how far you’ve made it through the *entire* course:  
- **Start Time in 12‑Hour Video:** [08:29:39](https://www.youtube.com/watch?v=xTtL8E4LzTQ&t=30579s)  
- **Full Course (12h video):** [Watch Compilation](https://www.youtube.com/watch?v=xTtL8E4LzTQ)

---

### 🎯 For the Quick‑Hit Learners  
If you just want **this lesson only** and to be done with it — no scrubbing through hours of footage:  
- **Lesson Playlist:** [Java tutorial for beginners (2025) ☕](https://www.youtube.com/playlist?list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc)  
- **This Lesson Only:** [Watch Lesson 41](https://www.youtube.com/watch?v=pqQAHA1XjJk&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=53) (Learn Java AGGREGATION in 9 minutes! 🏫, 9:26)

---

## 💻 Part 1 – Java‑Only (2 pts)

> Each class gets its own file next to `Main.java`, starting with the same `package` line, like lesson 27 (`package lesson41.basic;`, and `package lesson41.extra;` for the extra's copies).

**Basic (1 pt)**  
- Create a `Book` class with attributes and a method to display info:  

```java
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
```

- Create a few `Book` objects and store them in an array.  
- Print every book's `displayInfo()` with an enhanced `for` loop.  

**Extra (1 pt)**  
- Create a `Library` class that **aggregates** `Book` objects:  

```java
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
```

- Demonstrate usage:  

```java
Book b1 = new Book("The Fellowship of the Ring", 423);
Book b2 = new Book("The Two Towers", 352);
Book b3 = new Book("The Return of the King", 416);

Book[] books = { b1, b2, b3 };

Library library = new Library("New York City Public Library", 1897, books);
library.displayInfo();
```

- After the library, print `b1.displayInfo()` on its own. The book was built **before** the library and doesn't need it: that independence is what makes this aggregation. Lesson 42's composition is the opposite.  

---

## 🤖 Part 2 – Robot Code (2 pts)

> **Not written yet.** Lesson 41 is **optional** this offseason, so its robot half was never rewritten for the 2026 robot. What used to be here was a 2025 draft describing hardware this robot doesn't have, so it has been taken out rather than left to send you down a dead end. **Skip Parts 2 and 3 for now.**
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
- Emphasize that aggregation = “has‑a” relationship, but objects can live independently.  
- Robot code: robot has motors, but motors can exist outside robot.  
- Archaeology: replace scattered variables with aggregated collections.  
- Segue: Next lesson → **Composition** (stronger relationship, objects cannot exist independently).  
-->
