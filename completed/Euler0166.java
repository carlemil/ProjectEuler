
package completed;

//    A 4x4 grid is filled with digits d, 0  d  9.
//    
//    It can be seen that in the grid
//    
//    6 3 3 0
//    5 0 4 3
//    0 7 1 4
//    1 2 4 5
//    
//    the sum of each row and each column has the value 12. 
//    Moreover the sum of each diagonal is also 12.
//    
//    In how many ways can you fill a 4x4 grid with the 
//    digits d, 0  d  9 so that each row, each column, 
//    and both diagonals have the same sum?

public class Euler0166 {

    private final static int[][] a = new int[4][4];

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        long res = 0;
        for (int i = 0; i <= 4 * 9; i++) {
            res += findSum00(i);
        }
        System.out.println("time: " + (System.currentTimeMillis() - time) + "ms");
        System.out.println(res);
    }

    public static long findSum00(int sum) {
        long res = 0;
        int ll = 0;
        int ul = 9;
        for (int i = ll; i <= ul; i++) {
            a[0][0] = i;
            res += findSum01(sum);
        }
        return res;
    }

    public static long findSum01(int sum) {
        long res = 0;
        int ll = 0;
        int ul = 9;
        for (int i = ll; i <= ul; i++) {
            a[0][1] = i;
            res += findSum02(sum);
        }
        return res;
    }

    public static long findSum02(int sum) {
        long res = 0;
        int ll = 0;
        int ul = 9;
        for (int i = ll; i <= ul; i++) {
            a[0][2] = i;
            int t = sum - (a[0][0] + a[0][1] + a[0][2]);
            if (t >= 0 && t <= 9) {
                a[0][3] = t;
                res += findSum10(sum);
            }
        }
        return res;
    }

    public static long findSum10(int sum) {
        long res = 0;
        int ll = 0;
        int ul = 9;
        for (int i = ll; i <= ul; i++) {
            a[1][0] = i;
            res += findSum20(sum);
        }
        return res;
    }

    public static long findSum20(int sum) {
        long res = 0;
        int ll = 0;
        int ul = 9;
        for (int i = ll; i <= ul; i++) {
            a[2][0] = i;
            int t = sum - (a[0][0] + a[1][0] + a[2][0]);
            if (t >= 0 && t <= 9) {
                a[3][0] = t;
                res += findSum21(sum);
            }
        }
        return res;
    }

    public static long findSum21(int sum) {
        long res = 0;
        int ll = 0;
        int ul = 9;
        for (int i = ll; i <= ul; i++) {
            a[2][1] = i;
            int t = sum - (a[3][0] + a[2][1] + a[0][3]);
            if (t >= 0 && t <= 9) {
                a[1][2] = t;
                res += findSum22(sum);
            }
        }
        return res;
    }

    public static long findSum22(int sum) {
        long res = 0;
        int ll = 0;
        int ul = 9;
        for (int i = ll; i <= ul; i++) {
            a[2][2] = i;
            int t1 = sum - (a[2][0] + a[2][1] + a[2][2]);
            int t2 = sum - (a[0][2] + a[1][2] + a[2][2]);
            if (t1 >= 0 && t1 <= 9 && t2 >= 0 && t2 <= 9) {
                a[2][3] = t1;
                a[3][2] = t2;
                res += findSum11(sum);
            }
        }
        return res;
    }

    public static long findSum11(int sum) {
        long res = 0;
        int ll = 0;
        int ul = 9;
        for (int i = ll; i <= ul; i++) {
            a[1][1] = i;
            int t31 = sum - (a[0][1] + a[1][1] + a[2][1]);
            if (t31 >= 0 && t31 <= 9) {
                a[3][1] = t31;
                int t13 = sum - (a[1][0] + a[1][1] + a[1][2]);
                if (t13 >= 0 && t13 <= 9) {
                    a[1][3] = t13;
                    res += findSum33(sum);
                }
            }
        }
        return res;
    }

    public static long findSum33(int sum) {
        long res = 0;
        int ll = 0;
        int ul = 9;
        for (int i = ll; i <= ul; i++) {
            a[3][3] = i;
            if (sum == a[0][0] + a[1][1] + a[2][2] + a[3][3]) {
                if (sum == a[3][0] + a[3][1] + a[3][2] + a[3][3]) {
                    if (sum == a[0][3] + a[1][3] + a[2][3] + a[3][3]) {
                        res += 1;
                    }
                }
            }
        }
        return res;
    }

}
