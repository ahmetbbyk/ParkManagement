package com.park.parkmanagement.service.impl;

import com.park.parkmanagement.constant.VehicleType;
import com.park.parkmanagement.domain.garage.ParkingLot;
import com.park.parkmanagement.domain.vehicle.Car;
import com.park.parkmanagement.domain.vehicle.Jeep;
import com.park.parkmanagement.domain.vehicle.Truck;
import com.park.parkmanagement.domain.vehicle.Vehicle;
import com.park.parkmanagement.exception.ExceptionCode;
import com.park.parkmanagement.exception.ParkingException;
import com.park.parkmanagement.service.ParkService;
import org.springframework.stereotype.Service;

@Service
public class ParkServiceImpl implements ParkService {

    @Override
    public String park(Vehicle vehicle) throws ParkingException {
    	if(vehicle==null)
    		throw new ParkingException(ExceptionCode.VEHICLE_EMPTY.getMessage(), ExceptionCode.VEHICLE_EMPTY);
    	
    	ParkingLot parkingLot = ParkingLot.getInstance();
    	
    	if (vehicle.getVehicleType().equals(VehicleType.Car)) 
    		return parkingLot.parkVehicle(new Car(vehicle.vehiclePlate ,vehicle.vehicleColour));
    	else if (vehicle.getVehicleType().equals(VehicleType.Jeep))
    		return parkingLot.parkVehicle(new Jeep(vehicle.vehiclePlate ,vehicle.vehicleColour));
    	else if (vehicle.getVehicleType().equals(VehicleType.Truck))
    		return parkingLot.parkVehicle(new Truck(vehicle.vehiclePlate ,vehicle.vehicleColour));
    	else 
    		return "Beklenmeyen tip";
    }

    @Override
    public void leaveVehicle(Vehicle vehicle) throws ParkingException {
    	if(vehicle==null)
    		throw new ParkingException(ExceptionCode.VEHICLE_EMPTY.getMessage(), ExceptionCode.VEHICLE_EMPTY);
    	ParkingLot parkingLot = ParkingLot.getInstance();
    	parkingLot.leaveVehicle(vehicle);
    }

 
    @Override
    public void leave(int id) throws ParkingException {
    	if (id > 10)
    		throw new ParkingException(ExceptionCode.VEHICLE_ID_CANNOT_BE_GRATER_TEN.getMessage(),ExceptionCode.VEHICLE_ID_CANNOT_BE_GRATER_TEN);
    		
    	ParkingLot parkingLot = ParkingLot.getInstance();
    	Vehicle vhcl = parkingLot.getParkingLotWithId(id);
    	if (vhcl == null)
    		throw new ParkingException(ExceptionCode.VEHICLE_CANNOT_BE_FOUND.getMessage(),ExceptionCode.VEHICLE_CANNOT_BE_FOUND);
    	parkingLot.leaveVehicle(vhcl);
    }
    
    @Override
    public String status() throws ParkingException{   
    	ParkingLot parkingLot = ParkingLot.getInstance();
    	return parkingLot.status();
    }

}