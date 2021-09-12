package com.park.parkmanagement.domain.vehicle;

import com.park.parkmanagement.constant.VehicleType;
import com.park.parkmanagement.constant.VehicleWidth;

public class Car extends Vehicle{
    public Car(String vehiclePlate, String vehicleColour){
        spotsNeeded = VehicleWidth.CAR.getValue();
        this.vehiclePlate = vehiclePlate;
        this.vehicleColour = vehicleColour;
        vehicleType = VehicleType.Car;
    }
}
