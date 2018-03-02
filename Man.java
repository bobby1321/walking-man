import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public class Man extends JComponent
{
	private int dx =0, dy=0;
	private Rectangle body, leftArm, rightArm, leftLeg, rightLeg;
	private Ellipse2D.Double head;
	
	public Man(int x, int y)
	{
		setLocation(x,y);
		setSize(20,40);
	}
	public Man(int x, int y, int width, int height)
	{
		setLocation(x,y);
		setSize(width, height);
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		head = new Ellipse2D.Double(4, 0,10,10);
		g2.fill(head);
		body = new Rectangle(8,10,3,20);
		g2.fill(body);
		leftArm = new Rectangle(0,13,8,3);
		g2.fill(leftArm);
		rightArm = new Rectangle(10,13,8,3);
		g2.fill(rightArm);
		leftLeg = new Rectangle(5,25,3,15);
		g2.fill(leftLeg);
		rightLeg = new Rectangle(11,25,3,15);
		g2.fill(rightLeg);
	}
	public void setDX(int x)
	{
		dx = x;
	}
	public void setDY(int y)
	{
		dy = y;
	}
	public void update()
	{
		setLocation(getX() + dx, getY() + dy);
	}
	public void setSize2(int width, int height)
	{
		this.setSize(width, height);
	}
	public int getWidth()
	{
		return (int) this.getSize().getWidth();
	}
	public int getHeight()
	{
		return (int) this.getSize().getHeight();
	}
}


