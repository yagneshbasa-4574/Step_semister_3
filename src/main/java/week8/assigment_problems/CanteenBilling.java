
package week8.assigment_problems;

import java.util.Scanner;

class Customer {
    double amount;

    Customer(double amount) {
        this.amount = amount;
    }

    double calculateFinalAmount() {
        return amount;
    }
}

class StudentCustomer extends Customer {
    StudentCustomer(double amount) {
        super(amount);
    }

    @Override
    double calculateFinalAmount() {
        return amount * 0.90;
    }
}

class StaffCustomer extends Customer {
    StaffCustomer(double amount) {
        super(amount);
    }

    @Override
    double calculateFinalAmount() {
        return amount * 0.95;
    }
}

class GuestCustomer extends Customer {
    GuestCustomer(double amount) {
        super(amount);
    }

    @Override
    double calculateFinalAmount() {
        return amount + 10;
    }
}

public class CanteenBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().trim().split("\\s+");
            String type = input[0];
            double amount = Double.parseDouble(input[1]);

            Customer customer;

            switch (type) {
                case "STUDENT":
                    customer = new StudentCustomer(amount);
                    break;
                case "STAFF":
                    customer = new StaffCustomer(amount);
                    break;
                default:
                    customer = new GuestCustomer(amount);
            }

            double finalAmount = customer.calculateFinalAmount();
            System.out.printf("%s: %.2f%n", type, finalAmount);
            total += finalAmount;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
