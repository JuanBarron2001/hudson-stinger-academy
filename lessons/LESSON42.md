# 🖥️ Lesson 42 – Composition in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🐝  

---

## 🎯 Overview
**Keywords:** Java, Composition, Part‑Of Relationship, Encapsulation, Object-Oriented Design  
Learn to:
- Understand **composition**: a “part‑of” relationship between objects  
- Recognize that in composition, the **lifetime of the part depends on the whole** (if the car is deleted, its engine is deleted too)  
- Build complex objects from smaller, reusable components  
- Differentiate **composition** from **aggregation** (aggregation = has‑a, but parts can exist independently)  

---

## ⏱️ Progress Tracking

### 📊 For the Marathon Watchers  
If you’re following the **full 12‑hour compilation** and want to see how far you’ve made it through the *entire* course:  
- **Start Time in 12‑Hour Video:** [08:39:02](https://www.youtube.com/watch?v=xTtL8E4LzTQ&t=31142s)  
- **Full Course (12h video):** [Watch Compilation](https://www.youtube.com/watch?v=xTtL8E4LzTQ)

---

### 🎯 For the Quick‑Hit Learners  
If you just want **this lesson only** and to be done with it — no scrubbing through hours of footage:  
- **Lesson Playlist:** [Java tutorial for beginners (2025) ☕](https://www.youtube.com/playlist?list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc)  
- **This Lesson Only:** [Watch Lesson 42](https://www.youtube.com/watch?v=6MYaUdSuW24&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=54) (Learn composition in 6 minutes! ⚙️, 6:17)

---

## 💻 Part 1 – Java‑Only (2 pts)

> Each class gets its own file next to `Main.java`, starting with the same `package` line, like lesson 27 (`package lesson42.basic;`, and `package lesson42.extra;` for the extra's copies).

**Basic (1 pt)**  
- Create an `Engine` class with a `String type`, a constructor, `Engine(String type)`, and `void start()`, which prints `You start the `, the type, and ` engine`.  
- Create a `Car` class that **contains** an engine: `String model`, `int year` and `Engine engine`. Its constructor is  

```java
Car(String model, int year, String engineType)
```

  and it builds the engine **itself**, from `engineType`. The engine is created as part of the car. That's **composition**: a car *has an* engine.  
- Give `Car` its own `void start()`, which starts the engine and then prints the model followed by ` is running`.  
- In `main()`, create `new Car("Corvette", 2025, "V8")`. Print its model and year, then `Engine type: ` and `car.engine.type`, then call `car.start()`.  

Expected output:  

```
Corvette 2025
Engine type: V8
You start the V8 engine
Corvette is running
```

**Extra (1 pt)**  
- Print `car.engine` directly. You get a hash code, because it's an object (lesson 35). Give `Engine` a `toString()` that returns the type followed by ` engine`, and print it again.  
- Build a second car with a different engine, `new Car("Mustang", 2025, "V6")`, and start both.  
- Notice that `main` never created an `Engine`: each car built its own inside its constructor, and the only way to reach one is through its car (`car.engine`). When a car goes away, its engine goes with it. In a comment, compare that with lesson 41, where the books were built first and handed to the library, so they outlived it.  

Expected output (after the hash code line):  

```
V8 engine
You start the V8 engine
Corvette is running
You start the V6 engine
Mustang is running
```

---

## 🤖 Part 2 – Robot Code: the 2026 Robot (2 pts)

Your code goes in `robot-code/command-based-bot-2026/src/main/java/frc/lesson/lesson42/basic/Lesson42.java` (and `extra/Lesson42.java`). The task list is at the top of each file.  
Run it in the simulator the way you did in [Lesson 00](./LESSON00.md).

> 🤖 **This is the lesson where the robot becomes a robot.** Everything you've built since [Lesson 27](./LESSON27.md) gets owned by one object.

**Basic (1 pt)**: the robot becomes one object  

Inheritance is **IS-A**: a `Drivetrain` *is a* `SubsystemBase`. Composition is **HAS-A**, and it's what actually holds a robot together: the robot *has* a drivetrain, *has* a fuel mechanism, *has* a climber. None of those is a kind of robot. The robot **owns** them.

- Make `frc/robot/RobotContainer.java`. It **extends nothing**. It just owns things:  

```java
private final Drivetrain drivetrain = new Drivetrain();
private final Fuel fuel = new Fuel();
private final Climber climber = new Climber();
private final XboxController driver = new XboxController(0);
private final XboxController operator = new XboxController(1);
```

Exactly **one of each**, for the whole robot. That's [Lesson 31](./LESSON31.md)'s counter, enforced by there being one place that builds them.

- Make `frc/robot/commands/TeleopDrive.java` — a `Command` taking the `Drivetrain` and the driver's controller, with `addRequirements(drivetrain)`. Its `execute()` does the arcade driving you've done since lesson 04, and `isFinished()` returns `false`: it never ends.  
- In the constructor, hand the drivetrain over:  

```java
drivetrain.setDefaultCommand(new TeleopDrive(drivetrain, driver));
```

That is the method [Lesson 32](./LESSON32.md) told you that you'd inherited and had no use for yet. It means *run this whenever nothing else wants the drivetrain.*

- Add an `update()` method holding the button bindings — **B** runs `Intake`, the way you did in [Lesson 34](./LESSON34.md).  
- Your lesson's `setup()` makes **one** `RobotContainer`. Its `execute()` is a single line: `container.update();`  
- Run it and drive. **Nothing in your lesson file mentions a motor, a subsystem, a CAN ID or a stick.** It says "update the robot."  

> 🚦 **Why the default command matters.** Before this, your lesson called `drivetrain.arcade()` straight from `execute()`. It worked — but it went *around* the scheduler, so `addRequirements()` could not protect the drivetrain from **you**. Now every single thing that moves the drivetrain is a command, and the scheduler can referee all of them.

**Extra (1 pt)**: a command made of commands, and the drivetrain changing hands  

Composition again, one level up. `ShootAndClimb` is not a new behaviour — it is three behaviours you already wrote, in order.

```java
public class ShootAndClimb extends SequentialCommandGroup {
    public ShootAndClimb(Drivetrain drivetrain, Fuel fuel, Climber climber) {
        addCommands(
            new SpinUp(fuel),
            new DriveForward(drivetrain, 40),
            new ClimbUp(climber));
    }
}
```

- **No `execute()`. No `isFinished()`.** The group runs each command until it finishes, starts the next, and is done when the last one is. Every piece already knew when it was finished — which is exactly why lessons 34 and 38 made `isFinished()` do real work.  
- Bind it to the driver's **A** (the **Z** key). Publish who owns the drivetrain: one string in `TeleopDrive`'s `execute()`, a different one in its `end()`.  
- 🧪 **Tap A, then take your hands off the controls** and watch for about eight seconds. **Predict the order, and predict what happens to your teleop driving.**  

Here is what comes out:

```
rollers spin up and stop  ->  drivetrain rolls to ~41 rotations  ->  climber rises to ~380
Drive/Owner: "handed over" ............................ then "TeleopDrive"
```

> ✨ **Nobody wrote that handover.** `DriveForward` requires the drivetrain, so scheduling the group **interrupted** `TeleopDrive`. When the group finished, the scheduler noticed the drivetrain was free and restarted its default command on its own. Try to drive with the sticks in the middle of the sequence — you can't, and that is correct. An autonomous routine should not be fightable.

> 🧩 **The shape to notice:** `SpinUp`, `DriveForward` and `ClimbUp` know nothing about each other, and `ShootAndClimb` adds no robot code at all — it only states the order. That is what makes a fourth auto cost three lines instead of a new file full of motor calls.

---

## 📜 Part 3 – Code Archaeology (2 pts, optional)

**Basic (1 pt)**: draw the controller map — it doesn't exist anywhere else  
- Open `RobotContainer.java` in [`OG-Code-2026`](https://github.com/Hudson-Robotics/OG-Code-2026), branch `Pre-DCMP-Flywheel`, and find `configureBindings()`. There are **fourteen** bindings across three controllers.  
- **Draw the full map**: two Xbox diagrams, driver and operator, every button labelled with what it does. Check it against [ROBOT.md](../robot-code/command-based-bot-2026/ROBOT.md)'s controller table — that table was built by reading this exact method.  
- Now the point: **that drawing did not exist anywhere before you made it.** The only description of what the robot's controls do was the source code. Ask a driver what the right bumper does and the honest answer is "let me read `RobotContainer`."  
- Keep your drawing. Tape it to the driver station. That is a genuine contribution to next season, and it took you twenty minutes.  

**Extra (1 pt)**: their sequence, and the thing yours does differently  
- Read `src/main/java/frc/robot/commands/auto/ShootAndClimb.java`. It's a `SequentialCommandGroup` with four commands, and the whole class is one `addCommands(...)` call — same shape as yours.  
- But look at **how two of them stop**:  

```java
new AutoDrive(driveSubsystem, SHOOT_AND_CLIMB_DRIVE_SPEED, 0.0)
    .withTimeout(SHOOT_AND_CLIMB_DRIVE_SECONDS),
new LaunchSequence(fuelSubsystem)
    .withTimeout(SHOOT_AND_CLIMB_SHOOT_SECONDS),
```

- Theirs stop **after a number of seconds**. Yours stop when the robot has **actually done the thing** — reached speed, travelled far enough, hit the climb limit.  
- Write down when each approach is better. Be fair: a timeout always ends, and a sensor-based `isFinished()` that never becomes true will hang your entire autonomous. Which failure would you rather have in a match?  
- Then find the compromise the real code is reaching for, and check whether they used it everywhere. (`.withTimeout()` on a sensor-terminated command gives you both. Does `ShootAndClimb`'s `ClimbUp` have one?)  

---

## 🏆 Total Points
- **Max:** 6 pts  
  - Java‑Only: 2 pts  
  - Robot Code: 2 pts  
  - Code Archaeology: 2 pts *(optional)*  

---

<!-- Drafting notes from the transcript draft. Hidden from students.
Ideas:  
- Emphasize composition = “part‑of” relationship (engine is part of car).  
- Robot code: subsystems composed of motors or joints.  
- Archaeology: replace scattered part management with composition.  
- Segue: Next lesson → **Packages & Imports** (organizing classes into packages).  
-->
