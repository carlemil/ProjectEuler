package com.kjellstrand.euler;


/*
    Let T(n) be the number of tours over a 4 × n playing board such that:

    The tour starts in the top left corner.
    The tour consists of moves that are up, down, left, or right one square.
    The tour visits each square exactly once.
    The tour ends in the bottom left corner.
    The diagram shows one tour over a 4 × 10 board:

    T(10) is 2329. What is T(10^12) modulo 10^8?
 */

public class Euler0237 {

	public static void main(String[] args) {
        long time = System.currentTimeMillis();

        // look only at row 2, all depends on either of the middle rows.
        
        System.out.println("time: " + (System.currentTimeMillis() - time) + "ms"); 

	}
}

