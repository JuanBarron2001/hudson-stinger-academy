# 🖥️ Lesson 32 – Inheritance in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🐝  

---

## 🎯 Overview
**Keywords:** Java, Inheritance, Parent Class, Child Class, Multi‑Level Inheritance, Extends, DRY Principle  
Learn to:
- Understand **inheritance**: one class (child) inherits attributes and methods from another (parent)  
- Use the `extends` keyword to establish parent‑child relationships  
- Apply the **DRY principle** (Don’t Repeat Yourself) by reusing code in parent classes  
- Add **unique attributes and methods** to child classes  
- Recognize **multi‑level inheritance** (grandparent → parent → child)  
- Differentiate between **siblings** (classes that share the same parent but not each other’s methods)  

---

## ⏱️ Progress Tracking

### 📊 For the Marathon Watchers  
If you’re following the **full 12‑hour compilation** and want to see how far you’ve made it through the *entire* course:  
- **Start Time in 12‑Hour Video:** [07:22:04](https://www.youtube.com/watch?v=xTtL8E4LzTQ&t=26524s)  
- **Full Course (12h video):** [Watch Compilation](https://www.youtube.com/watch?v=xTtL8E4LzTQ)

---

### 🎯 For the Quick‑Hit Learners  
If you just want **this lesson only** and to be done with it — no scrubbing through hours of footage:  
- **Lesson Playlist:** [Java tutorial for beginners (2025) ☕](https://www.youtube.com/playlist?list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc)  
- **This Lesson Only:** [Watch Lesson 32](https://www.youtube.com/watch?v=GTP5lVEKXaU&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=44) (Learn Java inheritance in 9 minutes! 👨‍👧‍👦, 9:07)

---

## 💻 Part 1 – Java‑Only (2 pts)

> Each class gets its own file next to `Main.java`, starting with the same `package` line, like lesson 27: `Animal.java`, `Dog.java` and `Cat.java` all start with `package lesson32.basic;`. The extra folder gets its own copies with `package lesson32.extra;`.

**Basic (1 pt)**  
- Create a parent class `Animal` with:  
  - Attribute: `boolean isAlive`  
  - Constructor: sets `isAlive = true`  
  - Method: `void eat()`  

```java
public class Animal {
    boolean isAlive;

    Animal() {
        isAlive = true;
    }

    void eat() {
        System.out.println("The animal is eating");
    }
}
```

- Create child classes `Dog` and `Cat` that **extend** `Animal`.  
- Instantiate them and show they inherit `isAlive` and `eat()`.  

**Extra (1 pt)**  
- Add unique attributes and methods:  
  - `Dog`: `int lives = 1; void speak() { System.out.println("The dog goes woof"); }`  
  - `Cat`: `int lives = 9; void speak() { System.out.println("The cat goes meow"); }`  

```java
Dog dog = new Dog();
Cat cat = new Cat();

System.out.println(dog.isAlive); // true
dog.eat();                       // inherited
dog.speak();                     // unique

System.out.println(cat.lives);   // 9
cat.speak();                     // unique
```

- **Multi‑level inheritance**, the end of the video. Add a grandparent class `Organism` and move `isAlive` and its constructor into it, so `Animal extends Organism`. `Dog` and `Cat` still have `isAlive`: they get it through `Animal`.  
- Add `Plant extends Organism` with `void photosynthesize()` that prints `"The plant absorbs sunlight"`. A plant is alive, but it can't `eat()`, and a dog can't `photosynthesize()`. Try calling `dog.photosynthesize()` and read the error. They're siblings under `Organism`, not parent and child.  

---

## 🤖 Part 2 – Robot Code: the 2026 Robot (2 pts)

Your code goes in `robot-code/command-based-bot-2026/src/main/java/frc/lesson/lesson32/basic/Lesson32.java` (and `extra/Lesson32.java`). The task list is at the top of each file.  
Run it in the simulator the way you did in [Lesson 00](./LESSON00.md).

> 🏁 **This lesson ends the drivetrain-and-fuel unit.** After it, your two classes are real WPILib subsystems, and [Lesson 34](./LESSON34.md) can finally write a command. If you've fallen behind, this is the checkpoint to catch up at — ask a mentor for the reference copy.

**Basic (1 pt)**: `Drivetrain extends SubsystemBase`  

One word, and your class inherits a pile of machinery WPILib already wrote. You have been on the receiving end of this since lesson 01, by the way: every lesson you have ever written says `extends LessonBase`, which is exactly where `setup()` and `execute()` come from.

- Make it `public class Drivetrain extends SubsystemBase` (`edu.wpi.first.wpilibj2.command.SubsystemBase`).  
- Add a `periodic()` method with `@Override` and move your telemetry into it:  

```java
@Override
public void periodic() {
    SmartDashboard.putNumber("Drive/Left Rotations", leftLeader.getPosition().getValueAsDouble());
    SmartDashboard.putString("Drive/Name", getName());
}
```

- **You never call `periodic()`.** The `CommandScheduler` does, every loop, because `SubsystemBase` registered your drivetrain the moment you built it.  
- `getName()` is not a method you wrote either. It came with the parent, and it already returns `"Drivetrain"` — worked out from the class itself, not from a String you typed.  
- Now replace your arcade math with WPILib's:  

```java
drive = new DifferentialDrive(leftLeader::set, rightLeader::set);   // in the constructor
drive.arcadeDrive(forward * forwardScale, turn * turnScale);        // in arcade()
```

- The `::` is a **method reference**. Read it as *"the `set` method of `leftLeader`"*. [Lesson 56](./LESSON56.md) explains it properly; copy the pattern for now, the same way you did in [Lesson 49](./LESSON49.md).  
- Your `execute()` is now two lines: read the sticks, call `arcade()`.  
- 🧪 Run it and hold **W** for two seconds. You go about **3.9 m**. Lesson 29 went **5.4 m** with the same numbers. **Predict why before reading on.**  

> 🎯 **The answer:** `arcadeDrive` **squares** your input by default, so `0.7` becomes `0.49`. It's meant to give finer control near the middle of the stick, where drivers spend most of their time. Pass a third argument to turn it off — `drive.arcadeDrive(forward * forwardScale, turn * turnScale, false)` — and you're back to **5.4 m**. Decide which one this robot should have, and write down why. That is a real driver-preference argument, and you now have the numbers for both sides of it.

**Extra (1 pt)**: do it again, then count what the one word bought you  

- Make `Fuel extend SubsystemBase` too, and move **all** its telemetry into its own `periodic()`: the name, the last action, the roller speed. Group the keys with prefixes — `Fuel/...` and `Drive/...` — the way last season's code does.  
- Drive **and** intake at once: sticks for the drivetrain, the operator's **B** for the intake. Your `execute()` should be about four lines and mention no motors at all.  
- Run it holding **W** and **B** together. You drive while intaking, both `periodic()`s keep publishing, `Fuel/Name` says `Fuel` and `Drive/Name` says `Drivetrain`, and the rollers sit at **−68 RPS**.  
- 🧪 **The experiment:** delete `extends SubsystemBase` from `Fuel` and try to run it. **Predict both things that go wrong.**  

**Now count.** For the one word `extends SubsystemBase`, each subsystem got:

| What you got | Who wrote it |
|---|---|
| `periodic()`, called every loop — in teleop *and* while disabled | WPILib |
| `getName()`, already correct | WPILib |
| Registration with the `CommandScheduler` | WPILib |
| `setDefaultCommand()`, which does nothing yet and is the entire point of lesson 34 | WPILib |

You wrote none of it. That is what inheritance is: a parent that already did the boring part, and a child that only says what's different.

> 📍 **Why moving the telemetry matters more than it looks.** It now lives in the subsystem, not the lesson. A subsystem that reports on itself keeps reporting no matter who is driving it — your lesson today, a command tomorrow, an autonomous routine in lesson 42. If you'd left it in `execute()`, it would go silent the moment something other than your lesson took the wheel.

---

## 📜 Part 3 – Code Archaeology (2 pts, optional)

**Basic (1 pt)**: every `extends` in the robot  
- Run this on [`OG-Code-2026`](https://github.com/Hudson-Robotics/OG-Code-2026), branch `Pre-DCMP-Flywheel`: `grep -rn "class .* extends " src/main/java/frc/robot`.  
- You get **28 classes and only four parents**: `SubsystemBase` (4 of them), `Command` (19), `SequentialCommandGroup` (4) and `TimedRobot` (1).  
- Write down what each parent provides. You already know the first one — you just inherited from it. `Command` is [Lesson 34](./LESSON34.md), `SequentialCommandGroup` is lesson 42.  
- Nineteen commands against four subsystems. What does that ratio tell you about where a robot's code actually goes?  

**Extra (1 pt)**: the one file that inherits nothing  
- `LimelightHelpers.java` is 1,946 lines and extends nothing at all. Find out why, and the answer isn't "they forgot". The tell is its very first line: `//LimelightHelpers v1.14 (REQUIRES LLOS 2026.0 OR LATER)`. Nobody version-stamps their own robot code.  
- It's a **vendor library** — Limelight publishes it, teams drop it in. So it can't inherit from WPILib's command framework, because it isn't allowed to assume you're using it.  
- That's the trade-off worth naming: `CANDriveSubsystem` gets `periodic()` for free but only works inside WPILib. `LimelightHelpers` works anywhere and has to do everything itself. Which of your own classes could survive being copied into a different robot project?  

---

## 🏆 Total Points
- **Max:** 6 pts  
  - Java‑Only: 2 pts  
  - Robot Code: 2 pts  
  - Code Archaeology: 2 pts *(optional)*  

---

<!-- Drafting notes from the transcript draft. Hidden from students.
Ideas:  
- Show how inheritance reduces duplication (DRY principle).  
- Robot code: subsystems inherit from a common parent.  
- Archaeology: replace repeated attributes with a parent class.  
- Segue: Next lesson → **Method Overriding** (child classes redefine parent methods).  
-->
