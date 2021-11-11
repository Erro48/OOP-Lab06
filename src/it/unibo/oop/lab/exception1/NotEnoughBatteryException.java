package it.unibo.oop.lab.exception1;

public class NotEnoughBatteryException extends IllegalStateException {

	private final double batteryLevel;
	
	public NotEnoughBatteryException(final double batteryLevel) {
		this.batteryLevel = batteryLevel;
	}

	@Override
	public String toString() {
		return "Remain battery = " + this.batteryLevel;
	}
	
	@Override
	public String getMessage() {
		return this.toString();
	}

}
