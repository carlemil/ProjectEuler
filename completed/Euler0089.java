package completed;

import java.util.ArrayList;
import java.util.HashMap;

import com.kjellstrand.euler.Tools;

//The rules for writing Roman numerals allow for many ways of writing each number 
//(see About Roman Numerals...). However, there is always a "best" way of writing 
//a particular number.
//
//For example, the following represent all of the legitimate ways of writing the 
//number sixteen:
//
//IIIIIIIIIIIIIIII
//VIIIIIIIIIII
//VVIIIIII
//XIIIIII
//VVVI
//XVI
//
//The last example being considered the most efficient, as it uses the least number 
//of numerals.
//
//The 11K text file, roman.txt (right click and 'Save Link/Target As...'), contains 
//one thousand numbers written in valid, but not necessarily minimal, Roman numerals; 
//that is, they are arranged in descending units and obey the subtractive pair rule 
//(see About Roman Numerals... for the definitive rules for this problem).
//
//Find the number of characters saved by writing each of these in their minimal form.
//
//Note: You can assume that all the Roman numerals in the file contain no more than 
//four consecutive identical units.

//I = 1
//V = 5
//X = 10
//L = 50
//C = 100
//D = 500
//M = 1000

public class Euler0089 {
    static ArrayList<String>        numerals      = new ArrayList<String>();

    static String[]                 numCharsOrder = new String[]{"M", "D", "C", "L", "X", "V", "I"};
    static HashMap<String, Integer> numCharValMap = new HashMap<String, Integer>();
    static int                      M;
    static int                      D;
    static int                      C;
    static int                      L;
    static int                      X;
    static int                      V;
    static int                      I;

    public static void main(String[] args) {
        Tools.readStringListFromFile("completed/euler0089_roman.txt", numerals);

        long time = System.currentTimeMillis();
        M = 1000;
        D = 500;
        C = 100;
        L = 50;
        X = 10;
        V = 5;
        I = 1;
        numCharValMap.put("M", M);
        numCharValMap.put("D", D);
        numCharValMap.put("C", C);
        numCharValMap.put("L", L);
        numCharValMap.put("X", X);
        numCharValMap.put("V", V);
        numCharValMap.put("I", I);

        int sum = 0;
        for(String numeral : numerals) {
            int orgLength = numeral.length();
            int numeralValue = decodeRomanNumeral(numeral);
            int newLength = encodeRomanNumeral(numeralValue).length();
            sum += orgLength - newLength;
        }
        System.out.println("time: " + (System.currentTimeMillis() - time) + "ms");
        System.out.println(sum);
    }

    private static int decodeRomanNumeral(String numeral) {
        ArrayList<Integer> values = new ArrayList<Integer>();
        String[] nums = numeral.trim().split("");
        int lastNum = 1000;
        for(String num : nums) {
            if (num != null && num.length() == 1) {
                int currentNum = numCharValMap.get(num);
                if (currentNum > lastNum) {
                    values.set(values.size() - 1, -lastNum);
                }
                values.add(currentNum);
                lastNum = currentNum;
            }
        }
        int sum = 0;
        for(int v : values) {
            sum += v;
        }
        return sum;
    }

    private static String encodeRomanNumeral(int numeral) {
        ArrayList<String> result = new ArrayList<String>();
        while (numeral > 0) {
            numeral = handleNumeralPart(numeral, result, "M");
            numeral = handleNumeralPart(numeral, result, "D");
            numeral = handleNumeralPart(numeral, result, "C");
            numeral = handleNumeralPart(numeral, result, "L");
            numeral = handleNumeralPart(numeral, result, "X");
            numeral = handleNumeralPart(numeral, result, "V");
            numeral = handleNumeralPart(numeral, result, "I");
        }
        StringBuilder sb = new StringBuilder();
        for(String s : result) {
            sb.append(s);
        }
        return sb.toString();
    }

    private static int handleNumeralPart(int numeral, ArrayList<String> result, String c) {
        int ci = numCharValMap.get(c);
        while (numeral >= ci) {
            if (numeral == 4) {
                result.add("IV");
                numeral -= 4;
            }
            else if (numeral == 9) {
                result.add("IX");
                numeral -= 9;
            }
            else if (numeral >= 40 && numeral < 50) {
                result.add("XL");
                numeral -= 40;
            }
            else if (numeral >= 90 && numeral < 100) {
                result.add("XC");
                numeral -= 90;
            }
            else if (numeral >= 400 && numeral < 500) {
                result.add("CD");
                numeral -= 400;
            }
            else if (numeral >= 900 && numeral < 1000) {
                result.add("CM");
                numeral -= 900;
            }
            else {
                result.add(c);
                numeral -= ci;
            }

        }
        return numeral;
    }
}
