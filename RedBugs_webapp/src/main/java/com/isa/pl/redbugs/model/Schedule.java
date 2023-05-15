package com.isa.pl.redbugs.model;

public class Schedule {

    private Integer dateTime;
    private static String[] listOfStops;
    private static int chooseStop;
    private Vehicle vehicle;

    public Integer getDateTime() {
        return dateTime;
    }

    public void setDateTime(Integer dateTime) {
        this.dateTime = dateTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

}
