import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Bird extends JPanel implements ActionListener, MouseListener {
	static int width = 35;
	static int height = 25;
	static int currentImage = 0;
	int y = 0;
	int v0 = 0;
	double a = 1.7;
	boolean isRunning = true;
	private static final ImageIcon[] images = { new ImageIcon("bird1.png"), new ImageIcon("bird2.png"), new ImageIcon("bird3.png") };
	Timer timer;
	ImageIcon birdy;
	private Rectangle birdRectangle ;
	Bird() {
		birdRectangle  = new Rectangle(40,(int)y,width,height);
		this.setPreferredSize(new Dimension(width, height));
		this.setMaximumSize(this.getPreferredSize());
		this.setMinimumSize(this.getPreferredSize());
		for (int i = 0; i < images.length; i++) {
			Image image = images[i].getImage();
			Image newimg = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
			images[i] = new ImageIcon(newimg);
		}
		birdy = images[0];
		timer = new Timer(40, this);
		timer.start();
		addMouseListener(this);
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(birdy.getImage(), 40, (int) y, this);
		//g.drawRect(40, y, width, height);
	}
	public void actionPerformed(ActionEvent e) {
		currentImage = (currentImage + 1) % images.length;
		birdy = images[currentImage];
		y += v0;
		v0 += a;
		birdRectangle = new Rectangle(40,y,width,height);
		if (y + birdy.getIconHeight() >= this.getHeight()) {
			y = this.getHeight() - birdy.getIconHeight();
			isRunning = false;
			timer.stop();
		}
		if (y < 0) {
			isRunning = false;
			timer.stop();
		}
		repaint();
	}
	public Rectangle getRectangle() {
		return birdRectangle;
	}
	public void setIsRunning(boolean isRunning) {
		this.isRunning=isRunning;
	}
	public void mouseClicked(MouseEvent e) {
		v0 = -13;
	}
	public void mousePressed(MouseEvent e) {

	}
	public void mouseReleased(MouseEvent e) {

	}
	public void mouseEntered(MouseEvent e) {

	}
	public void mouseExited(MouseEvent e) {

	}
	public static void main(String args[]) {
		JFrame frame = new JFrame("Base");
		frame.setSize(375, 525);
		frame.add(new Bird());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
	}
}
