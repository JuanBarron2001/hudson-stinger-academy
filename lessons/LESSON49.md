# 🖥️ Lesson 49 – Anonymous Classes in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🐝

---

## 🎯 Overview
**Keywords:** Java, Anonymous Classes, Method Overriding, Inheritance, Interfaces, Runnable  
Learn to:
- Give **one** object its own behavior without writing a whole new class  
- Override a method inside an **anonymous class**: `new Dog() { ... };`  
- See that an anonymous class really has no name of its own  
- Build an object from an **interface** on the spot, the pattern lesson 50's `TimerTask` uses  

---

## ⏱️ Progress Tracking

### 📊 For the Marathon Watchers  
If you’re following the **full 12‑hour compilation** and want to see how far you’ve made it through the *entire* course:  
- **Start Time in 12‑Hour Video:** [10:20:24](https://www.youtube.com/watch?v=xTtL8E4LzTQ&t=37224s)  
- **Full Course (12h video):** [Watch Compilation](https://www.youtube.com/watch?v=xTtL8E4LzTQ)

---

### 🎯 For the Quick‑Hit Learners  
If you just want **this lesson only** and to be done with it — no scrubbing through hours of footage:  
- **Lesson Playlist:** [Java tutorial for beginners (2025) ☕](https://www.youtube.com/playlist?list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc)  
- **This Lesson Only:** [Watch Lesson 49](https://www.youtube.com/watch?v=P_iOnmdww8E&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=63) (Learn Java anonymous classes in 5 minutes! 🕵️‍♂️, 5:02)

---

## 💻 Part 1 – Java‑Only (2 pts)

> New classes go in their own file next to `Main.java`, starting with the same `package` line, like lesson 27 (`package lesson49.basic;`, and `package lesson49.extra;` for the extra's copy).

**Basic (1 pt)**: one unusual dog  
- Create a `Dog` class with one method, `void speak()`, that prints `"The dog goes woof"`. In `main()`, create a dog and make it speak.  
- Scooby‑Doo is a dog who talks. **The long way** first: a new file, `TalkingDog.java`, where `TalkingDog extends Dog` and overrides `speak()` to print `"Scooby-Doo says ruh-roh"`. Create one and make it speak.  
- That's a whole class for a single dog. **The short way:** delete `TalkingDog.java`, and give a second, ordinary `Dog` its own `speak()` right where you create it:  

```java
Dog dog2 = new Dog() {
    @Override
    void speak() {
        System.out.println("Scooby-Doo says ruh-roh");
    }
};
```

- The braces after `new Dog()` are a class with **no name**: an anonymous class. Notice the `;` after the closing brace. Make both dogs speak: the first still goes woof.  

**Extra (1 pt)**: no name, and no class needed  
- Print `dog2.getClass().getName()`. Java made up a name like `lesson49.extra.Main$1`, because you never gave the class one. That's also why an anonymous class **can't be reused**: there's no name to write `new` in front of. If you need the same behavior twice, write a real class.  
- Make a second unusual dog, like Clifford, with a different `speak()`. Each anonymous class belongs to exactly one object.  
- An anonymous class can fill in an **interface** too. `Runnable` is built into Java, and its one method is `public void run()`. You can't write `new Runnable()` by itself (lesson 37: interfaces aren't classes), but you can with a body:  

```java
Runnable task = new Runnable() {
    @Override
    public void run() {
        System.out.println("Running a one-time task");
    }
};
task.run();
```

- Lesson 50's `TimerTask` works exactly this way, and so does lesson 54's `Runnable` for threads.  

---

## 🤖 Part 2 – Robot Code: the 2026 Robot (2 pts)

Your code goes in `robot-code/command-based-bot-2026/src/main/java/frc/lesson/lesson49/basic/Lesson49.java` (and `extra/Lesson49.java`). The task list is at the top of each file.  
Run it in the simulator the way you did in [Lesson 00](./LESSON00.md). CAN IDs, inversions and buttons are in [ROBOT.md](../robot-code/command-based-bot-2026/ROBOT.md).

**Basic (1 pt)**: one robot action, in a class with no name  
- Create the operator controller, both rollers (CAN 5, 6) and the conveyor (CAN 29), the way lesson 13 did.  
- In `setup()`, **after** the motors exist, build the intake action as an anonymous `Runnable` and keep it in a field:  

```java
intakeAction = new Runnable() {
    @Override
    public void run() {
        leftRoller.set(-0.7);
        rightRoller.set(0.7);
        conveyor.set(0.8);
    }
};
```

- Build a second one, `ejectAction`, with the eject powers from ROBOT.md (rollers `+0.9`, conveyor `+0.8`).  
- In `execute()`, hold **B** and call `intakeAction.run()`, hold the **left bumper** and call `ejectAction.run()`, otherwise stop all three motors. At home the operator is Keyboard 1, so B is the **6** key and the left bumper is **3**.  
- Put the name of the action you ran on SmartDashboard, and next to it the roller speed you read in lesson 07, `leftRoller.getVelocity().getValueAsDouble()`. Intake should turn the rollers the opposite way from eject, and the sign tells you which.  
- **Nothing runs on its own here.** A `Runnable` is just an object with a `run()` method, and *you* call it, from the robot's own loop. That matters: lesson 50 shows what goes wrong when something else calls it, on its own thread.  

**Extra (1 pt)**: no name, no reuse, and the short way  
- Put `intakeAction.getClass().getName()` on SmartDashboard. Java made up something like `frc.lesson.lesson49.extra.Lesson49$1`, for the same reason it did in the Java half: you never named the class.  
- Hold both actions in a `Runnable[]` and pick one with the operator's buttons, so the array decides what the robot does. Each slot is a different anonymous class, and neither one can be reused anywhere else.  
- Write the same intake action a second way, as a **lambda**, and leave it in a comment:  

```java
// Runnable intakeAction = () -> { leftRoller.set(-0.7); rightRoller.set(0.7); conveyor.set(0.8); };
```

- Same object, four lines shorter. This is the shape every button binding on a command-based robot uses, which is the next thing you'll learn.  

---

## 📜 Part 3 – Code Archaeology (2 pts, optional)

> *Optional: skip this part if you're short on time.* Last season's code is [`Hudson-Robotics/OG-Code-2026`](https://github.com/Hudson-Robotics/OG-Code-2026), branch **`Pre-DCMP-Flywheel`**.

**Basic (1 pt)**: every lambda is an anonymous class  
- In `RobotContainer.java`, find `fuelSubsystem.setDefaultCommand(fuelSubsystem.run(() -> fuelSubsystem.stop()));`.  
- That `() -> fuelSubsystem.stop()` is a `Runnable`, exactly like yours. Rewrite it the long way, as `new Runnable() { ... }`, in a comment. Which one would you rather read at 2 AM at a competition?  
- How did you know it was a `Runnable` and not something else? *(Hint: what does `Subsystem.run(...)` take?)*  

**Extra (1 pt)**: the one that isn't a Runnable  
- Find `new DynamicClimbUp(climberSubsystem, () -> driverController.getRightTriggerAxis())`, and open `DynamicClimbUp.java`. Its second parameter is a `DoubleSupplier`, an interface with one method, `double getAsDouble()`.  
- Rewrite that lambda as an anonymous `DoubleSupplier`. You now have a working example of lesson 37's "you can't build an interface, but you can build an interface *with a body*".  
- Why does the command take a `DoubleSupplier` at all, instead of just a `double`? Hold the trigger halfway and think about what a plain `double` would have captured.  

---

## 🏆 Total Points
- **Max:** 6 pts  
  - Java‑Only: 2 pts  
  - Robot Code: 2 pts  
  - Code Archaeology: 2 pts *(optional)*

---

> 🐝 *"The sting is in the details — master them, and you master the bot."*
