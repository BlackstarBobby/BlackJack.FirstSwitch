package client;

/**
 * Created by Cretu Calin on 7/16/2016.
 */
public class Interpreter {

    private Communication communication;

    public Interpreter(Communication communication)
    {
        this.communication = communication;
    }

    public void interpret()
    {
        String message = (String)communication.receiveMessage();
        if (message.equals("You Won"))
            System.out.println(message);
            else
            System.out.println("You Lost");
    }
    public void play()
    {
        interpret();
        // blah blah blah
    }



}
