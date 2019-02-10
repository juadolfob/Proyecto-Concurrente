package problem;

public interface Actor {
	String state = null;

	public default void sleep(int qt) {
		try {
			Thread.sleep(qt + (int) (Math.random() * 100));
		} catch (InterruptedException e) {
		}
	}

	public default String state() {
		return this.state; 
	}

	public default boolean is(String state) {
		if (this.state == state) {
			return true;
		} else {
			return false;
		}
	}

	public void run();
}
