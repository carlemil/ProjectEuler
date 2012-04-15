package completed;

import com.kjellstrand.euler.Tools;

public class Euler0104 {

	public static void main(String[] args) {
		int i = 2;
		int n = 0;
		long f1 = 1;
		long f2 = 1;
		long h1 = 1;
		long h2 = 1;
		long t=0;
		boolean loop = true;
		while (loop){
			t = f1;
			f1 += f2;
			f2 = t;
			f1 %= 1000000000;

			t = h1;
			h1 += h2;
			h2 = t;
			if(h1 > 1000000000000000000l){
				h1 /= 10;
				h2 /= 10;
			}

			i++;
			if (Tools.isPandigital1to9((int)f1)){
				long log = (int)Math.log10((double)h1);
				if(log > 8){
					long pow = (long)(Math.pow( 10, log-8));
					long panCand = (long)(h1 / pow);
					if (Tools.isPandigital1to9((int)panCand)){				
						loop = false;
					}

				}
				n++;
			}
		}
		System.out.println(i);
	}
}
