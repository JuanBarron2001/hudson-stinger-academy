package lesson57.basic;
import lessonRunner.BaseLesson;

// LESSON 57 BASIC - What did the robot do?
// resources/lesson57-robot-log.txt is a real robot log: last season's PP Depot And Climb
// auto, run in the simulator. Each line:  time|key|type|value|hash of the line before
//
// The one line of file reading you need (lesson 47 is Optional). It throws IOException:
//   List<String> lines = Files.readAllLines(Path.of("resources/lesson57-robot-log.txt"));
// Imports: java.nio.file.Files, java.nio.file.Path, java.util.List
//
// TASK:
// 1. Read the file inside a try. If it throws, print "Couldn't read the log: " + the
//    exception's message, and stop. Print how many lines there are.
// 2. Split each line on "\\|" (a bare | means "or" in a pattern). The key is piece [1].
// 3. Count changes per key in a HashMap<String, Integer> (lesson 52). Print how many
//    different keys there are.
// 4. Put the entries in an ArrayList<Map.Entry<String, Integer>>, sort busiest first with a
//    lambda comparing values (lesson 56), and print the top three.
// 5. Collect every Fuel/Doing value into an ArrayList<String> and print it.
//
// Expected (Pose Y and Pose X tie, so either order):
//   Lines: 382
//   Different keys: 22
//   Climber/Position changed 118 times
//   Drive/Pose Y changed 73 times
//   Drive/Pose X changed 73 times
//   The fuel mechanism did: [INTAKE, stopped, SHOOT, stopped]
//
// EXPERIMENT: use a file name that doesn't exist. PREDICT the output, then change it back.
public class Main extends BaseLesson {
    public static void main(String[] args) {
    }
}
