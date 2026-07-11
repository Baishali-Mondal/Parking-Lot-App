package DTO;

import java.util.*;

public class ParkingLot {

    private final String parkingLotName; //a parking lot should have an identity:Forum Mall Parking
    private final List<ParkingFloor> parkingFloors; // ownership
    private final List<ParkingTicket> parkingTickets; // to maintain history if ticket is lost

    public ParkingLot(String parkingLotName) {
        this.parkingLotName = parkingLotName;
        this.parkingFloors = new ArrayList<>();
        this.parkingTickets = new ArrayList<>();
    }

    public String getParkingLotName() {
        return parkingLotName;
    }

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public List<ParkingTicket> getParkingTickets() {
        return parkingTickets;
    }


    public void addFloor(ParkingFloor floor) {
        parkingFloors.add(floor);
    }


    //It doesn't park the vehicle but starts the parking process: Vehicle enters-->Parking Successful-->Ticket Generated
    public ParkingTicket parkVehicle(Vehicle vehicle) {
        for (ParkingFloor floor : parkingFloors) {
            ParkingSlot slot = floor.findAvailableSlot(vehicle.getVehicleType());
            if (slot != null) {
                slot.parkVehicle(vehicle);

                ParkingTicket ticket = new ParkingTicket(vehicle, slot);
                parkingTickets.add(ticket);
                return ticket;
            }
        }
        System.out.println("No Slot available for parking..");
        return null;
    }


    public void exitVehicle(ParkingTicket ticket) {
        ParkingSlot slot = ticket.getParkingSlot(); //get the slot from the ticket
        slot.removeVehicle();
        ticket.closeTicket(); //set exit and calculate the fee
        ticket.calculateFee();
//        System.out.println("Vehicle exited successfully");
    }


    public ParkingTicket findTicketById(int ticketId) {
        for (ParkingTicket ticket : parkingTickets) {
            if (ticket.getTicketId() == ticketId
                    && ticket.getStatus() == TicketStatus.ACTIVE) {
                return ticket;
            }
        }
        return null;
    }


    public void displayAvailableSlots() {
        for (ParkingFloor floor : parkingFloors) {
            System.out.println("\nFloor : " + floor.getFloorNumber());
            for (ParkingSlot slot : floor.getParkingSlots()) {
                if (slot.isAvailable()) {
                    System.out.println(
                            "Slot " + slot.getSlotNumber() + " (" +
                                    slot.getSlotType() + ") "
                    );
                }
            }
        }
    }
}
