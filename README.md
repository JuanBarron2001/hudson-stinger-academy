# Hudson Stinger Academy

hudson‑stinger‑academy is where we train up FRC rookies and sharpen vets. Hands‑on Java lessons tied to real robot code, so you’re not just watching vids — you’re building skills that stick.

_Learn it. Test it. Break it. Fix it. Own it._ 🐝

---

## 🚀 Start here

1. **Fork this repo** to your own GitHub account, then clone your fork. Don't clone this one directly: your work needs somewhere to live.
2. **Do [Lesson 00](lessons/LESSON00.md).** It sets up your fork, Java, and the robot simulator. Nothing else works until it does.
3. **Read the [Student Guide](docs/STUDENT-GUIDE.md)** once. It covers running a lesson, turning it in, and what to do when something breaks.
4. Work down the **[lesson index](lessons/LESSONS.md)**, aiming for two lessons a week.

Mentors: the **[Mentor Guide](docs/MENTOR-GUIDE.md)** explains how the lessons, the grading logs and the simulator fit together.

---

## 🐝 How it works

The course is **lessons 00–57**. The Java lessons follow a [12-hour YouTube Java course](https://www.youtube.com/watch?v=xTtL8E4LzTQ), and every lesson links the part of the video it covers.

Every lesson teaches one Java idea twice:

- **💻 Java half** — watch the video, follow along, and write a small program in `java-lessons/`.
- **🤖 Robot half** — use the same idea on **last season's robot**. You start by driving a simple tank drive, then rebuild the 2026 robot piece by piece: intake, flywheel, climber, Limelight, and finally the autos. By lesson 57 you're running the whole robot on code you wrote.
- **📜 Code Archaeology** *(optional)* — read the code the team actually competed with and explain a piece of it.

Each half splits into **basic** (everyone does this) and **extra** (the stretch, if the basic felt easy).

**Core vs Optional:** lessons marked *Optional* in the index don't build a piece of the robot. Skip them unless you're ahead.

---

## 🏆 Points

Each lesson is worth **10 points**:

| Part | Basic | Extra | Total |
|---|---|---|---|
| 🤖 Robot code | 3 | 2 | 5 |
| 💻 Java | 2 | 1 | 3 |
| 📜 Code Archaeology *(optional)* | 1 | 1 | 2 |

**Aim for 5 a lesson:** the Java basic and the robot basic. Optional lessons have no robot half, so they're worth the 3 Java points.

Points earned between now and **kickoff** count toward a **prize**. Details are coming.

---

## ✅ How a lesson gets checked

1. **Java:** get your program working, then run it through `LessonRunner`. It runs the basic and extra halves and writes a log file for each, like `lesson07.basic-output.log`.
2. **Robot:** pick the lesson in `PickYourLesson.java`, test it in the **simulator** on your laptop, then deploy it to the real robot at a meeting with Joseph or a veteran. The robot half writes its own log too.
3. **Commit your code and the logs, and push to your fork.** That's the whole submission. The logs show your code actually ran, and your code gets read too.

Lessons that ask questions (anything with a `Scanner`) answer themselves from a file in `java-lessons/resources/`, so the runner never sits waiting for you. Edit that file to try different answers.

The Java lessons have no build file. One `javac` command compiles all of them; it's in [Student Guide §3](docs/STUDENT-GUIDE.md#3-running-a-java-only-lesson).

---

## 🆘 Stuck?

Ask **Joseph** (programming lead) first. If Joseph doesn't know or isn't around, message **Juan** on Teams. When a lesson crashes, the runner tells you which log file to send: the details a mentor needs are at the bottom of it.

---

## 📁 Repo structure

- `lessons/` – the guide for each lesson (`LESSON00.md` … `LESSON57.md`) and the [index](lessons/LESSONS.md)
- `java-lessons/` – the plain-Java exercises and `LessonRunner`
- `robot-code/command-based-bot-2026/` – **this season's robot project** (WPILib 2026). Robot facts like CAN IDs, buttons and speeds are in its [ROBOT.md](robot-code/command-based-bot-2026/ROBOT.md)
- `robot-code/command-based-bot-2025/` – last year's version of the course, kept for reference
- `docs/` – the Student and Mentor Guides
