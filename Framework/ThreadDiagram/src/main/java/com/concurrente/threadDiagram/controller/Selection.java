package com.concurrente.threadDiagram.controller;

import java.util.ArrayList;

import control.Control;
import control.State;
import problem.Problem;

public class Selection {
	private String problema;
	private String algoritmo;
	
	public String getProblema() {
		return problema;
	}
	public void setProblema(String problema) {
		this.problema = problema;
	}
	public String getAlgoritmo() {
		return algoritmo;
	}
	public void setAlgoritmo(String algoritmo) {
		this.algoritmo = algoritmo;
	}
	public Problem buildSelection(String problema, String algoritmo) {
		Problem selectedProblem = null;
		switch(problema) {
		case "PHILOSOPHERS_DINNER": 
			switch(algoritmo) {
			case "MUTEX": selectedProblem = new Problem(Problem.PHILOSOPHERS_DINNER, Control.MUTEX, 100, 100);
			}
		break;
		
		case "PRODUCER_CONSUMER": 
			switch(algoritmo) {
			case "MUTEX": selectedProblem = new Problem(Problem.PRODUCER_CONSUMER, Control.MUTEX, 100, 100);
			}
		break;
		}
		return selectedProblem;
	}
	public ArrayList<State>[] runSelected() {
		Problem selectedProblem;
		selectedProblem = buildSelection(problema, algoritmo);
		//Problem selectedProblem = new Problem(Problem.PHILOSOPHERS_DINNER, Control.MUTEX, 10, 100);
		ArrayList<State>[] matrix = null;
		selectedProblem.start();
		while(true) {
			if(selectedProblem.event.qtmatrix.isLastQT(selectedProblem.event.event.getstates())) {
				matrix = selectedProblem.event.qtmatrix.get();
				break;
			}
		}
		
		return matrix;
	}
}
