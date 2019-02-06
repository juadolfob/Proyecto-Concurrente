package practica3_cenafilosofos;
 
public class mutex {
	private boolean bandera;

	public void lock() {
 
		while (bandera) { 
			try {
			doWait();
			}catch (IllegalMonitorStateException e) { }
		} 
		bandera = true;
	}

	public void unlock() {
 
		bandera = false;
		doNotify();

	}

	public void doNotify() {

		try {
			this.notify();
		} catch (IllegalMonitorStateException e) { }
	}

	public void doWait() throws IllegalMonitorStateException{
		try {
			this.wait();
		} catch (InterruptedException e) { 
		}
	}
}

