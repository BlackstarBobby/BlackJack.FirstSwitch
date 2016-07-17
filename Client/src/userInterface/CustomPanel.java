package userInterface;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JPanel;

public class CustomPanel {
	
	JPanel panel;
	GridBagConstraints gbc;

	CustomPanel(int pozx, int pozy)
	{
		panel = new JPanel();
		panel.setLayout(null);
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = pozx;
		gbc.gridy = pozy;
	}
	
	public JPanel getPane(){
		return panel;
	}
	public GridBagConstraints getGBC(){
		return gbc;
	}
	
}
