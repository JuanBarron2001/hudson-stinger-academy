# 🖥️ Lesson 44 – ArrayLists in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 📚  

---

## 🎯 Overview
**Keywords:** Java, ArrayList, Collections Framework, Autoboxing, Dynamic Arrays  
Learn to:
- Understand that **ArrayLists** are resizable arrays that store **objects**  
- Use **wrapper classes** (Integer, Double, etc.) to store primitives via **autoboxing**  
- Add, remove, set, and get elements dynamically  
- Use `Collections.sort()` to sort ArrayLists  
- Iterate through ArrayLists with **enhanced for loops**  
- Accept **user input** to populate an ArrayList  

---

## ⏱️ Progress Tracking

### 📊 For the Marathon Watchers  
If you’re following the **full 12‑hour compilation** and want to see how far you’ve made it through the *entire* course:  
- **Start Time in 12‑Hour Video:** [08:55:51](https://www.youtube.com/watch?v=xTtL8E4LzTQ&t=32151s)  
- **Full Course (12h video):** [Watch Compilation](https://www.youtube.com/watch?v=xTtL8E4LzTQ)

---

### 🎯 For the Quick‑Hit Learners  
If you just want **this lesson only** and to be done with it — no scrubbing through hours of footage:  
- **Lesson Playlist:** [Java tutorial for beginners (2025) ☕](https://www.youtube.com/playlist?list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc)  
- **This Lesson Only:** [Watch Lesson 44](https://www.youtube.com/watch?v=wsTSREgCE5E&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=56) (Learn Java arraylists in 9 minutes! 📃, 9:40)

---

## 💻 Part 1 – Java‑Only (2 pts)

**Basic (1 pt)**  
- Import the class at the top of the file: `import java.util.ArrayList;`  
- Create an `ArrayList<Integer>` called `numbers` with `new ArrayList<>()`, add `3`, `1` and `2` with `add(...)`, and print the list. It's `Integer`, not `int`: an `ArrayList` holds objects, so Java autoboxes each number, like lesson 43.  
- Create an `ArrayList<String>` called `fruits`, add `"Apple"`, `"Orange"`, `"Banana"` and `"Coconut"`, and print it.  

Expected output:  

```
[3, 1, 2]
[Apple, Orange, Banana, Coconut]
```

**Extra (1 pt)**  
- Starting from the basic half's `fruits`:  
  - `remove(0)` takes out the item at index 0, `Apple`, and everything after it moves up one  
  - `set(0, "Pineapple")` replaces whatever is at index 0 now. **Predict which fruit that is.**  
  - print `get(1)` and `size()`  
- Add `import java.util.Collections;` at the top, then call `Collections.sort(fruits);` in `main` and print the list.  
- Print every fruit on its own line with an enhanced `for` loop.  
- **The video's exercise, a food list from user input:**  
  - Create an empty `ArrayList<String> foods` and a `Scanner`.  
  - Ask `Enter the number of food you would like: ` and read it with `nextInt()`, then call `scanner.nextLine()` once to clear the leftover new line (lesson 03).  
  - Loop that many times, asking `Enter food #1: `, `Enter food #2: ` and so on, and `add(...)` each answer to `foods`.  
  - Print the whole list. Unlike lesson 23's array, you never had to pick its size up front.  

Expected output, answering `2`, `pizza` and `tacos`:  

```
Banana
3
[Banana, Coconut, Pineapple]
Banana
Coconut
Pineapple
Enter the number of food you would like: 2
Enter food #1: pizza
Enter food #2: tacos
[pizza, tacos]
```

---

## 🤖 Part 2 – Robot Code: the 2026 Robot (2 pts)

Your code goes in `robot-code/command-based-bot-2026/src/main/java/frc/lesson/lesson44/basic/Lesson44.java` (and `extra/Lesson44.java`). The task list is at the top of each file.  
Run it in the simulator the way you did in [Lesson 00](./LESSON00.md). This half needs `getPose()` from [Lesson 40](./LESSON40.md).

**Basic (1 pt)**: which tags are near me right now?  

[Lesson 22](./LESSON22.md) gave you an array of CAN IDs. An array is the right shape when you know the count and it never changes: this robot has eight motors, forever.

*"Which AprilTags are within range of the robot"* is not that. It's four tags, then six, then five, changing every loop as you drive. **You cannot size an array for that.**

> 📷 **Good news: this one needs no camera.** The 2026 field layout ships inside WPILib — all **32 tags** with their real positions — and lesson 40 gave you a pose. Where you *think* you are, plus where the tags *actually* are, is enough to do something real in the simulator.

- Load the field in `setup()` and publish how many tags it has:  

```java
field = AprilTagFields.k2026RebuiltWelded.loadAprilTagLayoutField();
SmartDashboard.putNumber("Field/Total Tags", field.getTags().size());   // 32
```

- Reset your pose so you start somewhere known: `drivetrain.resetPose(new Pose2d());`  
- In `execute()`, build the list of tags close to you:  

```java
List<AprilTag> inRange = new ArrayList<>();
for (AprilTag tag : field.getTags()) {
    double dx = tag.pose.getX() - me.getX();
    double dy = tag.pose.getY() - me.getY();
    if (Math.hypot(dx, dy) < 4.0) {
        inRange.add(tag);
    }
}
```

- Publish `inRange.size()` and a string of the IDs, then drive. 🧪 **Predict what the count does as you go forward.** Hold **W** and watch.  

Driving straight up the field you get something like:

```
x=0.67 m: 4 tags  (28 29 30 31)
x=2.40 m: 5 tags  (17 27 28 29 30)
x=3.26 m: 6 tags  (17 18 27 28 29 30)
x=4.12 m: 5 tags  (17 18 19 27 28)
```

The list grows, shrinks and swaps members, and **you never once said how big it is.**

> 🧮 **Two shapes, and why picking wrong costs you an evening.** `field.getTags()` is 32 tags, fixed, known before the match — array-shaped. `inRange` changes every loop — list-shaped. An array here would mean guessing a maximum *and* separately tracking how many slots are really filled, which is precisely the bug you'd spend a night hunting.

**Extra (1 pt)**: the rest of the list, and one question about nothing  

- Use the methods an array doesn't have: `isEmpty()`, `size()`, `contains(...)`, `get(0)`.  
- `contains()` compares with `equals()`, and `AprilTag` has one — but `inRange.contains(new AprilTag(18, field.getTagPose(18).get()))` is a mouthful. Write a small helper that loops and checks `tag.ID` instead, and note in a comment which you'd rather read at 1am.  
- Sort nearest-first so `get(0)` means *the closest tag*: `inRange.sort(Comparator.comparingDouble(t -> distanceTo(t)));` — that's a lambda, promised since [Lesson 32](./LESSON32.md). Copy the pattern for now; [Lesson 56](./LESSON56.md) explains it. Publish the closest tag's ID and distance.  
- 🧪 **The crash.** Publish `inRange.get(0).ID` **without** checking `isEmpty()` first, then drive to a corner until nothing is in range. **Predict what happens.** You get an `IndexOutOfBoundsException` and the lesson dies mid-match. Fix it with `isEmpty()`.  
- **Now the design question this lesson is really about.** When nothing is in range, what should your method hand back?  
  **(a)** an empty list  **(b)** `null`  **(c)** a stand-in value like `-1`  

**Write your answer down before you read Part 3**, because last season's code picked **(a)** in one method and **(c)** in another, about ten lines apart.

> ✅ **Why an empty list is usually right:** a caller can loop over it and get zero iterations — correct, with no special case. Loop over `null` and you crash. And `-1` isn't a list at all, so every caller has to remember a magic number that means "nothing". One day somebody won't.

---

## 📜 Part 3 – Code Archaeology (2 pts, optional)

**Basic (1 pt)**: you just wrote their method  
- Open `getVisibleTags()` in `src/main/java/frc/robot/subsystems/VisionSubsystem.java` ([`OG-Code-2026`](https://github.com/Hudson-Robotics/OG-Code-2026), branch `Pre-DCMP-Flywheel`). Read it next to your own code.  
- It is the same four moves: start with an empty `ArrayList<AprilTag>`, loop over something fixed, `add()` the ones that pass a check, return the list.  
- The interesting difference is **where the fixed thing comes from**. Theirs loops over `RawFiducial[]` — an **array**, handed over by the Limelight, because the camera knows exactly how many tags it saw this frame. Yours loops over the whole 32-tag field. Both convert a fixed array into a list that grows.  
- So write down the rule you'd give a rookie: **when does data arrive as an array, and when do you build a list from it?**  

**Extra (1 pt)**: two answers to "nothing", ten lines apart  
- `getVisibleTags()` returns an **empty list** when the camera sees nothing — answer (a), and it even has an early `return tags;` to do it deliberately.  
- Scroll down to `getAvgTagDistance()`. Same file, same situation, and it returns **`-1`** — answer (c).  
- Find every caller of `getAvgTagDistance()` and check: **does each one remember that `-1` means "no tags"?** What happens to `Math.abs(dist - targetDistanceInches)` if one forgets?  
- Both methods were written by the same people on the same day. Neither is a typo. Write down why you think the shapes diverged, then say which one you'd make the other one match, and what that change would cost.  

---

## 🏆 Total Points
- **Max:** 6 pts  
  - Java‑Only: 2 pts  
  - Robot Code: 2 pts  
  - Code Archaeology: 2 pts *(optional)*  

---

<!-- Drafting notes from the transcript draft. Hidden from students.
Ideas:  
- Emphasize ArrayLists = resizable arrays.  
- Robot code: store motor speeds or sensor readings dynamically.  
- Archaeology: replace fixed arrays with ArrayLists for flexibility.  
- Segue: Next lesson → **For‑Each Loops with ArrayLists** (iterating collections more efficiently).  
-->
