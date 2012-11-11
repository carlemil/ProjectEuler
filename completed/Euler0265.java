
package completed;

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
        long startTime = System.currentTimeMillis();

        long res = check(0, 1, 1);

        long endTime = System.currentTimeMillis();

        System.out.println(res);
        System.out.println("time: " + (endTime - startTime) + "ms");
    }

    public static long check(long circ, long pos, long used) {
        long ret = 0;
        long maskAtPos = MASK << (pos);

        if (pos >= maxpos) {
            return Long.reverse(circ) >> (64 - maxpos);
        }
        long maskedAtPos = circ & maskAtPos;
        long masked = maskedAtPos >> pos;
        if (((1l << masked) & used) == 0) {
            used += (1l << masked);
            ret += check(circ, pos + 1l, used);
            used -= (1l << masked);
        }
        maskedAtPos += 1l << (N + pos - 1l);
        masked = maskedAtPos >> pos;
        if (((1l << masked) & used) == 0) {
            used += (1l << masked);
            circ += 1l << (N + pos - 1l);
            ret += check(circ, pos + 1l, used);
            used -= (1l << masked);
            circ -= 1l << (N + pos - 1l);
        }
        return ret;
    }
}
