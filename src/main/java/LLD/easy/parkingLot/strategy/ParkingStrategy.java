package LLD.easy.parkingLot.strategy;

import LLD.easy.parkingLot.model.Floor;
import LLD.easy.parkingLot.model.ParkingSpot;
import LLD.easy.parkingLot.model.Vehicle;

import java.util.List;

public interface ParkingStrategy {

    ParkingSpot findSpot(List<Floor> floors, Vehicle vehicle);
}
