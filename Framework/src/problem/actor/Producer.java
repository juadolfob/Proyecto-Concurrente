package problem.actor;

import javax.swing.*;

import control.Control;
import problem.SharedResource;

import java.awt.*;

public class Producer extends Thread implements Actor {
	private SharedResource product;

	private volatile boolean running = true;

	public Producer(SharedResource product) {
		this.product = product;
	}

	public void run() {
		running = true;
		while (true) {
			
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

}
