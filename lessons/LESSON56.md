# 🖥️ Lesson 56 – Lambdas & Method References

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ ➡️  

---

## 🎯 Overview
**Keywords:** Java, Lambdas, Method References, Functional Interfaces, `Runnable`, `DoubleSupplier`, `Trigger`  
Learn to:
- Write an anonymous class from [Lesson 49](./LESSON49.md) the short way, as a **lambda**: `() -> ...`  
- Recognise a **functional interface**, an interface with exactly one method to fill in, which is the only thing a lambda can be  
- Shorten a lambda that only calls one method into a **method reference**: `::`  
- Pay off five lessons' worth of *"copy this for now"* and bind buttons to commands the way real robot code does  

> 🧾 **This lesson owes you some explanations.** Lessons [32](./LESSON32.md), [34](./LESSON34.md), [37](./LESSON37.md), [44](./LESSON44.md) and [49](./LESSON49.md) each had you copy a `::`, an `->`, or a work-around for not having them yet, on a promise that a later lesson would explain it. This is that lesson.

---

## ⏱️ Progress Tracking

**There is no video for this one.** Lessons 01–55 each follow one video from the playlist, and the playlist has no lambdas video. So this lesson was written for the academy, and everything you need is on this page. If you want a video anyway, search *"Java lambda expressions"*; any 10-minute one covers the Basic half.

---

## 💻 Part 1 – Java‑Only (2 pts)

> New interfaces go in their own file next to `Main.java`, starting with the same `package` line, like lesson 27 (`package lesson56.basic;`).

### 📖 How to read a lambda

In [Lesson 49](./LESSON49.md) you wrote this to make one `Runnable`:

```java
new Runnable() {
    @Override
    public void run() {
        System.out.println("hi");
    }
}
```

Most of that is words the compiler could have worked out on its own. Java already knows the variable is a `Runnable`, and a `Runnable` has exactly one method, so there is only one method you could possibly be writing. A **lambda** keeps just the part that says something, which is the parameters and the body, joined by an arrow:

```java
() -> System.out.println("hi")
```

| You write | It means |
|---|---|
| `() -> expression` | no parameters, and the answer is `expression` |
| `x -> expression` | one parameter, named `x` (no brackets needed for exactly one) |
| `(a, b) -> expression` | two parameters |
| `x -> { statements; return something; }` | a body longer than one expression gets braces, semicolons and a `return`, like a normal method |

**The rule that makes all of it work:** a lambda can only become an interface with **exactly one** method to fill in. That kind of interface is called a **functional interface**. `Runnable` is one. So is `DoubleSupplier` from [Lesson 37](./LESSON37.md), and so is a `Comparator`.

**Basic (1 pt)**: the anonymous class, shortened  

- Write lesson 49's anonymous `Runnable` that prints `Running a one-time task` again, in `main()`. Then write a **second** `Runnable` that prints the same thing, as a lambda. Run both.  
- Make your own functional interface, `Greeting.java`, with one method:  

```java
String greet(String name);
```

- Make two `Greeting` lambdas: `polite`, which puts `"Hello, "` in front of the name, and `scooby`, which puts `"Ruh-roh, "` in front and `"!"` after. Call both with `"Shaggy"`.  
- Make a third, `loud`, whose body needs **two** statements: upper-case the name into a variable first, then return `"HEY "` + that + a local variable `punctuation` you set to `"!!!"` just above the lambda. Call it with `"Velma"`.  
- Print the class name of your lambda `Runnable`, `getClass().getName()`, the way lesson 49 printed `Main$1`.  

Expected output (the last line will have a different number on your machine):  

```
Running a one-time task
Running a one-time task
Hello, Shaggy
Ruh-roh, Shaggy!
HEY VELMA!!!
lesson56.basic.Main$$Lambda$1/0x000074f188000c30
```

- 🧪 **Two experiments. Predict each one before you build.**  
  1. Put `@FunctionalInterface` on the line above `public interface Greeting`, then add a second method, `String wave();`. The compiler now refuses: `Greeting is not a functional interface`. Which of your three lambdas would Java even have attached that second method to? Delete `wave()`, and keep the annotation: it's a note to the next person that this interface is meant for lambdas.  
  2. Right after the lambda that uses `punctuation`, add `punctuation = "?";`. The error is `local variables referenced from a lambda expression must be final or effectively final`. A lambda can **read** a nearby local variable, but only one that never changes. Undo it.  

**Extra (1 pt)**: method references, and a number that's fresh every time  

A lambda that does nothing but call one existing method can get shorter still. `name -> System.out.println(name)` just hands its parameter straight to `println`, so you can name the method instead, with `::`:

```java
System.out::println      // "the println method of System.out"
```

That's a **method reference**. Read `::` as *"the method called ... belonging to ..."*. It is the same object the lambda would have made, only shorter to write.

- Make an `ArrayList<String>` of `Scooby`, `Fred`, `Daphne`, `Velma` and `Shaggy`, in that order.  
- Print every name with `forEach`, which takes a lambda to run once per item. Then print them all again with `forEach` and `System.out::println`.  
- Sort the list shortest name first with `Comparator.comparingInt(...)`, handing it a lambda that turns a name into its length. Print the list. Then sort it **longest** first, using the method reference `String::length` and `.reversed()`. Print it again.  
- 🧪 Names with the same length (`Scooby`, `Daphne`, `Shaggy`) stay in the order they were already in. **Predict both lists before you run.**  
- Now the one that matters on a robot. Make a `double once = Math.random();` and a `DoubleSupplier everyTime = Math::random;`. In a loop that runs three times, print `once` and `everyTime.getAsDouble()` side by side.  

Expected output (your random numbers will differ, **but the left column must be the same number three times**):  

```
Scooby
Fred
Daphne
Velma
Shaggy
Scooby
Fred
Daphne
Velma
Shaggy
[Fred, Velma, Scooby, Daphne, Shaggy]
[Scooby, Daphne, Shaggy, Velma, Fred]
0.5737847816249689  vs  0.9886306258355839
0.5737847816249689  vs  0.5241595950688832
0.5737847816249689  vs  0.8131731171463132
```

> 🎯 **`once` was worked out one time and saved. `everyTime` is a way to work it out, saved, and it runs again every time you ask.** That's the whole reason [Lesson 37](./LESSON37.md)'s climb command took a `DoubleSupplier` instead of a `double`. A `double` would have stored the trigger position at the moment the command was built, and it would never have changed after that.

---

## 🤖 Part 2 – Robot Code: the 2026 Robot (2 pts)

Your code goes in `robot-code/command-based-bot-2026/src/main/java/frc/lesson/lesson56/basic/Lesson56.java` (and `extra/Lesson56.java`). The task list is at the top of each file.  
Run it in the simulator the way you did in [Lesson 00](./LESSON00.md). Buttons are in [ROBOT.md](../robot-code/command-based-bot-2026/ROBOT.md).

**Basic (1 pt)**: `TriggerAxis`, in one line  

In [Lesson 37](./LESSON37.md) you wrote `TriggerAxis`: a whole file with a field, a constructor and an `@Override`, all to hand `DynamicClimb` one expression, `controller.getRightTriggerAxis()`. `DoubleSupplier` has exactly one method, so it's a functional interface, which means a lambda can take `TriggerAxis`'s place.

- Build your climber and a `DynamicClimb` the way lesson 37 did, except with a lambda where `new TriggerAxis(driver)` used to be:  

```java
new DynamicClimb(climber, () -> driver.getRightTriggerAxis())
```

- **Change nothing else.** Not `DynamicClimb`, not `Climber`. Schedule it while the right trigger is past `0.1`, the way lesson 37 did (the **E** key at home).  
- Run it and hold the trigger at a quarter, then half, then all the way, the same way you did in lesson 37. **Predict first:** should the numbers come out different?  
- They don't. In the simulator, holding each for 1.2 s from zero measured **29.6, 58.2 and 116.6 rotations** with the lambda, and **29.6, 58.2 and 116.5** with lesson 37's `TriggerAxis`. `DynamicClimb` asked for "something that can give me a double" and can't tell which one it got.  
- Publish the class name of your lambda, the way the Java half did. Java made up something like `Lesson56$$Lambda...`: it wrote `TriggerAxis` for you, with no name, the same way lesson 49's anonymous class became `Lesson49$1`.  
- **Don't delete `TriggerAxis.java`.** Your `Lesson37.java` still uses it, and deleting a class that another file uses breaks the whole build, not just that one lesson. From now on, just don't write any new ones.  

**Extra (1 pt)**: `::`, and buttons that bind themselves  

- **The `::` from [Lesson 32](./LESSON32.md), explained at last.** Your `Drivetrain` has `new DifferentialDrive(leftLeader::set, rightLeader::set)`. `DifferentialDrive` asks for two things that can *take* a `double`, and `leftLeader::set` means *"the `set` method of `leftLeader`"*. Write the same thing the long way, as a lambda in a comment, so you can see the two match:  

```java
// new DifferentialDrive(speed -> leftLeader.set(speed), speed -> rightLeader.set(speed));
```

- 🧪 **Where `::` stops working.** In the lesson, try `Runnable stopFuel = fuel::stop;` and it builds. Now try `Runnable intakeNow = fuel::follow;` and **predict the error first**. `follow` needs a `BallPath` ([Lesson 53](./LESSON53.md)), and a `Runnable` has nothing to give it: `invalid method reference ... required: BallPath, found: no arguments`. When the method needs an argument you have to supply yourself, you need a lambda: `() -> fuel.follow(BallPath.INTAKE)`.  
- **Now the reason all of this exists.** Since [Lesson 34](./LESSON34.md) you've been starting and stopping commands by hand, every loop:  

```java
if (operator.getBButton() && !intake.isScheduled()) { intake.schedule(); }
if (!operator.getBButton() && intake.isScheduled()) { intake.cancel(); }
```

- WPILib's `Trigger` does that for you, and it takes a `BooleanSupplier`: "something that can give me a `boolean`, whenever I ask". In your `RobotContainer`'s **constructor**, not `update()`, add:  

```java
new Trigger(operator::getBButton).whileTrue(new Intake(fuel));
```

- **Delete the two `if` lines above from `update()`.** Do the same for the climber: `new Trigger(() -> driver.getRightTriggerAxis() > 0.1)` and `.whileTrue(...)` your `DynamicClimb`. That one needs a lambda, not `::`: why?  
- Run it. Hold **B** (the **6** key) and let go. Measured: `Intake/State` goes `started`, the rollers reach **−67.9 RPS**, and on release it goes `interrupted` and the rollers drop to **0.0**. That's the same log as lesson 34, with no `isScheduled()` anywhere in your code.  
- 🤔 **What must `whileTrue` be doing inside?** You have all the pieces to guess right: it keeps your `BooleanSupplier`, asks it for a `boolean` every loop, and does what your two `if` lines did. Write your guess down, then find the loop that asks. It's `CommandScheduler.getInstance().run()`, which the host has been calling every loop since lesson 32.  

> ✅ **Why the binding goes in the constructor:** a `Trigger` is built once and then watches the button forever. Build it in `update()` and you'd get a new one fifty times a second, each one starting its own `Intake`.

> 🎮 **The shortcut the competition code uses:** WPILib's `CommandXboxController` builds these `Trigger`s for you, so `new Trigger(operator::getBButton)` becomes `operator.b()`. You'll see it in the archaeology below. You're welcome to switch to it, now that you know what it's hiding.

> ⚖️ **When is a named class better than a lambda?** When you'd write the same lambda in three places, when it needs a name to explain what it's for, or when you want to put a breakpoint inside it and find it again. `Intake` is a class for all three reasons. `() -> driver.getRightTriggerAxis()` is a lambda because it has none of them.

---

## 📜 Part 3 – Code Archaeology (2 pts, optional)

Last season's code is [`OG-Code-2026`](https://github.com/Hudson-Robotics/OG-Code-2026), branch `Pre-DCMP-Flywheel`. Lesson 49's archaeology already had you rewrite two of its lambdas the long way; this one reads the rest.

**Basic (1 pt)**: four arguments that are all code  
- Open `CANDriveSubsystem.java` and find `configureAutoBuilder()`. The call to `AutoBuilder.configure(...)` hands PathPlanner **five** pieces of code in a row:  

```java
this::getPose,
this::resetPose,
this::getRobotRelativeSpeeds,
(speeds, feedforwards) -> driveRobotRelative(speeds),
...
() -> { var alliance = DriverStation.getAlliance(); ... },
```

- PathPlanner asks for these types, in this order: `Supplier<Pose2d>`, `Consumer<Pose2d>`, `Supplier<ChassisSpeeds>`, `BiConsumer<ChassisSpeeds, DriveFeedforwards>`, and later a `BooleanSupplier`. A `Supplier` **gives** something, a `Consumer` **takes** something, and a `BiConsumer` takes two. Match each argument to its type, and check each one against the method it names in the same file. Does `getPose` take anything? Does `resetPose` give anything back?  
- The fourth one is a lambda, not a `this::`. Why? Look at what it does with `feedforwards`.  
- Here's something the code didn't use: PathPlanner **also** accepts a plain `Consumer<ChassisSpeeds>` in that slot, so `this::driveRobotRelative` compiles there too (checked against PathPlannerLib 2026.1.2). Which version would you rather read, and which says more clearly that the feedforwards are ignored on purpose?  
- The last one is a lambda with a whole block for a body, the alliance check you read in [Lesson 53](./LESSON53.md). Rewrite it, in a comment, as a named method `private boolean isRedAlliance()`, and the argument as `this::isRedAlliance`. That's the "when is a named class better" question again, with a method this time.  

**Extra (1 pt)**: bindings, counted, and a constructor as an argument  
- Open `RobotContainer.java` and count the `.whileTrue(` bindings in `configureBindings()`. Each one would have been two `if` lines and a field in lesson 34's style. Work out how many lines that would have been.  
- Find `driveSubsystem.setDefaultCommand(new Drive(driveSubsystem, driverController))` and `fuelSubsystem.setDefaultCommand(fuelSubsystem.run(() -> fuelSubsystem.stop()))`. One is a whole command class and one is a lambda. Decide which one you'd turn into the other, if either, and why.  
- Open `Main.java`: `RobotBase.startRobot(Robot::new);`. That's a **constructor reference**, `::new`, *"the `Robot` constructor"*. `startRobot` asks for a `Supplier`, and gets back something that makes a `Robot` whenever it's called. Why would WPILib want a way to *build* your robot instead of a robot you already built? *(Hint: what has to be set up before a single motor can be created?)*  

---

## 🏆 Total Points
- **Max:** 6 pts  
  - Java‑Only: 2 pts  
  - Robot Code: 2 pts  
  - Code Archaeology: 2 pts *(optional)*  
