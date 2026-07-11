package Controller;

import DAO.ParkingLotRepository;
import DTO.*;
import Factory.VehicleFactory;
import Service.IParkingLotService;

import java.util.List;
import java.util.Scanner;

public class ParkingLotController {

    private final Scanner scanner;
    private final IParkingLotService parkingService;

    public ParkingLotController(IParkingLotService parkingService) {
        this.scanner = new Scanner(System.in);
        this.parkingService = parkingService;
    }

    public void showMenu() {
        System.out.println();
        System.out.println("=========================================");
        System.out.println("            Parking Lot System           ");
        System.out.println("=========================================");
        System.out.println("1. Park Vehicle");
        System.out.println("2. Exit Vehicle");
        System.out.println("3. Display Available Slots");
        System.out.println("4. Exit\n");
    }

    public void runParkingLot() {
        while (true) {
            showMenu();
            String userAction = getUserInput("Enter your Choice");
            try {
                performAction(Integer.parseInt(userAction));
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number");
            }
        }
    }

    private String getUserInput(String message) {
        System.out.print(message + " : ");
        return scanner.nextLine();
    }

    private void performAction(int action) {
        switch (action) {
            case 1:
                parkVehicle();
                break;
            case 2:
                exitVehicle();
                break;
            case 3:
                displayAvailableSlots();
                break;
            case 4:
                System.exit(0);
            default:
                System.out.println("Invalid choice. Please select from 1-4");
        }
    }

    private void displayAvailableSlots() {
        parkingService.displayAvailableSlots();
    }

    private void exitVehicle() {
        int ticketId = Integer.parseInt(getUserInput("Enter Ticket ID "));

        ParkingTicket ticket = parkingService.findTicketById(ticketId);
        if (ticket == null) {
            System.out.println("Ticket ID " + ticketId + " not found");
            return;
        }

        parkingService.exitVehicle(ticket);
        System.out.println("Parking Fee : ₹" + ticket.getFee());
        System.out.println("Vehicle exited Successfully. Thank You!!!!!");
    }

    private void parkVehicle() {
        VehicleType vehicleType = getVehicleType();

        String regisNumber = getUserInput("Enter Registration Number");
        String ownerName = getUserInput("Enter Owner Name");
        String color = getUserInput("Enter Vehicle Color");

        Vehicle vehicle = VehicleFactory.createVehicle(
                vehicleType,
                regisNumber,
                ownerName,
                color);

        ParkingTicket ticket = parkingService.parkVehicle(vehicle);

        if (ticket != null) {
            System.out.println();
            System.out.println("Vehicle Parked Successfully");
            System.out.println("Ticket ID : " + ticket.getTicketId());
            System.out.println("Slot No : " + ticket.getParkingSlot().getSlotNumber());
        } else {
            System.out.println("Parking Full.");
        }
    }

    private VehicleType getVehicleType() {
        System.out.println("Select Vehicle Type");
        System.out.println("1. CAR");
        System.out.println("2. BIKE");
        System.out.println("3. TRUCK");

        int choice = Integer.parseInt(getUserInput("Enter the type of Vehicle"));

        switch (choice) {
            case 1:
                return VehicleType.CAR;
            case 2:
                return VehicleType.BIKE;
            case 3:
                return VehicleType.TRUCK;
            default:
                System.out.println("Invalid Vehicle Type");
                return null;
        }

    }
}
