package problem.event;

import java.util.ArrayList;

import javax.swing.*;

import control.Control;
import matrix.DynamicLenghtMatrix;
import problem.Event;
import problem.SharedResource;
import problem.actor.Consumer;
import problem.actor.Producer;

public class ProducerConsumer implements Event {
	private SharedResource producto;
	private Control control;
	private Consumer consumer;
	private Producer producer;

	public ProducerConsumer() {
	}

	public void start() {

	}

	public DynamicLenghtMatrix getstates() {
		// TODO Auto-generated method stub
		return null;
	}

}
