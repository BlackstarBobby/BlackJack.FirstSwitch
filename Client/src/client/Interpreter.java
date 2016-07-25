package client;
import javax.swing.SwingUtilities;

import deck.Card;

/**
 * Created by Cretu Calin on 7/16/2016.
 */

public class Interpreter
{
    private Communication communication;
    private boolean myTurn;

    public Interpreter(Communication communication)
    {
        this.communication = communication;
        myTurn = false;
    }
    // trebuie rezivuit pentru ca sunt probleme la trimiterea cartilor
    // nu stii care carti iti apartin -> (treaba facuta in interfata grafica

    public void interpretTerminal()
    {
        Object messageReceived = communication.receiveMessage();

        while (messageReceived != null) {

            if (messageReceived instanceof Card) {
                System.out.println("You get" + (Card) messageReceived);
            }
            if (messageReceived instanceof Integer) {
                System.out.println("Your total is" + (int) messageReceived);
            }
            if (messageReceived instanceof String) {
                String message = messageReceived.toString();
                if (message.equals("BUSTED")) {
                    System.out.println("Bust! You Lost");
                    break;
                } else if (message.equals("You Win") || message.equals("You Lost") || message.equals("Draw") || message.equals("Dealer BUSTED! You Win!")) {
                    System.out.println(message);
                    break;
                }
                else
                {
                    System.out.println(message);
                }
            }
            messageReceived = communication.receiveMessage();

        }
    }

    public void interpretForUI()
    {

        Object messageReceived = communication.receiveMessage();

        label:
        while (messageReceived != null) {
            if (messageReceived instanceof Card) {
                communication.getFrame().addCard((Card) messageReceived);
            }
            else if (messageReceived instanceof Integer) {
                communication.getFrame().setTotal(((int) messageReceived));
            }
            else if (messageReceived instanceof String) {
                String message = messageReceived.toString();

                switch (message) {
                    case "Player 1":
                        communication.getFrame().setPlayerFocus(1);
                        break;
                    case "Player 2":
                        communication.getFrame().setPlayerFocus(2);
                        break;
                    case "Player 3":
                        communication.getFrame().setPlayerFocus(3);
                        break;
                    case "Player 4":
                        communication.getFrame().setPlayerFocus(4);
                        break;
                    case "Dealer":
                        communication.getFrame().setPlayerFocus(0);
                        break;
                    case "Your turn is 1":
                        communication.getFrame().setPlayer(1);
                        break;
                    case "Your turn is 2":
                        communication.getFrame().setPlayer(2);
                        break;
                    case "Your turn is 3":
                        communication.getFrame().setPlayer(3);
                        break;
                    case "Your turn is 4":
                        communication.getFrame().setPlayer(4);
                        break;
                    case "BUST":
                        if (myTurn) {
                            communication.getFrame().setStatus(message);
                            communication.getFrame().setFinalMessage(message);
                            communication.getFrame().disableButtons();
                            myTurn = false;
                            break label;
                        } else {
                            communication.getFrame().setTotal(22);
                        }
                        break;
                    case "WIN":
                    case "LOSE":
                    case "DRAW":
                    case "Dealer Busted! You Win":
                        communication.getFrame().setStatus(message);
                        communication.getFrame().setFinalMessage(message);
                        communication.getFrame().disableButtons();
                        myTurn = false;
                        break label;
                    case "Enter option: HIT/STAND":
                        communication.getFrame().enableButtons();
                        myTurn = true;
                        break;
                }

            }
            messageReceived = communication.receiveMessage();

        }
    }


}
