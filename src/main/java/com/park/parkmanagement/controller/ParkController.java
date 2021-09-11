package com.park.parkmanagement.controller;

import com.park.parkmanagement.domain.vehicle.Vehicle;
import com.park.parkmanagement.exception.ParkingException;
import org.springframework.web.bind.annotation.*;
import com.park.parkmanagement.service.ParkService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/parkManagement")
public class ParkController {

    private final ParkService parkService;

    public ParkController(ParkService parkService) {
        this.parkService = parkService;
    }

    @RequestMapping(value = "/park", method = RequestMethod.POST, headers = "Accept=application/json")
    public Optional<Integer> parkVehicle(@RequestBody Vehicle vehicle) throws ParkingException {
        return parkService.park(vehicle);
    }

    @RequestMapping(value = "/leave/{id}" ,method = RequestMethod.DELETE,headers = "Accept=application/json")
    public void leaveVehicle(@PathVariable("id") int id) throws ParkingException {
        parkService.leave(id);
    }

    @RequestMapping(value = "/status", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Vehicle> getAllParkingList() throws ParkingException {
        List<Vehicle> vehicleList = parkService.getAllParkingList();
        return vehicleList;
    }
}
