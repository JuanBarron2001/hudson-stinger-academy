# 🖥️ Lesson 25 – Variable Arguments (Varargs) in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🐝

---

## 🎯 Overview
**Keywords:** Java, Varargs, Variable Arguments, Arrays, Enhanced For Loop, Method Flexibility  
Learn to:
- Understand **variable arguments (varargs)** in Java  
- Replace multiple overloaded methods with a single flexible method  
- Use the `...` (ellipsis) syntax to accept any number of arguments  
- Recognize that varargs are treated as arrays inside the method  
- Apply varargs to create methods like `add()` and `average()`  

---

## ⏱️ Progress Tracking

### 📊 For the Marathon Watchers  
If you’re following the **full 12‑hour compilation** and want to see how far you’ve made it through the *entire* course:  
- **Start Time in 12‑Hour Video:** [05:28:07](https://www.youtube.com/watch?v=xTtL8E4LzTQ&t=19687s)  
- **Full Course (12h video):** [Watch Compilation](https://www.youtube.com/watch?v=xTtL8E4LzTQ)

---

### 🎯 For the Quick‑Hit Learners  
If you just want **this lesson only** and to be done with it — no scrubbing through hours of footage:  
- **Lesson Playlist:** [Java tutorial for beginners (2025) ☕](https://www.youtube.com/playlist?list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc)  
- **This Lesson Only:** [Watch Lesson 25](https://www.youtube.com/watch?v=2knxgAFqwKk&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=34) (Learn VARARGS in 6 minutes! 💬, 6:30)

---

## 💻 Part 1 – Java‑Only (2 pts)

**Basic (1 pt)**  
- Create a method `add(int... numbers)` that sums any number of integers. One method replaces all the `add` overloads you wrote in lesson 20.  
- Java packs the arguments into an array called `numbers`. Print `numbers.length` inside `add` to see how many arrived.  

```java
static int add(int... numbers) {
    int sum = 0;
    for (int number : numbers) {
        sum += number;
    }
    return sum;
}

public static void main(String[] args) {
    System.out.println(add(1, 2, 3));       // 6
    System.out.println(add(5, 10, 15, 20)); // 50
}
```

**Extra (1 pt)**  
- Create a method `average(double... numbers)` that calculates the average.  
- Handle the case when no arguments are passed (avoid division by zero).  

```java
static double average(double... numbers) {
    if (numbers.length == 0) {
        return 0;
    }
    double sum = 0;
    for (double number : numbers) {
        sum += number;
    }
    return sum / numbers.length;
}

public static void main(String[] args) {
    System.out.println(average(2, 3, 4, 5)); // 3.5
    System.out.println(average());           // 0.0
}
```

---

## 🤖 Part 2 – Robot Code (2 pts)

> **Not written yet.** Lesson 25 is **optional** this offseason, so its robot half was never rewritten for the 2026 robot. What used to be here was a 2025 draft describing hardware this robot doesn't have, so it has been taken out rather than left to send you down a dead end. **Skip Parts 2 and 3 for now.**
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
- Show how varargs simplify code compared to overloaded methods.  
- Robot code: varargs for motor speeds or sensor logging.  
- Archaeology: replace multiple overloads with a single varargs method.  
- Segue: Next lesson could cover **2D arrays** or **ArrayLists**, since varargs naturally connect to collections.  
-->
