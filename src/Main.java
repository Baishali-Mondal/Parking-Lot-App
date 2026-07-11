import Controller.ParkingLotController;

import DAO.ParkingLotRepository;
import DTO.ParkingFloor;
import DTO.ParkingLot;
import DTO.ParkingSlot;
import DTO.VehicleType;
import Service.IParkingLotService;
import Service.ParkingLotService;

public class Main {

    public static void main(String[] args) {

        //create a parking lot
        ParkingLot parkingLot = new ParkingLot("Galaxy Mall Parking");

        //create floors
        ParkingFloor floor1 = new ParkingFloor(1);
        ParkingFloor floor2 = new ParkingFloor(2);

        //add slots to the floors
        floor1.addSlot(new ParkingSlot(1, VehicleType.CAR));
        floor1.addSlot(new ParkingSlot(2, VehicleType.CAR));
        floor1.addSlot(new ParkingSlot(3, VehicleType.BIKE));
        floor1.addSlot(new ParkingSlot(4, VehicleType.BIKE));

        floor2.addSlot(new ParkingSlot(1, VehicleType.TRUCK));
        floor2.addSlot(new ParkingSlot(2, VehicleType.TRUCK));
        floor2.addSlot(new ParkingSlot(3, VehicleType.CAR));
        floor2.addSlot(new ParkingSlot(4, VehicleType.CAR));

        //add floors to the parking lot
        parkingLot.addFloor(floor1);
        parkingLot.addFloor(floor2);

        //create repository
        ParkingLotRepository repository  = new ParkingLotRepository();
        repository.saveParkingLot(parkingLot); //save ParkingLot

        //create service
        IParkingLotService service = new ParkingLotService(repository);

        //create controller
        ParkingLotController controller = new ParkingLotController(service);

        controller.runParkingLot();
    }
}
