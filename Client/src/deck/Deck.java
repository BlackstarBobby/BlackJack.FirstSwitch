package deck;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    ArrayList<Card> pachet;

    public Deck(){
        pachet = new ArrayList<Card>();
        for(int i=1;i<=13;i++)
        {
            pachet.add(new Card(i,"diamonds"));
            pachet.add(new Card(i,"clubs"));
            pachet.add(new Card(i,"hearts"));
            pachet.add(new Card(i,"spades"));
        }
        shuffle();
    }

    public void shuffle(){
        Collections.shuffle(pachet);
    }

    public Card getCard() {
        Card temp;
        temp = pachet.get(pachet.size()-1);
        pachet.remove(pachet.size()-1);
        return temp;
    }
}
