package com.example.lowleveldesign.ElevatorSystemDesign;

public class Floor {
    int floorNumber;
    ExternalButtonDispatcher externalButtonDispatcher;

    public Floor(int floorNumber) {
        this.floorNumber=floorNumber;
        externalButtonDispatcher = new ExternalButtonDispatcher();
    }

    public void pressButton(Direction direction)
    {
        externalButtonDispatcher.submitExternalRequest(floorNumber,direction);
    }
}
