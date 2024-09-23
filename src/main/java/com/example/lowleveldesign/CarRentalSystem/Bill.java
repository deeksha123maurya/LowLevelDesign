package com.example.lowleveldesign.CarRentalSystem;

public class Bill {
    Reservation reservation;
    double totalBill;
    boolean isBillPaid;

    public Bill(Reservation reservation) {
        this.reservation = reservation;
        isBillPaid=false;
        totalBill=computeBillAmount();
    }

    public double computeBillAmount()
    {
        return 2000.0;
    }
}
