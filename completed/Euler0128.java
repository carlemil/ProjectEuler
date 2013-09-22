package completed;

import java.util.Vector;

import com.kjellstrand.euler.Tools;


/*
A hexagonal tile with number 1 is surrounded by a ring of six hexagonal tiles, starting at "12 o'clock" and numbering the tiles 2 to 7 in an anti-clockwise direction.

New rings are added in the same fashion, with the next rings being numbered 8 to 19, 20 to 37, 38 to 61, and so on. The diagram below shows the first three rings.

- Image -

By finding the difference between tile n and each its six neighbours we shall define PD(n) to be the number of those differences which are prime.

For example, working clockwise around tile 8 the differences are 12, 29, 11, 6, 1, and 13. So PD(8) = 3.

In the same way, the differences around tile 17 are 1, 17, 16, 1, 11, and 10, hence PD(17) = 2.

It can be shown that the maximum value of PD(n) is 3.

If all of the tiles for which PD(n) = 3 are listed in ascending order to form a sequence, the 10th tile would be 271.

Find the 2000th tile in this sequence.

 */
public class Euler0128 {
	static long[] neighbours = new long[7];
	static long[] primes = null;
	static int expectedMaxPrime = 900000;

	public static void main(String[] args) {
		long time = System.currentTimeMillis();

		primes = new long[expectedMaxPrime];
		Vector<Integer> primVect = Tools.getPrimesVector(expectedMaxPrime);
		for(int i = 0; i<primVect.size(); i++){
			primes[primVect.get(i)] = 1;
		}

		System.out.println("time: " + (System.currentTimeMillis() - time) + "ms"); 

		long answer = 0;

		long np = 4;

		long d = 2;
		while (true){
			d++;

			long n =	getN(d, 0, 0);
			long n_inner = getN(d-1, 0, 0);
			long n_outer = getN(d+1, 0, 0);
			neighbours[0] = n+1;
			neighbours[1] = n+d*6-1;
			neighbours[2] = n_inner;
			neighbours[3] = n_outer;
			neighbours[4] = n_outer+1;
			neighbours[5] = n_outer+(d+1)*6-1;
			neighbours[6] = n;

			if(is3NeightboursPrimeDiff()){
				np++;
				answer = neighbours[6];

			if (np == 2000){
				break;
			} 
			}


			long h=5;
			long hp=d-1;
			//n_inner = getN(d-1, h, hp-1);
			//n_outer = getN(d+1, h, hp);

			long n_inner_side = n_inner+h*(d-1)+hp-1;
			long n_outer_side = n_outer+h*(d+1)+hp;
			neighbours[0] = n_inner_side-(d-1)*6+1;
			neighbours[1] = n-1;
			neighbours[2] = n_inner_side;
			neighbours[3] = n_inner_side+1;
			neighbours[4] = n_outer_side;
			neighbours[5] = n_outer_side+1;
			neighbours[6] = getN(d, h, hp);

			if(is3NeightboursPrimeDiff()){
				np++;
				answer = neighbours[6];

			if (np == 2000){
				break;
			} 
			}

		}

		System.out.println(answer);
		System.out.println("time: " + (System.currentTimeMillis() - time) + "ms"); 
	}

	private static boolean is3NeightboursPrimeDiff(){
		long n = neighbours[6];
		try{
			if(primes[(int)Math.abs(n-neighbours[0])] +primes[(int)Math.abs(n-neighbours[1])] +primes[(int)Math.abs(n-neighbours[2])] +
					primes[(int)Math.abs(n-neighbours[3])] +primes[(int)Math.abs(n-neighbours[4])] +primes[(int)Math.abs(n-neighbours[5])] == 3){
				return true;
			}
		} catch (Exception e) {
			System.out.println("n: " + n);
			for (int i=0; i<7; i++){
				System.out.print(neighbours[i] + " ");
			}
			System.exit(-1);
		}
		return false;

	}

	private static long getN(long d, long h, long hp){
		if (d==0) {
			return 1;
		}
		return (((d-1)*d)/2)*6+2+h*d+hp;
	}
}

