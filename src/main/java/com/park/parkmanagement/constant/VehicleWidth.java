package com.park.parkmanagement.constant;

public enum VehicleWidth {
	
    CAR(1), JEEP(2), TRUCK(4);
	
	private final int value;

	VehicleWidth(final int newValue) {
        value = newValue;
    }

    public int getValue() { return value; }
}
