package com.kjellstrand.euler;

// The 5-digit number, 16807=7^5, is also a fifth power. Similarly,
// the 9-digit number, 134217728=8^9, is a ninth power.
//
// How many n-digit positive integers exist which are also an nth power?

public class Euler0063 {

    public static void main(String[] args) {
        long time = System.currentTimeMillis();

        int s = 0;
        int n = 0;
        while (++n < 10) {
            int p = 0;
            int sl = s;
            boolean loop = true;
            while (loop) {
                p++;
                int pow = (int) (Math.log10(Math.pow(n, p)) + 1);
                if (pow == p) {
                    s++;
                } else if (s != sl) {
                    loop = false;
                }
            }
        }
        System.out.println(s);

        System.out.println("time: " + (System.currentTimeMillis() - time) + "ms");
    }
}
