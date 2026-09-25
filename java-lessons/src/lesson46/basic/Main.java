package lesson46.basic;
import lessonRunner.BaseLesson;

// LESSON 46 BASIC - Write a file
//
// TASK:
// 1. At the top of the file:  import java.io.FileWriter;  and  import java.io.IOException;
// 2. In main, open the file with try-with-resources (lesson 45):
//      try (FileWriter writer = new FileWriter("test.txt")) { ... }
//    inside: writer.write("I like pizza"); and print "File has been written."
// 3. catch (IOException e) and print "Could not write file."
// 4. Run it and find test.txt: with no folder in the name, it lands in the folder you
//    ran the lesson from, java-lessons/
public class Main extends BaseLesson {
    public static void main(String[] args) {
    }
}
