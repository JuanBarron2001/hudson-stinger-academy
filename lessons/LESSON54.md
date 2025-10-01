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
- **Start Time in 12‑Hour Video:** [blank]  
- **Full Course (12h video):** [link here]  

---

### 🎯 For the Quick‑Hit Learners  
- **Lesson Playlist:** [link here]  
- **This Lesson Only:** [link here]  

---

## 💻 Part 1 – Java‑Only (2 pts)

**Basic (1 pt)**  
- Without threads, long tasks block the main program:  

[CODE BLOCK]java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("You have 5 seconds to enter your name:");
        for (int i = 1; i <= 5; i++) {
            try {
                Thread.sleep(1000); // blocks main thread
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
    }
}
[CODE BLOCK]

- Problem: user input is blocked until the loop finishes.  

---

**Extra (1 pt)**  
- Solve with **Runnable** and a separate thread:  

[CODE BLOCK]java
class MyRunnable implements Runnable {
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
                System.exit(0); // exit program when time is up
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("You have 10 seconds to enter your name:");
        Thread timerThread = new Thread(new MyRunnable());
        timerThread.setDaemon(true); // ends when main thread ends
        timerThread.start();

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Hello " + name);
        scanner.close();
    }
}
[CODE BLOCK]

- Now the countdown runs **in the background** while the main thread waits for input.  

---

## 🤖 Part 2 – Robot Code (2 pts)

**Basic (1 pt)**  
- Use a thread to monitor battery voltage in the background:  

[CODE BLOCK]java
class BatteryMonitor implements Runnable {
    @Override
    public void run() {
        while (true) {
            SmartDashboard.putNumber("Battery Voltage", RobotController.getBatteryVoltage());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}

Thread monitorThread = new Thread(new BatteryMonitor());
monitorThread.setDaemon(true);
monitorThread.start();
[CODE BLOCK]

**Extra (1 pt)**  
- Use a thread for timed autonomous actions:  

[CODE BLOCK]java
class AutoTask implements Runnable {
    @Override
    public void run() {
        try {
            drivetrain.driveForward(0.5);
            Thread.sleep(3000); // drive for 3 seconds
            drivetrain.stop();
        } catch (InterruptedException e) {
            System.out.println("Auto task interrupted");
        }
    }
}

Thread autoThread = new Thread(new AutoTask());
autoThread.start();
[CODE BLOCK]

---

## 📜 Part 3 – Code Archaeology (2 pts)

**Basic (1 pt)**  
- Find a section of last year’s robot code where long operations (e.g., sensor polling, logging) blocked the main loop.  
- Suggest moving those operations into a **separate thread**.  

**Extra (1 pt)**  
- Suggest improvements:  
  - Use daemon threads for background monitoring.  
  - Use threads for timed sequences without blocking teleop.  
  - Replace `Thread.sleep()` in main code with background tasks.  

[CODE BLOCK]java
// Before: blocking call
Thread.sleep(5000);
arm.moveUp();

// After: threaded task
new Thread(() -> {
    try {
        Thread.sleep(5000);
        arm.moveUp();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}).start();
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
- Emphasize threads = run multiple tasks simultaneously.  
- Robot code: background monitoring, timed actions.  
- Archaeology: replace blocking code with threaded tasks.  
- Segue: Next lesson → **Synchronization** (managing shared resources between threads).  
[CODE BLOCK]
