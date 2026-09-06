package week5.assigment_problems;

public class MatchDayGridAnalyzer {

    private static double rowAverage(int[] row) {

        int sum = 0;

        for (int runs : row) {
            sum += runs;
        }

        return (double) sum / row.length;
    }

    static String classifyMatches(int[][] runsPerOver, int threshold) {

        String result = "";

        for (int i = 0; i < runsPerOver.length; i++) {

            double average = rowAverage(runsPerOver[i]);

            if (average >= threshold) {
                result += "Match " + i + ": Power Surge";
            } else {
                result += "Match " + i + ": Normal";
            }

            if (i < runsPerOver.length - 1) {
                result += " | ";
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[][] runsPerOver = {
            {4, 6, 8},
            {10, 12, 14},
            {2, 3, 1}
        };

        int threshold = 8;

        System.out.println(classifyMatches(runsPerOver, threshold));
    }
}