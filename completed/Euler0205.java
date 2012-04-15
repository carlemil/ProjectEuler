package completed;

//Peter has nine four-sided (pyramidal) dice, each with faces numbered 1, 2, 3, 4.
//Colin has six six-sided (cubic) dice, each with faces numbered 1, 2, 3, 4, 5, 6.
//
//Peter and Colin roll their dice and compare totals: the highest total wins. The 
//result is a draw if the totals are equal.
//
//What is the probability that Pyramidal Pete beats Cubic Colin? Give your answer 
//rounded to seven decimal places in the form 0.abcdefg

public class Euler0205 {
    static double[] peter = new double[28];
    static double[] colin = new double[31];

    public static void main(String[] args) {
        long time = System.currentTimeMillis();

        for(int i1 = 1; i1 <= 4; i1++) {
            for(int i2 = 1; i2 <= 4; i2++) {
                for(int i3 = 1; i3 <= 4; i3++) {
                    for(int i4 = 1; i4 <= 4; i4++) {
                        for(int i5 = 1; i5 <= 4; i5++) {
                            for(int i6 = 1; i6 <= 4; i6++) {
                                for(int i7 = 1; i7 <= 4; i7++) {
                                    for(int i8 = 1; i8 <= 4; i8++) {
                                        for(int i9 = 1; i9 <= 4; i9++) {
                                            peter[i1 + i2 + i3 + i4 + i5 + i6 + i7 + i8 + i9 - 9]++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        for(int i1 = 1; i1 <= 6; i1++) {
            for(int i2 = 1; i2 <= 6; i2++) {
                for(int i3 = 1; i3 <= 6; i3++) {
                    for(int i4 = 1; i4 <= 6; i4++) {
                        for(int i5 = 1; i5 <= 6; i5++) {
                            for(int i6 = 1; i6 <= 6; i6++) {
                                colin[i1 + i2 + i3 + i4 + i5 + i6 - 6]++;
                            }
                        }
                    }
                }
            }
        }

        // Tools.printIntArray(peter);
        // Tools.printIntArray(colin);

        double pt = 0;
        for(int p = 0; p < peter.length; p++) {
            pt += peter[p];
        }

        int ct = 0;
        for(int c = 0; c < colin.length; c++) {
            ct += colin[c];
        }

        double ps = 0;

        for(int p = 0; p < peter.length; p++) {
            double cs = getArraySum(p + 1, colin) / ct;
            double temp = (peter[p] / pt) * cs;
            ps += temp;
        }
        System.out.println("0." + (int) Math.ceil(ps * 10000000));

        System.out.println("time: " + (System.currentTimeMillis() - time) + "ms");
    }

    private static double getArraySum(int j, double[] colin) {
        double r = 0;
        for(int i = j; i < colin.length; i++) {
            r += colin[i];
        }
        return r;
    }
}
