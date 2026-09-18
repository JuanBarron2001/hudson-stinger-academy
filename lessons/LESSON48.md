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
If you’re following the **full 12‑hour compilation** and want to see how far you’ve made it through the *entire* course:  
- **Start Time in 12‑Hour Video:** [10:11:42](https://www.youtube.com/watch?v=xTtL8E4LzTQ&t=36702s)  
- **Full Course (12h video):** [Watch Compilation](https://www.youtube.com/watch?v=xTtL8E4LzTQ)

---

### 🎯 For the Quick‑Hit Learners  
If you just want **this lesson only** and to be done with it — no scrubbing through hours of footage:  
- **Lesson Playlist:** [Java tutorial for beginners (2025) ☕](https://www.youtube.com/playlist?list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc)  
- **This Lesson Only:** [Watch Lesson 48](https://www.youtube.com/watch?v=F2bZ1fkAQx0&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=62) (Learn DATES & TIMES with Java in 8 minutes! 📆, 8:44)

---

## 💻 Part 1 – Java‑Only (2 pts)

> In the code below, the `import` lines go at the **top** of your `Main.java`, and the rest goes **inside** `main`. Keep the `public class Main extends BaseLesson` line your file already has: without `extends BaseLesson`, the lesson runner can't run it.

**Basic (1 pt)**  
- Get the current date, time, and date-time:  

```java
// at the top of the file:
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.Instant;

// inside main:
LocalDate date = LocalDate.now();
LocalTime time = LocalTime.now();
LocalDateTime dateTime = LocalDateTime.now();
Instant instant = Instant.now();

System.out.println("Date: " + date);
System.out.println("Time: " + time);
System.out.println("DateTime: " + dateTime);
System.out.println("UTC Instant: " + instant);
```

- Compare `dateTime` and `instant`. Why are their hours different? *(Hint: the `Z` at the end of the instant means UTC, not your time zone.)*  

**Extra (1 pt)**  
- Format date-time with a custom pattern (`MM` is the month, `dd` the day, `yyyy` the year, `HH:mm:ss` the time):  

```java
// at the top of the file:
import java.time.format.DateTimeFormatter;

// inside main:
LocalDateTime now = LocalDateTime.now();
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
String formatted = now.format(formatter);

System.out.println("Formatted: " + formatted);
```

- Create your own date-times with `of()`, and compare them the way the video does:  

```java
LocalDateTime date1 = LocalDateTime.of(2024, 12, 25, 12, 0, 0); // Christmas, noon
LocalDateTime date2 = LocalDateTime.of(2025, 1, 1, 0, 0, 0);    // New Year's, midnight

if (date1.isBefore(date2)) {
    System.out.println(date1 + " is earlier than " + date2);
} else if (date1.isAfter(date2)) {
    System.out.println(date1 + " is later than " + date2);
} else if (date1.isEqual(date2)) {
    System.out.println(date1 + " is equal to " + date2);
}
```

- Change `date1` so each branch prints once: January 2nd, 2025, then New Year's at midnight.  

---

## 🤖 Part 2 – Robot Code (2 pts)

**Basic (1 pt)**  
- Log the current timestamp for robot events:  

```java
LocalDateTime eventTime = LocalDateTime.now();
SmartDashboard.putString("Event Time", eventTime.toString());
```

**Extra (1 pt)**  
- Format timestamps for logs:  

```java
DateTimeFormatter logFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
String logEntry = "Shooter activated at " + LocalDateTime.now().format(logFormat);

SmartDashboard.putString("Log", logEntry);
```

---

## 📜 Part 3 – Code Archaeology (2 pts)

**Basic (1 pt)**  
- Find a section of last year’s robot code where events were logged without timestamps.  
- Suggest adding `LocalDateTime.now()` to track when events occurred.  

**Extra (1 pt)**  
- Suggest improvements:  
  - Use `DateTimeFormatter` for human-readable logs.  
  - Store logs with timestamps in a file for debugging.  

```java
// Before
System.out.println("Shooter activated");

// After
System.out.println("Shooter activated at " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
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
- Emphasize LocalDate/LocalTime/LocalDateTime/Instant basics.  
- Robot code: add timestamps to logs for debugging.  
- Archaeology: replace plain logs with timestamped logs.  
- Segue: Next lesson → **Timers and Scheduling** (using `ScheduledExecutorService`).  
-->
