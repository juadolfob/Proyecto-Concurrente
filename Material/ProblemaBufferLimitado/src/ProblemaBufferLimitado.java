import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ProblemaBufferLimitado extends JFrame{
    private JButton bCorrer, bPause, bSalir;
    private JTextArea area;
    private JScrollPane scroll;
    private RecursoCompartido rc;
    private MiMutex mutex;
    private Productor p;
    private Consumidor c;
    private boolean control;
    
    public ProblemaBufferLimitado() {
        setSize(400, 400);
        setTitle("Productor Consumidor Mutex");
        this.control = false;
        MisComponentes();
    }
    private void MisComponentes() {
        bCorrer = new JButton("Correr");
        bPause = new JButton("Pausa");
        bSalir = new JButton("Salir");
        area = new JTextArea();
        scroll = new JScrollPane(area);
        rc = new RecursoCompartido();
        
        mutex = new MiMutex(false);
        p = new Productor(area, rc, mutex);
        c = new Consumidor(area, rc, mutex);
   
        setLayout(null);
        add(bCorrer);
        bCorrer.setBounds(10, 10, 100, 25);
        bCorrer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    p.start();
                    c.start();
                }catch(IllegalThreadStateException ex) {}
            }
        });
        add(bPause);
        bPause.setBounds(10, 50, 100, 25);
        bPause.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                p.interrupt();
                c.interrupt();
            }
        });
        add(bSalir);
        bSalir.setBounds(10, 80, 100, 25);
        bSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                p.interrupt();
                c.interrupt();
                dispose();
            }
        });
        add(scroll);
        scroll.setBounds(130, 10, 200, 200);
    }
    public static void main(String[] args) {
        ProblemaBufferLimitado fr = new ProblemaBufferLimitado();
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
