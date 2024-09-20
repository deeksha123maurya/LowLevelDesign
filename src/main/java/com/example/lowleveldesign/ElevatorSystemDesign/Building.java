package com.example.lowleveldesign.ElevatorSystemDesign;

import java.util.List;

public class Building {
    List<Floor>floorList;

    public Building(List<Floor> floors) {
        floorList = floors;
    }

    public void addFloors(Floor newFloor)
    {
        floorList.add(newFloor);
    }

    public void removeFloors(Floor removeFloor)
    {
        floorList.remove(removeFloor);
    }

    public List<Floor>getAllFloor()
    {
        return floorList;
    }
}
