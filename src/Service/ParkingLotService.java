package Service;

import DAO.ParkingLotRepository;
import DTO.ParkingLot;
import DTO.ParkingTicket;
import DTO.Vehicle;

public class ParkingLotService implements IParkingLotService {
    private final ParkingLotRepository parkingRepository;

    public ParkingLotService(ParkingLotRepository parkingRepository) {
        this.parkingRepository = parkingRepository;
    }

    @Override
    public ParkingTicket parkVehicle(Vehicle vehicle) {
        ParkingLot parkingLot = parkingRepository.getParkingLot();

        if (parkingLot == null) {
            System.out.println("Parking Lot is not initialized");
            return null;
        }
        return parkingLot.parkVehicle(vehicle);
    }

    @Override
    public void exitVehicle(ParkingTicket ticket) {

        ParkingLot parkingLot = parkingRepository.getParkingLot();

        if (parkingLot == null) {
            System.out.println("Parking Lot is not initialized");
            return;
        }
        parkingLot.exitVehicle(ticket);
    }

    @Override
    public void displayAvailableSlots() {
        ParkingLot parkingLot = parkingRepository.getParkingLot();

        if (parkingLot == null) {
            System.out.println("Parking Lot is not initialized");
            return;
        }
        parkingLot.displayAvailableSlots();
    }

    @Override
    public ParkingTicket findTicketById(int ticketId) {
        ParkingLot parkingLot = parkingRepository.getParkingLot();
        if (parkingLot == null) {
            System.out.println("Parking Lot is not initialized");
            return null;
        }
        return parkingLot.findTicketById(ticketId);
    }
}
