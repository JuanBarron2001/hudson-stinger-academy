# 🖥️ Lesson 50 – Timer and TimerTask in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ ⏱️  

---

## 🎯 Overview
**Keywords:** Java, Timer, TimerTask, Scheduling, Anonymous Classes, Periodic Tasks  
Learn to:
- Understand that **Timer** schedules tasks at specific times or intervals  
- Use **TimerTask** to define the task to be executed  
- Implement tasks with **anonymous classes** (no need to create a separate class file)  
- Schedule tasks with a **delay** or at a **fixed rate**  
- Cancel timers when tasks are complete  

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
- Create a `Timer` and a `TimerTask` using an **anonymous class**:  

[CODE BLOCK]java
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) {
        Timer timer = new Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Hello");
            }
        };

        // Schedule task after 3 seconds (3000 ms)
        timer.schedule(task, 3000);
    }
}
[CODE BLOCK]

**Extra (1 pt)**  
- Schedule a task to repeat at a fixed rate:  

[CODE BLOCK]java
Timer timer = new Timer();

TimerTask task = new TimerTask() {
    int count = 3;

    @Override
    public void run() {
        System.out.println("Hello");
        count--;
        if (count <= 0) {
            System.out.println("Task complete");
            timer.cancel();
        }
    }
};

// Start immediately (0 ms delay), repeat every 1000 ms
timer.scheduleAtFixedRate(task, 0, 1000);
[CODE BLOCK]

---

## 🤖 Part 2 – Robot Code (2 pts)

**Basic (1 pt)**  
- Use a timer to log robot status every second:  

[CODE BLOCK]java
Timer timer = new Timer();

TimerTask logTask = new TimerTask() {
    @Override
    public void run() {
        SmartDashboard.putString("Status", "Robot running...");
    }
};

timer.scheduleAtFixedRate(logTask, 0, 1000);
[CODE BLOCK]

**Extra (1 pt)**  
- Stop logging after 5 updates:  

[CODE BLOCK]java
TimerTask logTask = new TimerTask() {
    int count = 5;

    @Override
    public void run() {
        SmartDashboard.putString("Status", "Update " + count);
        count--;
        if (count <= 0) {
            SmartDashboard.putString("Status", "Logging complete");
            timer.cancel();
        }
    }
};

timer.scheduleAtFixedRate(logTask, 0, 1000);
[CODE BLOCK]

---

## 📜 Part 3 – Code Archaeology (2 pts)

**Basic (1 pt)**  
- Find a section of last year’s robot code where repeated actions were handled with manual loops or delays.  
- Suggest replacing them with **Timer + TimerTask** for cleaner scheduling.  

**Extra (1 pt)**  
- Suggest improvements:  
  - Use `TimerTask` for periodic sensor checks.  
  - Use `TimerTask` for timed subsystem shutdowns.  
  - Cancel timers when tasks are complete to avoid wasted resources.  

[CODE BLOCK]java
// Before: manual loop with Thread.sleep()
for (int i = 0; i < 5; i++) {
    System.out.println("Update " + i);
    Thread.sleep(1000);
}

// After: TimerTask
Timer timer = new Timer();
timer.scheduleAtFixedRate(new TimerTask() {
    int count = 5;
    @Override
    public void run() {
        System.out.println("Update " + count);
        count--;
        if (count <= 0) timer.cancel();
    }
}, 0, 1000);
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
- Emphasize Timer = scheduler, TimerTask = job.  
- Robot code: periodic logging, sensor checks, timed shutdowns.  
- Archaeology: replace loops/delays with TimerTask.  
- Segue: Next lesson → **Countdown Timer** (using Timer + TimerTask to count down).  
[CODE BLOCK]
```