package LLD.easy.parkingLot.service;

import LLD.easy.parkingLot.model.ParkingLot;
import LLD.easy.parkingLot.model.ParkingSpot;
import LLD.easy.parkingLot.model.Ticket;
import LLD.easy.parkingLot.model.Vehicle;
import LLD.easy.parkingLot.strategy.ParkingStrategy;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ParkingService {
    private final ParkingLot parkingLot;
    private final ParkingStrategy parkingStrategy;

    private final Map<Long, Ticket> tickets;
    private long ticketCounter = 1;

    public ParkingService(ParkingLot parkingLot, ParkingStrategy parkingStrategy) {
        this.parkingLot = parkingLot;
        this.parkingStrategy = parkingStrategy;
        this.tickets = new HashMap<>();
    }

    public Ticket parkVehicle(Vehicle vehicle) {
        ParkingSpot spot = parkingStrategy.findSpot(parkingLot.getFloors(), vehicle);
        if (spot == null) {
            throw new RuntimeException("Parking Full");
        }
        spot.parkVehicle();
        Ticket ticket = new Ticket(ticketCounter++, vehicle, spot, LocalDateTime.now());
        tickets.put(ticket.getTicketId(), ticket);
        return ticket;
    }

    public double exitVehicle(long ticketId) {
        Ticket ticket = tickets.get(ticketId);
        if (ticket == null) {
            throw new RuntimeException("Invalid Ticket");
        }
        ticket.getParkingSpot()
                .removeVehicle();
        return calculateBill(ticket);
    }

    private double calculateBill(Ticket ticket) {
        return 100;
    }

}
