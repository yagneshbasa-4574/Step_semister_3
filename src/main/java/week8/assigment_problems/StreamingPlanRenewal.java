
package week8.assigment_problems;

import java.util.Scanner;
import java.time.LocalDate;

abstract class StreamingPlan {
    String name;
    LocalDate startDate;

    StreamingPlan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    abstract int getDuration();

    LocalDate getRenewalDate() {
        return startDate.plusDays(getDuration());
    }
}

class BasicPlan extends StreamingPlan {
    BasicPlan(String name, LocalDate date) {
        super(name, date);
    }

    int getDuration() {
        return 30;
    }
}

class StandardPlan extends StreamingPlan {
    StandardPlan(String name, LocalDate date) {
        super(name, date);
    }

    int getDuration() {
        return 90;
    }
}

class PremiumPlan extends StreamingPlan {
    PremiumPlan(String name, LocalDate date) {
        super(name, date);
    }

    int getDuration() {
        return 365;
    }
}

public class StreamingPlanRenewal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double unused = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            String name = sc.next();
            LocalDate date = LocalDate.parse(sc.next());

            StreamingPlan plan;

            switch (type) {
                case "BASIC":
                    plan = new BasicPlan(name, date);
                    break;
                case "STANDARD":
                    plan = new StandardPlan(name, date);
                    break;
                case "PREMIUM":
                    plan = new PremiumPlan(name, date);
                    break;
                default:
                    System.out.println("Invalid plan type");
                    continue;
            }

            System.out.println(
                plan.name + ": " + plan.getRenewalDate()
            );
        }

        sc.close();
    }
}
