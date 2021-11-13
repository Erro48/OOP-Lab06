package it.unibo.oop.lab.exception2;

public class NotEnoughFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final double amount;
	
	public NotEnoughFoundException(final double amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return "Remain money: " + this.amount;
	}

	public String getMessage() {
		return this.toString();
	}
}
