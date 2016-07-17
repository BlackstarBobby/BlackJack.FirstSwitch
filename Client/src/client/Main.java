package client;

/**
 * Created by Cretu Calinn on 7/16/2016.
 */

public class Main {

    public static void main(String[] args)
    {

        Connection connection = new Connection("192.168.1.153", 80);
        Communication communication = new Communication(connection);
        Interpreter client = new Interpreter(communication);
        client.interpret();

    }

}

