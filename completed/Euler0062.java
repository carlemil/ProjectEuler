package completed;

import java.util.Arrays;
import java.util.HashMap;

// The cube, 41063625 (345^3), can be permuted to produce two other
// cubes: 56623104 (384^3) and 66430125 (405^3). In fact, 41063625 is
// the smallest cube which has exactly three permutations of its
// digits which are also cube.
//
// Find the smallest cube for which exactly five permutations of its
// digits are cube.

public class Euler0062 {

    static HashMap<String, Pair<Long, Integer>> map = new HashMap<String, Pair<Long, Integer>>();
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
            char[] q3ca = q3.toString().toCharArray();
            java.util.Arrays.sort(q3ca);
            String s = Arrays.toString(q3ca);
            if(map.containsKey(s)){
                Pair<Long, Integer> pair = map.get(s);
                if (++pair.count == PERMS) {
                    candidateFound = true;
                }
            } else {
                map.put(s, new Pair<Long, Integer>(q3,1));
            }
            if (candidateFound && prevLength != s.length()) {
                search = false;
            }
            prevLength = s.length();
        }

        Long n = Long.MAX_VALUE;
        for (Pair<Long, Integer> p : map.values()) {
            if (p.count == PERMS && p.number < n) {
                n = p.number;
            }
        }
        System.out.println(n);
        System.out.println("time: " + (System.currentTimeMillis() - time) + "ms");
    }
}

class Pair<T1, T2> {
    public Long number = 0l;
    public Integer count = 0;

    public Pair(T1 number, T2 count) {
        this.number = (Long) number;
        this.count = (Integer) count;
    }
}
