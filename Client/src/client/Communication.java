package client;

import java.io.IOException;

/**
 * Created by Cretu Calin on 7/16/2016.
 */
public class Communication {

    private Connection connection ;

    public Communication()
    {
        connection = new Connection("93.115.22.101",1234);
    }
    public void sendMessage(String message)
    {
        try {
            connection.getOutput().writeObject(message);
            connection.getOutput().flush();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public Object receiveMessage()
    {
        return connection.getInput();
    }


}
