package week6.class_problems;

public class Student {

    String name;
    double attendance;

    static String collegeName = "SRM Institute of Science and Technology";
    static int studentCount = 0;

    public Student(String name, double attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++;
    }

    public static void printCollegeInfo() {
        System.out.println("College: " + collegeName);
        System.out.println("Students created: " + studentCount);
    }

    public static void main(String[] args) {

        Student student1 = new Student("Ravi", 85.5);
        Student student2 = new Student("Anitha", 90.0);

        Student.printCollegeInfo();
    }
}