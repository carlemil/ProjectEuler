package com.kjellstrand.euler;

import java.util.Vector;

//The primes 3, 7, 109, and 673, are quite remarkable. 
//By taking any two primes and concatenating them in any 
//order the result will always be prime. For example, 
//taking 7 and 109, both 7109 and 1097 are prime. The sum 
//of these four primes, 792, represents the lowest sum 
//for a set of four primes with this property.
//
//Find the lowest sum for a set of five primes for which 
//any two primes concatenate to produce another prime.

public class Euler0060 {

    public static void main(String[] args) {
        long time = System.currentTimeMillis();

//for 5 nestlade loopar som inte överlappar, 2 börjar där 1 slutar osv. 
//kolla om a+b b+a osv finns i hashmap/primelist 

        int max=10000;
        Vector<Integer> primeList = Tools.getPrimes(max);
        
        
        
        System.out.println("time: " + (System.currentTimeMillis() - time) + "ms");
    }
}
