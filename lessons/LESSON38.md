# 🖥️ Lesson 38 – Polymorphism in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🐝  

---

## 🎯 Overview
**Keywords:** Java, Polymorphism, Inheritance, Interfaces, Abstract Classes, Method Overriding  
Learn to:
- Understand **polymorphism**: “many shapes” → objects can be treated as their own type or as a parent type  
- Use **abstract classes** and **interfaces** to achieve polymorphism  
- Store different child objects in a single array of their **common parent type**  
- Call overridden methods dynamically at runtime (dynamic dispatch)  
- Recognize that polymorphism supports **flexibility and code reusability**  

---

## ⏱️ Progress Tracking

### 📊 For the Marathon Watchers  
If you’re following the **full 12‑hour compilation** and want to see how far you’ve made it through the *entire* course:  
- **Start Time in 12‑Hour Video:** [08:07:44](https://www.youtube.com/watch?v=xTtL8E4LzTQ&t=29264s)  
- **Full Course (12h video):** [Watch Compilation](https://www.youtube.com/watch?v=xTtL8E4LzTQ)

---

### 🎯 For the Quick‑Hit Learners  
If you just want **this lesson only** and to be done with it — no scrubbing through hours of footage:  
- **Lesson Playlist:** [Java tutorial for beginners (2025) ☕](https://www.youtube.com/playlist?list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc)  
- **This Lesson Only:** [Watch Lesson 38](https://www.youtube.com/watch?v=6xRd0j1anzc&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=50) (Learn POLYMORPHISM in 6 minutes! 🎭, 6:46)

---

## 💻 Part 1 – Java‑Only (2 pts)

> Each class gets its own file next to `Main.java`, starting with the same `package` line, like lesson 27 (`package lesson38.basic;`, and `package lesson38.extra;` for the extra's copies).

**Basic (1 pt)**  
- Create an abstract parent class, `Vehicle`, with one abstract method, `abstract void go();`.  
- Create `Car`, `Bike` and `Boat`, which each extend `Vehicle` and override `go()`. They print `You drive the car`, `You ride the bike` and `You sail the boat`.  
- First try the video's mistake: `Car[] cars = { new Car(), new Bike(), new Boat() };`. Read the error, `incompatible types: Bike cannot be converted to Car`, because a bike isn't a car. Delete it, and find the one type all three share.  
- Put all three in an array of that type, `Vehicle[] vehicles`, and loop over it with `for (Vehicle vehicle : vehicles)`, calling `vehicle.go()`. Each one runs its **own** `go()`, even though the loop only knows it's a `Vehicle`. That's **polymorphism**.  

Expected output:  

```
You drive the car
You ride the bike
You sail the boat
```

**Extra (1 pt)**  
- Now get polymorphism with an **interface** instead of an abstract class. Turn `Vehicle` into `public interface Vehicle`, with `void go();`.  
- Change `Car`, `Bike` and `Boat` from `extends Vehicle` to `implements Vehicle`, and make each `go()` `public` (lesson 37: an interface's methods are always public).  
- Run the same `Vehicle[]` loop in `main`. It shouldn't need a single change: code written against `Vehicle` works whether `Vehicle` is an abstract class or an interface.  

Expected output: the same three lines as the basic half.  

---

## 🤖 Part 2 – Robot Code: the 2026 Robot (2 pts)

Your code goes in `robot-code/command-based-bot-2026/src/main/java/frc/lesson/lesson38/basic/Lesson38.java` (and `extra/Lesson38.java`). The task list is at the top of each file.  
Run it in the simulator the way you did in [Lesson 00](./LESSON00.md).

> 🏁 **Last lesson of the commands unit.** At a competition nobody edits code between matches — the drive team picks the autonomous routine off a dropdown. That dropdown is a `SendableChooser<Command>`, and the only reason it can hold three different classes at once is polymorphism.

**Basic (1 pt)**: one box, three different autos  

- Write three autos. Each is a `Command`, and **none of them needs a timer** — each knows it is finished by looking at the robot:  

| Auto | `execute()` | `isFinished()` |
|---|---|---|
| `DriveForward(drivetrain, rotations)` | drive at `0.5` | `drivetrain.rotations() > target` |
| `SpinUpAuto(fuel)` | rollers at `-0.72` | `fuel.atSpeed()` |
| `DoNothing()` | nothing | `true`, immediately |

`DoNothing` is not a joke. Real teams ship it, for the match where you'd rather not move at all.

- Build the chooser in `setup()`:  

```java
chooser = new SendableChooser<>();
chooser.setDefaultOption("Drive Forward", new DriveForward(drivetrain, 40));
chooser.addOption("Spin Up", new SpinUpAuto(fuel));
chooser.addOption("Do Nothing", new DoNothing());
SmartDashboard.putData("Auto Chooser", chooser);      // NAME IT. Part 3 explains why.
```

- In `execute()`, read `chooser.getSelected()` into a **`Command`** variable, publish its `getName()`, and schedule it when the driver presses **A** (the **Z** key).  
- Run it **without touching the dashboard**. It drives forward about **1.9 m** and stops itself at 40 rotations, because `setDefaultOption` means *"this is what you get if nobody picks."*  
- Open the simulator's NetworkTables window, switch the chooser to **Spin Up**, press **A** again. Different auto, **zero code changed**.  

> 🧬 **Your variable is declared `Command selected`.** Not `DriveForward`, not `SpinUpAuto`. You call `selected.schedule()` without knowing which one it is, and the right `execute()` runs anyway. That is polymorphism, and this dropdown is the exact place every FRC robot uses it.

> 🔍 **One oddity worth spotting:** the dropdown says `Drive Forward` but `getName()` says `DriveForward`. The label is yours; the name came from the class. They don't have to match, and on real robots they usually don't.

**Extra (1 pt)**: the same call, three answers — and the bug that loses a match  

- Put all three autos in one array, and look hard at the type:  

```java
Command[] autos = { new DriveForward(drivetrain, 40), new SpinUpAuto(fuel), new DoNothing() };
```

- Loop over it every cycle, publishing `autos[i].getName()` and `autos[i].isFinished()` for each.  
- Read your log. **One line of code, written once**, calling `isFinished()` — and you get three different answers, because each class overrode it differently. `DoNothing` says `true` forever; the other two say `false` until the robot has actually done something.  
- 🧪 **Now the bug.** Change `setDefaultOption` to `addOption`, so nothing is the default. Run again without touching the dashboard and press **A**. **Predict what happens first.**  
- **The robot sits there. 0.00 m.** `getSelected()` returned `null`, your null check caught it, and nothing ran. No crash, no error, no clue — which is precisely how this fails at a competition: the auto period quietly doesn't happen and you find out fifteen seconds later.  
- Put `setDefaultOption` back, and keep the null check anyway. Both halves matter: a default so it works, a null check so it never crashes.  

> ⚠️ **The real point of this lesson.** Polymorphism lets one dropdown hold four unrelated classes. That same flexibility means it can also hold **nothing**, and the compiler cannot warn you, because `null` is a perfectly valid `Command` as far as the type system is concerned.

---

## 📜 Part 3 – Code Archaeology (2 pts, optional)

Open `RobotContainer.java` in [`OG-Code-2026`](https://github.com/Hudson-Robotics/OG-Code-2026), branch `Pre-DCMP-Flywheel`, around line 87.

**Basic (1 pt)**: four autos, and one of them nobody wrote  
- The chooser holds four options, and it **does** call `setDefaultOption` — `"Shoot And Climb"`. Good. Now look at what the four options actually are:  
  - `ShootAndClimb`, `DriveToClimb` and `JustShoot` are the team's own `SequentialCommandGroup`s.  
  - `AutoBuilder.buildAuto("PP Depot And Climb")` is built by **PathPlanner**, from a path somebody drew in an app. Nobody on the team ever opened that class.  
- It sits in the same `SendableChooser<Command>` as the other three, and `getAutonomousCommand()` returns any of them through one line: `return autoChooser.getSelected();`.  
- Write down why that works, in one sentence, using the word *polymorphism*. Then answer the harder one: what would have to be true about `AutoBuilder.buildAuto` for this to break?  

**Extra (1 pt)**: the dropdown the drive team can't find  
- Look at line 92: `SmartDashboard.putData(autoChooser);` — one argument. Your version passed a **name** as well.  
- What does the chooser get called without one? Try it yourself: put a `SendableChooser` on the dashboard with and without a name, run the simulator, and read the NetworkTables window.  
- It publishes as **`SendableChooser[0]`**. Not a crash, not a warning — the auto picker is simply labelled with a number on the driver station, three minutes before a match, for a drive team that didn't write the code.  
- This is the third thing you've found this unit that works perfectly and still fails a human: the tuning slider that was never published ([Lesson 34](./LESSON34.md)), the climb limit that was commented out ([Lesson 37](./LESSON37.md)), and now a dropdown with no name. **Write down what the three have in common** — it's the most useful sentence you'll get out of this whole unit.  

---

## 🏆 Total Points
- **Max:** 6 pts  
  - Java‑Only: 2 pts  
  - Robot Code: 2 pts  
  - Code Archaeology: 2 pts *(optional)*  

---

<!-- Drafting notes from the transcript draft. Hidden from students.
Ideas:  
- Emphasize polymorphism = treating different objects as one common type.  
- Robot code: subsystems polymorphically run in a loop.  
- Archaeology: replace repeated subsystem calls with polymorphic arrays.  
- Segue: Next lesson → **Dynamic Binding & Casting** (downcasting, `instanceof`, runtime type checks).  
-->
