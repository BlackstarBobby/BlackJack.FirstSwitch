package deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by Mihai on 16-Jul-16.
 */
public class Deck
{
    public enum Suit
    {
        diamonds, hearts, spades, clubs
    }
    private ArrayList<Card> cards;

    public Deck()
    {
        cards = new ArrayList<Card>();
        int j = 0;
        for (int i = 2;i <= 14;i++) {
            for(Suit s : Suit.values())
            {
                cards.add(new Card(s.toString(),i));
            }
        }
        shuffle();
    }
    public String toString(){
        return String.format("in pachet sunt %s de carti", cards.size());
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }

    public Card drawCard()
    {
        Card temp = cards.get(0);
        cards.remove(0);
        return temp;
    }
}
