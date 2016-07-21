package client;

import userInterface.Frame;

import javax.swing.*;
import java.util.Scanner;

/**
 * Created by Cretu Calin on 7/21/2016.
 */
public class Client {

    Interpreter interpreter;
    Communication communication;
    Frame frame;

    Client(Interpreter interpreter, Communication communication)
    {
        this.interpreter = interpreter;
        this.communication = communication;
    }

    public void chooseHowToPlay()
    {
        String answer;
        Scanner scan = new Scanner(System.in);
        System.out.println("TERMINAL / UI ?");
        answer = scan.nextLine();
        if(answer.equals("TERMINAL"))
            playTerminal();
        else
            playUserInterface();
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
