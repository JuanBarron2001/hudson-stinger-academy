# 🖥️ Lesson 46 – Writing Files in Java (FileWriter)

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 📝  

---

## 🎯 Overview
**Keywords:** Java, FileWriter, File Handling, Exceptions, IO, File Paths  
Learn to:
- Use **FileWriter** to write small/medium text files  
- Understand the difference between **FileWriter**, **BufferedWriter**, **PrintWriter**, and **FileOutputStream**  
- Handle exceptions with **try-catch** blocks (`IOException`, `FileNotFoundException`)  
- Write text to files, including **multi-line strings**  
- Use **absolute file paths** and **relative paths**  
- Organize file-writing code with variables for file path and content  

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
- Writing a file with `FileWriter`:  

[CODE BLOCK]java
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try (FileWriter writer = new FileWriter("test.txt")) {
            writer.write("I like pizza");
            System.out.println("File has been written.");
        } catch (IOException e) {
            System.out.println("Could not write file.");
        }
    }
}
[CODE BLOCK]

- Output: creates `test.txt` with text:  
  `I like pizza`

**Extra (1 pt)**  
- Using absolute file paths and handling `FileNotFoundException`:  

[CODE BLOCK]java
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\YourName\\Desktop\\test.txt";
        String textContent = """
                I like pizza
                It's really good
                Buy me pizza
                """;

        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(textContent);
            System.out.println("File has been written.");
        } catch (FileNotFoundException e) {
            System.out.println("Could not locate file location.");
        } catch (IOException e) {
            System.out.println("Could not write file.");
        }
    }
}
[CODE BLOCK]

---

## 🤖 Part 2 – Robot Code (2 pts)

**Basic (1 pt)**  
- Write robot logs to a file:  

[CODE BLOCK]java
try (FileWriter writer = new FileWriter("robot_log.txt")) {
    writer.write("Robot initialized.\n");
    writer.write("DriveTrain active.\n");
    writer.write("Arm lifted.\n");
    System.out.println("Robot log written.");
} catch (IOException e) {
    System.out.println("Error writing robot log.");
}
[CODE BLOCK]

**Extra (1 pt)**  
- Use multi-line strings for structured logs:  

[CODE BLOCK]java
String log = """
        === Robot Log ===
        DriveTrain: OK
        Arm: OK
        Shooter: OK
        =================
        """;

try (FileWriter writer = new FileWriter("robot_status.txt")) {
    writer.write(log);
    System.out.println("Robot status written.");
} catch (IOException e) {
    System.out.println("Error writing robot status.");
}
[CODE BLOCK]

---

## 📜 Part 3 – Code Archaeology (2 pts)

**Basic (1 pt)**  
- Find a section of last year’s robot code where logs were only printed to console.  
- Suggest writing logs to a file for persistence.  

**Extra (1 pt)**  
- Suggest improvements:  
  - Use `FileWriter` for small logs.  
  - Use `PrintWriter` for structured logs.  
  - Use `BufferedWriter` for performance with large logs.  

[CODE BLOCK]java
// Before: only console output
System.out.println("Shooter RPM: 3000");

// After: write to file
try (FileWriter writer = new FileWriter("shooter_log.txt")) {
    writer.write("Shooter RPM: 3000");
} catch (IOException e) {
    System.out.println("Error writing shooter log.");
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
- Emphasize FileWriter = simple way to write text files.  
- Robot code: log subsystem activity to files.  
- Archaeology: replace console-only logs with persistent file logs.  
- Segue: Next lesson → **Reading Files** (using FileReader, BufferedReader, Scanner).  
[CODE BLOCK]
