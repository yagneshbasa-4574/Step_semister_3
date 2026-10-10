
package week7.class_problems;

public class Locker {

    private String code;
    private final int lockerNumber;

    public Locker(int lockerNumber, String code) {
        this.lockerNumber = lockerNumber;
        this.code = code;
    }

    public boolean changeCode(String currentCode, String newCode) {
        if (this.code.equals(currentCode)) {
            this.code = newCode;
            return true;
        }

        return false;
    }

    public int getLockerNumber() {
        return lockerNumber;
    }

    public static void main(String[] args) {

        Locker l = new Locker(101, "1234");

        if (l.changeCode("1234", "5678")) {
            System.out.println("First change: Success");
        } else {
            System.out.println("First change: Rejected");
        }

        if (l.changeCode("0000", "9999")) {
            System.out.println("Second change: Success");
        } else {
            System.out.println("Second change: Rejected");
        }

        System.out.println("Locker number: " + l.getLockerNumber());
    }
}
