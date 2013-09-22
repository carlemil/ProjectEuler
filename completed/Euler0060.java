package completed;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

import com.kjellstrand.euler.Tools;

// The primes 3, 7, 109, and 673, are quite remarkable.
// By taking any two primes and concatenating them in any
// order the result will always be prime. For example,
// taking 7 and 109, both 7109 and 1097 are prime. The sum
// of these four primes, 792, represents the lowest sum
// for a set of four primes with this property.
//
// Find the lowest sum for a set of five primes for which
// any two primes concatenate to produce another prime.

public class Euler0060 {
    
    private static Set<Integer> p = new HashSet<Integer>();

    public static void main(String[] args) {
        long time = System.currentTimeMillis();

        int max = 100000000;
        Vector<Integer> primeList = Tools.getPrimesVector(max);
        System.out.println("Got primelist");
        
        for (Integer i: primeList){
            p.add(i);
        }
        
        int p1 = 0;
        int p2 = 1;
        int p3 = 2;
        int p4 = 3;
        int p5 = 4;

        int maxLoop = 2630;

        for (p5 = 0; p5 < maxLoop; p5++) {
            int pp5 = primeList.get(p5);
            int pp5_ = (int) (Math.pow(10, Math.ceil(Math.log10(pp5))));

            for (p4 = 0; p4 < maxLoop; p4++) {
                int pp4 = primeList.get(p4);
                int pp4_ = (int) (Math.pow(10, Math.ceil(Math.log10(pp4))));
                if (!p.contains(pp4 + pp5 * pp4_) || !p.contains(pp5 + pp4 * pp5_)) {
                    continue;
                }
                for (p3 = p4 + 1; p3 < maxLoop; p3++) {
                    int pp3 = primeList.get(p3);
                    int pp3_ = (int) (Math.pow(10, Math.ceil(Math.log10(pp3))));
                    if (!p.contains(pp3 + pp4 * pp3_) || !p.contains(pp4 + pp3 * pp4_) ||
                            !p.contains(pp3 + pp5 * pp3_) || !p.contains(pp5 + pp3 * pp5_)) {
                        continue;
                    }

                    for (p2 = p3 + 1; p2 < maxLoop; p2++) {
                        int pp2 = primeList.get(p2);
                        int pp2_ = (int) (Math.pow(10, Math.ceil(Math.log10(pp2))));
                        if (!p.contains(pp2 + pp3 * pp2_) || !p.contains(pp3 + pp2 * pp3_) ||
                                !p.contains(pp2 + pp4 * pp2_) || !p.contains(pp4 + pp2 * pp4_) ||
                                !p.contains(pp2 + pp5 * pp2_) || !p.contains(pp5 + pp2 * pp5_)) {
                            continue;
                        }

                        for (p1 = p2 + 1; p1 < maxLoop; p1++) {
                            int pp1 = primeList.get(p1);
                            int pp1_ = (int) (Math.pow(10, Math.ceil(Math.log10(pp1))));
                            //System.out.println( pp1 + " " + pp2);
                            if (!p.contains(pp1 + pp2 * pp1_) || !p.contains(pp2 + pp1 * pp2_) ||
                                    !p.contains(pp1 + pp3 * pp1_) || !p.contains(pp3 + pp1 * pp3_) ||
                                    !p.contains(pp1 + pp4 * pp1_) || !p.contains(pp4 + pp1 * pp4_) ||
                                    !p.contains(pp1 + pp5 * pp1_) || !p.contains(pp5 + pp1 * pp5_)) {
                                continue;
                            }

                            System.out.println((pp1 + pp2 + pp3 + pp4 + pp5) + " - " + pp1 + " " + pp2 + " " + pp3
                                    + " " + pp4 + " " + pp5);
                            
                        }
                    }
                }
            }
        }
        System.out.println("time: " + (System.currentTimeMillis() - time) + "ms");
    }
}
