
package week9.assigment_problems;

import java.util.Scanner;

interface NightService {
    double calculateNightFare(double fare);
}

abstract class Cab {
    double distance;

    Cab(double distance) {
        this.distance = distance;
    }

    abstract double calculateFare();

    double applyMinimumFare(double fare) {
        return Math.max(fare, 100);
    }
}

class Mini extends Cab {

    Mini(double distance) {
        super(distance);
    }

    double calculateFare() {
        return applyMinimumFare(distance * 10);
    }
}

class Sedan extends Cab implements NightService {

    Sedan(double distance) {
        super(distance);
    }

    double calculateFare() {
        return applyMinimumFare(distance * 14);
    }

    public double calculateNightFare(double fare) {
        return fare * 1.20;
    }
}

class SUV extends Cab implements NightService {

    SUV(double distance) {
        super(distance);
    }

    double calculateFare() {
        return applyMinimumFare(distance * 18);
    }

    public double calculateNightFare(double fare) {
        return fare * 1.20;
    }
}

public class CityCabFareMeter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Cab[] cabs = new Cab[n];
        boolean[] night = new boolean[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double distance = sc.nextDouble();
            night[i] = sc.nextBoolean();

            switch (type) {

                case "MINI":
                    cabs[i] = new Mini(distance);
                    break;

                case "SEDAN":
                    cabs[i] = new Sedan(distance);
                    break;

                case "SUV":
                    cabs[i] = new SUV(distance);
                    break;

                default:
                    System.out.println("Invalid cab type");
                    sc.close();
                    return;
            }
        }

        for (int i = 0; i < n; i++) {

            Cab cab = cabs[i];

            if (night[i] && !(cab instanceof NightService)) {
                System.out.println("Night service not available");
                continue;
            }

            double fare = cab.calculateFare();

            if (night[i]) {
                NightService service = (NightService) cab;
                fare = service.calculateNightFare(fare);
            }

            System.out.printf("Cab Fare: %.2f%n", fare);
        }

        sc.close();
    }
}
