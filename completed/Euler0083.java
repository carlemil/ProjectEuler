package completed;

import java.awt.Point;
import java.util.ArrayList;

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

public class Euler0083 {

    // static int[][] matrix = new int[][]{{131, 673, 234, 103, 18}, {201, 96, 342, 965, 150}, {630, 803, 746, 422, 111},
    // {537, 699, 497, 121, 956}, {805, 732, 524, 37, 331}};
    static int[][]          matrix      = new int[80][80];
    static int[][]          visitedCost = new int[matrix.length][matrix[0].length];

    static ArrayList<Point> moveStack   = new ArrayList<Point>();

    public static void main(String[] args) {
        Tools.readInt2DArrayFromFile("completed/euler_0083_matrix.txt", matrix);

        long time = System.currentTimeMillis();

        initCost();
        moveStack.add(new Point(0, 0));
        run();
        // Tools.print2DArray(matrix);
        System.out.println("time: " + (System.currentTimeMillis() - time) + "ms");

        System.out.println(visitedCost[visitedCost.length - 1][visitedCost[0].length - 1]);
    }

    private static void run() {
        while (!moveStack.isEmpty()) {
            Point p = moveStack.remove(0);
            if (visitedCost[p.x][p.y] > 500000)
                break;

            if (p.x > 0) {
                updateCost(p.x, p.y, p.x - 1, p.y);
            }
            if (p.y > 0) {
                updateCost(p.x, p.y, p.x, p.y - 1);
            }
            if (p.x < matrix.length - 1) {
                updateCost(p.x, p.y, p.x + 1, p.y);
            }
            if (p.y < matrix.length - 1) {
                updateCost(p.x, p.y, p.x, p.y + 1);
            }
        }
    }

    private static void updateCost(int x, int y, int dx, int dy) {
        if (visitedCost[x][y] + matrix[dx][dy] < visitedCost[dx][dy]) {
            visitedCost[dx][dy] = visitedCost[x][y] + matrix[dx][dy];
            moveStack.add(moveStack.size(), new Point(dx, dy));
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