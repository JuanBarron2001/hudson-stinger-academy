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
- **Start Time in 12‑Hour Video:** [blank]  
- **Full Course (12h video):** [link here]  

---

### 🎯 For the Quick‑Hit Learners  
- **Lesson Playlist:** [link here]  
- **This Lesson Only:** [link here]  

---

## 💻 Part 1 – Java‑Only (2 pts)

**Basic (1 pt)**  
- Create an abstract parent class `Animal` with an abstract method `speak()`.  

[CODE BLOCK]java
public abstract class Animal {
    abstract void speak();
}
[CODE BLOCK]

- Create child classes `Dog` and `Cat` that override `speak()`.  

[CODE BLOCK]java
public class Dog extends Animal {
    @Override
    void speak() {
        System.out.println("The dog goes woof");
    }
}

public class Cat extends Animal {
    @Override
    void speak() {
        System.out.println("The cat goes meow");
    }
}
[CODE BLOCK]

**Extra (1 pt)**  
- Use **runtime polymorphism** with user input:  

[CODE BLOCK]java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Would you like a pet? (1 = Dog, 2 = Cat): ");
        int choice = scanner.nextInt();

        Animal animal; // declared as parent type

        if (choice == 1) {
            animal = new Dog();
        } else {
            animal = new Cat();
        }

        // Runtime polymorphism: JVM decides which speak() to call
        animal.speak();

        scanner.close();
    }
}
[CODE BLOCK]

- Output:  
  - Input `1` → `The dog goes woof`  
  - Input `2` → `The cat goes meow`  

---

## 🤖 Part 2 – Robot Code (2 pts)

**Basic (1 pt)**  
- Create an abstract class `Subsystem` with an abstract method `run()`.  
- Create child classes `DriveTrain` and `Arm` that override `run()`.  

**Extra (1 pt)**  
- Use runtime polymorphism to decide which subsystem to activate based on user input.  
- Print results to **SmartDashboard**.  

[CODE BLOCK]java
public abstract class Subsystem {
    abstract void run();
}

public class DriveTrain extends Subsystem {
    @Override
    void run() {
        SmartDashboard.putString("DriveTrain", "Driving forward");
    }
}

public class Arm extends Subsystem {
    @Override
    void run() {
        SmartDashboard.putString("Arm", "Lifting object");
    }
}

// Example runtime decision
Scanner scanner = new Scanner(System.in);
System.out.print("Choose subsystem (1 = DriveTrain, 2 = Arm): ");
int choice = scanner.nextInt();

Subsystem subsystem;
if (choice == 1) {
    subsystem = new DriveTrain();
} else {
    subsystem = new Arm();
}
subsystem.run();
scanner.close();
[CODE BLOCK]

---

## 📜 Part 3 – Code Archaeology (2 pts)

**Basic (1 pt)**  
- Find a section of last year’s robot code where different subsystems were manually selected with `if`/`else` blocks.  
- Suggest replacing them with **runtime polymorphism**: declare a parent type, assign it to the chosen child, and call the method.  

**Extra (1 pt)**  
- Suggest improvements:  
  - Replace repeated `if`/`else` calls with polymorphic behavior.  
  - Example: `Subsystem subsystem = new DriveTrain(); subsystem.run();`  
  - This makes the code more scalable when adding new subsystems.  

[CODE BLOCK]java
Subsystem[] subsystems = { new DriveTrain(), new Arm() };

for (Subsystem s : subsystems) {
    s.run(); // dynamic dispatch
}
[CODE BLOCK]

---

## 🏆 Total Points
- **Max:** 6 pts  
  - Java‑Only: 2 pts  
  - Robot Code: 2 pts  
  - Code Archaeology: 2 pts  

---

[CODE BLOCK]LOG  
Ideas:  
- Emphasize runtime polymorphism = method chosen at runtime, not compile time.  
- Robot code: subsystems selected dynamically based on input.  
- Archaeology: replace rigid `if`/`else` with polymorphic design.  
- Segue: Next lesson → **Casting & instanceof** (downcasting objects, type checks).  
[CODE BLOCK]
