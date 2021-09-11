package com.park.parkmanagement.domain.park;

import com.park.parkmanagement.domain.vehicle.Car;
import com.park.parkmanagement.domain.vehicle.Jeep;
import com.park.parkmanagement.domain.vehicle.Vehicle;

import java.util.*;

public class ParkingLot {
    private static final int NUMBER_OF_SMALL_SLOTS = 10;
    private static final int NUMBER_OF_COMPACT_SLOTS = 10;
    private static final int NUMBER_OF_LARGE_SLOTS = 10;
    public Map<Long, Slot> occupiedSlots;
    private List<Slot> carSlots;
    private List<Slot> jeepSlots;
    private List<Slot> truckSlots;

    public ParkingLot() {
        carSlots = new ArrayList<>(NUMBER_OF_SMALL_SLOTS);
        jeepSlots = new ArrayList<>(NUMBER_OF_COMPACT_SLOTS);
        truckSlots = new ArrayList<>(NUMBER_OF_LARGE_SLOTS);
        createSlots();
        occupiedSlots = new HashMap<>();
    }

    private void createSlots() {

        for (int i = 1; i <= NUMBER_OF_SMALL_SLOTS; i++) {
            carSlots.add(new CarSlot(i));
        }
        for (int i = 1; i <= NUMBER_OF_COMPACT_SLOTS; i++) {
            jeepSlots.add(new JeepSlot(i));
        }
        for (int i = 1; i <= NUMBER_OF_LARGE_SLOTS; i++) {
            truckSlots.add(new TruckSlot(i));
        }

    }

    public long park(Vehicle vehicle) {

        Slot slot;
        long uniqueToken = -1;

        if (vehicle instanceof Car) {
            if ((slot = getFirstEmptySlot(carSlots)) != null) {
                uniqueToken = parkHelper(slot, vehicle);
            } else if ((slot = getFirstEmptySlot(jeepSlots)) != null) {
                uniqueToken = parkHelper(slot, vehicle);
            } else if ((slot = getFirstEmptySlot(truckSlots)) != null) {
                uniqueToken = parkHelper(slot, vehicle);
            }
        } else if (vehicle instanceof Jeep) {
            if ((slot = getFirstEmptySlot(jeepSlots)) != null) {
                uniqueToken = parkHelper(slot, vehicle);
            } else if ((slot = getFirstEmptySlot(truckSlots)) != null) {
                uniqueToken = parkHelper(slot, vehicle);
            }
        } else {
            if ((slot = getFirstEmptySlot(truckSlots)) != null) {
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
