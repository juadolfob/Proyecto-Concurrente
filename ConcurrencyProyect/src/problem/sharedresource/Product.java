package problem.sharedresource;

import control.Control;
import problem.SharedResource;

public class Product implements SharedResource { 
	Control control;

	public Product(Control control) {
		this.control = control;
	}

	@Override
	public void use() { 
		control.lock();
	}

	@Override
	public void relase() {
		control.unlock();
	}

}
