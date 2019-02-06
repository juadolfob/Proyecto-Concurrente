import javax.swing.*;
import java.awt.*;

public class Productor extends Thread {
    private JTextArea area;
    private RecursoCompartido rc;
    private MiMutex mutex;

    public Productor(JTextArea area, RecursoCompartido rc, MiMutex mutex) {
        this.area = area;
        this. rc = rc;
        this.mutex = mutex;
    }
    
    public void run() {
        while(true) {
        	try {
        		mutex.lock();
        		rc.setRc((rc.getRc() + 1));
        		area.append("Productor: " + rc.getRc() + "\n");
        		mutex.unlock();
        	}catch(IllegalMonitorStateException e) {}
        		try {
        			Thread.sleep(400 + (int)(Math.random() * 100));
        		}catch(InterruptedException e) {}
        }
    }
}
