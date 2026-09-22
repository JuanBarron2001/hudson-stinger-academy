# 🖥️ Lesson 51 – Generics in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 📦  

---

## 🎯 Overview
**Keywords:** Java, Generics, Type Parameters, Type Arguments, Type Safety  
Learn to:
- Understand **generics**: write classes, interfaces, or methods compatible with many data types  
- Differentiate between **type parameters** (placeholders like `<T>`) and **type arguments** (actual types like `<String>`)  
- Recognize how generics enforce **compile-time type safety**  
- Build reusable classes with **single** and **multiple type parameters**  
- Apply generics in real-world examples (`ArrayList`, `Box<T>`, `Product<T, U>`)  

---

## ⏱️ Progress Tracking

### 📊 For the Marathon Watchers  
If you’re following the **full 12‑hour compilation** and want to see how far you’ve made it through the *entire* course:  
- **Start Time in 12‑Hour Video:** [10:38:16](https://www.youtube.com/watch?v=xTtL8E4LzTQ&t=38296s)  
- **Full Course (12h video):** [Watch Compilation](https://www.youtube.com/watch?v=xTtL8E4LzTQ)

---

### 🎯 For the Quick‑Hit Learners  
If you just want **this lesson only** and to be done with it — no scrubbing through hours of footage:  
- **Lesson Playlist:** [Java tutorial for beginners (2025) ☕](https://www.youtube.com/playlist?list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc)  
- **This Lesson Only:** [Watch Lesson 51](https://www.youtube.com/watch?v=H9vc4gTtGGA&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=66) (Learn Java generics in 13 minutes! 📦, 13:56)

---

## 💻 Part 1 – Java‑Only (2 pts)

> `import` lines go at the **top** of your `Main.java`, and statements go **inside** `main`. New classes like `Box` get their own file next to `Main.java`, starting with the same `package` line, like lesson 27 (`package lesson51.basic;`, and `package lesson51.extra;` for the extra's copies).

**Basic (1 pt)**  
- Generics are everywhere in Java. For example, `ArrayList<E>`:  

```java
import java.util.ArrayList; // at the top of the file

ArrayList<String> fruits = new ArrayList<>();
fruits.add("Apple");
fruits.add("Orange");
fruits.add("Banana");

System.out.println(fruits); // [Apple, Orange, Banana]
```

- If you change the type argument to `Integer`, you can only store numbers:  

```java
ArrayList<Integer> numbers = new ArrayList<>();
numbers.add(1);
numbers.add(2);
numbers.add(3);
```

---

- Create a **generic Box class**:  

```java
public class Box<T> {
    private T item;

    public void setItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }
}
```

- Usage:  

```java
Box<String> stringBox = new Box<>();
stringBox.setItem("Banana");
System.out.println(stringBox.getItem()); // Banana

Box<Integer> intBox = new Box<>();
intBox.setItem(3);
System.out.println(intBox.getItem()); // 3
```

- Now try `intBox.setItem("Banana");` and read the error. The `<Integer>` you wrote is the **type argument**: it fills in the `T` for that box, and Java checks it before the program ever runs. Delete the line.  

---

**Extra (1 pt)**  
- Create a **Product class** with two type parameters:  

```java
public class Product<T, U> {
    private T item;
    private U price;

    public Product(T item, U price) {
        this.item = item;
        this.price = price;
    }

    public T getItem() {
        return item;
    }

    public U getPrice() {
        return price;
    }
}
```

- Usage with different type arguments:  

```java
Product<String, Double> product1 = new Product<>("Apple", 0.5);
System.out.println(product1.getItem());  // Apple
System.out.println(product1.getPrice()); // 0.5

Product<String, Integer> product2 = new Product<>("Ticket", 15);
System.out.println(product2.getItem());  // Ticket
System.out.println(product2.getPrice()); // 15
```

---

## 🤖 Part 2 – Robot Code (2 pts)

> **Not written yet.** Lesson 51 is **optional** this offseason, so its robot half was never rewritten for the 2026 robot. What used to be here was a 2025 draft describing hardware this robot doesn't have, so it has been taken out rather than left to send you down a dead end. **Skip Parts 2 and 3 for now.**
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
- Combine Part I and Part II into one complete Generics lesson.  
- Emphasize type parameters (`<T>`) vs. type arguments (`<String>`).  
- Show single-type (`Box<T>`) and multi-type (`Product<T, U>`) examples.  
- Robot code: flexible subsystems with generics.  
- Archaeology: replace duplicate classes with one generic class.  
- Segue: Next lesson → **Generic Methods & Bounded Types** (`<T extends Number>`).  
-->
