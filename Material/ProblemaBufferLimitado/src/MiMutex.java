

public class MiMutex {
    private boolean bandera;
    
    public MiMutex(boolean bandera) {
    	this.bandera = bandera;
    }
    public void lock() throws IllegalMonitorStateException {
    	while(bandera) {
    		try {
				wait();
			} catch (InterruptedException e) {}
    	}
    	bandera = true;
    }
    public void unlock() throws IllegalMonitorStateException {
        bandera = false;
        notify();
    }
}
