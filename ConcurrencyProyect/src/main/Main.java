package main;

import control.Control;
import control.QTMatrix;
import problem.Problem;

public class Main {

	public static void main(String[] args) {
		Problem problem = new Problem(Problem.SMOKERS, Control.MUTEX,10,100); 
		problem.start();
	}

}
