# 🖥️ Lesson 39 – Runtime (Dynamic) Polymorphism in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🐝  

---

## 🎯 Overview
**Keywords:** Java, Runtime Polymorphism, Dynamic Dispatch, Abstract Classes, Method Overriding  
Learn to:
- Understand **runtime polymorphism**: the method executed is determined at **runtime** based on the actual object type  
- Use **abstract classes** and **method overriding** to enforce consistent method signatures  
- Accept **user input** to decide which object to instantiate at runtime  
- Demonstrate **dynamic dispatch**: the JVM decides which overridden method to call  

---

## ⏱️ Progress Tracking

### 📊 For the Marathon Watchers  
If you’re following the **full 12‑hour compilation** and want to see how far you’ve made it through the *entire* course:  
- **Start Time in 12‑Hour Video:** [08:14:27](https://www.youtube.com/watch?v=xTtL8E4LzTQ&t=29667s)  
- **Full Course (12h video):** [Watch Compilation](https://www.youtube.com/watch?v=xTtL8E4LzTQ)

---

### 🎯 For the Quick‑Hit Learners  
If you just want **this lesson only** and to be done with it — no scrubbing through hours of footage:  
- **Lesson Playlist:** [Java tutorial for beginners (2025) ☕](https://www.youtube.com/playlist?list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc)  
- **This Lesson Only:** [Watch Lesson 39](https://www.youtube.com/watch?v=YDKHfqzaF30&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=51) (Learn runtime polymorphism in 5 minutes! 🤷‍♂️, 5:10)

---

## 💻 Part 1 – Java‑Only (2 pts)

> Each class gets its own file next to `Main.java`, starting with the same `package` line, like lesson 27 (`package lesson39.basic;`, and `package lesson39.extra;` for the extra's copies).

**Basic (1 pt)**  
- Create an abstract parent class, `Animal`, with one abstract method, `abstract void speak();`.  
- Create `Dog` and `Cat`, which extend `Animal` and override `speak()`, printing `The dog goes woof` and `The cat goes meow`.  
- In `main()`, create a `Dog` and a `Cat` and call `speak()` on each. Then try `new Animal()` and read the error, `Animal is abstract; cannot be instantiated`. Delete it.  

Expected output:  

```
The dog goes woof
The cat goes meow
```

**Extra (1 pt)**  
- Use **runtime polymorphism**, where the user picks the pet while the program runs. Add `import java.util.Scanner;` at the top of your `Main.java`, and write the rest **inside** `main`. Keep the `public class Main extends BaseLesson` line your file already has: without `extends BaseLesson`, the lesson runner can't run it.  
- Ask `Would you like a pet? (1 = Dog, 2 = Cat): ` and read an `int`.  
- Declare `Animal animal;`, but don't create it yet. Then, if the choice is `1`, make it a `new Dog()`, and otherwise a `new Cat()`.  
- Call `animal.speak()` **once**, after the `if`. Which `speak()` runs isn't decided until the program is running and the user has answered. Close the scanner.  

Expected output:  
- Input `1` → `The dog goes woof`  
- Input `2` → `The cat goes meow`  

---

## 🤖 Part 2 – Robot Code (2 pts)

> **Not written yet.** Lesson 39 is **optional** this offseason, so its robot half was never rewritten for the 2026 robot. What used to be here was a 2025 draft describing hardware this robot doesn't have, so it has been taken out rather than left to send you down a dead end. **Skip Parts 2 and 3 for now.**
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
- Emphasize runtime polymorphism = method chosen at runtime, not compile time.  
- Robot code: subsystems selected dynamically based on input.  
- Archaeology: replace rigid `if`/`else` with polymorphic design.  
- Segue: Next lesson → **Casting & instanceof** (downcasting objects, type checks).  
-->
