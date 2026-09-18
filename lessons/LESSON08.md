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
If you’re following the **full 12‑hour compilation** and want to see how far you’ve made it through the *entire* course:  
- **Start Time in 12‑Hour Video:** [01:42:37](https://www.youtube.com/watch?v=xTtL8E4LzTQ&t=6157s)  
- **Full Course (12h video):** [Watch Compilation](https://www.youtube.com/watch?v=xTtL8E4LzTQ)

---

### 🎯 For the Quick‑Hit Learners  
If you just want **this lesson only** and to be done with it — no scrubbing through hours of footage:  
- **Lesson Playlist:** [Java tutorial for beginners (2025) ☕](https://www.youtube.com/playlist?list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc)  
- **This Lesson Only:** [Watch Lesson 08](https://www.youtube.com/watch?v=nTBDjxWAcoE&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=10) (Java printf() is really useful! 🖨️, 13:37)

---

## 💻 Part 1 – Java‑Only (2 pts)

**Basic (1 pt)**  
- Build a **player profile card** with formatted output:
  - Create variables: `name` (String), `initial` (char), `rank` (int), `wins` (int), `score` (double), `level` (int), `isOnline` (boolean)
  - Use `printf` to print a nicely aligned profile with a header and footer
  - Use every specifier from the video at least once: `%s`, `%c`, `%d`, `%f` and `%b`
  - Use `printf` with:
    - Precision for doubles (`%.2f`)
    - The `,` flag for comma-separated thousands (`%,.2f` gives `12,345.50`)
    - **Zero padding** for the rank: `%03d` turns `1` into `001`
    - Width to line things up: a positive width right‑justifies (`%5d`), a negative one left‑justifies (`%-12s`)
    - `%n` (or `\n`) at the end of every line. `printf` never adds a new line for you.
  - Example output:
    ```
    ================================
     Player Profile
    ================================
     Name:        SpongeBob
     Rank:        #001
     Level:       45
     Wins:        234
     Score:       12,345.50
     Online:      true
    ================================
    ```

**Extra (1 pt)**  
- Build an **interactive "Team Member Profile" card** with Scanner input:
  - Prompt for: name, team number, role (driver/operator/engineer), years on team, match wins, total hours
  - After every `nextInt()` or `nextDouble()`, call `scanner.nextLine()` once before reading the next word, or the leftover new line from lesson 03 swallows it.
  - Format and print a nicely aligned profile card with all fields
  - Use consistent width and precision throughout
  - Example: "John Doe | #4295 | Driver | 2 years | 47 wins | 120.5 hrs"  

---

## 🤖 Part 2 – Robot Code (2 pts)

**Basic (1 pt)**  
- Format **joystick input** with consistent decimal places and alignment:
  - Read all 4 axes from an XboxController: left X, left Y, right X, right Y
  - Use `printf` to print them in an aligned, easy-to-read format:
    ```
    Left X:  -0.25  |  Right X:  +0.50
    Left Y:  +0.75  |  Right Y:  -0.12
    ```
  - Use:
    - `%.2f` for 2 decimal places
    - `%+` flag to show +/- signs
    - Width specifiers for alignment
    - `%n` for newlines
  - Print this to console every 50-100ms so you can see real-time input

**Extra (1 pt)**  
- Build a **match data logger** that captures critical telemetry:
  - Log the following **every 100ms** (or on a periodic timer):
    - Timestamp (milliseconds since robot enable)
    - Joystick inputs (4 axes: left X/Y, right X/Y, each `%+.2f`)
    - Motor speeds (left wheel, right wheel, each `%+.2f`)
    - Distance to AprilTag (from Limelight `ta`, in units, `%.1f`)
  - Format as an aligned table so it's readable when scrolling through logs:
    ```
    Time(ms) | LX     LY     RX     RY     | LeftW  RightW | TagDist
    1250     | -0.25  +0.75  +0.50  -0.12  | +0.60  +0.65  | 24.5
    1350     | -0.23  +0.76  +0.48  -0.10  | +0.58  +0.63  | 23.8
    ```
  - Use consistent width and precision throughout so logs are machine-readable and human-readable
  - This data is useful for post-match debugging!  

---

## 📜 Part 3 – Code Archaeology (2 pts)

**Basic (1 pt)**  
- Find debug output in last year's robot code (console or SmartDashboard prints).  
- Identify messy or hard-to-read output (inconsistent spacing, no decimal places, values running together).  
- Suggest how `printf` with proper width and precision would improve readability.  

**Extra (1 pt)**  
- Propose a formatted telemetry system for match data:
  - What data matters most during a match? (sensor values, motor speeds, timing)
  - Design a table format that's easy to read at a glance
  - Write pseudo-code for logging that data with `printf`
  - Consider: What precision do different values need? How should columns be aligned?

---

## 🏆 Total Points
- **Max:** 6 pts  
  - Java‑Only: 2 pts  
  - Robot Code: 2 pts  
  - Code Archaeology: 2 pts

---

<!-- Drafting notes from the transcript draft. Hidden from students.
Ideas:
- Show how `%n` is better than `\n` for cross‑platform newlines.  
- Robot code: format joystick values with fixed width for easy reading.  
- Archaeology: replace messy debug prints with aligned tables.  
- Segue: Next lesson could cover loops to repeatedly print formatted output.  
-->
