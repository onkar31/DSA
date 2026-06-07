package LLD.easy.parkingLot.model;

public class TruckSpot extends ParkingSpot{
    public TruckSpot(int spotId) {
        super(spotId, SpotType.TRUCK);
    }

    @Override
    public boolean canFitVehicle(
            Vehicle vehicle) {

        return vehicle.getVehicleType()
                == VehicleType.TRUCK;
    }
}
