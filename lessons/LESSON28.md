# 🖥️ Lesson 28 – Constructors in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🐝

---

## 🎯 Overview
**Keywords:** Java, Constructors, Initialization, this Keyword, Parameters, Objects  
Learn to:
- Understand what a **Constructor** is and how it differs from regular methods  
- Use Constructors to initialize objects with **unique values**  
- Pass arguments to a Constructor and match them with parameters  
- Apply the `this` keyword to distinguish between attributes and parameters  
- Automatically set default values for certain attributes  
- Use attributes inside methods after initialization  

---

## ⏱️ Progress Tracking

### 📊 For the Marathon Watchers  
If you’re following the **full 12‑hour compilation** and want to see how far you’ve made it through the *entire* course:  
- **Start Time in 12‑Hour Video:** [06:51:38](https://www.youtube.com/watch?v=xTtL8E4LzTQ&t=24698s)  
- **Full Course (12h video):** [Watch Compilation](https://www.youtube.com/watch?v=xTtL8E4LzTQ)

---

### 🎯 For the Quick‑Hit Learners  
If you just want **this lesson only** and to be done with it — no scrubbing through hours of footage:  
- **Lesson Playlist:** [Java tutorial for beginners (2025) ☕](https://www.youtube.com/playlist?list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc)  
- **This Lesson Only:** [Watch Lesson 28](https://www.youtube.com/watch?v=ZD7CB6wKg8A&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=40) (Learn CONSTRUCTORS in 10 minutes! 🔨, 10:08)

---

## 💻 Part 1 – Java‑Only (2 pts)

> New classes go in their own file next to `Main.java`, starting with the same `package` line, like lesson 27: `java-lessons/src/lesson28/basic/Student.java` starts with `package lesson28.basic;`, and the extra folder gets its own copy with `package lesson28.extra;`.

**Basic (1 pt)**  
- Create a `Student` class with attributes:  
  - `String name`  
  - `int age`  
  - `double gpa`  
  - `boolean isEnrolled`  

- Add a **Constructor** that accepts `name`, `age`, and `gpa`.  
- Use the `this` keyword to assign parameters to attributes.  
- Automatically set `isEnrolled = true`.  
- In `main()`, create one student with `new Student("SpongeBob", 30, 3.2)` and print its four attributes.  

```java
public class Student {
    String name;
    int age;
    double gpa;
    boolean isEnrolled;

    // Constructor
    Student(String name, int age, double gpa) {
        this.name = name;
        this.age = age;
        this.gpa = gpa;
        this.isEnrolled = true; // default
    }

    void study() {
        System.out.println(this.name + " is studying");
    }
}
```

**Extra (1 pt)**  
- In `main()`, create three students with unique values.  
- Print their attributes and call the `study()` method.  
- Try `new Student()` with no arguments. Read the error: once a class has a constructor with parameters, every new object has to pass them.  

```java
public static void main(String[] args) {
    Student s1 = new Student("SpongeBob", 30, 3.2);
    Student s2 = new Student("Patrick", 34, 1.5);
    Student s3 = new Student("Sandy", 27, 4.0);

    System.out.println(s1.name + " " + s1.age + " " + s1.gpa + " " + s1.isEnrolled);
    System.out.println(s2.name + " " + s2.age + " " + s2.gpa + " " + s2.isEnrolled);
    System.out.println(s3.name + " " + s3.age + " " + s3.gpa + " " + s3.isEnrolled);

    s1.study();
    s2.study();
    s3.study();
}
```

---

## 🤖 Part 2 – Robot Code: the 2026 Robot (2 pts)

Your code goes in `robot-code/command-based-bot-2026/src/main/java/frc/lesson/lesson28/basic/Lesson28.java` (and `extra/Lesson28.java`). The task list is at the top of each file.  
Run it in the simulator the way you did in [Lesson 00](./LESSON00.md). CAN IDs, inversions and current limits are in [ROBOT.md](../robot-code/command-based-bot-2026/ROBOT.md).

> 🧱 You keep building the same robot. This lesson edits the `Fuel` class you wrote in [Lesson 27](./LESSON27.md) and adds a `Drivetrain` next to it. If you skipped 27, do it first or ask a mentor for the reference copy.

**Basic (1 pt)**: a constructor is where a motor gets set up  

Your `Fuel` works, but every motor on it is running on factory defaults. A real motor has settings — which way it spins, how hard it may pull, what it does when you stop asking — and they only need setting **once**. That is what a constructor is for.

- In `Fuel.java`, take the `= new TalonFX(5)` off the end of each field. Leave just `public TalonFX leftRoller;`.  
- Add `public Fuel() { ... }` and create the three motors inside it. **Run the lesson before you change anything else.** Nothing should look different — that is the point. Same behaviour, new home.  
- Now configure them from [ROBOT.md](../robot-code/command-based-bot-2026/ROBOT.md): rollers get **Coast**, a **100 A** stator limit, left `CounterClockwise_Positive` and right `Clockwise_Positive`; the conveyor gets **Brake** and **80 A**.  

```java
var rollerConfig = new TalonFXConfiguration()
    .withMotorOutput(new MotorOutputConfigs()
        .withNeutralMode(NeutralModeValue.Coast)
        .withInverted(InvertedValue.CounterClockwise_Positive))
    .withCurrentLimits(new CurrentLimitsConfigs()
        .withStatorCurrentLimit(100)
        .withStatorCurrentLimitEnable(true));
leftRoller.getConfigurator().apply(rollerConfig);
```

- In `Lesson28.java`, publish **both** roller speeds this time. Hold **B** (the 6 key) and check they agree — both should settle near **−68 RPS**.  
- 🧪 **The experiment:** change the roller limit from `100` to `10` and run it again. **Predict what happens first.** The rollers still spin, but they top out around **−52 RPS** instead of −68: a current limit is not a speed limit, it just stops the motor pulling hard enough to get there. Put `100` back.  

> 🏠 **Honest note about home vs. the robot.** The inversions you just set change *nothing you can see in the simulator* — it already models the motors as mounted on the real robot, so the rollers read the same before and after. Coast vs. brake and the current limits are real on hardware, and the inversions matter the moment the code runs on the actual robot. Set them right anyway; the next lesson's drivetrain is where an inversion becomes visible.

**Extra (1 pt)**: the drivetrain gets a constructor, and you delete a minus sign  

Back in [Lesson 19](./LESSON19.md) you wrote `setDrive(left, right)`, and it had to flip the sign on the right side by hand because the two sides face opposite directions. A constructor tells the motors that **once**.

- Make `frc/robot/subsystems/Drivetrain.java` with four `TalonFX` fields: **1** and **2** are the leaders, **3** and **4** the followers.  
- Its constructor creates all four, then applies one config per side: **Brake** and a **60 A** limit on both, `Clockwise_Positive` on the right, `CounterClockwise_Positive` on the left.  
- Make the followers follow, so you only ever talk to the leaders:  

```java
leftFollower.setControl(new Follower(1, MotorAlignmentValue.Aligned));
rightFollower.setControl(new Follower(2, MotorAlignmentValue.Aligned));
```

- Add `public void arcade(double forward, double turn)`: left leader gets `forward + turn`, right leader gets `forward - turn`. **No minus sign on the right.** That is what the inversion bought you.  
- Drive it from the sticks, scaled the way the real robot is — forward × 0.7, turn × 0.8 — and publish both sides' rotations.  
- Run it and hold **W**: straight forward, about **5.4 m** in two seconds, heading still **0**.  
- 🧪 **The experiment:** delete the `.withInverted(...)` line from the right side's config and run it again. **Predict it first.** The robot spins in place — the same bug [Lesson 03](./LESSON03.md) warned you about, except now it lives in one line of a constructor instead of in every single drive call.  

---

## 📜 Part 3 – Code Archaeology (2 pts, optional)

Both constructors you just wrote already exist in [`OG-Code-2026`](https://github.com/Hudson-Robotics/OG-Code-2026), branch `Pre-DCMP-Flywheel`: `CANFuelSubsystem()` and `CANDriveSubsystem()`.

**Basic (1 pt)**: two comments that name the wrong side  
- In `CANFuelSubsystem`, above the launcher config, the comment reads *"Right is not inverted; left is inverted so positive values intake and launch on both sides."* Read the four lines under it. `Clockwise_Positive` is applied to **`rightIntakeLauncher`**, and `CounterClockwise_Positive` — which is the **default**, i.e. not inverted — goes to the left. **The comment has the sides backwards.**  
- Now open `CANDriveSubsystem` and find *"Left side is inverted so that positive values drive both sides forward."* Check which motors get which value. It's the same mistake, in the same shape, in a different file.  
- Neither one is a bug: the **code** is right both times, and it matches [ROBOT.md](../robot-code/command-based-bot-2026/ROBOT.md). Only the comments are wrong. So write down the real lesson — what does the compiler check, and what does it not?  

**Extra (1 pt)**: a warning about a motor that isn't there  
- `Constants.java` line 35 explains the 60 A drive limit: *"a reasonable maximum to reduce likelihood of tripping breakers or damaging CIM motors."*  
- **There isn't a single CIM on this robot.** Every drive motor is a TalonFX. That comment was written for a different robot, in a different year, and copied forward.  
- Grep the whole project for `CIM` — one hit. How many years old do you think that line is? Try `git log -p --all -S CIM -- src/main/java/frc/robot/Constants.java`.  
- The 60 A number itself is probably fine. The question worth asking is the one the comment can't answer: **is 60 A right for a Kraken, and who last checked?**  

---

## 🏆 Total Points
- **Max:** 6 pts  
  - Java‑Only: 2 pts  
  - Robot Code: 2 pts  
  - Code Archaeology: 2 pts *(optional)*  

---

<!-- Drafting notes from the transcript draft. Hidden from students.
Ideas:
- Show how Constructors solve the problem of duplicate default values.  
- Robot code: use Constructors for motors, sensors, or subsystems.  
- Archaeology: replace manual initialization with Constructor calls.  
- Segue: Next lesson → **Overloading Constructors** (multiple ways to initialize objects).  
-->
