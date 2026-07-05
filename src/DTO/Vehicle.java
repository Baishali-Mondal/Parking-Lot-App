package DTO;

public abstract class Vehicle {

    private final String registrationNumber;
    private final String ownerName;
    private final String color;
    private final VehicleType vehicleType;

    protected Vehicle(
            String registrationNumber,
            String ownerName,
            String color,
            VehicleType vehicleType) {
        this.registrationNumber = registrationNumber;
        this.ownerName = ownerName;
        this.color = color;
        this.vehicleType = vehicleType;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getColor() {
        return color;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
    @Override
    public String toString() {
        return "Vehicle{" +
                "Car No. : " + registrationNumber + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

}
