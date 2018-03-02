import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public class Ball extends JComponent
{
	private Ellipse2D.Double circle;
	private Rectangle collision;
	
	public Ball(int x, int y)
	{
		setLocation(x,y);
		setSize(10, 10);
		collision = new Rectangle(x, y, 10, 10);
	}
	
	public void update()
	{
		setLocation(getX() + 5, getY());
		collision.setLocation(getX(), getY());
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.RED);
		circle = new Ellipse2D.Double(0, 0, 8, 8);
		g2.fill(circle);
	}
	
	public Rectangle getCollision()
	{
		return collision;
	}
}
