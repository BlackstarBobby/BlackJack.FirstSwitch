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

public class InitialFrame extends JFrame {

    private JPanel contentPane;
    private JTextField txtLittleJockFrom;
    private Client client;

    /**
     * Launch the application.
     */
//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    InitialFrame frame = new InitialFrame(client);
//                    frame.setVisible(true);
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }

    /**
     * Create the frame.
     */

    public InitialFrame(Client client) {
        this.client = client;
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
                        // TODO Auto-generated method stub
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

        JFormattedTextField frmtdtxtfldSalutate = new JFormattedTextField();
        frmtdtxtfldSalutate.setBounds(212, 110, 179, 33);
        contentPane.add(frmtdtxtfldSalutate);

        txtLittleJockFrom = new JTextField();
        txtLittleJockFrom.setBackground(Color.LIGHT_GRAY);
        txtLittleJockFrom.setFont(txtLittleJockFrom.getFont().deriveFont(11f));
        txtLittleJockFrom.setEditable(false);
        txtLittleJockFrom.setText("Little jock from the web");
        txtLittleJockFrom.setBounds(27, 11, 365, 73);
        contentPane.add(txtLittleJockFrom);
        txtLittleJockFrom.setColumns(10);
    }
}

