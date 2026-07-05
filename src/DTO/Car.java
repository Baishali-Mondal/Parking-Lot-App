package DTO;

public class Car extends Vehicle{
    public Car(
            String registrationNumber,
            String ownerName,
            String color){

        super(
                registrationNumber,
                ownerName,
                color,
                VehicleType.CAR);
    }
}
