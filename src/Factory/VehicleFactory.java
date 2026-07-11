package Factory;

import DTO.*;

public class VehicleFactory {

    public static Vehicle createVehicle(
            VehicleType vehicleType,
            String registrationNumber,
            String ownerName,
            String color){

        switch(vehicleType){
            case CAR:
                return new Car(registrationNumber, ownerName, color);
            case BIKE:
                return new Bike(registrationNumber, ownerName, color);
            case TRUCK:
                return new Truck(registrationNumber, ownerName, color);
            default:
                throw new IllegalArgumentException("Invalid Vehicle Type");
        }
    }
}
