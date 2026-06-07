package LLD.easy.parkingLot.factory;

import LLD.easy.parkingLot.model.*;

public class VehicleFactory {

    public static Vehicle createVehicle(
            VehicleType vehicleType,
            String vehicleNumber){
        switch (vehicleType){
            case CAR:
                return new Car(vehicleNumber);

            case BIKE:
                return new Bike(vehicleNumber);

            case TRUCK:
                return new Truck(vehicleNumber);

            default:
                throw new IllegalArgumentException("Invalid vehicle type");
        }
    }
}
