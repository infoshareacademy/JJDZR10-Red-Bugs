package com.infoshareacademy.api;

import java.util.List;

public class TripResponse {

    private String lastUpdate;

    private List<Trip> trips;

    public TripResponse(String lastUpdate, List<Trip> trips) {
        this.lastUpdate = lastUpdate;
        this.trips = trips;
    }

    public TripResponse() {
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }

    @Override
    public String toString() {
        return "Response{" +
                "lastUpdate=" + lastUpdate +
                ", trips=" + trips +
                '}';
    }
}
