package com.park.parkmanagement.controller;

import com.park.parkmanagement.domain.vehicle.Vehicle;
import com.park.parkmanagement.exception.ParkingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.park.parkmanagement.service.ParkService;

@RestController
@RequestMapping("/parkManagement")
public class ParkController {

	@Autowired
	ParkService parkService;

    @RequestMapping(value = "/park", method = RequestMethod.POST)
    public String park(@RequestBody Vehicle vehicle) throws ParkingException {
    	return parkService.park(vehicle);
    }

    @RequestMapping(value = "/leaveVehicle" ,method = RequestMethod.DELETE)
    public void leaveVehicle(@RequestBody Vehicle vehicle) throws ParkingException {
    	parkService.leaveVehicle(vehicle);
    }
  
	@RequestMapping(value = "/leave" ,method = RequestMethod.DELETE)
    public void leave(@RequestBody int leaveCarId) throws ParkingException {
		parkService.leave(leaveCarId);
    }
    
    @RequestMapping(value = "/status", method = RequestMethod.GET)
    public String status() throws ParkingException {
    	return parkService.status();
    }
}
