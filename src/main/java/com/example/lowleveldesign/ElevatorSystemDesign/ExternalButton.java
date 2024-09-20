package com.example.lowleveldesign.ElevatorSystemDesign;

public class ExternalButton {
    ExternalButtonDispatcher dispatcher=new ExternalButtonDispatcher();

    public void pressButton(int floor, Direction direction)
    {
        dispatcher.submitExternalRequest(floor,direction);
    }
}
