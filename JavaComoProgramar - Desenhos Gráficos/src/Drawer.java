import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Drawer extends JPanel {
	
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		
		int width = getWidth();
		int height = getHeight();
		 g.drawLine(0, 0, width, height);
		 g.drawLine(0, height, width, 0);
	}

}
