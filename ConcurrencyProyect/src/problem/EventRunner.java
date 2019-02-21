package problem;

import control.QTMatrix;
import control.QTState;
import matrix.DynamicLenghtMatrix;
import problem.event.*;

public class EventRunner extends Thread {
	public Event event; 
	public QTMatrix qtmatrix;
	int qtmlenght;
	private volatile boolean running = false;

	EventRunner(QTMatrix qtmatrix, String event, String control,int qtmlenght, int quatum) { 
		this.qtmatrix=qtmatrix;
		this.qtmlenght=qtmlenght;
		switch (event) {
		case Problem.PRODUCER_CONSUMER:
			this.event = new ProducerConsumer(control,quatum);
			break;
		case Problem.PHILOSOPHERS_DINNER:
			this.event = new Dinner(control,quatum);
			break;
		case Problem.READERS_WRITERS:
			this.event = new ReadersWriters(control,quatum);
			break;
		case Problem.SLEEPING_BARBER:
			this.event = new SleepingBarber(control,quatum);
			break;
		case Problem.SMOKERS:
			this.event = new Smokers(control,quatum);
			break;
		default:

		}
	}

	@Override
	public void run() {
		running = true;
		event.start();
		while (true) {
			while (running && qtmatrix.lenght() < qtmlenght) {

				logrevision(event.getstates());
			}

		}
	}

	private void logrevision(QTState Threadstates) {
		if (!qtmatrix.isLastQT(Threadstates)) {

			qtmatrix.print();
			qtmatrix.updateQTMatrix(Threadstates); 
		}
	}
}
