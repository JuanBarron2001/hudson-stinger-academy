# 🖥️ Lesson 49 – Anonymous Classes in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🐝

---

## 🎯 Overview
**Keywords:** Java, Anonymous Classes, Method Overriding, Inheritance, Interfaces, Runnable  
Learn to:
- Give **one** object its own behavior without writing a whole new class  
- Override a method inside an **anonymous class**: `new Dog() { ... };`  
- See that an anonymous class really has no name of its own  
- Build an object from an **interface** on the spot, the pattern lesson 50's `TimerTask` uses  

---

## ⏱️ Progress Tracking

### 📊 For the Marathon Watchers  
If you’re following the **full 12‑hour compilation** and want to see how far you’ve made it through the *entire* course:  
- **Start Time in 12‑Hour Video:** [10:20:24](https://www.youtube.com/watch?v=xTtL8E4LzTQ&t=37224s)  
- **Full Course (12h video):** [Watch Compilation](https://www.youtube.com/watch?v=xTtL8E4LzTQ)

---

### 🎯 For the Quick‑Hit Learners  
If you just want **this lesson only** and to be done with it — no scrubbing through hours of footage:  
- **Lesson Playlist:** [Java tutorial for beginners (2025) ☕](https://www.youtube.com/playlist?list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc)  
- **This Lesson Only:** [Watch Lesson 49](https://www.youtube.com/watch?v=P_iOnmdww8E&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=63) (Learn Java anonymous classes in 5 minutes! 🕵️‍♂️, 5:02)

---

## 💻 Part 1 – Java‑Only (2 pts)

> New classes go in their own file next to `Main.java`, starting with the same `package` line, like lesson 27 (`package lesson49.basic;`, and `package lesson49.extra;` for the extra's copy).

**Basic (1 pt)**: one unusual dog  
- Create a `Dog` class with one method, `void speak()`, that prints `"The dog goes woof"`. In `main()`, create a dog and make it speak.  
- Scooby‑Doo is a dog who talks. **The long way** first: a new file, `TalkingDog.java`, where `TalkingDog extends Dog` and overrides `speak()` to print `"Scooby-Doo says ruh-roh"`. Create one and make it speak.  
- That's a whole class for a single dog. **The short way:** delete `TalkingDog.java`, and give a second, ordinary `Dog` its own `speak()` right where you create it:  

```java
Dog dog2 = new Dog() {
    @Override
    void speak() {
        System.out.println("Scooby-Doo says ruh-roh");
    }
};
```

- The braces after `new Dog()` are a class with **no name**: an anonymous class. Notice the `;` after the closing brace. Make both dogs speak: the first still goes woof.  

**Extra (1 pt)**: no name, and no class needed  
- Print `dog2.getClass().getName()`. Java made up a name like `lesson49.extra.Main$1`, because you never gave the class one. That's also why an anonymous class **can't be reused**: there's no name to write `new` in front of. If you need the same behavior twice, write a real class.  
- Make a second unusual dog, like Clifford, with a different `speak()`. Each anonymous class belongs to exactly one object.  
- An anonymous class can fill in an **interface** too. `Runnable` is built into Java, and its one method is `public void run()`. You can't write `new Runnable()` by itself (lesson 37: interfaces aren't classes), but you can with a body:  

```java
Runnable task = new Runnable() {
    @Override
    public void run() {
        System.out.println("Running a one-time task");
    }
};
task.run();
```

- Lesson 50's `TimerTask` works exactly this way, and so does lesson 54's `Runnable` for threads.  

---

## 🤖 Part 2 – Robot Code (2 pts)

> **Not written yet.** Lesson 49 was an empty file until the 2026 audit, so it has no robot half or Code Archaeology. It's optional this offseason: **skip Parts 2 and 3 for now.**

---

## 📜 Part 3 – Code Archaeology (2 pts, optional)

> Not written yet. See Part 2.

---

## 🏆 Total Points
- **Max right now:** 2 pts  
  - Java‑Only: 2 pts  
  - Robot Code and Code Archaeology: coming once they're written

---

> 🐝 *"The sting is in the details — master them, and you master the bot."*
