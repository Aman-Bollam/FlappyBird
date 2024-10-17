import javax.swing.*;
import java.awt.*;
public class Main{
	Bird bird;
	Base base;
	boolean isRunning=true;
	JFrame frame;
	JLayeredPane sky;
	Background background;
	Pipe pipe;
	Main(){
		frame = new JFrame("Flappy Bird");
		frame.setSize(375, 675);
		frame.setIconImage((new ImageIcon("bird1.png")).getImage());
		base = new Base();
		sky = new JLayeredPane();
		background = new Background();
		background.setBounds(0, 0, Background.width, Background.height);
		background.setOpaque(false);
		bird = new Bird();
		bird.setBounds(0, 0, Background.width, Background.height);
		bird.setOpaque(false);
		pipe = new Pipe(bird,base);
		pipe.setBounds(0, 0, Background.width, Background.height);
		pipe.setOpaque(false);
		sky.add(bird, 0);
		sky.add(background, 2);
		sky.add(pipe,1);
		frame.setLayout(new BorderLayout());
		frame.add(sky, BorderLayout.CENTER);
		frame.add(base, BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		Main main = new Main();
	}
	
}
