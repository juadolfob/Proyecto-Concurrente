package control.concurency;

import control.Control;

public class Mutex implements Control {

	private boolean flag;

	@Override
	public void lock() {

		while (flag) {
			try {
				doWait();
			} catch (IllegalMonitorStateException e) {
			}
		}
		flag = true;
	}

	@Override
	public void unlock() {

		flag = false;
		doNotify();

	}

	private void doNotify() {

		try {
			this.notify();
		} catch (IllegalMonitorStateException e) {
		}
	}

	private void doWait() throws IllegalMonitorStateException {
		try {
			this.wait();
		} catch (InterruptedException e) {
		}
	}
}
