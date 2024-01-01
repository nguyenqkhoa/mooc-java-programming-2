import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Hand implements Comparable<Hand>{

    private ArrayList<Card> hand = new ArrayList<>();

    public Hand(){
    }

    public void add(Card card){
        hand.add(card);
    }

    public void print(){
        for (Card c: hand) {
            System.out.println(c.toString());
        }
    }

    public void sort(){
        Comparator<Card> comparator = Comparator.comparing(Card::getValue).thenComparing(Card::getSuit);
        Collections.sort(hand, comparator);
    }

    @Override
    public int compareTo(Hand hand2) {
        int currentHandValue = 0;
        for (Card c : hand){
            currentHandValue += c.getValue();
        }
        int otherHandValue = 0;
        for (Card c : hand2.hand){
            otherHandValue += c.getValue();
        }
        return currentHandValue - otherHandValue;
    }

    public void sortBySuit(){
        Collections.sort(hand, new BySuitInValueOrder());
    }
}
