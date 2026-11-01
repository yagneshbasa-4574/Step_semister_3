
package week9.assigment_problems;

import java.util.Scanner;

abstract class Ticket {
    abstract double calculatePrice();

    double totalPrice() {
        return calculatePrice() + 20;
    }
}

class Regular extends Ticket {
    double calculatePrice() {
        return 150;
    }
}

class Premium extends Ticket {
    double calculatePrice() {
        return 250;
    }
}

class Recliner extends Ticket {
    double calculatePrice() {
        return 400;
    }
}

public class MovieTicketCounter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Ticket[] tickets = new Ticket[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();

            switch (type) {
                case "REGULAR":
                    tickets[i] = new Regular();
                    break;

                case "PREMIUM":
                    tickets[i] = new Premium();
                    break;

                case "RECLINER":
                    tickets[i] = new Recliner();
                    break;

                default:
                    System.out.println("Invalid ticket type");
                    return;
            }
        }

        double totalAmount = 0;

        for (Ticket ticket : tickets) {

            double price = ticket.totalPrice();

            System.out.printf("Ticket Price: %.2f%n", price);

            totalAmount += price;
        }

        System.out.printf("Total Amount: %.2f%n", totalAmount);

        sc.close();
    }
}
