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
- **Start Time in 12‑Hour Video:** [blank]  
- **Full Course (12h video):** [link here]  

---

### 🎯 For the Quick‑Hit Learners  
- **Lesson Playlist:** [link here]  
- **This Lesson Only:** [link here]  

---

## 💻 Part 1 – Java‑Only (2 pts)

**Basic (1 pt)**  
- Example: reading a text file line by line  

[CODE BLOCK]java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\YourName\\Desktop\\test.txt";

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
    }
}
[CODE BLOCK]

- Output: prints each line of the file until EOF (`null`).  

**Extra (1 pt)**  
- Demonstrate error handling:  
  - Misspelled path → `FileNotFoundException`  
  - Corrupted file → `IOException`  

---

## 🤖 Part 2 – Robot Code (2 pts)

**Basic (1 pt)**  
- Read a configuration file for robot settings:  

[CODE BLOCK]java
try (BufferedReader reader = new BufferedReader(new FileReader("robot_config.txt"))) {
    String line;
    while ((line = reader.readLine()) != null) {
        SmartDashboard.putString("Config", line);
    }
} catch (IOException e) {
    SmartDashboard.putString("Error", "Could not read config file");
}
[CODE BLOCK]

**Extra (1 pt)**  
- Parse numeric values from file lines:  

[CODE BLOCK]java
try (BufferedReader reader = new BufferedReader(new FileReader("motor_speeds.txt"))) {
    String line;
    while ((line = reader.readLine()) != null) {
        double speed = Double.parseDouble(line);
        SmartDashboard.putNumber("Motor Speed", speed);
    }
} catch (IOException e) {
    SmartDashboard.putString("Error", "Failed to read motor speeds");
}
[CODE BLOCK]

---

## 📜 Part 3 – Code Archaeology (2 pts)

**Basic (1 pt)**  
- Find a section of last year’s robot code where configuration values were hardcoded.  
- Suggest replacing them with **external text files** read via `BufferedReader`.  

**Extra (1 pt)**  
- Suggest improvements:  
  - Store subsystem parameters (e.g., PID values, motor speeds) in a config file.  
  - Read them at runtime → easier tuning without recompiling code.  

[CODE BLOCK]java
// Before: hardcoded
double shooterRPM = 3000;

// After: read from file
try (BufferedReader reader = new BufferedReader(new FileReader("shooter_config.txt"))) {
    shooterRPM = Double.parseDouble(reader.readLine());
} catch (IOException e) {
    shooterRPM = 3000; // fallback default
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
- Emphasize BufferedReader + FileReader = best for line-by-line text reading.  
- Robot code: read configs/logs from files instead of hardcoding.  
- Archaeology: replace constants with file-driven configs.  
- Segue: Next lesson → **Serialization** (saving/loading objects to files).  
[CODE BLOCK]
