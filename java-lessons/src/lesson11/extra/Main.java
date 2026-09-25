package lesson11.extra;
import lessonRunner.BaseLesson;

// LESSON 11 EXTRA - A file path parser
//
// TASK:
// 1. Store a file path in a String, like "/home/user/robot/config.json"
//    For a Windows path, write every backslash twice: "C:\\Users\\robot\\config.json"
//    (a single backslash starts an escape like \n, and \U isn't one, so it won't compile)
// 2. Use .lastIndexOf("/") (or .lastIndexOf("\\") for Windows) to find the LAST slash
// 3. Filename  = everything after the last slash   -> config.json
// 4. Use .lastIndexOf(".") to find the LAST dot
// 5. Extension = everything after the last dot     -> json
// 6. Directory = everything before the last slash  -> /home/user/robot
// 7. Print all three parts
// 8. Edge cases: .lastIndexOf() gives -1 when it finds nothing.
//    What should print for "notes" (no extension) or "config.json" (no directory)?
public class Main extends BaseLesson {
    public static void main(String[] args) {
    }
}
