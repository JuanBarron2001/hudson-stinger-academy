# 🖥️ Lesson 24 – User Input into Arrays in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🐝

---

## 🎯 Overview
**Keywords:** Java, Arrays, User Input, Scanner, Dynamic Size, For Loop, Enhanced For Loop  
Learn to:
- Allocate memory for arrays before assigning values  
- Understand why arrays need a fixed size at creation  
- Fill arrays with user input using `Scanner`  
- Dynamically set array size based on user input  
- Handle input buffer issues when mixing `nextInt()` and `nextLine()`  

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
- Create a `String[] foods = new String[3];`  
- Use a `for` loop to prompt the user three times:  

[CODE BLOCK]java
String[] foods = new String[3];
Scanner scanner = new Scanner(System.in);

for (int i = 0; i < foods.length; i++) {
    System.out.print("Enter a food: ");
    foods[i] = scanner.nextLine();
}

for (String food : foods) {
    System.out.println(food);
}
scanner.close();
[CODE BLOCK]

**Extra (1 pt)**  
- Ask the user how many foods they want to enter.  
- Use that number to set the array size dynamically.  
- Clear the input buffer after `nextInt()` with `scanner.nextLine()`.  

[CODE BLOCK]java
System.out.print("How many foods do you want? ");
int size = scanner.nextInt();
scanner.nextLine(); // clear buffer

String[] foods = new String[size];

for (int i = 0; i < foods.length; i++) {
    System.out.print("Enter a food: ");
    foods[i] = scanner.nextLine();
}

for (String food : foods) {
    System.out.println(food);
}
[CODE BLOCK]

---

## 🤖 Part 2 – Robot Code (2 pts)

**Basic (1 pt)**  
- Create an array of motor names and print them:  

[CODE BLOCK]java
String[] motors = {"leftMotor", "rightMotor", "armMotor"};
for (String motor : motors) {
    System.out.println("Motor: " + motor);
}
[CODE BLOCK]

**Extra (1 pt)**  
- Ask the user how many motors they want to configure.  
- Create an array of motor speeds with that size.  
- Fill the array with user input values.  
- Print results to **SmartDashboard**.  

[CODE BLOCK]java
System.out.print("How many motors? ");
int motorCount = scanner.nextInt();
double[] speeds = new double[motorCount];

for (int i = 0; i < motorCount; i++) {
    System.out.print("Enter speed for motor " + i + ": ");
    speeds[i] = scanner.nextDouble();
}

// Example SmartDashboard output
for (int i = 0; i < motorCount; i++) {
    SmartDashboard.putNumber("Motor " + i + " Speed", speeds[i]);
}
[CODE BLOCK]

---

## 📜 Part 3 – Code Archaeology (2 pts)

**Basic (1 pt)**  
- Find a section of last year’s robot code where multiple variables were used for similar data (e.g., `motor1`, `motor2`, `motor3`).  
- Suggest replacing them with an array.  

**Extra (1 pt)**  
- Suggest improvements:  
  - Replace repeated `println` statements with a loop over an array.  
  - Use arrays to store joystick button states or autonomous path steps.  

[CODE BLOCK]java
System.out.print("How many motors? ");
int size = scanner.nextInt();
scanner.nextLine(); // clear buffer
double[] speeds = new double[size];

for (int i = 0; i < size; i++) {
    System.out.print("Enter speed for motor " + i + ": ");
    speeds[i] = scanner.nextDouble();
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
- Show difference between fixed-size arrays and dynamic size from user input.  
- Robot code: arrays for motor speeds or sensor names.  
- Archaeology: replace multiple variables with arrays for cleaner code.  
- Segue: Next lesson could cover **2D arrays** (grids/matrices) since user input arrays lead naturally into them.  
[CODE BLOCK]
