package com.kjellstrand.euler;

//The game Number Mind is a variant of the well known game Master Mind.
//
//Instead of coloured pegs, you have to guess a secret sequence of digits. 
//After each guess you're only told in how many places you've guessed the 
//correct digit. So, if the sequence was 1234 and you guessed 2036, you'd be 
//told that you have one correct digit; however, you would NOT be told that 
//you also have another digit in the wrong place.
//
//For instance, given the following guesses for a 5-digit secret sequence,
//
//90342 ;2 correct
//70794 ;0 correct
//39458 ;2 correct
//34109 ;1 correct
//51545 ;2 correct
//12531 ;1 correct
//
//The correct sequence 39542 is unique.
//
//Based on the following guesses,
//
//5616185650518293 ;2 correct
//3847439647293047 ;1 correct
//5855462940810587 ;3 correct
//9742855507068353 ;3 correct
//4296849643607543 ;3 correct
//3174248439465858 ;1 correct
//4513559094146117 ;2 correct
//7890971548908067 ;3 correct
//8157356344118483 ;1 correct
//2615250744386899 ;2 correct
//8690095851526254 ;3 correct
//6375711915077050 ;1 correct
//6913859173121360 ;1 correct
//6442889055042768 ;2 correct
//2321386104303845 ;0 correct
//2326509471271448 ;2 correct
//5251583379644322 ;2 correct
//1748270476758276 ;3 correct
//4895722652190306 ;1 correct
//3041631117224635 ;3 correct
//1841236454324589 ;3 correct
//2659862637316867 ;2 correct
//
//Find the unique 16-digit secret sequence.

public class Euler0185 {

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        
        int[][] d = new int[][]{
              {2,3,2,1,3,8,6,1,0,4,3,0,3,8,4,5,0,0 },
              {5,6,1,6,1,8,5,6,5,0,5,1,8,2,9,3,2,0 },
              {3,8,4,7,4,3,9,6,4,7,2,9,3,0,4,7,1,0 },
              {5,8,5,5,4,6,2,9,4,0,8,1,0,5,8,7,3,0 },
              {9,7,4,2,8,5,5,5,0,7,0,6,8,3,5,3,3,0 },
              {4,2,9,6,8,4,9,6,4,3,6,0,7,5,4,3,3,0 },
              {3,1,7,4,2,4,8,4,3,9,4,6,5,8,5,8,1,0 },
              {4,5,1,3,5,5,9,0,9,4,1,4,6,1,1,7,2,0 },
              {7,8,9,0,9,7,1,5,4,8,9,0,8,0,6,7,3,0 },
              {8,1,5,7,3,5,6,3,4,4,1,1,8,4,8,3,1,0 },
              {2,6,1,5,2,5,0,7,4,4,3,8,6,8,9,9,2,0 },
              {8,6,9,0,0,9,5,8,5,1,5,2,6,2,5,4,3,0 },
              {6,3,7,5,7,1,1,9,1,5,0,7,7,0,5,0,1,0 },
              {6,9,1,3,8,5,9,1,7,3,1,2,1,3,6,0,1,0 },
              {6,4,4,2,8,8,9,0,5,5,0,4,2,7,6,8,2,0 },
              {2,3,2,6,5,0,9,4,7,1,2,7,1,4,4,8,2,0 },
              {5,2,5,1,5,8,3,3,7,9,6,4,4,3,2,2,2,0 },
              {1,7,4,8,2,7,0,4,7,6,7,5,8,2,7,6,3,0 },
              {4,8,9,5,7,2,2,6,5,2,1,9,0,3,0,6,1,0 },
              {3,0,4,1,6,3,1,1,1,7,2,2,4,6,3,5,3,0 },
              {1,8,4,1,2,3,6,4,5,4,3,2,4,5,8,9,3,0 },
              {2,6,5,9,8,6,2,6,3,7,3,1,6,8,6,7,2,0 }
              };
        
        
        double [][] p = new double [d[0].length][10];

        for (int i = 1; i < d.length; i++) {
            int n=d.length;
            for (int j = 0; j < d[0].length - 2; j++) {
                if (d[0][j] == d[i][j]) {
                    d[i][j] = -1;
                    n--;
                }
            }
            d[i][d[0].length-1]=n;
        }

        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < d[0].length; j++) {
                int a = d[i][j];
                if (j >= d[0].length - 2) {
                    System.out.print(" ");
                }
                if (a != -1) {
                    System.out.print(a);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        for (int i = 1; i < d.length; i++) {
            for (int j = 0; j < d[0].length - 2; j++) {
                int digit = d[i][j];
                if (digit != -1) {
                    p[j][digit] += d[i][d[0].length - 2] / (double) d[i][d[0].length - 1];
                }
            }
        }
        System.out.println();
        for (int i = 1; i < p.length-2; i++) {
            for (int j = 0; j < p[0].length; j++) {
                System.out.print((int) (p[i][j] * 10000) + " ");
            }
            System.out.println();
        }
        
        System.out.println();
        for (int i = 1; i < p.length-2; i++) {
            double smalest=p[i][0];
            int index=0;
            while(smalest==0){
                index++;
                smalest=p[i][index];
            }
            for (int j = 0; j < p[0].length; j++) {
                double curent = p[i][j];
                if(curent!=0 && curent<smalest){
                    smalest=curent;
                    index=j;
                }
            }
            System.out.print(index+" ");
        }

        System.out.println("time: " + (System.currentTimeMillis() - time) + "ms");
        
        // 4640261571849533
    }
}
