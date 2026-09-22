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
If you’re following the **full 12‑hour compilation** and want to see how far you’ve made it through the *entire* course:  
- **Start Time in 12‑Hour Video:** [09:13:28](https://www.youtube.com/watch?v=xTtL8E4LzTQ&t=33208s)  
- **Full Course (12h video):** [Watch Compilation](https://www.youtube.com/watch?v=xTtL8E4LzTQ)

---

### 🎯 For the Quick‑Hit Learners  
If you just want **this lesson only** and to be done with it — no scrubbing through hours of footage:  
- **Lesson Playlist:** [Java tutorial for beginners (2025) ☕](https://www.youtube.com/playlist?list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc)  
- **This Lesson Only:** [Watch Lesson 46](https://www.youtube.com/watch?v=Pg0aoSbrqOE&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=58) (How to WRITE FILES with Java in 8 minutes! ✍, 8:32)

---

## 💻 Part 1 – Java‑Only (2 pts)

> In the code below, the `import` lines go at the **top** of your `Main.java`, and the rest goes **inside** `main`. Keep the `public class Main extends BaseLesson` line your file already has: without `extends BaseLesson`, the lesson runner can't run it.

**Basic (1 pt)**  
- Write a file with `FileWriter`:  

```java
// at the top of the file:
import java.io.FileWriter;
import java.io.IOException;

// inside main:
try (FileWriter writer = new FileWriter("test.txt")) {
    writer.write("I like pizza");
    System.out.println("File has been written.");
} catch (IOException e) {
    System.out.println("Could not write file.");
}
```

- Run it, then find `test.txt`. With just a name and no folder, the file lands in the folder you ran the lesson from: `java-lessons/`. (In the video it lands in IntelliJ's source folder instead.) It should say `I like pizza`.  

**Extra (1 pt)**  
- Write to a full (absolute) path, like your Desktop, and catch a bad path separately:  

```java
// at the top of the file:
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

// inside main:
String filePath = "C:\\Users\\YourName\\Desktop\\test.txt"; // Windows: every backslash doubled
// String filePath = "/Users/YourName/Desktop/test.txt";         // Mac
// String filePath = "/home/YourName/Desktop/test.txt";          // Linux
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
```

- Use the line for **your** computer, with your own user name, and delete the others.  
- The triple quotes `"""` make a multi‑line `String`, handy when there's a lot of text.  
- Misspell `Desktop` as `Deskto` and run it again. The folder doesn't exist, so you get the `FileNotFoundException` message. Catch the specific exception first and the general `IOException` last (lesson 45's advice).  

---

## 🤖 Part 2 – Robot Code (2 pts)

> **Not written yet.** Lesson 46 is **optional** this offseason, so its robot half was never rewritten for the 2026 robot. What used to be here was a 2025 draft describing hardware this robot doesn't have, so it has been taken out rather than left to send you down a dead end. **Skip Parts 2 and 3 for now.**
>
> Ahead of the pace and want the points anyway? Ask a mentor. Writing this half with you is a good use of a meeting.

---

## 📜 Part 3 – Code Archaeology (2 pts, optional)

> Not written yet. See Part 2.

---

## 🏆 Total Points
- **Max right now:** 2 pts  
  - Java‑Only: 2 pts  
  - Robot Code and Code Archaeology: they come back if this lesson gets a 2026 robot half

---

<!-- Drafting notes from the transcript draft. Hidden from students.
Ideas:  
- Emphasize FileWriter = simple way to write text files.  
- Robot code: log subsystem activity to files.  
- Archaeology: replace console-only logs with persistent file logs.  
- Segue: Next lesson → **Reading Files** (using FileReader, BufferedReader, Scanner).  
-->
