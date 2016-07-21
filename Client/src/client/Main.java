package client;

import userInterface.Frame;

/**
 * Created by Cretu Calinn on 7/16/2016.
 */

public class Main {

    public static void main(String[] args)
    {
        Connection connection = new Connection("localhost",9797);
        Communication communication = new Communication(connection);
        Interpreter interpreter = new Interpreter(communication);
        Client client = new Client(interpreter, communication);
        client.startInitialFrame();

    }

}

