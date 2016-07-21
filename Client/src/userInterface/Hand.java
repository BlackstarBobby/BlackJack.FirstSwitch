package userInterface;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Hand {
	
	JPanel panel;
	JLabel labels[] = new JLabel[20];

	Hand(JPanel panel, int clientNumber)
	{
		this.panel = panel;
		for(int i = labels.length-1;i>-1;i--)
		{
			if(i == labels.length-1)
				labels[i] = new JLabel("Client" + clientNumber);
			else
			{
				labels[i] = new JLabel("");
			}
			labels[i].setBounds(0 + i * 20, 0, 106, 159);
			panel.add(labels[i]);
		}
	}
	
	public int getCountLabels()
	{
		return labels.length;
	}
	public JLabel getLabel(int i)
	{
		return labels[i];
	}
};
