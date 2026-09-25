# 🖥️ Lesson 30 – Arrays of Objects in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🐝  

---

## 🎯 Overview
**Keywords:** Java, Arrays, Objects, Anonymous Objects, Enhanced For Loop, Constructors  
Learn to:
- Create a class with attributes and methods  
- Instantiate multiple objects from that class  
- Store objects inside an array  
- Iterate through arrays of objects with standard and enhanced for loops  
- Use **anonymous objects** inside arrays  
- Modify attributes of objects stored in arrays  

---

## ⏱️ Progress Tracking

### 📊 For the Marathon Watchers  
If you’re following the **full 12‑hour compilation** and want to see how far you’ve made it through the *entire* course:  
- **Start Time in 12‑Hour Video:** [07:08:22](https://www.youtube.com/watch?v=xTtL8E4LzTQ&t=25702s)  
- **Full Course (12h video):** [Watch Compilation](https://www.youtube.com/watch?v=xTtL8E4LzTQ)

---

### 🎯 For the Quick‑Hit Learners  
If you just want **this lesson only** and to be done with it — no scrubbing through hours of footage:  
- **Lesson Playlist:** [Java tutorial for beginners (2025) ☕](https://www.youtube.com/playlist?list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc)  
- **This Lesson Only:** [Watch Lesson 30](https://www.youtube.com/watch?v=cMJeCs0n6BY&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=42) (Learn Java ARRAY OF OBJECTS in 5 minutes! 🗃️, 5:46)

---

## 💻 Part 1 – Java‑Only (2 pts)

> New classes go in their own file next to `Main.java`, starting with the same `package` line, like lesson 27: `Car.java` starts with `package lesson30.basic;` in the basic folder, and the extra folder gets its own copy with `package lesson30.extra;`.

**Basic (1 pt)**  
- Create a `Car` class with `String model` and `String color`, a constructor `Car(String model, String color)` that sets both, and `void drive()`, which prints `You drive the `, then the color, a space, and the model.  
- In `main()`, create three cars (a red Mustang, a blue Corvette and a yellow Charger) and store them in a `Car[]` array.  
- Use a `for` loop that stops at `cars.length` to call `drive()` on each one.  

Expected output:  

```
You drive the Red Mustang
You drive the Blue Corvette
You drive the Yellow Charger
```

**Extra (1 pt)**  
- Build the array with **anonymous objects**: put the three `new Car(...)` calls straight inside the array's braces, with no variable for each car.  
- Drive every car with an **enhanced `for` loop** (`for (Car car : cars)`).  
- Paint every car: in another enhanced `for` loop, set `car.color = "Black";`, then drive them all again. Changing an object you got from the array changes the object itself.  

Expected output:  

```
You drive the Red Mustang
You drive the Blue Corvette
You drive the Yellow Charger
You drive the Black Mustang
You drive the Black Corvette
You drive the Black Charger
```

---

## 🤖 Part 2 – Robot Code (2 pts)

> **Not written yet.** Lesson 30 is **optional** this offseason, so its robot half was never rewritten for the 2026 robot. What used to be here was a 2025 draft describing hardware this robot doesn't have, so it has been taken out rather than left to send you down a dead end. **Skip Parts 2 and 3 for now.**
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
- Show difference between arrays of primitives vs. arrays of objects.  
- Robot code: arrays of motors or sensors.  
- Archaeology: replace multiple object variables with arrays.  
- Segue: Next lesson → **Object Arrays + Loops with User Input** (dynamic object creation).  
-->
