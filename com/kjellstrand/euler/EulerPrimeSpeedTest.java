package com.kjellstrand.euler;

import java.math.BigInteger;

public class EulerPrimeSpeedTest {

    public static void main(String[] args) {
        int max = 20;
        long time = System.currentTimeMillis();
        int[] p = Tools.getPrimesIntArray(max);
        double t = (System.currentTimeMillis() - time);
        System.out.println(p.length + " primes tested in " + t + "ms");
        System.out.println( p.length/t*1000 + " primes/s");
        time = System.currentTimeMillis();

        long c = 1;
        BigInteger bi = BigInteger.ZERO;
        for (int i = 0; i < max; i++) {
            bi = bi.add(BigInteger.ONE);
            if (Tools.isPrime(bi)) {
                c++;
            }
        }
        t = (System.currentTimeMillis() - time);
        System.out.println(c + " primes tested in " + t + "ms");
        System.out.println(c/t*1000 + " primes/s");        
        for (int i = 0; i < max; i++) {
            if (Tools.isPrimeRegexp(i)) {
                System.out.println(i);
            }
        }
    }
}
