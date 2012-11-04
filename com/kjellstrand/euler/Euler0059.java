
package com.kjellstrand.euler;

import java.util.HashMap;

//Each character on a computer is assigned a unique code and the preferred 
//standard is ASCII (American Standard Code for Information Interchange). 
//For example, uppercase A = 65, asterisk (*) = 42, and lowercase k = 107.
//A modern encryption method is to take a text file, convert the bytes to 
//ASCII, then XOR each byte with a given value, taken from a secret key. The 
//advantage with the XOR function is that using the same encryption key on 
//the cipher text, restores the plain text; for example, 65 XOR 42 = 107, 
//then 107 XOR 42 = 65.
//For unbreakable encryption, the key is the same length as the plain text 
//message, and the key is made up of random bytes. The user would keep the 
//encrypted message and the encryption key in different locations, and without 
//both "halves", it is impossible to decrypt the message.
//Unfortunately, this method is impractical for most users, so the modified 
//method is to use a password as a key. If the password is shorter than the 
//message, which is likely, the key is repeated cyclically throughout the 
//message. The balance for this method is using a sufficiently long password 
//key for security, but short enough to be memorable.
//Your task has been made easy, as the encryption key consists of three 
//lower case characters. Using cipher1.txt (right click and 'Save Link/Target 
//As...'), a file containing the encrypted ASCII codes, and the knowledge that 
//the plain text must contain common English words, decrypt the message and 
//find the sum of the ASCII values in the original text.

public class Euler0059 {

    private static HashMap<Integer, Integer> charProb =
            new HashMap<Integer, Integer>();

    public static void main(String[] args) {
        long time = System.currentTimeMillis();

        populateCharProb();

        Integer key[] = new Integer[] {
                0, 0, 0
        };
        Integer ints[] = Tools
                .readIntegersListFromFile("com/kjellstrand/euler/euler0059_cipher1.txt");
        // keys are 103, 111, 100
        findBestKey(key, 0, ints);
        findBestKey(key, 1, ints);
        findBestKey(key, 2, ints);
       
        StringBuffer sb = decode(key, ints);

        System.out.println(count(sb));

        System.out.println("time: " + (System.currentTimeMillis() - time) + "ms");
    }
    
    private static int count(StringBuffer string){
        int res=0;
        for (int i=0;i<string.length(); i++) {
            res += string.charAt(i);
        }
        return res;
    }
        
    private static StringBuffer decode(Integer[] key, Integer[] ints){
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < ints.length; i++) {
            sb.append((char)(key[i % key.length] ^ ints[i]));
        }
        return sb;
    }

    private static void findBestKey(Integer[] key, int keyPos, Integer[] ints){
        int min = Integer.MAX_VALUE;
        int bestKey = -1;
        for (int i = 0; i < 128; i++) {
            key[keyPos] = i;
            int temProb = checkKeyAtPosProbability(key, keyPos, ints);
            
            if(temProb < min){
                min = temProb;
                bestKey = i;
            }
        }
        key[keyPos] = bestKey;
    }

    private static int checkKeyAtPosProbability(Integer[] key, int pos, Integer[] ints) {
        int res = 0;
        for (int i = pos; i < ints.length; i += key.length) {
            int t = 10;
            int val = key[i % key.length] ^ ints[i];
            if (charProb.containsKey(val)) {
                t = charProb.get(val);
            }
            res += t;
            t = 10;
        }
        return res;
    }

    private static void populateCharProb() {
        charProb.put(Integer.valueOf('q'), Integer.valueOf(0));
        charProb.put(Integer.valueOf('w'), Integer.valueOf(0));
        charProb.put(Integer.valueOf('e'), Integer.valueOf(0));
        charProb.put(Integer.valueOf('r'), Integer.valueOf(0));
        charProb.put(Integer.valueOf('t'), Integer.valueOf(0));
        charProb.put(Integer.valueOf('y'), Integer.valueOf(0));
        charProb.put(Integer.valueOf('u'), Integer.valueOf(0));
        charProb.put(Integer.valueOf('i'), Integer.valueOf(0));
        charProb.put(Integer.valueOf('o'), Integer.valueOf(0));
        charProb.put(Integer.valueOf('p'), Integer.valueOf(0));
        charProb.put(Integer.valueOf('a'), Integer.valueOf(0));
        charProb.put(Integer.valueOf('s'), Integer.valueOf(0));
        charProb.put(Integer.valueOf('d'), Integer.valueOf(0));
        charProb.put(Integer.valueOf('f'), Integer.valueOf(0));
        charProb.put(Integer.valueOf('g'), Integer.valueOf(0));
        charProb.put(Integer.valueOf('h'), Integer.valueOf(0));
        charProb.put(Integer.valueOf('j'), Integer.valueOf(0));
        charProb.put(Integer.valueOf('k'), Integer.valueOf(0));
        charProb.put(Integer.valueOf('l'), Integer.valueOf(0));
        charProb.put(Integer.valueOf('z'), Integer.valueOf(0));
        charProb.put(Integer.valueOf('x'), Integer.valueOf(0));
        charProb.put(Integer.valueOf('c'), Integer.valueOf(0));
        charProb.put(Integer.valueOf('v'), Integer.valueOf(0));
        charProb.put(Integer.valueOf('b'), Integer.valueOf(0));
        charProb.put(Integer.valueOf('n'), Integer.valueOf(0));
        charProb.put(Integer.valueOf('m'), Integer.valueOf(0));
        charProb.put(Integer.valueOf('Q'), Integer.valueOf(0));
        charProb.put(Integer.valueOf('W'), Integer.valueOf(0));
        charProb.put(Integer.valueOf('E'), Integer.valueOf(0));
        charProb.put(Integer.valueOf('R'), Integer.valueOf(0));
        charProb.put(Integer.valueOf('T'), Integer.valueOf(0));
        charProb.put(Integer.valueOf('Y'), Integer.valueOf(0));
        charProb.put(Integer.valueOf('U'), Integer.valueOf(0));
        charProb.put(Integer.valueOf('I'), Integer.valueOf(0));
        charProb.put(Integer.valueOf('O'), Integer.valueOf(0));
        charProb.put(Integer.valueOf('P'), Integer.valueOf(0));
        charProb.put(Integer.valueOf('A'), Integer.valueOf(0));
        charProb.put(Integer.valueOf('S'), Integer.valueOf(0));
        charProb.put(Integer.valueOf('D'), Integer.valueOf(0));
        charProb.put(Integer.valueOf('F'), Integer.valueOf(0));
        charProb.put(Integer.valueOf('G'), Integer.valueOf(0));
        charProb.put(Integer.valueOf('H'), Integer.valueOf(0));
        charProb.put(Integer.valueOf('J'), Integer.valueOf(0));
        charProb.put(Integer.valueOf('K'), Integer.valueOf(0));
        charProb.put(Integer.valueOf('L'), Integer.valueOf(0));
        charProb.put(Integer.valueOf('Z'), Integer.valueOf(0));
        charProb.put(Integer.valueOf('X'), Integer.valueOf(0));
        charProb.put(Integer.valueOf('C'), Integer.valueOf(0));
        charProb.put(Integer.valueOf('V'), Integer.valueOf(0));
        charProb.put(Integer.valueOf('B'), Integer.valueOf(0));
        charProb.put(Integer.valueOf('N'), Integer.valueOf(0));
        charProb.put(Integer.valueOf('M'), Integer.valueOf(0));
        charProb.put(Integer.valueOf('1'), Integer.valueOf(0));
        charProb.put(Integer.valueOf('2'), Integer.valueOf(0));
        charProb.put(Integer.valueOf('3'), Integer.valueOf(0));
        charProb.put(Integer.valueOf('4'), Integer.valueOf(0));
        charProb.put(Integer.valueOf('5'), Integer.valueOf(0));
        charProb.put(Integer.valueOf('6'), Integer.valueOf(0));
        charProb.put(Integer.valueOf('7'), Integer.valueOf(0));
        charProb.put(Integer.valueOf('8'), Integer.valueOf(0));
        charProb.put(Integer.valueOf('9'), Integer.valueOf(0));
        charProb.put(Integer.valueOf('0'), Integer.valueOf(0));
        charProb.put(Integer.valueOf(' '), Integer.valueOf(0));

        charProb.put(Integer.valueOf('.'), Integer.valueOf(1));
        charProb.put(Integer.valueOf('!'), Integer.valueOf(1));
        charProb.put(Integer.valueOf('?'), Integer.valueOf(1));
        charProb.put(Integer.valueOf(','), Integer.valueOf(1));
        charProb.put(Integer.valueOf('('), Integer.valueOf(1));
        charProb.put(Integer.valueOf(')'), Integer.valueOf(1));
        charProb.put(Integer.valueOf('['), Integer.valueOf(2));
        charProb.put(Integer.valueOf(']'), Integer.valueOf(2));
        charProb.put(Integer.valueOf('{'), Integer.valueOf(2));
        charProb.put(Integer.valueOf('}'), Integer.valueOf(2));
        charProb.put(Integer.valueOf('"'), Integer.valueOf(3));
        charProb.put(Integer.valueOf('\''), Integer.valueOf(3));
    }

}
