# 🖥️ Lesson 43 – Wrapper Classes in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🎁  

---

## 🎯 Overview
**Keywords:** Java, Wrapper Classes, Autoboxing, Unboxing, Utility Methods, Parsing  
Learn to:
- Understand **wrapper classes**: objects that wrap primitive values (int → Integer, double → Double, etc.)  
- Recognize when wrapper classes are needed (e.g., **Collections Framework** like `ArrayList`)  
- Use **autoboxing** (automatic conversion from primitive → wrapper)  
- Use **unboxing** (automatic conversion from wrapper → primitive)  
- Apply **static utility methods** from wrapper classes (`toString()`, `parseXxx()`, `isLetter()`, etc.)  

---

## ⏱️ Progress Tracking

### 📊 For the Marathon Watchers  
If you’re following the **full 12‑hour compilation** and want to see how far you’ve made it through the *entire* course:  
- **Start Time in 12‑Hour Video:** [08:45:17](https://www.youtube.com/watch?v=xTtL8E4LzTQ&t=31517s)  
- **Full Course (12h video):** [Watch Compilation](https://www.youtube.com/watch?v=xTtL8E4LzTQ)

---

### 🎯 For the Quick‑Hit Learners  
If you just want **this lesson only** and to be done with it — no scrubbing through hours of footage:  
- **Lesson Playlist:** [Java tutorial for beginners (2025) ☕](https://www.youtube.com/playlist?list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc)  
- **This Lesson Only:** [Watch Lesson 43](https://www.youtube.com/watch?v=5bt07czziV4&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=55) (Learn WRAPPER CLASSES in 10 minutes! 🎁, 10:36)

---

## 💻 Part 1 – Java‑Only (2 pts)

**Basic (1 pt)**  
- Wrapping primitives the old way. **Just read this one, don't type it:** these constructors are deprecated, and Java now warns that they'll be removed. It's the clearest picture of what "wrapping" means, though: the number goes inside an object.  

```java
Integer a = new Integer(123);     // int → Integer
Double b = new Double(3.14);      // double → Double
Character c = new Character('$'); // char → Character
Boolean d = new Boolean(true);    // boolean → Boolean
```

- The modern way is **autoboxing**, and this one you type. Make the same four variables, `Integer a`, `Double b`, `Character c` and `Boolean d`, with the same four values, but assign each value straight to its variable with no `new`. Java wraps each one for you.  
- Print all four. They look like plain values, but each one is an object now.  

Expected output:  

```
123
3.14
$
true
```

**Extra (1 pt)**  
- **Unboxing** goes the other way: assign each wrapper straight to a primitive, `int x = a;` and so on for `double`, `char` and `boolean`. Print all four on one line.  
- **Primitive → `String`:** make four `String`s with `Integer.toString(123)`, `Double.toString(3.14)`, `Character.toString('$')` and `Boolean.toString(false)`. Print all four added together. **Predict it first.** You get one long `String`, because every piece is a `String` now.  
- **`String` → primitive:** `Integer.parseInt("123")`, `Double.parseDouble("3.14")` and `Boolean.parseBoolean("true")`. There's no `Character.parseChar`, so take the first letter of a `String` instead, with `"pizza".charAt(0)`. Add the parsed `int` and `double` together: they're numbers now, so they add up instead of sticking together. Then print the `boolean` and the `char`.  
- **Character checks:** print `Character.isLetter('b')`, `Character.isLetter('$')` and `Character.isUpperCase('b')`. Checks like these are how you'd validate a username or password.  

Expected output:  

```
123 3.14 $ true
1233.14$false
126.14
true p
true
false
false
```

---

## 🤖 Part 2 – Robot Code (2 pts)

> **Not written yet.** Lesson 43 is **optional** this offseason, so its robot half was never rewritten for the 2026 robot. What used to be here was a 2025 draft describing hardware this robot doesn't have, so it has been taken out rather than left to send you down a dead end. **Skip Parts 2 and 3 for now.**
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
- Emphasize wrapper classes = objects for primitives.  
- Robot code: ArrayLists require wrapper classes.  
- Archaeology: replace invalid primitive collections with wrapper equivalents.  
- Segue: Next lesson → **ArrayLists** (dynamic arrays that only work with objects).  
-->
