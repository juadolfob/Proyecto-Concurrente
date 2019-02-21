package control;

import java.util.ArrayList;

import matrix.DynamicLenghtMatrix;

public class QTState extends DynamicLenghtMatrix<State>{
 
	public QTState(int actors) {
		super(actors); 
	} 
 
	public String[][][] toStringStatic() {
		String[][][] matrix=new String[this.height()][this.lenght()][2];
		for(int r=0;r<this.height();r++) {
			for(int c=0;c<this.lenght(r);c++)	{
				matrix[r][c][0]=(String)(this.get(r,c).state);
				matrix[r][c][1]=(String)(this.get(r,c).control);
			}
	}
		
		return matrix; 
	}
	
	public void print() { 
		for (int r = 0; r < this.height(); r++) {
			for (int c = 0; c < this.lenght(r); c++) { 
				this.get(r, c).print();
				this.get(r, c).print();
			}
			System.out.println();
		}
	}

	public void printstates() {
		for (int r = 0; r < this.height(); r++) {
			for (int c = 0; c < this.lenght(r); c++) { 
				System.out.print(this.get(r, c).state); 
			}
		}
	}
 
 
}
