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
       Server server = new Server();
       server.waitForConnections();
    }
}
