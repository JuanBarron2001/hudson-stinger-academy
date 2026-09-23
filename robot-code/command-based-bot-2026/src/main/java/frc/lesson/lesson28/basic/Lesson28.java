package frc.lesson.lesson28.basic;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.lesson.LessonBase;
// Uncomment once you've given Fuel a constructor. It's the class you wrote in lesson 27.
// import frc.robot.subsystems.Fuel;

// LESSON 28 BASIC - A constructor is where a motor gets set up
// Your Fuel class works, but every motor on it is running on factory defaults. A real
// motor has settings: which way it spins, how hard it may pull, what it does when you
// stop asking. They only need to be set ONCE, which is exactly what a constructor is for.
//
// TASK:
// 1. In Fuel.java, take the  = new TalonFX(5)  off the ends of your three fields. Leave
//    the declarations:  public TalonFX leftRoller;
// 2. Add a constructor -  public Fuel() { ... }  - and create the three motors inside it.
//    Run the lesson. Nothing should have changed yet. That's the point: same thing, new home.
// 3. Now configure them, from the tables in ROBOT.md:
//      rollers  - Coast, 100 A stator limit, left CounterClockwise_Positive, right Clockwise_Positive
//      conveyor - Brake, 80 A stator limit, default direction
//    The shape is:
//      var rollerConfig = new TalonFXConfiguration()
//          .withMotorOutput(new MotorOutputConfigs()
//              .withNeutralMode(NeutralModeValue.Coast)
//              .withInverted(InvertedValue.CounterClockwise_Positive))
//          .withCurrentLimits(new CurrentLimitsConfigs()
//              .withStatorCurrentLimit(100)
//              .withStatorCurrentLimitEnable(true));
//      leftRoller.getConfigurator().apply(rollerConfig);
// 4. Here: uncomment the import, and publish BOTH roller speeds this time, not just one.
//    Hold B (the 6 key) and check they agree. Both should settle near -68 RPS.
// 5. THE EXPERIMENT: change the roller limit from 100 to 10 and run it again. PREDICT
//    what happens first. Then put 100 back.
//
// WHAT TO NOTICE: a current limit is not a speed limit, but it looks like one. Strangled
// to 10 A the rollers still spin - they just can't pull hard enough to get past about -52.
public class Lesson28 extends LessonBase {
    // Declare your operator controller and your Fuel here.

    @Override
    public void setup() {
        // Runs ONCE, when the robot program starts.
    }

    @Override
    public void execute() {
        // Runs about 50 times a second while the robot is in Teleoperated.
    }
}
