# 🤖 The 2026 Robot — Fact Sheet

Everything you need to program the 2026 robot, in one place. Every robot lesson this offseason uses these numbers.

Everything here was read out of the code the team competed with: [`Hudson-Robotics/OG-Code-2026`](https://github.com/Hudson-Robotics/OG-Code-2026), branch `Pre-DCMP-Flywheel`. You don't need to open that code to do a lesson. Reading it is **Code Archaeology**, and that part is optional.

> ⚠️ Anything marked **(not measured)** came from a template and hasn't been checked on the real robot. If a lesson has you measure one of these, your number wins.

---

## CAN IDs

| ID | Device | Mechanism |
|---|---|---|
| 1 | TalonFX | Drivetrain, left leader |
| 2 | TalonFX | Drivetrain, right leader |
| 3 | TalonFX | Drivetrain, left follower |
| 4 | TalonFX | Drivetrain, right follower |
| 5 | TalonFX | Intake/launcher rollers, left |
| 6 | TalonFX | Intake/launcher rollers, right |
| 7 | TalonFX | Climber |
| 11 | Pigeon 2 | Gyro |
| 29 | TalonFX | Conveyor |

The competition code also declares CANcoders with IDs 9 and 10 but never uses them.

In code, a motor is `new TalonFX(id)` and the gyro is `new Pigeon2(11)`. Both come from Phoenix 6 (`com.ctre.phoenix6.hardware`).

---

## Drivetrain

Tank drive: two motors per side, and both motors on a side turn the same gearbox.

| Setting | Value |
|---|---|
| Left side direction | `InvertedValue.CounterClockwise_Positive` (the default) |
| Right side direction | `InvertedValue.Clockwise_Positive` (inverted) |
| Neutral mode | Brake |
| Stator current limit | 60 A |
| Gear ratio | 10.71 motor turns per wheel turn **(not measured)** |
| Wheel diameter | 6 in = 0.1524 m **(not measured)** |
| Track width (left wheels to right wheels) | 0.56 m **(not measured)** |
| Stick scaling | forward × 0.7, turning × 0.8 |

**Why the right side is inverted:** the motors on each side face opposite directions. If both sides get `+0.5` and neither is inverted, one side drives forward, the other drives backward, and the robot spins in place. The simulator does this too.

**Gyro:** Pigeon 2 on ID 11, mounted sideways (Y axis up), so the competition code sets a mount pose with a pitch of 90°.

---

## Fuel mechanism (intake + launcher + conveyor)

**The same pair of rollers is both the intake and the launcher.** The rollers spin the same way whether you're pulling fuel in or shooting it out. **The conveyor's direction decides where the ball goes:** into the hopper, or up to the launcher.

| Setting | Rollers (5 and 6) | Conveyor (29) |
|---|---|---|
| Direction | Left `CounterClockwise_Positive`, right `Clockwise_Positive` | default |
| Neutral mode | Coast (so the flywheel keeps spinning) | Brake |
| Stator current limit | 100 A | 80 A |

### Ball paths: what the competition code actually sends

| Action | Button | Rollers | Conveyor |
|---|---|---|---|
| **Intake** into the hopper | Operator B | `-0.7` | `+0.8` |
| **Eject** back out the intake | Operator left bumper | `+0.9` | `+0.8` |
| **Shoot** | Operator A / X / Y | closed loop at `-70` / `-80` / `-90` RPS | hold at `-0.05`, then `-0.7` once the rollers are at speed |
| **Shuttle** (pass across the field) | Operator right bumper | closed loop at `-90` RPS | `0`, then `-0.7` once at speed |

Negative roller speed is the launch direction.

### Flywheel (closed-loop speed control)

| Setting | Value |
|---|---|
| kS | 0.15 V |
| kV | 0.12 V per RPS |
| kP | 0.1 V per RPS of error |
| "At speed" tolerance | within 3 RPS of the target |
| Control request | `VelocityVoltage`, in rotations per second |

---

## Climber

| Setting | Value |
|---|---|
| Neutral mode | Brake |
| Stator current limit | 80 A |
| Climb up | `+0.95`, stops once position is past `365` rotations |
| Climb down | `-0.3867`, stops once position is below `-70` rotations |

Position is the motor's own encoder, in motor rotations.

---

## Vision

| Setting | Value |
|---|---|
| Front Limelight name | `limelight` |
| Back Limelight name | `limelight-back` |
| "Aimed" tolerance | 1.5° |
| Hub center, red alliance | x = 11.9903 m, y = 4.0214 m |
| Hub center, blue alliance | x = 4.5227 m, y = 4.0214 m |
| Distance → flywheel speed | 30 in → `-60` RPS, 120 in → `-90` RPS, straight line in between |

The competition code reads the Limelight through `LimelightHelpers.java`, a file Limelight publishes.

> 🏠 The simulator can't fake a camera yet, so vision lessons need the real robot, or a mentor, for now.

---

## Controllers

| Port | Who | Controls |
|---|---|---|
| 0 | Driver | Left stick Y: drive. Right stick X: turn. D-pad up/down: climb. Triggers: climb at variable speed. Left bumper: align and shoot |
| 1 | Operator | B: intake. Left bumper: eject. Right bumper: shuttle. A / X / Y: short / medium / far shot. Triggers: jiggle the conveyor |
| 2 | Pit tuner | A: flywheel tuning mode |

**Joystick Y is backward:** pushing the stick away from you reads *negative*, so drive code uses `-controller.getLeftY()`.

---

## Autonomous routines

| Name | What it does |
|---|---|
| Shoot And Climb (default) | Climber up, drive forward 2 s, shoot for 4 s, climber down |
| Drive To Climb | Climber up, wait 3 s, drive forward 2 s, climber down |
| Just Shoot | Climber up, drive forward 1.867 s, spin up for 1 s, shoot for 15 s |
| PP Depot And Climb | A path drawn in PathPlanner, using the named commands Intake, Shoot, ClimbUp and ClimbDown |

---

## In the simulator

Your keyboard is controller 0 (the driver). **WASD** is the left stick, **IJKL** the right stick, **Q/E** the triggers, **Z/X/C/V** the A/B/X/Y buttons, **1/2** the bumpers, and the arrow keys the D-pad. The full table is in [lesson 00](../../lessons/LESSON00.md).

`frc.sim.RobotSim` makes all of the motors above, and the gyro, move when you run the simulator at home. It models each motor as a Kraken X60, which is the only motor CTRE's simulator supports. It uses the numbers on this page, plus some estimates (robot weight, roller weight) that are good enough to see the right behavior but won't match the real robot exactly. A mentor maintains it, so you never need to edit it.
