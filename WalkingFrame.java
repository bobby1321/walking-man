import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class WalkingFrame extends JFrame implements ActionListener
{
	private Man man;
	private static JButton testBtn;
	Rectangle m, b;
	private ArrayList<Ball> balls = new ArrayList<Ball>();
	
	public WalkingFrame()
	{
		setBounds(0,0,1920,1080);
		setLayout(null);
		testBtn = new JButton("Test");
		testBtn.setFocusable(false);
		testBtn.setBounds(960, 540, 100, 100);
		testBtn.setVisible(true);
		man = new Man(0,0);
		add(man);
		m = new Rectangle(man.getX(), man.getY(), man.getWidth(), man.getHeight());
		b = new Rectangle(testBtn.getX(), testBtn.getY(), testBtn.getWidth(), testBtn.getHeight());
		Timer timer = new Timer(10, this);
		timer.start();
		addMouseMotionListener(new MouseMotionListener()
				{

					@Override
					public void mouseDragged(MouseEvent e)
					{
						man.setLocation(e.getX()-15, e.getY()-50);
					}

					@Override
					public void mouseMoved(MouseEvent e){}
					
				});
		addKeyListener(new KeyListener()
			{
				@SuppressWarnings("static-access")
				@Override
				public void keyPressed(KeyEvent e)
				{
					if(e.getKeyCode() == (e.VK_W)) 
					{
						man.setDY(-2);
					}
					if(e.getKeyCode() == (e.VK_S))
					{
						man.setDY(2);
					}
					if(e.getKeyCode() == (e.VK_A)) 
					{
						man.setDX(-2);
					}
					if(e.getKeyCode() == (e.VK_D)) 
					{
						man.setDX(2);
					}
					if(e.getKeyCode() == (e.VK_J)) 
						{
							man.setSize2(man.getWidth() + 10, man.getHeight() + 10);
							repaint();
						}
					if(e.getKeyCode() == (e.VK_K)) 
						{
							man.setSize2(man.getWidth() - 10, man.getHeight() - 10);
							repaint();
						}
					if(e.getKeyCode() == (e.VK_SPACE))
					{
						Ball tempBall = new Ball(man.getX(), man.getY());
						balls.add(tempBall);
						add(tempBall);
						System.out.println("1");
					}
				}

				@SuppressWarnings("static-access")
				@Override
				public void keyReleased(KeyEvent e)
				{
					if(e.getKeyCode() == (e.VK_W)) man.setDY(0);
					if(e.getKeyCode() == (e.VK_S)) man.setDY(0);
					if(e.getKeyCode() == (e.VK_A)) man.setDX(0);
					if(e.getKeyCode() == (e.VK_D)) man.setDX(0);
				}

				@Override
				public void keyTyped(KeyEvent e){}
			
			});
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args)
	{
		new WalkingFrame().add(testBtn);
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		m.setLocation(man.getX(), man.getY());
		if(m.intersects(b))
		{
			testBtn.setText("Hit");
		}
		else testBtn.setText("Not");
		man.update();
		for(int i = 0; i < balls.size(); i++)
		{
			balls.get(i).update();
			if(balls.get(i).getCollision().intersects(b))
			{
				remove(balls.get(i));
				balls.remove(i);
				i--;
				//testBtn.setBackground(testBtn.getBackground());
			}
			if(balls.get(i).getX() >= getWidth())
			{
				remove(balls.get(i));
				balls.remove(i);
				i--;
				System.out.println("2");
			}
		}
		repaint();	
	}
}
