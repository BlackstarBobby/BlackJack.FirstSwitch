package client;

/**
 * Created by Cretu Calinn on 7/16/2016.
 */
public class Main {

    public static void main(String[] args) {

        Connection connection = new Connection("123.12.12.34", 1234);
        Communication communication = new Communication(connection);
        Interpreter client = new Interpreter(communication);
        client.play();


    }

}

