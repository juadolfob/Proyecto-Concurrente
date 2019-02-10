package problem.event;

import java.util.ArrayList;

import control.concurency.Mutex;
import problem.Event;

import matrix.DynamicLenghtMatrix;
import problem.sharedresource.Fork;
import problem.actor.Diner;

public class Dinner implements Event {

	static final String BEINGHUNGRY = "BEINGHUNGRY";
	static final String EATING = "BEINGHUNGRY";
	static final String THINKING = "BEINGHUNGRY";
	Fork fork[] = new Fork[5];
	private Diner philosopher[] = new Diner[5];

	public Dinner(String ControlMethod) {

		fork[0] = new Fork(new Mutex());
		fork[1] = new Fork(new Mutex());
		fork[2] = new Fork(new Mutex());
		fork[3] = new Fork(new Mutex());
		fork[4] = new Fork(new Mutex());

		philosopher[0] = new Diner(0, fork);
		philosopher[1] = new Diner(1, fork);
		philosopher[2] = new Diner(2, fork);
		philosopher[3] = new Diner(3, fork);
		philosopher[4] = new Diner(4, fork);

	}

	public void start() {

		philosopher[0].start();
		philosopher[1].start();
		philosopher[2].start();
		philosopher[3].start();
		philosopher[4].start();
	}

	public DynamicLenghtMatrix getstates() {

		DynamicLenghtMatrix qtthreadst = new DynamicLenghtMatrix(5);

		for (int number = 0; number < 5; number++) {

			if (philosopher[number].state() == Diner.IS_HUNGRY) {
				qtthreadst.add(number, Diner.IS_HUNGRY);
			} else if (philosopher[number].state() == Diner.IS_EATING) {
				qtthreadst.add(number, Diner.IS_EATING);
			} else if (philosopher[number].state() == Diner.IS_THINKING) {
				qtthreadst.add(number, Diner.IS_THINKING);
			}

		}
		return qtthreadst;

	}

}
