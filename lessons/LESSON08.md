# 🖥️ Lesson 08 – The `printf` Statement in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🐝

---

## 🎯 Overview
**Keywords:** Java, printf, Output Formatting, Placeholders, Specifiers, Precision, Flags, Width  
Learn to:
- Use `printf` as an alternative to `print` and `println`  
- Insert variables into strings with placeholders  
- Apply format specifiers for different data types (`%s`, `%c`, `%d`, `%f`, `%b`)  
- Control precision for floating‑point numbers  
- Use flags (`+`, `,`, `(`, space) for formatting  
- Set width and alignment (zero‑padding, left/right justification)  

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
- Create variables of different types:  
  - `String name = "SpongeBob";`  
  - `char firstLetter = 'S';`  
  - `int age = 30;`  
  - `double height = 60.5;`  
  - `boolean isEmployed = true;`  
- Use `printf` with the correct specifiers:  
  - `%s` for strings  
  - `%c` for characters  
  - `%d` for integers  
  - `%f` for doubles  
  - `%b` for booleans  

**Extra (1 pt)**  
- Demonstrate multiple variables in one line:  
  [CODE BLOCK]java
  System.out.printf("%s is %d years old%n", name, age);
  [CODE BLOCK]  
- Show precision with doubles (`%.2f`)  
- Experiment with flags (`+`, `,`, `(`, space)  
- Use width and justification (`%04d`, `%4d`, `%-4d`)  

---

## 🤖 Part 2 – Robot Code (2 pts)

**Basic (1 pt)**  
- Use `printf` to format sensor readings with consistent decimal places.  
- Example: print motor speed with one decimal place.  

**Extra (1 pt)**  
- Format telemetry output for SmartDashboard logs:  
  - Align columns of sensor values using width specifiers.  
  - Zero‑pad IDs or timestamps for clean alignment.  

---

## 📜 Part 3 – Code Archaeology (2 pts)

**Basic (1 pt)**  
- Find a place in last year’s robot code where `System.out.println` was used for debugging.  
- Suggest replacing it with `printf` for cleaner, aligned output.  

**Extra (1 pt)**  
- Propose improvements:  
  - Use precision for floating‑point sensor data.  
  - Align multiple values in a table‑like format.  
- Or write pseudo‑code for formatted telemetry:  
  [CODE BLOCK]java
  System.out.printf("ID: %04d | Voltage: %.2f V | Temp: %.1f C%n", id, voltage, temperature);
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
- Show how `%n` is better than `\n` for cross‑platform newlines.  
- Robot code: format joystick values with fixed width for easy reading.  
- Archaeology: replace messy debug prints with aligned tables.  
- Segue: Next lesson could cover loops to repeatedly print formatted output.  
[CODE BLOCK]
