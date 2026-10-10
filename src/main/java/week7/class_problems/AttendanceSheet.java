
package week7.class_problems;

public class AttendanceSheet {

    private final String[] students;
    private int presentCount;

    public AttendanceSheet(int capacity) {
        students = new String[capacity];
        presentCount = 0;
    }

    public void markPresent(String name) {
        if (isPresent(name)) {
            return;
        }

        if (presentCount < students.length) {
            students[presentCount] = name;
            presentCount++;
        } else {
            System.out.println("Attendance sheet is full");
        }
    }

    public int getPresentCount() {
        return presentCount;
    }

    public boolean isPresent(String name) {
        for (int i = 0; i < presentCount; i++) {
            if (students[i].equals(name)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        AttendanceSheet sheet = new AttendanceSheet(30);

        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");

        System.out.println("Present count: " + sheet.getPresentCount());
        System.out.println("Is Ben present? " + sheet.isPresent("Ben"));
        System.out.println("Is Chen present? " + sheet.isPresent("Chen"));
    }
}
