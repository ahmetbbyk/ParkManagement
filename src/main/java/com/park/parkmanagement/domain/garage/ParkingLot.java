package com.park.parkmanagement.domain.garage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.park.parkmanagement.constant.InfoMessage;
import com.park.parkmanagement.constant.SlotCount;
import com.park.parkmanagement.domain.vehicle.Vehicle;
import com.park.parkmanagement.exception.ParkingException;

public class ParkingLot {

	private static final Logger logger = LoggerFactory.getLogger(ParkingLot.class);
    private final Garage garage;
    private static ParkingLot parkingLot = null;
    
    public ParkingLot(int numberSpots) {
        garage = new Garage(numberSpots);
        logger.info("Created " + numberSpots + " " + "spots");
    }

    public String parkVehicle(Vehicle vehicle) throws ParkingException{
        logger.info(" ------------------------------------ ");

        if (garage.parkVehicle(vehicle)) {
            logger.info("VEHICLE PARKED " + vehicle.getSpotsNeeded());
            return (InfoMessage.ALLOCATED_SLOTS.toString().replace("#SlotCount", Integer.toString(vehicle.getSpotsNeeded()))).replace("#Singularity", (vehicle.getSpotsNeeded()>1?"s":""));
        }
        logger.warn("PARKING FULL");
        return InfoMessage.GARAGE_IS_FULL.toString();
    }

    public void leaveVehicle(Vehicle vehicle) {
        garage.spotFreed(vehicle);
        logger.info("Spot freed and exited  " + vehicle.getVehiclePlate());
    }

    public String status() {
        return garage.status();
    }
    
    public Vehicle getParkingLotWithId(int id) {
        return garage.findSpotbyId(id);
    }
    
    // static method to get the singleton instance of ParkingLot
    public static ParkingLot getInstance() {
      if (parkingLot == null) {
        parkingLot = new ParkingLot(SlotCount.SLOT_COUNT.getValue());
      }
      return parkingLot;
    }

}
