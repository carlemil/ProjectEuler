package completed;

import java.math.BigInteger;

//The square root of 2 can be written as an infinite continued fraction.
//
//The infinite continued fraction can be written, 2 = [1;(2)], (2) indicates that 2 
//repeats ad infinitum. In a similar way, 23 = [4;(1,3,1,8)].
//
//It turns out that the sequence of partial values of continued fractions for square 
//roots provide the best rational approximations. Let us consider the convergents for 2.
//
//Hence the sequence of the first ten convergents for 2 are:
//
//1, 3/2, 7/5, 17/12, 41/29, 99/70, 239/169, 577/408, 1393/985, 3363/2378, ...
//What is most surprising is that the important mathematical constant,
//e = [2; 1,2,1, 1,4,1, 1,6,1 , ... , 1,2k,1, ...].
//
//The first ten terms in the sequence of convergents for e are:
//
//2, 3, 8/3, 11/4, 19/7, 87/32, 106/39, 193/71, 1264/465, 1457/536, ...
//The sum of digits in the numerator of the 10th convergent is 1+4+5+7=17.
//
//Find the sum of digits in the numerator of the 100th convergent of the continued fraction for e.

public class Euler0065 {
    public static void main(String[] args) {
        long time = System.currentTimeMillis();

        BigInteger n0 = new BigInteger("0");// 0;
        BigInteger n1 = new BigInteger("1");// 1;
        BigInteger n2 = new BigInteger("1");// 1;
        BigInteger r = new BigInteger("1");

        BigInteger two = new BigInteger("2");
        BigInteger pow;

        for(int i = 1; i <= 100; i++) {
            n0 = n1.add(n2);
            if (i % 3 == 0) {
                pow = n1.multiply(r);
                n0 = n0.add(pow);
                r = r.add(two);
            }
            n2 = n1;
            n1 = n0;
        }

        String n = n0.toString();

        int sum = 0;
        while (n.length() > 0) {
            sum += Integer.parseInt(n.substring(n.length() - 1));
            n = n.substring(0, n.length() - 1);
        }
        System.out.println(sum);
        System.out.println("time: " + (System.currentTimeMillis() - time) + "ms");
    }
}
