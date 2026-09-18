package lesson33.basic;
import lessonRunner.BaseLesson;

// LESSON 33 BASIC - super hands the parent what it needs
//
// TASK:
// 1. Person.java (package lesson33.basic;):
//      String first, last;  a constructor Person(String first, String last);
//      void showName() prints first + " " + last
// 2. Student.java:  Student extends Person,  with  double gpa
// 3. Student's constructor takes first, last and gpa. First try setting  this.first = first;
//    in it, and read the error. Then replace that with  super(first, last);
//    as the constructor's FIRST line, and set  this.gpa = gpa;
// 4. Give Student  void showGpa()  that prints first + "'s GPA is " + gpa
// 5. In main: create  new Student("Harry", "Potter", 3.25),  call showName() and showGpa()
public class Main extends BaseLesson {
    public static void main(String[] args) {
    }
}
