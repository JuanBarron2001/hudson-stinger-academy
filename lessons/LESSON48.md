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

> The `import` lines go at the **top** of your `Main.java`, and the rest goes **inside** `main`. Keep the `public class Main extends BaseLesson` line your file already has: without `extends BaseLesson`, the lesson runner can't run it.

**Basic (1 pt)**  
- Import `LocalDate`, `LocalTime`, `LocalDateTime` and `Instant`, all from `java.time`.  
- Print each one's `now()`, with a label: `Date: `, `Time: `, `DateTime: ` and `UTC Instant: `.  
- Compare the date-time and the instant. Why are their hours different? *(Hint: the `Z` at the end of the instant means UTC, not your time zone.)* Answer in a comment.  

Expected output (your date and times will differ, and so may the gap between the hours):  

```
Date: 2026-09-24
Time: 23:52:37.138986544
DateTime: 2026-09-24T23:52:37.139804602
UTC Instant: 2026-09-25T04:52:37.140593612Z
```

**Extra (1 pt)**  
- Import `java.time.format.DateTimeFormatter`. Make one with `DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss")` (`MM` is the month, `dd` the day, `yyyy` the year, `HH:mm:ss` the time), then print `Formatted: ` and `LocalDateTime.now().format(...)`.  
- Build your own date-times with `LocalDateTime.of(year, month, day, hour, minute, second)`: `date1` is Christmas 2024 at noon, and `date2` is New Year's 2025 at midnight.  
- Compare them the way the video does, with an `if` / `else if` / `else if`:  
  - `date1.isBefore(date2)` prints the two joined by ` is earlier than `  
  - `date1.isAfter(date2)` prints ` is later than `  
  - `date1.isEqual(date2)` prints ` is equal to `  
- Change `date1` so each branch prints once: January 2nd, 2025, then New Year's at midnight.  

Expected output (the first line will differ). Notice a time with zero seconds prints as just `12:00`:  

```
Formatted: 09-24-2026 23:52:37
2024-12-25T12:00 is earlier than 2025-01-01T00:00
2025-01-02T00:00 is later than 2025-01-01T00:00
2025-01-01T00:00 is equal to 2025-01-01T00:00
```

---

## 🤖 Part 2 – Robot Code (2 pts)

> **Not written yet.** Lesson 48 is **optional** this offseason, so its robot half was never rewritten for the 2026 robot. What used to be here was a 2025 draft describing hardware this robot doesn't have, so it has been taken out rather than left to send you down a dead end. **Skip Parts 2 and 3 for now.**
>
> Ahead of the pace and want the points anyway? Ask a mentor. Writing this half with you is a good use of a meeting.

---

## 📜 Part 3 – Code Archaeology (2 pts, optional)

> Not written yet. See Part 2.

---

## 🏆 Total Points
- **Max right now:** 2 pts  
  - Java‑Only: 2 pts  
  - Robot Code and Code Archaeology: they come back if this lesson gets a 2026 robot half

---

<!-- Drafting notes from the transcript draft. Hidden from students.
Ideas:  
- Emphasize LocalDate/LocalTime/LocalDateTime/Instant basics.  
- Robot code: add timestamps to logs for debugging.  
- Archaeology: replace plain logs with timestamped logs.  
- Segue: Next lesson → **Timers and Scheduling** (using `ScheduledExecutorService`).  
-->
