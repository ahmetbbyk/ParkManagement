package com.park.parkmanagement.domain.park;

import com.park.parkmanagement.domain.vehicle.Car;
import com.park.parkmanagement.domain.vehicle.Jeep;
import com.park.parkmanagement.domain.vehicle.Vehicle;

import java.util.*;

public class ParkingLot {
    private static final int NUMBER_OF_PARK_SLOTS = 10;
    public Map<Long, Slot> occupiedSlots;
    private List<Slot> vehicleSlots;

    public ParkingLot() {
        vehicleSlots = new ArrayList<>(NUMBER_OF_PARK_SLOTS);
        createSlots();
        occupiedSlots = new HashMap<>();
    }

    private void createSlots() {
        for (int i = 1; i <= NUMBER_OF_PARK_SLOTS; i++) {
            vehicleSlots.add(new VehicleSlot(i));
        }
    }

    public long park(Vehicle vehicle) {

        Slot slot;
        long uniqueToken = -1;

        if (vehicle instanceof Car) {
            if ((slot = getFirstEmptySlot(vehicleSlots)) != null) {
                uniqueToken = parkHelper(slot, vehicle);
            }
        } else if (vehicle instanceof Jeep) {
            if ((slot = getFirstEmptySlot(vehicleSlots)) != null) {
                uniqueToken = parkHelper(slot, vehicle);
            }
        } else {
            if ((slot = getFirstEmptySlot(vehicleSlots)) != null) {
                uniqueToken = parkHelper(slot, vehicle);
            }
        }
        return uniqueToken;
    }

    public void unPark(long uniqueToken) {
        occupiedSlots.get(uniqueToken).unPark();
        occupiedSlots.remove(uniqueToken);
    }

    private Slot getFirstEmptySlot(List<Slot> slots) {
        Iterator<Slot> slotIterator = slots.iterator();
        boolean isSlotFound = false;
        Slot emptySlot = null;

        while (slotIterator.hasNext() && !isSlotFound) {
            emptySlot = slotIterator.next();
            if (!emptySlot.isOccupied()) {
                isSlotFound = true;
            }
        }
        return emptySlot;
    }

    private long parkHelper(Slot slot, Vehicle vehicle) {
        slot.park();
        long uniqueToken = vehicle.hashCode() * 43;
        occupiedSlots.put(uniqueToken, slot);
        return uniqueToken;
    }
}
