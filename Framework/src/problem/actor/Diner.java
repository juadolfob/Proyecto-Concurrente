package problem.actor;

import java.util.ArrayList;

import problem.Actor;
import problem.sharedresource.Fork;

public class Diner extends Thread implements Actor {

	public static final String IS_HUNGRY = "IS_HUNGRY  ";
	public static final String IS_EATING = "IS_EATING  ";
	public static final String IS_THINKING = "IS_THINKING";
	public boolean hasleftfork = false;
	public boolean hasrightfork = false;
	@SuppressWarnings("unchecked")
	ArrayList<String>[] threadst = new ArrayList[5];
	private Fork fork[];
	private int chair;

	private String state = IS_HUNGRY;

	public Diner(int chair, Fork[] fork) {
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

	@Override
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

		fork[chair].use();
	}

	public void takeleftfork() {
		if (chair == 0) {
			fork[4].use();
		} else {
			fork[chair - 1].use();
		}
	}

	public void relaserightfork() {

		fork[chair].relase();
	}

	public void relaseleftfork() {
		if (chair == 0) {
			fork[4].relase();
		} else {
			fork[chair - 1].relase();
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
	}

}
