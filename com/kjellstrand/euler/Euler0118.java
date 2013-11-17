package com.kjellstrand.euler;

// Using all of the digits 1 through 9 and concatenating them freely to
// form decimal integers, different sets can be formed. Interestingly
// with the set {2,5,47,89,631}, all of the elements belonging to it
// are prime.
//
// How many distinct sets containing each of the digits one through
// nine exactly once contain only prime elements?

public class Euler0118 {

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        
        int c=0;
        
        int max = 9;
        int[] digits = new int[max];

        for (int i = 1; i <= max; i++) {
            digits[i - 1] = i;
        }

      
        System.out.println("time: " + (System.currentTimeMillis() - time) + "ms");
        System.out.println("c: " + c);
    }
}
