package com.park.parkmanagement.domain.garage;

import java.util.Arrays;
import java.util.stream.Collectors;

import com.park.parkmanagement.domain.vehicle.Vehicle;
import com.park.parkmanagement.exception.ExceptionCode;
import com.park.parkmanagement.exception.ParkingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Garage {
	private static final Logger logger = LoggerFactory.getLogger(Garage.class);
	private final ParkingSpot[] spots;
	private int availableSpots;

	public Garage(int numberOfSpots) {
		availableSpots = numberOfSpots;
		spots = new ParkingSpot[numberOfSpots];

		for (var i = 0; i < numberOfSpots; i++) {
			spots[i] = new ParkingSpot();
		}
	}

	public int availableSpots() {
		return availableSpots;
	}

	public boolean parkVehicle(Vehicle vehicle) throws ParkingException {
		if (availableSpots() < vehicle.getSpotsNeeded())
			return false;

		int spotNumber = findAvailableSpots(vehicle);
		if (spotNumber < 0)
			return false;

		if (vehicle.isExist(spots))
			throw new ParkingException(ExceptionCode.VEHICLE_ALLREADY_EXIST.getMessage(),
					ExceptionCode.VEHICLE_ALLREADY_EXIST);

		return parkStartingAtSpot(spotNumber, vehicle);
	}

	private boolean parkStartingAtSpot(int number, Vehicle vhcl) {
		vhcl.clearSpots();
		var success = true;
		for (int i = number; i < number + vhcl.getSpotsNeeded(); i++) {
			// full slots with vehicle
			success &= spots[i].park(i, vhcl);
			logger.info("Allocating the spot.. " + i + " for vehicle :" + vhcl.vehiclePlate + " - "
					+ vhcl.getVehicleType());
		}
		availableSpots -= vhcl.getSpotsNeeded();
		return success;
	}

	private int findAvailableSpots(Vehicle vehicle) {
		for (var i = 0; i < spots.length; i++) {
			if (spots[i].isAvailable() && vehicle.canFitInSpot(i, spots)) {
				return i;
			}
		}
		return -1;
	}

	public void spotFreed(Vehicle vehicle) {
		for (ParkingSpot spot : spots) {
			if (spot.getVehicle() != null && spot.getVehicle().getVehiclePlate().equals(vehicle.getVehiclePlate())) {
				spot.removeVehicle();
				availableSpots++;
			}
		}

		logger.info("Available Spots in the current level :" + availableSpots);
	}

	public String status() {
		return Arrays.stream(spots)
				.collect(Collectors.groupingBy(p -> p.getVehicle().getVehiclePlate(),
						Collectors.mapping(ParkingSpot::getSpotNumber, Collectors.joining(",", "[", "]"))))
				.entrySet().stream().map(e -> e.getKey() + " " + e.getValue()).collect(Collectors.joining("\n"));
	}

	public Vehicle findSpotbyId(int id) {
		return spots[id].getVehicle();
	}
}