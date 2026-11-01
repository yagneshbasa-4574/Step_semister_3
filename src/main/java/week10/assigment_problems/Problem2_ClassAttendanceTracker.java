
package week10.assigment_problems;

public class Problem2_ClassAttendanceTracker {

    public static int[] attendanceSummary(int[] days) {

        if (days == null || days.length == 0) {
            return new int[]{0, 0};
        }

        int presentCount = 0;
        int currentStreak = 0;
        int longestStreak = 0;

        for (int day : days) {

            if (day == 1) {
                presentCount++;
                currentStreak++;

                if (currentStreak > longestStreak) {
                    longestStreak = currentStreak;
                }

            } else {
                currentStreak = 0;
            }
        }

        return new int[]{presentCount, longestStreak};
    }

    public static String formatSummary(int[] summary) {
        return "Present: " + summary[0]
                + ", Longest streak: " + summary[1];
    }

    public static void main(String[] args) {

        int[] days1 = {1, 1, 0, 1, 1, 1, 0, 1};

        int[] result1 = attendanceSummary(days1);
        System.out.println(formatSummary(result1));

        int[] days2 = {0, 0, 0};

        int[] result2 = attendanceSummary(days2);
        System.out.println(formatSummary(result2));
    }
}
