package com.park.parkmanagement.service.impl;


import com.park.parkmanagement.domain.vehicle.Vehicle;
import com.park.parkmanagement.exception.ParkingException;
import com.park.parkmanagement.service.ParkService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParkServiceImpl implements ParkService {

    @Override
    public Optional<Integer> park(Vehicle vehicle) throws ParkingException {
    	
    	
        return Optional.empty();
    }

    @Override
    public void leave(int slotNumber) throws ParkingException {
    	
    	

    }

    @Override
    public List<Vehicle> getAllParkingList(){
        return null;
    }

}