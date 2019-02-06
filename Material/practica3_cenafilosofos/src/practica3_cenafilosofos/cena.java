package practica3_cenafilosofos;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class cena {
	 
	public static void main(String[] args) {
		philosopher filosofo[]= new philosopher[5]; 
		fork fork[] = new fork[5];
		fork[0]= new fork();
		fork[1]= new fork();
		fork[2]= new fork();
		fork[3]= new fork();
		fork[4]= new fork();
		filosofo[0] = new philosopher(0,fork);
		filosofo[1] = new philosopher(1,fork);
		filosofo[2] = new philosopher(2,fork);
		filosofo[3] = new philosopher(3,fork);
		filosofo[4] = new philosopher(4,fork); 
		
		 

            	window gui = new window(filosofo,fork); 

        		gui.setVisible(true);
        		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        		
		filosofo[0].start();
		filosofo[1].start();
		filosofo[2].start();
		filosofo[3].start();
		filosofo[4].start();
	}

}
