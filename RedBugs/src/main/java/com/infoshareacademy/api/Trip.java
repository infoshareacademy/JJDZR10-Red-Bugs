package com.infoshareacademy.api;

public class Trip {
    public String id;
    public int routeId;
    public int tripId;
    public String tripHeadsign;
    public String tripShortName;
    public int directionId;
    public String activationDate;
    public String type;

    public Trip() {
    }

    public Trip(String id, int routeId, int tripId, String tripHeadsign, String tripShortName, int directionId, String activationDate, String type) {
        this.id = id;
        this.routeId = routeId;
        this.tripId = tripId;
        this.tripHeadsign = tripHeadsign;
        this.tripShortName = tripShortName;
        this.directionId = directionId;
        this.activationDate = activationDate;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public int getTripId() {
        return tripId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public String getTripHeadsign() {
        return tripHeadsign;
    }

    public void setTripHeadsign(String tripHeadsign) {
        this.tripHeadsign = tripHeadsign;
    }

    public String getTripShortName() {
        return tripShortName;
    }

    public void setTripShortName(String tripShortName) {
        this.tripShortName = tripShortName;
    }

    public int getDirectionId() {
        return directionId;
    }

    public void setDirectionId(int directionId) {
        this.directionId = directionId;
    }

    public String getActivationDate() {
        return activationDate;
    }

    public void setActivationDate(String activationDate) {
        this.activationDate = activationDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "id='" + id + '\'' +
                ", routeId=" + routeId +
                ", tripId=" + tripId +
                ", tripHeadsign='" + tripHeadsign + '\'' +
                ", tripShortName='" + tripShortName + '\'' +
                ", directionId=" + directionId +
                ", activationDate='" + activationDate + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
