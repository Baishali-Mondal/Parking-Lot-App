package Service;

import DTO.ParkingTicket;
import DTO.Vehicle;

public interface IParkingLotService {

    void displayAvailableSlots();

    ParkingTicket parkVehicle(Vehicle vehicle);

    void exitVehicle(ParkingTicket ticket);

    ParkingTicket findTicketById(int ticketId);
}
