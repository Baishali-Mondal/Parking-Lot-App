package DTO;

public class Truck extends Vehicle{

    public Truck(
            String registrationNumber,
            String ownerName,
            String color){

        super(
                registrationNumber,
                ownerName,
                color,
                VehicleType.TRUCK);
    }
}
