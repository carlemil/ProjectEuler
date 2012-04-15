package completed;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;
import java.util.regex.Pattern;

//NOTE: This problem is a more challenging version of Problem 81.
//
//The minimal path sum in the 5 by 5 matrix below, by starting in 
//any cell in the left column and finishing in any cell in the right 
//column, and only moving up, down, and right, is indicated in red 
//and bold; the sum is equal to 994.
//
//
//131 673 234 103 18
//201 96  342 965 150
//630 803 746 422 111
//537 699 497 121 956
//805 732 524 37  331
//
//Find the minimal path sum, in matrix.txt (right click and 'Save 
//Link/Target As...'), a 31K text file containing a 80 by 80 matrix, 
//from the left column to the right column.

public class Euler0082 {

    // static int[][] matrix = new int[][]{{131, 673, 234, 103, 18}, {201, 96, 342, 965, 150},
    // {630, 803, 746, 422, 111}, {537, 699, 497, 121, 956}, {805, 732, 524, 37, 331}};
    static int[][]     matrix            = new int[80][80];
    static int[][]     visitedCost       = new int[matrix.length][matrix[0].length];

    static Stack<Move> moveStack         = new Stack<Move>();
    static long        bestSolutionSoFar = Long.MAX_VALUE;

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        readFile();
        initCost();
        for(int x = 0; x < matrix.length; x++) {
            moveStack.push(new Move(x, 0, 0));
        }
        run();

        int s = Integer.MAX_VALUE;
        for(int x = 0; x < visitedCost[0].length; x++) {
            int c = visitedCost[x][visitedCost.length - 1];
            System.out.println(c + ", ");
            if (s > c) {
                s = c;
            }
        }

        System.out.println(s);

        System.out.println("time: " + (System.currentTimeMillis() - time) + "ms");

    }

    private static void readFile() {
        try {
            FileReader input = new FileReader("euler_0082_matrix.txt");
            BufferedReader bufRead = new BufferedReader(input);

            String regex = ",";
            Pattern pattern = Pattern.compile(regex);

            String line;
            int count = 0;
            line = bufRead.readLine();

            int x = 0;
            while (line != null) {
                String[] sa = pattern.split(line);
                int[] row = new int[80];
                for(int i = 0; i < row.length; i++) {
                    row[i] = Integer.parseInt(sa[i]);
                }
                matrix[x++] = row;
                line = bufRead.readLine();

            }
            System.out.println(count);
            bufRead.close();

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void run() {
        while (!moveStack.empty()) {
            Move m = moveStack.pop();

            if (m.x >= 0 && m.x < matrix.length && m.y >= 0 && m.y < matrix[0].length) {
                m.cost += matrix[m.x][m.y];
                if (updateCost(m.x, m.y, m.cost)) {
                    moveStack.push(new Move(m.x, m.y + 1, m.cost));
                    if (m.y < matrix[0].length - 1) {
                        moveStack.push(new Move(m.x + 1, m.y, m.cost));
                        moveStack.push(new Move(m.x - 1, m.y, m.cost));
                    }
                    // moveStack.push(new Move(m.x, m.y - 1, m.cost));

                    if (m.cost == 0)
                        break;
                }
            }
        }
    }

    private static boolean updateCost(int x, int y, int cost) {
        if (x == matrix.length - 1 && y == matrix[0].length - 1) {
            if (bestSolutionSoFar < cost) {
                bestSolutionSoFar = cost;
            }
        }
        if (bestSolutionSoFar < cost) {
            return false;
        }
        if (visitedCost[x][y] > cost) {
            visitedCost[x][y] = cost;
            return true;
        }
        return false;
    }

    private static void initCost() {
        for(int x = 0; x < visitedCost.length; x++) {
            for(int y = 0; y < visitedCost[0].length; y++) {
                visitedCost[x][y] = Integer.MAX_VALUE;
            }
        }
        bestSolutionSoFar = 0;
        for(int x = 0; x < visitedCost.length; x++) {
            bestSolutionSoFar += matrix[x][0];
        }
        for(int y = 1; y < visitedCost[0].length; y++) {
            bestSolutionSoFar += matrix[visitedCost.length - 1][y];
        }
    }
}
