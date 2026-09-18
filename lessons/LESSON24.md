# 🖥️ Lesson 24 – Searching an Array in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🐝

---

## 🎯 Overview
**Keywords:** Java, Arrays, Linear Search, For Loop, break, Boolean Flag, Not Operator, equals, Scanner  
Learn to:
- Search an array one element at a time (a **linear search**)  
- Stop searching as soon as you find it, with `break`  
- Use a `boolean` flag and `!` to say "not found"  
- Search an array of `String`s with `.equals()`, and know why `==` doesn't work there  
- Search for something the user types in  

---

## ⏱️ Progress Tracking

### 📊 For the Marathon Watchers  
If you’re following the **full 12‑hour compilation** and want to see how far you’ve made it through the *entire* course:  
- **Start Time in 12‑Hour Video:** [05:20:38](https://www.youtube.com/watch?v=xTtL8E4LzTQ&t=19238s)  
- **Full Course (12h video):** [Watch Compilation](https://www.youtube.com/watch?v=xTtL8E4LzTQ)

---

### 🎯 For the Quick‑Hit Learners  
If you just want **this lesson only** and to be done with it — no scrubbing through hours of footage:  
- **Lesson Playlist:** [Java tutorial for beginners (2025) ☕](https://www.youtube.com/playlist?list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc)  
- **This Lesson Only:** [Watch Lesson 24](https://www.youtube.com/watch?v=EB9-OOnCthg&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=33) (How to SEARCH an ARRAY easy! 🔎, 7:30)

---

## 💻 Part 1 – Java‑Only (2 pts)

**Basic (1 pt)**: search an array of numbers  
- Create an array of numbers, like `int[] numbers = {1, 9, 2, 8, 3, 7, 4};`, and an `int target = 2;`.  
- Loop through the array with a `for` loop that stops at `numbers.length`.  
- Inside the loop, `if (numbers[i] == target)`, print `"Element found at index " + i` and then `break`. Once you've found it, there's no reason to keep looking.  
- Search for a number that isn't in the array, like `5`. Nothing prints at all. That's the next fix:  
  - Before the loop, create `boolean isFound = false;`. Set it to `true` when you find the target.  
  - After the loop, `if (!isFound)`, print `"Element not found in the array"`.  

**Extra (1 pt)**: search an array of words  
- Create `String[] fruits = {"apple", "orange", "banana"};` and search it for `"orange"` the same way.  
- Compare with `fruits[i].equals(target)`, **not** `==`. A `String` is a reference type (lesson 02's IOU), so `==` asks whether two strings sit at the same memory address, not whether they have the same letters.  
- Now let the user pick: use a `Scanner` to ask `"Enter a fruit to search for: "` and read the target with `nextLine()`.  
- Search for `"banana"`, then for `"coconut"`, and check you get the right message each time.  

---

## 🤖 Part 2 – Robot Code (2 pts)

> **Not written yet.** This lesson's robot half and Code Archaeology were drafted for the wrong topic (a copy of lesson 23's), and haven't been rewritten for searching an array. Lesson 24 is optional this offseason: **skip Parts 2 and 3 for now.**

---

## 📜 Part 3 – Code Archaeology (2 pts, optional)

> Not written yet. See Part 2.

---

## 🏆 Total Points
- **Max right now:** 2 pts  
  - Java‑Only: 2 pts  
  - Robot Code and Code Archaeology: coming back once they're written for this topic

---

> 🐝 *"The sting is in the details — master them, and you master the bot."*
