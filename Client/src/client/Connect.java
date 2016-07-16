package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Cretu Calin on 7/16/2016.
 */

public class Connect {

    private Socket socket;
    private String IP;
    private int port;


    private ObjectInputStream input;

    public ObjectOutputStream getOutput() {
        return output;
    }

    private ObjectOutputStream output;


    Connect(String IP, int port)
    {
        this.IP = IP;
        this.port = port;
        connectToServer();
        setUpStreams();
    }

    public void setOutput(ObjectOutputStream output) {
        this.output = output;
    }
    public ObjectInputStream getInput() {
        return input;
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

    public void setUpStreams() {
        try {
            output = new ObjectOutputStream(socket.getOutputStream());
            output.flush();
            input = new ObjectInputStream(socket.getInputStream());
            System.out.println("Streams are up\n");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }







}
