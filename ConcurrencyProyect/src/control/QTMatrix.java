package control;

import java.util.ArrayList;

import matrix.DynamicLenghtMatrix;

public class QTMatrix extends DynamicLenghtMatrix<State> {

	public QTMatrix(int height) {
		super(height);
	}

	public State[][] toStatic() { // NOT READY
		return null;
	}

	public String[][][] toStringStatic() {
		String[][][] matrix = new String[this.height()][this.lenght()][2];
		for (int r = 0; r < this.height(); r++) {
			for (int c = 0; c < this.lenght(r); c++) {
				matrix[r][c][0] = (String) (this.get(r, c).state);
				matrix[r][c][1] = (String) (this.get(r, c).control);
			}
		}

		return matrix;
	}

	public void print() {
		String[][][] matrix = toStringStatic();
		for (int r = 0; r < matrix.length; r++) {
			for (int c = 0; c < matrix[r].length; c++) {
				System.out.print(matrix[r][c][0] + "");
				System.out.print(matrix[r][c][1] + " ");
			}
			System.out.println();
		}
	}

	public void updateQTMatrix(QTState qtstate) {
		add(qtstate);
	}

	public void printstates() {
		String[][][] matrix = toStringStatic();
		for (int r = 0; r < matrix.length; r++) {
			for (int c = 0; c < matrix[r].length; c++) {
				System.out.print(matrix[r][c][0] + " ");
			}
			System.out.println();
		}
	}

	public void printlaststates() {
		String[][][] matrix = toStringStatic();
		for (int r = 0; r < matrix.length; r++) {
			System.out.print(matrix[r][matrix[0].length - 1][0]);
		}
		System.out.println();
	}

	public boolean isLastQT(QTState qtstate) {

		for (int r = 0; r < qtstate.height(); r++) {

			if (this.lenght() == 0
					|| !(this.get(r, this.lenght() - 1).state == qtstate.get(r, qtstate.lenght() - 1).state)
					|| !(this.get(r, this.lenght() - 1).control == qtstate.get(r, qtstate.lenght() - 1).control)) {
				return false;
			}
		}

		return true;
	}
}
