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
- **Start Time in 12‑Hour Video:** [blank]  
- **Full Course (12h video):** [link here]  

---

### 🎯 For the Quick‑Hit Learners  
- **Lesson Playlist:** [link here]  
- **This Lesson Only:** [link here]  

---

## 💻 Part 1 – Java‑Only (2 pts)

**Basic (1 pt)**  
- Create an enum for days of the week:  

[CODE BLOCK]java
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
[CODE BLOCK]

- Usage in `main`:  

[CODE BLOCK]java
Day day = Day.SUNDAY;
System.out.println(day);              // SUNDAY
System.out.println(day.getDayNumber());// 1
[CODE BLOCK]

**Extra (1 pt)**  
- Use enums in a switch statement:  

[CODE BLOCK]java
Day today = Day.WEDNESDAY;

switch (today) {
    case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> 
        System.out.println("It is a weekday");
    case SATURDAY, SUNDAY -> 
        System.out.println("It is the weekend");
}
[CODE BLOCK]

- Enums are faster than comparing strings in switches and more readable than using integers.  

---

## 🤖 Part 2 – Robot Code (2 pts)

**Basic (1 pt)**  
- Use enums to represent robot modes:  

[CODE BLOCK]java
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
[CODE BLOCK]

**Extra (1 pt)**  
- Add values to enums (e.g., priority levels):  

[CODE BLOCK]java
public enum Priority {
    LOW(1), MEDIUM(2), HIGH(3);

    private final int level;
    Priority(int level) { this.level = level; }
    public int getLevel() { return level; }
}

Priority task = Priority.HIGH;
SmartDashboard.putNumber("Task Priority", task.getLevel());
[CODE BLOCK]

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

[CODE BLOCK]java
// Before
String mode = "AUTO";
if (mode.equals("AUTO")) { ... }

// After
RobotMode mode = RobotMode.AUTONOMOUS;
if (mode == RobotMode.AUTONOMOUS) { ... }
[CODE BLOCK]

---

## 🏆 Total Points
- **Max:** 6 pts  
  - Java‑Only: 2 pts  
  - Robot Code: 2 pts  
  - Code Archaeology: 2 pts  

---

[CODE BLOCK]LOG  
Ideas:  
- Emphasize enums = fixed set of constants, more readable than numbers/strings.  
- Robot code: use enums for modes, states, priorities.  
- Archaeology: replace string/int states with enums for safety and clarity.  
- Segue: Next lesson → **Interfaces** (contracts for classes to implement).  
[CODE BLOCK]
```