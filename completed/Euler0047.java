package completed;

import java.util.ArrayList;

import com.kjellstrand.euler.Tools;

//The first two consecutive numbers to have two distinct prime factors are:
//
//14 = 2  7
//15 = 3  5
//
//The first three consecutive numbers to have three distinct prime factors are:
//
//644 = 2^2  7  23
//645 = 3  5  43
//646 = 2  17  19.
//
//Find the first four consecutive integers to have four distinct primes factors. 
//What is the first of these numbers?

public class Euler0047 {
    static ArrayList<Integer> factors = new ArrayList<Integer>();

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        int numberOfDistinct = 4;
        int i = 0;

        while (true) {
            i++;
            factors.addAll(Tools.distinctPrimeFactors(i));
            if (factors.size() == numberOfDistinct) {
                factors.addAll(Tools.distinctPrimeFactors(i + 1));
                if (factors.size() == numberOfDistinct * 2) {
                    factors.addAll(Tools.distinctPrimeFactors(i + 2));
                    if (factors.size() == numberOfDistinct * 3) {
                        factors.addAll(Tools.distinctPrimeFactors(i + 3));
                        if (factors.size() == numberOfDistinct * 4) {
                            break;
                        }
                    }
                }
            }
            factors.clear();
        }
        System.out.println(i);
        System.out.println("time: " + (System.currentTimeMillis() - time) + "ms");
    }

}
