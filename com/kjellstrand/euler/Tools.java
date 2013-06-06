
package com.kjellstrand.euler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Vector;
import java.util.regex.Pattern;

public class Tools {

	public static boolean isBouncy(long number) {

		long dir = 0;
		long prevD = number - ((number / 10) * 10);
		long d = prevD;
		long prevDir = 0;
		long tmp = 0;

		while (number > 0) {
			prevD = d;
			d = number - ((number / 10) * 10);
			tmp = prevD - d;

			if (tmp != 0) {
				prevDir = dir;
				dir = tmp;
			}

			if (dir > 0 && prevDir < 0 || dir < 0 && prevDir > 0) {
				return true;
			}
			number /= 10;
		}
		return false;
	}

    public static ArrayList<Integer> primeFactors(int numbers) {

        // for faster->
        // http://www.math.mtu.edu/mathlab/COURSES/holt/dnt/divis2.html
        int n = numbers;
        ArrayList<Integer> factors = new ArrayList<Integer>();
        for (int i = 2; i <= n / i; i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        if (n > 1) {
            factors.add(n);
        }
        return factors;
    }

    public static ArrayList<Integer> distinctPrimeFactors(int numbers) {
        int n = numbers;
        ArrayList<Integer> factors = new ArrayList<Integer>();

        for (int i = 2; i <= n / i; i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        if (n > 1) {
            factors.add(n);
        }
        return makeDistinct(factors);
    }

    private static ArrayList<Integer> makeDistinct(ArrayList<Integer> factors) {
        ArrayList<Integer> distinctFactors = new ArrayList<Integer>();
        ArrayList<Integer> seenFactors = new ArrayList<Integer>();
        for (Integer f : factors) {
            int i = 0;
            if (!seenFactors.contains(f)) {
                for (Integer n : factors) {
                    if (f == n) {
                        seenFactors.add(f);
                        i++;
                    }
                }
                distinctFactors.add((int) Math.pow(f, i));
            }
        }
        return distinctFactors;
    }

    public static long getPentagonal(long n) {
        // Pn=n(3n-1)/2
        return (n * (n + (n << 1) - 1)) >> 1;
    }

    public static void get9HeadOfNthFibonacci(int n) {
        int i = 0;
        // int n = 0;
        long h1 = 1;
        long h2 = 1;
        long t = 0;
        while (i < n) {
            t = h1;
            h1 += h2;
            h2 = t;
            if (h1 > 1000000000000000000l) {
                h1 /= 10;
                // System.out.println("CUT - ");

            }
            long log = (int) Math.log10(h1);
            // System.out.println("log " + log );
            if (log > 8) {
                long pow = (long) (Math.pow(10, log - 8));
                // System.out.println("pow "+ pow );
                long panCand = (h1 / pow);
                // System.out.println(h1 + " - "+ panCand );
                if (isPandigital1to9((int) panCand)) {
                    System.out.println(h1 + " - " + panCand);
                }
                i++;
            }
        }
    }

    /**
     * def is_pandigital_1to9(pan): pand_list = [0 for x in range(0, 11)] s =
     * str(pan) nio = 0 if len(s) == 9: for i in range(0,9): if
     * pand_list[int(s[i])]==0: pand_list[int(s[i])] = 1 nio += 1 if nio == 9
     * and pand_list[0]==0: return True return False
     */
    public static boolean isPandigital1to9(int pan) {
        int answer = 0;
        if (pan >= 123456788 && pan <= 987654322) {
            for (int i = 0; i < 9; i++) {
                answer += 1 << (pan % 10);
                pan = pan / 10;
            }
        }

        if (answer == 1022) {
            return true;
        }
        return false;
    }

    /**
     * def next_lex_permutation(v, n): ## scan from right to left to find the
     * first i such that ## v[i+1] > v[i] i = n - 2 while ((i >= 0) and
     * not(v[i+1] > v[i])): i = i-1 ## If there is no such i, then the elements
     * are in reverse ## lexicographical order and we have found the last
     * permutation. if (i < 0): return None ##Otherwise, exchange v[i] with the
     * next-largest element ##in v[i+1],...,v[n] k = n - 1 while (v[i] > v[k]):
     * k = k-1 swap(v, i, k) ##then reverse P[i+1],...,P[n]. r = v[i+1:] l =
     * v[:i+1] r.reverse() v = l+r return v
     */
    // public static int[] nextLexPermutation(int[] v, int n) {

    public static boolean permuteLexically(int[] data) {
        int k = data.length - 2;
        while (data[k] >= data[k + 1]) {
            k--;
            if (k < 0) {
                return false;
            }
        }
        int l = data.length - 1;
        while (data[k] >= data[l]) {
            l--;
        }
        swap(data, k, l);
        int length = data.length - (k + 1);
        for (int i = 0; i < length / 2; i++) {
            swap(data, k + 1 + i, data.length - i - 1);
        }
        return true;
    }

    private static void swap(int[] data, int k, int l) {
        int t = data[k];
        data[k] = data[l];
        data[l] = t;
    }

    public static void printReversIntArray(int[] a) {
        for (int i = a.length - 1; i >= 0; i--) {
            System.out.print(a[i]);
        }
        System.out.println();
    }

    public static boolean isPalindrome(double l) {
        double length = Math.log10(l) + 1;
        double halfLength = length / 2;
        double rpow = 1;
        double lpow = Math.pow(10d, length - 1);
        for (int i = 0; i < halfLength; i++) {
            double rpow10 = rpow * 10;
            double lpow10 = lpow * 10;

            double right = l / rpow - (l / rpow10) * 10;
            double left = l / lpow - (l / lpow10) * 10;

            if (right != left) {
                return false;
            }
            rpow = rpow10;
            lpow = lpow / 10;
        }
        return true;
    }

    /**
     * --- Same method in Python --- def get_primes_low(max): list = [0 for a in
     * range(0, max+1)] for cand in range(2, max+1): for not_prime in
     * range(cand*2, max+1, cand): list[not_prime] = 1 ret_list = [] for pos in
     * range(2,max+1): if list[pos] == 0: ret_list.append(pos) return ret_list
     * 
     * @param max
     * @return Vector of al the primes in the range 0 .. max
     */
    public static Vector<Integer> getPrimes(int max) {
        System.out.println("Getting first " + max + " primes in a vector.");
        boolean[] list = new boolean[max + 1];
        for (int i = 0; i < max + 1; i++) {
            list[i] = false;
        }
        for (int c = 2; c < max + 1; c++) {
            for (int not_prime = c * 2; not_prime < max + 1; not_prime += c) {
                list[not_prime] = true;
            }
        }
        Vector<Integer> ret_v = new Vector<Integer>();
        for (int pos = 2; pos < max + 1; pos++) {
            if (list[pos] == false) {
                ret_v.add(pos);
            }
        }
        return ret_v;
    }

    /*
     * def is_prime(a): a = abs(a) if a == 1: return False if a==2 or a==3 or
     * a==5: return True if a%2==0 or a%3==0 or a%5==0: return False i = 5 asqrt
     * = int(math.sqrt(a)) while i < asqrt: i += 2 if a % i == 0: return False i
     * += 4 if a % i == 0: return False return True
     * @param n
     * @return boolean true if n is prime
     */
    public static boolean isPrime(long n) {
        //System.out.println("p: "+n);
        if (n < 0) {
            n = n * -1;
        }

        if (n <= 5) {
            if (n == 1 || n == 4) {
                return false;
            }
            else {
                return true;
            }
        }

        if (n % 2 == 0 || n % 3 == 0 || n % 5 == 0) {
            return false;
        }

        long i = 5;
        long asqrt = (long) Math.sqrt(n) + 1;
        while (i < asqrt) {
            i += 2;
            if (n % i == 0) {
                return false;
            }
            i += 4;
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void print2DArray(int[][] matrix) {
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[0].length; y++) {
                System.out.print(matrix[x][y] + ", ");
            }
            System.out.println();
        }
    }

    public static BigInteger reverseBigInt(BigInteger a) {
        BigInteger b = BigInteger.ZERO;
        BigInteger t = BigInteger.ONE;
        BigInteger t2 = BigInteger.ONE;
        t = a;
        while (!t.equals(BigInteger.ZERO)) {
            t2 = t;
            t = t.divide(BigInteger.TEN);
            b = b.multiply(BigInteger.TEN);
            b = b.add(t2.subtract(t.multiply(BigInteger.TEN)));
        }
        return b;
    }

    public static int[][] readInt2DArrayFromFile(String filename, int[][] matrix) {
        try {
            FileReader input = new FileReader(filename);
            BufferedReader bufRead = new BufferedReader(input);

            String regex = ",";
            Pattern pattern = Pattern.compile(regex);

            String line;
            int count = 0;
            line = bufRead.readLine();

            int x = 0;
            while (line != null) {
                String[] sa = pattern.split(line);
                int[] row = new int[sa.length];
                for (int i = 0; i < row.length; i++) {
                    row[i] = Integer.parseInt(sa[i]);
                }
                matrix[x++] = row;
                line = bufRead.readLine();

            }
            bufRead.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return matrix;
    }

    public static void printIntegerArray(Integer[] d) {
        for (int x = 0; x < d.length; x++) {
            System.out.print(d[x] + ", ");
        }
        System.out.println();
    }

    public static void printDoubleArray(double[] d) {
        for (int x = 0; x < d.length; x++) {
            System.out.print(d[x] + ", ");
        }
        System.out.println();
    }

    public static void readStringListFromFile(String filename, ArrayList<String> numerals) {
        if (numerals == null) {
            throw new NullPointerException("numerals ArrayList null.");
        }
        try {
            FileReader input = new FileReader(filename);
            BufferedReader bufRead = new BufferedReader(input);

            String line = bufRead.readLine();

            while (line != null) {
                numerals.add(line);
                line = bufRead.readLine();
            }
            bufRead.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Integer[] readIntegersListFromFile(String filename) {
        ArrayList<Integer> integers = new ArrayList<Integer>();
        try {
            FileReader input = new FileReader(filename);
            BufferedReader bufRead = new BufferedReader(input);

            String line = bufRead.readLine();

            while (line != null) {
                for (String s : line.split(",")) {
                    integers.add(Integer.valueOf(s.trim()));
                }
                line = bufRead.readLine();
            }
            bufRead.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return integers.toArray(new Integer[0]);
    }
}
