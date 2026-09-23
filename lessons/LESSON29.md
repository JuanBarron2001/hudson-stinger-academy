# 🖥️ Lesson 29 – Overloaded Constructors in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🐝  

---

## 🎯 Overview
**Keywords:** Java, Constructors, Overloading, Initialization, Default Values, Optional Fields  
Learn to:
- Understand what **overloaded constructors** are  
- Create multiple constructors with different parameter lists  
- Provide **default values** when arguments are missing  
- Initialize objects in flexible ways depending on available data  
- Apply this technique when some fields are optional  

---

## ⏱️ Progress Tracking

### 📊 For the Marathon Watchers  
If you’re following the **full 12‑hour compilation** and want to see how far you’ve made it through the *entire* course:  
- **Start Time in 12‑Hour Video:** [07:01:45](https://www.youtube.com/watch?v=xTtL8E4LzTQ&t=25305s)  
- **Full Course (12h video):** [Watch Compilation](https://www.youtube.com/watch?v=xTtL8E4LzTQ)

---

### 🎯 For the Quick‑Hit Learners  
If you just want **this lesson only** and to be done with it — no scrubbing through hours of footage:  
- **Lesson Playlist:** [Java tutorial for beginners (2025) ☕](https://www.youtube.com/playlist?list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc)  
- **This Lesson Only:** [Watch Lesson 29](https://www.youtube.com/watch?v=iLrY412dFwo&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=41) (Learn OVERLOADED CONSTRUCTORS in 6 minutes! 🛠️, 6:37)

---

## 💻 Part 1 – Java‑Only (2 pts)

> New classes go in their own file next to `Main.java`, starting with the same `package` line, like lesson 27: `User.java` starts with `package lesson29.basic;` in the basic folder, and the extra folder gets its own copy with `package lesson29.extra;`.

**Basic (1 pt)**  
- Create a `User` class with attributes:  
  - `String username`  
  - `String email`  
  - `int age`  

- Add a constructor that accepts only a username and sets default values for the other fields.  
- In `main()`, create `new User("SpongeBob")` and print its username, email and age.  

```java
public class User {
    String username;
    String email;
    int age;

    // Constructor with username only
    User(String username) {
        this.username = username;
        this.email = "Not Provided";
        this.age = 0;
    }
}
```

**Extra (1 pt)**  
- Add more constructors:  
  - One with `username` and `email`  
  - One with `username`, `email`, and `age`  
  - One with **no arguments** (default/guest profile)  
- In `main()`, create one user with each constructor, like the video: `"SpongeBob"`; `"Patrick"` and `"pstar@aol.com"`; `"Sandy"`, `"scheeks@gmail.com"` and `27`; and one with nothing. Print all four. Java picks the constructor whose parameters match what you pass.  

```java
// Constructor with username + email
User(String username, String email) {
    this.username = username;
    this.email = email;
    this.age = 0;
}

// Constructor with username + email + age
User(String username, String email, int age) {
    this.username = username;
    this.email = email;
    this.age = age;
}

// Constructor with no arguments
User() {
    this.username = "Guest";
    this.email = "Not Provided";
    this.age = 0;
}
```

---

## 🤖 Part 2 – Robot Code: the 2026 Robot (2 pts)

Your code goes in `robot-code/command-based-bot-2026/src/main/java/frc/lesson/lesson29/basic/Lesson29.java` (and `extra/Lesson29.java`). The task list is at the top of each file.  
Run it in the simulator the way you did in [Lesson 00](./LESSON00.md). Shot speeds and stick scaling are in [ROBOT.md](../robot-code/command-based-bot-2026/ROBOT.md).

> 🧱 Still the same robot. This lesson adds a `Shot` class and a `shoot()` method to the `Fuel` from [Lesson 27](./LESSON27.md), and gives the `Drivetrain` from [Lesson 28](./LESSON28.md) a second constructor.

**Basic (1 pt)**: three shots, one class, three constructors  

The robot takes three shots — short, medium and far. They differ only in numbers. That is exactly a class with overloaded constructors: one easy way to build the usual one, and other ways to build the ones you have to describe.

- Make `frc/robot/Shot.java` with three fields: `rollerPower`, `targetRps` and `conveyorPower`.  
- Give it **three** constructors, each handing work to the next with `this(...)`:  

```java
public Shot() {
    this(-0.72, -70);                 // the short shot, the one you take most
}

public Shot(double rollerPower, double targetRps) {
    this(rollerPower, targetRps, -0.7);
}

public Shot(double rollerPower, double targetRps, double conveyorPower) {
    this.rollerPower = rollerPower;   // only THIS one assigns anything
    this.targetRps = targetRps;
    this.conveyorPower = conveyorPower;
}
```

- Only the last one assigns the fields. Write it that way **on purpose**: when the default conveyor power changes, it changes in one place instead of three.  
- In `Fuel`, add three things:  
  - `public double rollerRps()` — the left roller's velocity.  
  - `public boolean atSpeed(Shot shot)` — [Lesson 07](./LESSON07.md)'s check, `Math.abs(shot.targetRps - rollerRps()) < 3`.  
  - `public void shoot(Shot shot)` — both rollers to `shot.rollerPower`, and the conveyor held at `-0.05` **until** `atSpeed`, then `shot.conveyorPower`. That is what the real robot does, and it's in ROBOT.md: don't feed a flywheel that hasn't got there yet.  
- Build the three shots in `setup()` and fire them from the operator's **A**, **X** and **Y** (the **5**, **7** and **8** keys). Publish the target, the actual RPS and whether you're at speed.  
- You already know `-0.72` reaches **−70 RPS** — you found it in lesson 07. Find the powers for **−80** and **−90** the same way. Roller RPS is roughly `97 × power` in the simulator, so start near `-0.82` and `-0.93`. Those land at **−79.6** and **−90.2**, both inside your ±3 tolerance, and the conveyor kicks in a moment after each button.  

**Read your two lines out loud.** `new Shot()` says *the usual shot*. `new Shot(-0.93, -90, -0.9)` says *this specific one*. Either way you never wrote three loose `double`s sitting next to each other where two could quietly get swapped.

**Extra (1 pt)**: a rookie driver's drivetrain  

- Add `public double forwardScale;` and `public double turnScale;` to `Drivetrain`.  
- Give it two constructors. `Drivetrain()` becomes a single line, `this(0.7, 0.8)` — the robot's own numbers from ROBOT.md. Everything you wrote in lesson 28 (motors, configs, followers) moves into `Drivetrain(double forwardScale, double turnScale)`.  
- Move the scaling **into** `arcade()`, so the lesson hands it raw stick values: `leftLeader.set(forward * forwardScale + turn * turnScale);`.  
- Publish both scales, so your log says which drivetrain you built.  
- Run it with `new Drivetrain()` and hold **W** for two seconds: about **5.4 m**.  
- 🧪 Change it to `new Drivetrain(0.4, 0.5)` and do it again. **Predict the distance first.** You should get about **3.3 m**, and the turning feels much lazier.  

> 🤔 **Why not build one of each and switch with a button?** Because you already found out what happens: [Lesson 27](./LESSON27.md)'s two `Fuel` objects fought over the same rollers and nothing moved. One robot, one drivetrain. You choose how it's built at the moment you build it — which is all a constructor is.

---

## 📜 Part 3 – Code Archaeology (2 pts, optional)

**Basic (1 pt)**: the same trick, in last season's code  
- Open `src/main/java/frc/robot/commands/FlywheelLaunchSequence.java` in [`OG-Code-2026`](https://github.com/Hudson-Robotics/OG-Code-2026), branch `Pre-DCMP-Flywheel`. It has **two** constructors, and the short one is one line: `this(fuelSubsystem, FuelConstants.DEFAULT_LAUNCH_RPS);`.  
- That's the pattern you just wrote, by a team that had never met you. Find every place it's used, in `RobotContainer.java`:  
  - `operatorController.a()`, `.x()` and `.y()` each pass an explicit RPS — `SHORT_RANGE_RPS`, `MEDIUM_RANGE_RPS`, `FAR_RANGE_RPS`.  
  - `NamedCommands.registerCommand("Shoot", new FlywheelLaunchSequence(fuelSubsystem))` uses the **no-argument** one.  
- So which shot does the autonomous path take? Trace `DEFAULT_LAUNCH_RPS` in `Constants.java` and find out. Is that the shot you'd want during auto, from wherever the path leaves the robot?  

**Extra (1 pt)**: you already wrote `execute()`  
- Read `FlywheelLaunchSequence.execute()`. It commands the flywheel, then: *if at speed, run the feeder; otherwise hold it still.* That is your `shoot()` method, line for line, with `isAtTargetVelocity()` where you wrote `atSpeed()`. You arrived at the same shape they did, from the same problem.  
- The one real difference: they ask for a **velocity** (closed loop, using gains `kS`, `kV` and `kP`) where you ask for a **power** you hunted for by hand. You don't need the gains yet — answer the cheaper question: **what does closed loop buy you that `-0.72` doesn't?** Think about a low battery, or a robot that just took a hit.  
- Now go looking for the risk. `FlywheelLaunchSequence` takes its number from `Constants`, but three other commands — `SpinUp.java`, `Launch.java` and `FlywheelTuningCommand.java` — call `SmartDashboard.getNumber(...)` instead. What happens at a match if somebody typed a number into the dashboard during practice and never put it back?  

---

## 🏆 Total Points
- **Max:** 6 pts  
  - Java‑Only: 2 pts  
  - Robot Code: 2 pts  
  - Code Archaeology: 2 pts *(optional)*  

---

<!-- Drafting notes from the transcript draft. Hidden from students.
Ideas:  
- Show similarity between overloaded methods and overloaded constructors.  
- Robot code: sensors or motors initialized in multiple ways.  
- Archaeology: replace repetitive initialization with constructor overloading.  
- Segue: Next lesson → **toString() method** for printing object details.  
-->
