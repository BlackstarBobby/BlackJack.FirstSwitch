package client;

import userInterface.Frame;

import java.awt.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by Cretu Calin on 7/16/2016.
 */


public class Communication
{

    Connection connection;
    private ObjectInputStream input;
    private ObjectOutputStream output;



    //private Interpreter interpret;
    private Frame frame;


    public Communication(Connection connection){
        this.connection=connection;
        setUpStreams();
        startUserInterface();

    }

    public Frame getFrame() {
        return frame;
    }

    public void setOutput(ObjectOutputStream output)
    {
        this.output = output;
    }

    public ObjectInputStream getInput() {
        return input;
    }

    public void setUpStreams() {
        try {
            output = new ObjectOutputStream(connection.getSocket().getOutputStream());
            output.flush();
            input = new ObjectInputStream(connection.getSocket().getInputStream());
            System.out.println("Streams are up\n");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }


    public void sendMessage(String message)
    {
        try {
            output.writeObject(message);
            output.flush();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public Object receiveMessage()
    {
        try {
            return input.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void startUserInterface()
    {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new Frame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
