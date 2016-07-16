package client;

import java.io.IOException;

/**
 * Created by Cretu Calin on 7/16/2016.
 */
public class Communicate {

    private Connect connect ;

    public Communicate()
    {
        connect = new Connect("93.115.22.101",1234);
    }
    public void sendMessage(String message)
    {
        try {
            connect.getOutput().writeObject(message);
            connect.getOutput().flush();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public Object receiveMessage()
    {
        return connect.getInput();
    }


}
