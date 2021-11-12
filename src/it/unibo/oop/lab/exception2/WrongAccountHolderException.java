package it.unibo.oop.lab.exception2;

public class WrongAccountHolderException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int usrId;
	
	public WrongAccountHolderException(final int userID) {
		this.usrId = userID;
	}
	
	@Override
	public String toString() {
		return "User with id(" + this.usrId + ") has no authorization to operate here";
	}

	public String getMessage() {
		return this.toString();
	}
}
