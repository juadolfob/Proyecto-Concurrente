package problem;

import java.util.ArrayList;

import matrix.DynamicLenghtMatrix;
import problem.event.*;

public class EventRunner extends Thread {
	Event event;
	Problem problem;
	private volatile boolean running = false;

	EventRunner(Problem problem, String event, String control) {
		this.problem = problem;
		switch (event) {
		case Problem.PRODUCER_CONSUMER:
		case Problem.PHILOSOPHERS_DINNER:
			this.event = new Dinner(control);
		default:

		}
	}

	@Override
	public void run() {
		running = true;
		event.start();
		while (true) {

			while (running) {

				logrevision(event.getstates());

			}

		}
	}

	private void logrevision(DynamicLenghtMatrix Threadstates) {
		if (!problem.isLastColumn(Threadstates)) {
			problem.updateQT(Threadstates);

		}
	}
}
