package com.park.parkmanagement.domain.garage;

import com.park.parkmanagement.domain.vehicle.Vehicle;

public class ParkingSpot {
	private Vehicle vehicle;
	private int spotNumber;

	public boolean isAvailable() {
		return vehicle == null;
	}

	public boolean park(int spotNumber, Vehicle vhcl) {
		this.spotNumber = spotNumber;
		vehicle = vhcl;
		vehicle.parkInSpot(this);
		return true;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public String getSpotNumber() {
		return String.valueOf(spotNumber);
	}

	public void removeVehicle() {
		vehicle = null;
	}
}
