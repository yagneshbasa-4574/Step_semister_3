package week2.class_problems;

import java.util.Scanner;

public class MaskedPhoneNumberFormatter {

    static String formatPhoneNumber(String phoneNumber) {

        if (phoneNumber.length() != 10) {
            return "Invalid phone number";
        }

        for (int i = 0; i < phoneNumber.length(); i++) {
            if (!Character.isDigit(phoneNumber.charAt(i))) {
                return "Invalid phone number";
            }
        }

        StringBuilder maskedNumber = new StringBuilder();

        maskedNumber.append("XXXXXX");
        maskedNumber.append("-");
        maskedNumber.append(phoneNumber.substring(6));

        return maskedNumber.toString();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter 10-digit phone number: ");
        String phoneNumber = scanner.nextLine();

        System.out.println(formatPhoneNumber(phoneNumber));

        scanner.close();
    }
}