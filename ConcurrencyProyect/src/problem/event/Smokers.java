package problem.event;

import control.QTState;
import control.State;
import control.concurency.Mutex;
import problem.Event;
import problem.actor.Arbiter;
import problem.actor.Barber;
import problem.actor.BarberCustomer;
import problem.actor.Diner;
import problem.actor.Smoker;
import problem.sharedresource.Fork;

public class Smokers implements Event {

	Arbiter arbiter;

	private int quantum=100;

	Smoker smoker0,smoker1,smoker2;
	
	public Smokers(String ControlMethod,int quantum) { 
		this.quantum=quantum;
		

	}

	@Override
	public void start() {

		smoker0=new Smoker(quantum);
		smoker1=new Smoker(quantum);
		smoker2=new Smoker(quantum);

		arbiter=new Arbiter(smoker0,smoker1,smoker2);
		smoker0.start();
		smoker1.start();
		smoker2.start();
		arbiter.start();
	}


	@Override
	public QTState getstates() {

		QTState qstate = new QTState(4);
		 
		qstate.add(0, new State(smoker0.state,smoker0.controlcase)); 
		qstate.add(1, new State(smoker1.state,smoker0.controlcase)); 
		qstate.add(2, new State(smoker2.state,smoker0.controlcase));  
		qstate.add(3, new State(arbiter.state,smoker0.controlcase));
								
		return qstate;

	}
 

}
