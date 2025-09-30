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
- **Start Time in 12‑Hour Video:** [blank]  
- **Full Course (12h video):** [link here]  

---

### 🎯 For the Quick‑Hit Learners  
- **Lesson Playlist:** [link here]  
- **This Lesson Only:** [link here]  

---

## 💻 Part 1 – Java‑Only (2 pts)

**Basic (1 pt)**  
- Example of dividing by zero:  

[CODE BLOCK]java
try {
    int result = 1 / 0; // dangerous code
} catch (ArithmeticException e) {
    System.out.println("You can't divide by zero!");
}
[CODE BLOCK]

- Example of input mismatch:  

[CODE BLOCK]java
import java.util.Scanner;
import java.util.InputMismatchException;

Scanner scanner = new Scanner(System.in);

try {
    System.out.print("Enter a number: ");
    int number = scanner.nextInt();
    System.out.println("You entered: " + number);
} catch (InputMismatchException e) {
    System.out.println("That wasn't a number!");
}
[CODE BLOCK]

**Extra (1 pt)**  
- Using multiple catch blocks and a catch-all:  

[CODE BLOCK]java
try {
    int result = 1 / 0;
} catch (ArithmeticException e) {
    System.out.println("Math error: " + e.getMessage());
} catch (Exception e) {
    System.out.println("Something went wrong.");
} finally {
    System.out.println("This always executes.");
}
[CODE BLOCK]

- Using **try-with-resources**:  

[CODE BLOCK]java
try (Scanner scanner2 = new Scanner(System.in)) {
    System.out.print("Enter a number: ");
    int num = scanner2.nextInt();
    System.out.println("You entered: " + num);
} catch (InputMismatchException e) {
    System.out.println("Invalid input!");
}
[CODE BLOCK]

---

## 🤖 Part 2 – Robot Code (2 pts)

**Basic (1 pt)**  
- Handle exceptions when reading sensor values:  

[CODE BLOCK]java
try {
    String sensorValue = "abc"; // invalid numeric input
    int voltage = Integer.parseInt(sensorValue);
    SmartDashboard.putNumber("Voltage", voltage);
} catch (NumberFormatException e) {
    SmartDashboard.putString("Error", "Invalid sensor value");
}
[CODE BLOCK]

**Extra (1 pt)**  
- Use finally to ensure cleanup:  

[CODE BLOCK]java
Scanner scanner = new Scanner(System.in);
try {
    System.out.print("Enter motor speed: ");
    double speed = scanner.nextDouble();
    SmartDashboard.putNumber("Motor Speed", speed);
} catch (InputMismatchException e) {
    SmartDashboard.putString("Error", "Invalid speed input");
} finally {
    scanner.close(); // cleanup
}
[CODE BLOCK]

---

## 📜 Part 3 – Code Archaeology (2 pts)

**Basic (1 pt)**  
- Find a section of last year’s robot code where invalid input or sensor data caused crashes.  
- Suggest wrapping those sections in **try-catch** blocks.  

**Extra (1 pt)**  
- Suggest improvements:  
  - Catch **specific exceptions** (e.g., `NumberFormatException` for parsing).  
  - Use **finally** or **try-with-resources** to ensure cleanup.  

[CODE BLOCK]java
try {
    int rpm = Integer.parseInt(sensorString);
    shooter.setRPM(rpm);
} catch (NumberFormatException e) {
    System.out.println("Invalid RPM input, using default.");
    shooter.setRPM(3000);
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
- Emphasize exceptions = interruptions in program flow.  
- Robot code: handle invalid sensor data gracefully.  
- Archaeology: replace crash-prone parsing with try-catch.  
- Segue: Next lesson → **File Handling** (working with files, streams, and exceptions).  
[CODE BLOCK]
