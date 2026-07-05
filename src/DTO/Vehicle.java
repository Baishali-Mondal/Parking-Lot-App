package DTO;

public abstract class Vehicle {

    private final String registrationNumber;
    private final String ownerName;
    private final String color;

    protected Vehicle( String registrationNumber, String ownerName, String color) {
        this.registrationNumber = registrationNumber;
        this.ownerName = ownerName;
        this.color = color;
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

    @Override
    public String toString() {
        return "Vehicle{" +
                "Car No. : " + registrationNumber + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
