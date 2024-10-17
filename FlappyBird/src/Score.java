import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 
public class Score extends JPanel implements ActionListener {
	int score;
	private JLabel label;
	Score(){
		Dimension size = new Dimension(50,50);
		this.setLayout(new FlowLayout());
		this.setSize(size);
		this.setMaximumSize(size);
		this.setMinimumSize(size);
		this.setOpaque(false);
		label = new JLabel();
		score=0;
		label.setText(Integer.toString(score));
		label.setFont(new Font("Impact", Font.BOLD, 40));
		label.setForeground(Color.white);
		this.add(label);
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString(Integer.toString(score),375/2 , 0);
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
	}
	public static void main(String args[]) {
		JFrame frame = new JFrame("Base");
		frame.setSize(375, 525);
		Score score = new Score();
		// pipe.setIsRunning(false);
		frame.add(score);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
	}

}
