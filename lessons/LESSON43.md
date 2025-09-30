# 🖥️ Lesson 43 – Wrapper Classes in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🎁  

---

## 🎯 Overview
**Keywords:** Java, Wrapper Classes, Autoboxing, Unboxing, Utility Methods, Parsing  
Learn to:
- Understand **wrapper classes**: objects that wrap primitive values (int → Integer, double → Double, etc.)  
- Recognize when wrapper classes are needed (e.g., **Collections Framework** like `ArrayList`)  
- Use **autoboxing** (automatic conversion from primitive → wrapper)  
- Use **unboxing** (automatic conversion from wrapper → primitive)  
- Apply **static utility methods** from wrapper classes (`toString()`, `parseXxx()`, `isLetter()`, etc.)  

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
- Wrapping primitives (old/deprecated way):  

[CODE BLOCK]java
Integer a = new Integer(123);     // int → Integer
Double b = new Double(3.14);      // double → Double
Character c = new Character('$'); // char → Character
Boolean d = new Boolean(true);    // boolean → Boolean
[CODE BLOCK]

- Modern way: **autoboxing**  

[CODE BLOCK]java
Integer a = 123;
Double b = 3.14;
Character c = '$';
Boolean d = true;
[CODE BLOCK]

**Extra (1 pt)**  
- **Unboxing**: converting wrapper → primitive  

[CODE BLOCK]java
int x = a;       // Integer → int
double y = b;    // Double → double
char z = c;      // Character → char
boolean flag = d;// Boolean → boolean
[CODE BLOCK]

- **Utility methods**:  

[CODE BLOCK]java
// Convert primitive to String
String s1 = Integer.toString(123);
String s2 = Double.toString(3.14);
String s3 = Character.toString('$');
String s4 = Boolean.toString(false);

// Convert String to primitive
int i = Integer.parseInt("123");
double d2 = Double.parseDouble("3.14");
boolean b2 = Boolean.parseBoolean("true");

// Character checks
char letter = 'b';
System.out.println(Character.isLetter(letter));   // true
System.out.println(Character.isUpperCase(letter));// false
[CODE BLOCK]

---

## 🤖 Part 2 – Robot Code (2 pts)

**Basic (1 pt)**  
- Use wrapper classes with **ArrayList** (since ArrayList only works with objects).  

[CODE BLOCK]java
ArrayList<Integer> speeds = new ArrayList<>();
speeds.add(50);   // autoboxing: int → Integer
speeds.add(75);
speeds.add(100);

for (Integer s : speeds) {
    SmartDashboard.putNumber("Speed", s);
}
[CODE BLOCK]

**Extra (1 pt)**  
- Parse sensor values from strings:  

[CODE BLOCK]java
String voltageReading = "12";
int voltage = Integer.parseInt(voltageReading);

String tempReading = "36.5";
double temperature = Double.parseDouble(tempReading);

SmartDashboard.putNumber("Voltage", voltage);
SmartDashboard.putNumber("Temperature", temperature);
[CODE BLOCK]

---

## 📜 Part 3 – Code Archaeology (2 pts)

**Basic (1 pt)**  
- Find a section of last year’s robot code where primitives were stored in collections.  
- Suggest replacing them with **wrapper classes** (e.g., `ArrayList<Integer>` instead of `ArrayList<int>`).  

**Extra (1 pt)**  
- Suggest improvements:  
  - Use wrapper utility methods for parsing sensor data from strings.  
  - Use `Character.isLetter()` or `Character.isDigit()` for validating user input.  

[CODE BLOCK]java
// Before
// ArrayList<int> speeds; // invalid

// After
ArrayList<Integer> speeds = new ArrayList<>();
speeds.add(60);
speeds.add(80);
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
- Emphasize wrapper classes = objects for primitives.  
- Robot code: ArrayLists require wrapper classes.  
- Archaeology: replace invalid primitive collections with wrapper equivalents.  
- Segue: Next lesson → **ArrayLists** (dynamic arrays that only work with objects).  
[CODE BLOCK]
