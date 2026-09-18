# 🖥️ Lesson 52 – HashMaps in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🗂️  

---

## 🎯 Overview
**Keywords:** Java, HashMap, Key-Value Pairs, Collections Framework, Generics  
Learn to:
- Understand that **HashMap** stores data as **key-value pairs**  
- Recognize that **keys must be unique**, but **values can be duplicated**  
- Create a `HashMap<K, V>` with type parameters for key and value  
- Add, update, remove, and retrieve elements  
- Check for existence of keys/values with `containsKey()` and `containsValue()`  
- Iterate through a HashMap with `for-each` loops  

---

## ⏱️ Progress Tracking

### 📊 For the Marathon Watchers  
If you’re following the **full 12‑hour compilation** and want to see how far you’ve made it through the *entire* course:  
- **Start Time in 12‑Hour Video:** [10:52:09](https://www.youtube.com/watch?v=xTtL8E4LzTQ&t=39129s)  
- **Full Course (12h video):** [Watch Compilation](https://www.youtube.com/watch?v=xTtL8E4LzTQ)

---

### 🎯 For the Quick‑Hit Learners  
If you just want **this lesson only** and to be done with it — no scrubbing through hours of footage:  
- **Lesson Playlist:** [Java tutorial for beginners (2025) ☕](https://www.youtube.com/playlist?list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc)  
- **This Lesson Only:** [Watch Lesson 52](https://www.youtube.com/watch?v=NMHk1CGb28o&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=67) (Java hashmaps are easy! 🗺️, 10:31)

---

## 💻 Part 1 – Java‑Only (2 pts)

> In the code below, the `import` line goes at the **top** of your `Main.java`, and the rest goes **inside** `main`. Keep the `public class Main extends BaseLesson` line your file already has: without `extends BaseLesson`, the lesson runner can't run it.

**Basic (1 pt)**  
- Create a HashMap with `String` keys and `Double` values:  

```java
// at the top of the file:
import java.util.HashMap;

// inside main:
HashMap<String, Double> map = new HashMap<>();

// Add items
map.put("Apple", 0.50);
map.put("Orange", 0.75);
map.put("Banana", 0.25);

System.out.println(map);
```

- Keys must be unique. Adding another `"Orange"` overwrites the old value:  

```java
map.put("Orange", 1000000.0); // overwrites previous price
```

**Extra (1 pt)**  
- Add, remove, and retrieve values:  

```java
map.put("Coconut", 1.00);
System.out.println(map); // includes Coconut

map.remove("Apple");
System.out.println(map); // Apple removed

System.out.println("Coconut price: " + map.get("Coconut")); // 1.0
```

- Check for keys and values:  

```java
System.out.println(map.containsKey("Banana")); // true
System.out.println(map.containsKey("Pineapple")); // false

System.out.println(map.containsValue(1.0)); // true
System.out.println(map.containsValue(1));   // false (wrong type)
```

- Use `containsKey` the way the video does, before you `get`:  

```java
if (map.containsKey("Pineapple")) {
    System.out.println(map.get("Pineapple"));
} else {
    System.out.println("Key not found");
}
```

- Get the size of the map:  

```java
System.out.println("Map size: " + map.size());
```

- Iterate with a for-each loop:  

```java
for (String key : map.keySet()) {
    System.out.println(key + ": $" + map.get(key));
}
```

---

## 🤖 Part 2 – Robot Code (2 pts)

**Basic (1 pt)**  
- Use a HashMap to store subsystem names and their status:  

```java
HashMap<String, String> subsystems = new HashMap<>();
subsystems.put("DriveTrain", "OK");
subsystems.put("Arm", "OK");
subsystems.put("Shooter", "Needs Calibration");

for (String key : subsystems.keySet()) {
    SmartDashboard.putString(key, subsystems.get(key));
}
```

**Extra (1 pt)**  
- Store motor IDs and their power levels:  

```java
HashMap<String, Double> motorPowers = new HashMap<>();
motorPowers.put("LeftMotor", 0.75);
motorPowers.put("RightMotor", 0.80);

for (String motor : motorPowers.keySet()) {
    SmartDashboard.putNumber(motor, motorPowers.get(motor));
}
```

---

## 📜 Part 3 – Code Archaeology (2 pts)

**Basic (1 pt)**  
- Find a section of last year’s robot code where multiple variables tracked subsystem states individually.  
- Suggest replacing them with a **HashMap** for cleaner organization.  

**Extra (1 pt)**  
- Suggest improvements:  
  - Use `HashMap<String, Double>` for sensor readings.  
  - Use `HashMap<String, Boolean>` for toggles (enabled/disabled).  
  - Iterate through maps to display all values dynamically.  

```java
// Before
double leftMotor = 0.75;
double rightMotor = 0.80;

// After
HashMap<String, Double> motors = new HashMap<>();
motors.put("LeftMotor", 0.75);
motors.put("RightMotor", 0.80);

for (String motor : motors.keySet()) {
    System.out.println(motor + ": " + motors.get(motor));
}
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
- Emphasize HashMap = key-value pairs, unique keys, duplicate values allowed.  
- Robot code: store subsystem states or motor powers.  
- Archaeology: replace scattered variables with HashMaps.  
- Segue: Next lesson → **LinkedHashMap & TreeMap** (ordered maps).  
-->
