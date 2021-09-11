package com.park.parkmanagement.domain.vehicle;

public abstract class Vehicle {
    private String vehiclePlateNo;
    private String vehicleColour;
    private final VehicleWidth widht;
    private final VehicleType type;

    
    public Vehicle(VehicleType type, VehicleWidth width) {
        this.type = type;
        this.widht = width;
    }
    
	public String getVehiclePlateNo() {
        return vehiclePlateNo;
    }

    public void setVehiclePlateNo(String vehiclePlateNo) {
        this.vehiclePlateNo = vehiclePlateNo;
    }

    public String getVehicleColour() {
        return vehicleColour;
    }

    public void setVehicleColour(String vehicleColour) {
        this.vehicleColour = vehicleColour;
    }

	public VehicleType getType() {
		return type;
	}

	public VehicleWidth getWidht() {
		return widht;
	}
}
