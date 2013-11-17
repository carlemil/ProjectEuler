package completed;

import java.math.BigInteger;

import com.kjellstrand.euler.Tools;



//##Consider numbers t(n) of the form t(n) = 2n^2-1 with n > 1.
//##The first such numbers are 7, 17, 31, 49, 71, 97, 127 and 161.
//##It turns out that only 49 = 7*7 and 161 = 7*23 are not prime.
//##For n 10000 there are 2202 numbers t(n) that are prime.
//##
//##How many numbers t(n) are prime for n 50,000,000 ?

public class Euler0216 {
	static int max = 50000000;

	public static void main(String[] args) {
		long time = System.currentTimeMillis();

		BigInteger bi = BigInteger.ZERO;
		long c=0;
		for(int i = 0; i<max; i++){
		    String s = t((long)i);
			if(Tools.isPrime(new BigInteger(s))){
			    c++;
			    //System.out.println(i+" +++: "+s);
			}else{
			    //System.out.println(i+"    : "+s);			    
			}
		}
		System.out.println("time: " + (System.currentTimeMillis() - time) + "ms"); 
		System.out.println("c: "+c);
	}

	private static String t(long n){
		return ""+((2l*(n*n))-1l);
	}
}






















