
package week8.class_problems;

import java.util.Scanner;

class Question {
    String type;
    String text;
    String correctAnswer;
    String studentAnswer;
    int points;

    Question(String type, String text, String correctAnswer,
             String studentAnswer, int points) {
        this.type = type;
        this.text = text;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    double grade() {
        return 0;
    }
}

class MCQ extends Question {
    MCQ(String text, String correct, String answer, int points) {
        super("MCQ", text, correct, answer, points);
    }

    @Override
    double grade() {
        return studentAnswer.equals(correctAnswer) ? points : 0;
    }
}

class TrueFalseQuestion extends Question {
    TrueFalseQuestion(String text, String correct, String answer, int points) {
        super("TF", text, correct, answer, points);
    }

    @Override
    double grade() {
        return studentAnswer.equals(correctAnswer) ? points : 0;
    }
}

class Essay extends Question {
    Essay(String text, String correct, String answer, int points) {
        super("ESSAY", text, correct, answer, points);
    }

    @Override
    double grade() {
        String[] keywords = correctAnswer.split(",");
        int matches = 0;
        String answer = studentAnswer.toLowerCase();

        for (String keyword : keywords) {
            if (answer.contains(keyword.trim().toLowerCase())) {
                matches++;
            }
        }

        if (matches >= 2) {
            return points * 0.75;
        } else if (matches == 1) {
            return points * 0.50;
        }

        return 0;
    }
}

public class ExaminationGrader {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split("\"");

            String type = line.substring(0, line.indexOf(' ')).trim();
            String text = parts[1];
            String correct = parts[3];
            String answer = parts[5];
            int points = Integer.parseInt(parts[6].trim());

            Question question;

            switch (type) {
                case "MCQ":
                    question = new MCQ(text, correct, answer, points);
                    break;
                case "TF":
                    question = new TrueFalseQuestion(
                        text, correct, answer, points
                    );
                    break;
                default:
                    question = new Essay(text, correct, answer, points);
            }

            double score = question.grade();
            System.out.printf("%s: %.2f%n", type, score);
            total += score;
        }

        System.out.printf("Total Score: %.2f%n", total);
        sc.close();
    }
}
