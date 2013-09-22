package com.kjellstrand.euler;

import java.util.Vector;

public class EulerPrimeSpeedTest {

    public static void main(String[] args) {
        int max = 125;
        int min = 121;
        long time = System.currentTimeMillis();
        int[] p = Tools.getPrimesIntArray(min, max);
        System.out.println("int array time: " + (System.currentTimeMillis() - time) + "ms");
        time = System.currentTimeMillis();
        Vector<Integer> pv = Tools.getPrimesVector(max);
        System.out.println("vector time: " + (System.currentTimeMillis() - time) + "ms");

        boolean same=true;
        for (int i = 0; i < pv.size(); i++) {
            System.out.println("Primes on pos: " + i + ", prime: " + pv.get(i));
        }    
        for (int i = 0; i < p.length; i++) {
            System.out.println("Primes on pos: " + i + ", fast prime: " +p[i]);
        }
        if(!same){
            System.out.println("Not same :(");
        }

    }
}
