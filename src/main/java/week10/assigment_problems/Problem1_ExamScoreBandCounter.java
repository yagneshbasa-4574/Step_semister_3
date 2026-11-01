
package week10.assigment_problems;

public class Problem1_ExamScoreBandCounter {

    // Finds the first index where score >= target
    public static int findFirstGreaterOrEqual(int[] scores, int target) {
        int left = 0;
        int right = scores.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (scores[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    // Finds the first index where score > target
    public static int findFirstStrictlyGreater(int[] scores, int target) {
        int left = 0;
        int right = scores.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (scores[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    // Counts scores in the inclusive range [low, high]
    public static int countInBand(int[] scores, int low, int high) {
        if (scores == null || scores.length == 0 || low > high) {
            return 0;
        }

        int lowerBoundIndex = findFirstGreaterOrEqual(scores, low);
        int upperBoundIndex = findFirstStrictlyGreater(scores, high);

        return upperBoundIndex - lowerBoundIndex;
    }

    public static void main(String[] args) {

        int[] scores = {35, 42, 42, 50, 58, 58, 58, 63, 71, 88};

        int result1 = countInBand(scores, 42, 58);
        System.out.println("Sample 1 Output: " + result1);

        int result2 = countInBand(scores, 90, 100);
        System.out.println("Sample 2 Output: " + result2);
    }
}
