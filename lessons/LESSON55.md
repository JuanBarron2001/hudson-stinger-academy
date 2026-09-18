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

**Basic (1 pt)**  
- Use multi‑threading to log sensor data while running main code:  

```java
class SensorLogger implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            SmartDashboard.putNumber("Battery Voltage", RobotController.getBatteryVoltage());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Logger interrupted");
            }
        }
    }
}

Thread logger = new Thread(new SensorLogger());
logger.start();
```

**Extra (1 pt)**  
- Run two concurrent tasks: one logging, one controlling motors:  

```java
Thread logger = new Thread(new SensorLogger());
Thread motorTask = new Thread(() -> {
    for (int i = 0; i < 5; i++) {
        drivetrain.driveForward(0.5);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("Motor task interrupted");
        }
    }
    drivetrain.stop();
});

logger.start();
motorTask.start();

logger.join();
motorTask.join();
```

---

## 📜 Part 3 – Code Archaeology (2 pts)

**Basic (1 pt)**  
- Find a section of last year’s robot code where tasks were run sequentially (e.g., logging first, then driving).  
- Suggest replacing them with **multi‑threading** so both run concurrently.  

**Extra (1 pt)**  
- Suggest improvements:  
  - Use `join()` to ensure threads finish before ending the program.  
  - Use thread names for debugging.  
  - Replace blocking loops with concurrent threads for responsiveness.  

```java
// Before: sequential
logSensors();
driveForward();

// After: concurrent
Thread logger = new Thread(() -> logSensors());
Thread driver = new Thread(() -> driveForward());

logger.start();
driver.start();

logger.join();
driver.join();
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
- Emphasize multi‑threading = multiple threads running concurrently.  
- Robot code: log sensors + drive simultaneously.  
- Archaeology: replace sequential blocking code with concurrent threads.  
- Segue: Next lesson → **Synchronization** (managing shared resources safely between threads).  
-->
