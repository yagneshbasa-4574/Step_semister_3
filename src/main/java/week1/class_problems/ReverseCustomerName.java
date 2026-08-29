package week1.class_problems;

import java.util.Scanner;

public class ReverseCustomerName {

    static String reverseCustomerName(String customerName) {

        String reversed = "";

        for (int i = customerName.length() - 1; i >= 0; i--) {
            reversed = reversed + customerName.charAt(i);
        }

        return reversed;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();

        String reversedName = reverseCustomerName(customerName);

        System.out.println("Original Name: " + customerName);
        System.out.println("Reversed Name: " + reversedName);

        scanner.close();
    }
}