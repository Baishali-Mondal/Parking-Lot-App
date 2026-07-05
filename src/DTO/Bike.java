package DTO;

public class Bike extends Vehicle{

    public Bike(
            String registrationNumber,
            String ownerName,
            String color){

        super(
                registrationNumber,
                ownerName,
                color,
                VehicleType.BIKE);
    }
}
