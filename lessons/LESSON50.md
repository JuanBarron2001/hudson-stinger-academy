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

> The `import` lines go at the **top** of your `Main.java`, and the rest goes **inside** `main`. Keep the `public class Main extends BaseLesson` line your file already has: without `extends BaseLesson`, the lesson runner can't run it.

> ⚠️ **Make `main` wait for the timer.** A `Timer` runs its task on its own thread, in the background. If `main` finishes first, the lesson runner stops logging, so the task's output never reaches your log. And a timer that's never cancelled keeps the program running forever. So after scheduling, call `Thread.sleep(...)` long enough for the task to finish, and add `throws InterruptedException` to `main`, like lesson 16's countdown.

**Basic (1 pt)**  
- Import `java.util.Timer` and `java.util.TimerTask`, and add `throws InterruptedException` to `main`'s first line, after the parentheses.  
- Create a `Timer`.  
- Create a `TimerTask` using an **anonymous class** (lesson 49), `new TimerTask() { ... };`, whose `public void run()` prints `Hello`.  
- `timer.schedule(task, 3000)` runs it once, after 3 seconds (3000 ms).  
- Then wait for it and stop the timer, so the program can end: `Thread.sleep(4000);` and `timer.cancel();`.  
- Try it without those last two lines once, and look at your log: `Hello` isn't in it, and the program doesn't end on its own (stop it with **Ctrl+C**). Then put them back.  

Expected output, three seconds after it starts:  

```
Hello
```

**Extra (1 pt)**  
- Schedule a task to repeat, and let the task stop itself. Give the anonymous `TimerTask` its own field, `int count = 3;`. Its `run()` prints `Hello` and counts down; once `count` reaches `0`, it prints `Task complete` and calls `timer.cancel()`.  
- `timer.scheduleAtFixedRate(task, 0, 1000)` starts it immediately (0 ms delay) and repeats every 1000 ms.  
- The task cancels the timer itself, but `main` still has to wait for it: `Thread.sleep(4000);`.  
- Change the first number, the delay, to `3000`. Now it waits 3 seconds before the first `Hello`. How long does `main` have to sleep now?  

Expected output, one line a second:  

```
Hello
Hello
Hello
Task complete
```

---

## 🤖 Part 2 – Robot Code: the 2026 Robot (2 pts)

Your code goes in `robot-code/command-based-bot-2026/src/main/java/frc/lesson/lesson50/basic/Lesson50.java` (and `extra/Lesson50.java`). The task list is at the top of each file.  
Run it in the simulator the way you did in [Lesson 00](./LESSON00.md). CAN IDs, inversions and buttons are in [ROBOT.md](../robot-code/command-based-bot-2026/ROBOT.md).

> ⚠️ **Two different classes are called `Timer`.** Part 1's is `java.util.Timer`, and it comes with its own thread. WPILib has its own, `edu.wpi.first.wpilibj.Timer`, which is just a stopwatch you read. **Robot code uses WPILib's.** Import the wrong one and your code either won't compile or will do something much worse — see "Why not `TimerTask` on a robot?" below. Nothing in last season's competition code uses `java.util.Timer` at all.

**Basic (1 pt)**: a stopwatch on the robot's own loop  
- Import `edu.wpi.first.wpilibj.Timer` and make one as a field.  
- In `setup()`, call `timer.restart()`.  
- In `execute()`, read `timer.get()` and put the seconds on SmartDashboard. `execute()` already runs about 50 times a second, so you don't need anything to call you.  
- Put a status next to it that changes with time: under 2 seconds, `"WAITING"`; after that, `"READY"`. This is the `if` from lesson 05, reading a clock.  
- Add a button that calls `timer.restart()` and watch the seconds go back to zero.  

**Why not `TimerTask` on a robot?** Robot code runs one loop every 20 ms, and everything — motors, the dashboard, your lesson's log — expects to be touched from that loop. A `java.util.Timer` runs its `TimerTask` on a **second thread**, so two pieces of code can reach the same motor at the same moment, and which one wins is luck. It also keeps running after your lesson ends. Write it in the Java half, not here.

**Extra (1 pt)**: run "Just Shoot" by hand  
- Last season's `Just Shoot` auto is a sequence with times in it: spin the rollers up for 1 second, then feed for 15. Build the same shape out of one timer and `if`s, on the rollers (CAN 5, 6) and the conveyor (CAN 29).  
  - `timer.get() < 1.0` → rollers at your lesson 07 shooting power, conveyor `0`.  
  - between `1.0` and `5.0` → rollers still going, conveyor `-0.7` (the feed, from ROBOT.md).  
  - after `5.0` → everything `0`, and put `"DONE"` on SmartDashboard.  
- Publish the phase name every loop, so your log reads like a timeline of the auto.  
- Then read `JustShoot.java` in Part 3 and compare: one `.withTimeout()` per step, no clock arithmetic anywhere. Write down which version you'd rather change the day before a match.  

---

## 📜 Part 3 – Code Archaeology (2 pts, optional)

> *Optional: skip this part if you're short on time.* Last season's code is [`Hudson-Robotics/OG-Code-2026`](https://github.com/Hudson-Robotics/OG-Code-2026), branch **`Pre-DCMP-Flywheel`**.

**Basic (1 pt)**: how the robot really tells time  
- `Timer`, `TimerTask` and `Thread.sleep` appear **nowhere** in the whole competition code. Every timed thing is done two ways instead: `new WaitCommand(DRIVE_TO_CLIMB_WAIT_SECONDS)` in `commands/auto/DriveToClimb.java`, and `.withTimeout(JUST_SHOOT_DRIVE_SECONDS)` in `commands/auto/JustShoot.java`.  
- What is the difference between the two? One of them does nothing for three seconds; the other lets a command run and then cuts it off. Say which is which, and why an auto needs both.  
- Neither one blocks the robot loop. Explain what would happen to the driver's controls if an auto called `Thread.sleep(3000)` instead.  

**Extra (1 pt)**: where 1.867 came from  
- `Constants.java` has `JUST_SHOOT_DRIVE_SECONDS = 1.867`. Nobody picks 1.867 out of the air. Run `git log -S"1.867" -p src/main/java/frc/robot/Constants.java` and find the commit that set it. What was the number before, what date did it change, and how many other constants changed in the same commit? Its whole message is "updated const", which tells you nothing — so what would you have written instead?  
- Same file, a few lines up: `SPIN_UP_SECONDS = 1` and `JUST_SHOOT_SECONDS = 15.0`. A 15-second launch in a 15-second auto. Is that a timeout or a "run until the period ends"?  
- Now open `commands/SpinUp.java` and `commands/Launch.java`. Both read their motor powers from SmartDashboard with `SmartDashboard.getNumber("Launching launcher roller value", LAUNCHING_LAUNCHER_PERCENT)`. What does the auto shoot at if nobody opens the dashboard that day — and what does it shoot at if someone was tuning in the pit an hour earlier and left the box at 0.2?  

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
