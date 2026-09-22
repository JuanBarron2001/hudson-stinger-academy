# 🖥️ Lesson 54 – Threading in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🧵⚡  

---

## 🎯 Overview
**Keywords:** Java, Threads, Concurrency, Runnable, Multitasking  
Learn to:
- Understand that **threads** allow multiple tasks to run simultaneously  
- Recognize the difference between the **main thread** and additional threads  
- Create threads by **extending Thread** or **implementing Runnable**  
- Use `Thread.sleep()` to pause execution  
- Run background tasks without blocking the main program  
- Use **daemon threads** to automatically end background tasks when the main thread finishes  

---

## ⏱️ Progress Tracking

### 📊 For the Marathon Watchers  
If you’re following the **full 12‑hour compilation** and want to see how far you’ve made it through the *entire* course:  
- **Start Time in 12‑Hour Video:** [11:12:45](https://www.youtube.com/watch?v=xTtL8E4LzTQ&t=40365s)  
- **Full Course (12h video):** [Watch Compilation](https://www.youtube.com/watch?v=xTtL8E4LzTQ)

---

### 🎯 For the Quick‑Hit Learners  
If you just want **this lesson only** and to be done with it — no scrubbing through hours of footage:  
- **Lesson Playlist:** [Java tutorial for beginners (2025) ☕](https://www.youtube.com/playlist?list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc)  
- **This Lesson Only:** [Watch Lesson 54](https://www.youtube.com/watch?v=SztE5W41on4&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=69) (Learn Java threading in 10 minutes! 🧵, 10:21)

---

## 💻 Part 1 – Java‑Only (2 pts)

> In the code below, the `import` line goes at the **top** of your `Main.java`, and the rest goes **inside** `main`. Keep the `public class Main extends BaseLesson` line your file already has: without `extends BaseLesson`, the lesson runner can't run it. New classes like `MyRunnable` get their own file next to `Main.java`, starting with the same `package` line, like lesson 27.

**Basic (1 pt)**  
- Without threads, a long task blocks the main program:  

```java
// at the top of the file:
import java.util.Scanner;

// inside main:
Scanner scanner = new Scanner(System.in);

System.out.println("You have 5 seconds to enter your name:");
for (int i = 1; i <= 5; i++) {
    try {
        Thread.sleep(1000); // blocks the main thread
    } catch (InterruptedException e) {
        System.out.println("Thread was interrupted");
    }
    if (i == 5) {
        System.out.println("Time's up!");
    }
}

System.out.print("Enter your name: ");
String name = scanner.nextLine();
System.out.println("Hello " + name);
scanner.close();
```

- Problem: you can't even see the name prompt until the countdown is over. Everything runs on **one** thread, the main thread, one line at a time.  

---

**Extra (1 pt)**  
- Move the countdown to its own thread, with the **Runnable** interface. In a new file, `MyRunnable.java`:  

```java
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
            if (i == 10) {
                System.out.println("Time's up!");
            }
        }
    }
}
```

- And inside `main`:  

```java
Scanner scanner = new Scanner(System.in);

System.out.println("You have 10 seconds to enter your name:");
Thread timerThread = new Thread(new MyRunnable());
timerThread.setDaemon(true); // ends when the main program ends
timerThread.start();

System.out.print("Enter your name: ");
String name = scanner.nextLine();
System.out.println("Hello " + name);
scanner.close();
```

- Now the countdown runs **in the background** while the main thread waits for your name.  
- Take out `setDaemon(true)` and answer quickly. The program keeps running until the countdown finishes, because Java waits for every ordinary thread. A **daemon** thread doesn't hold the program open.  
- The video also calls `System.exit(0)` when time is up, to end the whole program. Leave that out here: it would shut down the lesson runner too, before it finishes your log.  

---

## 🤖 Part 2 – Robot Code (2 pts)

> **Not written yet.** Lesson 54 is **optional** this offseason, so its robot half was never rewritten for the 2026 robot. What used to be here was a 2025 draft describing hardware this robot doesn't have, so it has been taken out rather than left to send you down a dead end. **Skip Parts 2 and 3 for now.**
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
- Emphasize threads = run multiple tasks simultaneously.  
- Robot code: background monitoring, timed actions.  
- Archaeology: replace blocking code with threaded tasks.  
- Segue: Next lesson → **Synchronization** (managing shared resources between threads).  
-->
