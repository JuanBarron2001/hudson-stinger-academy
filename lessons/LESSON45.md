# 🖥️ Lesson 45 – Exceptions in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ ⚡  

---

## 🎯 Overview
**Keywords:** Java, Exceptions, try-catch, finally, try-with-resources, Error Handling  
Learn to:
- Understand that **exceptions** are events that interrupt the normal flow of a program  
- Use **try-catch** blocks to handle dangerous code gracefully  
- Catch **specific exceptions** (e.g., `ArithmeticException`, `InputMismatchException`)  
- Use a **catch-all** as a last resort (`Exception e`)  
- Apply the **finally** block for cleanup tasks  
- Use **try-with-resources** for automatic resource management  

---

## ⏱️ Progress Tracking

### 📊 For the Marathon Watchers  
If you’re following the **full 12‑hour compilation** and want to see how far you’ve made it through the *entire* course:  
- **Start Time in 12‑Hour Video:** [09:05:29](https://www.youtube.com/watch?v=xTtL8E4LzTQ&t=32729s)  
- **Full Course (12h video):** [Watch Compilation](https://www.youtube.com/watch?v=xTtL8E4LzTQ)

---

### 🎯 For the Quick‑Hit Learners  
If you just want **this lesson only** and to be done with it — no scrubbing through hours of footage:  
- **Lesson Playlist:** [Java tutorial for beginners (2025) ☕](https://www.youtube.com/playlist?list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc)  
- **This Lesson Only:** [Watch Lesson 45](https://www.youtube.com/watch?v=u1PROb-aRUI&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=57) (Learn EXCEPTION HANDLING in 8 minutes! ⚠️, 8:02)

---

## 💻 Part 1 – Java‑Only (2 pts)

**Basic (1 pt)**  
- Example of dividing by zero:  

```java
try {
    int result = 1 / 0; // dangerous code
} catch (ArithmeticException e) {
    System.out.println("You can't divide by zero!");
}
```

- Example of input mismatch:  

```java
// These two lines go at the TOP of the file, with the other imports:
import java.util.Scanner;
import java.util.InputMismatchException;

// The rest goes in main:
Scanner scanner = new Scanner(System.in);

try {
    System.out.print("Enter a number: ");
    int number = scanner.nextInt();
    System.out.println("You entered: " + number);
} catch (InputMismatchException e) {
    System.out.println("That wasn't a number!");
}
```

- Run it twice: once typing a number, once typing a word like `pizza`. Without the `try`, the word would crash the program with an `InputMismatchException`.  

**Extra (1 pt)**  
- Using multiple catch blocks and a catch-all:  

```java
try {
    int result = 1 / 0;
} catch (ArithmeticException e) {
    System.out.println("Math error: " + e.getMessage());
} catch (Exception e) {
    System.out.println("Something went wrong.");
} finally {
    System.out.println("This always executes.");
}
```

- Using **try-with-resources**:  

```java
try (Scanner scanner2 = new Scanner(System.in)) {
    System.out.print("Enter a number: ");
    int num = scanner2.nextInt();
    System.out.println("You entered: " + num);
} catch (InputMismatchException e) {
    System.out.println("Invalid input!");
}
```

- With try‑with‑resources, Java closes the `Scanner` for you when the `try` ends, even if an exception was thrown. The video's advice: catch **specific** exceptions first, so the user learns what went wrong, and keep `Exception e` last, as a safety net.  

---

## 🤖 Part 2 – Robot Code (2 pts)

**Basic (1 pt)**  
- Handle exceptions when reading sensor values:  

```java
try {
    String sensorValue = "abc"; // invalid numeric input
    int voltage = Integer.parseInt(sensorValue);
    SmartDashboard.putNumber("Voltage", voltage);
} catch (NumberFormatException e) {
    SmartDashboard.putString("Error", "Invalid sensor value");
}
```

**Extra (1 pt)**  
- Use `finally` for code that must run either way. Parse a `String` like the basic half, not a `Scanner`: robot code has no keyboard, and waiting for one would freeze the robot loop like lesson 15's `while`.  

```java
String speedText = "0.75"; // then try "fast"
try {
    double speed = Double.parseDouble(speedText);
    SmartDashboard.putNumber("Motor Speed", speed);
} catch (NumberFormatException e) {
    SmartDashboard.putString("Error", "Invalid speed input");
} finally {
    SmartDashboard.putString("Status", "Speed input checked"); // runs either way
}
```

---

## 📜 Part 3 – Code Archaeology (2 pts)

**Basic (1 pt)**  
- Find a section of last year’s robot code where invalid input or sensor data caused crashes.  
- Suggest wrapping those sections in **try-catch** blocks.  

**Extra (1 pt)**  
- Suggest improvements:  
  - Catch **specific exceptions** (e.g., `NumberFormatException` for parsing).  
  - Use **finally** or **try-with-resources** to ensure cleanup.  

```java
try {
    int rpm = Integer.parseInt(sensorString);
    shooter.setRPM(rpm);
} catch (NumberFormatException e) {
    System.out.println("Invalid RPM input, using default.");
    shooter.setRPM(3000);
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
- Emphasize exceptions = interruptions in program flow.  
- Robot code: handle invalid sensor data gracefully.  
- Archaeology: replace crash-prone parsing with try-catch.  
- Segue: Next lesson → **File Handling** (working with files, streams, and exceptions).  
-->
