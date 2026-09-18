# 🖥️ Lesson 47 – Reading Files in Java (BufferedReader + FileReader)

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 📖  

---

## 🎯 Overview
**Keywords:** Java, FileReader, BufferedReader, File Handling, Exceptions, IO  
Learn to:
- Use **FileReader** to read characters from a file  
- Combine **BufferedReader** with FileReader for efficient **line-by-line reading**  
- Handle exceptions with **try-catch** (`FileNotFoundException`, `IOException`)  
- Use **try-with-resources** to automatically close files  
- Understand alternatives:  
  - **FileInputStream** → binary files (images, audio)  
  - **RandomAccessFile** → read/write specific portions of large files  

---

## ⏱️ Progress Tracking

### 📊 For the Marathon Watchers  
If you’re following the **full 12‑hour compilation** and want to see how far you’ve made it through the *entire* course:  
- **Start Time in 12‑Hour Video:** [09:21:58](https://www.youtube.com/watch?v=xTtL8E4LzTQ&t=33718s)  
- **Full Course (12h video):** [Watch Compilation](https://www.youtube.com/watch?v=xTtL8E4LzTQ)

---

### 🎯 For the Quick‑Hit Learners  
If you just want **this lesson only** and to be done with it — no scrubbing through hours of footage:  
- **Lesson Playlist:** [Java tutorial for beginners (2025) ☕](https://www.youtube.com/playlist?list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc)  
- **This Lesson Only:** [Watch Lesson 47](https://www.youtube.com/watch?v=eHjbvgw4hsI&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=59) (How to READ FILES with Java in 8 minutes! 📖, 6:54)

---

## 💻 Part 1 – Java‑Only (2 pts)

> In the code below, the `import` lines go at the **top** of your `Main.java`, and the rest goes **inside** `main`. Keep the `public class Main extends BaseLesson` line your file already has: without `extends BaseLesson`, the lesson runner can't run it.

**Basic (1 pt)**  
- Read the `test.txt` you wrote in lesson 46, line by line. It's in `java-lessons/`, the folder you run lessons from, so its name alone is enough:  

```java
// at the top of the file:
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

// inside main:
String filePath = "test.txt";

try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
    String line;
    while ((line = reader.readLine()) != null) {
        System.out.println(line); // print each line
    }
} catch (FileNotFoundException e) {
    System.out.println("Could not locate file.");
} catch (IOException e) {
    System.out.println("Something went wrong.");
}
```

- `readLine()` hands back one line each time you call it, and `null` once there are no lines left. That's why the `while` loop stops at `null`.  
- The `FileReader` does the actual reading. The `BufferedReader` wraps it, like a middleman, so it can read a whole line at a time.  

**Extra (1 pt)**  
- Misspell the file name and run it: you get the `FileNotFoundException` message instead of a crash.  
- Count the lines: add an `int` counter that goes up inside the `while` loop, and print `"Lines: " + count` after it.  
- Read the multi‑line file you wrote to your Desktop in lesson 46's extra, using its full path (`"C:\\Users\\YourName\\Desktop\\test.txt"` on Windows, `"/Users/YourName/Desktop/test.txt"` on a Mac, `"/home/YourName/Desktop/test.txt"` on Linux).  

---

## 🤖 Part 2 – Robot Code (2 pts)

**Basic (1 pt)**  
- Read a configuration file for robot settings:  

```java
try (BufferedReader reader = new BufferedReader(new FileReader("robot_config.txt"))) {
    String line;
    while ((line = reader.readLine()) != null) {
        SmartDashboard.putString("Config", line);
    }
} catch (IOException e) {
    SmartDashboard.putString("Error", "Could not read config file");
}
```

**Extra (1 pt)**  
- Parse numeric values from file lines:  

```java
try (BufferedReader reader = new BufferedReader(new FileReader("motor_speeds.txt"))) {
    String line;
    while ((line = reader.readLine()) != null) {
        double speed = Double.parseDouble(line);
        SmartDashboard.putNumber("Motor Speed", speed);
    }
} catch (IOException e) {
    SmartDashboard.putString("Error", "Failed to read motor speeds");
}
```

---

## 📜 Part 3 – Code Archaeology (2 pts)

**Basic (1 pt)**  
- Find a section of last year’s robot code where configuration values were hardcoded.  
- Suggest replacing them with **external text files** read via `BufferedReader`.  

**Extra (1 pt)**  
- Suggest improvements:  
  - Store subsystem parameters (e.g., PID values, motor speeds) in a config file.  
  - Read them at runtime → easier tuning without recompiling code.  

```java
// Before: hardcoded
double shooterRPM = 3000;

// After: read from file
try (BufferedReader reader = new BufferedReader(new FileReader("shooter_config.txt"))) {
    shooterRPM = Double.parseDouble(reader.readLine());
} catch (IOException e) {
    shooterRPM = 3000; // fallback default
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
- Emphasize BufferedReader + FileReader = best for line-by-line text reading.  
- Robot code: read configs/logs from files instead of hardcoding.  
- Archaeology: replace constants with file-driven configs.  
- Segue: Next lesson → **Serialization** (saving/loading objects to files).  
-->
