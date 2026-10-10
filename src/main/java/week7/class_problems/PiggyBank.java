
package week7.class_problems;

public class PiggyBank {

    private double savings;
    private final String id;

    public PiggyBank(String id) {
        this.id = id;
        savings = 0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            savings += amount;
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount");
        } else if (amount > savings) {
            System.out.println("Withdrawal rejected");
        } else {
            savings -= amount;
        }
    }

    public double getSavings() {
        return savings;
    }

    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");

        pb.deposit(100);
        System.out.println("After deposit: " + pb.getSavings());

        pb.withdraw(30);
        System.out.println("After withdrawal: " + pb.getSavings());

        pb.withdraw(500);
        System.out.println("Final savings: " + pb.getSavings());
    }
}
