
package week8.assigment_problems;

import java.util.Scanner;

abstract class Vehicle {
    abstract double calculateCharge(int hours);
}

class Bike extends Vehicle {
    double calculateCharge(int hours) {
        return hours * 10.0;
    }
}

class Car extends Vehicle {
    double calculateCharge(int hours) {
        return 30 + (hours - 1) * 20.0;
    }
}

class Truck extends Vehicle {
    double calculateCharge(int hours) {
        return Math.max(hours * 50.0, 100.0);
    }
}

public class ParkingChargeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            int hours = sc.nextInt();

            Vehicle vehicle;

            switch (type) {
                case "BIKE":
                    vehicle = new Bike();
                    break;
                case "CAR":
                    vehicle = new Car();
                    break;
                case "TRUCK":
                    vehicle = new Truck();
                    break;
                default:
                    System.out.println("Invalid vehicle type");
                    continue;
            }

            double charge = vehicle.calculateCharge(hours);

            System.out.printf("%s: %.2f%n", type, charge);
            total += charge;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
