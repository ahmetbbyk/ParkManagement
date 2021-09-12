package com.park.parkmanagement.constant;

public enum SlotCount {
	
	SLOT_COUNT(10);

    private final int value;

    SlotCount(final int newValue) {
        value = newValue;
    }

    public int getValue() { return value; }
}
