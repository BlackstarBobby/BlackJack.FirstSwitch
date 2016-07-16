package userInterface;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class BackgroundPanel extends JPanel{
	Image image;
	public BackgroundPanel(int tablePanelwidth, int tablePanelheight)
    {
        try
        {
        	ImageIcon dealerTable = new ImageIcon(getClass().getResource("/userInterface/other/dealer-table.jpg"));
		    image = dealerTable.getImage().getScaledInstance(tablePanelwidth, tablePanelheight, java.awt.Image.SCALE_DEFAULT);            }
        catch (Exception e) { /*handled in paintComponent()*/ }
    }
	@Override
	  protected void paintComponent(Graphics g) {
		
		super.paintComponent(g); 
        if (image != null)
            g.drawImage(image, 0,0,this.getWidth(),this.getHeight(),this);
	    
	}
}