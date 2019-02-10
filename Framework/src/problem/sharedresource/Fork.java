package problem.sharedresource;

import control.Control;
import control.concurency.Mutex;
import problem.SharedResource;

public class Fork implements SharedResource {
	int available = 0;
	Control control;

	public Fork(Control control) {
		this.control = control;
	}

	public void use() {
		available++;
		control.lock();
	}

	public void relase() {
		if (available > 0) {
			available--;
		}
		control.unlock();
	}

	public boolean isAvaliable() {
		if (available == 0) {
			return true;
		} else {
			return false;
		}
	}
}
