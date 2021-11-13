package it.unibo.oop.lab.exception2;

public class TransactionsOverQuotaException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final double maxOperationCount;
	
	public TransactionsOverQuotaException(final double maxOperationCount) {
		this.maxOperationCount = maxOperationCount;
	}
	
	@Override
	public String toString() {
		return "Reached the maximum operation count (" + this.maxOperationCount + ")";
	}

	public String getMessage() {
		return this.toString();
	}
}
