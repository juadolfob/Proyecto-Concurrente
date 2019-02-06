package practica3_cenafilosofos;

import javax.swing.*;
import java.awt.*;

public class philosopher extends Thread {

	public static final String IS_HUNGRY = "H";
	public static final String IS_EATING = "E";
	public static final String IS_THINKING = "T";

	public boolean hasleftfork = false;
	public boolean hasrightfork = false;

	private fork fork[];
	private int chair;

	private String state = IS_HUNGRY;

	public philosopher(int chair, fork[] fork) {
		this.fork = fork;
		this.chair = chair;
	}

	public boolean is(String state) {
		if (this.state == state) {
			return true;
		} else {
			return false;
		}
	}

	public String state() {
		return this.state;
	}

	public void run() {
		sleep(2000);
		while (true) {
			
			takerightfork(); 
			hasrightfork = true; 
			takeleftfork(); 
			hasleftfork = true;  
			state = IS_EATING;
			sleep(2000); 
			state = IS_THINKING; 
			hasleftfork = false; 
			relaseleftfork(); 
			hasrightfork = false; 
			relaserightfork(); 
			sleep(2000); 
			state = IS_HUNGRY;

		}
	}

	public void takerightfork() {

		fork[chair].takefork();
	}

	public void takeleftfork() {
		if (chair == 0) {
			fork[4].takefork(); 
		} else {
			fork[chair - 1].takefork(); 
		}
	}

	public void relaserightfork() {

		fork[chair].relasefork();
	}

	public void relaseleftfork() {
		if (chair == 0) {
			fork[4].relasefork(); 
		} else {
			fork[chair - 1].relasefork(); 
		}
	}

	public boolean hasrightfork() {
		return hasrightfork;
	}

	public boolean hasleftfork() {
		return hasleftfork;
	}

	public void sleep(int qt) {
		try {
			Thread.sleep(qt + (int) (Math.random() * 100));
		} catch (InterruptedException e) {
		}
		;
	}
	public void printforks() {
		for(int i=0;i<4;i++) {
			System.out.print(i + " "+fork[i].isavaliable());
		}
		System.out.println();
	}
}
