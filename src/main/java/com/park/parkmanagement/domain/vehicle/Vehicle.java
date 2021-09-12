package com.park.parkmanagement.domain.vehicle;

import java.util.ArrayList;
import java.util.StringJoiner;

import com.park.parkmanagement.constant.SlotCount;
import com.park.parkmanagement.constant.VehicleType;
import com.park.parkmanagement.domain.garage.ParkingSpot;
public  class Vehicle {

    protected ArrayList<ParkingSpot> parkingSpots = new ArrayList<>();
    public String vehiclePlate;
    public String vehicleColour;
    public int spotsNeeded;
    public VehicleType vehicleType;

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public int getSpotsNeeded() {
        return spotsNeeded;
    }

    public void parkInSpot(ParkingSpot s) {
        parkingSpots.add(s);
    }

    public void clearSpots() {
        for (ParkingSpot parkingSpot : parkingSpots) {
            parkingSpot.removeVehicle();
        }
        parkingSpots.clear();
    }

    public boolean canFitInSpot(int spotNumber, ParkingSpot[] spots) {
        for (var i = 0; i < spotsNeeded; i++) {
            if ((spotNumber + i)<SlotCount.SLOT_COUNT.getValue() && ((spotNumber + i) > spots.length || (!spots[spotNumber + i].isAvailable()))) {
                return false;
            }
        }

        return true;
    }

	public boolean isExist(ParkingSpot[] spots) {
    	 for (var i = 0; i < spots.length; i++) {
            if (spots[i].getVehicle() !=null && this.vehiclePlate.equals(spots[i].getVehicle().getVehiclePlate())) {
                return true;
            }
        }

        return false;
    }

    public String getVehiclePlate() {
        return vehiclePlate;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Vehicle.class.getSimpleName() + "[", "]")
                .add("vehiclePlate='" + vehiclePlate + "'")
                .add("spotsNeeded=" + spotsNeeded)
                .add("vehicleType=" + vehicleType)
                .toString();
    }

}
