# 🖥️ Lesson 53 – Enums in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 📅  

---

## 🎯 Overview
**Keywords:** Java, Enums, Enumerations, Constants, Switch Statements  
Learn to:
- Understand that **enums** are special classes that represent a fixed set of constants  
- Improve code readability and maintainability by replacing “magic numbers” or strings with named constants  
- Associate values with enum constants using constructors and fields  
- Use enums in **switch statements** (more efficient than strings)  
- Handle user input with enums and catch invalid values  

---

## ⏱️ Progress Tracking

### 📊 For the Marathon Watchers  
If you’re following the **full 12‑hour compilation** and want to see how far you’ve made it through the *entire* course:  
- **Start Time in 12‑Hour Video:** [11:02:38](https://www.youtube.com/watch?v=xTtL8E4LzTQ&t=39758s)  
- **Full Course (12h video):** [Watch Compilation](https://www.youtube.com/watch?v=xTtL8E4LzTQ)

---

### 🎯 For the Quick‑Hit Learners  
If you just want **this lesson only** and to be done with it — no scrubbing through hours of footage:  
- **Lesson Playlist:** [Java tutorial for beginners (2025) ☕](https://www.youtube.com/playlist?list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc)  
- **This Lesson Only:** [Watch Lesson 53](https://www.youtube.com/watch?v=BIOxWAfaAgw&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=68) (Learn Java enums in 10 minutes! 📅, 10:10)

---

## 💻 Part 1 – Java‑Only (2 pts)

> An enum is a special kind of class, so `Day` gets its own file next to `Main.java`, `Day.java`, starting with the same `package` line, like lesson 27 (`package lesson53.basic;`, and `package lesson53.extra;` for the extra's copy).

**Basic (1 pt)**  
- Create an enum for days of the week:  

```java
public enum Day {
    SUNDAY(1),
    MONDAY(2),
    TUESDAY(3),
    WEDNESDAY(4),
    THURSDAY(5),
    FRIDAY(6),
    SATURDAY(7);

    private final int dayNumber;

    Day(int dayNumber) {
        this.dayNumber = dayNumber;
    }

    public int getDayNumber() {
        return dayNumber;
    }
}
```

- Usage in `main`:  

```java
Day day = Day.SUNDAY;
System.out.println(day);              // SUNDAY
System.out.println(day.getDayNumber());// 1
```

**Extra (1 pt)**  
- Use enums in a switch statement:  

```java
Day today = Day.WEDNESDAY;

switch (today) {
    case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> 
        System.out.println("It is a weekday");
    case SATURDAY, SUNDAY -> 
        System.out.println("It is the weekend");
}
```

- Enums are faster than comparing strings in switches and more readable than using integers.  
- **Let the user pick the day**, like the end of the video:  
  - Read a line with a `Scanner` and turn it into a `Day` with `Day.valueOf(response.toUpperCase())`. The constants are all caps, so `monday` has to become `MONDAY`.  
  - Type `Pizza day` and read the exception. Wrap the `valueOf` and the `switch` in a `try`, and `catch (IllegalArgumentException e)` to print `"Please enter a valid day"`.  
  - Then make pizza day real: add `PIZZA_DAY(8)` to the enum and put it in the weekend case. Typing `pizza_day` works now.  

---

## 🤖 Part 2 – Robot Code: the 2026 Robot (2 pts)

Your code goes in `robot-code/command-based-bot-2026/src/main/java/frc/lesson/lesson53/basic/Lesson53.java` (and `extra/Lesson53.java`). The task list is at the top of each file.  
Run it in the simulator the way you did in [Lesson 00](./LESSON00.md). The ball paths table is in [ROBOT.md](../robot-code/command-based-bot-2026/ROBOT.md).

> 🏁 **This is the last core robot half of the offseason.** Everything after it is [the lambdas lesson](./LESSON56.md) and the capstone.

**Basic (1 pt)**: the four ball paths, named at last  

Back in [Lesson 13](./LESSON13.md) you learned the 2026 robot can do exactly **four** things with a ball, and each is a pair of numbers. Since then those numbers have been scattered across if-chains, `Constants`, and command classes.

Four. Fixed. Known at compile time. Each carrying data. **That is an enum.**

```java
public enum BallPath {
    INTAKE(-0.7, 0.8),
    EJECT(0.9, 0.8),
    SHOOT(-0.72, -0.7),
    SHUTTLE(-0.93, -0.7);

    private final double rollerPower;
    private final double conveyorPower;

    BallPath(double rollerPower, double conveyorPower) { ... }

    public double getRollerPower() { return rollerPower; }
    public double getConveyorPower() { return conveyorPower; }
}
```

Same shape as `Day` in Part 1 — constructor, private fields, getters — except the data is two doubles instead of a day number.

- Replace `Fuel`'s separate `intake()` / `eject()` / `shoot()` methods with **one**:  

```java
public void follow(BallPath path) {
    leftRoller.set(path.getRollerPower());
    rightRoller.set(path.getRollerPower());
    conveyor.set(path.getConveyorPower());
}
```

Four behaviours, one method, because the enum carries the difference.

- Pick a path from the operator's buttons — **B** intake, **left bumper** eject, **A** shoot, **right bumper** shuttle (the **6**, **3**, **5** and **4** keys). Publish `path.toString()`.  
- Publish `BallPath.values()` too — every constant, in order, for free: `[INTAKE, EJECT, SHOOT, SHUTTLE]` — and `path.ordinal()`. **You wrote neither method.**  
- Run all four:  

| Path | Rollers | Conveyor |
|---|---|---|
| `INTAKE` | −67.9 RPS | +77.6 RPS |
| `EJECT` | +87.3 RPS | +77.6 RPS |
| `SHOOT` | −69.9 RPS | −67.9 RPS |
| `SHUTTLE` | −90.2 RPS | −67.9 RPS |

> ✅ **What an enum gives you that a `String` couldn't:** `BallPath.SHOOT` is checked by the compiler. Misspell it and the build fails **on your laptop**. In [Lesson 52](./LESSON52.md) you typed `"Intkae"` into a map and the robot silently did nothing — the same mistake, caught months apart.

> 👀 **You have been using enums since [Lesson 28](./LESSON28.md).** `NeutralModeValue.Brake` and `InvertedValue.Clockwise_Positive` are both enum constants. Go and look at one now that you know what you're seeing.

**Extra (1 pt)**: `switch` on it, then type pizza at it  

- Switch on the path to say where the ball actually **goes**. The numbers live in the enum; the meaning doesn't:  

```java
String destination = switch (path) {
    case INTAKE -> "into the hopper";
    case EJECT -> "back out the front";
    case SHOOT, SHUTTLE -> "up and out of the launcher";
};
```

- 🧪 You wrote no `default`. **Delete one of those three lines and build. Predict the error first.** That message is the enum and the compiler between them guaranteeing you handled every case — something no `String` switch can ever do for you.  
- Now let a human pick, the way Part 1 used a `Scanner`. Read a `Paths/Wanted` string off the dashboard: `BallPath.valueOf(typed.toUpperCase())`. The constants are all caps, so `shuttle` has to become `SHUTTLE` — the same rule as `monday`/`MONDAY`.  
- 🧪 Type `PIZZA_PATH` into it. **Predict what happens.** It throws `IllegalArgumentException`, exactly like *"Pizza day"* did. Catch it ([Lesson 45](./LESSON45.md)) and publish something a person can read instead of letting the lesson die.  
- Run all three. `SHOOT` and `shuttle` work; `PIZZA_PATH` gives `no such ball path: PIZZA_PATH` and the fuel mechanism stays still.  

> ⚖️ **Now compare this with lesson 52.** Both let a human name a behaviour. The map's `get()` handed back `null` and the robot did **nothing at all**. The enum's `valueOf()` **threw**, loudly, with the bad name in the message. Which would you rather debug at a competition? Then write down when a `Map` is still the right answer anyway — hint: PathPlanner's step names aren't known when you compile, and an enum's constants must be.

> 📌 **Where `Alliance` finally gets explained.** [Lesson 12](./LESSON12.md) had you copy `DriverStation.getAlliance().orElse(Alliance.Blue) == Alliance.Red` without explaining it, and for a while it pointed at lesson 43 — which is wrapper classes and never mentions `Optional`. **This** is the right lesson for it: `Alliance.Red` and `Alliance.Blue` are enum constants like any other. The `.orElse` part stays copied as-is, because the Java course doesn't teach `Optional` anywhere — worth knowing rather than pretending otherwise.

---

## 📜 Part 3 – Code Archaeology (2 pts, optional)

Last season's code is [`OG-Code-2026`](https://github.com/Hudson-Robotics/OG-Code-2026), branch `Pre-DCMP-Flywheel`.

**Basic (1 pt)**: the enum that isn't there  
- `CANFuelSubsystem` does the same four things your `BallPath` does. Go and find them: `INTAKE_ROLLER_PERCENT`, `INTAKE_FEEDER_PERCENT`, `EJECT_ROLLER_PERCENT`, `EJECT_FEEDER_PERCENT`, `SHUTTLE_FEEDER_PERCENT` and friends, in `Constants.java`.  
- They are **loose doubles in a flat list**, and the pairing between a roller value and its feeder value exists only in the reader's head. Nothing stops somebody using `INTAKE_ROLLER_PERCENT` with `EJECT_FEEDER_PERCENT`.  
- Count how many separate constants your one enum replaced. Then find the ones sitting under that `// Legacy / unused` label from [Lesson 31](./LESSON31.md) and work out which ball path each belonged to.  
- **Write the argument you'd make in a code review** for turning those into an enum — and the strongest argument against, which is real: somebody tuning at an event wants to change one number in one obvious place, fast, with cold hands.  

**Extra (1 pt)**: the enums they did use  
- Enums are all over that code, just not the team's own. Find `NeutralModeValue`, `InvertedValue`, `MotorAlignmentValue` and `DriverStation.Alliance` being used.  
- `RobotContainer`'s PathPlanner setup has this:  

```java
var alliance = DriverStation.getAlliance();
if (alliance.isPresent()) {
    return alliance.get() == DriverStation.Alliance.Red;
}
return false;
```

- Two questions worth real thought. **Why is the alliance allowed to be missing at all** — what is the robot's situation when `isPresent()` is false? And **what does this code do in that situation**, given it returns `false`, which also means *"blue"*?  
- The answer is a genuine design decision about what a robot should assume when it doesn't know which side it's on. Decide whether you agree with the one they made.  

---

## 🏆 Total Points
- **Max:** 6 pts  
  - Java‑Only: 2 pts  
  - Robot Code: 2 pts  
  - Code Archaeology: 2 pts *(optional)*  

---

<!-- Drafting notes from the transcript draft. Hidden from students.
Ideas:  
- Emphasize enums = fixed set of constants, more readable than numbers/strings.  
- Robot code: use enums for modes, states, priorities.  
- Archaeology: replace string/int states with enums for safety and clarity.  
- Segue: Next lesson → **Interfaces** (contracts for classes to implement).  
-->
