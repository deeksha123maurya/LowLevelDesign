package com.example.lowleveldesign.ParkingLot;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;

public class AutomatedSystem {
    public int id;
    public ParkingLot parkingLot;
    public HashMap<Integer,Ticket>currentTickets;

    public AutomatedSystem(int id) {
        this.id = id;
        currentTickets=new HashMap<>();
    }

    public ParkingLot getParkingLot()
    {
        return parkingLot;
    }
    public void setParkingLot(ParkingLot parkingLot)
    {
        this.parkingLot=parkingLot;
    }

    public ParkingSpot fetchAvailableSpots()
    {
        return this.parkingLot.getAvailableSpot();
    }

    public Ticket generateTicket(Customer customer)
    {
        ParkingSpot availableSpot=fetchAvailableSpots();
        Vehicle vehicle=customer.getVehicle();
        Ticket ticket=new Ticket(vehicle,availableSpot);
        currentTickets.put(ticket.getId(), ticket);
        return ticket;
    }

    public Ticket scanTicket()
    {
        return currentTickets.get(1234);
    }

    public double calculateCharges()
    {
        Ticket ticket=scanTicket();
        long duration= Duration.between(LocalDateTime.now(), ticket.arrivalTime).toHours();
        double charges=duration* parkingLot.getParkingCharges();
        return charges;
    }

    public void openEntryBarrier(){
        // Code for opening Entry Barrier
        this.parkingLot.getDisplayBoard().update(Status.FULL);
    }
    public void closeEntryBarrier(){
        // Code for closing Entry Barrier
    }
    public void openExitBarrier(){
        // Code for opening Entry Barrier
        this.parkingLot.getDisplayBoard().update(Status.AVAILABLE);
    }
    public void closeExitBarrier(){
        // Code for closing Entry Barrier
    }

}
