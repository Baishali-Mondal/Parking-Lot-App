package DTO;

public class ParkingSlot {
    private final int slotNumber;
    private final VehicleType slotType;
    private boolean occupied;
    private Vehicle parkedVehicle;

    public ParkingSlot(int slotNumber, VehicleType slotType) {
        this.slotNumber = slotNumber;
        this.slotType = slotType;
        this.occupied = false;
        this.parkedVehicle = null;
    }

    public boolean isAvailable() {
        return !occupied;
    }

    public VehicleType getSlotType() {
        return slotType;
    }

    public String getSlotNumber() {
        return slotNumber + " ";
    }

    public void parkVehicle(Vehicle vehicle) {
        if (vehicle.getVehicleType() != slotType) {
            System.out.println("The Slot is not compatible with the Vehicle");
            return;
        } else {
            if (!isAvailable()) {
                System.out.println("Slot is already occupied");
                return;
            }
            this.parkedVehicle = vehicle;
            this.occupied = true;
            System.out.println("\nVehicle parked successfully at Slot No. :" + slotNumber);
        }
    }

    public void removeVehicle() {
        if (isAvailable()) {
            System.out.println("Slot is already Empty");
        }
        parkedVehicle = null;
        occupied = false;
        System.out.println("Vehicle at Slot No. :" + slotNumber + " has been removed successfully");
    }
}
