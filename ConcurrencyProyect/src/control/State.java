package control;

import java.lang.reflect.Array;

import matrix.DynamicLenghtMatrix;

public class State{
	public String state;
	public String control;

	public State(String state, String control) {
		this.state = state;
		this.control = control; 
	}
	public void print(){
		System.out.print(state+" "); 
		System.out.print(control+"\n");
	} 
	
}
