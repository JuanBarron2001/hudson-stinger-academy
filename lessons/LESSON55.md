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
- In `MyRunnable.java`, write `public class MyRunnable implements Runnable`. Its `run()` counts from 1 to 5, sleeping 1000 ms before each number (catching `InterruptedException` as in lesson 54), and prints the thread's name, a space, and the number. The name comes from `Thread.currentThread().getName()`.  
- Add `throws InterruptedException` to `main`'s first line.  
- In `main`, create two threads, each from its own `new MyRunnable()`, and `start()` both.  
- End `main` with `Thread.sleep(6000);`. The threads run in the background: if `main` finishes first, the lesson runner stops logging, and their counting never reaches your log. Lesson 50's timer had the same problem, and the extra shows the proper fix.  
- Run it a few times. Both threads count at the same time, and Java names them `Thread-0` and `Thread-1`.  

Expected output (**the order of each pair changes from run to run**, which is the point):  

```
Thread-1 1
Thread-0 1
Thread-1 2
Thread-0 2
Thread-1 3
Thread-0 3
Thread-1 4
Thread-0 4
Thread-1 5
Thread-0 5
```

**Extra (1 pt)**  
- Ping‑pong, the video's exercise. Give `MyRunnable` some text to print instead of the count: `private final String text;`, a constructor `public MyRunnable(String text)`, and a `run()` that prints the text five times, one second apart.  
- In `main`, first **without** `join`: print `Game start`, start a `"Ping"` thread and a `"Pong"` thread, then print `Game over`. **Predict it.** `Game over` prints before a single ping, because `main` doesn't wait for anything.  
- Now the proper fix. After starting both threads, call `join()` on each one, inside a `try` that catches `InterruptedException` (`Main thread was interrupted`). `join()` means *"wait here until that thread has finished."* Print `Game over` after the `try`.  

Expected output, before and after `join` (Ping and Pong may swap within a pair):  

```
Game start
Game over
Ping
Pong
Ping
Pong
Ping
Pong
Ping
Pong
Ping
Pong
```
```
Game start
Ping
Pong
Ping
Pong
Ping
Pong
Ping
Pong
Ping
Pong
Game over
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
