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
- **Start Time in 12‑Hour Video:** [blank]  
- **Full Course (12h video):** [link here]  

---

### 🎯 For the Quick‑Hit Learners  
- **Lesson Playlist:** [link here]  
- **This Lesson Only:** [link here]  

---

## 💻 Part 1 – Java‑Only (2 pts)

**Basic (1 pt)**  
- Create a `Runnable` class:  

[CODE BLOCK]java
class MyRunnable implements Runnable {
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
[CODE BLOCK]

- Run it in `main`:  

[CODE BLOCK]java
public class Main {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyRunnable());
        Thread thread2 = new Thread(new MyRunnable());

        thread1.start();
        thread2.start();
    }
}
[CODE BLOCK]

---

**Extra (1 pt)**  
- Modify `MyRunnable` to accept text (ping/pong):  

[CODE BLOCK]java
class MyRunnable implements Runnable {
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
[CODE BLOCK]

- In `main`:  

[CODE BLOCK]java
public class Main {
    public static void main(String[] args) {
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
    }
}
[CODE BLOCK]

---

## 🤖 Part 2 – Robot Code (2 pts)

**Basic (1 pt)**  
- Use multi‑threading to log sensor data while running main code:  

[CODE BLOCK]java
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
[CODE BLOCK]

**Extra (1 pt)**  
- Run two concurrent tasks: one logging, one controlling motors:  

[CODE BLOCK]java
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
[CODE BLOCK]

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

[CODE BLOCK]java
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
- Emphasize multi‑threading = multiple threads running concurrently.  
- Robot code: log sensors + drive simultaneously.  
- Archaeology: replace sequential blocking code with concurrent threads.  
- Segue: Next lesson → **Synchronization** (managing shared resources safely between threads).  
[CODE BLOCK]
