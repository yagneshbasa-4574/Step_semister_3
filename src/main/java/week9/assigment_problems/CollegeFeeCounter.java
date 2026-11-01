
package week9.assigment_problems;

import java.util.Scanner;

abstract class Student {
    abstract double calculateFee();
}

class DayScholar extends Student {

    double calculateFee() {
        return 40000 + 12000;
    }
}

class Hosteller extends Student {

    double calculateFee() {
        return 40000 + 60000;
    }
}

class Scholar extends Student {

    double calculateFee() {
        return 20000 + 12000;
    }
}

public class CollegeFeeCounter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();

            switch (type) {

                case "DAY_SCHOLAR":
                    students[i] = new DayScholar();
                    break;

                case "HOSTELLER":
                    students[i] = new Hosteller();
                    break;

                case "SCHOLAR":
                    students[i] = new Scholar();
                    break;

                default:
                    System.out.println("Invalid student category");
                    sc.close();
                    return;
            }
        }

        double totalFees = 0;

        for (Student student : students) {

            double fee = student.calculateFee();

            System.out.printf("Student Fee: %.2f%n", fee);

            totalFees += fee;
        }

        System.out.printf("Total College Fees: %.2f%n", totalFees);

        sc.close();
    }
}
