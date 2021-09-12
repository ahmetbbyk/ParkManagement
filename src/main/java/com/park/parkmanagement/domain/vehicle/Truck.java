package com.park.parkmanagement.domain.vehicle;

import com.park.parkmanagement.constant.VehicleType;
import com.park.parkmanagement.constant.VehicleWidth;

public class Truck extends Vehicle {

    public Truck(String vehiclePlate, String vehicleColour) {
        spotsNeeded = VehicleWidth.TRUCK.getValue();
        this.vehiclePlate = vehiclePlate;
        this.vehicleColour = vehicleColour;
        vehicleType = VehicleType.Truck;
    }
}