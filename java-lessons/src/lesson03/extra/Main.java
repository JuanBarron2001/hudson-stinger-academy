package lesson03.extra;
import java.util.Scanner;

import lessonRunner.BaseLesson;

// Prompt the user for:
// - Name
// - Class
// - four doubles (assignment scores)
// Calculate the average score
// Print a "report card" style output

// Report Card for: <student name>
// Class: <class name>
// Assignment Scores: <score1>, <score2>, <score3>, <score4>
// Average Score: <average>
public class Main extends BaseLesson {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        String s = sc.nextLine();
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        double d = sc.nextDouble();
        System.out.println(n + "\n" + s + "\n" + (a+b+c+d)/4.0);
        sc.close();
    }
}
