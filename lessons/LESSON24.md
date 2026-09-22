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

## 🤖 Part 2 – Robot Code: the 2026 Robot (2 pts)

Your code goes in `robot-code/command-based-bot-2026/src/main/java/frc/lesson/lesson24/basic/Lesson24.java` (and `extra/Lesson24.java`). The task list is at the top of each file.  
Run it in the simulator the way you did in [Lesson 00](./LESSON00.md). CAN IDs, inversions and buttons are in [ROBOT.md](../robot-code/command-based-bot-2026/ROBOT.md).

**Basic (1 pt)**: is that CAN ID on the robot?  
- Start from lesson 22's array: `int[] canIds = {1, 2, 3, 4, 5, 6, 7, 29};`.  
- Pick an `int target = 29;` and search the array with this lesson's loop: when `canIds[i] == target`, remember the index and `break`. The array never changes, so do the search **once in `setup()`** and store the answer in a field.  
- In `execute()`, put the answer on SmartDashboard: `"CAN 29 found at index 7"`.  
- Add the `boolean isFound` flag. After the loop, `if (!isFound)`, put `"CAN <target> is not on this robot"` instead.  
- Now set `target = 8` and run it again. There is no CAN 8 on this robot, which is exactly the case the flag is for. Without it, the dashboard just says nothing, and you can't tell "not found" from "my code never ran".  

**Extra (1 pt)**: search by mechanism name  
- Add a `String[] mechanisms` in the **same order** as `canIds`:  
  `{"left drive", "right drive", "left drive follower", "right drive follower", "left roller", "right roller", "climber", "conveyor"}`.  
- Search it with `mechanisms[i].equals(target)`, **not** `==`, for a name like `"conveyor"`.  
- The index is what links the two arrays: once you've found the name at index `i`, `canIds[i]` is that mechanism's CAN ID. Put both on SmartDashboard.  
- Let the operator pick the target, the way the Java half let the user type it: **B** → `"conveyor"`, **A** → `"climber"`, **X** → `"left drive"`. At home the operator is Keyboard 1, so those are the **6**, **5** and **7** keys.  
- Because the target now changes while the robot is running, the search moves out of `setup()` and into `execute()`. Search for a name that isn't in the array, like `"shooter"`, and check you still get the not-found message.  
- Build a `TalonFX[]` from `canIds` the way you did in lesson 22, and publish the found motor's rotations. Search for `"left drive"`, hold **W** to drive, and watch the number you searched for move.  

---

## 📜 Part 3 – Code Archaeology (2 pts, optional)

> *Optional: skip this part if you're short on time.* Last season's code is [`Hudson-Robotics/OG-Code-2026`](https://github.com/Hudson-Robotics/OG-Code-2026), branch **`Pre-DCMP-Flywheel`**.

**Basic (1 pt)**: find the search that doesn't look like one  
- Open `VisionSubsystem.getPoseEstimate()`. It loops over `estimate.rawFiducials` and, the moment one tag's `ambiguity` is above `MAX_AMBIGUITY` (0.2), it stops and returns `null`.  
- That is this lesson's search, with two changes: the early exit is a `return` instead of a `break`, and there is no `isFound` flag, because returning *is* the answer. Explain both in a comment.  
- What does the method return when the camera sees no tags at all? Find the line that decides it.  

**Extra (1 pt)**: which loops can't stop early  
- A few lines below, `getVisibleTags()` and `getAvgTagDistance()` also loop over a `RawFiducial[]`, but neither one ever exits early. Why can't they? Say what each loop is actually doing with the array.  
- `break` appears **zero times** in the whole competition code (`LimelightHelpers.java` included, and that file isn't even ours). Is that a bug, a style, or just what the code happened to need?  
- How would you change `getVisibleTags()` to find one specific tag, say tag 7, and stop looking once it had it?  

---

## 🏆 Total Points
- **Max:** 6 pts  
  - Java‑Only: 2 pts  
  - Robot Code: 2 pts  
  - Code Archaeology: 2 pts *(optional)*

---

> 🐝 *"The sting is in the details — master them, and you master the bot."*
