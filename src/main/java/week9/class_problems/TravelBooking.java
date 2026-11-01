
package week9.class_problems;

import java.util.Scanner;

abstract class Travel {
    double distance;

    Travel(double distance) {
        this.distance = distance;
    }

    abstract double calculateFare();

    double totalFare() {
        return calculateFare() + 50;
    }
}

class Bus extends Travel {

    Bus(double distance) {
        super(distance);
    }

    double calculateFare() {
        return distance * 2;
    }
}

class Train extends Travel {

    Train(double distance) {
        super(distance);
    }

    double calculateFare() {
        return distance * 1.5;
    }
}

class Flight extends Travel {

    Flight(double distance) {
        super(distance);
    }

    double calculateFare() {
        return 2500 + (distance * 4);
    }
}

public class TravelBooking {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Travel[] bookings = new Travel[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double distance = sc.nextDouble();

            switch (type) {

                case "BUS":
                    bookings[i] = new Bus(distance);
                    break;

                case "TRAIN":
                    bookings[i] = new Train(distance);
                    break;

                case "FLIGHT":
                    bookings[i] = new Flight(distance);
                    break;
            }
        }

        double totalAmount = 0;

        for (Travel booking : bookings) {

            double fare = booking.totalFare();

            System.out.printf("Total Fare: %.2f%n", fare);

            totalAmount += fare;
        }

        System.out.printf("Grand Total: %.2f%n", totalAmount);

        sc.close();
    }
}
