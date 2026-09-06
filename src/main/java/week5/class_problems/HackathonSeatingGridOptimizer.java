package week5.class_problems;

public class HackathonSeatingGridOptimizer {

    private static double rowAverage(int[] row) {

        int sum = 0;

        for (int score : row) {
            sum += score;
        }

        return (double) sum / row.length;
    }

    static String classifyRows(int[][] seatingScores, int threshold) {

        String result = "";

        for (int i = 0; i < seatingScores.length; i++) {

            double average = rowAverage(seatingScores[i]);

            if (average < threshold) {
                result += "Row " + i + ": Quiet Zone";
            } else {
                result += "Row " + i + ": Buzzing Zone";
            }

            if (i < seatingScores.length - 1) {
                result += " | ";
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[][] seatingScores = {
            {40, 50, 45},
            {85, 90, 95},
            {30, 20, 25}
        };

        int threshold = 60;

        System.out.println(classifyRows(seatingScores, threshold));
    }
}