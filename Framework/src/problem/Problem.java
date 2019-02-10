package problem;

import java.util.ArrayList;

import matrix.DynamicLenghtMatrix;

public class Problem extends DynamicLenghtMatrix {

	public final static String PRODUCER_CONSUMER = "PRODUCER_CONSUMER";
	public final static String PHILOSOPHERS_DINNER = "PHILOSOPHERS_DINNER";

	EventRunner event;

	public Problem(String problem, String control) {
		switch (problem) {
		case PRODUCER_CONSUMER:
			init(2);
			event = new EventRunner(this, PRODUCER_CONSUMER, control);
		case PHILOSOPHERS_DINNER:
			init(5);
			event = new EventRunner(this, PHILOSOPHERS_DINNER, control);
		default:

		}
	}

	void updateQT(DynamicLenghtMatrix Threadstates) {
		System.out.println("updateQT");
		add(Threadstates);
		print();
		System.out.println();
	}

	public void start() {
		event.start();
	}

	@SuppressWarnings("deprecation")
	public void stop() {
		event.stop();
	}

}
