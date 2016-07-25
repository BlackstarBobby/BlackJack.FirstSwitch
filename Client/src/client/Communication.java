package client;

import userInterface.Frame;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by Cretu Calin on 7/16/2016.
 */

public class Communication
{

    private Connection connection;
    private ObjectInputStream input;
    private ObjectOutputStream output;
    private Communication thisCommunication;


    //private Interpreter interpret;
    private Frame frame;


    public Communication(Connection connection){
        this.connection=connection;
        thisCommunication = this;
        setUpStreams();
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
    public void sendHit()
    {
        try {
            output.writeObject("HIT");
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void sendStand()
    {
        try {
            output.writeObject("STAND");
            output.flush();
        } catch (IOException e) {
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

    public void startUserInterface() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new Frame(thisCommunication);
                    frame.setVisible(true);


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }



}

