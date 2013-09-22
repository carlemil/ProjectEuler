package com.kjellstrand.euler;

import java.util.Vector;


//##Consider numbers t(n) of the form t(n) = 2n^2-1 with n > 1.
//##The first such numbers are 7, 17, 31, 49, 71, 97, 127 and 161.
//##It turns out that only 49 = 7*7 and 161 = 7*23 are not prime.
//##For n 10000 there are 2202 numbers t(n) that are prime.
//##
//##How many numbers t(n) are prime for n 50,000,000 ?
//
//from tools import get_primes
//n = 10000
//list_of_primes = get_primes(n*100)
//set_of_primes = set(p for p in list_of_primes)
//def t(n):
//    return (2*(n**2))-1
//p=0
//i=0
//
//for n in range(2,n):
//    i+=1
//##    if i % 1000 == 0:
//##        print i
//    if t(n) in set_of_primes:
//        p+=1
//        print t(n)
//##    print "--- %d" % (n)
//##print "-----"
//print i
//print p

public class Euler0216 {
	static int[] primes = null;
	static int expectedMaxPrime = 10000000;
	static int nMax = 10000;

	public static void main(String[] args) {
		long time = System.currentTimeMillis();

		primes = new int[expectedMaxPrime];
		Vector<Integer> primVect = Tools.getPrimesVector(expectedMaxPrime);
		for(int i = 0; i<primVect.size(); i++){
			primes[primVect.get(i)] = 1;
		}

		System.out.println("time: " + (System.currentTimeMillis() - time) + "ms"); 


		int p=0;
		int i=0;

		for (int n=2; n<nMax; n++){
			i++;
			if (i % 1000 == 0){
				//System.out.println("i " + i);
			}
			if (primes[t(n)] == 1){
				p++;
				//System.out.println("t(n) " + t(n) + " n " + n);
			}
		}
		System.out.println("i " + i);
		System.out.println("p " + p);
		System.out.println("time: " + (System.currentTimeMillis() - time) + "ms"); 
	}

	private static int t(int n){
		return (2*(n*n))-1;
	}
}






















