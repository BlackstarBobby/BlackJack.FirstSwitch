package userInterface;
import client.Client;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;

public class InitialFrame extends JFrame {

    private JPanel contentPane;
    private JTextField txtLittleJockFrom;
    private Client client;
    JFormattedTextField frmtdtxtfldUserNmae;

    public InitialFrame(Client client) {
        this.client = client;
        InitialFrame thisInitialFrame = this;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 428, 298);
        contentPane = new JPanel();
        contentPane.setToolTipText("C'mon ! I know you want it !");
        contentPane.setBackground(Color.LIGHT_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        //PLAY IN THE UI Button
        JButton userInterfaceButton = new JButton("Play in UI");
        userInterfaceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                SwingWorker<Void,Void> worker = new SwingWorker<Void,Void>()
                {

                    @Override
                    protected Void doInBackground() throws Exception {



                        thisInitialFrame.setVisible(false);
                        writeUserNameInFile();
                        System.out.println(frmtdtxtfldUserNmae.getText());
                        client.playUserInterface();
                        return null;
                    }

                };
                worker.execute();

            }
        });
        userInterfaceButton.setBounds(27, 217, 175, 33);
        contentPane.add(userInterfaceButton);
        //PLAY IN THE TERMINAL Button
        JButton terminalButton = new JButton("Old School ;)");
        terminalButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SwingWorker<Void,Void> worker = new SwingWorker<Void,Void>()
                {

                    @Override
                    protected Void doInBackground() throws Exception {
                        // TODO Auto-generated method stub
                        thisInitialFrame.setVisible(false);
                        writeUserNameInFile();
                        client.playTerminal();
                        return null;
                    }

                };
                worker.execute();
            }
        });

        terminalButton.setBounds(212, 217, 180, 33);
        contentPane.add(terminalButton);
        //
        JTextPane txtpnPleaseEnterYour = new JTextPane();
        txtpnPleaseEnterYour.setToolTipText("C'mon ! I know you want it !");
        txtpnPleaseEnterYour.setBackground(Color.LIGHT_GRAY);
        txtpnPleaseEnterYour.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtpnPleaseEnterYour.setEditable(false);
        txtpnPleaseEnterYour.setText("Please enter your name :");
        txtpnPleaseEnterYour.setBounds(27, 110, 175, 33);
        contentPane.add(txtpnPleaseEnterYour);

        // User name
        frmtdtxtfldUserNmae = new JFormattedTextField();
        frmtdtxtfldUserNmae.setBounds(212, 110, 179, 33);
        contentPane.add(frmtdtxtfldUserNmae);


// panel for joke
        txtLittleJockFrom = new JTextField();
        txtLittleJockFrom.setBackground(Color.LIGHT_GRAY);
        txtLittleJockFrom.setFont(txtLittleJockFrom.getFont().deriveFont(11f));
        txtLittleJockFrom.setEditable(false);
        //txtLittleJockFrom.setText("Little jock from the web");
        txtLittleJockFrom.setBounds(27, 11, 365, 73);
        contentPane.add(txtLittleJockFrom);
        txtLittleJockFrom.setColumns(10);


    }
    public void setJoke(String joke)
    {
        txtLittleJockFrom.setText(joke);
    }

    public void setUsername(String username)
    {
        frmtdtxtfldUserNmae.setText(username);
    }

    private void writeUserNameInFile()
    {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter("C:\\Users\\usseerr\\Desktop\\BJ\\ClientV2\\src\\userInterface\\username.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        pw.write(frmtdtxtfldUserNmae.getText());
        pw.close();
    }

}

