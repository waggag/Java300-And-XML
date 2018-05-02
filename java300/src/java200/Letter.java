package java200;

public class Letter {
	private String name;
	private int counter;
	
	public Letter() {
	}
	
	public Letter(String name) {
		super();
		this.name = name;
	}

	/**
	 * @param name
	 * @param counter
	 */
	public Letter(String name, int counter) {
		super();
		this.name = name;
		this.counter = counter;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}
	
}
