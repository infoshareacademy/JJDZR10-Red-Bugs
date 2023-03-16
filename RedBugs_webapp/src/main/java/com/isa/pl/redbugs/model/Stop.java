package com.isa.pl.redbugs.model;

public class Stop {
    private long stopId;
    private String stopName;
    private Schedule schedule;

    public Stop(long stopId, String stopName) {
        this.stopId = stopId;
        this.stopName = stopName;
    }

    public Stop() {
    }

    public long getStopId() {
        return stopId;
    }

    public void setStopId(long stopId) {
        this.stopId = stopId;
    }

    public String getStopName() {
        return stopName;
    }

    public void setStopName(String stopName) {
        this.stopName = stopName;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    @Override
    public String toString() {
        return "Stop number: " + stopId +
                ", stopName: " + stopName ;
    }
}
