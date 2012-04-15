package completed;

import java.math.BigInteger;

//It is possible to show that the square root of two can be expressed as an infinite 
//continued fraction.
//
//sqrt(2) = 1 + 1/(2 + 1/(2 + 1/(2 + ... ))) = 1.414213...
//
//By expanding this for the first four iterations, we get:
//
//1 + 1/2 = 3/2 = 1.5
//1 + 1/(2 + 1/2) = 7/5 = 1.4
//1 + 1/(2 + 1/(2 + 1/2)) = 17/12 = 1.41666...
//1 + 1/(2 + 1/(2 + 1/(2 + 1/2))) = 41/29 = 1.41379...
//
//The next three expansions are 99/70, 239/169, and 577/408, but the eighth expansion, 
//1393/985, is the first example where the number of digits in the numerator exceeds 
//the number of digits in the denominator.
//
//In the first one-thousand expansions, how many fractions contain a numerator with 
//more digits than denominator?

public class Euler0057 {

    public static void main(String[] args) {
        long time = System.currentTimeMillis();

        int c = 0;
        int i = 0;
        BigInteger two = new BigInteger("2");

        BigInteger n0, n1, n2;
        n0 = new BigInteger("0");
        n1 = new BigInteger("1");
        n2 = new BigInteger("1");

        BigInteger d0, d1, d2;
        d0 = new BigInteger("0");
        d1 = new BigInteger("1");
        d2 = new BigInteger("0");

        while (i++ <= 1000) {
            n0 = n1.multiply(two).add(n2);
            d0 = d1.multiply(two).add(d2);
            n2 = n1;
            d2 = d1;
            n1 = n0;
            d1 = d0;
            if (d0.toString().length() < n0.toString().length()) {
                c++;
            }
        }
        System.out.println("time: " + (System.currentTimeMillis() - time) + "ms");
        System.out.println(c);
    }
}
