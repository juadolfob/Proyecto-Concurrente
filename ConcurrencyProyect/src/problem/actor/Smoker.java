package problem.actor;

import problem.Actor;
import problem.SharedResource;

public class Smoker extends Thread implements Actor {
	
 
	public static final String IS_WAITING = "0";
	public static final String IS_SMOKING = "1";
	
	private SharedResource ingredient;
	public String state="0";
	public String controlcase="0";
	private volatile boolean running = true;
	public int quantum=100;
	
	public Smoker(int quantum) {
		this.quantum=quantum;
		this.ingredient=ingredient;
	}
 
	@Override
	public void run() {

		running = true;
		 
		while (true) {
			while (!running) {
			}

		}

	}
	
	public boolean getR(){
		while(state==IS_WAITING) {
			
		}
		return true;
	}
	
	public void smoke() {
		state=IS_SMOKING;
		sleep();
		state=IS_WAITING;
	}
	public void resumep() {
		this.running = true;
	}

	public void pause() {
		this.running = false;
	}
	
	 

}
