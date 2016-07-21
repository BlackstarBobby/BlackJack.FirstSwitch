package client;

import userInterface.Frame;
import userInterface.InitialFrame;

import javax.swing.*;
import java.util.Scanner;

/**
 * Created by Cretu Calin on 7/21/2016.
 */
public class Client {

    private Interpreter interpreter;
    private Communication communication;
    private InitialFrame initialFrame ;
    private Client thisClient;


    Client(Interpreter interpreter, Communication communication)
    {
        this.interpreter = interpreter;
        this.communication = communication;
        this.initialFrame = new InitialFrame(this);
        thisClient = this;
    }

    public void chooseHowToPlay()
    {


    }

    public void startInitialFrame() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    initialFrame = new InitialFrame(thisClient);
                    initialFrame.setVisible(true);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void playUserInterface()
    {
        communication.startUserInterface();
        interpreter.interpret();
    }

    public void playTerminal()
    {
        interpreter.interpretTerminal();
    }

}
