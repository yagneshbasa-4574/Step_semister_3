
package week9.class_problems;

import java.util.Scanner;

abstract class LibraryItem {
    int lateDays;

    LibraryItem(int lateDays) {
        this.lateDays = lateDays;
    }

    abstract int calculateFine();
}

class Book extends LibraryItem {

    Book(int lateDays) {
        super(lateDays);
    }

    int calculateFine() {
        return lateDays * 2;
    }
}

class DVD extends LibraryItem {

    DVD(int lateDays) {
        super(lateDays);
    }

    int calculateFine() {
        return Math.min(lateDays * 5, 50);
    }
}

class Magazine extends LibraryItem {

    Magazine(int lateDays) {
        super(lateDays);
    }

    int calculateFine() {
        return lateDays;
    }
}

public class LibraryLateFine {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        LibraryItem[] items = new LibraryItem[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            int days = sc.nextInt();

            switch (type) {

                case "BOOK":
                    items[i] = new Book(days);
                    break;

                case "DVD":
                    items[i] = new DVD(days);
                    break;

                case "MAGAZINE":
                    items[i] = new Magazine(days);
                    break;
            }
        }

        int totalFine = 0;

        for (LibraryItem item : items) {

            int fine = item.calculateFine();

            System.out.println("Fine: " + fine);

            totalFine += fine;
        }

        System.out.println("Total Fine: " + totalFine);

        sc.close();
    }
}
