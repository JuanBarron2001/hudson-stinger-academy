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
If you’re following the **full 12‑hour compilation** and want to see how far you’ve made it through the *entire* course:  
- **Start Time in 12‑Hour Video:** [10:25:23](https://www.youtube.com/watch?v=xTtL8E4LzTQ&t=37523s)  
- **Full Course (12h video):** [Watch Compilation](https://www.youtube.com/watch?v=xTtL8E4LzTQ)

---

### 🎯 For the Quick‑Hit Learners  
If you just want **this lesson only** and to be done with it — no scrubbing through hours of footage:  
- **Lesson Playlist:** [Java tutorial for beginners (2025) ☕](https://www.youtube.com/playlist?list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc)  
- **This Lesson Only:** [Watch Lesson 50](https://www.youtube.com/watch?v=HjzcZkzRDYs&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=64) (Learn Java timertasks in 6 minutes! ⏲️, 6:24)

---

## 💻 Part 1 – Java‑Only (2 pts)

> In the code below, the `import` lines go at the **top** of your `Main.java`, and the rest goes **inside** `main`. Keep the `public class Main extends BaseLesson` line your file already has: without `extends BaseLesson`, the lesson runner can't run it.

> ⚠️ **Make `main` wait for the timer.** A `Timer` runs its task on its own thread, in the background. If `main` finishes first, the lesson runner stops logging, so the task's output never reaches your log. And a timer that's never cancelled keeps the program running forever. So after scheduling, call `Thread.sleep(...)` long enough for the task to finish, and add `throws InterruptedException` to `main`, like lesson 16's countdown.

**Basic (1 pt)**  
- Create a `Timer` and a `TimerTask`, using an **anonymous class** (lesson 49):  

```java
// at the top of the file:
import java.util.Timer;
import java.util.TimerTask;

// main's first line becomes:
// public static void main(String[] args) throws InterruptedException {

// inside main:
Timer timer = new Timer();

TimerTask task = new TimerTask() {
    @Override
    public void run() {
        System.out.println("Hello");
    }
};

// Run the task once, after 3 seconds (3000 ms)
timer.schedule(task, 3000);

// Wait for it, then stop the timer so the program can end
Thread.sleep(4000);
timer.cancel();
```

- Try it without the last two lines once, and look at your log: `Hello` isn't in it, and the program doesn't end on its own (stop it with **Ctrl+C**). Then put them back.  

**Extra (1 pt)**  
- Schedule a task to repeat at a fixed rate, and let the task stop itself:  

```java
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

// The task cancels the timer itself, but main still has to wait for it
Thread.sleep(4000);
```

- Change the first number, the delay, to `3000`. Now it waits 3 seconds before the first `Hello`. How long does `main` have to sleep now?  

---

## 🤖 Part 2 – Robot Code (2 pts)

**Basic (1 pt)**  
- Use a timer to log robot status every second:  

```java
Timer timer = new Timer();

TimerTask logTask = new TimerTask() {
    @Override
    public void run() {
        SmartDashboard.putString("Status", "Robot running...");
    }
};

timer.scheduleAtFixedRate(logTask, 0, 1000);
```

**Extra (1 pt)**  
- Stop logging after 5 updates:  

```java
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
```

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

```java
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
- Emphasize Timer = scheduler, TimerTask = job.  
- Robot code: periodic logging, sensor checks, timed shutdowns.  
- Archaeology: replace loops/delays with TimerTask.  
- Segue: Next lesson → **Countdown Timer** (using Timer + TimerTask to count down).  
-->
