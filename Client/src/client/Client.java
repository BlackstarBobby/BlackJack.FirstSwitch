package client;

import sun.util.resources.cldr.ee.TimeZoneNames_ee;
import userInterface.Frame;
import userInterface.InitialFrame;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Time;
import java.util.Scanner;

/**
 * Created by Cretu Calin on 7/21/2016.
 */
public class Client {

    private Interpreter interpreter;
    private Communication communication;
    private InitialFrame initialFrame ;
    private Client thisClient;
    private HttpRequest http ;




    Client(Interpreter interpreter, Communication communication)
    {

        this.interpreter = interpreter;
        this.communication = communication;
        this.initialFrame = new InitialFrame(this);
        thisClient = this;

    }


    public void chooseHowToPlay() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    initialFrame = new InitialFrame(thisClient);
                    initialFrame.setVisible(true);
                    getUsername();
                    initialFrame.setJoke(new HttpRequest().sendGet());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void getUsername()
    {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("src/userInterface/username.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            String userName = br.readLine();
            if (userName != null) {
                initialFrame.setUsername(userName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void playUserInterface()
    {
        communication.startUserInterface();
        interpreter.interpretForUI();
    }

    public void playTerminal()
    {
        interpreter.interpretTerminal();
    }



}
