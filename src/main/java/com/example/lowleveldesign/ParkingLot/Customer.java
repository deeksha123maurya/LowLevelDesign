package com.example.lowleveldesign.ParkingLot;

public class Customer {

    public String name;
    public Vehicle vehicle;

    public Customer(String name,String vehicleNumber) {
        this.name=name;
        this.vehicle=new Vehicle(vehicleNumber);
    }

    public Vehicle getVehicle()
    {
        return vehicle;
    }
}
