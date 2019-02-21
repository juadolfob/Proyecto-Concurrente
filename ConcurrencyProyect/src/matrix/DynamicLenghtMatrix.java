package matrix;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DynamicLenghtMatrix<E> {

	private ArrayList<E>[] matrix;

	public DynamicLenghtMatrix() {
	}

	public DynamicLenghtMatrix(int MatrixHeight) {
		init(MatrixHeight);
	}
	
	public DynamicLenghtMatrix(int MatrixHeight, E[][] StringArray) { // not finished, also not usefull
		init(StringArray.length);
		for (int t = 0; t < StringArray.length; t++) {
			for (int c = 0; c < StringArray[t].length; c++) {
				this.matrix[t].add((E) StringArray[t][c]);
			}
		}
	}

	public int height() {
		return matrix.length;
	}

	public int lenght(int row) {
		return matrix[row].size();
	}
	public int lenght() {
		int longest=0;
		for(int r=0;r<height();r++) {
			if(longest<matrix[r].size()) { 
				longest=matrix[r].size();
			}
	}
		return longest;
	}

	public void init(int matrix) {
		this.matrix = new ArrayList[matrix];
		for (int t = 0; t < matrix; t++) {
			this.matrix[t] = new ArrayList<E>();
		}
	}

	public void add(ArrayList<E>[] matrix) {
		for (int t = 0; t < this.matrix.length; t++) {
			this.matrix[t].add(matrix[t].get(0));
		}
	}

	public void add(int row, E string) {
		this.matrix[row].add(string);
	}

	public void add(DynamicLenghtMatrix<E> matrix) {// NOT FINISHED

		for (int r = 0; r < matrix.height(); r++) {

			for (int c = 0; c <= matrix.lenght(r) - 1; c++ ){
				this.add(r, (E) matrix.get(r, c));
			}
		}
	}

	public E get(int r, int c) {
		return (E) matrix[r].get(c);
	}

	public ArrayList<E>[] get() {
		return this.matrix;
	}

	public ArrayList<E>[] get(int column) {
		ArrayList<E>[] matrix = new ArrayList[this.matrix.length];
		for (int t = 0; t < this.matrix.length; t++) {
			matrix[t].add(this.matrix[t].get(t));
		}
		return matrix;
	}

	public ArrayList<E>[] getlast() {// NOT READY

		ArrayList<E>[] matrix = new ArrayList[this.matrix.length];

		for (int r = 0; r < this.matrix.length; r++) {
			matrix[r] = new ArrayList();
			matrix[r].add((E)this.get(r, this.lenght(r) - 1));
		}
		return matrix;

	}

	public DynamicLenghtMatrix getlastColumn() {// NOT READY
		DynamicLenghtMatrix matrix = new DynamicLenghtMatrix(this.matrix.length);
		for (int t = 0; t < this.matrix.length; t++) {
			if (this.lenght(t) > 0)
				matrix.add(t, this.matrix[t].get(matrix.lenght(t)));
		}
		return matrix;
	}
 
	public boolean isLastColumn(ArrayList<E>[] matrix) { 
		
		for (int t = 0; t < this.matrix.length; t++) {

			if ((this.matrix[t].size()) < 0) {

				return false;
			} else if (matrix[t].get(0) != this.matrix[t].get(this.matrix[t].size() - 1)) {

				return false;
			}
		}
		return true;
	}


	public boolean isLastColumn(DynamicLenghtMatrix matrix) {
		
		for (int t = 0; t < this.matrix.length; t++) {

			if ((this.matrix[t].size() - 1) < 0) {
				return false;
			} else if (!this.isLastColumn(matrix.getlastColumn().get())) {
				return false;
			}
		}
		return true;
	}

	public void print() {
		for (int t = 0; t < matrix.length; t++) {
			for (int e = 0; e < matrix[t].size(); e++) {
				System.out.print(matrix[t].get(e) + "   ");
			}
			System.out.println();
		}
	}

	private void print(ArrayList<E>[] matrix) {
		for (int t = 0; t < matrix.length; t++) {
			for (int e = 0; e < matrix[t].size(); e++) {
				System.out.print(matrix[t].get(e) + "   ");
			}
			System.out.println();
		}
	}

	public void printlaststates() {
		for (int t = 0; t < matrix.length; t++) {

			if ((matrix[t].size() - 1) >= 0) {

				System.out.println(matrix[t].get(matrix[t].size() - 1));
			} else {
				System.out.println("null");
			}

		}
	}
 
}
