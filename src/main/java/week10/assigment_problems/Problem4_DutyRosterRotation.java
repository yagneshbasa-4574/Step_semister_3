
package week10.assigment_problems;

import java.util.Arrays;

public class Problem4_DutyRosterRotation {

    public static String[] rotateRoster(String[] names, int k) {

        if (names == null || names.length <= 1) {
            return names;
        }

        int n = names.length;

        // Remove unnecessary full rotations
        int effectiveK = k % n;

        String[] rotated = new String[n];

        for (int i = 0; i < n; i++) {

            int newPosition = (i + effectiveK) % n;

            rotated[newPosition] = names[i];
        }

        return rotated;
    }

    public static void main(String[] args) {

        String[] names1 = {"A", "B", "C", "D", "E"};

        String[] result1 = rotateRoster(names1, 2);

        System.out.println("Sample 1 Output: "
                + Arrays.toString(result1));

        String[] names2 = {"A", "B", "C", "D", "E"};

        String[] result2 = rotateRoster(names2, 7);

        System.out.println("Sample 2 Output: "
                + Arrays.toString(result2));
    }
}
