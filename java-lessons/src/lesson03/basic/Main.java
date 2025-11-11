package lesson03.basic;
import java.util.Scanner;

import lessonRunner.BaseLesson;

// TASK: Import the Scanner class
// Create a Scanner object to read input
// Prompt the user for width and height (two doubles)
// Calculate the area of a rectangle
// Print the result in the format:
// The area is: <area> cm²
public class Main extends BaseLesson {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        System.out.println(a*b);
        sc.close();
    }
}
