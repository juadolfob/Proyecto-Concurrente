import javax.swing.*;

public class Consumidor extends Thread{
    private JTextArea area;
    private RecursoCompartido rc;
    private MiMutex mutex;
    
    public Consumidor(JTextArea area, RecursoCompartido rc, MiMutex mutex) {
        this.area = area;
        this.rc = rc;
        this.mutex = mutex;
    }
    
    public void run() {
        while(true) {
        	try {
        		mutex.lock();
        		area.append("Consumidor: " + rc.getRc() + "\n");
        		mutex.unlock();
        	}catch(IllegalMonitorStateException e) {}
            try {
                Thread.sleep((int)(400 + Math.random() * 100));
            }catch(InterruptedException e) {}
        }
    }
}
