package client;
import deck.Card;

/**
 * Created by Cretu Calin on 7/16/2016.
 */

public class Interpreter
{

    private Communication communication;
    Object messageReceived;
    boolean myTurn;

    public Interpreter(Communication communication)
    {
        this.communication = communication;
        myTurn = false;

    }
    // setPlayerFocus(int playerFocus);
    // addCard(Card card);
    // setTotal(int total);
    // setStatus(String status);
    //
    //String
    //it's your turn blah -> // face un boolean my turn ->  il face true -> activam butoanele
    // if esle
    //bust -> my turn true Jdiagol cu YOU BUST!
    // if not -> setezi la totalul playerului busted
    //win lose draw
    //dealer;s turn -> SETAM panelul la dealer si stregem cartea cu fata in jos
    //else ->setam panelul -> primim player x
    //Card -> o punem in panelul in care suntem
    //INTEGER -> set total in panelul curent

    public void interpret()
    {
        messageReceived =  communication.receiveMessage();

        while(messageReceived != null)
        {
            if (messageReceived instanceof Card)
            {
                communication.getFrame().addCard((Card)messageReceived);
            }
            if (messageReceived instanceof Integer)
            {
                communication.getFrame().setTotal(((int)messageReceived));
            }
            if (messageReceived instanceof String)
            {
                String message = messageReceived.toString();

                if (message.equals("Player 1"))
                    communication.getFrame().setPlayerFocus(1);
                else if (message.equals("Player 2"))
                    communication.getFrame().setPlayerFocus(2);
                else if (message.equals("Player 3"))
                    communication.getFrame().setPlayerFocus(3);
                else if (message.equals("Player 4"))
                    communication.getFrame().setPlayerFocus(4);
                else if (message.equals("Dealer"))
                    communication.getFrame().setPlayerFocus(5);
                else if (message.equals("BUSTED"))
                {
                    System.out.println("Bust! You Lost");
                    myTurn = true;
                    break;
                }
                else if (message.equals("You Win") || message.equals("You Lost") || message.equals("Draw") || message.equals("Dealer BUSTED! You Win!"))
                {
                    communication.getFrame().setStatus(message);
                    myTurn=false;
                    break;
                }
                else if(message.equals("Enter option: HIT/STAND"))
                {
                    communication.getFrame().enterOptins();
                }
                else
                {
                    System.out.println(message);
                }
            }
            messageReceived = communication.getInput();

        }
    }


}
