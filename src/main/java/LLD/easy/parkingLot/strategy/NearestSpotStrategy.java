package LLD.easy.parkingLot.strategy;

import LLD.easy.parkingLot.model.Floor;
import LLD.easy.parkingLot.model.ParkingSpot;
import LLD.easy.parkingLot.model.Vehicle;

import java.util.List;

public class NearestSpotStrategy implements ParkingStrategy {

    @Override
    public ParkingSpot findSpot(List<Floor> floors, Vehicle vehicle) {
        for (Floor floor: floors){
            for (ParkingSpot spot: floor.getParkingSpots()){
                if(!spot.isOccupied() && spot.canFitVehicle(vehicle)){
                    return spot;
                }
            }
        }
        return null;
    }
}
