package deck;
import java.io.Serializable;
/**
 * Created by Cretu Calin on 7/16/2016.
 */


public class Card implements Serializable{

    public static final long serialVersionUID = 1L;

    private int value;
    private String culori;
    private String suit;

    Card(int value, String culori){
        this.value = value;
        this.culori = culori;
    }

    public int getValue(){
        if(value >= 10)
            return 10;
        return value;
    }


    @Override
    public String toString() {
        if(value == 1)
        {
            return "ace_of_" + culori;
        }
        if(value == 11)
        {
            return "jack_of_" + culori;
        }
        if(value == 12) {
            return "queen_of_" + culori;
        }
        if(value == 13)
        {
            return "king_of_" + culori;
        }
        return value + "_of_" + culori;
    }
}