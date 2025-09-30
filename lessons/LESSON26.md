# 🖥️ Lesson 26 – 2D Arrays in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🐝

---

## 🎯 Overview
**Keywords:** Java, 2D Arrays, Multi‑Dimensional Arrays, Nested Loops, Matrix, Rows, Columns  
Learn to:
- Understand that a **2D array is an array of arrays**  
- Initialize and display 2D arrays  
- Access and modify elements using two indices (row, column)  
- Use nested loops to traverse a 2D array  
- Build a mini‑project: a telephone keypad grid  

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
- Create a 2D array of groceries:  

[CODE BLOCK]java
String[][] groceries = {
    {"Apple", "Orange", "Banana"},
    {"Potato", "Onion", "Carrot"},
    {"Chicken", "Pork", "Beef", "Fish"}
};

// Nested loop to print
for (String[] foods : groceries) {
    for (String food : foods) {
        System.out.print(food + " ");
    }
    System.out.println();
}
[CODE BLOCK]

**Extra (1 pt)**  
- Modify elements using two indices:  

[CODE BLOCK]java
groceries[0][0] = "Pineapple"; // replaces Apple
groceries[1][0] = "Celery";    // replaces Potato
groceries[2][1] = "Eggs";      // replaces Pork
[CODE BLOCK]

---

## 🤖 Part 2 – Robot Code (2 pts)

**Basic (1 pt)**  
- Create a 2D array to represent a robot’s grid map (rows = y, columns = x).  
- Fill it with `"."` for empty spaces.  

**Extra (1 pt)**  
- Place `"R"` for robot position and `"O"` for obstacles.  
- Use nested loops to print the grid to **SmartDashboard**.  

[CODE BLOCK]java
char[][] grid = {
    {'.', '.', '.', '.'},
    {'.', 'O', '.', '.'},
    {'.', '.', 'R', '.'},
    {'.', '.', '.', '.'}
};

for (char[] row : grid) {
    String line = "";
    for (char cell : row) {
        line += cell + " ";
    }
    SmartDashboard.putString("Grid Row", line);
}
[CODE BLOCK]

---

## 📜 Part 3 – Code Archaeology (2 pts)

**Basic (1 pt)**  
- Find a section of last year’s robot code where multiple arrays were used separately (e.g., left motor speeds, right motor speeds).  
- Suggest combining them into a **2D array** for cleaner structure.  

**Extra (1 pt)**  
- Suggest improvements:  
  - Replace multiple nested `if` statements with a 2D array lookup.  
  - Use a 2D array to store autonomous path coordinates.  

[CODE BLOCK]java
int[][] path = {
    {0, 0},  // start
    {1, 2},  // move to (1,2)
    {2, 3},  // move to (2,3)
    {3, 5}   // move to (3,5)
};
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
- Show difference between 1D arrays and 2D arrays.  
- Robot code: 2D arrays for grid maps or path planning.  
- Archaeology: replace multiple arrays with one 2D structure.  
- Segue: Next lesson could cover **ArrayLists** or **multi‑dimensional data structures**.  
[CODE BLOCK]
