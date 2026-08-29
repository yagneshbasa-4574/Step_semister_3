package week1.assigment_problems;

import java.util.Scanner;

public class TypingAccuracyChecker {

    static void checkTypingAccuracy(String original, String typed) {

        int matched = 0;
        int minLength = Math.min(original.length(), typed.length());
        int firstMismatch = -1;

        for (int i = 0; i < minLength; i++) {

            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatch == -1) {
                firstMismatch = i;
            }
        }

        int totalCharacters = original.length();
        double accuracy = (matched * 100.0) / totalCharacters;

        System.out.printf("Matched: %d/%d | Accuracy: %.2f%%%n",
                matched, totalCharacters, accuracy);

        if (firstMismatch == -1 && original.length() == typed.length()) {
            System.out.println("No Mismatches");
        } else if (firstMismatch != -1) {
            System.out.println(
                    "First Mismatch at position " + (firstMismatch + 1)
                    + " ('" + original.charAt(firstMismatch)
                    + "' vs '" + typed.charAt(firstMismatch) + "')"
            );
        } else {
            System.out.println("Length Mismatch");
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter original passage: ");
        String original = scanner.nextLine();

        System.out.print("Enter typed passage: ");
        String typed = scanner.nextLine();

        checkTypingAccuracy(original, typed);

        scanner.close();
    }
}