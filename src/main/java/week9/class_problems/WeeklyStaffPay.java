
package week9.class_problems;

import java.util.Scanner;

abstract class Staff {
    String name;

    Staff(String name) {
        this.name = name;
    }

    abstract double calculatePay();
}

class FullTime extends Staff {
    double salary;

    FullTime(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    double calculatePay() {
        return salary;
    }
}

class Hourly extends Staff {
    double hours, rate;

    Hourly(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    double calculatePay() {
        if (hours <= 40) {
            return hours * rate;
        }

        return (40 * rate) + ((hours - 40) * rate * 1.5);
    }
}

class Intern extends Staff {
    double stipend;

    Intern(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    double calculatePay() {
        return stipend;
    }
}

public class WeeklyStaffPay {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Staff[] employees = new Staff[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String name = sc.next();

            switch (type) {

                case "FULLTIME":
                    double salary = sc.nextDouble();
                    employees[i] = new FullTime(name, salary);
                    break;

                case "HOURLY":
                    double hours = sc.nextDouble();
                    double rate = sc.nextDouble();
                    employees[i] = new Hourly(name, hours, rate);
                    break;

                case "INTERN":
                    double stipend = sc.nextDouble();
                    employees[i] = new Intern(name, stipend);
                    break;
            }
        }

        double totalPayroll = 0;

        for (Staff employee : employees) {
            double pay = employee.calculatePay();

            System.out.printf("%s: %.2f%n", employee.name, pay);

            totalPayroll += pay;
        }

        System.out.printf("Total Payroll: %.2f%n", totalPayroll);

        sc.close();
    }
}
