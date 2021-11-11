package it.unibo.oop.lab.exception1;

/**
 * Represents an exception occurring when battery level of a robot
 * is not enough.
 * 
 */
public class NotEnoughBatteryException extends IllegalStateException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final double batteryLevel;
	
	/**
	 * Construct new instance of exception
	 * 
	 * @param batteryLevel
	 * 	            	represent the battery level that caused the exception
	 * 
	 */
	public NotEnoughBatteryException(final double batteryLevel) {
		this.batteryLevel = batteryLevel;
	}

	/**
     * 
     * @return the string representation of instances of this class
     */
	@Override
	public String toString() {
		return "Remain battery = " + this.batteryLevel;
	}
	
	@Override
	public String getMessage() {
		return this.toString();
	}

}
