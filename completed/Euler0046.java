package completed;

import java.util.Vector;

import com.kjellstrand.euler.Tools;

//It was proposed by Christian Goldbach that every odd composite number
//can be written as the sum of a prime and twice a square.
//
//9 = 7 + 2*1^2
//15 = 7 + 2*2^2
//21 = 3 + 2*3^2
//25 = 7 + 2*3^2
//27 = 19 + 2*2^2
//33 = 31 + 2*1^2
//
//It turns out that the conjecture was false.
//
//What is the smallest odd composite that cannot be written as the sum of
//a prime and twice a square?

public class Euler0046 {
    static Vector<Integer> primes;

    public static void main(String[] args) {
        long time = System.currentTimeMillis();

        primes = Tools.getPrimes(5000);

        int i = 9;
        while (goldbachTest(i)) {
            i += 2;
        }

        System.out.println("time: " + (System.currentTimeMillis() - time) + "ms");
    }

    private static boolean goldbachTest(int i) {
        if (!Tools.isPrime(i)) {
            for(int hs = 0; hs < Math.sqrt(i / 2); hs++) {
                for(Integer p : primes) {
                    if (p + hs * hs * 2 == i) {
                        return true;
                    }
                }
            }
        }
        else {
            return true;
        }
        System.out.println(i);
        return false;
    }
}
