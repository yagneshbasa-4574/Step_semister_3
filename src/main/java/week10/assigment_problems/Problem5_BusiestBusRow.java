
package week10.assigment_problems;

public class Problem5_BusiestBusRow {

    public static int[] busiestRow(int[][] grid) {

        if (grid == null || grid.length == 0) {
            return new int[]{-1, 0};
        }

        int bestRowIndex = 0;
        int maxTotal = -1;

        for (int i = 0; i < grid.length; i++) {

            int rowTotal = 0;

            for (int j = 0; j < grid[i].length; j++) {
                rowTotal += grid[i][j];
            }

            if (rowTotal > maxTotal) {
                maxTotal = rowTotal;
                bestRowIndex = i;
            }
        }

        return new int[]{bestRowIndex, maxTotal};
    }

    public static String formatBusiestRow(int[] result) {
        return "Row " + result[0] + ", Total " + result[1];
    }

    public static void main(String[] args) {

        int[][] grid = {
            {2, 0, 1},
            {3, 3, 1},
            {1, 1, 1}
        };

        int[] result = busiestRow(grid);

        System.out.println(formatBusiestRow(result));
    }
}
