package LLD.easy.parkingLot.model;

public class BikeSpot extends ParkingSpot{

    public BikeSpot(int spotId) {
        super(spotId, SpotType.BIKE);
    }

    @Override
    public boolean canFitVehicle(
            Vehicle vehicle) {

        return vehicle.getVehicleType()
                == VehicleType.BIKE;
    }
}
