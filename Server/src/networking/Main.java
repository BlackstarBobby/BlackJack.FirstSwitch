package networking;

import deck.Card;
import deck.Deck;

/**
 * Created by Mihai on 17-Jul-16.
 */
public class Main
{
    public static void main(String[] args)
    {
       // Server server = new Server();
    	Deck deck = new Deck();
    	for (int i = 0; i < 52; i++)
    	{
    		Card card = deck.drawCard();
    		System.out.println(card);
    	}

    }
}
