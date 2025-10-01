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
- **Start Time in 12‑Hour Video:** [blank]  
- **Full Course (12h video):** [link here]  

---

### 🎯 For the Quick‑Hit Learners  
- **Lesson Playlist:** [link here]  
- **This Lesson Only:** [link here]  

---

## 💻 Part 1 – Java‑Only (2 pts)

**Basic (1 pt)**  
- Create a HashMap with `String` keys and `Double` values:  

[CODE BLOCK]java
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Double> map = new HashMap<>();

        // Add items
        map.put("Apple", 0.50);
        map.put("Orange", 0.75);
        map.put("Banana", 0.25);

        System.out.println(map);
    }
}
[CODE BLOCK]

- Keys must be unique. Adding another `"Orange"` overwrites the old value:  

[CODE BLOCK]java
map.put("Orange", 1000000.0); // overwrites previous price
[CODE BLOCK]

**Extra (1 pt)**  
- Add, remove, and retrieve values:  

[CODE BLOCK]java
map.put("Coconut", 1.00);
System.out.println(map); // includes Coconut

map.remove("Apple");
System.out.println(map); // Apple removed

System.out.println("Coconut price: " + map.get("Coconut")); // 1.0
[CODE BLOCK]

- Check for keys and values:  

[CODE BLOCK]java
System.out.println(map.containsKey("Banana")); // true
System.out.println(map.containsKey("Pineapple")); // false

System.out.println(map.containsValue(1.0)); // true
System.out.println(map.containsValue(1));   // false (wrong type)
[CODE BLOCK]

- Get the size of the map:  

[CODE BLOCK]java
System.out.println("Map size: " + map.size());
[CODE BLOCK]

- Iterate with a for-each loop:  

[CODE BLOCK]java
for (String key : map.keySet()) {
    System.out.println(key + ": $" + map.get(key));
}
[CODE BLOCK]

---

## 🤖 Part 2 – Robot Code (2 pts)

**Basic (1 pt)**  
- Use a HashMap to store subsystem names and their status:  

[CODE BLOCK]java
HashMap<String, String> subsystems = new HashMap<>();
subsystems.put("DriveTrain", "OK");
subsystems.put("Arm", "OK");
subsystems.put("Shooter", "Needs Calibration");

for (String key : subsystems.keySet()) {
    SmartDashboard.putString(key, subsystems.get(key));
}
[CODE BLOCK]

**Extra (1 pt)**  
- Store motor IDs and their power levels:  

[CODE BLOCK]java
HashMap<String, Double> motorPowers = new HashMap<>();
motorPowers.put("LeftMotor", 0.75);
motorPowers.put("RightMotor", 0.80);

for (String motor : motorPowers.keySet()) {
    SmartDashboard.putNumber(motor, motorPowers.get(motor));
}
[CODE BLOCK]

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

[CODE BLOCK]java
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
- Emphasize HashMap = key-value pairs, unique keys, duplicate values allowed.  
- Robot code: store subsystem states or motor powers.  
- Archaeology: replace scattered variables with HashMaps.  
- Segue: Next lesson → **LinkedHashMap & TreeMap** (ordered maps).  
[CODE BLOCK]
