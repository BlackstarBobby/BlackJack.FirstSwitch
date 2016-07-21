package deck;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by Mihai on 16-Jul-16.
 */

public class Card implements Serializable
{
    public static final long serialVersionUID = 1L;

    private int points;
    private int value;
    private String suit;

    public Card()
    {
        value = 1;
        suit = "uninitialised";
    }

    public Card(String type, int value)
    {
        this.value = value;
        this.suit = type;
        if (value < 12)
            this.points = value;
        else this.points = 10;//pentru ca punctajul J D K e de 10
    }


    public int getPoints(){
        return points;
    }
    public int getValue(){return value;}
    public void setValue(int value)
    {
        this.value = value;
    }
    public String getSuit()
    {
        return suit;
    }
    public void setSuit(String suit)
    {
        this.suit = suit;
    }


    public String toString()
    {
        String result = "";
        if(value == 11)
        {
            result = "ace_of_" + suit;
        }
        if(value == 12)
        {
            result = "jack_of_" + suit;
        }
        if(value == 13)
        {
            result = "queen_of_" + suit;
        }
        if(value == 14)
        {
            result = "king_of_" + suit;
        }
        if(value <= 10)
        {
            result = value + "_of_" + suit;
        }
        return result;
    }
}
