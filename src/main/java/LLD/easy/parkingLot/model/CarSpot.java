package LLD.easy.parkingLot.model;

public class CarSpot extends ParkingSpot{
    public CarSpot(int spotId) {
        super(spotId, SpotType.CAR);
    }

    @Override
    public boolean canFitVehicle(
            Vehicle vehicle) {

        return vehicle.getVehicleType()
                == VehicleType.CAR;
    }
}
