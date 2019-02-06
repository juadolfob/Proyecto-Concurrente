package practica3_cenafilosofos;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.lang.Thread;
import java.util.Random;

public class graphics extends JPanel {

	static final Color BEINGHUNGRY = Color.red;
	static final Color EATING = Color.green;
	static final Color THINKING = Color.blue;

	philosopher[] philosophers;
	fork[] fork;

	public Font font =new Font("Arial", Font.PLAIN, 40); 
	
	public graphics(philosopher[] philosopher, fork[] fork) {
		this.philosophers = philosopher;
		this.fork = fork; 
		setBackground(new Color(255,255,255,255));  
		components();
		Thread thread = new Thread() {
			public void run() {
				while(true) {  
					revalidate(); 
					repaint();
				}
			}
		};
		thread.start();
	} 
	
	JLabel Hunger;
	JLabel Eating;
	JLabel Thinking;
	JLabel philosopher1;
	JLabel philosopher2;
	JLabel philosopher3;
	JLabel philosopher4;
	JLabel philosopher5;

	public void components() {

		Hunger = new JLabel();
		Eating = new JLabel();
		Thinking = new JLabel();
		philosopher1 = new JLabel();
		philosopher2 = new JLabel();
		philosopher3 = new JLabel();
		philosopher4 = new JLabel();
		philosopher5 = new JLabel();

		Hunger.setFont(font);
		Eating.setFont(font);
		Thinking.setFont(font);
		philosopher1.setFont(font);
		philosopher2.setFont(font);
		philosopher3.setFont(font);
		philosopher4.setFont(font);
		philosopher5.setFont(font);

		Hunger.setText("Hunger");
		Eating.setText("Eating");
		Thinking.setText("Thinking");
		philosopher1.setText("philosopher1");
		philosopher2.setText("philosopher2");
		philosopher3.setText("philosopher3");
		philosopher4.setText("philosopher4");
		philosopher5.setText("philosopher5");

		Hunger.setBounds(10, 1800 - 220, 300, 100);
		Eating.setBounds(10, 1800 , 300, 100);
		Thinking.setBounds(10, 1800 -110, 300, 100);

		philosopher1.setBounds((int)(840 + (Math.cos(0) * 600)),(int)(1030 + (Math.sin(0) * 600)), 300, 100);
		philosopher2.setBounds((int)(840 + (Math.cos((2 * Math.PI) / 5)) * 600),(int)(930 + (Math.sin((2 * Math.PI) / 5)) * 600), 300, 100);
		philosopher3.setBounds((int)(840 + (Math.cos((4 * Math.PI) / 5)) * 600),(int)(700 + (Math.sin((4 * Math.PI) / 5)) * 600), 300, 100);
		philosopher4.setBounds((int)(840 + (Math.cos((6 * Math.PI) / 5)) * 600),(int)(800 + (Math.sin((6 * Math.PI) / 5)) * 600), 300, 100);
		philosopher5.setBounds((int)(840 + (Math.cos((8 * Math.PI) / 5)) * 600),(int)(840 + (Math.sin((8 * Math.PI) / 5)) * 600), 300, 100);
		
		Hunger.setForeground(Color.black);
		Eating.setForeground(Color.black);
		Eating.setForeground(Color.black); 
		
		add(Hunger);
		add(Eating);
		add(Thinking);
		add(philosopher1);
		add(philosopher2);
		add(philosopher3);
		add(philosopher4);
		add(philosopher5);

	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.red);

		g2.setColor(new Color(213, 152, 91)/* brown */);
		g2.fill(new Ellipse2D.Double(1000 - 400, 1000 - 400, 700, 700));

		g2.setColor(Color.red);
		g2.fill(new Rectangle2D.Double(10, 1800 - 220, 150, 100));
		g2.setColor(Color.blue);
		g2.fill(new Rectangle2D.Double(10, 1800 - 110, 150, 100));
		g2.setColor(Color.green);
		g2.fill(new Rectangle2D.Double(10, 1800, 150, 100));

		int number = 0;
		
		g2.setColor(new Color(223, 172,120)/*spaguetti */);

		g2.fill(new Ellipse2D.Double(1280 - 400, 1280 - 400, 140, 140));
		
		for (double n = 0; n < 2 * Math.PI; n += (2 * Math.PI) / 5) {

			if (philosophers[number].state() == philosopher.IS_HUNGRY) {
				g2.setColor(BEINGHUNGRY);
			} else if (philosophers[number].state() == philosopher.IS_EATING) {
				g2.setColor(EATING);
			} else if (philosophers[number].state() == philosopher.IS_THINKING) {
				g2.setColor(THINKING);
			}
			
			g2.fill(new Ellipse2D.Double(840 + (Math.cos(n) * 500), 840 + (Math.sin(n) * 500), 200, 200));
			g2.setColor(new Color(237, 200, 158)/* philosopher_skin */);
			g2.fill(new Ellipse2D.Double(875 + (Math.cos(n) * 500), 875 + (Math.sin(n) * 500), 130, 130));
			

			g2.setColor(new Color(163, 159, 146)/* forks and plates */);
			g2.fill(new Ellipse2D.Double(875 + (Math.cos(n) * 260), 875 + (Math.sin(n) * 260), 130, 130));

			if(fork[number].isavaliable()) {
				g2.fill(new Rectangle2D.Double(900 + (Math.cos(n+(Math.PI / 5)) * 300), 890 + (Math.sin(n+(Math.PI / 5)) * 300), 40, 100));
			}
			if (philosophers[number].hasleftfork()) {

				g2.fill(new Rectangle2D.Double(900 + (Math.cos(n) * 500), 890 + (Math.sin(n) * 500), 40, 100));
			}
			if (philosophers[number].hasrightfork()) {
				g2.fill(new Rectangle2D.Double(954 + (Math.cos(n) * 500), 890 + (Math.sin(n) * 500), 40, 100));
			}
			number++;
 
		}
		add(Hunger);
		add(Eating);
		add(Thinking);
		add(philosopher1);
		add(philosopher2);
		add(philosopher3);
		add(philosopher4);
		add(philosopher5);
	}
}
