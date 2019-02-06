package practica3_cenafilosofos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class window extends JFrame {

	graphics graphics;
	philosopher[] philosopher;
	fork[] fork;
	public Font font = new Font("Arial", Font.PLAIN, 40);

	public window(philosopher[] philosopher, fork[] fork) {
		this.fork = fork;
		this.philosopher = philosopher;
		setSize(2000, 2000);
		setTitle("Cena Filosofos");
		graphics = new graphics(philosopher, fork);
		setLayout(null);

		graphics.setLayout(null);
		this.getContentPane().add(graphics);
		graphics.setBounds(0, 0, 2000, 2000);
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

		Hunger.setBounds(10, 1800, 300, 100);
		Eating.setBounds(10, 1800 - 110, 300, 100);
		Thinking.setBounds(10, 1800 - 220, 300, 100);
		philosopher1.setBounds(10, 1800, 100, 100);
		philosopher2.setBounds(10, 1800, 300, 100);
		philosopher3.setBounds(10, 1800, 300, 100);
		philosopher4.setBounds(10, 1800, 300, 100);
		philosopher5.setBounds(10, 1800, 300, 100);

		this.getContentPane().add(Hunger);
		this.getContentPane().add(Eating);
		this.getContentPane().add(Thinking);
		this.getContentPane().add(philosopher1);
		this.getContentPane().add(philosopher2);
		this.getContentPane().add(philosopher3);
		this.getContentPane().add(philosopher4);
		this.getContentPane().add(philosopher5);

	}

}
