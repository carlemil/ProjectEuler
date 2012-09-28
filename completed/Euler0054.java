
package completed;

import com.kjellstrand.euler.Tools;

import java.util.ArrayList;

//In the card game poker, a hand consists of five cards and are 
//ranked, from lowest to highest, in the following way:
//
//High Card: Highest value card.
//One Pair: Two cards of the same value.
//Two Pairs: Two different pairs.
//Three of a Kind: Three cards of the same value.
//Straight: All cards are consecutive values.
//Flush: All cards of the same suit.
//Full House: Three of a kind and a pair.
//Four of a Kind: Four cards of the same value.
//Straight Flush: All cards are consecutive values of same suit.
//Royal Flush: Ten, Jack, Queen, King, Ace, in same suit.
//The cards are valued in the order:
//2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King, Ace.
//
//If two players have the same ranked hands then the rank made up 
//of the highest value wins; for example, a pair of eights beats a 
//pair of fives (see example 1 below). 
//But if two ranks tie, for example, both players have a pair of 
//queens, then highest cards in each hand are compared (see example
//4 below); if the highest cards tie then the next highest cards 
//are compared, and so on.
//
//The file, poker.txt, contains one-thousand random hands dealt to 
//two players. Each line of the file contains ten cards (separated 
//by a single space): the first five are Player 1's cards and the 
//last five are Player 2's cards. You can assume that all hands are 
//valid (no invalid characters or repeated cards), each player's 
//hand is in no specific order, and in each hand there is a clear 
//winner.
//
//How many hands does Player 1 win?

public class Euler0054 {

    public static void main(String[] args) {

        ArrayList<String> numerals = new ArrayList<String>();
        Tools.readStringListFromFile("completed/euler0054_poker.txt", numerals);

        Hand h1 = new Hand();
        Hand h2 = new Hand();
        int c1 = 0;
        int c2 = 0;

        for (String numeral : numerals) {

            String[] cards = numeral.split(" ");

            for (int i = 0; i < 5; i++) {
                h1.cards[i].setCard(cards[i]);
            }
            for (int i = 5; i < 10; i++) {
                h2.cards[i - 5].setCard(cards[i]);
            }
            h1.EvalHand();
            h2.EvalHand();
            if (isFirstHandBest(h1, h2)) {
                c1++;
            } else {
                c2++;
            }
        }
        System.out.println(c1);
    }

    public static boolean isFirstHandBest(Hand h1, Hand h2) {
        if (h1.rankHand > h2.rankHand) {
            return true;
        } else if (h1.rankHand < h2.rankHand) {
            return false;
        }
        for (int i = 0; i < 5; i++) {
            if (h1.rankHighestCards[i] > h2.rankHighestCards[i]) {
                return true;
            } else if (h1.rankHighestCards[i] < h2.rankHighestCards[i]) {
                return false;
            }
        }
        System.out.println("EQUAL ERROR;");
        return true;
    }
}

class Hand {
    Card[] cards = new Card[] {
            new Card(), new Card(), new Card(), new Card(), new Card()
    };

    public static final int HIGH_CARD = 0;
    public static final int PAIR = 1;
    public static final int TWO_PAIR = 2;
    public static final int THREE_OAK = 3;
    public static final int STRAIGHT = 4;
    public static final int FLUSH = 5;
    public static final int FULL_HOUSE = 6;
    public static final int FOUR_OAK = 7;
    public static final int STRAIGHT_FLUSH = 8;

    public int rankHand = 0;
    public int[] rankHighestCards = new int[5];
    int[] oak = new int[15];

    public void EvalHand() {
        clean();

        for (int i = 0; i < oak.length; i++) {
            oak[i] = 0;
        }
        oak[cards[0].mValue]++;
        oak[cards[1].mValue]++;
        oak[cards[2].mValue]++;
        oak[cards[3].mValue]++;
        oak[cards[4].mValue]++;

        // Pre process
        int m = 0; // many of a kind
        int f = 0; // few of a kind
        int r = 0; // runner for straight

        for (int i = 2; i < oak.length; i++) {
            if (oak[i] > oak[m]) {
                // find 2,3,4 oak
                f = m;
                m = i;
            } else if (oak[i] == oak[m]) {
                // find 2 pair
                f = m;
                m = i;
            }
            if (oak[i - 1] == oak[i] && oak[i] == 1) {
                // find straights
                r++;
            } else if (r != 4) {
                r = 0;
            }
        }
        // Eval
        if (flush() && r == 4) {
            // found Straight Flush
            rankHand = STRAIGHT_FLUSH;
            for (int j = 14; j > 5; j--) {
                if (oak[j] == 1) {
                    rankHighestCards[1] = oak[j];
                    break;
                }
            }
        } else if (oak[m] == 4) {
            // found Four OAK
            rankHand = FOUR_OAK;
            rankHighestCards[0] = oak[m];
            rankHighestCards[0] = m;
            fillHighestRankingCardsList(1);
        } else if (oak[m] == 3 && oak[f] == 2) {
            // found Full House
            rankHand = FULL_HOUSE;
            rankHighestCards[0] = m;
        } else if (flush()) {
            // found Flush
            rankHand = FLUSH;
        } else if (r == 4) {
            // found Straight
            rankHand = STRAIGHT;
            for (int j = 14; j > 5; j--) {
                if (oak[j] == 1) {
                    rankHighestCards[1] = j;
                    break;
                }
            }
        } else if (oak[14] == 1 && oak[2] == 1 && oak[3] == 1 && oak[4] == 1 && oak[5] == 1) {
            // found Straight
            rankHand = STRAIGHT;
            rankHighestCards[0] = 5;
        } else if (oak[m] == 3) {
            // found Three OAK
            rankHand = THREE_OAK;
            rankHighestCards[0] = m;
            fillHighestRankingCardsList(1);
        }
        else if (oak[m] == 2 && oak[f] == 2) {
            // found Two Pair
            rankHand = TWO_PAIR;
            if (m > f) {
                rankHighestCards[0] = m;
                rankHighestCards[1] = f;
            } else {
                rankHighestCards[0] = f;
                rankHighestCards[1] = m;
            }
            int hc = 0;
            for (int j = 0; j < oak.length; j++) {
                if (oak[j] == 1) {
                    rankHighestCards[2] = j;
                }
            }
        } else if (oak[m] == 2) {
            // found Pair
            rankHand = PAIR;
            rankHighestCards[0] = m;
            fillHighestRankingCardsList(1);
        } else {
            // found nothing
            rankHand = HIGH_CARD;
            fillHighestRankingCardsList(0);
        }

    }

    private void fillHighestRankingCardsList(int p) {
        for (int j = 14; j > 1; j--) {
            if (oak[j] == 1) {
                rankHighestCards[p++] = j;
            }
        }
    }

    private void clean() {
        rankHand = 0;
        rankHighestCards[0] = 0;
        rankHighestCards[1] = 0;
        rankHighestCards[2] = 0;
        rankHighestCards[3] = 0;
        rankHighestCards[4] = 0;
    }

    private boolean flush() {
        return cards[0].mSuit == cards[1].mSuit &&
                cards[1].mSuit == cards[2].mSuit &&
                cards[2].mSuit == cards[3].mSuit &&
                cards[3].mSuit == cards[4].mSuit;
    }
}

class Card {
    public static final int H = 1;
    public static final int D = 2;
    public static final int S = 3;
    public static final int C = 4;
    public int mValue = 0;
    public int mSuit = 0;

    public void setCard(String card) {
        char v = card.charAt(0);
        switch (v) {
            case 'T':
                mValue = 10;
                break;
            case 'J':
                mValue = 11;
                break;
            case 'Q':
                mValue = 12;
                break;
            case 'K':
                mValue = 13;
                break;
            case 'A':
                mValue = 14;
                break;
            default:
                mValue = Character.getNumericValue(v);
                break;
        }
        char s = card.charAt(1);
        switch (s) {
            case 'H':
                mSuit = H;
                break;
            case 'D':
                mSuit = D;
                break;
            case 'S':
                mSuit = S;
                break;
            case 'C':
                mSuit = C;
                break;
        }
    }
}
