package LLD.easy.parkingLot.model;

import java.util.List;

public class ParkingLot {
    private final String parkingLotName;
    private final List<Floor> floors;

    public ParkingLot(String parkingLotName, List<Floor> floors) {
        this.parkingLotName = parkingLotName;
        this.floors = floors;
    }

    public String getParkingLotName() {
        return parkingLotName;
    }

    public List<Floor> getFloors() {
        return floors;
    }
}
