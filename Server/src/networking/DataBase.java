package networking;
import javax.xml.crypto.Data;
import java.sql.*;
/**
 * Created by Cretu Calin on 7/27/2016.
 */
public class DataBase {
    private Connection myConn = null;
    private Statement myStmt = null;
    private ResultSet myRs = null;

    DataBase()
    {
        connectToDataBase();
        createStatement();
    }

    private void connectToDataBase()
    {
        // 1. Get a connection to database
        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blackjackdatabase", "cretu97" , "//change this");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void createStatement()
    {
        // 2. Create a statement
        try {
            myStmt = myConn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void addingUserAndScore(String username, int score)
    {
        String command = "INSERT INTO `blackjackdatabase`.`score` " +
                        " (`username`, `score`) " +
                        "  VALUES ('"+ username + "','" + score + "')";
        try {
            myStmt.executeUpdate(command);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void getResults()
    {
        String result = "";
        try {
            myRs = myStmt.executeQuery("select * from score");
            while (myRs.next())
            {
                System.out.println(myRs.getString("username") + " -> " + myRs.getString("score"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws SQLException {

        DataBase dataBase = new DataBase();
        dataBase.addingUserAndScore("Calinn", 20);
        dataBase.getResults();

    }
}
