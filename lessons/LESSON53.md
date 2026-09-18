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

## 🤖 Part 2 – Robot Code (2 pts)

**Basic (1 pt)**  
- Use enums to represent robot modes:  

```java
public enum RobotMode {
    DISABLED,
    AUTONOMOUS,
    TELEOP,
    TEST
}

RobotMode mode = RobotMode.AUTONOMOUS;

switch (mode) {
    case DISABLED -> SmartDashboard.putString("Mode", "Robot Disabled");
    case AUTONOMOUS -> SmartDashboard.putString("Mode", "Running Autonomous");
    case TELEOP -> SmartDashboard.putString("Mode", "Teleop Control");
    case TEST -> SmartDashboard.putString("Mode", "Test Mode");
}
```

**Extra (1 pt)**  
- Add values to enums (e.g., priority levels):  

```java
public enum Priority {
    LOW(1), MEDIUM(2), HIGH(3);

    private final int level;
    Priority(int level) { this.level = level; }
    public int getLevel() { return level; }
}

Priority task = Priority.HIGH;
SmartDashboard.putNumber("Task Priority", task.getLevel());
```

---

## 📜 Part 3 – Code Archaeology (2 pts)

**Basic (1 pt)**  
- Find a section of last year’s robot code where strings or integers were used to represent states (e.g., `"AUTO"`, `"TELEOP"`, or `1, 2, 3`).  
- Suggest replacing them with enums for clarity and type safety.  

**Extra (1 pt)**  
- Suggest improvements:  
  - Use enums for subsystem states (e.g., `ArmState.UP`, `ArmState.DOWN`).  
  - Use enums for error codes or logging levels.  
  - Replace fragile string comparisons with enum constants.  

```java
// Before
String mode = "AUTO";
if (mode.equals("AUTO")) { ... }

// After
RobotMode mode = RobotMode.AUTONOMOUS;
if (mode == RobotMode.AUTONOMOUS) { ... }
```

---

## 🏆 Total Points
- **Max:** 6 pts  
  - Java‑Only: 2 pts  
  - Robot Code: 2 pts  
  - Code Archaeology: 2 pts  

---

<!-- Drafting notes from the transcript draft. Hidden from students.
Ideas:  
- Emphasize enums = fixed set of constants, more readable than numbers/strings.  
- Robot code: use enums for modes, states, priorities.  
- Archaeology: replace string/int states with enums for safety and clarity.  
- Segue: Next lesson → **Interfaces** (contracts for classes to implement).  
-->
