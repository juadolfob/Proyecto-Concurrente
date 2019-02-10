package main;

import problem.*;
import control.*;

public class Main {

	public static void main(String[] args) {

		Problem problem = new Problem(Problem.PRODUCER_CONSUMER, Control.MUTEX);
		problem.start();
	}

}
