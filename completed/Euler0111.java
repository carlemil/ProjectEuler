package completed;

import java.util.HashSet;

import com.kjellstrand.euler.Tools;

/*
 Considering 4-digit primes containing repeated digits it is clear that they cannot all be the same: 
 1111 is divisible by 11, 2222 is divisible by 22, and so on. But there are nine 4-digit primes 
 containing three ones:

 1117, 1151, 1171, 1181, 1511, 1811, 2111, 4111, 8111

 We shall say that M(n, d) represents the maximum number of repeated digits for an n-digit prime 
 where d is the repeated digit, N(n, d) represents the number of such primes, and S(n, d) represents 
 the sum of these primes.

 So M(4, 1) = 3 is the maximum number of repeated digits for a 4-digit prime where one is the 
 repeated digit, there are N(4, 1) = 9 such primes, and the sum of these primes is S(4, 1) = 22275. 
 It turns out that for d = 0, it is only possible to have M(4, 0) = 2 repeated digits, but there 
 are N(4, 0) = 13 such cases.

 In the same way we obtain the following results for 4-digit primes.

 // Digit, d	  M(4, d)	N(4, d)	S(4, d)
 //        0	  2	    13  	67061
 //        1	  3    	9   	22275
 //        2	  3   	1   	2221
 //        3	  3   	12  	46214
 //        4      3   	2   	8888
 //        5	  3   	1   	5557
 //        6	  3   	1   	6661
 //        7	  3   	9   	57863
 //        8	  3   	1   	8887
 //        9	  3   	7   	48073
 // For d = 0 to 9, the sum of all S(4, d) is 273700.

 Find the sum of all S(10, d).

 */
public class Euler0111 {
    static final int     len         = 10;

    static HashSet<Long> foundPrimes = new HashSet<Long>();

    public static void main(String[] args) {
        long time = System.currentTimeMillis();

        long min = (long) Math.pow(10, len - 1);
        long max = (long) Math.pow(10, len);

        long sum = 0;

        for(int fill = 0; fill < 10; fill++) {
            long fillSum = 0;
            int nbrOfPrimes = 0;
            if (fill != 0) {
                for(int pos = 0; pos < len; pos++) {
                    long filled = getFill(fill);
                    for(int d = 0; d <= 9; d++) {
                        long numberToTest = addDtoPos(filled, d, pos, fill);
                        if (numberToTest > min && numberToTest < max && !foundPrimes.contains(numberToTest)
                                && Tools.isPrime(numberToTest)) {
                            foundPrimes.add(numberToTest);
                            fillSum += numberToTest;
                            nbrOfPrimes++;
                        }
                    }
                }
            }
            if (fillSum == 0) {
                for(int pos1 = 0; pos1 < len; pos1++) {
                    long filled = getFill(fill);
                    for(int d1 = 0; d1 <= 9; d1++) {
                        for(int pos2 = 0; pos2 < len; pos2++) {
                            for(int d2 = 0; d2 <= 9; d2++) {
                                long numberToTest = addD1toPos1AndD2ToPos2(filled, d1, d2, pos1, pos2, fill);
                                if (numberToTest > min && numberToTest < max && !foundPrimes.contains(numberToTest)
                                        && Tools.isPrime(numberToTest)) {
                                    foundPrimes.add(numberToTest);
                                    fillSum += numberToTest;
                                    nbrOfPrimes++;
                                }
                            }
                        }

                    }
                }
            }
            sum += fillSum;
            fillSum = 0;
        }

        System.out.println("sum: " + sum);

        System.out.println("time: " + (System.currentTimeMillis() - time) + "ms");
    }

    private static long addD1toPos1AndD2ToPos2(long filled, int d1, int d2, int pos1, int pos2, int fill) {
        filled -= (long) (fill * Math.pow(10, pos1));
        filled += (long) (d1 * Math.pow(10, pos1));

        filled -= (long) (fill * Math.pow(10, pos2));
        filled += (long) (d2 * Math.pow(10, pos2));

        return filled;
    }

    private static long addDtoPos(long filled, int d, int pos, int fill) {
        filled -= (long) (fill * Math.pow(10, pos));
        filled += (long) (d * Math.pow(10, pos));

        return filled;
    }

    static long getFill(int fill) {
        long filled = 0;
        for(int i = 0; i < len; i++) {
            filled += fill * Math.pow(10, (len - 1) - i);
        }
        return filled;
    }
}
