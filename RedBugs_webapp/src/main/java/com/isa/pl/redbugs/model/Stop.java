package com.isa.pl.redbugs.model;

import java.util.Objects;

public class Stop {
    private String stopId;
    private String stopName;
    private Schedule schedule;
    private double latitude;
    private double longitude;

    public Stop(String stopId, String stopName, Schedule schedule, double latitude, double longitude) {
        this.stopId = stopId;
        this.stopName = stopName;
        this.schedule = schedule;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Stop() {
    }

    public String getStopId() {
        return stopId;
    }

    public void setStopId(String stopId) {
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

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stop stop = (Stop) o;

        if (Double.compare(stop.latitude, latitude) != 0) return false;
        if (Double.compare(stop.longitude, longitude) != 0) return false;
        if (!Objects.equals(stopId, stop.stopId)) return false;
        if (!Objects.equals(stopName, stop.stopName)) return false;
        return Objects.equals(schedule, stop.schedule);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = stopId != null ? stopId.hashCode() : 0;
        result = 31 * result + (stopName != null ? stopName.hashCode() : 0);
        result = 31 * result + (schedule != null ? schedule.hashCode() : 0);
        temp = Double.doubleToLongBits(latitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(longitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Stop{" +
                "stopId=" + stopId +
                ", stopName='" + stopName + '\'' +
                ", schedule=" + schedule +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
