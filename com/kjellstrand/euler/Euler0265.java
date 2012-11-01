
package com.kjellstrand.euler;

/*
 2^N binary digits can be placed in a circle so that all 
 the N-digit clockwise subsequences are distinct.

 For N=3, two such circular arrangements are possible, 
 ignoring rotations:


 For the first arrangement, the 3-digit subsequences, in 
 clockwise order, are:
 000, 001, 010, 101, 011, 111, 110 and 100.

 Each circular arrangement can be encoded as a number by 
 concatenating the binary digits starting with the 
 subsequence of all zeros as the most significant bits 
 and proceeding clockwise. The two arrangements for N=3 
 are thus represented as 23 and 29:

 00010111 2 = 23
 00011101 2 = 29
 Calling S(N) the sum of the unique numeric representations, 
 we can see that S(3) = 23 + 29 = 52.

 Find S(5).
 */
public class Euler0265 {

    static long count = 0;
    static final long MASK = 1 + 2 + 4 + 8 + 16; // a 11111 mask
    static final long N = 5;
    static final long maxpos = (long) Math.pow(2d, N);

    public static void main(String[] args) {


        System.out.println(check(0, 1, 1));
        System.out.println("maxpos " + maxpos);
        
//        used: 11111111111111111110111110110101
//        circ: 11001110101000100101101111100000
    }

    public static long check(long circ, long pos, long used) {
        long ret = 0;

        long maskAtPos = MASK << (pos);
       // System.out.println("  maskAtPos: " + Integer.toBinaryString(maskAtPos));
        
        if (pos >= maxpos) {
//            System.out.println("used: " + Long.toBinaryString(used));
//            System.out.println("pos: " + pos);
//            System.out.println("circ: " + Long.toBinaryString(circ));
//            System.out.println(pos);
            System.out.println("found one: "+(Long.toBinaryString(Long.reverse(circ)>>(64-maxpos))));
            return Long.reverse(circ)>>(64-maxpos);
        }
        // Check maskAtPos set to 0xy
        long maskedAtPos = circ & maskAtPos;
        long masked = maskedAtPos >> pos;
       // System.out.println("maskedAtPos: "+Integer.toBinaryString(maskedAtPos));
        //System.out.println("masked     : "+Integer.toBinaryString(masked));
        
        if (((1l << masked) & used) == 0) {
            // mark used
            used += (1l << masked);
           // System.out.println("------ 0");
            ret += check(circ, pos + 1l, used);
            //System.out.println("------");
            used -= (1l << masked);
            // unmark used
        }else{
            //System.out.println("used 0");
        }
        // Check maskAtPos set to 1xy
        // mark used
        maskedAtPos += 1l << (N + pos - 1l);
        masked = maskedAtPos >> pos;
        //System.out.println("maskedAtPos: "+Integer.toBinaryString(maskedAtPos));
        //System.out.println("masked     : "+Integer.toBinaryString(masked));
        
        if (((1l << masked) & used) == 0) {
            // mark used
            used += (1l << masked);
            circ += 1l << (N+pos-1l);
            //System.out.println("------ 1");
            ret += check(circ, pos + 1l, used);
            //System.out.println("------");

            used -= (1l << masked);
            circ -= 1l << (N+pos-1l);

            // unmark used
        }else{
            //System.out.println("used 1");
        }
        // unmark used
        return ret;
    }
}
