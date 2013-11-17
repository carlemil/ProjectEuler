package com.kjellstrand.euler;

public class Test {

    public static void main(String[] args) {
        long time = System.currentTimeMillis();

        for (int i = 1; i < 19; i++) {
            System.out.println(i + " - " + (long) Math.pow(11, i));
        }

        System.out.println("time: " + (System.currentTimeMillis() - time) + "ms");
    }
}
