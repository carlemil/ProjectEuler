package com.kjellstrand.euler;


/*
Let D0 be the two-letter string "Fa". For n1, derive Dn from Dn-1 by the string-rewriting rules:

"a"  "aRbFR"
"b"  "LFaLb"

Thus, D0 = "Fa", D1 = "FaRbFR", D2 = "FaRbFRRLFaLbFR", and so on.

FaRbFRRLFaLbFRRLFaRbFRLLFaLbFRRLFaRbFRRLFaLbFRLLFaRbFRLLFaLbFRRLFaRbFRRLFaLbFRRLFaRbFRLLFaLbFRLLFaR
bFRRLFaLbFRLLFaRbFRLLFaLbFRRLFaRbFRRLFaLbFRRLFaRbFRLLFaLbFRRLFaRbFRRLFaLbFRLLFaRbFRLLFaLbFRLLFaRbF
RRLFaLbFRRLFaRbFRLLFaLbFRLLFaRbFRRLFaLbFRLLFaRbFRLLFaLbFR

 RRLRRLLRRRL
r
rr
lrrl
lrrrllrl
lrrrlrrlllrrllrl
lrrrlrrllrrrllrlllrrlrrlllrrllrl
lrrrlrrllrrrllrllrrrlrrlllrrllrlllrrlrrllrrrllrlllrrlrrll

l
rr
rlrr
llrrrllr
llrrrlrrlllrrllr

l
rr
rlrr
llrrrllr
lllrrlrrlllrrllr
llrrrlrrllrrrllrllrrrlrrlllrrllr


These strings can be interpreted as instructions to a computer graphics program, with "F" meaning 
"draw forward one unit", "L" meaning "turn left 90 degrees", "R" meaning "turn right 90 degrees", 
and "a" and "b" being ignored. The initial position of the computer cursor is (0,0), pointing up 
towards (0,1).

Then Dn is an exotic drawing known as the Heighway Dragon of order n. For example, D10 is shown below; 
counting each "F" as one step, the highlighted spot at (18,16) is the position reached after 500 steps.


What is the position of the cursor after 10^12 steps in D50 ?
Give your answer in the form x,y with no spaces.
 */
public class Euler0220 {

	static long poss[] = new long[102400];
	static int pos = 0;

	static int direction = 6;
	static int st = 150;

	public static void main(String[] args) {


		/*
		for (int i = 0; i<=10 ;i++){
			System.out.println("i " + (int)Math.pow(2d, (double)i)+ "	" +getXY(i, 0));
		}
		System.out.println("");
		 */

		int d2 = 1;

		int x=0;
		int y=0;
		int d = 0;
		for (int i = 1; i<10000 ;i++){
			poss[i] = d * 2;

			switch(d){
			case 0:
				y++;
				break;
			case 1:
				x++;
				break;
			case 2:
				y--;
				break;
			case 3:
				x--;
				break;
			}
			if((((i & -i) << 1) & i) != 0) {
				d = (d + 3) % 4;
			} else {
				d = (d + 1) % 4;
			}
//			if ( i == d2){
//				System.out.println("i " + i +" 	x " + x + " 	y " + y +
//						" 	d " + d*2 + " 	lr " + (((((i & -i) << 1) & i) != 0)? "l":"r"));
//				d2 = i*2;
//			}
			if ( i == st){
				System.out.println("i " + i +" 	x " + x + " 	y " + y +
						" 	d " + d*2 + " 	lr " + (((((i & -i) << 1) & i) != 0)? "l":"r"));
			}
			if ( i == st+1){
				System.out.println("i " + i +" 	x " + x + " 	y " + y +
						" 	d " + d*2 + " 	lr " + (((((i & -i) << 1) & i) != 0)? "l":"r"));
			}
			if ( i == st+2){
				System.out.println("i " + i +" 	x " + x + " 	y " + y +
						" 	d " + d*2 + " 	lr " + (((((i & -i) << 1) & i) != 0)? "l":"r"));
			}
			if ( i == st+4){
				System.out.println("i " + i +" 	x " + x + " 	y " + y +
						" 	d " + d*2 + " 	lr " + (((((i & -i) << 1) & i) != 0)? "l":"r"));
			}
			if ( i == st+8){
				System.out.println("i " + i +" 	x " + x + " 	y " + y +
						" 	d " + d*2 + " 	lr " + (((((i & -i) << 1) & i) != 0)? "l":"r"));
			}
			if ( i == st+16){
				System.out.println("i " + i +" 	x " + x + " 	y " + y +
						" 	d " + d*2 + " 	lr " + (((((i & -i) << 1) & i) != 0)? "l":"r"));
			}
			if ( i == st+32){
				System.out.println("i " + i +" 	x " + x + " 	y " + y +
						" 	d " + d*2 + " 	lr " + (((((i & -i) << 1) & i) != 0)? "l":"r"));
			}
			if ( i == st+64){
				System.out.println("i " + i +" 	x " + x + " 	y " + y +
						" 	d " + d*2 + " 	lr " + (((((i & -i) << 1) & i) != 0)? "l":"r"));
			}
			if ( i == st+128){
				System.out.println("i " + i +" 	x " + x + " 	y " + y +
						" 	d " + d*2 + " 	lr " + (((((i & -i) << 1) & i) != 0)? "l":"r"));
			}
			if ( i == st+256){
				System.out.println("i " + i +" 	x " + x + " 	y " + y +
						" 	d " + d*2 + " 	lr " + (((((i & -i) << 1) & i) != 0)? "l":"r"));
			}
			if ( i == st+512){
				System.out.println("i " + i +" 	x " + x + " 	y " + y +
						" 	d " + d*2 + " 	lr " + (((((i & -i) << 1) & i) != 0)? "l":"r"));
			}
			if ( i == st+1024){
				System.out.println("i " + i +" 	x " + x + " 	y " + y +
						" 	d " + d*2 + " 	lr " + (((((i & -i) << 1) & i) != 0)? "l":"r"));
			}
			if ( i == st+2048){
				System.out.println("i " + i +" 	x " + x + " 	y " + y +
						" 	d " + d*2 + " 	lr " + (((((i & -i) << 1) & i) != 0)? "l":"r"));
			}

		}


		DirPoint dp = binSearch(st, 0, 0);
		System.out.println("yoo " + dp);
		System.out.println("");
	}


	private static DirPoint binSearch(long f, int dir, int old_d){
		int d = (int)(Math.log(f) / Math.log(2d));
		long froof = (long)Math.pow(2d, (double)(d));

		pos += froof;

		long f_diff = f - froof;
		//System.out.println("d: " + d + "	froof: " +
		//	 froof+ "	fdiff " + f_diff);

		if (f != froof){
			froof *= 2;
		}

		System.out.println("\nf " + (st-f) + "	dir " + dir + " 	realdir: " + poss[(int) (st-f)] +
				" 	d "+ d +" 	f_diff " + f_diff);

		//System.out.println("froof " + froof);
		if(froof != 0){
			DirPoint dp = getXY(d, dir);
			if (old_d > d+1){
				direction=(direction + 4)%8;
			}
			else {
				//direction = 2;
			}

			//System.out.println("dp "+dp +"	poss " +poss[pos] );
			DirPoint dp2 = binSearch(f_diff, dp.dir, d);
			dp.Add(dp2);
			return dp;
		}
		return null;

	}

	private static DirPoint getXY(int d, int dir){
		/*
i 0 	x 0 	y 1 	dir: 0
i 1 	x 1 	y 1 	dir: 1
i 3 	x 2 	y 0 	dir: 2
i 7 	x 2 	y -2 	dir: 3
i 15 	x 0 	y -4 	dir: 4
i 31 	x -4 	y -4 	dir: 5
i 63 	x -8 	y 0 	dir: 6
i 127 	x -8 	y 8 	dir: 7
i 255 	x 0 	y 16 	dir: 0
i 511 	x 16 	y 16 	dir: 1
i 1023 	x 32 	y 0 	dir: 2


		 0:y+1
	    6:x-1 dir 2:x+1
		 4:y-1

		 */
		DirPoint p = new DirPoint();
		long value = (long)Math.pow(2d, (double)(d/2));

		switch((dir+d) % 8){
		case 0:
			p.x = 0;
			p.y = value;
			break;
		case 1:
			p.x = value;
			p.y = value;
			break;
		case 2:
			p.x = value;
			p.y = 0;
			break;
		case 3:
			p.x = value;
			p.y = -value;
			break;
		case 4:
			p.x = 0;
			p.y = -value;
			break;
		case 5:
			p.x = -value;
			p.y = -value;
			break;
		case 6:
			p.x = -value;
			p.y = 0;
			break;
		case 7:
			p.x = -value;
			p.y = value;
			break;
		}
		p.dir = (dir + direction)%8;
		return p;

	}

	static class DirPoint{
		long x;
		long y;
		int dir;

		public void Add(DirPoint dp){
			if (dp == null){
				return;
			}
			x += dp.x;
			y += dp.y;
			//dir += dp.dir;
		}

		public String toString(){
			return "x: " + x + "	y: " + y + "	dir: " + dir;
		}
	}
}

