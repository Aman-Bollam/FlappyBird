import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Background extends JPanel implements ActionListener {
	static int width = 375;
	static int height = 525;
	ImageIcon bg;
	Background() {
		this.setPreferredSize(new Dimension(width, height));
		this.setMaximumSize(this.getPreferredSize());
		this.setMinimumSize(this.getPreferredSize());
		bg = new ImageIcon("background.png");
		Image image = bg.getImage();
		Image newimg = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
		bg = new ImageIcon(newimg);
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(bg.getImage(), 0, 0, null);
	}

	public void actionPerformed(ActionEvent e) {
		repaint();
	}

	public static void main(String args[]) {
		JFrame frame = new JFrame("Base");
		frame.setSize(width, height);
		frame.add(new Background());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
	}
}
