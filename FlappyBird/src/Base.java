import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Base extends JPanel implements ActionListener {
	static int width = 375;
	static int height = 113;
	ImageIcon base;
	Timer timer;
	int x, y = 0;
	boolean isRunning = true;
	Base() {
		this.setPreferredSize(new Dimension(width, height));
		this.setMaximumSize(this.getPreferredSize());
		this.setMinimumSize(this.getPreferredSize());
		base = new ImageIcon("base.png");
		Image image = base.getImage();
		Image newimg = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		base = new ImageIcon(newimg);
		timer = new Timer(10, this);
		timer.start();
	}
	public void paint(Graphics g) {
		super.paint(g);
		Graphics g2d = (Graphics2D) g;
		g2d.drawImage(base.getImage(), x, y, null);
		g2d.drawImage(base.getImage(), x - width, y, null);
	}
	public void actionPerformed(ActionEvent e) {
		x += 1;
		if (x > width) {
			x = 0;
		}
		repaint();
	}
	public static void main(String args[]) {
		JFrame frame = new JFrame("Base");
		frame.setSize(width, height);
		Base base = new Base();
		//base.setIsRunning(false);
		frame.add(base);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
	}
}
