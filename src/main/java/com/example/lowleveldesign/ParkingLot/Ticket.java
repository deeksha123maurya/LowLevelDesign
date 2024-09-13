package com.example.lowleveldesign.ParkingLot;

import java.time.LocalDateTime;

public class Ticket {
    static int idCounter;
    public int id;
    public String vehicleRegistrationNumber;
    public LocalDateTime arrivalTime;
    public String parkingSpotNumber;

    public Ticket(Vehicle vehicle,ParkingSpot parkingSpot) {
        this.id=++idCounter;
        this.vehicleRegistrationNumber= vehicle.getVehicleNumber();
        this.parkingSpotNumber= parkingSpot.getSpotNumber();
        this.arrivalTime=LocalDateTime.now();
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", vehicleRegistrationNumber='" + vehicleRegistrationNumber + '\'' +
                ", arrivalTime=" + arrivalTime +
                ", parkingSpotNumber='" + parkingSpotNumber + '\'' +
                '}';
    }
}
