package userInterface;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import deck.Card;
import deck.Deck;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLayeredPane;

public class Frame extends JFrame {

	private JPanel contentPane;
	int tablePanelwidth;
	int tablePanelheight;
	int cardToPrint = 0;
	BackgroundPanel panel_dealer;
	int playerFocus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Frame() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{170, 170, 170, 170, 0};
		gbl_contentPane.rowHeights = new int[]{313, 0, 164, 19, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
	//DECK ICON
	//*********************
		JPanel panelDeck = new JPanel();
		panelDeck = newPanel(0,0);
		JLabel lblDeckImage = new JLabel();
		lblDeckImage = imageToLabel("/userInterface/other/Card-Back.png",190,280);
		lblDeckImage.setBounds(9, 5, 190, 280);
		panelDeck.add(lblDeckImage);
	//*********************
	//DECK ICONS
		
	//DEALER TABLE
	//*********************
		
		tablePanelwidth = gbl_contentPane.columnWidths[1]+gbl_contentPane.columnWidths[2]+gbl_contentPane.columnWidths[3];
		tablePanelheight = gbl_contentPane.rowHeights[0];
		
		panel_dealer = new BackgroundPanel(tablePanelwidth, tablePanelheight);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridwidth = 3;
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 0;
		contentPane.add(panel_dealer, gbc_panel_2);
		panel_dealer.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		Deck deck = new Deck();
		Card card = deck.getCard();
		
		addDealerCard(card);
		addInvisibleCard();	
		
	//*********************
	//DEALER TABLE
		
	//CLIENT 1 TURN
	//*********************
		final JLabel lblTurn1 = new JLabel("Client 1 Turn");
		final GridBagConstraints gbc_lblTurn1 = new GridBagConstraints();
		gbc_lblTurn1.insets = new Insets(0, 0, 5, 5);
		gbc_lblTurn1.gridx = 0;
		gbc_lblTurn1.gridy = 1;
		contentPane.add(lblTurn1, gbc_lblTurn1);
	//CLIENT 1 TURN
	//*********************
		
	final Hand Clients[] = new Hand[5];
		
	//CLIENT 1 HAND
	//*********************
		
		JPanel Client1_panel = newPanel(0,2);
		Clients[1] = new Hand(Client1_panel, 1);
		Client1_panel.setVisible(true);
	//*********************
	//CLIENT 1 HAND
		
	//OTHER CLIENT DEFAULT TEXT
	//*********************
		JPanel Client2_panel = newPanel(1,2);
		Clients[2] = new Hand(Client2_panel, 2);
		
		JPanel Client3_panel = newPanel(2,2);
		Clients[3] = new Hand(Client3_panel, 3);
		
		JPanel Client4_panel = newPanel(3,2);
		Clients[4] = new Hand(Client4_panel, 4);
	
	//*********************
	//OTHER CLIENT DEFAULT TEXT
		
	//CLIENT LABELS
	//*********************
		
		JLabel Client1Label = newLabel(0,3,"Client1Label");
		JLabel Client2Label	= newLabel(1,3,"Client2Label");
		JLabel Client3Label = newLabel(2,3,"Client3Label");
		JLabel Client4Label = newLabel(3,3,"Client4Label");
		
	//*********************
	//CLIENT LABELS
		
	//HIT BUTTON
	//*********************
		final JButton btnHit = new JButton("HIT");
				
		btnHit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(cardToPrint<Clients[1].getCountLabels())
				{
					Deck deck = new Deck();
					Card card = deck.getCard();
				
					ImageIcon cardBacktemp = new ImageIcon(getClass().getResource("/userInterface/cards/" + card.toString() + ".png"));
					Clients[1].getLabel(cardToPrint).setIcon(new ImageIcon(cardBacktemp.getImage().getScaledInstance(100, 150, java.awt.Image.SCALE_SMOOTH)));
					Clients[1].getLabel(Clients[1].getCountLabels() - 1).setText("");
					
					lblTurn1.setText("Total " + card.getValue()); // AICI TREBUIE FACUT PRINT ARRAY DE TOTALURI, VECTORUL
					contentPane.add(lblTurn1, gbc_lblTurn1);
					cardToPrint++;
				}
				else
					JOptionPane.showMessageDialog(null, "Hai gata...", "Error",JOptionPane.ERROR_MESSAGE);
			}
		});
		
		GridBagConstraints gbc_btnHit = new GridBagConstraints();
		gbc_btnHit.insets = new Insets(0, 0, 0, 5);
		gbc_btnHit.gridx = 1;
		gbc_btnHit.gridy = 5;
		contentPane.add(btnHit, gbc_btnHit);
	//HIT BUTTON
	//*********************
		
	//STAND BUTTON
	//*********************
		JButton btnStand = new JButton("STAND");
		btnStand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//objectInputStream("Stand"); ceva de gen
			}
		});
		
		GridBagConstraints gbc_btnStand = new GridBagConstraints();
		gbc_btnStand.insets = new Insets(0, 0, 0, 5);
		gbc_btnStand.gridx = 2;
		gbc_btnStand.gridy = 5;
		contentPane.add(btnStand, gbc_btnStand);
	//STAND BUTTON
	//*********************
		
	}

	private JLabel newLabel(int pozx, int pozy, String string) {
		{
			JLabel label = new JLabel("New label");
			GridBagConstraints gbc_label = new GridBagConstraints();
			gbc_label.insets = new Insets(0, 0, 5, 5);
			gbc_label.gridx = 1;
			gbc_label.gridy = 1;
			contentPane.add(label, gbc_label);
		}
		
		JLabel temp = new JLabel(string);
		GridBagConstraints gbc_temp = new GridBagConstraints();
		gbc_temp.insets = new Insets(0, 0, 5, 5);
		gbc_temp.gridx = pozx;
		gbc_temp.gridy = pozy;
		contentPane.add(temp, gbc_temp);
		return temp;
	}

	void showCard(Card card, int playerNumber){
		playerFocus = playerNumber;
		ImageIcon cardBacktemp = new ImageIcon(getClass().getResource("/userInterface/cards/" + card.toString() + ".png"));
	}
	
	public void addDealerCard(Card card){
		
		JLabel cardDealer = new JLabel();
		ImageIcon cardOfDealer = new ImageIcon(getClass().getResource("/userInterface/cards/" + card.toString() + ".png"));
		cardDealer.setIcon(new ImageIcon(cardOfDealer.getImage().getScaledInstance(100, 150, java.awt.Image.SCALE_SMOOTH)));
		panel_dealer.add(cardDealer);
	}
	
	public void addInvisibleCard(){
		JLabel otherCard = new JLabel();
		ImageIcon backOfCard = new ImageIcon(getClass().getResource("/userInterface/other/Card-Back.png"));
		otherCard.setIcon(new ImageIcon(backOfCard.getImage().getScaledInstance(100, 150, java.awt.Image.SCALE_SMOOTH)));
		panel_dealer.add(otherCard);
	}
	
	public JLabel imageToLabel(String path, int sizex, int sizey)
	{
		ImageIcon cardBack = new ImageIcon(getClass().getResource(path));
		JLabel lblDeckimage = new JLabel(new ImageIcon(cardBack.getImage().getScaledInstance(sizex, sizey, java.awt.Image.SCALE_SMOOTH)));
		return lblDeckimage;
	}
	
	public JPanel newPanel (int pozx, int pozy){
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.gridx = pozx;
		gbc_panel_1.gridy = pozy;
		contentPane.add(panel_1, gbc_panel_1);
		return panel_1;
	}
};