package problem;

import control.QTMatrix;
import control.QTState; 

public interface Event {
	public int quantum=100;
	public QTMatrix qtmatrix = null; 
	public void start(); 
	public QTState getstates(); 
}
