
package week9.assigment_problems;

import java.util.Scanner;

interface SaverMode {
    double applySaver(double units);
}

abstract class Appliance {
    double hours;

    Appliance(double hours) {
        this.hours = hours;
    }

    abstract double calculateUnits();

    double calculateCost() {
        return calculateUnits() * 8;
    }
}

class Fridge extends Appliance {

    Fridge(double hours) {
        super(hours);
    }

    double calculateUnits() {
        return (150 * hours) / 1000;
    }
}

class AC extends Appliance implements SaverMode {

    AC(double hours) {
        super(hours);
    }

    double calculateUnits() {
        return (1500 * hours) / 1000;
    }

    public double applySaver(double units) {
        return units * 0.75;
    }
}

class TV extends Appliance {

    TV(double hours) {
        super(hours);
    }

    double calculateUnits() {
        return (100 * hours) / 1000;
    }
}

class WashingMachine extends Appliance implements SaverMode {

    WashingMachine(double hours) {
        super(hours);
    }

    double calculateUnits() {
        return (500 * hours) / 1000;
    }

    public double applySaver(double units) {
        return units * 0.75;
    }
}

public class HomeApplianceEnergyReport {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Appliance[] appliances = new Appliance[n];
        boolean[] saver = new boolean[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double hours = sc.nextDouble();
            saver[i] = sc.nextBoolean();

            switch (type) {

                case "FRIDGE":
                    appliances[i] = new Fridge(hours);
                    break;

                case "AC":
                    appliances[i] = new AC(hours);
                    break;

                case "TV":
                    appliances[i] = new TV(hours);
                    break;

                case "WASHING_MACHINE":
                    appliances[i] = new WashingMachine(hours);
                    break;

                default:
                    System.out.println("Invalid appliance");
                    sc.close();
                    return;
            }
        }

        double totalUnits = 0;
        double totalCost = 0;

        for (int i = 0; i < n; i++) {

            Appliance appliance = appliances[i];

            double units = appliance.calculateUnits();

            if (saver[i]) {

                if (appliance instanceof SaverMode) {
                    SaverMode mode = (SaverMode) appliance;
                    units = mode.applySaver(units);
                } else {
                    System.out.println("Saver mode not available");
                }
            }

            double cost = units * 8;

            System.out.printf("Units: %.2f%n", units);
            System.out.printf("Cost: %.2f%n", cost);

            totalUnits += units;
            totalCost += cost;
        }

        System.out.printf("Total Units: %.2f%n", totalUnits);
        System.out.printf("Total Cost: %.2f%n", totalCost);

        sc.close();
    }
}
