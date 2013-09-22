package completed;

import com.kjellstrand.euler.Tools;

// A composite is a number containing at least two prime factors.
// For example, 15 = 3 × 5; 9 = 3 × 3; 12 = 2 × 2 × 3.
//
// There are ten composites below thirty containing precisely two,
// not necessarily distinct, prime factors:
// 4, 6, 9, 10, 14, 15, 21, 22, 25, 26.
//
// How many composite integers, n < 10^8, have precisely two,
// not necessarily distinct, prime factors?

public class Euler0187 {

    public static void main(String[] args) {
        long time = System.currentTimeMillis();

        Long problemSize = 100000000l;
        // 17 427 258
        Long maxPrime = problemSize / 2;
        Integer[] iprimes = Tools.getPrimesVector(maxPrime.intValue()).toArray(new Integer[0]);
        Long primes[] = new Long[iprimes.length];
        for (int i = 0; i < iprimes.length; i++) {
            primes[i] = new Long(iprimes[i]);
        }
        long sum = 1;
        for (int i = 0; i < Math.sqrt(primes.length); i++) {

            Long p = bs(new Long(0), new Long(primes.length - 1),
                    new Long(primes.length / 2), primes, problemSize, primes[i]);

            if(p>i){
            sum += p-i;
            }
            
        }
        System.out.println(sum);

        System.out.println("time: " + (System.currentTimeMillis() - time) + "ms");
    }

    private static Long bs(Long lb, Long ub, Long p, Long[] primes, Long problemSize, Long prime) {
        if (ub - lb<=1) {
            return ub;
        }
        if (prime * primes[p.intValue()] < problemSize) {
            lb = p;
        } else {
            ub = p;
        }
        p = (ub - lb ) / 2 + lb;
        return bs(lb, ub, p, primes, problemSize, prime);
    }
}
