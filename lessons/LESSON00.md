# 🧰 Lesson 00 – Git, Your Fork & the Simulator

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🐝

---

## 🎯 Overview
**Keywords:** Git, GitHub, Fork, Clone, Commit, Push, Rebase, Upstream, WPILib Simulator, simgui

This offseason, you rebuild the 2026 robot's code yourself, one lesson at a time. Before lesson 01 you need two things working:

- **Git**, so your work is saved, turned in, and able to pick up new lessons as they come out.
- **The simulator**, so you can run robot code at home with no robot.

This lesson has no code to write. It's done when your setup check says **PASSED** and that log is pushed to your fork.

---

## 🗺️ The words, in plain English

| Word | What it means |
|---|---|
| **Git** | A program that saves snapshots of your code, so you can always go back. |
| **GitHub** | A website that stores git projects online. |
| **Repository (repo)** | One project and all of its history. |
| **Fork** | Your own copy of someone else's repo, on GitHub. You can change yours freely, and the original isn't touched. |
| **Clone** | Downloading a repo onto your laptop. |
| **Commit** | Saving a snapshot, with a message that says what changed. |
| **Push** | Sending your commits up to GitHub. |
| **Upstream** | The original repo you forked from. New lessons show up there first. |
| **Rebase** | Replaying your commits on top of the newest upstream, as if you'd started from it. |

---

## 💻 Part 1 – Git

### 1. Fork the academy
1. Go to **github.com/JuanBarron2001/hudson-stinger-academy**.
2. Click **Fork**, then **Create fork**.

You now have `github.com/<your-username>/hudson-stinger-academy`. That's where your work lives.

### 2. Clone your fork
Replace `<your-username>` with yours:

```bash
git clone https://github.com/<your-username>/hudson-stinger-academy.git
cd hudson-stinger-academy
```

### 3. Tell git where new lessons come from

```bash
git remote add upstream https://github.com/JuanBarron2001/hudson-stinger-academy.git
git remote -v
```

You should see **two** names: `origin` (your fork) and `upstream` (the academy).

### 4. The everyday loop
Finish a lesson half, then:

```bash
git add .
git commit -m "lesson 05 basic"
git push
```

Commit after **each half** of each lesson, not once a week. Small commits are easy to undo; giant ones aren't.

### 5. Getting new lessons (rebase)
When a mentor says new lessons are out:

```bash
git fetch upstream
git rebase upstream/main
git push --force-with-lease
```

- `fetch` downloads what's new without changing your files.
- `rebase` stacks your commits on top of the new lessons.
- Rebasing rewrites your fork's history, so a normal `git push` gets refused. `--force-with-lease` pushes anyway, but refuses if your fork has something you don't have locally, so you can't accidentally wipe work.

> 🧯 **If the rebase stops with a "conflict":** don't panic, and don't delete anything. Run `git rebase --abort` to get back exactly where you were, then ask a mentor. Conflicts should be rare, because new lessons don't touch files you've already worked in.

---

## 🤖 Part 2 – The Simulator

### 1. Open the robot project
In **WPILib VS Code 2026**, use **File → Open Folder** and open:

```
hudson-stinger-academy/robot-code/command-based-bot-2026
```

Open that exact folder, not the whole repo, or the WPILib commands won't show up.

### 2. Pick lesson 00
Open `src/main/java/frc/robot/PickYourLesson.java` and set:

```java
public static final int LESSON = 0;
public static final boolean EXTRA = false;
```

That file is the only place you ever choose a lesson.

### 3. Start the simulator
Press **Ctrl+Shift+P**, type **WPILib: Simulate Robot Code**, press Enter, make sure **Sim GUI** is checked, and click **OK**.

The first run takes a while, because it downloads libraries. A window called the **Robot Simulation** GUI opens.

> Terminal instead? From the project folder: `./gradlew simulateJava` (on Windows: `gradlew simulateJava`).

### 4. Use your keyboard as a controller
The project comes set up so **Keyboard 0** acts like an Xbox controller plugged into slot **0**:

| Xbox controller | Keyboard |
|---|---|
| Left stick | **W A S D** (W is stick forward) |
| Right stick | **I J K L** |
| Left / right trigger | **Q** / **E** |
| A / B / X / Y | **Z** / **X** / **C** / **V** |
| Left / right bumper | **1** / **2** |
| Back / Start | **9** / **0** |
| D-pad | **Arrow keys** |

Some lessons also use the **operator** controller, which is **Keyboard 1** in slot **1**:

| Operator controller | Keyboard |
|---|---|
| A / B / X / Y | **5** / **6** / **7** / **8** |
| Left / right bumper | **3** / **4** |
| Left / right trigger | **O** / **P** |

The simulator window has to be selected (clicked on) for your key presses to count.

> 🤖 **Want to see the robot actually move?** Set `LESSON = 98` and run it. Lesson 98 isn't a lesson, it's the **simulator check**: it drives with **W/S** and **J/L**, spins the rollers on the operator's **5**, and runs the climber on the **arrow keys**. Everything it hears shows up under **Demo/**. Use it any time you're not sure whether the problem is your code or your setup. Every real lesson starts as an empty file, so an empty file publishing nothing is normal.

> 🔧 **Keys doing nothing?** Look at the **Joysticks** window. If slot 0 is empty, drag **Keyboard 0** from the **System Joysticks** window onto it. The key mapping lives in the **Keyboard 0 Settings** window if you ever need to check it.

### 5. Run it
1. In the **Robot State** window, click **Teleoperated**. Your lesson only runs in Teleoperated.
2. Open **NetworkTables → SmartDashboard** and find **Setup Check**.
3. Hold **W** until *Moved Stick* is true, then press **Z** until *Pressed A* is true.
4. **Setup Check** should now say **PASSED**.

### 6. Find your log and turn it in
Close the simulator window. Your log is now in the project folder:

```
robot-code/command-based-bot-2026/frc.lesson.lesson00.basic-output.log
```

Commit it and push it:

```bash
git add .
git commit -m "lesson 00 setup check passed"
git push
```

---

## 🏠 How robot lessons work at home

Every robot lesson runs in the simulator exactly the way lesson 00 did. The simulator makes the 2026 robot's motors and gyro behave like the real ones, including the mistakes:

- **Forget to invert the right side** of the drivetrain and the simulated robot spins in place, just like the real one would.
- **Command the flywheel to a speed** and it actually spins up and holds it.
- **Want to watch the robot drive?** Open **NetworkTables → SmartDashboard → Sim Field**.

What the simulator **can't** do yet is fake the Limelight camera. Vision lessons need the real robot, or a mentor.

At the weekly meeting you deploy the same code to the real robot and see it for real.

The robot's CAN IDs, inversions and buttons are all in [`robot-code/command-based-bot-2026/ROBOT.md`](../robot-code/command-based-bot-2026/ROBOT.md).

---

## 🏆 Done When
- [ ] Your fork exists and `git remote -v` shows both `origin` and `upstream`.
- [ ] Setup Check said **PASSED** in the simulator.
- [ ] `frc.lesson.lesson00.basic-output.log` is committed and pushed to your fork.

Lesson 00 has no points. It's what makes the points possible.

---

> 🐝 *"Save early, save often, push before you leave."*
