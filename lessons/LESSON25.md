# 🖥️ Lesson 25 – Variable Arguments (Varargs) in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🐝

---

## 🎯 Overview
**Keywords:** Java, Varargs, Variable Arguments, Arrays, Enhanced For Loop, Method Flexibility  
Learn to:
- Understand **variable arguments (varargs)** in Java  
- Replace multiple overloaded methods with a single flexible method  
- Use the `...` (ellipsis) syntax to accept any number of arguments  
- Recognize that varargs are treated as arrays inside the method  
- Apply varargs to create methods like `add()` and `average()`  

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
- Create a method `add(int... numbers)` that sums any number of integers.  

[CODE BLOCK]java
static int add(int... numbers) {
    int sum = 0;
    for (int number : numbers) {
        sum += number;
    }
    return sum;
}

public static void main(String[] args) {
    System.out.println(add(1, 2, 3));       // 6
    System.out.println(add(5, 10, 15, 20)); // 50
}
[CODE BLOCK]

**Extra (1 pt)**  
- Create a method `average(double... numbers)` that calculates the average.  
- Handle the case when no arguments are passed (avoid division by zero).  

[CODE BLOCK]java
static double average(double... numbers) {
    if (numbers.length == 0) {
        return 0;
    }
    double sum = 0;
    for (double number : numbers) {
        sum += number;
    }
    return sum / numbers.length;
}

public static void main(String[] args) {
    System.out.println(average(2, 3, 4, 5)); // 3.5
    System.out.println(average());           // 0
}
[CODE BLOCK]

---

## 🤖 Part 2 – Robot Code (2 pts)

**Basic (1 pt)**  
- Create a method `setMotorSpeeds(double... speeds)` that accepts any number of motor speeds.  
- Print each motor speed.  

[CODE BLOCK]java
static void setMotorSpeeds(double... speeds) {
    for (int i = 0; i < speeds.length; i++) {
        System.out.println("Motor " + i + " speed: " + speeds[i]);
    }
}
[CODE BLOCK]

**Extra (1 pt)**  
- Send motor speeds to **SmartDashboard** dynamically.  

[CODE BLOCK]java
static void setMotorSpeeds(double... speeds) {
    for (int i = 0; i < speeds.length; i++) {
        SmartDashboard.putNumber("Motor " + i + " Speed", speeds[i]);
    }
}
[CODE BLOCK]

---

## 📜 Part 3 – Code Archaeology (2 pts)

**Basic (1 pt)**  
- Find a section in last year’s robot code where multiple overloaded methods existed (e.g., `driveForward(int speed)`, `driveForward(int left, int right)`).  
- Suggest replacing them with a single varargs method.  

**Extra (1 pt)**  
- Suggest improvements:  
  - Replace multiple `addMotor()` overloads with one `addMotors(Motor... motors)`.  
  - Replace repeated `logSensorValues()` overloads with `logSensors(String... sensors)`.  

[CODE BLOCK]java
static void logSensors(String... sensors) {
    for (String sensor : sensors) {
        System.out.println("Logging sensor: " + sensor);
    }
}
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
- Show how varargs simplify code compared to overloaded methods.  
- Robot code: varargs for motor speeds or sensor logging.  
- Archaeology: replace multiple overloads with a single varargs method.  
- Segue: Next lesson could cover **2D arrays** or **ArrayLists**, since varargs naturally connect to collections.  
[CODE BLOCK]
