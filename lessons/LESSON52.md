# 🖥️ Lesson 52 – HashMaps in Java

**Hudson Stinger Academy** – Rookie & Vet Training Series  
_Learn it. Test it. Break it. Fix it. Own it._ 🗂️  

---

## 🎯 Overview
**Keywords:** Java, HashMap, Key-Value Pairs, Collections Framework, Generics  
Learn to:
- Understand that **HashMap** stores data as **key-value pairs**  
- Recognize that **keys must be unique**, but **values can be duplicated**  
- Create a `HashMap<K, V>` with type parameters for key and value  
- Add, update, remove, and retrieve elements  
- Check for existence of keys/values with `containsKey()` and `containsValue()`  
- Iterate through a HashMap with `for-each` loops  

---

## ⏱️ Progress Tracking

### 📊 For the Marathon Watchers  
If you’re following the **full 12‑hour compilation** and want to see how far you’ve made it through the *entire* course:  
- **Start Time in 12‑Hour Video:** [10:52:09](https://www.youtube.com/watch?v=xTtL8E4LzTQ&t=39129s)  
- **Full Course (12h video):** [Watch Compilation](https://www.youtube.com/watch?v=xTtL8E4LzTQ)

---

### 🎯 For the Quick‑Hit Learners  
If you just want **this lesson only** and to be done with it — no scrubbing through hours of footage:  
- **Lesson Playlist:** [Java tutorial for beginners (2025) ☕](https://www.youtube.com/playlist?list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc)  
- **This Lesson Only:** [Watch Lesson 52](https://www.youtube.com/watch?v=NMHk1CGb28o&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=67) (Java hashmaps are easy! 🗺️, 10:31)

---

## 💻 Part 1 – Java‑Only (2 pts)

> The `import` line goes at the **top** of your `Main.java`, and the rest goes **inside** `main`. Keep the `public class Main extends BaseLesson` line your file already has: without `extends BaseLesson`, the lesson runner can't run it.

**Basic (1 pt)**  
- Import `java.util.HashMap`, and create a `HashMap<String, Double>` called `map`: the keys are `String`s and the values are `Double`s.  
- `put` three prices, `"Apple"` at `0.50`, `"Orange"` at `0.75` and `"Banana"` at `0.25`, and print the map.  
- Keys must be unique. `put` `"Orange"` again at `1000000.0` and print the map again. **Predict it first:** is there a second orange?  

Expected output:  

```
{Apple=0.5, Orange=0.75, Banana=0.25}
{Apple=0.5, Orange=1000000.0, Banana=0.25}
```

**Extra (1 pt)**  
- Build the basic half's three prices again, then `put` `"Coconut"` at `1.00` and print the map. Coconut doesn't land at the end: a `HashMap` keeps no order at all, so never count on one.  
- `remove("Apple")` and print the map. Print `get("Coconut")` too.  
- Print `containsKey("Banana")`, `containsKey("Pineapple")`, `containsValue(1.0)` and `containsValue(1)`. Why is the last one `false`? *(Hint: `1` is an `Integer`, not a `Double`, lesson 43.)*  
- Use `containsKey` the way the video does, before you `get`: if the map has `"Pineapple"`, print its price, and otherwise print `Key not found`.  
- Print `size()`.  
- Print every pair with `for (String key : map.keySet())`: the key, then `: $`, then its price.  

Expected output:  

```
{Apple=0.5, Coconut=1.0, Orange=0.75, Banana=0.25}
{Coconut=1.0, Orange=0.75, Banana=0.25}
1.0
true
false
true
false
Key not found
3
Coconut: $1.0
Orange: $0.75
Banana: $0.25
```

---

## 🤖 Part 2 – Robot Code: the 2026 Robot (2 pts)

Your code goes in `robot-code/command-based-bot-2026/src/main/java/frc/lesson/lesson52/basic/Lesson52.java` (and `extra/Lesson52.java`). The task list is at the top of each file.  
Run it in the simulator the way you did in [Lesson 00](./LESSON00.md).

**Basic (1 pt)**: calling a command by its name  

[Lesson 38](./LESSON38.md) put commands in a dropdown. This one puts them in a phone book.

Here is the problem a `HashMap` actually solves on a robot. **PathPlanner autos are drawn in an app, not written in Java.** In that app you place a step called `"Intake"`. The app has never heard of your `Intake` class — it only knows the **word**. Something has to turn that word into the real command, and that something is a `Map<String, Command>`.

- Write a small command you can make several of: `FuelFor(fuel, label, rollers, belt)` runs the two motors at whatever numbers you hand it.  
- Build the map:  

```java
Map<String, Command> actions = new HashMap<>();
actions.put("Intake", new FuelFor(fuel, "Intake", -0.7, 0.8));
actions.put("Eject",  new FuelFor(fuel, "Eject",   0.9, 0.8));
actions.put("Shoot",  new FuelFor(fuel, "Shoot",  -0.72, -0.7));
```

- Publish `actions.size()` and `actions.keySet()`. Put a `Lookup` string on the dashboard, call `actions.get(wanted)` each loop, and run whatever came back while the operator holds **B**.  
- Change `Lookup` in the NetworkTables window between the three names and hold **B** each time. Measured: **−67.9**, **+87.3** and **−69.9 RPS**. You are choosing robot behaviour **by typing a word.**  
- 🧪 **The experiment:** set `Lookup` to `"Intkae"` — a plain typo — and hold **B**. **Predict first.** `get()` returns `null`, `found` is false, and **nothing happens at all.** No error. No crash.  

> 📖 **Why a map and not an if-chain?** You could write `if (wanted.equals("Intake"))` three times. Then the fourth action means editing that chain, and the tenth means reading twenty lines to find out what even exists. A map's `keySet()` **is** the list of what exists, and adding one is one line.

**Extra (1 pt)**: hand your map to PathPlanner, then check it before the match  

Your map and PathPlanner's are the same idea, and PathPlanner will take yours **whole**:

```java
NamedCommands.registerCommands(actions);     // it takes a Map<String, Command>
```

That single line is why you built a map instead of an if-chain. The library's API *is* a map, because the problem *is* a map.

- Now write the check the basic half's typo was asking for. PathPlanner can tell you whether a name is registered: `NamedCommands.hasCommand("Intake")`.  
- Make a list of every name your autos actually use — `"Intake"`, `"Eject"`, `"Shoot"`, `"ClimbUp"` — and publish `hasCommand()` for each at startup. 🧪 **Predict all four.**  

```
Intake   true
Eject    true
Shoot    true
ClimbUp  FALSE   <- the auto needs it, and nobody ever registered it
```

- Publish one summary boolean, `Autos/All Names Registered`, true only if every name passed. **That single value is the thing a mentor can check in two seconds before a match.**  
- Add a climb command to the map and watch it flip to true.  

> 🚨 **Why this is the most useful code in the unit.** A missing named command doesn't crash anything. PathPlanner just **skips that step** — the robot drives its path, does nothing where the intake should have been, and everybody spends the afternoon arguing about the intake hardware. Six lines at startup turns that into a red boolean on the dashboard.

> 🔁 **Look at what you have now seen three times.** [Lesson 34](./LESSON34.md)'s tuning slider that was never published. [Lesson 38](./LESSON38.md)'s dropdown with no name. And now a named command with nothing behind it. The same failure every time: the code is fine, and a human finds out too late. **This time you wrote the thing that tells them.**

> 🧮 **One more map, if you want it.** Keys don't have to be `String`s. A `Map<Double, Double>` of distance → roller speed is [Lesson 26](./LESSON26.md)'s shot table again. Work out why that one is *awkward* as a map — what happens at a distance that isn't a key? — and what lesson 26's closest-row loop was really doing for you.

---

## 📜 Part 3 – Code Archaeology (2 pts, optional)

**Basic (1 pt)**: match the app against the code  
- In [`OG-Code-2026`](https://github.com/Hudson-Robotics/OG-Code-2026) (branch `Pre-DCMP-Flywheel`), `RobotContainer.java` lines 77–80 register four named commands: `Intake`, `Shoot`, `ClimbUp`, `ClimbDown`.  
- Now open the **auto file itself**: `src/main/deploy/pathplanner/autos/PP Depot And Climb.auto`. It's JSON — a file drawn by an app, committed next to the code. Search it for `"type": "named"`.  
- You'll find four, each with a `"name"`. **Check every one against the registered list.** (They match, this time. Confirm it yourself rather than taking my word for it.)  
- Then answer the real question: **what in this repository would have told anybody if they didn't match?** Nothing does. You wrote the missing check in the extra half.  

**Extra (1 pt)**: the registration order that matters  
- Read the comment above line 77: *"Register named commands for PathPlanner autos BEFORE building any auto."*  
- Then find line 90, where `AutoBuilder.buildAuto("PP Depot And Climb")` runs — in the same constructor, thirteen lines later.  
- Work out why the order matters, and what `buildAuto` must be doing with the map at that moment. Would moving the `registerCommand` calls into `configureBindings()` break it? Read carefully before answering.  
- That comment is a **warning left by somebody who got it wrong once.** It's the most valuable kind of comment in the whole repository, and it's four words long. Find one more like it while you're in there.  

---

## 🏆 Total Points
- **Max:** 6 pts  
  - Java‑Only: 2 pts  
  - Robot Code: 2 pts  
  - Code Archaeology: 2 pts *(optional)*  

---

<!-- Drafting notes from the transcript draft. Hidden from students.
Ideas:  
- Emphasize HashMap = key-value pairs, unique keys, duplicate values allowed.  
- Robot code: store subsystem states or motor powers.  
- Archaeology: replace scattered variables with HashMaps.  
- Segue: Next lesson → **LinkedHashMap & TreeMap** (ordered maps).  
-->
