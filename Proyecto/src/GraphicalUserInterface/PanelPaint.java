package interfaze;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JPanel;

public class PanelPaint extends JPanel {

	
	
	public void paintComponent(Graphics g) {
		
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		for(int i = 0; i < 10; i ++) {
			Rectangle r = new Rectangle();
			g.setColor(Color.BLACK);
			r.setBounds(25 + 45 * i, 40, 40, 40);
			g.fillRect((int)r.getX(), (int)r.getY(), (int)r.getWidth() , (int)r.getHeight());
			g.setColor(Color.white);
			g.setFont( new Font( "Tahoma", Font.BOLD, 15) );
			g.drawString(i + "", (int)((r.getX() + r.getWidth() / 2) - 6), (int)((r.getY() + r.getHeight() / 2) + 6));
		}
		
	}
	
	
	
	
	
	
}
