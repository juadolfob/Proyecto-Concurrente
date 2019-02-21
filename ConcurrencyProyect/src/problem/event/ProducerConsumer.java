package problem.event;

import control.Control;
import control.QTState;
import control.State;
import control.concurency.Mutex;
import matrix.DynamicLenghtMatrix;
import problem.Actor;
import problem.Event;
import problem.SharedResource;
import problem.actor.Consumer;
import problem.actor.Diner;
import problem.actor.Producer;
import problem.sharedresource.Fork;
import problem.sharedresource.Product;

public class ProducerConsumer implements Event {
	private SharedResource producto;
	private Control control;
	private Consumer consumer;
	private Producer producer;
	private int quantum;
	public ProducerConsumer() {
		
	}

	public ProducerConsumer(String ControlMethod,int quantum) { 
		this.quantum=quantum;
		producto = new Product(new Mutex());
		this.consumer=new Consumer(producto, quantum);
		this.producer=new Producer(producto, quantum);		

	}

	@Override
	public void start() {
		consumer.start();
		producer.start(); 
	}

	@Override
	public QTState getstates() {

		QTState qstate = new QTState(2);
		 	
			qstate.add(0, new State(consumer.state,consumer.controlcase));
			qstate.add(1, new State(producer.state,producer.controlcase));
			
		return qstate;

	}
}
