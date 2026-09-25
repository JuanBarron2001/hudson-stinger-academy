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

> The `import` lines go at the **top** of your `Main.java`, and the rest goes **inside** `main`. Keep the `public class Main extends BaseLesson` line your file already has: without `extends BaseLesson`, the lesson runner can't run it.

**Basic (1 pt)**  
- Read the `test.txt` you wrote in lesson 46, line by line. It's in `java-lessons/`, the folder you run lessons from, so `String filePath = "test.txt";` is enough.  
- Import `BufferedReader`, `FileReader`, `FileNotFoundException` and `IOException`, all from `java.io`.  
- Open it with try-with-resources (lesson 45): `try (BufferedReader reader = new BufferedReader(new FileReader(filePath)))`. The `FileReader` does the actual reading. The `BufferedReader` wraps it, like a middleman, so it can read a whole line at a time.  
- Inside, declare `String line;` and loop with `while ((line = reader.readLine()) != null)`, printing each line. `readLine()` hands back one line each time you call it, and `null` once there are no lines left, which is why the loop stops at `null`. That one condition does two jobs: it reads the next line into `line`, *then* checks it.  
- Catch `FileNotFoundException` first (`Could not locate file.`), then `IOException` (`Something went wrong.`).  

Expected output:  

```
I like pizza
```

**Extra (1 pt)**  
- Misspell the file name and run it: you get the `FileNotFoundException` message instead of a crash. Then fix it.  
- Count the lines: add an `int` counter that goes up inside the `while` loop, and print `Lines: ` and the count after it.  
- Read the multi‑line file you wrote to your Desktop in lesson 46's extra, using its full path (`"C:\\Users\\YourName\\Desktop\\test.txt"` on Windows, `"/Users/YourName/Desktop/test.txt"` on a Mac, `"/home/YourName/Desktop/test.txt"` on Linux).  

Expected output: the misspelled name, then `test.txt`, then the Desktop file:  

```
Could not locate file.
```
```
I like pizza
Lines: 1
```
```
I like pizza
It's really good
Buy me pizza
Lines: 3
```

---

## 🤖 Part 2 – Robot Code (2 pts)

> **Not written yet.** Lesson 47 is **optional** this offseason, so its robot half was never rewritten for the 2026 robot. What used to be here was a 2025 draft describing hardware this robot doesn't have, so it has been taken out rather than left to send you down a dead end. **Skip Parts 2 and 3 for now.**
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
- Emphasize BufferedReader + FileReader = best for line-by-line text reading.  
- Robot code: read configs/logs from files instead of hardcoding.  
- Archaeology: replace constants with file-driven configs.  
- Segue: Next lesson → **Serialization** (saving/loading objects to files).  
-->
