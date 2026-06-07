package LLD.easy.parkingLot.model;

public abstract class ParkingSpot {
    private final int spotId;
    private final SpotType spotType;
    private boolean occupied;

    public ParkingSpot(int spotId, SpotType spotType) {
        this.spotId = spotId;
        this.spotType = spotType;
        this.occupied = false;
    }

    public int getSpotId() {
        return spotId;
    }

    public SpotType getSpotType() {
        return spotType;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void parkVehicle() {
        occupied = true;
    }

    public void removeVehicle() {
        occupied = false;
    }

    public abstract boolean canFitVehicle(
            Vehicle vehicle);
}
