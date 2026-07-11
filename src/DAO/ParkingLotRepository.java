package DAO;

import DTO.ParkingLot;

public class ParkingLotRepository {

    private ParkingLot parkingLot;

    public void saveParkingLot(ParkingLot parkingLot){
        this.parkingLot = parkingLot;
    }

    public ParkingLot getParkingLot(){
        return parkingLot;
    }
}
