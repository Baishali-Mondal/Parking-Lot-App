package DTO;

import java.time.Duration;
import java.time.LocalDateTime;

public class ParkingTicket {

    private static int ticketCounter = 1;
    private final int ticketId;

    private final Vehicle vehicle;
    private final ParkingSlot parkingSlot;

    private final LocalDateTime entryTime;
    private LocalDateTime exitTime;

    private double fee;
    private TicketStatus status;


    public ParkingTicket(Vehicle vehicle,
                         ParkingSlot parkingSlot) {
        this.ticketId = ticketCounter++;
        this.vehicle = vehicle;
        this.parkingSlot = parkingSlot;
        this.entryTime = LocalDateTime.now();
        this.status = TicketStatus.ACTIVE;
    }

    //getters
    public int getTicketId() {
        return ticketId;
    }
    public Vehicle getVehicle() {
        return vehicle;
    }
    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }
    public LocalDateTime getEntryTime() {
        return entryTime;
    }
    public LocalDateTime getExitTime() {
        return exitTime;
    }
    public double getFee() {
        return fee;
    }
    public TicketStatus getStatus() {
        return status;
    }



    public void calculateFee(){
        long minutes = Duration.between(entryTime, exitTime).toMinutes();

        if( minutes < 1){
            minutes = 1;
        }
        fee = minutes * 10;
    }



    public void closeTicket() {
        this.exitTime = LocalDateTime.now();
        calculateFee();
        this.status = TicketStatus.CLOSED;
    }

}
