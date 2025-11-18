package lesson11.extra;
import lessonRunner.BaseLesson;

public class Main extends BaseLesson {
    public static void main(String[] args) {
        // TASK: Build a filename/path parser (more complex)
        // 1. Create a Scanner to read a file path from user
        //    Examples: "/home/user/Documents/myfile.txt" or "C:\\Users\\robot\\config.json"
        // 2. Use .lastIndexOf("/") or .lastIndexOf("\\") to find the LAST slash/backslash
        // 3. Extract filename: path.substring(lastIndexOf separators + 1)
        // 4. Use .lastIndexOf(".") to find the LAST dot
        // 5. Extract extension: path.substring(lastIndexOf(".") + 1)
        // 6. Extract directory: path.substring(0, lastIndexOf separators)
        // 7. Print all three parts: directory, filename, extension
        // Example: "/home/user/robot/config.json" →
        //   Directory: /home/user/robot
        //   Filename: config
        //   Extension: json
        // Handle edge cases: what if there's no extension? No directory?
    }
}
