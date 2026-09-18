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
If you’re following the **full 12‑hour compilation** and want to see how far you’ve made it through the *entire* course:  
- **Start Time in 12‑Hour Video:** [08:45:17](https://www.youtube.com/watch?v=xTtL8E4LzTQ&t=31517s)  
- **Full Course (12h video):** [Watch Compilation](https://www.youtube.com/watch?v=xTtL8E4LzTQ)

---

### 🎯 For the Quick‑Hit Learners  
If you just want **this lesson only** and to be done with it — no scrubbing through hours of footage:  
- **Lesson Playlist:** [Java tutorial for beginners (2025) ☕](https://www.youtube.com/playlist?list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc)  
- **This Lesson Only:** [Watch Lesson 43](https://www.youtube.com/watch?v=5bt07czziV4&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=55) (Learn WRAPPER CLASSES in 10 minutes! 🎁, 10:36)

---

## 💻 Part 1 – Java‑Only (2 pts)

**Basic (1 pt)**  
- Wrapping primitives the old way. **Just read this one, don't type it:** these constructors are deprecated, and Java now warns that they'll be removed. It's the clearest picture of what "wrapping" means, though: the number goes inside an object.  

```java
Integer a = new Integer(123);     // int → Integer
Double b = new Double(3.14);      // double → Double
Character c = new Character('$'); // char → Character
Boolean d = new Boolean(true);    // boolean → Boolean
```

- The modern way, **autoboxing**. Type this one: Java wraps each value for you.  

```java
Integer a = 123;
Double b = 3.14;
Character c = '$';
Boolean d = true;
```

- Print all four. They look like plain values, but each one is an object now.  

**Extra (1 pt)**  
- **Unboxing**: converting wrapper → primitive  

```java
int x = a;       // Integer → int
double y = b;    // Double → double
char z = c;      // Character → char
boolean flag = d;// Boolean → boolean
```

- **Utility methods**:  

```java
// Convert primitive to String
String s1 = Integer.toString(123);
String s2 = Double.toString(3.14);
String s3 = Character.toString('$');
String s4 = Boolean.toString(false);

// Convert String to primitive
int i = Integer.parseInt("123");
double d2 = Double.parseDouble("3.14");
boolean b2 = Boolean.parseBoolean("true");

// There's no Character.parseChar: take the first letter of a String instead
char first = "pizza".charAt(0);

// Character checks
char letter = 'b';
System.out.println(Character.isLetter(letter));   // true
System.out.println(Character.isUpperCase(letter));// false
```

- Print `s1 + s2 + s3 + s4`. You get one long `String`, `1233.14$false`, because every piece is a `String` now. Then try `i + d2`: numbers add up instead of sticking together.  
- Try `Character.isLetter('$')`. Checks like these are how you'd validate a username or password.  

---

## 🤖 Part 2 – Robot Code (2 pts)

**Basic (1 pt)**  
- Use wrapper classes with **ArrayList** (since ArrayList only works with objects; lesson 44 covers `ArrayList`).  

```java
ArrayList<Integer> speeds = new ArrayList<>();
speeds.add(50);   // autoboxing: int → Integer
speeds.add(75);
speeds.add(100);

for (Integer s : speeds) {
    SmartDashboard.putNumber("Speed", s);
}
```

**Extra (1 pt)**  
- Parse sensor values from strings:  

```java
String voltageReading = "12";
int voltage = Integer.parseInt(voltageReading);

String tempReading = "36.5";
double temperature = Double.parseDouble(tempReading);

SmartDashboard.putNumber("Voltage", voltage);
SmartDashboard.putNumber("Temperature", temperature);
```

---

## 📜 Part 3 – Code Archaeology (2 pts)

**Basic (1 pt)**  
- Find a section of last year’s robot code where primitives were stored in collections.  
- Suggest replacing them with **wrapper classes** (e.g., `ArrayList<Integer>` instead of `ArrayList<int>`).  

**Extra (1 pt)**  
- Suggest improvements:  
  - Use wrapper utility methods for parsing sensor data from strings.  
  - Use `Character.isLetter()` or `Character.isDigit()` for validating user input.  

```java
// Before
// ArrayList<int> speeds; // invalid

// After
ArrayList<Integer> speeds = new ArrayList<>();
speeds.add(60);
speeds.add(80);
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
- Emphasize wrapper classes = objects for primitives.  
- Robot code: ArrayLists require wrapper classes.  
- Archaeology: replace invalid primitive collections with wrapper equivalents.  
- Segue: Next lesson → **ArrayLists** (dynamic arrays that only work with objects).  
-->
