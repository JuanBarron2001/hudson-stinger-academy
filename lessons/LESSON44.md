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
- **Start Time in 12‑Hour Video:** [blank]  
- **Full Course (12h video):** [link here]  

---

### 🎯 For the Quick‑Hit Learners  
- **Lesson Playlist:** [link here]  
- **This Lesson Only:** [link here]  

---

## 💻 Part 1 – Java‑Only (2 pts)

**Basic (1 pt)**  
- Import the ArrayList class:  
  `import java.util.ArrayList;`

- Create an ArrayList of integers:  

[CODE BLOCK]java
ArrayList<Integer> numbers = new ArrayList<>();
numbers.add(3);
numbers.add(1);
numbers.add(2);

System.out.println(numbers); // [3, 1, 2]
[CODE BLOCK]

- Create an ArrayList of strings:  

[CODE BLOCK]java
ArrayList<String> fruits = new ArrayList<>();
fruits.add("Apple");
fruits.add("Orange");
fruits.add("Banana");
fruits.add("Coconut");

System.out.println(fruits); // [Apple, Orange, Banana, Coconut]
[CODE BLOCK]

**Extra (1 pt)**  
- Demonstrate ArrayList methods:  

[CODE BLOCK]java
fruits.remove(0); // removes Apple
fruits.set(0, "Pineapple"); // replaces Orange with Pineapple
System.out.println(fruits.get(1)); // Banana
System.out.println(fruits.size()); // 3
[CODE BLOCK]

- Sort with Collections:  

[CODE BLOCK]java
import java.util.Collections;

Collections.sort(fruits);
System.out.println(fruits); // [Banana, Coconut, Pineapple]
[CODE BLOCK]

- Iterate with enhanced for loop:  

[CODE BLOCK]java
for (String fruit : fruits) {
    System.out.println(fruit);
}
[CODE BLOCK]

---

## 🤖 Part 2 – Robot Code (2 pts)

**Basic (1 pt)**  
- Use ArrayLists to store motor speeds:  

[CODE BLOCK]java
ArrayList<Double> motorSpeeds = new ArrayList<>();
motorSpeeds.add(0.5);
motorSpeeds.add(0.75);
motorSpeeds.add(1.0);

for (Double speed : motorSpeeds) {
    SmartDashboard.putNumber("Motor Speed", speed);
}
[CODE BLOCK]

**Extra (1 pt)**  
- Accept sensor readings as strings, parse them, and add to an ArrayList:  

[CODE BLOCK]java
ArrayList<Integer> voltages = new ArrayList<>();
voltages.add(Integer.parseInt("12"));
voltages.add(Integer.parseInt("11"));
voltages.add(Integer.parseInt("13"));

for (Integer v : voltages) {
    SmartDashboard.putNumber("Voltage", v);
}
[CODE BLOCK]

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

[CODE BLOCK]java
// Before
double[] speeds = {0.5, 0.75, 1.0};

// After
ArrayList<Double> speeds = new ArrayList<>();
speeds.add(0.5);
speeds.add(0.75);
speeds.add(1.0);
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
- Emphasize ArrayLists = resizable arrays.  
- Robot code: store motor speeds or sensor readings dynamically.  
- Archaeology: replace fixed arrays with ArrayLists for flexibility.  
- Segue: Next lesson → **For‑Each Loops with ArrayLists** (iterating collections more efficiently).  
[CODE BLOCK]
