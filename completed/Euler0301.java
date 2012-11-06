
package completed;

//Nim is a game played with heaps of stones, where two players take it in 
//turn to remove any number of stones from any heap until no stones remain.
//
//We'll consider the three-heap normal-play version of Nim, which works as 
//follows:
//- At the start of the game there are three heaps of stones.
//- On his turn the player removes any positive number of stones from any 
//single heap.
//- The first player unable to move (because no stones remain) loses.
//
//If (n1,n2,n3) indicates a Nim position consisting of heaps of size 
//n1, n2 and n3 then there is a simple function X(n1,n2,n3) — that you 
//may look up or attempt to deduce for yourself — that returns:
//
//zero if, with perfect strategy, the player about to move will eventually 
//lose; or
//non-zero if, with perfect strategy, the player about to move will 
//eventually win.
//For example X(1,2,3) = 0 because, no matter what the current player does, 
//his opponent can respond with a move that leaves two heaps of equal size, 
//at which point every move by the current player can be mirrored by his 
//opponent until no stones remain; so the current player loses. 
//To illustrate:
//- current player moves to (1,2,1)
//- opponent moves to (1,0,1)
//- current player moves to (0,0,1)
//- opponent moves to (0,0,0), and so wins.
//
//For how many positive integers n  230 does X(n,2n,3n) = 0 ?

public class Euler0301 {
    static int[] a;

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        a = new int[31];
        int c = 1;

        while (incByOne(0)) {
            c++;
        }

        System.out.println(c);
        System.out.println("time: " + (System.currentTimeMillis() - time) + "ms");
    }

    private static boolean incByOne(int p) {
        if (p >= a.length - 1) {
            return false;
        } else {
            if (a[p + 1] == 1) {
                a[p + 1] = 0;
                return incByOne(p + 2);
            } else if (a[p] == 1) {
                a[p] = 0;
                if (a[p + 1] == 0) {
                    return incByOne(p + 1);
                } else {
                    a[p] = 0;
                    a[p + 1] = 0;
                    return incByOne(p + 2);
                }
            } else {
                a[p] = 1;
            }
        }
        return true;
    }

    private static int getNimSum(int a, int b, int c) {
        return a ^ b ^ c;
    }
}
