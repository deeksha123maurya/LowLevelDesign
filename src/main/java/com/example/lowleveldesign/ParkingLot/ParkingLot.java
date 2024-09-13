package com.example.lowleveldesign.ParkingLot;

import java.util.ArrayList;

public class ParkingLot {
    public String name;
    public int capacity;
    public String Location;
    public double parkingCharges;
    public Admin admin;
    public AutomatedSystem automatedSystem;
    public ArrayList<ParkingSpot> parkingSpots;
    public ArrayList<ParkingSpot> availableSpots;
    public DisplayBoard displayBoard;

    public ParkingLot(String name, int capacity, String location, double parkingCharges, AutomatedSystem automatedSystem, DisplayBoard displayBoard) {
        this.name = name;
        this.capacity = capacity;
        Location = location;
        this.parkingCharges = parkingCharges;
        this.automatedSystem = automatedSystem;
        this.automatedSystem.setParkingLot(this);
        this.displayBoard = displayBoard;
        this.parkingSpots = createParkingSpots(capacity);
        availableSpots = (ArrayList<ParkingSpot>) parkingSpots.clone();
    }
    private ArrayList<ParkingSpot> createParkingSpots(int capacity){
        ArrayList<ParkingSpot> tempList = new ArrayList<>();
        for (int i = 0; i <capacity ; i++) {
            ParkingSpot temp = new ParkingSpot("MPL "+i);
            tempList.add(temp);
        }
        return tempList;
    }

    public double getParkingCharges() {
        return parkingCharges;
    }

    public DisplayBoard getDisplayBoard() {
        return displayBoard;
    }

    public ParkingSpot getAvailableSpot() {
        return availableSpots.remove(0);
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public int getAvailability()
    {
        return availableSpots.size();
    }

    public void updateParkingCharges(double newCharges)
    {
        this.parkingCharges=newCharges;
    }

    public static void main(String[] args)
    {
        AutomatedSystem automatedSystem=new AutomatedSystem(1);
        DisplayBoard displayBoard=new DisplayBoard();
        ParkingLot myParkingLot=new ParkingLot("ABC",100,"Lohta",50,automatedSystem,displayBoard);

        int availability=myParkingLot.getAvailability();
        System.out.println(availability);

        Customer piyush = new Customer("Piyush","UP85 AX 5454");

        // Automated System Generating Ticket
        Ticket piyushTicket = myParkingLot.automatedSystem.generateTicket(piyush);

        // Printing Ticket Info
        System.out.println(piyushTicket);

        // Creating Customer
        Customer ayush = new Customer("Ayush","UP86 AB 9999");

        // Automated System Generating Ticket
        Ticket ayushTicket = myParkingLot.automatedSystem.generateTicket(ayush);

        // Printing Ticket Info
        System.out.println(ayushTicket);



    }
}
