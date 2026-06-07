package LLD.easy.parkingLot;

import LLD.easy.parkingLot.model.*;
import LLD.easy.parkingLot.service.ParkingService;
import LLD.easy.parkingLot.strategy.NearestSpotStrategy;
import LLD.easy.parkingLot.strategy.ParkingStrategy;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        /*
        //Vehicle type test
        Vehicle car = new Car("MH12AB1234");
        System.out.println(car.getVehicleNumber());
        System.out.println(car.getVehicleType());

        //Spot test
        Vehicle car1 = new Car("MH13AZ1234");
        ParkingSpot spot = new CarSpot(1);
        //ParkingSpot spot = new TruckSpot(1);   // Negative scenatio test -> truck cant be placed in Car spot, hence will get False.
        System.out.println(spot.canFitVehicle(car));

        */
        ParkingSpot carSpot1 = new CarSpot(1);
        ParkingSpot carSpot2 = new CarSpot(2);

        Floor floor1 = new Floor(1, Arrays.asList(carSpot1, carSpot2));

        ParkingLot parkingLot = new ParkingLot("Phoenix Mall Parking", Arrays.asList(floor1));

        ParkingStrategy strategy = new NearestSpotStrategy();

        ParkingService parkingService = new ParkingService(parkingLot, strategy);
        Vehicle car = new Car("MH12AB1234");

        Ticket ticket = parkingService.parkVehicle(car);
        System.out.println("Ticket Id : " + ticket.getTicketId());
        System.out.println("Spot Id : " + ticket.getParkingSpot().getSpotId());

        double bill = parkingService.exitVehicle(ticket.getTicketId());
        System.out.println("Bill : " + bill);
    }
}
