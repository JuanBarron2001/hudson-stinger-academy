# 🖥️ Lesson 27 – Objects & Classes in Java (Intro to OOP)

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🐝

---

## 🎯 Overview
**Keywords:** Java, Object-Oriented Programming, Objects, Classes, Attributes, Methods, Dot Operator  
Learn to:
- Understand what an **object** is (real-world entity in code)  
- Recognize **attributes** (things an object has) and **methods** (things an object can do)  
- Create a **class** as a blueprint for objects  
- Instantiate objects using the `new` keyword  
- Access and modify attributes with the **dot operator**  
- Call methods to perform actions  

---

## ⏱️ Progress Tracking

### 📊 For the Marathon Watchers  
If you’re following the **full 12‑hour compilation** and want to see how far you’ve made it through the *entire* course:  
- **Start Time in 12‑Hour Video:** [06:41:47](https://www.youtube.com/watch?v=xTtL8E4LzTQ&t=24107s)  
- **Full Course (12h video):** [Watch Compilation](https://www.youtube.com/watch?v=xTtL8E4LzTQ)

---

### 🎯 For the Quick‑Hit Learners  
If you just want **this lesson only** and to be done with it — no scrubbing through hours of footage:  
- **Lesson Playlist:** [Java tutorial for beginners (2025) ☕](https://www.youtube.com/playlist?list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc)  
- **This Lesson Only:** [Watch Lesson 27](https://www.youtube.com/watch?v=DYbi93vuSaU&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=39) (Learn Java Object Oriented Programming in 10 minutes! 🧱, 9:51)

---

## 💻 Part 1 – Java‑Only (2 pts)

> **Where a new class goes.** Make a new file next to your `Main.java`: `java-lessons/src/lesson27/basic/Car.java`. Its first line must be `package lesson27.basic;`, the same as `Main.java`, or `Main` can't find it. The extra half lives in a different folder, so it needs its own `Car.java` that starts with `package lesson27.extra;`. Copy your basic one over and change that line.

**Basic (1 pt)**  
- Create a `Car` class with five attributes, each with a starting value: `String make` (`"Ford"`), `String model` (`"Mustang"`), `int year` (`2025`), `double price` (`58000.99`) and `boolean isRunning` (`false`).  
- In `main()`, create a car with `Car car = new Car();` and print each attribute with the dot operator: `car.make`, `car.model`, and so on.  

Expected output:  

```
Ford
Mustang
2025
58000.99
false
```

**Extra (1 pt)**  
- Add four methods to `Car`, with no `static` this time:  
  - `void start()` sets `isRunning` to `true` and prints `You start the engine`  
  - `void stop()` sets it back to `false` and prints `You stop the engine`  
  - `void drive()` prints `You drive the ` and the model  
  - `void brake()` prints `You brake the ` and the model  
- In `main()`, print `isRunning`, call `start()`, print it again, call `stop()`, and print it once more. Then call `drive()` and `brake()`.  
- Change an attribute straight from `main` with the dot operator: `car.isRunning = true;`  
- Create a **second** `Car` and print its make and model. Why is it exactly the same as the first one? Lesson 28's constructors fix that.  

Expected output (before the `car.isRunning = true;` line):  

```
false
You start the engine
true
You stop the engine
false
You drive the Mustang
You brake the Mustang
Ford Mustang
```

---

## 🤖 Part 2 – Robot Code: the 2026 Robot (2 pts)

Your code goes in `robot-code/command-based-bot-2026/src/main/java/frc/lesson/lesson27/basic/Lesson27.java` (and `extra/Lesson27.java`). The task list is at the top of each file.  
Run it in the simulator the way you did in [Lesson 00](./LESSON00.md). CAN IDs, inversions and buttons are in [ROBOT.md](../robot-code/command-based-bot-2026/ROBOT.md).

> 🧱 **This lesson changes how the robot half works, for good.** Until now everything you wrote lived inside one `LessonNN.java`, and every lesson stood alone. From here you are building **one robot that grows**, in `frc/robot/`, and each lesson adds to what the last one built. The lesson file gets thinner every time. By the end it is little more than the switch that turns your robot on.
>
> Two things that follow from that:
> - **You create the files.** Nothing is waiting there for you to fill in. Because a file you haven't written yet can't be imported, the lesson stub's `import frc.robot...` line starts **commented out**. Uncomment it once the file exists.
> - **Don't skip a lesson.** Lesson 28 expects the `Fuel` you write today. If you fall behind, ask a mentor for the reference copy rather than jumping ahead.

**Basic (1 pt)**: the fuel mechanism becomes a class  
- Make a new file, `frc/robot/subsystems/Fuel.java`, starting with `package frc.robot.subsystems;`. (It isn't a WPILib *subsystem* yet — that's lesson 32 — but this is the folder mechanisms live in, and it's where last season's code keeps them too.)  
- Three attributes, created right where you declare them, because constructors are next lesson:  

```java
public TalonFX leftRoller = new TalonFX(5);
public TalonFX rightRoller = new TalonFX(6);
public TalonFX conveyor = new TalonFX(29);
```

- Three methods — `intake()`, `eject()` and `stop()` — holding the ball paths you already used in lesson 13. Intake is rollers `-0.7` and conveyor `+0.8`; eject is `+0.9` and `+0.8`; stop is zero.  
- ⚠️ **Both rollers get the same number.** They turn the same physical rollers, so opposite signs make them fight and nothing spins. It's in [ROBOT.md](../robot-code/command-based-bot-2026/ROBOT.md), and last season's code does exactly this: `setIntakeLauncherRoller` sets both to the same `power`.  
- The class, its fields and its methods all need `public` in front, because your lesson is in a **different folder** from the class. Lesson 40 is where `public` and `private` get explained properly; for now, `public` means "anyone can reach this".  
- Back in `Lesson27.java`: uncomment the import, make **one** `Fuel` in `setup()`, and in `execute()` call `intake()` while the operator holds **B**, `eject()` on **left bumper**, and `stop()` otherwise.  
- Publish the action name and the real roller and conveyor speeds, straight off the motors: `fuel.leftRoller.getVelocity().getValueAsDouble()`.  
- Run it. At home the operator is **Keyboard 1**, so B is the **6** key and left bumper is **3**. Holding B should settle around **−68 RPS** on the rollers with the conveyor running **positive**.  

**Look at what happened to `execute()`.** It no longer mentions motors, CAN IDs or power levels. It says *intake*, *eject*, *stop*. That is the whole reason classes exist: the lesson says what to do, and `Fuel` knows how.  

**Extra (1 pt)**: two objects, one set of rollers  
- Add `public String lastAction = "none";` to `Fuel`, and set it at the end of each method.  
- Make **two** of them in `setup()`, then change only the second one with the dot operator, the way the Java half did: `fuelB.lastAction = "I am the second one";`. Put both on SmartDashboard — two objects, two answers, one class.  
- Now the interesting part. While the operator holds **B**, call `fuelA.intake();` and then `fuelB.stop();` in the same loop, and publish the real roller speed.  
- **Predict the roller speed before you run it.** Then run it and hold the 6 key.  
- The rollers sit at **0**. Both objects have their own `lastAction` and happily report different things, but the robot has only **one** pair of rollers, and both objects are commanding it. The last `set()` of each loop wins.  
- This is a bug teams actually ship: two pieces of code owning the same motor and fighting over it. Lesson 42 is where exactly one `Fuel` gets made and everything else shares it.  

---

## 📜 Part 3 – Code Archaeology (2 pts, optional)

Last season's fuel mechanism is `src/main/java/frc/robot/subsystems/CANFuelSubsystem.java` in [`OG-Code-2026`](https://github.com/Hudson-Robotics/OG-Code-2026), branch `Pre-DCMP-Flywheel`. You just wrote a 20-line version of it.

**Basic (1 pt)**: the same three motors, grown up  
- Find `leftIntakeLauncher`, `rightIntakeLauncher` and `conveyor`. They're the same three fields you declared, with longer names.  
- Find `setIntakeLauncherRoller(double power)`. It sets **both** rollers to the same `power`, which is the rule you followed. There's a comment on the second line that says `// positive for shooting`. Is that comment on the right line? What would it take to be sure?  
- Your `Fuel` has three methods. `CANFuelSubsystem` has eight and 184 lines. Skim the other five and write down which ones you could not have written yet, and what Java you'd need first. (Closed-loop flywheel control is lesson 31's constants and a Phoenix feature; `periodic()` is lesson 32.)  

**Extra (1 pt)**: the import nobody read  
- Line 31 is `import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;`. Jackson is a JSON library. **Nothing in the file uses it.** Someone's IDE offered to auto-import a class called `Default` and they pressed Enter.  
- It's harmless, and it's still worth noticing: it means at some point a name in that file didn't resolve, and the fix that got accepted was the first one offered. What's the version of that mistake that *isn't* harmless?  
- Ask the bigger question while you're in there: is there anything in this file that isn't about the fuel mechanism? That's the test for whether a class earns its name.  

---

## 🏆 Total Points
- **Max:** 6 pts  
  - Java‑Only: 2 pts  
  - Robot Code: 2 pts  
  - Code Archaeology: 2 pts *(optional)*  

---

<!-- Drafting notes from the transcript draft. Hidden from students.
Ideas:
- Objects = entities with attributes + methods.  
- Robot code: encapsulate robot parts as objects.  
- Archaeology: replace repeated code with classes.  
- Segue: Next lesson → **Constructors** (to create unique objects with custom attributes).  
-->
