package completed;

import com.kjellstrand.euler.Tools;

// NOTE: This problem is a significantly more challenging version of Problem 81.
//
// In the 5 by 5 matrix below, the minimal path sum from the top left to the bottom
// right, by moving left, right, up, and down, is indicated in bold red and is equal 
// to 2297.
//
//
// 131 673 234 103 18
// 201 96  342 965 150
// 630 803 746 422 111
// 537 699 497 121 956
// 805 732 524 37  331
//
// Find the minimal path sum, in matrix.txt (right click and 'Save Link/Target As...'), 
// a 31K text file containing a 80 by 80 matrix, from the top left to the bottom right 
// by moving left, right, up, and down.

public class Euler0083Fast {

    // static int[][] matrix = new int[][]{{131, 673, 234, 103, 18}, {201, 96, 342, 965, 150},
    // {630, 803, 746, 422, 111}, {537, 699, 497, 121, 956}, {805, 732, 524, 37, 331}};
    static int[][] matrix            = new int[80][80];
    static int[][] visitedCost       = new int[matrix.length][matrix[0].length];

    static long    bestSolutionSoFar = Long.MAX_VALUE;

    public static void main(String[] args) {
        Tools.readInt2DArrayFromFile("completed/euler_0083_matrix.txt", matrix);
        long time = System.currentTimeMillis();
        initCost();
        run();
        System.out.println("time: " + (System.currentTimeMillis() - time) + "ms");
    }

    private static void run() {
        int i = 0;
        while (i < 4) {
            for(int x = 0; x < visitedCost.length; x++) {
                for(int y = 0; y < visitedCost[0].length; y++) {
                    updateCost(x, y, x + 1, y);
                    updateCost(x, y, x - 1, y);
                    updateCost(x, y, x, y + 1);
                    updateCost(x, y, x, y - 1);
                }
            }
            i++;
        }
        // Tools.print2DArray(visitedCost);
        System.out.println(visitedCost[matrix.length - 1][matrix[0].length - 1]);
    }

    private static void updateCost(int x, int y, int dx, int dy) {
        if (dx >= 0 && dy >= 0 && dx < matrix.length && dy < matrix[0].length) {
            int origCost = visitedCost[x][y];
            if (visitedCost[dx][dy] > origCost + matrix[dx][dy]) {
                visitedCost[dx][dy] = origCost + matrix[dx][dy];
            }
        }
    }

    private static void initCost() {
        for(int x = 0; x < visitedCost.length; x++) {
            for(int y = 0; y < visitedCost[0].length; y++) {
                visitedCost[x][y] = Integer.MAX_VALUE;
            }
        }
        visitedCost[0][0] = matrix[0][0];
    }
}