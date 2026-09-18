# 🖥️ Lesson 44 – ArrayLists in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 📚  

---

## 🎯 Overview
**Keywords:** Java, ArrayList, Collections Framework, Autoboxing, Dynamic Arrays  
Learn to:
- Understand that **ArrayLists** are resizable arrays that store **objects**  
- Use **wrapper classes** (Integer, Double, etc.) to store primitives via **autoboxing**  
- Add, remove, set, and get elements dynamically  
- Use `Collections.sort()` to sort ArrayLists  
- Iterate through ArrayLists with **enhanced for loops**  
- Accept **user input** to populate an ArrayList  

---

## ⏱️ Progress Tracking

### 📊 For the Marathon Watchers  
If you’re following the **full 12‑hour compilation** and want to see how far you’ve made it through the *entire* course:  
- **Start Time in 12‑Hour Video:** [08:55:51](https://www.youtube.com/watch?v=xTtL8E4LzTQ&t=32151s)  
- **Full Course (12h video):** [Watch Compilation](https://www.youtube.com/watch?v=xTtL8E4LzTQ)

---

### 🎯 For the Quick‑Hit Learners  
If you just want **this lesson only** and to be done with it — no scrubbing through hours of footage:  
- **Lesson Playlist:** [Java tutorial for beginners (2025) ☕](https://www.youtube.com/playlist?list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc)  
- **This Lesson Only:** [Watch Lesson 44](https://www.youtube.com/watch?v=wsTSREgCE5E&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=56) (Learn Java arraylists in 9 minutes! 📃, 9:40)

---

## 💻 Part 1 – Java‑Only (2 pts)

**Basic (1 pt)**  
- Import the ArrayList class:  
  `import java.util.ArrayList;`

- Create an ArrayList of integers:  

```java
ArrayList<Integer> numbers = new ArrayList<>();
numbers.add(3);
numbers.add(1);
numbers.add(2);

System.out.println(numbers); // [3, 1, 2]
```

- Create an ArrayList of strings:  

```java
ArrayList<String> fruits = new ArrayList<>();
fruits.add("Apple");
fruits.add("Orange");
fruits.add("Banana");
fruits.add("Coconut");

System.out.println(fruits); // [Apple, Orange, Banana, Coconut]
```

**Extra (1 pt)**  
- Demonstrate ArrayList methods:  

```java
fruits.remove(0); // removes Apple
fruits.set(0, "Pineapple"); // replaces Orange with Pineapple
System.out.println(fruits.get(1)); // Banana
System.out.println(fruits.size()); // 3
```

- Sort with Collections:  

```java
import java.util.Collections; // this line goes at the TOP of the file, with the other imports

Collections.sort(fruits);       // this one goes in main
System.out.println(fruits); // [Banana, Coconut, Pineapple]
```

- Iterate with enhanced for loop:  

```java
for (String fruit : fruits) {
    System.out.println(fruit);
}
```

- **The video's exercise, a food list from user input:**  
  - Create an empty `ArrayList<String> foods` and a `Scanner`.  
  - Ask `"Enter the number of food you would like: "` and read it with `nextInt()`, then call `scanner.nextLine()` once to clear the leftover new line (lesson 03).  
  - Loop that many times, asking `"Enter food #" + i + ": "`, and `foods.add(...)` each answer.  
  - Print the whole list. Unlike lesson 23's array, you never had to pick its size up front.  

---

## 🤖 Part 2 – Robot Code (2 pts)

**Basic (1 pt)**  
- Use ArrayLists to store motor speeds:  

```java
ArrayList<Double> motorSpeeds = new ArrayList<>();
motorSpeeds.add(0.5);
motorSpeeds.add(0.75);
motorSpeeds.add(1.0);

for (Double speed : motorSpeeds) {
    SmartDashboard.putNumber("Motor Speed", speed);
}
```

**Extra (1 pt)**  
- Accept sensor readings as strings, parse them, and add to an ArrayList:  

```java
ArrayList<Integer> voltages = new ArrayList<>();
voltages.add(Integer.parseInt("12"));
voltages.add(Integer.parseInt("11"));
voltages.add(Integer.parseInt("13"));

for (Integer v : voltages) {
    SmartDashboard.putNumber("Voltage", v);
}
```

---

## 📜 Part 3 – Code Archaeology (2 pts)

**Basic (1 pt)**  
- Find a section of last year’s robot code where multiple values were stored in fixed arrays.  
- Suggest replacing them with **ArrayLists** for flexibility.  

**Extra (1 pt)**  
- Suggest improvements:  
  - Use `ArrayList<Double>` for dynamic motor speeds.  
  - Use `ArrayList<String>` for logging subsystem states.  
  - Use `Collections.sort()` to order values when needed.  

```java
// Before
double[] speeds = {0.5, 0.75, 1.0};

// After
ArrayList<Double> speeds = new ArrayList<>();
speeds.add(0.5);
speeds.add(0.75);
speeds.add(1.0);
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
- Emphasize ArrayLists = resizable arrays.  
- Robot code: store motor speeds or sensor readings dynamically.  
- Archaeology: replace fixed arrays with ArrayLists for flexibility.  
- Segue: Next lesson → **For‑Each Loops with ArrayLists** (iterating collections more efficiently).  
-->
