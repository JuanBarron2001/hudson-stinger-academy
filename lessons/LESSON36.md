# 🖥️ Lesson 36 – Abstraction in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🐝  

---

## 🎯 Overview
**Keywords:** Java, Abstraction, Abstract Class, Abstract Method, Concrete Method, Inheritance  
Learn to:
- Understand **abstraction**: hiding implementation details and exposing only essential features  
- Use the `abstract` keyword to create abstract classes and methods  
- Recognize that abstract classes **cannot be instantiated** directly  
- Force child classes to implement abstract methods for consistency  
- Inherit **concrete methods** from abstract classes without redefining them  

---

## ⏱️ Progress Tracking

### 📊 For the Marathon Watchers  
If you’re following the **full 12‑hour compilation** and want to see how far you’ve made it through the *entire* course:  
- **Start Time in 12‑Hour Video:** [07:51:58](https://www.youtube.com/watch?v=xTtL8E4LzTQ&t=28318s)  
- **Full Course (12h video):** [Watch Compilation](https://www.youtube.com/watch?v=xTtL8E4LzTQ)

---

### 🎯 For the Quick‑Hit Learners  
If you just want **this lesson only** and to be done with it — no scrubbing through hours of footage:  
- **Lesson Playlist:** [Java tutorial for beginners (2025) ☕](https://www.youtube.com/playlist?list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc)  
- **This Lesson Only:** [Watch Lesson 36](https://www.youtube.com/watch?v=4B8XKEORJss&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=48) (Learn Java abstraction in 9 minutes! 🌫️, 9:34)

---

## 💻 Part 1 – Java‑Only (2 pts)

> Each class gets its own file next to `Main.java`, starting with the same `package` line, like lesson 27 (`package lesson36.basic;`, and `package lesson36.extra;` for the extra's copies).

**Basic (1 pt)**  
- Create an abstract parent class `Shape` with:  
  - Abstract method: `double area()`  
  - Concrete method: `void display()`  

```java
public abstract class Shape {
    // Abstract method (must be implemented by children)
    abstract double area();

    // Concrete method (inherited by children)
    void display() {
        System.out.println("This is a shape");
    }
}
```

- Create child classes `Circle`, `Triangle`, and `Rectangle` that extend `Shape`.  
- Each child **must** have an `area()` method, or Java won't compile it: that's what `abstract` enforces. For now, give each one `@Override double area() { return 0; }`. The extra fills them in.  
- In `main()`, try `new Shape()` and read the error, then delete it. `Shape` is too general to build.  
- Create one `Circle`, one `Triangle` and one `Rectangle`, and call `display()` on each. They inherited it from `Shape` without writing it.  

**Extra (1 pt)**  
- Implement the `area()` method in each child:  

```java
public class Circle extends Shape {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }
}

public class Triangle extends Shape {
    double base, height;

    Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    double area() {
        return 0.5 * base * height;
    }
}

public class Rectangle extends Shape {
    double length, width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double area() {
        return length * width;
    }
}
```

- Demonstrate usage:  

```java
Shape circle = new Circle(3);
Shape triangle = new Triangle(4, 5);
Shape rectangle = new Rectangle(6, 7);

System.out.println(circle.area());    // 28.27...
System.out.println(triangle.area());  // 10.0
System.out.println(rectangle.area()); // 42.0
```

---

## 🤖 Part 2 – Robot Code: the 2026 Robot (2 pts)

Your code goes in `robot-code/command-based-bot-2026/src/main/java/frc/lesson/lesson36/basic/Lesson36.java` (and `extra/Lesson36.java`). The task list is at the top of each file.  
Run it in the simulator the way you did in [Lesson 00](./LESSON00.md). The ball paths are in [ROBOT.md](../robot-code/command-based-bot-2026/ROBOT.md).

**Basic (1 pt)**: the thing you have been doing since lesson 01  

Open `frc/lesson/LessonBase.java` and find this line:

```java
public abstract void execute();
```

No body. No code. Just a promise that every lesson **has** one. That is why the very first thing you ever wrote on this robot was an `@Override execute()` — `LessonBase` could not run without it, and it refused to be a lesson on its own.

`Command` works the same way. So does `SubsystemBase`. You have been standing on abstract classes for thirty-five lessons. Now build one.

**The problem it solves:** your `Intake` command is about 25 lines. An `Eject` command is the same 25 lines with two numbers changed. Write both and you own two copies of a lifecycle that have to stay in step forever.

- Make `frc/robot/commands/FuelAction.java` — `public abstract class FuelAction extends Command`. It holds everything intake and eject agree on: the constructor that takes `Fuel` and calls `addRequirements(fuel)`, plus all four lifecycle methods.  
- And it holds two methods with **no body** — the part each action has to answer for itself:  

```java
protected abstract double rollerPower();
protected abstract double conveyorPower();

@Override
public void execute() {
    fuel.setRollers(rollerPower());     // the parent calls the child's answer
    fuel.setConveyor(conveyorPower());
}
```

- Add `setRollers(double)` and `setConveyor(double)` to `Fuel` if they aren't there yet.  
- Rewrite `Intake` as `public class Intake extends FuelAction`. The constructor calls `super(fuel)`, then it answers the two questions: `-0.7` and `0.8`. **That is the whole file.**  
- Write `Eject` the same way: `0.9` and `0.8`.  
- **B** runs intake, **left bumper** runs eject (the **6** and **3** keys). Intake reads about **−68 RPS**, eject about **+87**.  

> 🏷️ **Notice:** `Action/Running` says `Intake` or `Eject`, and you never typed either word as a String. `getName()` came from `Command`, and it knows which subclass it is sitting inside.

> ❓ **Why `abstract` and not just a normal parent?** Because `new FuelAction(fuel)` is meaningless — there is no such thing as a generic fuel action, it would have no numbers. Marking the class `abstract` makes the compiler agree with you. The extra half makes you prove it.

**Extra (1 pt)**: collect on it  

An abstraction is only worth something if the **next** one is cheap. So add a third action and count the lines.

- Make `frc/robot/commands/Shuttle.java` — the long pass across the field: rollers `-0.93`, conveyor `-0.7`. **Write it before reading the next line.**  
- It should be a constructor calling `super(fuel)` and two one-line methods. About **five lines** of actual code. Last season's equivalent file is **57**.  
- **B** intakes, **left bumper** ejects, **right bumper** shuttles (**6**, **3**, **4**). Run all three and write down the speeds. They should be clearly different: about **−68/+78**, then **+87/+78**, then **−90/−68**.  
- 🧪 **The experiment.** Add this to `setup()` and build:  

```java
FuelAction whatever = new FuelAction(fuel);
```

**Predict what happens.** Then read the error — it is one of the clearest messages Java ever produces.

- 🧪 **Then the other direction.** In `FuelAction`, delete the word `abstract` from `rollerPower()` so it reads `protected double rollerPower();` and build. Then instead give it a body, `{ return 0; }`, and build again. Three outcomes, and each one tells you something different about what `abstract` is actually for.  

> 💡 **What `abstract` means, in one sentence:** this class is half a class, and the compiler will not let anyone pretend otherwise.

> 🔁 **You are now on both sides of the same idea in one project.** Your lesson extends `LessonBase` and fills in `execute()`. Your commands extend `FuelAction` and fill in `rollerPower()`. Identical deal — except somebody wrote `LessonBase` for you before you knew what it was.

---

## 📜 Part 3 – Code Archaeology (2 pts, optional)

**Basic (1 pt)**: the abstraction nobody wrote  
- Search all of [`OG-Code-2026`](https://github.com/Hudson-Robotics/OG-Code-2026) (branch `Pre-DCMP-Flywheel`) for the word `abstract` outside `LimelightHelpers.java`: `grep -rn abstract src/main/java/frc/robot`.  
- **There are none.** Not one abstract class in 24 commands and 4 subsystems.  
- Now diff two of them: `Intake.java` and `Eject.java` are **49 lines each**, and the only differences are the class name, the constructor name, one comment, and **two constant names**. `Shuttle.java` is 57 and `SpinUp.java` is 50, same shape.  
- Count it up: roughly 200 lines across four files to express about eight numbers. Rewrite one of them as a `FuelAction` subclass on paper and count what's left.  
- Then be fair to them. What does the duplicated version give you that yours doesn't? (Think about a rookie opening `Eject.java` at 11pm and needing to change only how ejecting works.)  

**Extra (1 pt)**: where their abstraction actually lives  
- They have no abstract classes of their own — but all 24 commands still share a lifecycle, and it works. Where is that shared code?  
- It's in `Command` itself, which is abstract, in WPILib. They inherited an abstraction instead of writing one. That is a legitimate answer, and it's most teams' answer.  
- So the real question is about the **second** layer: when four of your classes differ only in numbers, is a new parent worth it? Write down where you'd draw the line — two near-identical commands? Four? Ten?  
- Finally, look at `SequentialCommandGroup`, which four of their classes extend. Is that abstraction, or something else? (`JustShoot` and `ShootAndClimb` are the ones to read.) You'll build one in lesson 42.  

---

## 🏆 Total Points
- **Max:** 6 pts  
  - Java‑Only: 2 pts  
  - Robot Code: 2 pts  
  - Code Archaeology: 2 pts *(optional)*  

---

<!-- Drafting notes from the transcript draft. Hidden from students.
Ideas:  
- Emphasize that abstraction = hiding details, showing essentials.  
- Robot code: abstract parent class for subsystems.  
- Archaeology: replace repeated subsystem code with abstract parent.  
- Segue: Next lesson → **Interfaces** (pure abstraction, multiple inheritance of type).  
-->
