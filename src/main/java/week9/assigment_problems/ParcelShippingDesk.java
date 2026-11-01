
package week9.assigment_problems;

import java.util.Scanner;

interface Insurable {
    double calculateInsurance(double declaredValue);
}

abstract class Parcel {
    double weight;

    Parcel(double weight) {
        this.weight = weight;
    }

    abstract double calculateShippingCost();
}

class StandardParcel extends Parcel {

    StandardParcel(double weight) {
        super(weight);
    }

    double calculateShippingCost() {
        return 40 + (weight * 10);
    }
}

class ExpressParcel extends Parcel implements Insurable {

    ExpressParcel(double weight) {
        super(weight);
    }

    double calculateShippingCost() {
        return 80 + (weight * 15);
    }

    public double calculateInsurance(double declaredValue) {
        return declaredValue * 0.02;
    }
}

class FragileParcel extends Parcel implements Insurable {

    FragileParcel(double weight) {
        super(weight);
    }

    double calculateShippingCost() {
        return 40 + (weight * 10) + 50;
    }

    public double calculateInsurance(double declaredValue) {
        return declaredValue * 0.02;
    }
}

public class ParcelShippingDesk {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Parcel[] parcels = new Parcel[n];
        double[] declaredValues = new double[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double weight = sc.nextDouble();
            double value = sc.nextDouble();

            declaredValues[i] = value;

            switch (type) {

                case "STANDARD":
                    parcels[i] = new StandardParcel(weight);
                    break;

                case "EXPRESS":
                    parcels[i] = new ExpressParcel(weight);
                    break;

                case "FRAGILE":
                    parcels[i] = new FragileParcel(weight);
                    break;

                default:
                    System.out.println("Invalid parcel type");
                    sc.close();
                    return;
            }
        }

        double grandTotal = 0;

        for (int i = 0; i < n; i++) {

            Parcel parcel = parcels[i];

            double shipping = parcel.calculateShippingCost();
            double insurance = 0;

            if (parcel instanceof Insurable) {
                Insurable item = (Insurable) parcel;
                insurance = item.calculateInsurance(declaredValues[i]);
            }

            double total = shipping + insurance;

            System.out.printf("Shipping: %.2f%n", shipping);
            System.out.printf("Insurance: %.2f%n", insurance);
            System.out.printf("Total: %.2f%n", total);

            grandTotal += total;
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);

        sc.close();
    }
}
