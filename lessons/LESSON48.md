# 🖥️ Lesson 48 – Dates and Times in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ ⏰  

---

## 🎯 Overview
**Keywords:** Java, LocalDate, LocalTime, LocalDateTime, Instant, DateTimeFormatter  
Learn to:
- Work with **current date, time, and date-time** using `LocalDate`, `LocalTime`, and `LocalDateTime`  
- Retrieve **UTC timestamps** with `Instant`  
- Format dates and times with **DateTimeFormatter**  
- Create **custom date/time objects** with `of()`  
- Compare dates with `isBefore()`, `isAfter()`, and `isEqual()`  

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
- Get the current date, time, and date-time:  

[CODE BLOCK]java
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.Instant;

public class Main {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime dateTime = LocalDateTime.now();
        Instant instant = Instant.now();

        System.out.println("Date: " + date);
        System.out.println("Time: " + time);
        System.out.println("DateTime: " + dateTime);
        System.out.println("UTC Instant: " + instant);
    }
}
[CODE BLOCK]

**Extra (1 pt)**  
- Format date-time with a custom pattern:  

[CODE BLOCK]java
import java.time.format.DateTimeFormatter;

LocalDateTime now = LocalDateTime.now();
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
String formatted = now.format(formatter);

System.out.println("Formatted: " + formatted);
[CODE BLOCK]

- Create custom date-time objects:  

[CODE BLOCK]java
LocalDate christmas = LocalDate.of(2024, 12, 25);
LocalDateTime newYears = LocalDateTime.of(2025, 1, 1, 0, 0);

System.out.println("Christmas: " + christmas);
System.out.println("New Year's: " + newYears);
[CODE BLOCK]

- Compare dates:  

[CODE BLOCK]java
if (christmas.isBefore(newYears.toLocalDate())) {
    System.out.println("Christmas is earlier than New Year's.");
}
[CODE BLOCK]

---

## 🤖 Part 2 – Robot Code (2 pts)

**Basic (1 pt)**  
- Log the current timestamp for robot events:  

[CODE BLOCK]java
LocalDateTime eventTime = LocalDateTime.now();
SmartDashboard.putString("Event Time", eventTime.toString());
[CODE BLOCK]

**Extra (1 pt)**  
- Format timestamps for logs:  

[CODE BLOCK]java
DateTimeFormatter logFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
String logEntry = "Shooter activated at " + LocalDateTime.now().format(logFormat);

SmartDashboard.putString("Log", logEntry);
[CODE BLOCK]

---

## 📜 Part 3 – Code Archaeology (2 pts)

**Basic (1 pt)**  
- Find a section of last year’s robot code where events were logged without timestamps.  
- Suggest adding `LocalDateTime.now()` to track when events occurred.  

**Extra (1 pt)**  
- Suggest improvements:  
  - Use `DateTimeFormatter` for human-readable logs.  
  - Store logs with timestamps in a file for debugging.  

[CODE BLOCK]java
// Before
System.out.println("Shooter activated");

// After
System.out.println("Shooter activated at " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
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
- Emphasize LocalDate/LocalTime/LocalDateTime/Instant basics.  
- Robot code: add timestamps to logs for debugging.  
- Archaeology: replace plain logs with timestamped logs.  
- Segue: Next lesson → **Timers and Scheduling** (using `ScheduledExecutorService`).  
[CODE BLOCK]
