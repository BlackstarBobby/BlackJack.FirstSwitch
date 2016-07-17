package client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;


/**
 * Created by Cretu Calin on 7/16/2016.
 */

public class Connection {


    private Socket socket;
    private String IP;
    private int port;

    Connection(String IP, int port)
    {
        this.IP = IP;
        this.port = port;
        connectToServer();

    }

    public Socket getSocket() {
        return socket;
    }

    private void connectToServer()
    {
        System.out.println("Attempting connection...\n");
        try {
            socket = new Socket(IP, port);
            System.out.println("Connected to server\n");
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}


