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

    static HashMap<String, Long[]> map = new HashMap<String, Long[]>();
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
                Long[] pair = map.get(s);
                if (++pair[1] == PERMS) {
                    candidateFound = true;
                }
            } else {
                map.put(s, new Long[]{q3,1l});
            }
            if (candidateFound && prevLength != s.length()) {
                search = false;
            }
            prevLength = s.length();
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

        System.out.println("\n--- 1 ---");
        sort(333333333333l);
        System.out.println("\n--- 2 ---");
        sort(9871214);
        System.out.println("\n--- 4 ---");
        sort(127035954683l);
        System.out.println("\n--- 5 ---");
        sort(999999999999l);

    }

    private static int[] tmp = new int[13];
    static private int sort(long s){
        int sorted = 0;
        int i=0;
        while(i<tmp.length){
        tmp[i++] = (int) (s%10);
        s/=10;
        }
        java.util.Arrays.sort(tmp);
        for(int n: tmp){
//            if(n==0){
//                break;
//            }
            System.out.print(n+" ");
        }

        return sorted;
    }
}

//class Pair<T1, T2> {
//    public Long number = 0l;
//    public Integer count = 0;
//
//    public Pair(T1 number, T2 count) {
//        this.number = (Long) number;
//        this.count = (Integer) count;
//    }
//}
