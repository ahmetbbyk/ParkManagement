package com.park.parkmanagement.constant;

public enum InfoMessage {
	GARAGE_IS_FULL
	{
		@Override
        public String toString() {
            return "Garage is full.";
        }
    },
	ALLOCATED_SLOTS
	{
		@Override
        public String toString() {
            return "Allocated #SlotCount slot#Singularity.";
        }
    }
}
