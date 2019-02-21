package problem.actor;

import control.Control;
import control.concurency.Mutex;
import problem.Actor;
import problem.SharedResource;

public class Consumer extends Thread implements Actor {
	private SharedResource product;
	public String state="0";
	public String controlcase="0";
	private volatile boolean running = true;
	public int quantum=100; 
	
	public Consumer(SharedResource product,int quantum) { 
		this.quantum=quantum;
		this.product = product;
	}
 
	@Override
	public void run() {

		running = true;

		
		while (true) {
			 
			sleep();  
			controlcase="1";   
			product.use(); 
			state="1";   
			sleep();  
			controlcase="0";
			product.relase();  
			state="0";  

			while (!running) {
			}

		}

	}

	public void resumep() {
		this.running = true;
	}

	public void pause() {
		this.running = false;
	}
 

}
