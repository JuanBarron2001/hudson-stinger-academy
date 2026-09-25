package lesson47.basic;
import lessonRunner.BaseLesson;

// LESSON 47 BASIC - Read a file line by line
//
// TASK:
// 1. Imports at the top (all java.io): BufferedReader, FileReader, FileNotFoundException,
//    IOException
// 2. String filePath = "test.txt";  (the file lesson 46 wrote into java-lessons/)
// 3. try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
//        String line;
//        while ((line = reader.readLine()) != null) { print line }
//    }
//    readLine() gives one line per call, and null when there are none left
// 4. catch FileNotFoundException ("Could not locate file."), then IOException
//    ("Something went wrong.")
public class Main extends BaseLesson {
    public static void main(String[] args) {
    }
}
