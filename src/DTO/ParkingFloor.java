package DTO;

import java.util.*;

public class ParkingFloor {
    private final int floorNumber;
    private final List<ParkingSlot> parkingSlots;

    public ParkingFloor(int floorNumber){
        this.floorNumber = floorNumber;
        this.parkingSlots = new ArrayList<>();
    }

    public int getFloorNumber(){
        return floorNumber;
    }

    public List<ParkingSlot> getParkingSlots(){
        return this.parkingSlots;
//        return Collections.unmodifiableList(parkingSlots);
    }

    public void addSlot(ParkingSlot slot){
        parkingSlots.add(slot);
    }

    // Check slot availability based on the type of vehicle
    public ParkingSlot findAvailableSlot(VehicleType vehicleType) {
        for(ParkingSlot slot : parkingSlots){
            if(slot.isAvailable()
                    && slot.getSlotType() == vehicleType){
                return slot;
            }
        }
        return null;
    }
}
