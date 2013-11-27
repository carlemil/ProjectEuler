
package completed;

import java.util.HashMap;

// The cube, 41063625 (345^3), can be permuted to produce two other
// cubes: 56623104 (384^3) and 66430125 (405^3). In fact, 41063625 is
// the smallest cube which has exactly three permutations of its
// digits which are also cube.
//
// Find the smallest cube for which exactly five permutations of its
// digits are cube.

public class Euler0062 {

    static HashMap<Long, Long[]> map = new HashMap<Long, Long[]>();

    static final int PERMS = 5;

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        boolean search = true;
        boolean candidateFound = false;
        int prevLength = 0;
        int q = 1;
        Long q3 = new Long(Long.MAX_VALUE);
        while (search) {
            q3 = (long) Math.pow(q++, 3);
            Long l = sort(q3);
            if (map.containsKey(l)) {
                Long[] pair = map.get(l);
                if (++pair[1] == PERMS) {
                    candidateFound = true;
                }
            } else {
                map.put(l, new Long[] {
                        q3, 1l
                });
            }
            if (candidateFound && prevLength != Math.log10(l)) {
                search = false;
            }
            prevLength = (int) Math.log10(l);
        }

        Long n = Long.MAX_VALUE;
        for (Long[] p : map.values()) {
            if (p[1] == PERMS && p[0] < n) {
                n = p[0];
            }
        }
        Long now = System.currentTimeMillis();
        System.out.println("time: " + (now - time) + "ms");
        System.out.println(n);
    }

    private static int[] tmp = new int[13];

    static private long sort(long s) {
        long sorted = 0;
        int i = 0;
        while (i < tmp.length) {
            tmp[i++] = (int) (s % 10);
            s /= 10;
        }
        java.util.Arrays.sort(tmp);
        for (int n : tmp) {
            sorted = sorted * 10l + n;
        }

        return sorted;
    }
}
