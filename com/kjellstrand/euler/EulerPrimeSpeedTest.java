package com.kjellstrand.euler;

import java.util.Vector;

public class EulerPrimeSpeedTest {

	public static void main(String[] args) {
	    int max = 10000000;
        long time = System.currentTimeMillis();
        int [] p=Tools.getPrimesIntArray(max);
        System.out.println("time: " + (System.currentTimeMillis() - time) + "ms"); 
        time = System.currentTimeMillis();
         Vector<Integer> pv = Tools.getPrimesVector(max);
        System.out.println("time: " + (System.currentTimeMillis() - time) + "ms"); 

	}
}

