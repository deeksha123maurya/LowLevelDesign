package com.example.lowleveldesign.CarRentalSystem;

import java.util.ArrayList;
import java.util.List;

public class VehicleInventoryManagement {
    List<Vehicle> vehicles=new ArrayList<>();

    public VehicleInventoryManagement(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
