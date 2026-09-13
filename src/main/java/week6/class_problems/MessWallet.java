package week6.class_problems;

public class MessWallet {

    private double balance;

    public MessWallet(double openingBalance) {

        if (openingBalance < 0) {
            System.out.println("Warning: Negative balance not allowed. Starting at Rs 0.0");
            balance = 0;
        } else {
            balance = openingBalance;
        }
    }

    public void topUp(double amount) {

        if (amount <= 0) {
            System.out.println("Top-up rejected: amount must be positive");
        } else {
            balance += amount;
            System.out.println("Balance after top-up: " + balance);
        }
    }

    public void deduct(double amount) {

        if (amount > balance) {
            System.out.println("Deduct rejected: insufficient balance");
        } else if (amount <= 0) {
            System.out.println("Deduct rejected: amount must be positive");
        } else {
            balance -= amount;
        }
    }

    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {

        MessWallet wallet = new MessWallet(500);

        wallet.topUp(200);
        wallet.deduct(1000);

        System.out.println("Final balance: " + wallet.getBalance());
    }
}