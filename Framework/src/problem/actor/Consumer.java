package problem.actor;

import javax.swing.*;

import control.Control;
import problem.Actor;
import problem.SharedResource;

import java.awt.*;

public class Consumer extends Thread implements Actor {
	private SharedResource producto;

	private volatile boolean running = true;

	public Consumer(SharedResource producto, Control m) {
		this.producto = producto;
	}

	public void run() {

		running = true;
		while (true) {
			control.lock();

			// area.append("consumidor "+rc.getRc()+"\n");

			control.unlock();
			try {
				Thread.sleep(400 + (int) (Math.random() * 100));
			} catch (InterruptedException e) {
			}
			;

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

	public void sleep(int qt) {
	}

}
