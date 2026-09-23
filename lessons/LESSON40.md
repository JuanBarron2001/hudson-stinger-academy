# 🖥️ Lesson 40 – Getters and Setters in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🐝  

---

## 🎯 Overview
**Keywords:** Java, Encapsulation, Getters, Setters, Access Modifiers, Private Fields  
Learn to:
- Understand **encapsulation**: restricting direct access to fields  
- Use **private attributes** to protect data  
- Provide **getter methods** to read values safely  
- Provide **setter methods** to update values with control  
- Recognize how getters and setters improve **security, flexibility, and maintainability**  

---

## ⏱️ Progress Tracking

### 📊 For the Marathon Watchers  
If you’re following the **full 12‑hour compilation** and want to see how far you’ve made it through the *entire* course:  
- **Start Time in 12‑Hour Video:** [08:19:35](https://www.youtube.com/watch?v=xTtL8E4LzTQ&t=29975s)  
- **Full Course (12h video):** [Watch Compilation](https://www.youtube.com/watch?v=xTtL8E4LzTQ)

---

### 🎯 For the Quick‑Hit Learners  
If you just want **this lesson only** and to be done with it — no scrubbing through hours of footage:  
- **Lesson Playlist:** [Java tutorial for beginners (2025) ☕](https://www.youtube.com/playlist?list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc)  
- **This Lesson Only:** [Watch Lesson 40](https://www.youtube.com/watch?v=OjrR_C_UPjc&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=52) (Learn Java getters and setters in 10 minutes! 🔐, 10:06)

---

## 💻 Part 1 – Java‑Only (2 pts)

> New classes go in their own file next to `Main.java`, starting with the same `package` line, like lesson 27 (`package lesson40.basic;`, and `package lesson40.extra;` for the extra's copy).

**Basic (1 pt)**: lock the data, then open it on purpose  
- Create a `Car` class whose attributes are **private**:  

```java
public class Car {
    private String model;
    private String color;
    private int price;

    Car(String model, String color, int price) {
        this.model = model;
        this.color = color;
        this.price = price;
    }
}
```

- In `main()`, create `new Car("Charger", "Yellow", 10000)` and try to print `car.color`. Read the error: `private` means only code inside `Car` can touch it.  
- Add a **getter** for each attribute, so they can be read: `public String getModel()`, `public String getColor()` and `public int getPrice()`, each returning its attribute. Print all three with the getters.  
- Add **setters** for `color` and `price` only: `public void setColor(String color)` and `public void setPrice(int price)`. You can repaint a car or sell it for a new price, but a Charger can't turn into a Corvette, so there is **no** `setModel`.  
- Repaint the car blue, change its price, and print it again with the getters. Then try `car.setModel("Corvette")` and read the error.  

**Extra (1 pt)**: rules inside getters and setters  
- Make the model `private final String model;`. `final` means it can be set once, in the constructor, and never again, even from inside `Car`.  
- Add logic to the getter: have `getPrice()` return `"$" + price` (a `String` now).  
- Add a rule to the setter: if the new price is less than 0, print `"Price can't be less than zero"` and leave the old price alone.  
- Try `car.setPrice(-100)`. The message prints, and the price stays what it was.  

---

## 🤖 Part 2 – Robot Code: the 2026 Robot (2 pts)

Your code goes in `robot-code/command-based-bot-2026/src/main/java/frc/lesson/lesson40/basic/Lesson40.java` (and `extra/Lesson40.java`). The task list is at the top of each file.  
Run it in the simulator the way you did in [Lesson 00](./LESSON00.md).

> 🧱 First lesson of the last unit. Your robot can drive, intake, shoot and climb. Now it finds out **where it is**.

**Basic (1 pt)**: close the doors, then open windows  

Since [Lesson 27](./LESSON27.md) every field on your subsystems has been `public`, and your lessons have reached straight through them: `drivetrain.leftLeader.getPosition().getValueAsDouble()`. That one line is a lesson file knowing the robot has a motor called `leftLeader`, that it's a `TalonFX`, and that positions arrive in motor rotations. Change any one of those and every lesson breaks.

- Change every field in `Drivetrain` from `public` to `private`. **Build it.** Count the errors — that list is exactly every place something outside the class was reaching in.  
- Add the getters, and notice they don't just hand the field back. They answer a question, in units the caller actually wants:  

```java
public double getLeftDistanceMeters() {
    return leftLeader.getPosition().getValueAsDouble() * METERS_PER_MOTOR_ROTATION;
}

public Rotation2d getHeading() {
    return Rotation2d.fromDegrees(pigeon.getYaw().getValueAsDouble());
}
```

- Add the odometry — the thing that turns *"how far did each wheel go"* into *"where am I"*. Build a `DifferentialDriveOdometry` in the constructor from your three getters, add `getPose()` and `resetPose(Pose2d)`, and `odometry.update(...)` once per loop in `periodic()`.  
- Put `METERS_PER_MOTOR_ROTATION` in `Constants`: `(Math.PI * 0.1524) / 10.71`. Both numbers are marked **(not measured)** in [ROBOT.md](../robot-code/command-based-bot-2026/ROBOT.md), which matters in a moment.  
- Drive forward, holding **W** for two seconds. Then open the simulator's **Sim Field** view and compare it with your published `Pose X`.  
- 🧪 Your odometry says about **5.56 m**. The field says about **5.68 m**. **Predict which one a real robot would believe**, and why they differ at all.  

> 📏 **Why they differ:** odometry is a *guess* assembled from wheel rotations. If the wheels slip even slightly, or the wheel diameter in `Constants` isn't the real one, the guess drifts. That's about **2% here** — and 2% of a fifteen-second autonomous is the difference between scoring and missing.

> 🚪 **What the getters bought you:** your lesson now asks *"where am I?"* instead of *"what does motor 1 say?"*. Swap every `TalonFX` for a different motor tomorrow and nothing outside `Drivetrain` notices.

**Extra (1 pt)**: a setter that checks, and a minus sign worth arguing about  

A getter answers a question. A setter is the one place a value must get past you before it reaches a motor — so it is the natural place to check it.

- Replace the raw motor calls with `public void setPower(double left, double right)`, clamping both to **−1.0 … 1.0**. Publish whether you clamped anything.  
- On **A** call `setPower(3.0, 3.0)`; on **B** call `setPower(-3.0, -3.0)`. Both clamp, and the robot drives full forward then full backward.  
- 🧪 **Now the mistake to avoid.** Change the clamp to `0.0 … 1.0` and press **B** again. **Predict first.** The robot cannot reverse. At all, ever. A `0..1` clamp looks perfectly reasonable — *power is a percentage, percentages aren't negative* — and it silently deletes half of what a drivetrain can do. Put `-1.0` back.  

Now the heading. Last season's `getHeading()` is:

```java
return Rotation2d.fromDegrees(-pigeon2.getYaw().getValueAsDouble());
```

- **Write yours without the minus sign first.** Drive forward two seconds, then turn right for about one, watching `Drive/Heading Deg` and **Sim Field** together.  
- Now add the minus sign and repeat. **Predict what changes.**  
- Without it, heading goes **negative** turning right, and the field agrees. With it, heading goes **positive** while the robot still turns right — your odometry now believes the robot is somewhere it isn't, mirrored across the field.  

> ⚖️ **So is the minus sign wrong?** In the simulator, clearly yes. On the real robot, maybe not — the Pigeon is mounted on its side (see ROBOT.md), and the competition code sets a mount pose to handle that. The simulator does not reproduce the sideways mount, so **it cannot settle this**. What you *have* proved is how to settle it in ten seconds on the real robot: turn right, and see whether the heading agrees. Write down the test; do it at the next meeting.

> 🌀 **One more thing to notice.** After that hard turn your odometry says about **400°** and the field says about **429°**. Position matched almost exactly, but the *turn* lost 7%. Skidding sideways is invisible to a wheel encoder — it can only report rolling. That is why robots that care where they are trust a gyro for heading and the wheels only for distance.

---

## 📜 Part 3 – Code Archaeology (2 pts, optional)

**Basic (1 pt)**: the getters you just wrote, already there  
- `CANDriveSubsystem` in [`OG-Code-2026`](https://github.com/Hudson-Robotics/OG-Code-2026) (branch `Pre-DCMP-Flywheel`) has `getHeading()`, `getLeftDistanceMeters()`, `getRightDistanceMeters()`, `getPose()` and `resetPose()` — your list, same names.  
- Find the four lines in `configureAutoBuilder()` that read `this::getPose` and `this::resetPose`. PathPlanner is being handed **your getters and setters by name**, to call whenever it likes. Would that be possible if the fields were public and there were no methods? Say why not, precisely.  
- Now the question from the extra half: their `getHeading()` negates the yaw, and their Pigeon config sets a mount pose with a 90° pitch. Write down the ten-second test, then go run it at a meeting.  

**Extra (1 pt)**: the two things that never meet  
- `VisionSubsystem` can estimate the robot's pose from an AprilTag — look for `getPoseEstimate()`. `CANDriveSubsystem` estimates the robot's pose from wheels and a gyro.  
- **Search the whole project for anything that combines them.** There is nothing. No `addVisionMeasurement`, no `SwerveDrivePoseEstimator`, no call from one subsystem to the other.  
- So the robot has two independent opinions about where it is, and never compares them. Given what you measured about odometry drift, what would each be good for? Which one would you trust after fifteen seconds of a match, and which after one second?  
- This is a real thing the team could add next season, and it's the sort of item worth bringing to the capstone.  

---

## 🏆 Total Points
- **Max:** 6 pts  
  - Java‑Only: 2 pts  
  - Robot Code: 2 pts  
  - Code Archaeology: 2 pts *(optional)*  

---

<!-- Drafting notes from the transcript draft. Hidden from students.
Ideas:  
- Emphasize encapsulation: hide fields, expose controlled access.  
- Robot code: validate motor speeds or sensor values with setters.  
- Archaeology: replace `public` fields with private + getters/setters.  
- Segue: Next lesson → **Access Modifiers (public, private, protected)** for deeper encapsulation.  
-->
