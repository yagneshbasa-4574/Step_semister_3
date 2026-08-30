package week2.assigment_problems;

import java.util.Scanner;

public class StopWordFrequencyReport {

    static void generateFrequencyReport(String sentence) {

        String[] words = sentence.toLowerCase().split(" ");

        String[] stopWords = {
            "the", "is", "a", "an", "and", "of", "to", "in"
        };

        String[] uniqueWords = new String[words.length];
        int[] frequencies = new int[words.length];

        int uniqueCount = 0;

        for (String word : words) {

            boolean isStopWord = false;

            for (String stopWord : stopWords) {
                if (word.equals(stopWord)) {
                    isStopWord = true;
                    break;
                }
            }

            if (isStopWord || word.length() == 0) {
                continue;
            }

            int index = -1;

            for (int i = 0; i < uniqueCount; i++) {
                if (uniqueWords[i].equals(word)) {
                    index = i;
                    break;
                }
            }

            if (index == -1) {
                uniqueWords[uniqueCount] = word;
                frequencies[uniqueCount] = 1;
                uniqueCount++;
            } else {
                frequencies[index]++;
            }
        }

        System.out.println("Word Frequency Report:");

        for (int i = 0; i < uniqueCount; i++) {
            System.out.println(
                    uniqueWords[i] + " : " + frequencies[i]
            );
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();

        generateFrequencyReport(sentence);

        scanner.close();
    }
}