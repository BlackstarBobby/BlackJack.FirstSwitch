package client;
import deck.Card;

/**
 * Created by Cretu Calin on 7/16/2016.
 */

public class Interpreter
{

    private Communication communication;
    Object messageReceived;

    public Interpreter(Communication communication)
    {
        this.communication = communication;
    }

    public void interpret()
    {
        messageReceived =  communication.receiveMessage();

        while(messageReceived != null)
        {
            if (messageReceived instanceof Card)
            {
                System.out.println((Card) messageReceived);//
            }
            if (messageReceived instanceof Integer)
            {
                System.out.println((Integer) messageReceived);
            }
            if (messageReceived instanceof String)
            {
                String message = messageReceived.toString();
                if (message.equals("BUSTED"))
                {
                    System.out.println("Bust! You Lost");
                    break;
                }
                else if (message.equals("You Win") || message.equals("You Lost") || message.equals("Draw") || message.equals("Dealer BUSTED! You Win!"))
                {
                    System.out.println(message);
                    break;
                }
                else
                {
                    System.out.println(message);
                }
            }
            messageReceived = communication.getInput();

        }
    }
    public void play()
    {
        interpret();
        // blah blah blah
    }



}
