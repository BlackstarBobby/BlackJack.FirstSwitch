package gamelogic;

import deck.Card;
import deck.Deck;
import networking.PlayerCommunication;
import networking.Server;

import java.io.IOException;

/**
 * Created by Mihai on 16-Jul-16.
 */
public class GameLogic
{
    private Deck deck;
    private Server server;

    private PlayerBehaviour dealer;

    public GameLogic(Server server)
    {
        deck = new Deck();
        this.server = server;
        dealer = new PlayerBehaviour("dealer");
    }

    public void startGame()
    {
        setTwoCards();
        showCards();

        server.setGameStarted(true);

        playersTurn();
        dealersTurn();
        sendResults();
        server.setGameOver(true);
    }

    private void setTwoCards()
    {
        Card card;
        for(int i = 0; i < server.getNumberOfPlayers(); i++)
        {   card = deck.drawCard();
            server.getThreads().get(i).addCard(card);
            card = deck.drawCard();
            server.getThreads().get(i).addCard(card);
        }
        card = deck.drawCard();
        dealer.addCard(card);
        card = deck.drawCard();
        dealer.addCard(card);
    }

    private void showCards()
    {
        for(int i = 0; i < server.getNumberOfPlayers(); i++)
        {
            for(int j = 0; j < server.getNumberOfPlayers(); j++)
            {

                server.getThreads().get(j).sendToClient("Player" + (i + 1));
                server.getThreads().get(j).sendToClient(server.getThreads().get(i).getCards().get(0));
                server.getThreads().get(j).sendToClient(server.getThreads().get(i).getCards().get(1));
                server.getThreads().get(j).sendToClient(server.getThreads().get(i).getTotal());
            }
        }

        for(int i = 0 ; i < server.getNumberOfPlayers(); i++)
        {
            server.getThreads().get(i).sendToClient("Dealer");
            server.getThreads().get(i).sendToClient(dealer.getCards().get(0));
        }
    }

    public void playersTurn()
    {
        while(server.getTurn() < server.getNumberOfPlayers())
        {
            if(server.getThreads().get(server.getTurn()).isFinished())
                server.setTurn(server.getTurn() + 1);

        }
    }

    private int getMinimum(){
        int minimum = 22;
        for(int i = 0;i < server.getNumberOfPlayers(); i++)
            if(minimum > server.getThreads().get(i).getTotal())
                minimum = server.getThreads().get(i).getTotal();
        return minimum;
    }

    public void dealersTurn()
    {
        for(int i = 0; i < server.getNumberOfPlayers(); i++)
        {
            server.getThreads().get(i).sendToClient("Dealer's turn");
            server.getThreads().get(i).sendToClient(dealer.getCards().get(1));
        }
        Card card;

        while(dealer.getTotal() < getMinimum())
        {
            card = deck.drawCard();
            dealer.addCard(card);
            for(int i = 0; i < server.getNumberOfPlayers(); i++)
            {
                server.getThreads().get(i).sendToClient(card);
            }
        }
    }

    public void sendResults() // trimitem rezultatele jucatorilor
    {
        for(int i = 0; i<server.getThreads().size(); i++)
        {
            if(server.getThreads().get(i).getTotal() <= 21)
            {
                if(dealer.getTotal() <= 21)
                {
                    if(dealer.getTotal() > server.getThreads().get(i).getTotal())
                    {
                        server.getThreads().get(i).sendToClient("LOSE");
                    }
                    else if (dealer.getTotal() == server.getThreads().get(i).getTotal())
                    {
                        server.getThreads().get(i).sendToClient("DRAW");
                    }
                    else
                    {
                        server.getThreads().get(i).sendToClient("WIN");
                    }
                }
                else {
                    server.getThreads().get(i).sendToClient("Dealer Busted! You Win");
                }
            }
        }
    }

    public void interpretMessage(PlayerCommunication player, String message)
    {
        if (message.equals("STAND"))
        {
            player.setFinished(true);
        }

        if (message.equals("HIT"))
        {
            hitCardAndCheckBust(player);
        }
    }

    public void hitCardAndCheckBust(PlayerCommunication player)
    {
        Card card = deck.drawCard();
        player.addCard(card);

        for (int i = 0; i < server.getNumberOfPlayers(); i++)
        {
            server.getThreads().get(i).sendToClient(card);
        }
        if(player.getTotal() > 21)
        {
            player.setFinished(true);
            for (int i = 0; i < server.getNumberOfPlayers(); i++)
            {
                server.getThreads().get(i).sendToClient("BUST");
            }

        }
        else
        {
            for (int i = 0; i < server.getNumberOfPlayers(); i++)
            {
                server.getThreads().get(i).sendToClient(player.getTotal());
            }

        }
    }



}
