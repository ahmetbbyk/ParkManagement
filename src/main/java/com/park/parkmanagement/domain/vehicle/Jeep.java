package com.park.parkmanagement.domain.vehicle;

import com.park.parkmanagement.constant.VehicleType;
import com.park.parkmanagement.constant.VehicleWidth;

public class Jeep extends Vehicle{
    public Jeep(String vehiclePlate, String vehicleColour){
        spotsNeeded = VehicleWidth.JEEP.getValue();
        this.vehiclePlate = vehiclePlate;
        this.vehicleColour = vehicleColour;
        vehicleType = VehicleType.Jeep;
    }
}
