
package week8.assigment_problems;

import java.util.Scanner;

abstract class Room {
    abstract double calculateBill();
}

class SingleRoom extends Room {
    int units;

    SingleRoom(int units) {
        this.units = units;
    }

    double calculateBill() {
        return units * 8.0;
    }
}

class SharedRoom extends Room {
    int units, occupants;

    SharedRoom(int units, int occupants) {
        this.units = units;
        this.occupants = occupants;
    }

    double calculateBill() {
        return (units * 6.0) / occupants;
    }
}

class ACRoom extends Room {
    int units;

    ACRoom(int units) {
        this.units = units;
    }

    double calculateBill() {
        return units * 10.0 + 200;
    }
}

public class HostelElectricityBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            Room room;

            switch (type) {
                case "SINGLE":
                    room = new SingleRoom(sc.nextInt());
                    break;

                case "SHARED":
                    room = new SharedRoom(sc.nextInt(), sc.nextInt());
                    break;

                case "AC":
                    room = new ACRoom(sc.nextInt());
                    break;

                default:
                    System.out.println("Invalid room type");
                    continue;
            }

            double bill = room.calculateBill();
            System.out.printf("%s: %.2f%n", type, bill);
            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
