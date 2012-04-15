package completed;

//The fraction 49/98 is a curious fraction, as an inexperienced mathematician 
//in attempting to simplify it may incorrectly believe that 49/98 = 4/8, which 
//is correct, is obtained by cancelling the 9s.
//
//We shall consider fractions like, 30/50 = 3/5, to be trivial examples.
//
//There are exactly four non-trivial examples of this type of fraction, less 
//than one in value, and containing two digits in the numerator and denominator.
//
//If the product of these four fractions is given in its lowest common terms, 
//find the value of the denominator.

public class Euler0033 {

    public static void main(String[] args) {
        // numerator / denominator
        long numerator = 1;
        long denominator = 1;
        for(int i = 1; i < 10; i++) {
            for(int n = 0; n < 10; n++) {
                for(int d = 0; d < 10; d++) {
                    if (d != n && n != i) {
                        if (((float) n) / d == ((float) n * 10 + i) / (i * 10 + d)) {
                            numerator *= (n * 10 + i);
                            denominator *= (i * 10 + d);
                        }
                    }
                }
            }
        }
        System.out.println(1 / (numerator / (float) denominator));
    }
}
