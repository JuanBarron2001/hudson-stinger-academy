# 🖥️ Lesson 37 – Interfaces in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🐝  

---

## 🎯 Overview
**Keywords:** Java, Interfaces, Multiple Inheritance, Abstract Methods, Implements  
Learn to:
- Understand that an **interface** is a blueprint for a class  
- Recognize that interfaces contain **abstract methods** (no body, just signatures)  
- Implement interfaces in classes, which forces those classes to define the methods  
- Achieve **multiple inheritance–like behavior** by implementing more than one interface  
- Differentiate between **abstract classes** and **interfaces**  

---

## ⏱️ Progress Tracking

### 📊 For the Marathon Watchers  
If you’re following the **full 12‑hour compilation** and want to see how far you’ve made it through the *entire* course:  
- **Start Time in 12‑Hour Video:** [08:01:30](https://www.youtube.com/watch?v=xTtL8E4LzTQ&t=28890s)  
- **Full Course (12h video):** [Watch Compilation](https://www.youtube.com/watch?v=xTtL8E4LzTQ)

---

### 🎯 For the Quick‑Hit Learners  
If you just want **this lesson only** and to be done with it — no scrubbing through hours of footage:  
- **Lesson Playlist:** [Java tutorial for beginners (2025) ☕](https://www.youtube.com/playlist?list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc)  
- **This Lesson Only:** [Watch Lesson 37](https://www.youtube.com/watch?v=c2sTQk9opO8&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=49) (Learn INTERFACES in 6 minutes! 📋, 6:16)

---

## 💻 Part 1 – Java‑Only (2 pts)

> Every interface and class gets its own file next to `Main.java`, starting with the same `package` line, like lesson 27: `Prey.java`, `Predator.java`, `Rabbit.java` and so on all start with `package lesson37.basic;` (and `package lesson37.extra;` for the extra's copies).

**Basic (1 pt)**  
- Create two interfaces:  

```java
public interface Prey {
    void flee();
}

public interface Predator {
    void hunt();
}
```

- Create a `Rabbit` class that implements `Prey`:  

```java
public class Rabbit implements Prey {
    @Override
    public void flee() {
        System.out.println("The rabbit is running away!");
    }
}
```

- Create a `Hawk` class that implements `Predator`:  

```java
public class Hawk implements Predator {
    @Override
    public void hunt() {
        System.out.println("The hawk is hunting!");
    }
}
```

- In `main()`, create a `Rabbit` and a `Hawk`, and call `rabbit.flee()` and `hawk.hunt()`. A rabbit has no `hunt()` and a hawk has no `flee()`.  
- Delete the word `public` from the rabbit's `flee()` and read the error. An interface's methods are always public, so the class that fills them in has to keep them public. Put it back.  

**Extra (1 pt)**  
- Create a `Fish` class that implements **both** `Prey` and `Predator`:  

```java
public class Fish implements Prey, Predator {
    @Override
    public void flee() {
        System.out.println("The fish is swimming away!");
    }

    @Override
    public void hunt() {
        System.out.println("The fish is hunting smaller fish!");
    }
}
```

- Demonstrate usage:  

```java
Rabbit rabbit = new Rabbit();
Hawk hawk = new Hawk();
Fish fish = new Fish();

rabbit.flee(); // The rabbit is running away!
hawk.hunt();   // The hawk is hunting!
fish.flee();   // The fish is swimming away!
fish.hunt();   // The fish is hunting smaller fish!
```

---

## 🤖 Part 2 – Robot Code: the 2026 Robot (2 pts)

Your code goes in `robot-code/command-based-bot-2026/src/main/java/frc/lesson/lesson37/basic/Lesson37.java` (and `extra/Lesson37.java`). The task list is at the top of each file.  
Run it in the simulator the way you did in [Lesson 00](./LESSON00.md). Climber numbers are in [ROBOT.md](../robot-code/command-based-bot-2026/ROBOT.md).

An abstract class says *"you **are** a kind of me."* An interface says something smaller and far more useful: *"you can **do** this one thing."* It does not care what you are.

Java already ships the one you need. `DoubleSupplier` is an interface with a single method — `double getAsDouble()` — and it means *"ask me for a number, whenever you like."*

**Basic (1 pt)**: the climber, at whatever speed the driver wants  

- Make `frc/robot/subsystems/Climber.java`, a `SubsystemBase` on **CAN 7**: brake mode, **80 A** limit, and `motor.setPosition(0)` in the constructor so you start from a known place. Give it `setSpeed(double)`, `getPosition()`, `stop()` and a `periodic()` that publishes the position.  
- Make `frc/robot/commands/DynamicClimb.java`, whose constructor takes a `Climber` **and** a `DoubleSupplier`:  

```java
public DynamicClimb(Climber climber, DoubleSupplier speed) { ... }

@Override
public void execute() {
    climber.setSpeed(speed.getAsDouble());   // no idea where this number came from
}
```

- Make `frc/robot/TriggerAxis.java`, a small class that **implements** the interface:  

```java
public class TriggerAxis implements DoubleSupplier {
    private final XboxController controller;
    public TriggerAxis(XboxController controller) { this.controller = controller; }

    @Override
    public double getAsDouble() { return controller.getRightTriggerAxis(); }
}
```

- Build `new DynamicClimb(climber, new TriggerAxis(driver))` and schedule it while the right trigger is past `0.1`. At home the driver's triggers are **Q** and **E**.  
- Run it. Squeeze the trigger a little, then a lot. **Predict the position after a couple of seconds at each.** Measured: a quarter trigger for about a second gets you **25 rotations**, half gets **78**, full gets **180**.  

> 🔌 **`DynamicClimb` never mentions `XboxController`, triggers, or the driver.** It asks an interface for a number. Anything that can produce a `double` can drive your climber — and the extra half proves it.

**Extra (1 pt)**: prove the command doesn't care, then give it a limit  

- Make `frc/robot/FixedSpeed.java`, also `implements DoubleSupplier`. It holds one number and returns it. That is the entire class.  
- Build a **second** `DynamicClimb` with it:  

```java
byTrigger = new DynamicClimb(climber, new TriggerAxis(driver));
byFixed   = new DynamicClimb(climber, new FixedSpeed(0.3));
```

- Right trigger runs the first, **A** (the **Z** key) runs the second. Hold **A** and *don't touch the trigger* — the climber still moves, at a steady `0.3`. You changed `DynamicClimb` **exactly zero times** to make that work.  
- Now the limit. Add `UP_LIMIT_ROTATIONS = 365` to your climber constants and make `isFinished()` return `climber.getPosition() > UP_LIMIT_ROTATIONS`.  
- 🧪 Hold the trigger flat out for about eight seconds. **Predict where it stops.**  
- **It does not stop at 365. It stops around 411.** `isFinished()` cuts the power at 365, and a spinning climber keeps going for a while after that. A software limit is a request, not a wall — so the number you choose has to leave room for the coast.  

> 🎯 **The whole lesson in one line:** an interface is a promise about *one behaviour*. `DynamicClimb` asked for "something that can give me a double" and got a trigger, then a constant — and could just as easily get a dashboard value, a sensor, or an autonomous routine. It never has to know, and it never has to change.

> ⚡ **The short way, coming soon.** `TriggerAxis` is eight lines wrapping one expression. Java has a shorter way to say exactly the same thing: `new DynamicClimb(climber, () -> driver.getRightTriggerAxis())`. That is the literal line last season's code uses, and it is a `DoubleSupplier` too — Java writes the class for you. [Lesson 49](./LESSON49.md) showed you the long way round; [Lesson 56](./LESSON56.md) finishes the job.

---

## 📜 Part 3 – Code Archaeology (2 pts, optional)

Open `src/main/java/frc/robot/commands/DynamicClimbUp.java` in [`OG-Code-2026`](https://github.com/Hudson-Robotics/OG-Code-2026), branch `Pre-DCMP-Flywheel`. It is the command you just wrote, including the `DoubleSupplier` field.

**Basic (1 pt)**: what stops the driver from overdriving the climber?  
- Read `DynamicClimbUp.isFinished()`. Here it is, in full:  

```java
public boolean isFinished() {
    //return climberSubsystem.getPosition() > 60;
    return false;
}
```

- The limit **was written, and then commented out**. `DynamicClimbDown` has the identical pattern: `//return climberSubsystem.getPosition() < -40;` above a `return false;`.  
- Now open `ClimbUp.java` — the D-pad version of the same motion. Its `isFinished()` is `return climberSubsystem.getPosition() > 365;`, with `//return false;` commented out above it. **Somebody flipped the comment the other way in that file and not in this one.**  
- So: the D-pad climb stops itself and the trigger climb does not, on the same mechanism, on the same robot. `RobotContainer` binds both (lines 130 and 132). **Answer the question in the heading**, and say what a driver leaning on the trigger at the end of a match would actually get.  
- One more: the commented-out limit says **60** and the live one says **365**. They cannot both be right. Which is, and how would you find out without the robot?  

**Extra (1 pt)**: the lambda you were about to write  
- Find the two bindings in `RobotContainer.java`:  

```java
driverController.rightTrigger(0.1).whileTrue(
    new DynamicClimbUp(climberSubsystem, () -> driverController.getRightTriggerAxis()));
```

- That `() -> driverController.getRightTriggerAxis()` **is** your `TriggerAxis` class. Same interface, same one method, eight lines shorter, and no file.  
- Count what the lambda costs you as well as what it saves: you can't name it, reuse it from three places, or set a breakpoint inside it as easily. When is the eight-line class the better call?  
- Then look at `whileTrue(...)`. It schedules while the trigger is held and cancels when released — the six lines of `isScheduled()` bookkeeping you wrote by hand in [Lesson 34](./LESSON34.md), done for you. Write down what it must be doing internally, because you now know enough to guess correctly.  

---

## 🏆 Total Points
- **Max:** 6 pts  
  - Java‑Only: 2 pts  
  - Robot Code: 2 pts  
  - Code Archaeology: 2 pts *(optional)*  

---

<!-- Drafting notes from the transcript draft. Hidden from students.
Ideas:  
- Emphasize that interfaces = contracts (classes must implement methods).  
- Robot code: use interfaces for subsystems to enforce consistent behavior.  
- Archaeology: replace repeated method signatures with interfaces.  
- Segue: Next lesson → **Polymorphism with Interfaces** (treating different objects through a common interface type).  
-->
