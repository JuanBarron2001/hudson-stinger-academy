# 🖥️ Lesson 20 – Overloaded Methods in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🐝

---

## 🎯 Overview
**Keywords:** Java, Overloaded Methods, Method Signature, Parameters, Arguments, Reusability  
Learn to:
- Understand what overloaded methods are  
- Recognize that a **method signature** = method name + parameter list  
- Write multiple methods with the same name but different parameters  
- Use overloaded methods for flexibility (e.g., math operations, pizza builder)  
- Avoid duplicate signatures (which cause compile errors)  

---

## ⏱️ Progress Tracking

### 📊 For the Marathon Watchers  
If you’re following the **full 12‑hour compilation** and want to see how far you’ve made it through the *entire* course:  
- **Start Time in 12‑Hour Video:** [04:19:51](https://www.youtube.com/watch?v=xTtL8E4LzTQ&t=15591s)  
- **Full Course (12h video):** [Watch Compilation](https://www.youtube.com/watch?v=xTtL8E4LzTQ)

---

### 🎯 For the Quick‑Hit Learners  
If you just want **this lesson only** and to be done with it — no scrubbing through hours of footage:  
- **Lesson Playlist:** [Java tutorial for beginners (2025) ☕](https://www.youtube.com/playlist?list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc)  
- **This Lesson Only:** [Watch Lesson 20](https://www.youtube.com/watch?v=nhnAx79gxCM&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=27) (Learn Java overloaded methods in 6 minutes! 🍕, 6:08)

---

## 💻 Part 1 – Java‑Only (2 pts)

**Basic (1 pt)**  
- Create an `add` method that takes two `double` parameters and returns their sum.  
- Call it with `1` and `2` → output should be `3.0` (it's a `double`).  
- Write a **second** method with the exact same line, `static double add(double a, double b)`, and run it. Read the error, then delete the copy. The name plus the parameter list is the method's **signature**, and no two methods can share one.  

**Extra (1 pt)**  
- Overload the `add` method to accept three and four parameters.  
- Call each version and print results.  
- Demonstrate that methods with the same name but different parameter lists are valid.  
- **Pizza**, the video's second example. Write three overloads of `static String bakePizza(...)`:  
  - `bakePizza(String bread)` returns `bread + " pizza"`  
  - `bakePizza(String bread, String cheese)` returns `cheese + " " + bread + " pizza"`  
  - `bakePizza(String bread, String cheese, String topping)` returns `topping + " " + cheese + " " + bread + " pizza"`  
  - Call all three. Java picks the one whose parameters match: `bakePizza("flatbread", "mozzarella", "pepperoni")` gives `"pepperoni mozzarella flatbread pizza"`.  

---

## 🤖 Part 2 – Robot Code (2 pts)

> **Not written yet.** Lesson 20 is **optional** this offseason, so its robot half was never rewritten for the 2026 robot. What used to be here was a 2025 draft describing hardware this robot doesn't have, so it has been taken out rather than left to send you down a dead end. **Skip Parts 2 and 3 for now.**
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
- Math example (`add`) → simple intro to overloading.  
- Pizza example → fun, real‑world analogy.  
- Robot code: overloaded methods for motor control.  
- Archaeology: replace multiple similar methods with one overloaded method.  
- Segue: Next lesson could cover **variable scope** or **access modifiers**.  
-->
