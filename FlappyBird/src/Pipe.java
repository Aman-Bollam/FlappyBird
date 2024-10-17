import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class Pipe extends JPanel implements ActionListener {
	static int width = 375;
	static int height = 525;
	static int pipewidth = 500;
	static int pipeHeight = 500;
	ImageIcon up;
	ImageIcon down;
	Timer timer;
	int x = 361;
	int pipe1Y, pipe2Y;
	Random rand = new Random();
	ArrayList<PipeData> pipes = new ArrayList<>();
	ArrayList<Rectangle> uppipeRectangles;
	ArrayList<Rectangle> downpipeRectangles;
	Bird bird;
	Base base;
	boolean isRunning = true;
	int score;

	class PipeData {
		int x, y;
		ImageIcon up, down;

		public PipeData(int x, int y, ImageIcon up, ImageIcon down) {
			this.x = x;
			this.y = y;
			this.up = up;
			this.down = down;
		}
	}

	Pipe(Bird bird, Base base) {
		this.bird=bird;
		this.setPreferredSize(new Dimension(width, height));
		this.setMaximumSize(this.getPreferredSize());
		this.setMinimumSize(this.getPreferredSize());

		up = new ImageIcon("uppipe.png");
		Image image = up.getImage();
		Image newimg = image.getScaledInstance(pipewidth, pipeHeight, Image.SCALE_SMOOTH);
		up = new ImageIcon(newimg);

		down = new ImageIcon("downpipe.png");
		Image image2 = down.getImage();
		Image newimg2 = image2.getScaledInstance(pipewidth, pipeHeight, Image.SCALE_SMOOTH);
		down = new ImageIcon(newimg2);
		uppipeRectangles = new ArrayList<Rectangle>();
		downpipeRectangles = new ArrayList<Rectangle>();
		pipe1Y = (height - 75) - (int) (Math.random() * 250);
		pipe2Y = pipe1Y - pipeHeight;
		pipes.add(new PipeData(x, pipe1Y, up, down));
		uppipeRectangles.add(new Rectangle(width,pipe1Y-2,68,pipeHeight));
		downpipeRectangles.add(new Rectangle(width, pipe1Y-pipeHeight-147, 68, pipeHeight));
		timer = new Timer(10, this);
		this.base=base;
		timer.start();
	}

	public void paint(Graphics g) {
		super.paint(g);
		for (PipeData pipe : pipes) {
			g.drawImage(pipe.up.getImage(), pipe.x, pipe.y, this);
			g.drawRect(pipe.x, pipe.y-1, 67, pipeHeight);
			g.drawImage(pipe.down.getImage(), pipe.x, pipe.y - pipeHeight, this);
			g.drawRect(pipe.x, pipe.y-pipeHeight-147, 67, pipeHeight);
			g.drawRect(40, bird.y, 35,25);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (isRunning) {
			for(Rectangle rect: uppipeRectangles) {
				if(bird.getRectangle().intersects(rect)) {
					bird.timer.stop();
					base.timer.stop();
					isRunning=false;
				}
			}
			for(Rectangle rect: downpipeRectangles) {
				if(bird.getRectangle().intersects(rect)) {
					bird.timer.stop();
					base.timer.stop();
					isRunning=false;
				}
			}
			if (pipes.get(pipes.size() - 1).x <= width / 2) {
				int y=(height - 75) - rand.nextInt(250);
				pipes.add(new PipeData(width, y, up, down));
				//uppipeRectangles.add(new Rectangle(width,y-5,69,pipeHeight));
				//downpipeRectangles.add(new Rectangle(width, y-pipeHeight-147, 69, pipeHeight));
				uppipeRectangles.add(new Rectangle(width,y-2,67,pipeHeight));
				downpipeRectangles.add(new Rectangle(width, y-pipeHeight-147, 67, pipeHeight));
			}
			for (PipeData pipe : pipes) {
				pipe.x -= 2;
			}
			for(Rectangle rect: uppipeRectangles) {
				rect.setLocation(rect.getLocation().x-2, rect.getLocation().y);
			}
			for(Rectangle rect: downpipeRectangles) {
				rect.setLocation(rect.getLocation().x-2, rect.getLocation().y);
			}
			repaint();
		}
	}

	public static void main(String args[]) {
		JFrame frame = new JFrame("Base");
		frame.setSize(375, 525);
		Pipe pipe = new Pipe(new Bird(), new Base());
		// pipe.setIsRunning(false);
		frame.add(pipe);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
	}
}
