package control;

public interface Control {
	static final String MUTEX = "MUTEX";

	boolean flag = false;

	public void lock();

	public void unlock();
}