# 🖥️ Lesson 55 – Multi‑Threading in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🧵⚡  

---

## 🎯 Overview
**Keywords:** Java, Multi‑Threading, Runnable, Concurrency, Thread Management  
Learn to:
- Understand that **multi‑threading** allows multiple threads to run concurrently  
- Create threads by **implementing Runnable** (preferred over extending Thread)  
- Use `Thread.sleep()` to pause execution inside a thread  
- Differentiate threads by their **names**  
- Synchronize thread completion with the `join()` method  
- Apply multi‑threading to simulate concurrent tasks (e.g., ping‑pong game)  

---

## ⏱️ Progress Tracking

### 📊 For the Marathon Watchers  
If you’re following the **full 12‑hour compilation** and want to see how far you’ve made it through the *entire* course:  
- **Start Time in 12‑Hour Video:** [11:23:04](https://www.youtube.com/watch?v=xTtL8E4LzTQ&t=40984s)  
- **Full Course (12h video):** [Watch Compilation](https://www.youtube.com/watch?v=xTtL8E4LzTQ)

---

### 🎯 For the Quick‑Hit Learners  
If you just want **this lesson only** and to be done with it — no scrubbing through hours of footage:  
- **Lesson Playlist:** [Java tutorial for beginners (2025) ☕](https://www.youtube.com/playlist?list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc)  
- **This Lesson Only:** [Watch Lesson 55](https://www.youtube.com/watch?v=taI7G6U29L8&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=70) (Learn Java multithreading in 8 minutes! 🧶, 8:01)

---

## 💻 Part 1 – Java‑Only (2 pts)

> Code for `main` goes **inside** your existing `main`: keep the `public class Main extends BaseLesson` line your file already has, because without `extends BaseLesson` the lesson runner can't run it. `MyRunnable` gets its own file next to `Main.java`, starting with the same `package` line, like lesson 27.

**Basic (1 pt)**  
- Create a `Runnable` class in `MyRunnable.java`:  

```java
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                Thread.sleep(1000); // pause 1 second
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted");
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
```

- Run two of them at once from `main`. Add `throws InterruptedException` to `main`'s first line for the `sleep` at the end:  

```java
Thread thread1 = new Thread(new MyRunnable());
Thread thread2 = new Thread(new MyRunnable());

thread1.start();
thread2.start();

// Keep main alive until both threads finish counting
Thread.sleep(6000);
```

- Both threads count at the same time, and their lines come out in a different order each run. Java names them `Thread-0` and `Thread-1`.  
- Why the `sleep` at the end? The threads run in the background. If `main` finishes first, the lesson runner stops logging, and their counting never reaches your log. Lesson 50's timer had the same problem, and the extra shows the proper fix.  

---

**Extra (1 pt)**  
- Ping‑pong, the video's exercise. Give `MyRunnable` some text to print instead of the count:  

```java
public class MyRunnable implements Runnable {
    private final String text;

    public MyRunnable(String text) {
        this.text = text;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
            System.out.println(text);
        }
    }
}
```

- In `main`, first **without** `join`: print `"Game start"`, start a `"Ping"` thread and a `"Pong"` thread, then print `"Game over"`. `Game over` prints before a single ping, because `main` doesn't wait for anything.  
- Now make `main` wait for both threads with `join()`, the proper fix:  

```java
System.out.println("Game start");

Thread thread1 = new Thread(new MyRunnable("Ping"));
Thread thread2 = new Thread(new MyRunnable("Pong"));

thread1.start();
thread2.start();

try {
    thread1.join();
    thread2.join();
} catch (InterruptedException e) {
    System.out.println("Main thread was interrupted");
}

System.out.println("Game over");
```

---

## 🤖 Part 2 – Robot Code (2 pts)

> **Not written yet.** Lesson 55 is **optional** this offseason, so its robot half was never rewritten for the 2026 robot. What used to be here was a 2025 draft describing hardware this robot doesn't have, so it has been taken out rather than left to send you down a dead end. **Skip Parts 2 and 3 for now.**
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
- Emphasize multi‑threading = multiple threads running concurrently.  
- Robot code: log sensors + drive simultaneously.  
- Archaeology: replace sequential blocking code with concurrent threads.  
- Segue: Next lesson → **Synchronization** (managing shared resources safely between threads).  
-->
