package completed;

import java.util.HashSet;
import java.util.Set;

import com.kjellstrand.euler.Tools;

/*
 By replacing the 1st digit of *3, it turns out that six of the nine 
 possible values: 13, 23, 43, 53, 73, and 83, are all prime.

 By replacing the 3rd and 4th digits of 56**3 with the same digit, 
 this 5-digit number is the first example having seven primes among 
 the ten generated numbers, yielding the family: 
 56003, 56113, 56333, 56443, 56663, 56773, and 56993. 
 Consequently 56003, being the first member of this family, is the 
 smallest prime with this property.

 Find the smallest prime which, by replacing part of the number (not 
 necessarily adjacent digits) with the same digit, is part of an eight 
 prime value family.
 */
public class Euler0051 {
    static final int    lookingForFamilySize = 8;
    static long         time;

    static Set<Integer> set                  = new HashSet<Integer>();

    public static void main(String[] args) {
        time = System.currentTimeMillis();
        int p = 1;

        while (true) {
            if (testFamily(p)) {
                break;
            }
            p++;
        }

    }

    static boolean testFamily(int p) {
        if (Tools.isPrime(p)) {
            int[] pa = new int[(int) Math.log10(p) + 1];
            for(int i = 0; i < pa.length; i++) {
                pa[i] = p % (int) Math.pow(10, i + 1) / (int) Math.pow(10, i);
            }
            if (Tools.isPrime(p)) {
                findFamilyMembers(p, pa);
            }
        }
        return false;
    }

    static void findFamilyMembers(int p, int[] pa) {
        for(int dd = 1; dd < pa.length; dd++) {
            boolean hasMorePermutations = true;
            int perm[] = new int[pa.length];
            for(int ddd = 0; ddd < perm.length; ddd++) {
                perm[ddd] = 1;
            }
            for(int ddd = 0; ddd < dd; ddd++) {
                perm[ddd] = 0;
            }
            while (hasMorePermutations) {

                int c = 10;
                set.clear();
                for(int i = 0; i < 10; i++) {

                    int pp = buildPP(p, i, pa, perm);

                    if (!Tools.isPrime(pp)) {
                        c--;
                        if (c < lookingForFamilySize) {
                            break;
                        }
                    }
                    else {
                        set.add(pp);
                    }
                }
                if (c >= lookingForFamilySize) {

                    System.out.println(findMinPrime(set));
                    System.out.println("time: " + (System.currentTimeMillis() - time) + "ms");
                    System.exit(0);
                }
                hasMorePermutations = Tools.permuteLexically(perm);
            }
        }
    }

    static int findMinPrime(Set<Integer> set) {
        int min = Integer.MAX_VALUE;
        for(Integer m : set) {
            if (m < min) {
                min = m;
            }
        }
        return min;
    }

    static int buildPP(int p, int i, int pa[], int perm[]) {
        int ret = p;
        // System.out.println("pa:");
        // Tools.printIntArray(pa);
        // System.out.println("perm:");
        // Tools.printIntArray(perm);
        // System.out.println("p: " + p + " i: " + i);
        if (i == 0 && perm[perm.length - 1] == 1) {
            return 4;
        }
        for(int j = 0; j < perm.length; j++) {
            // System.out.println("perm[j] : " + perm[j] + " j: " + j);
            if (perm[j] == 1) {
                int pow = (int) Math.pow(10, j);
                // System.out.println("pow: " + pow + " pa[1]: " + pa[1] + " i: " + i);
                ret += i * pow - pa[j] * pow;
            }
        }
        return ret;
    }
}
