package LLD.easy.parkingLot.strategy;

import LLD.easy.parkingLot.model.Floor;
import LLD.easy.parkingLot.model.ParkingSpot;
import LLD.easy.parkingLot.model.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomSpotStrategy implements ParkingStrategy{

    @Override
    public ParkingSpot findSpot(List<Floor> floors, Vehicle vehicle) {
        List<ParkingSpot> availableSpots = new ArrayList<>();
        for(Floor floor : floors){
            for(ParkingSpot spot :
                    floor.getParkingSpots()) {
                if(!spot.isOccupied() && spot.canFitVehicle(vehicle)) {
                    availableSpots.add(spot);
                }
            }
        }

        if(availableSpots.isEmpty()) {
            return null;
        }

        return availableSpots.get(new Random().nextInt(availableSpots.size()));
    }
}
