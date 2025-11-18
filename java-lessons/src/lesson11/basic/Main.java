package lesson11.basic;
import lessonRunner.BaseLesson;

public class Main extends BaseLesson {
    public static void main(String[] args) {
        // TASK: Build an interactive email slicer
        // 1. Create a Scanner to read user input
        // 2. Prompt user: "Enter an email address: "
        // 3. Validate that email contains "@" using .contains("@")
        // 4. Use .indexOf("@") to find the position of the @ symbol
        // 5. Extract username: email.substring(0, indexOf("@"))
        // 6. Extract domain: email.substring(indexOf("@") + 1)
        // 7. Print results: "Username: [username], Domain: [domain]"
        // Example: "bro123@gmail.com" → "Username: bro123, Domain: gmail.com"
    }
}
