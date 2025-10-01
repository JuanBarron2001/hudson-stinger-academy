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
- **Start Time in 12‑Hour Video:** [blank]  
- **Full Course (12h video):** [link here]  

---

### 🎯 For the Quick‑Hit Learners  
- **Lesson Playlist:** [link here]  
- **This Lesson Only:** [link here]  

---

## 💻 Part 1 – Java‑Only (2 pts)

**Basic (1 pt)**  
- Generics are everywhere in Java. For example, `ArrayList<E>`:  

[CODE BLOCK]java
import java.util.ArrayList;

ArrayList<String> fruits = new ArrayList<>();
fruits.add("Apple");
fruits.add("Orange");
fruits.add("Banana");

System.out.println(fruits); // [Apple, Orange, Banana]
[CODE BLOCK]

- If you change the type argument to `Integer`, you can only store numbers:  

[CODE BLOCK]java
ArrayList<Integer> numbers = new ArrayList<>();
numbers.add(1);
numbers.add(2);
numbers.add(3);
[CODE BLOCK]

---

- Create a **generic Box class**:  

[CODE BLOCK]java
public class Box<T> {
    private T item;

    public void setItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }
}
[CODE BLOCK]

- Usage:  

[CODE BLOCK]java
Box<String> stringBox = new Box<>();
stringBox.setItem("Banana");
System.out.println(stringBox.getItem()); // Banana

Box<Integer> intBox = new Box<>();
intBox.setItem(3);
System.out.println(intBox.getItem()); // 3
[CODE BLOCK]

---

**Extra (1 pt)**  
- Create a **Product class** with two type parameters:  

[CODE BLOCK]java
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
[CODE BLOCK]

- Usage with different type arguments:  

[CODE BLOCK]java
Product<String, Double> product1 = new Product<>("Apple", 0.5);
System.out.println(product1.getItem());  // Apple
System.out.println(product1.getPrice()); // 0.5

Product<String, Integer> product2 = new Product<>("Ticket", 15);
System.out.println(product2.getItem());  // Ticket
System.out.println(product2.getPrice()); // 15
[CODE BLOCK]

---

## 🤖 Part 2 – Robot Code (2 pts)

**Basic (1 pt)**  
- Use generics to represent robot parts:  

[CODE BLOCK]java
Product<String, Double> motor = new Product<>("Left Motor", 0.75);
SmartDashboard.putString("Motor", motor.getItem());
SmartDashboard.putNumber("Motor Power", motor.getPrice());
[CODE BLOCK]

**Extra (1 pt)**  
- Use generics for counters or tickets in robot events:  

[CODE BLOCK]java
Product<String, Integer> matchTickets = new Product<>("Match Tickets", 15);
SmartDashboard.putString("Item", matchTickets.getItem());
SmartDashboard.putNumber("Price", matchTickets.getPrice());
[CODE BLOCK]

---

## 📜 Part 3 – Code Archaeology (2 pts)

**Basic (1 pt)**  
- Find a section of last year’s robot code where multiple classes were written for different data types (e.g., `MotorDouble`, `MotorInt`).  
- Suggest replacing them with a **generic class**.  

**Extra (1 pt)**  
- Suggest improvements:  
  - Use `<T, U>` to handle both identifiers and values.  
  - Reduce code duplication by writing one generic class instead of many.  

[CODE BLOCK]java
// Before: separate classes
class MotorDouble { String id; double power; }
class MotorInt { String id; int power; }

// After: generic class
class Motor<T> {
    String id;
    T power;
    Motor(String id, T power) {
        this.id = id;
        this.power = power;
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
- Combine Part I and Part II into one complete Generics lesson.  
- Emphasize type parameters (`<T>`) vs. type arguments (`<String>`).  
- Show single-type (`Box<T>`) and multi-type (`Product<T, U>`) examples.  
- Robot code: flexible subsystems with generics.  
- Archaeology: replace duplicate classes with one generic class.  
- Segue: Next lesson → **Generic Methods & Bounded Types** (`<T extends Number>`).  
[CODE BLOCK]
