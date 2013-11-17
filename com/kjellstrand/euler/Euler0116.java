package com.kjellstrand.euler;

//If a box contains twenty-one coloured discs, composed of fifteen blue 
//discs and six red discs, and two discs were taken at random, it can 
//be seen that the probability of taking two blue discs, 
//P(BB) = (15/21)(14/20) = 1/2.
//
//The next such arrangement, for which there is exactly 50% chance of 
//taking two blue discs at random, is a box containing eighty-five blue 
//discs and thirty-five red discs.
//
//By finding the first arrangement to contain over 10^12 = 1,000,000,000,000 
//discs in total, determine the number of blue discs that the box would 
//contain.

public class Euler0116 {

    public static void main(String[] args) {
        long time = System.currentTimeMillis();

        long start = 1000000000000l;
        long blue = start * 14 / 21;

        while (true) {
            long sum = blue * (blue - 1) * 2;
            System.out.println("sum: " + sum);
            long val = (long) Math.sqrt(sum);
            long tot = val * (val - 1);
            System.out.println("tot: " + tot);

            if (tot > start && tot == sum) {
                System.out.println("Math.ceil(val): " + (long) Math.ceil(val) + " Math.floor(val) " + (long) Math.floor(val));
                System.out.println("blue: " + blue);
                System.out.println("val: " + val);
                System.out.println("res: " + (long) ((Math.ceil(val) * Math.floor(val))));
                break;
            }

            // 890,284,329,856,541,301,737,330.000000000
            // 890,284,329,857,925,730,099,344.000000000
            // 890,284,329,860,594,489,106,612.000000000
            // 8.902843299×10²³

            // blue: 667189751817
            // sum: 7567372555350007952
            // val: 2750885776

            blue++;
        }

        System.out.println("time: " + (System.currentTimeMillis() - time) + "ms");
    }
}
