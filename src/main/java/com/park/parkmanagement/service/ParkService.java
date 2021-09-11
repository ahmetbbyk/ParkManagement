package com.park.parkmanagement.service;

import com.park.parkmanagement.domain.vehicle.Vehicle;
import com.park.parkmanagement.exception.ParkingException;

import java.util.List;
import java.util.Optional;

public interface ParkService extends AbstractService {

    /* ---- Actions ----- */

    public Optional<Integer> park(Vehicle vehicle) throws ParkingException;

    public void leave(int slotNumber) throws ParkingException;

    List<Vehicle> getAllParkingList() throws ParkingException;
}
