package com.park.parkmanagement.service;

import com.park.parkmanagement.domain.vehicle.Vehicle;
import com.park.parkmanagement.exception.ParkingException;

public interface ParkService {

    /* ---- Parking Actions ----- */

    public String park(Vehicle vehicle) throws ParkingException;
    
    public void leaveVehicle(Vehicle vehicle) throws ParkingException;

    public String status() throws ParkingException;

	public void leave(int id) throws ParkingException;
}
